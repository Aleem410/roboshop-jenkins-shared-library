def call() {
    node {

        stage('Checkout SCM') {
            cleanWs()
            sh 'pwd'
            sh 'ls'
            git branch: 'main', url: "${env.REPO_URL}"
            sh 'pwd'
            sh 'ls'
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