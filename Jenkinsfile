pipeline {
   // agent { docker { image 'maven:3.8.7-eclipse-temurin-11' } }
   agent any
    stages {
        stage('build') {
            steps('maven version check') {
            withMaven(maven : 'maven_3.9.0'){
             sh 'mvn --version'
            }
            }
        }
            stage('build') {
                steps('maven clean install') {
                withMaven(maven : 'maven_3.9.0'){
                 sh 'mvn clean install'
                }
                }
            }
    }
}