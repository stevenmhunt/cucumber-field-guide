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
            } finally {
                def appName = 'simple search page'
                def fdir = language == 'java' ? './src/test/resources' : './features'
                sh """
                APP_VERSION=`git rev-parse --short=8 HEAD`
                ~/.dotnet/tools/pickles \
                    -f $fdir -o ./build/docs --df=word \
                    -l en --sn="$appName" --sv="\$APP_VERSION" \
                    --trfmt=cucumberjson --lr=./build/reports/results.json
                """
                archiveArtifacts artifacts: 'build/**/*', fingerprint: true
                junit 'build/reports/**/*.xml'
            }
        }

        stage('Deploy') {
            echo 'Deploying!'
        }

        stage('Promote') {
            echo 'Promote!'
        }
    }
}
