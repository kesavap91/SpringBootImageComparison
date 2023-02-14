pipeline {
   // agent { docker { image 'maven:3.8.7-eclipse-temurin-11' } }
   agent any
    stages {
        stage('maven version check') {
            steps {
            withMaven(){
             sh 'mvn --version'
            }
            }
        }
        stage('maven clean install') {
            steps {
            withMaven(){
            sh 'mvn clean install'
            }
            }
        }
    }
}