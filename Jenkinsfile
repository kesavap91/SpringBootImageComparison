pipeline {
   // agent { docker { image 'maven:3.8.7-eclipse-temurin-11' } }
   agent any
    stages {
        stage('maven version check') {
            steps {
            git 'https://github.com/kesavap91/SpringBootImageComparison.git'
            withMaven(maven:'MAVEN_HOME') {
             bat 'mvn --version'
            }

            }
        }
        stage('maven clean install') {
            steps {
            bat 'mvn clean install'
            }
        }
    }
}