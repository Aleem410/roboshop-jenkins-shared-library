import groovyjarjarantlr4.v4.codegen.model.Action

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

       stage('terraform init') {
//           addShortText background: '#FFFF00', borderColor: '#FFFF00', color: '', link: '', text: "Env : ${ENVIRONMENT} | Action : ${ACTION}"
           addShortText(text: "Env:${ ENVIRONMENT } | Action:${ Action }")

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

