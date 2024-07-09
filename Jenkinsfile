pipeline {
    agent any
    tools {
        maven 'Maven 3.9.8'
    }
    stages {
        stage('Build') {
            steps {
                git 'https://github.com/vitorgomes/Trabalho_5_Atividade_5.1_Pipeline_Jenkinsfile'
                echo 'Building...'
                sh 'vn clean package'
                echo 'uccess built...'
            }
            post {
                success {
                    echo 'running tests...'
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}