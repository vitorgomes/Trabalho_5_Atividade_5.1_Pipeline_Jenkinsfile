pipeline {
    agent any
    tools {
        maven 'Maven 3.9.8'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/vitorgomes/Trabalho_5_Atividade_5.1_Pipeline_Jenkinsfile'
            }
        }
        stage('Build') {
            steps {
                echo 'Building...'
                sh 'mvn clean package'
                echo 'Build completed.'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'mvn test'
            }
        }
    }
    post {
        always {
            echo 'Pipeline completed.'
        }
        success {
            echo 'Tests completed successfully...'
            junit '**/target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
        failure {
            echo 'Build or tests failed...'
        }
    }
}
