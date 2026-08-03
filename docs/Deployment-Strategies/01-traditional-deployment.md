🚀 Phase 1 – Traditional Deployment
📖 Overview
This document describes the initial deployment architecture of SkillOrbit before introducing containerization and cloud-native deployment techniques.

In this phase, the application components run directly on the host machine:

React Frontend
Spring Boot Backend
H2 Database
This deployment model was used to validate the application's core functionality, authentication mechanisms, role management, skill analysis engine, and learning roadmap generation.

🎯 Objectives
The primary objectives of this deployment phase were:

✅ Develop the MVP

✅ Validate frontend-backend communication

✅ Implement JWT authentication

✅ Implement Role-Based Access Control (RBAC)

✅ Build the Skill Gap Analysis Engine

✅ Establish foundational architecture

🏗️ Traditional Architecture
+-------------------+
|     Browser       |
+---------+---------+
          |
          | HTTP
          v
+-------------------+
|   React Frontend  |
|  localhost:3000   |
+---------+---------+
          |
          | REST API Calls
          |
          v
+-------------------+
| Spring Boot APIs  |
| localhost:8080    |
+---------+---------+
          |
          | JPA
          |
          v
+-------------------+
|   H2 Database     |
|  In-Memory DB     |
+-------------------+
🌐 Network Flow
flowchart LR

U[User Browser]

F[React Frontend<br/>localhost:3000]

B[Spring Boot Backend<br/>localhost:8080]

D[(H2 Database)]

U --> F

F -->|REST API Calls| B

B -->|CRUD Operations| D

D --> B

B --> F

F --> U
🔄 Application Request Flow
sequenceDiagram

actor User

participant Frontend as React Frontend
participant Backend as Spring Boot API
participant DB as H2 Database

User->>Frontend: Login / Select Role
Frontend->>Backend: API Request
Backend->>DB: Fetch Data
DB-->>Backend: Response
Backend-->>Frontend: JSON Response
Frontend-->>User: Dashboard Update
🧩 Components
Frontend
Technology
React.js
JavaScript
HTML
CSS
Responsibilities
Login UI
Admin Dashboard
Skill Analysis Dashboard
User Interaction Layer
API Consumption
Backend
Technology
Spring Boot
Spring Security
JWT Authentication
Spring Data JPA
Responsibilities
Authentication
Role Management
Skill Management
Roadmap Generation
Gap Analysis Processing
Database
Technology
H2 In-Memory Database
Responsibilities
User Data Storage
Role Data Storage
Skills Repository
Roadmap Definitions
📦 Prerequisites
Backend
Java 17+
Maven 3.9+
Frontend
Node.js
npm
▶️ Backend Deployment
Navigate to backend folder:

cd user-service
Build application:

mvn clean install
Start application:

mvn spring-boot:run
Application URL:

http://localhost:8080
▶️ Frontend Deployment
Navigate to frontend:

cd skillorbit-ui
Install dependencies:

npm install
Start application:

npm start
Application URL:

http://localhost:3000
🔑 Authentication Flow
flowchart LR

U[User]

L[Login Page]

A[Authentication API]

J[JWT Token]

D[Dashboard]

U --> L

L --> A

A --> J

J --> D
📊 Skill Analysis Flow
flowchart TD

A[Select Target Role]

B[Load Required Skills]

C[Enter Skill Levels]

D[Submit Analysis]

E[Gap Calculation Engine]

F[Priority Assignment]

G[Roadmap Generation]

H[Analysis Result]

A --> B

B --> C

C --> D

D --> E

E --> F

F --> G

G --> H
⚠️ Challenges Encountered
API Communication
Challenge
Frontend and backend initially failed to communicate correctly due to API configuration issues.

Resolution
Standardized API endpoints
Corrected request paths
Improved response handling
Authentication
Challenge
JWT implementation required proper token propagation and authorization handling.

Resolution
Added JWT Filters
Implemented Security Configuration
Protected Admin APIs
Data Consistency
Challenge
Maintaining role-skill-roadmap relationships.

Resolution
Normalized data model
Introduced clear entity relationships
📚 Key Learnings
During this phase, the following concepts were mastered:

REST API Design
JWT Authentication
Spring Security
Role-Based Authorization
React State Management
JPA Entity Relationships
Full Stack Application Architecture
✅ Outcome
The traditional deployment phase successfully delivered:

Secure Authentication
Role-Based Access
Dynamic User Interface
Skill Gap Analysis
Learning Roadmap Generation
This phase established the foundation for future deployment strategies:

➡️ Traditional Deployment

➡️ Containerized Deployment

➡️ Cloud Deployment

➡️ Kubernetes Orchestration

🚀 Next Phase
Continue to:

📄 02-containerized-deployment.md

to learn how SkillOrbit evolved into a Dockerized multi-container application.
