# BookMyShow
🎬 BookMyShow Clone – Movie Ticket Booking System

This project is a backend application built using Spring Boot, Java, MySQL, and Maven, designed to replicate the core functionality of the popular BookMyShow platform. It enables users to register, log in securely, browse movies, view available shows, and book seats concurrently — all while maintaining data consistency and security at scale.

🔧 Overview

The system follows a Layered Architecture pattern, separating responsibilities into Controller, Service, and Repository layers. It includes strong concurrency control to prevent multiple users from booking the same seat, and uses BCrypt encryption for password security.

This project is ideal for demonstrating backend engineering skills such as RESTful API design, transaction management, data modeling, and secure authentication.

✨ Key Features

User Registration & Login

Users can register and authenticate using credentials stored securely with BCrypt password encryption.

Movie and Show Management

Admins can add and manage movies, shows, and theatres.

Users can view movies and available shows.

Seat Booking System

Multiple users can book seats simultaneously.

Concurrency is handled using Spring’s @Transactional isolation and optimistic locking to prevent overbooking.

Payment Integration (Simulated)

Each booking is associated with a payment record.

Layered Architecture

Clean code structure separating API, business logic, and database operations.

Validation & Exception Handling

Input validation using @Valid and @NotBlank.

Centralized exception handling via @ControllerAdvice.

Database Design

Relational schema modeled in MySQL, optimized for relationships between users, movies, shows, and bookings.

🧱 Database Schema

User → (id, name, email, password)

Movie → (id, title, duration, rating)

Theatre → (id, name, location)

Show → (id, movie_id, theatre_id, show_time)

Seat → (id, seat_no, theatre_id)

Booking → (id, user_id, show_id, seat_id, status)

Payment → (id, booking_id, amount, status)

Relationships:

One Movie → Many Shows

One Theatre → Many Seats

One Show → Many Bookings

One Booking → One Payment

⚙️ Tech Stack

Backend: Spring Boot, Java
Database: MySQL
ORM: Spring Data JPA
Build Tool: Maven
Security: Spring Security, BCrypt
Documentation: Swagger / OpenAPI
Version Control: Git

⚡ Concurrency Control

The system ensures that no two users can book the same seat for the same show.
This is achieved using:

Spring’s @Transactional annotation with Isolation.SERIALIZABLE level.

Optional Optimistic Locking using @Version fields in entities.

Database-level unique constraints on seat and show combinations.

🔐 Security

Passwords are encrypted using BCrypt before being stored in the database.

Optional JWT (JSON Web Token) support can be added for stateless authentication.

Role-based access control (e.g., ADMIN, USER).
