def executeCucumberJSTests(options) {
    def tags = options?.tags
    def command = 'npm run ci-test'
    if (tags != null && tags.length() > 0) { command += " -t \"$tags\"" }
    sh command
}