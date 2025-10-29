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


