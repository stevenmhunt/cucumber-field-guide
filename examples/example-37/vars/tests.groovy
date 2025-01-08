def executeCucumberTests(options) {
    def lang = options?.language
    switch (lang) {
        case 'ruby':
            return executeCucumberRubyTests(options)
        case 'java':
            return executeCucumberJVMTests(options)
        case 'javascript':
            return executeCucumberJSTests(options)
    }
    throw new IllegalArgumentException("Unsupported language: $lang")
}