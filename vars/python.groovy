def call() {
    node {
        stage('code quality'){
            echo 'code quality'
        }


        stage('Test cases'){
            echo 'Test cases'
        }

        stage('Publish release'){
            echo 'Publish release'
        }

    }
}

