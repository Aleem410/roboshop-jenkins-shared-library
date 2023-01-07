def checkout() {
    stage('Checkout SCM') {
        cleanWs()
        git branch: 'main', url: "${env.REPO_URL}"
    }
}

def compile() {
    stage('compile code') {
        if (appType == "java") {
            sh 'mvn clean compile'
        }
        if (appType == "golang") {
            sh 'go mod init'
        }
    }
}

def codeQuality() {
    stage('code quality'){
        echo 'code quality'
    }
}

def release() {
    stage('Publish A release'){
        echo 'Publish A release'
    }
}
