pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        bat 'gradle build'
        bat 'gradle javadoc'
        bat 'echo \'he\''
        archiveArtifacts 'build/libs/*jar'
      }
    }
    stage('Mail Notification') {
      steps {
        bat 'echo \'hi\''
      }
    }
    stage('Code Analysis') {
      parallel {
        stage('Sonarqube') {
          environment {
            scannerHome = 'SonarQubeScanner'
          }
          steps {
            withSonarQubeEnv('sonarqube') {
              bat "${scannerHome}/sonar-scanner"
            }

            timeout(time: 10, unit: 'MINUTES') {
              waitForQualityGate true
            }

          }
        }
        stage('Test Reporting') {
          steps {
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
        slackSend(baseUrl: 'https://gradlesil.slack.com/services/hooks/jenkins-ci/', channel: '#jenkins')
      }
    }
  }
}