pipeline {
   // agent { docker { image 'maven:3.8.7-eclipse-temurin-11' } }
   agent any
    stages {
        stage('maven version check') {
            steps {
            withEnv(maven:'MAVEN_HOME') {
             bat 'mvn --version'
            }

            }
        }
        stage('maven clean install') {
            steps {
            withEnv(maven:'MAVEN_HOME') {
            bat 'mvn clean install'
            }
            }
        }
    }
}