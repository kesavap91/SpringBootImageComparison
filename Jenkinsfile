pipeline {
   // agent { docker { image 'maven:3.8.7-eclipse-temurin-11' } }
   agent any
    stages {
        stage('maven version check') {
            steps {
            git 'https://github.com/kesavap91/SpringBootImageComparison.git'
            sh 'mvn --version'
            }
        }
        stage('maven clean install') {
            steps {
            git 'https://github.com/kesavap91/SpringBootImageComparison.git'
            sh 'mvn clean install'
            }
        }
    }
}