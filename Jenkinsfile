pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        bat 'gradle build'
        bat 'gradle javadoc'
        bat 'echo \'he\''
      }
    }
    stage('Mail Notification') {
      steps {
        bat 'echo \'hi\''
      }
    }
    stage('Code Analysis') {
      parallel {
        stage('Code Analysis') {
          steps {
            withSonarQubeEnv 'sonarqube'
          }
        }
        stage('Test Reporting') {
          steps {
            bat 'echo \'test\''
            jacoco()
          }
        }
      }
    }
    stage('Deployment') {
      steps {
        bat 'gradle uploadArchives'
      }
    }
    stage('Slack Notification') {
      steps {
        bat 'echo \'hi\''
      }
    }
  }
}