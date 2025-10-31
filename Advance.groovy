pipeline {
    agent {
        label "slave-vm"
    }
    parameters {
        choice(
            name: 'TERRAFORM_ACTION',
            choices: ['apply', 'destroy'],
            description: 'Choose Terraform action: apply to create, destroy to remove infrastructure'
        )
    }
    stages {
        stage("Terraform Init") {
            steps {
                dir("/home/ansible/jenkins-usecases") {
                    sh "terraform init"
                }
            }
        }
        stage("Terraform Plan/Apply") {
            when {
                expression { params.TERRAFORM_ACTION == 'apply' }
            }
            steps {
                dir("/home/ansible/jenkins-usecases") {
                    sh "terraform plan"
                    sh "terraform apply --auto-approve"
                }
            }
        }
        stage("Terraform Destroy") {
            when {
                expression { params.TERRAFORM_ACTION == 'destroy' }
            }
            steps {
                dir("/home/ansible/jenkins-usecases") {
                    sh "terraform destroy --auto-approve"
                }
            }
        }
    }
}
