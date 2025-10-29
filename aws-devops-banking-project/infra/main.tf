provider "aws" { region = "us-east-1" }

resource "aws_ecr_repository" "repo" {
  name = "banking-microservice"
}

output "ecr_url" { value = aws_ecr_repository.repo.repository_url }
