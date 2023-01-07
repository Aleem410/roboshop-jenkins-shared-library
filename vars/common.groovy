def checkout() {
    stage('Checkout SCM') {
        cleanWs()
        git branch: 'main', url: "${env.REPO_URL}"
    }
}
