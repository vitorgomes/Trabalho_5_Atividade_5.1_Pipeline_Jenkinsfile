pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Faz o checkout do repositório na branch main
                git branch: 'main', url: 'https://github.com/vitorgomes/Trabalho_5_Atividade_5.1_Pipeline_Jenkinsfile.git'
            }
        }
        stage('Build') {
            steps {
                // Executa o build usando Maven
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                // Executa os testes com JUnit
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            // Publica os resultados dos testes
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
