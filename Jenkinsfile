pipeline {
   // agent { docker { image 'maven:3.8.7-eclipse-temurin-11' } }
   agent any
    stages {
    env.JAVA_HOME="${tool 'jdk1.8.0_111'}"
    env.PATH="${env.JAVA_HOME}/bin:${env.PATH}"
        stage('maven version check') {
            steps {
//             sh "ls -ltr"
//             sh "./mvnw --version"
            git 'https://github.com/kesavap91/SpringBootImageComparison.git'
            bat 'mvnw --version'
            bat 'mvnw.cmd --version'
            }
        }
        stage('maven clean install') {
            steps {
            bat 'mvn clean install'
            }
        }
    }
}