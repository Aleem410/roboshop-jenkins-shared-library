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
       sh "sonar-scanner -Dsonar.login=admin -Dsonar.password=Cisco@410 -Dsonar.host.url=http://3.231.31.130/:9000 -Dsonar.projectKey=${env.COMPONENT}"
    }
}

def release() {
    stage('Publish A release'){
        echo 'Publish A release'
    }
}
