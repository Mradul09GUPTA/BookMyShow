# 🎬 BookMyShow Clone – Movie Ticket Booking System  

Welcome to the **BookMyShow Clone**, a full-fledged **backend application** built using **Spring Boot**, **Java**, **MySQL**, and **Maven**.  
This project recreates the core logic of the popular *BookMyShow* platform — allowing users to **register, log in securely, browse movies, view shows, and book seats** — all while ensuring **data consistency**, **security**, and **concurrency control** at scale.  

---

## 🔧 Overview  

This system follows a **Layered Architecture** design pattern that cleanly separates application logic into distinct layers:  
- **Controller** → Handles REST API requests and responses.  
- **Service** → Contains core business logic.  
- **Repository** → Handles database interactions.  

It also includes **strong concurrency control** to prevent multiple users from booking the same seat and uses **BCrypt encryption** to securely store passwords.  

This project showcases key backend engineering concepts such as:
- RESTful API design  
- Transaction management  
- Data modeling and normalization  
- Secure authentication  
- Production-level architecture  

---

## ✨ Key Features  

### 👤 User Registration & Authentication  
- Register new users with encrypted passwords using **BCrypt**.  
- Secure login system with **Spring Security** and role-based access (USER / ADMIN).  

### 🎥 Movie & Show Management  
- Admins can add and manage movies, theatres, and shows.  
- Users can browse available movies and their scheduled showtimes.  

### 💺 Seat Booking System  
- Multiple users can book seats concurrently for the same show.  
- Prevents overbooking through **transactional isolation** and **optimistic locking**.  

### 💳 Payment Integration *(Simulated)*  
- Each booking record is linked to a payment entry.  
- Payment flow can be extended to integrate gateways like Razorpay or Stripe.  

### 🧩 Layered Architecture  
- Clean code organization with **Controller–Service–Repository** separation.  
- Uses DTOs for clean API data transfer (no entity exposure).  

### ✅ Validation & Exception Handling  
- Input validation via annotations (`@Valid`, `@NotBlank`, etc.).  
- Centralized error management using `@ControllerAdvice`.  

### 🗄️ Database Design  
- Well-structured **relational schema** modeled in **MySQL**, optimized for joins between users, shows, and bookings.  

---

## 🧱 Database Schema  

| Entity | Attributes |
|--------|-------------|
| **User** | id, name, email, password |
| **Movie** | id, title, duration, rating |
| **Theatre** | id, name, location |
| **Show** | id, movie_id, theatre_id, show_time |
| **Seat** | id, seat_no, theatre_id |
| **Booking** | id, user_id, show_id, seat_id, status |
| **Payment** | id, booking_id, amount, status |

### Relationships  
- 1️⃣ **Movie → Shows** (One-to-Many)  
- 2️⃣ **Theatre → Seats** (One-to-Many)  
- 3️⃣ **Show → Bookings** (One-to-Many)  
- 4️⃣ **Booking → Payment** (One-to-One)  

---

## ⚙️ Tech Stack  

| Layer | Technology |
|-------|-------------|
| **Language** | Java |
| **Framework** | Spring Boot |
| **Database** | MySQL |
| **ORM** | Spring Data JPA |
| **Build Tool** | Maven |
| **Security** | Spring Security + BCrypt |
| **API Docs** | Swagger / OpenAPI |
| **Version Control** | Git |

---

## ⚡ Concurrency Control  

The system guarantees that **no two users can book the same seat** for the same show.  

Implemented via:
- `@Transactional(isolation = Isolation.SERIALIZABLE)`  
- **Optimistic Locking** using `@Version` fields  
- **Database-level unique constraints** on seat and show combinations  

This ensures **thread-safe seat allocation** even under high booking traffic.  

---

## 🔐 Security  

- Passwords are stored using **BCrypt one-way hashing** with a unique salt.  
- Designed for **JWT token-based authentication** (extendable).  
- Implements **role-based authorization** for admin and user privileges.  

---

## 🌟 Highlights  

- 🚀 Built with **Spring Boot** and follows **microservice-ready structure**.  
- 🧠 Demonstrates advanced **transaction and concurrency handling**.  
- 🔐 Implements **secure user authentication and data validation**.  
- 💾 Uses **MySQL relational modeling** with clean entity relationships.  
- 🧱 Designed for **scalability and maintainability**, ready for future enhancements.  

---

## 🧠 Future Enhancements  

- Integrate **JWT authentication** for token-based security.  
- Connect **real payment gateways** (Razorpay / Stripe).  
- Add a **frontend UI** (React or Angular) for better user experience.  
- Containerize with **Docker** and deploy to **AWS**.  
- Add **caching** (Redis) for frequently accessed data like shows and movies.  

---

## 🏁 Summary  

The **BookMyShow Clone** project demonstrates a production-grade backend system with real-world challenges like **secure authentication**, **concurrent seat booking**, and **transaction management**.  
It reflects best practices in **Spring Boot development**, making it a perfect showcase project for **SDE or Backend Developer** roles.

---

⭐ *If you like this project, consider giving it a star on GitHub!*
