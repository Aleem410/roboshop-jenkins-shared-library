def call() {
   pipeline {
       agent any

//       options {
//           ansiColor('xterm')
//       }
       parameters {
           choice(name: 'ENVIRONMENT', choices: ['', 'dev', 'prod'], description: 'Pick ENVIRONMENT')
           choice(name: 'ACTION', choices: ['', 'apply', 'destroy'], description: 'Pick TERRAFORM ACTION')
       }
       stages {
          stage('terraform init') {
               steps {
                   sh '''
                   terraform init -backend-config=env/${ENVIRONMENT}-backend.tfvars
                   '''
                 }
             }
          stage('terraform plan') {
               steps {
                   sh '''
                   terraform plan -var-file=env/${ENVIRONMENT}.tfvars
                   '''
               }
           }
           stage('terraform Apply') {
               steps {
                   input {
                       message "Apply?"
                       ok "Yes"
                   }
                   sh '''
                   terraform apply -auto-approve -var-file=env/${ENVIRONMENT}.tfvars
                   '''
               }
           }
       }

   }
}

