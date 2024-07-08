pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
		sh 'mvn clean install'
		}
	}

	stage('Test') {
            steps {
                script {
                    echo 'Running tests...'
                }
                sh 'mvn test'
            }
        }
    }
}
