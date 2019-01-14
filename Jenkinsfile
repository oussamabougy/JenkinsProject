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
		        scannerHome = tool 'SonarQubeScanner'
		    }
		    steps {
		        withSonarQubeEnv('sonarqube') {
		            bat "${scannerHome}/sonar-scanner"
		        }
		        timeout(time: 10, unit: 'MINUTES') {
		            waitForQualityGate abortPipeline: true
		        }
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
        slackSend()
      }
    }
  }
}