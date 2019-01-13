pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        bat 'gradle build'
        bat 'C:\\Gradle\\gradle-4.10.2\\bin\\gradle.bat javadoc'
      }
    }
  }
}