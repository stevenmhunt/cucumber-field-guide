#!/bin/bash

BOOKFILE="./build/book.tex"

GIT_COMMIT=`git rev-parse HEAD`

mkdir -p ./build
echo "" > $BOOKFILE
for FILE in ./tex/packages/*; do
	cat $FILE >> $BOOKFILE
done
echo "\\begin{document}" >> $BOOKFILE

cat "./tex/titlepage.tex" >> $BOOKFILE
sed -e "s/\*\*GIT_COMMIT\*\*/${GIT_COMMIT}/g" "./tex/copyright.tex" >> $BOOKFILE
cat "./tex/dedication.tex" >> $BOOKFILE
cat "./tex/toc.tex" >> $BOOKFILE


count=0
for FILE in ./contents/*.md; do
    TMPFILE="./build/~$count.tmp"
    cp "$FILE" $TMPFILE

    # PRE-LATEX PROCESSING
    # process subheaders so that the special icons show up.
	
	# inline headers
    sed -i \
		-e 's/\*\*Key Terms:\*\*/\*\*\\bulb Key Terms:\*\*/g' \
		-e's/\*\*Anti-pattern:\*\*/\*\*\\danger Anti-pattern:\*\*/g' \
		-e's/\*\*Danger:\*\*/\*\*\\danger Danger:\*\*/g' \
    	-e 's/\*\*Pitfall:\*\*/\*\*\\warning Pitfall:\*\*/g' \
    	-e 's/\*\*Caution:\*\*/\*\*\\warning Caution:\*\*/g' \
    	-e 's/\*\*Pro Tip:\*\*/\*\*\\protip Pro Tip:\*\*/g' \
    	-e 's/\*\*Example:\*\*/\*\*\\example Example:\*\*/g' \
    	-e 's/\*\*Table:\*\*/\*\*\\tableicon Table:\*\*/g' \
    	-e 's/\*\*Java\*\*/\*\*\\java Java\*\*/g' \
    	-e 's/\*\*JavaScript\*\*/\*\*\\javascript JavaScript\*\*/g' \
    	-e 's/\*\*Ruby\*\*/\*\*\\ruby Ruby\*\*/g' \
    	-e 's/\*\*Groovy\*\*/\*\*\\groovy Groovy\*\*/g' \
    	-e 's/\*\*Difficulty:\*\* Easy/\*\*\Difficulty:\*\* \\greenstar \\whitestar \\whitestar Easy/g' \
    	-e 's/\*\*Difficulty:\*\* Medium/\*\*\Difficulty:\*\* \\orangestar \\orangestar \\whitestar Medium/g' \
    	-e 's/\*\*Difficulty:\*\* Expert/\*\*\Difficulty:\*\* \\redstar \\redstar \\redstar Expert/g' \
    	-e 's/\*\*Time:\*\*/\*\*\Time:\*\* \\clock/g' \
		$TMPFILE

	# automatically add italicized terms to the index
# 		-e 's/ \*\([^*]*\)\*\([ ,.\^\)]\)/ *\1*\\index{\1}\2/g' \
	sed -i \
		-e 's/{{\([^}]*\)}}/\1\\index{\L\1}/g' \
		-e 's/\\{/{/g' \
		-e 's/\\}/}/g' \
        $TMPFILE

    pandoc $TMPFILE -f markdown -t latex -o ./build/$count.tex

    # POST-LATEX PROCESSING

    # process figures so that they are sized correctly.
    sed -i \
		-e 's/\\begin{figure}/\\begin{figure}[H]/g' \
		-e 's/\\begin{Shaded}/\\medskip\n\\begin{Shaded}/g' \
	./build/$count.tex
	
	# Gherkin language support (instead of re-compiling pandoc...)
	sed -i -E 's/\\NormalTok\{(.*)"(.*)"/\\NormalTok\{\1\\StringTok\{"\2"\}/g' ./build/$count.tex
	sed -i \
		-e 's/\\NormalTok{Feature: /\\NormalTok{\\KeywordTok{Feature:} /g' \
		-e 's/\\NormalTok{Example: /\\NormalTok{\\KeywordTok{Example:} /g' \
		-e 's/\\NormalTok{Scenario: /\\NormalTok{\\KeywordTok{Scenario:} /g' \
		-e 's/\\NormalTok{Scenario Outline: /\\NormalTok{\\KeywordTok{Scenario Outline:} /g' \
		-e 's/\\NormalTok{    Example: /\\NormalTok{\\KeywordTok{    Example:} /g' \
		-e 's/\\NormalTok{    Scenario: /\\NormalTok{\\KeywordTok{    Scenario:} /g' \
		-e 's/\\NormalTok{    Scenario Outline: /\\NormalTok{\\KeywordTok{    Scenario Outline:} /g' \
		-e 's/\\NormalTok{  Rule: /\\NormalTok{\\KeywordTok{  Rule:} /g' \
		-e 's/\\NormalTok{Background:/\\NormalTok{\\KeywordTok{Background:} /g' \
		-e 's/\\NormalTok{    Background:/\\NormalTok{\\KeywordTok{    Background:} /g' \
		-e 's/\\NormalTok{Examples:/\\NormalTok{\\KeywordTok{Examples:}/g' \
		-e 's/\\NormalTok{    Given /\\NormalTok{    \\KeywordTok{Given} /g' \
		-e 's/\\NormalTok{    When /\\NormalTok{    \\KeywordTok{When} /g' \
		-e 's/\\NormalTok{    Then /\\NormalTok{    \\KeywordTok{Then} /g' \
		-e 's/\\NormalTok{    And /\\NormalTok{    \\KeywordTok{And} /g' \
		-e 's/\\NormalTok{    But /\\NormalTok{    \\KeywordTok{But} /g' \
		-e 's/\\NormalTok{      Given /\\NormalTok{      \\KeywordTok{Given} /g' \
		-e 's/\\NormalTok{      When /\\NormalTok{      \\KeywordTok{When} /g' \
		-e 's/\\NormalTok{      Then /\\NormalTok{      \\KeywordTok{Then} /g' \
		-e 's/\\NormalTok{      And /\\NormalTok{      \\KeywordTok{And} /g' \
		-e 's/\\NormalTok{      But /\\NormalTok{      \\KeywordTok{But} /g' \
		-e 's/\\NormalTok{@/\\AttributeTok{@/g' \
		-e 's/\\NormalTok{  @/\\AttributeTok{  @/g' \
		-e 's/\\NormalTok{    @/\\AttributeTok{    @/g' \
		-e 's/\\NormalTok{\\# /\\CommentTok{\\# /g' \
		-e 's/\\NormalTok{    \\# /\\CommentTok{    \\# /g' \
		-e 's/"\\StringTok{""}/\\StringTok{"""}/g' \
		-e 's/\\ImportTok{import}/\\KeywordTok{import}/g' \
		-e 's/\\ImportTok{export}/\\KeywordTok{export}/g' \
		./build/$count.tex

	# add pages to the final output.
    echo "\\include{${count}}" >> $BOOKFILE
    echo "\pagebreak" >> $BOOKFILE
    count=$((count+1))
done

echo "\\end{document}" >> $BOOKFILE
