# ⚡SkillOrbit

A full-stack **career intelligence platform** that helps users transition into new roles by analyzing their skill gaps and generating personalized learning roadmaps.

---

## 🔥 What This Application Does

This platform enables:

✅ Admins to define roles, skills, and learning paths  
✅ Users to select target roles and evaluate their skill levels  
✅ The system to analyze skill gaps and recommend learning paths  

---

## 🧠 Core Concept

ROLE → SKILLS → USER INPUT → GAP ANALYSIS → ROADMAP

---

## 🧩 Features

### 🔐 Authentication & Security
- JWT-based login system
- Role-based access control (ADMIN vs USER)
---

### ⚙️ Admin Panel
- Manage users
- Create/update/delete roles
- Define skills per role
- Build learning roadmap steps
- Fully UI-driven (no direct DB dependency ✅)

---

### 👤 User Dashboard
- Select target role dynamically
- Enter current skill levels
- Trigger skill gap analysis
- View:
  - Priority (High / Medium / Low)
  - Skill gaps
  - Free learning path
  - Premium learning path

---

### 📊 Skill Gap Analysis Engine
- Compares user input vs required skill levels
- Calculates gap and priority
- Maps roadmap steps based on skill gaps

---

## 🧱 Tech Stack

### Frontend
- React.js
- Modern UI components

### Backend
- Spring Boot
- REST APIs
- Spring Security (JWT-based)

### Database
- H2 (in-memory for development)

---

## 🏗️ Architecture

React UI
↓
Spring Boot APIs
↓
JWT Security Layer
↓
Business Logic (Analysis Engine)
↓
Database (Roles → Skills → Roadmap)

---

## 📸 Screenshots (Add Yours Here)

- ✅ Admin Panel
- ✅ Role Management
- ✅ Skill Management
- ✅ Roadmap Builder
- ✅ User Dashboard
- ✅ Analysis Results

---

## ▶️ How to Run

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

### Access (Local Environment)

Frontend: http://localhost:3000  
Backend: http://localhost:8080  
H2 DB: http://localhost:8080/h2-console  

---

### 🧪 Test Flow

1. Login as Admin  
2. Create roles  
3. Add skills to roles  
4. Define roadmap steps  
5. Login as user  
6. Select role  
7. Enter skill levels  
8. Click Analyze ✅  

---

## ✅ What Makes This Project Strong

✔ End-to-end full-stack implementation  
✔ Clean separation of concerns  
✔ Real-world system design  
✔ Secure API architecture  
✔ Dynamic data-driven UI  
✔ No manual DB dependency (admin-driven system ✅)  

---

## 🚀 Future Enhancements

- Progress tracking  
- Skill history graph  
- Personalized recommendations  
- CI/CD pipeline  
- Cloud deployment (AWS / Azure)  

---

## 💡 Author

**Sadiq Pasha Shaik**  
Cloud Applications Consultant  

---

## ⭐ Final Note

This project demonstrates a **production-like full-stack application** with real-world concepts including:

- ✅ Secure API design  
- ✅ Role-based access control  
- ✅ Data-driven UI architecture  
- ✅ Analytical backend logic (Skill Gap Engine)  

---

## 📁 Project Documentation

Additional details and logs are available in:

docs/

---

### 📌 Highlights

- Designed with real-world system architecture principles  
- No direct DB dependency (admin-driven UI ✅)  
- Built with scalability and maintainability in mind  
