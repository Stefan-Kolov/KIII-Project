# Boat Rental Application

A full-stack boat rental application deployed using Kubernetes with Dockerized backend and frontend services.

---

## Project Overview

This project demonstrates a microservices architecture with a React frontend, Spring Boot backend, and PostgreSQL database, all containerized with Docker and orchestrated via Kubernetes. The app is designed to manage boat rentals, including boats, reservations, and users.

---

## Features

- **Frontend:** React app served via Nginx
- **Backend:** Spring Boot REST API
- **Database:** PostgreSQL with persistent storage
- **Orchestration:** Kubernetes (Deployments, Services, StatefulSet, Ingress)
- **CI/CD:** GitHub Actions pipeline to build and push Docker images to Docker Hub
- **Networking:** Ingress controller for routing frontend and backend requests under a single domain

---

## Technologies

- Kubernetes (k3d for local cluster)
- Docker & Docker Hub
- React
- Spring Boot
- PostgreSQL
- GitHub Actions
- NGINX Ingress Controller

---

## Getting Started

### Prerequisites

- Docker
- k3d (Kubernetes local cluster)
- kubectl
- GitHub account with Docker Hub secrets set up for CI/CD
