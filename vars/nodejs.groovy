def call() {
    node {

        stage('Checkout SCM') {
            cleanWs()
            git branch: 'main', url: "${env.REPO_URL}"
        }
        stage('code quality') {
            echo 'code quality'
        }

        stage('Test cases') {
            echo 'Test cases'
        }

        stage('Publish release') {
            echo 'Publish release'
        }

    }
}