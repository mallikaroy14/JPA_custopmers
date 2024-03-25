pipeline {
    agent any

    stages {

         stage('Git Pull') {
            steps {
                script {
                    git branch: 'main', url: 'https://github.com/mallikaroy14/JPA_custopmers'
                }
            }
        }

        stage('create jar file') {
            steps {
                script {
                    sh 'mvn clean install -DskipTests'
                }
            }
        }

        stage('Docker Compose') {
            steps {
                script {
                    sh 'docker compose up --build'
                }
            }
        }
    }
}
