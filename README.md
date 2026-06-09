# 🚖 Taxi Booking System

> A scalable, enterprise-style full-stack Taxi Booking platform built using Spring Boot and MVC architecture, designed to manage taxi reservations, user operations, and administrative workflows efficiently.

---

## 📌 Project Overview

The **Taxi Booking System** is a full-stack web application developed using **Spring Boot 3.3.0, Java 17, Hibernate/JPA, MySQL, Thymeleaf, and Jakarta API**.

The system provides a complete taxi booking workflow with secure admin authentication, booking management, file uploading, contact handling, and service management. The application follows a clean **MVC architecture** with layered backend design for scalability and maintainability.

---

## 🏠 Application Preview

![Taxi Booking Home Page](<img width="1895" height="1017" alt="Home" src="https://github.com/user-attachments/assets/38bf6d13-0154-4fa7-9025-3631d7481c72" />
)

---

## 🏗️ System Architecture

* MVC (Model–View–Controller) Pattern
* Layered Architecture:

  * Controller Layer
  * Service Layer
  * Repository Layer
* Server-side rendering using Thymeleaf
* Session-based authentication
* MySQL relational database integration

---

## ⚙️ Tech Stack

### Backend

* Spring Boot 3.3.0
* Java 17
* Hibernate / JPA
* Jakarta API

### Frontend

* Thymeleaf
* HTML
* CSS

### Database

* MySQL

### Tools & Utilities

* Maven
* Lombok
* Apache Tomcat
* Spring Tool Suite (STS)

---

## 🔐 Core Features

### 👨‍💼 Admin Panel

* Secure Admin Login / Logout
* Dashboard for managing users, cars, and bookings
* Administrative control over application workflows

### 🚕 Car Booking System

* Users can book available taxis
* Booking workflow integrated with MySQL database
* Dynamic booking management

### 📁 File Upload Module

* Upload profile and booking-related files
* Spring Boot-based file handling

### 📞 Contact Module

* User inquiry form
* Admin-side message management

### 📄 Informational Modules

* About Page
* Services Page

---

## 🔑 Key Functionalities

* Full CRUD Operations
* Session Management
* Secure Authentication Flow
* Database-Driven Architecture
* MVC-Based Layered Design
* File Upload Integration
* Form Validation & Request Handling

---

## 🌐 Application Access

| Module              | URL                               |
| ------------------- | --------------------------------- |
| 🏠 Main Application | http://localhost:8080             |
| 🔐 Admin Panel      | http://localhost:8080/admin/login |

---

## 📸 Application Screenshots

### 🔐 Admin Login Page

![Admin Login](screenshots/admin-login.png)

### 📊 Admin Dashboard

![Admin Dashboard](screenshots/admin-dashboard.png)

### 🚕 Car Booking Page

![Booking Page](screenshots/booking.png)

### 📁 File Upload Module

![File Upload](screenshots/file-upload.png)

### 📞 Contact Page

![Contact Page](screenshots/contact.png)

---

## 📂 Screenshot Folder Structure

```bash id="folder01"
project-root/
│
├── screenshots/
│   ├── home.png
│   ├── admin-login.png
│   ├── admin-dashboard.png
│   ├── booking.png
│   ├── file-upload.png
│   └── contact.png
```

---

## 🚀 How to Run Locally

### 1. Clone Repository

```bash id="clone01"
git clone https://github.com/your-username/taxi-booking-system.git
```

### 2. Configure Database

Update `application.properties`

```properties id="dbconfig01"
spring.datasource.url=jdbc:mysql://localhost:3306/taxi_db
spring.datasource.username=root
spring.datasource.password=your_password
```

### 3. Run the Application

Execute:

```bash id="runapp01"
TaxiBookingSystemApplication.java
```

### 4. Access the Application

```bash id="access01"
http://localhost:8080
```

---

## 📈 Engineering Highlights

* Real-world taxi booking workflow implementation
* Secure admin authentication system
* End-to-end CRUD architecture
* File upload integration
* Scalable Spring Boot backend design
* Clean MVC architecture implementation
* Production-style layered project structure

---

## 🎯 Skills Demonstrated

* Full-Stack Web Application Development
* Spring Boot Backend Engineering
* Hibernate & JPA Integration
* MySQL Database Management
* Authentication & Session Handling
* MVC Architecture Implementation
* Form Validation & File Handling

---

## 📦 Project Structure

```bash id="projectstructure01"
src/main/java
 ├── controller
 ├── service
 ├── repository
 ├── model
 └── config

src/main/resources
 ├── templates
 │    ├── admin
 │    └── user
 ├── static
 └── application.properties
```

---

## 👨‍💻 Developer

**Saurav Kumar**
Java | Spring Boot | Backend Developer

---

## ⭐ Project Status

✔ Completed
✔ Fully Functional
✔ Portfolio Ready
✔ Recruiter Friendly

---

## 📜 License

This project is developed for learning and educational purposes.
