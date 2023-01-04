def call() {
node {

    stage('compile'){
        steps {
            echo 'compile'
        }
    }
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