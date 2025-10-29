# AWS DevOps Banking Project (Spring Boot + Jenkins + Terraform + EKS)
Region: us-east-1

End-to-end enterprise-style CI/CD setup:
- Spring Boot API deployed to AWS EKS
- Jenkins pipeline for CI/CD
- Terraform for infra (ECR, VPC, EKS)
- Docker, Kubernetes, and monitoring support

To run locally:
```
mvn clean package
docker build -t banking-service .
docker run -p 8080:8080 banking-service
curl http://localhost:8080/api/v1/customers
```
