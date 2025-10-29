pipeline {
  agent any
  environment {
    AWS_REGION = 'us-east-1'
    ECR = '123456789012.dkr.ecr.us-east-1.amazonaws.com/banking-microservice'
  }
  stages {
    stage('Build') { steps { sh 'mvn clean package -DskipTests' } }
    stage('Docker Build & Push') {
      steps {
        sh '''
        aws ecr get-login-password --region $AWS_REGION | docker login --username AWS --password-stdin 123456789012.dkr.ecr.$AWS_REGION.amazonaws.com
        docker build -t $ECR:$BUILD_NUMBER .
        docker push $ECR:$BUILD_NUMBER
        '''
      }
    }
  }
}
