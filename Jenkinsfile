pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                echo "HELLO"
                which mvn
                echo "WORLD"


                echo 'Building...'
                sh 'mvn clean install'
		        echo 'success built'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'mvn test'
		        echo 'tests ok'
            }
        }
    }
}

