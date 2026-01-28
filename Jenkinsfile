pipeline {
    agent any
    tools {
        maven 'maven_3_9_12'
    }
    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/NipunaAluthdeniya/devops-automation']])
                bat 'mvn clean install'
            }
        }
        stage('Build docker image') {
            steps {
                script {
                    bat 'docker build -t nipunaaluthdeniya/devops-integration .'
                }
            }
        }
        stage('Push docker image') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'docker-creds', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USER')]) {
                        bat '''
                        echo %DOCKER_PASSWORD% | docker login -u %DOCKER_USER% --password-stdin
                        docker push nipunaaluthdeniya/devops-integration
                        '''
                    }
                }
            }
        }
    }
}