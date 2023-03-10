def checkout() {
    stage('Checkout SCM') {
        cleanWs()
        git branch: 'main', url: "${env.REPO_URL}"
    }
}

def compile(appType) {
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
//        sh "sonar-scanner -Dsonar.qualitygate.wait=true -Dsonar.login=admin -Dsonar.password=Cisco@410 -Dsonar.host.url=http:44.204.103.238:9000 -Dsonar.projectKey=${env.COMPONENT} ${SONAR_OPTS}"
        sh 'echo OK'
    }

}

def testCases(appType) {
    stage('Unit Tests') {
        if (appType == "java") {
            sh 'mvn test'
        }
        if (appType == "golang") {
            sh 'go mod init'
        }
        if (appType == "nodejs") {
            sh 'npm install'
        }
        if (appType == "python") {
            sh 'python3 -m unittest *.py'
        }
    }
}

def release() {
    stage('Publish A release'){
        echo 'Publish A release'
        sh 'env'
    }
}


