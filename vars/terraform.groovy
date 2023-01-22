def call() {
   node {
     properties([
       parameters([
           [$class: 'ChoiceParameterDefinition',
           choices: '\ndev\nprod\n',
           name: 'ENVIRONMENT',
           description: "choose Environment"
           ],
       ]),
       parameters([
           [$class: 'ChoiceParameterDefinition',
           choices: '\napply\ndestroy\n',
           name: 'ACTION',
           description: "choose Action"
           ],
       ]),
     ])
       stage('terraform init') {
           sh '''
              terraform init -backend-config=env/${ENVIRONMENT}-backend.tfvars
           '''
             }
          stage('terraform plan') {
           sh '''
              terraform plan -var-file=env/${ENVIRONMENT}.tfvars
           '''
           }
           stage('terraform Apply') {
           sh '''
              terraform apply -auto-approve -var-file=env/${ENVIRONMENT}.tfvars
           '''
           }

   }
}

