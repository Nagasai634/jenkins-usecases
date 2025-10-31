pipeline {
    agent any
    stages {
        stage("IAC") {
            steps {
                dir("/c/Users/konderu Nagasai/USESCASES/jenkins_usecases"){
                    sh "terraform init"
                    sh "terraform plan"
                    sh "terraform apply --auto-approve"
                }
            }
        }
    }
}
