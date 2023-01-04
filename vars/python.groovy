def call() {
    pipeline {
        agent any

        stages {

            stage('code quality'){
                steps {
                    echo 'code quality'
                }
            }

            stage('Test cases'){
                steps {
                    echo 'Test cases'
                }
            }

            stage('Publish release'){
                steps {
                    echo 'Publish release'
                }
            }
        }
    }
}
