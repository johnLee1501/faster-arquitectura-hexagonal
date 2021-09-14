pipeline {
    //Donde se va a ejecutar el Pipeline
    agent {
        label 'Slave_Induccion'
    }
    //Opciones específicas de Pipeline dentro del Pipeline
    options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
 	    disableConcurrentBuilds()
    }

    //Una sección que define las herramientas “preinstaladas” en Jenkins
    tools {
        jdk 'JDK8_Centos' //Verisión preinstalada en la Configuración del Master
    }

    //Aquí comienzan los “items” del Pipeline
    stages{
        stage('Checkout') {
            steps{
            echo "------------>Checkout<------------"
            checkout([
                $class: 'GitSCM',
                branches: [[name: '*/master']],
                doGenerateSubmoduleConfigurations: false,
                extensions: [],
                gitTool: 'Default',
                submoduleCfg: [],
                userRemoteConfigs: [[
                credentialsId: 'GitHub_johnLee1501',
                url:'https://github.com/johnLee1501/faster-arquitectura-hexagonal.git'
                ]]
            ])

            }
        }

        stage('Compile & Unit Tests') {
            steps{
            echo "------------>Compile & Unit Tests<------------"
            sh 'chmod +x gradlew'
            sh './gradlew --b ./microservicio/build.gradle test'
            }
        }

        stage('Static Code Analysis') {
            steps{
            echo '------------>Análisis de código estático<------------'
            withSonarQubeEnv('Sonar') {
                sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
            }
            }
        }

        stage('Build') {
           steps {
            echo "------------>Build<------------"
            //Construir sin tarea test que se ejecutó previamente
            sh './gradlew --b ./microservicio/build.gradle clean'
            sh './gradlew --b ./microservicio/build.gradle build'
           }
        }

    }

    post {
        always {
          echo 'This will always run'
        }
        success {
          echo 'This will run only if successful'
          junit '**/test-results/test/*.xml' //RUTA DE TUS ARCHIVOS .XML
        }
        failure {
          echo 'This will run only if failed'
          mail (to: 'john.vega@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
        }
        unstable {
          echo 'This will run only if the run was marked as unstable'
        }
        changed {
          echo 'This will run only if the state of the Pipeline has changed'
          echo 'For example, if the Pipeline was previously failing but is now successful'
        }
    }
}