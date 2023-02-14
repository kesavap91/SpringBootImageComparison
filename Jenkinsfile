pipeline {
   // agent { docker { image 'maven:3.8.7-eclipse-temurin-11' } }
   agent any
    stages {
        stage('maven version check') {
            steps {
//             sh "ls -ltr"
//             sh "./mvnw --version"
            git 'https://github.com/kesavap91/SpringBootImageComparison.git'
            withMaven(){
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