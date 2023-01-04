def call() {
    pipeline {
        agent any

        stages {
            common()

            stage('Publish release'){
                steps {
                    echo 'Publish release'
                }
            }
        }
    }
}

