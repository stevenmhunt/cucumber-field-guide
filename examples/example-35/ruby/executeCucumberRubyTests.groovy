def executeCucumberRubyTests(options) {
    def tags = options?.tags
    def command = 'cucumber -p ci'
    if (tags != null && tags.length() > 0) { command += " -t \"$tags\"" }
    sh command
}