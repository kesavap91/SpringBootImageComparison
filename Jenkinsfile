pipeline {
   // agent { docker { image 'maven:3.8.7-eclipse-temurin-11' } }
   agent any
    stages {
        stage('maven version check') {
            steps {
            git url: 'https://github.com/cyrille-leclerc/multi-module-maven-project'
            withMaven{
             sh 'mvn --version'
            }
            }
        }
        stage('maven clean install') {
            steps {
            git url: 'https://github.com/cyrille-leclerc/multi-module-maven-project'
            withMaven{
            sh 'mvn clean install'
            }
            }
        }
    }
}