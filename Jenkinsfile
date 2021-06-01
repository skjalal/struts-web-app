pipeline {
    agent any

    stages {
        stage('init') {
            steps {
                cleanWs()
            }
        }
       stage('checkout') {
           steps {
               git url: 'https://github.com/skjalal/struts-web-app.git'
               script{
                   env.GIT_COMMIT = sh(returnStdout: true, script: "git log -n 1 --pretty=format:'%h'").trim()
               }
               githubNotify account: 'skjalal', context: 'continuous-integration/jenkins', credentialsId: 'GIT', description: 'Build Initiated', sha: "${GIT_COMMIT}", repo: 'struts-web-app', status: 'PENDING'
               sh 'chmod +x /var/jenkins_home/workspace/struts-web-app/gradlew'
           }
       }
       stage('build') {
           steps {
               echo 'Build Gradle Project'
               sh '/var/jenkins_home/workspace/struts-web-app/gradlew clean build'
           }
       }
       stage('SonarQube analysis') {
            steps {
               withSonarQubeEnv('MySonarQube') {
                 sh '/var/jenkins_home/workspace/struts-web-app/gradlew sonarqube'
               }
            }
       }
       stage('Quality Gate') {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
                }
            }
       }
    }
    post {
        success {
            echo 'Build Succeeded'
            githubNotify account: 'skjalal', context: 'continuous-integration/jenkins', credentialsId: 'GIT', description: 'Build Completed with No Errors', sha: "${GIT_COMMIT}", repo: 'struts-web-app', status: 'SUCCESS'
        }
        failure {
            echo 'Build was Failed'
            githubNotify account: 'skjalal', context: 'continuous-integration/jenkins', credentialsId: 'GIT', description: 'Build Completed with Errors', sha: "${GIT_COMMIT}", repo: 'struts-web-app', status: 'FAILURE'
        }
        aborted {
            echo 'Build Cancelled'
            githubNotify account: 'skjalal', context: 'continuous-integration/jenkins', credentialsId: 'GIT', description: 'Build Completed with Errors', sha: "${GIT_COMMIT}", repo: 'struts-web-app', status: 'FAILURE'
        }
        unstable {
            echo 'Build got Unstable'
            githubNotify account: 'skjalal', context: 'continuous-integration/jenkins', credentialsId: 'GIT', description: 'Build Completed with Errors', sha: "${GIT_COMMIT}", repo: 'struts-web-app', status: 'FAILURE'
        }
    }
 }