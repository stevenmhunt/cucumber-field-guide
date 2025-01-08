def executeCucumberJVMTests(options) {
    def tags = options?.tags
    def command = 'mvn test -Pprofile-ci'
    if (tags != null && tags.length() > 0) {
        command += " -Dcucumber.filter.tags=\"$tags\""
    }
    sh """
    M2_HOME='/opt/apache-maven-3.9.6'
    PATH="\$M2_HOME/bin:\$PATH"
    $command
    """
}