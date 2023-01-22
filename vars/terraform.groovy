def call() {
   node {

       properties([
               parameters([
                       [$class     : 'ChoiceParameterDefinition',
                        choices    : '\ndev\nprod\n',
                        name       : 'ENVIRONMENT',
                        description: "Choose Environment"
                       ],
                       [$class     : 'ChoiceParameterDefinition',
                        choices    : '\napply\ndestroy\n',
                        name       : 'ACTION',
                        description: "Choose Action"
                       ],
               ]),
       ])

       common.checkout()

       if ( ! ENVIRONMENT ) {
         env.ENVIRONMENT = "${ENVIRONMENT_DEFAULT}"
       }
       if ( ! ACTION ) {
           env.ACTION = "${ACTION_DEFAULT}"
       }
       stage('terraform init') {
//           addShortText background: '#FFFF00', borderColor: '#FFFF00', color: '', link: '', text: "Env : ${ENVIRONMENT} | Action : ${ACTION}"
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

