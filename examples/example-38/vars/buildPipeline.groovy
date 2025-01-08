def call(options) {
    def language = options?.language

    node {
        stage('Checkout') {
            checkout scm
        }

        stage('Build') {
            echo "Build your $language application..."
        }

        stage('Test') {
            try {
                tests.executeCucumberTests([
                    language: language
                ])
            } finally { junit 'build/reports/**/*.xml' }
        }

        stage('Deploy') {
            echo 'Deploying!'
        }

        stage('Promote') {
            echo 'Promote!'
        }
    }
}
