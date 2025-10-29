# AWS DevOps Banking Project  
Spring Boot | Jenkins | Terraform | Docker | Kubernetes | AWS EKS | Monitoring

---

## Project Overview

This project demonstrates a **real-time enterprise-level DevOps pipeline** for a banking microservice built with **Spring Boot (Java 17)**.  
It automates the full **CI/CD lifecycle** — from code commit to deployment on **AWS EKS**, using **Jenkins**, **Terraform**, and **AWS native services**.

The goal is to mimic a real-world cloud migration and automation scenario, ensuring **zero manual deployment**, **high availability**, and **continuous monitoring**.

---

## Architecture Diagram

      ┌────────────────────────┐
      │   Developer Commit     │
      │   (GitHub Repo)        │
      └──────────┬─────────────┘
                 │ Webhook
                 ▼
      ┌────────────────────────┐
      │ Jenkins CI/CD Pipeline │
      │  • Build & Unit Test   │
      │  • Dockerize App       │
      │  • Push to ECR         │
      │  • Deploy to EKS       │
      └──────────┬─────────────┘
                 │
                 ▼
      ┌────────────────────────┐
      │ AWS ECR (Image Repo)   │
      └──────────┬─────────────┘
                 │
                 ▼
      ┌────────────────────────┐
      │ AWS EKS (Kubernetes)   │
      │  • Pods & Services     │
      │  • HPA Autoscaling     │
      └──────────┬─────────────┘
                 │
                 ▼
      ┌────────────────────────┐
      │ CloudWatch / Grafana   │
      │ Monitoring & Metrics   │
      └────────────────────────┘


---

## AWS Services Used

| Category | Services |
|-----------|-----------|
| **Compute & Orchestration** | EKS (Kubernetes), EC2 |
| **Container Registry** | ECR |
| **Infrastructure as Code** | Terraform |
| **Monitoring & Logging** | CloudWatch, Prometheus, Grafana |
| **Security & IAM** | IAM Roles, Secrets Manager |
| **Storage & DB** | S3, RDS (PostgreSQL) |

---

## Tech Stack

| Layer | Technologies |
|-------|---------------|
| **Application** | Java 17, Spring Boot 3.x |
| **Build Tools** | Maven |
| **CI/CD** | Jenkins Pipeline (Groovy), Git |
| **Containerization** | Docker |
| **Infrastructure** | Terraform |
| **Orchestration** | Kubernetes (EKS) |
| **Scripting** | Bash, Python |
| **Monitoring** | Prometheus, Grafana, CloudWatch |

---

## Application Overview

**API:** `/api/v1/customers`

| Method | Endpoint | Description |
|---------|-----------|-------------|
| GET | `/api/v1/customers` | Returns list of customers |
| POST | `/api/v1/customers` | Adds a new customer |

### Run Locally
```bash
mvn clean package
docker build -t banking-service .
docker run -p 8080:8080 banking-service
curl http://localhost:8080/api/v1/customers


CI/CD Pipeline Flow (Jenkins)

Checkout Code: Pulls source from GitHub repo

Build Stage: Compiles Spring Boot app using Maven

Docker Build: Builds Docker image for the microservice

Push to ECR: Pushes image to AWS Elastic Container Registry

Deploy to EKS: Updates Kubernetes deployment and rolls out new pods

Verification: Performs health checks via /actuator/health

Monitoring: Metrics exposed to Prometheus → Grafana dashboards

Terraform (Infrastructure as Code)

The infra/ folder contains Terraform configuration that provisions:

VPC, Subnets, Security Groups

EKS Cluster with Node Groups

RDS PostgreSQL

AWS ECR Repository

Commands to execute:

cd infra
terraform init
terraform apply -auto-approve

Kubernetes Deployment

The k8s/ folder contains manifests for:

Deployment → banking-service pods

Service → internal/external access

Namespace → devops-demo

HPA (Horizontal Pod Autoscaler) → scales pods automatically

Deploy manually:

kubectl apply -f k8s/
kubectl get pods -n devops-demo

Monitoring Setup

Prometheus collects app metrics (/actuator/prometheus)

Grafana visualizes service health and latency

CloudWatch monitors infrastructure and Lambda logs

Helm installation commands:

helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
helm repo add grafana https://grafana.github.io/helm-charts
helm repo update
helm install prom prometheus-community/prometheus -n monitoring
helm install graf grafana/grafana -n monitoring --set adminPassword=admin

Security & Best Practices

Least privilege IAM roles for Jenkins & EKS

Encrypted secrets via AWS Secrets Manager

HTTPS ingress with SSL termination (optional)

S3 bucket versioning & lifecycle policies

Infrastructure locked in Terraform state backend (S3 + KMS)

Repository Structure
aws-devops-banking-project/
│
├── src/                         # Spring Boot source code
├── Dockerfile                   # Docker build configuration
├── Jenkinsfile                  # Jenkins CI/CD pipeline script
├── infra/                       # Terraform IaC
├── k8s/                         # Kubernetes manifests
├── scripts/                     # Bash/Python automation scripts
├── pom.xml                      # Maven project descriptor
└── README.md                    # Project documentation

Author

Abdul Afroz
Senior Java & DevOps Engineer
LinkedIn | GitHub
