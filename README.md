# ⚡ SkillOrbit

A full-stack **Career Intelligence Platform** that helps users transition into new roles by analyzing skill gaps and generating personalized learning roadmaps.

---

## 🚀 Overview

SkillOrbit enables professionals to:

- Identify skill gaps for a target role
- Evaluate current proficiency levels
- Generate personalized learning roadmaps
- Accelerate career transitions
- Follow structured learning paths

The platform also provides a comprehensive administrator experience for managing roles, skills, learning paths, and users through a fully UI-driven system.

---

## 📚 Table of Contents

- [🧠 Core Concept](#-core-concept)
- [✨ Features](#-features)
- [🧱 Technology Stack](#-technology-stack)
- [🏗️ Architecture](#️-architecture)
- [🚀 Deployment Evolution](#-deployment-evolution)
- [📖 Project Documentation](#-project-documentation)
- [📸 Application Screenshots](#-application-screenshots)
- [▶️ Local Development Setup](#️-local-development-setup)
- [🐳 Containerized Deployment](#-containerized-deployment)
- [🧪 Test Flow](#-test-flow)
- [📁 Repository Structure](#-repository-structure)
- [🌟 Project Highlights](#-project-highlights)
- [🔮 Future Enhancements](#-future-enhancements)
- [👨‍💻 Author](#-author)

---

## 🧠 Core Concept

```text
ROLE
  ↓
ROLE SKILLS
  ↓
USER ASSESSMENT
  ↓
SKILL GAP ANALYSIS
  ↓
PERSONALIZED LEARNING ROADMAP
```

---

## ✨ Features

### 🔐 Authentication & Security

- JWT Authentication
- Spring Security
- Role-Based Access Control (RBAC)
- Admin and User authorization separation

---

### ⚙️ Admin Panel

Administrators can:

- Manage users
- Create, update and delete roles
- Create, update and delete skills
- Configure learning roadmaps
- Manage application master data entirely through the UI

✅ Fully UI-driven administration

✅ No direct database manipulation required

---

### 👤 User Dashboard

Users can:

- Select target roles dynamically
- Load role-specific skill requirements
- Self-assess current proficiency
- Run skill gap analysis
- Receive personalized learning recommendations

---

### 📊 Skill Gap Analysis Engine

The Analysis Engine:

- Compares user skill levels against role requirements
- Calculates proficiency gaps
- Assigns learning priorities
- Generates learning recommendations
- Produces Free and Premium learning paths

---

## 🧱 Technology Stack

### Frontend

- React.js
- JavaScript
- HTML5
- CSS3

### Backend

- Spring Boot
- Spring Security
- JWT Authentication
- REST APIs

### Database

#### Traditional Deployment
- H2 Database

#### Containerized Deployment
- PostgreSQL

### DevOps & Cloud

- Docker
- Docker Compose
- GitHub
- Aws (In Progress)
- Kubernetes (Planned)

---

## 🏗️ Architecture

```text
+-----------------------+
|      React UI         |
+-----------+-----------+
            |
            v
+-----------------------+
| Spring Boot REST APIs |
+-----------+-----------+
            |
            v
+-----------------------+
| JWT Security Layer    |
+-----------+-----------+
            |
            v
+-----------------------+
| Skill Analysis Engine |
+-----------+-----------+
            |
            v
+-----------------------+
| Database Layer        |
+-----------------------+
```

---

## 🚀 Deployment Evolution

SkillOrbit demonstrates the evolution of modern application deployment practices, progressing from a traditional local setup to a fully orchestrated cloud-native architecture.

| Phase | Deployment Model | Documentation |
|---------|---------|---------|
| Phase 1 | Traditional Deployment | [01-traditional-deployment.md](docs/01-traditional-deployment.md) |
| Phase 2 | Containerized Deployment | [02-containerized-deployment.md](docs/02-containerized-deployment.md) |
| Phase 3 | Cloud Deployment | [03-cloud-deployment.md](docs/03-cloud-deployment.md) |
| Phase 4 | Orchestrated Cloud Deployment | [04-orchestrated-cloud-deployment.md](docs/04-orchestrated-cloud-deployment.md) |

---

### Phase 1 – Traditional Deployment

📄 Documentation: [01-traditional-deployment.md](docs/01-traditional-deployment.md)

Includes:

- React Development Server
- Spring Boot Application
- H2 Database
- Local Environment Setup
- Manual Application Startup

---

### Phase 2 – Containerized Deployment

📄 Documentation: [02-containerized-deployment.md](docs/02-containerized-deployment.md)

Includes:

- Frontend Docker Image
- Backend Docker Image
- PostgreSQL Container
- Docker Networking
- Docker Compose Orchestration
- Environment Variable Management

---

### Phase 3 – Cloud Deployment

📄 Documentation: [03-cloud-deployment.md](docs/03-cloud-deployment.md)

Includes:

- Aws Deployment Strategy
- Container Registry Integration
- Managed PostgreSQL Database
- Environment Configuration
- Cloud Networking

---

### Phase 4 – Orchestrated Cloud Deployment

📄 Documentation: [04-orchestrated-cloud-deployment.md](docs/04-orchestrated-cloud-deployment.md)

Includes:

- Kubernetes Deployments
- Services & Ingress
- ConfigMaps & Secrets
- Horizontal Pod Autoscaling
- Rolling Updates
- Self-Healing Architecture
- High Availability

---

## 📖 Project Documentation

### 📐 Architecture & Technical Documentation

| Document | Description |
|-----------|------------|
| [architecture.md](docs/architecture.md) | System architecture and design decisions |
| [api-docs.md](docs/api-docs.md) | API specifications and endpoint documentation |
| [setup-guide.md](docs/setup-guide.md) | Local development setup instructions |
| [sprint-plan.md](docs/sprint-plan.md) | Sprint planning, milestones and roadmap |

---

### 🐳 Containerization Documentation

|Document                | Description
|frontend-docker.md      | Docker file to build frontend image
|backend-docker.md       | Docker file to build backend image
|docker-compose.md       | Docker file to run both frontend, backend and DB (Containers in an isolated network)
|docker-commands.md      | Document defining all the docker commands used 
|container-networking.md | Document defining all the Network and Storage configurations made to link all the individual containers.

---

### 📝 Daily Engineering Journal

|Documents (daywise update files) | Walk through documents with all the development/troubleshooting happened day wise.

Additional details and logs are available in: 📁 docs/Daily Engineering Journal/

---

## 📸 Application Screenshots

### Authentication

- Login Screen
- Registration Screen

### Admin Module

- User Management
- Role Management
- Skill Management
- Roadmap Builder

### User Module

- Role Selection
- Skill Assessment
- Analysis Dashboard
- Learning Recommendations

> Screenshots will be added in future releases.

---

## ▶️ Local Development Setup

### Backend

```bash
cd user-service
./mvnw spring-boot:run
```

### Frontend

```bash
cd skillorbit-ui
npm install
npm start
```

---

## 🌐 Local Access URLs

| Component | URL |
|------------|-----|
| Frontend | http://localhost:3000 |
| Backend | http://localhost:8080 |
| H2 Console | http://localhost:8080/h2-console |

---

## 🐳 Containerized Deployment

Build and run all services:

```bash
docker compose up --build
```

### Access URLs

Frontend:

```text
http://localhost:3000
```

Backend:

```text
http://localhost:8080
```

PostgreSQL:

```text
localhost:5432
```

---

## 🧪 Test Flow

### Administrator Flow

1. Login as Admin
2. Create Roles
3. Add Skills
4. Configure Learning Paths
5. Manage Users

### User Flow

1. Login as User
2. Select Target Role
3. Load Required Skills
4. Enter Skill Levels
5. Run Analysis
6. Review Learning Recommendations

---

## 📁 Repository Structure

```text
skill-orbit
│
├── skillorbit-ui/ (Frontned)
│   ├── src/
│   ├── public/
│   ├── Dockerfile
│   └── .env, .env.docker
│
├── user-service/ (Backend)
│   ├── src/
│   ├── pom.xml
│   ├── Dockerfile
│   └── application.properties
│
├── docs/
│   │
│   ├── 📐 Architecture
│   │   └── architecture.md
│   │
│   ├── 📘 Technical Documentation
│   │   ├── api-docs.md
│   │   ├── setup-guide.md
│   │   └── sprint-plan.md
│   │
│   ├── 🚀 Deployment Strategies
│   │   ├── 01-traditional-deployment.md
│   │   ├── 02-containerized-deployment.md
│   │   ├── 03-cloud-deployment.md
│   │   └── 04-orchestrated-cloud-deployment.md
│   │
│   ├── 🐳 Containerization
│   │   ├── frontend-docker.md
│   │   ├── backend-docker.md
│   │   ├── docker-compose.md
│   │   ├── docker-commands.md
│   │   └── container-networking.md
│   │
│   └── 📝 Daily Engineering Journal
│       ├── day-1.md
│       ├── day-2.md
│       ├── ...
│       └── day-13.md
│
├── docker-compose.yml
├── .env
├── .env.docker
│
└── README.md
```

---

## 🌟 Project Highlights

✅ Full-stack application architecture

✅ JWT-based authentication

✅ Role-based access control

✅ RESTful API design

✅ Dynamic UI-driven administration

✅ Skill Gap Analysis Engine

✅ Personalized Learning Roadmaps

✅ Docker Containerization

✅ Environment-Based Configuration

✅ Scalable Cloud-Ready Architecture

✅ Daily Engineering Journal

✅ DevOps Learning Journey Documentation

---

## 🔮 Future Enhancements

### Application

- Progress Tracking
- User Skill History
- Recommendation Engine
- Dashboard Analytics
- Notifications

### DevOps & Cloud

- GitHub Actions CI/CD
- AWS/Azure/GCP Deployment
- Kubernetes Deployment
- Monitoring & Logging
- Security Scanning
- Auto Scaling

---

## 👨‍💻 Author

**Shaik Sadiq Pasha**
Cloud Applications Consultant · AWS Certified Solutions Architect – Associate

[LinkedIn](https://www.linkedin.com/in/shaik-sadiq-pasha/) · [sadiqpasha7474@gmail.com](mailto:sadiqpasha7474@gmail.com) · [GitHub](https://github.com/SshaikP)

---

## ⭐ Final Note

SkillOrbit demonstrates a production-style application architecture that combines:

- Secure API Development
- JWT Authentication
- Role-Based Authorization
- React Frontend Development
- Spring Boot Backend Services
- Database Design
- Containerization
- Cloud Deployment Practices
- Kubernetes Readiness
- DevOps Learning & Documentation

The project is designed as a practical showcase of modern Full-Stack, Cloud, and DevOps engineering principles.
