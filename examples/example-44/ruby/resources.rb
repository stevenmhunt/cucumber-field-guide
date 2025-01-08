$resources ||= {}
def load_resource(name)
    return $resources[name] if $resources.key?(name)

    file_path = Dir.glob("./resources/#{name}.*").first
    return nil unless file_path

    extension = File.extname(file_path)
    content = if extension.downcase == '.txt'
                  File.read(file_path)
              else
                  File.binread(file_path).bytes
              end
    $resources[name] = content
end