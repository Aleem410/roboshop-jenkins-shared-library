def call() {
node {
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


