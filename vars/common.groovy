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
       sh 'sonar-scanner -D sonar.login=admin -D sonar.password=Cisco@410 -D sonar.host.url=http://http://3.231.31.130/:9000'
    }
}

def release() {
    stage('Publish A release'){
        echo 'Publish A release'
    }
}
