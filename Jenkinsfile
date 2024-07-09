pipeline {
    agent any
    tools{
        maven "M3"
    }

    stages {
        stage('Build') {
            steps {
                git 'https://github.com/vitorgomes/Trabalho_5_Atividade_5.1_Pipeline_Jenkinsfile'
                echo 'Building...'
                sh 'mvn clean package'
		        echo 'success built...'
            }
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