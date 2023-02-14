pipeline {
   // agent { docker { image 'maven:3.8.7-eclipse-temurin-11' } }
   agent any
    stages {
        stage('maven version check') {
            steps {
            withMaven(maven : 'maven_3.9.0'){
             sh 'mvn --version'
            }
            }
        }
        stage('maven clean install') {
                steps {
                withMaven(maven : 'maven_3.9.0'){
                 sh 'mvn clean install'
                }
                }
            }
    }
}