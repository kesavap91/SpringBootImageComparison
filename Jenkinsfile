pipeline {
   // agent { docker { image 'maven:3.8.7-eclipse-temurin-11' } }
   agent any
    stages {
        stage('maven version check') {
            steps {
            withMaven(maven:'MAVEN_HOME') {
             bat 'mvn --version'
            }

            }
        }
        stage('maven clean install') {
            steps {
            withMaven(maven:'MAVEN_HOME') {
            bat 'mvn clean install'
            }
            }
        }


                stage('s3 bucket') {
                    steps {
bat 'echo "s3 related steps"'
                    }
                    }

    }
}