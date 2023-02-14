pipeline {
   // agent { docker { image 'maven:3.8.7-eclipse-temurin-11' } }
   agent any
    stages {
        stage('maven version check') {
            steps {
             sh 'mvn --version'
            }
        }
        stage('maven clean install') {
            steps {
            sh 'mvn clean install'
            }
        }
    }
}