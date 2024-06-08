#!/bin/bash

# Directory where Markdown files are located
MD_DIR="./contents"  # Update this path to your actual Markdown files directory

# Base directory to store extracted code snippets
BUILD_DIR="./build/lint"

# Language to file extension mapping
declare -A lang_ext=(
    ["gherkin"]="feature"
    ["ruby"]="rb"
    ["java"]="java"
    ["javascript"]="js"
    ["xml"]="xml"
    ["json"]="json"
    ["bash"]="sh"
    ["groovy"]="groovy"
    ["yaml"]="yaml"
    ["properties"]="properties"
    ["typescript"]="ts"
)

# Ensure the build directory exists
rm -rf "$BUILD_DIR" && mkdir -p "$BUILD_DIR"

# Function to extract and save code snippets
extract_and_save() {
    local lang="$1"
    local content="$2"
    local ext="${lang_ext[$lang]}"
    local target_dir="$BUILD_DIR/$lang"
    local counter=1

    # Ensure the target directory exists
    mkdir -p "$target_dir"

    # Determine the next file number
    while [[ -f "$target_dir/ex${counter}.$ext" ]]; do
        ((counter++))
    done

    local target_file="$target_dir/ex${counter}.$ext"

    # Save the content to the target file
    if [[ "$lang" == "xml" ]] && [[ "$content" != "<?xml"* ]]; then
        echo "<document>" > "$target_file"
        echo -n "$content" >> "$target_file"
        echo -n "</document>" >> "$target_file"
    else
        echo -n "$content" > "$target_file"
    fi
}

# Process each Markdown file
find "$MD_DIR" -name "*.md" | while read -r md_file; do
    echo "Processing $md_file..."

    # Reset variables for each file
    unset lang
    unset block_content
    inside_block=false

    # Read file line by line
    while IFS= read -r line || [[ -n "$line" ]]; do
        if [[ "$line" =~ ^\`\`\` ]]; then
            if [[ "$inside_block" = true ]]; then
                # End of block, process the content
                extract_and_save "$lang" "$block_content"
                unset block_content
                inside_block=false
            else
                # Start of a new block
                lang=$(echo "$line" | sed 's/```//')
                inside_block=true
                block_content=""
            fi
        elif [[ "$inside_block" = true ]]; then
            block_content+="$line"$'\n'
        fi
    done < "$md_file"

    # Check for unclosed block
    if [[ -n "$block_content" ]]; then
        echo "Warning: Unclosed code block detected in $md_file"
    fi
done

echo "Extraction complete."
