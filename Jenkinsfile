pipeline {
    agent {
        label "slave-vm"
    }
    stages {
        stage("IAC") {
            steps {
                dir("/home/ansible/jenkins-usecases"){
                    sh "terraform init"
                    sh "terraform plan"
                    sh "terraform apply --auto-approve"
                    
                }
            }
        }
    }
}
