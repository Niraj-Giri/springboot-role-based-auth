🔐 JWT-based User Management System (Spring Boot)

A User Management System built with Spring Boot, featuring:

🔑 JWT-based Authentication

🔒 BCrypt password hashing

👥 Role-based Authorization (RBAC)

⚡ RESTful API for user management

This project is designed as a boilerplate for building secure backends where user login, registration, and role-based API access are required.

📖 Table of Contents

Features

Architecture

Tech Stack

Project Structure

Setup & Installation

API Endpoints

Postman Testing

Future Improvements

License

🚀 Features

✅ User registration and login with BCrypt encrypted passwords
✅ JWT token generation & validation for stateless authentication
✅ Role-based access (ROLE_ADMIN, ROLE_USER)
✅ Secure REST endpoints with Spring Security
✅ Centralized exception handling
✅ Plug-and-play DB support (H2, MySQL, PostgreSQL)

🏗 Architecture
[ Client ]
     |
     |  Login/Register (username + password)
     v
[ Spring Boot App ]
   ├── BCrypt → Secure password storage
   ├── JWT Auth Filter → Validates token
   ├── Role-based Security → Restricts endpoints
     |
     v
[ Database (H2/MySQL/Postgres) ]
   └── Stores Users & Roles


Authentication Flow:

User registers → password hashed with BCrypt

User logs in → JWT issued

User accesses protected API → JWT validated → Role checked

🛠 Tech Stack

☕ Java 17+

🚀 Spring Boot 3+

🔐 Spring Security + JWT

🗄 Spring Data JPA (Hibernate)

🧂 BCrypt Password Encoder

🗃 Database: H2 (default), MySQL/PostgreSQL supported

📦 Maven

📂 Project Structure
src/main/java/com/example/usermanagement/
│── config/        # Security & JWT configuration
│── controller/    # REST API controllers
│── dto/           # Request/Response DTOs
│── model/         # Entities (User, Role)
│── repository/    # JPA repositories
│── security/      # JWT utils, filters
│── service/       # Business logic
└── UserManagementApplication.java

⚙️ Setup & Installation

1️⃣ Clone the repository

git clone https://github.com/your-username/springboot-jwt-user-management.git
cd springboot-jwt-user-management


2️⃣ Configure Database in application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/userdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update


3️⃣ Run the application

mvn spring-boot:run


4️⃣ H2 Console (if using H2 DB)

URL: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:testdb

📌 API Endpoints
🔓 Authentication
Method	Endpoint	Description
POST	/api/auth/register	Register new user
POST	/api/auth/login	Authenticate & get JWT
👤 User Management
Method	Endpoint	Description	Role Required
GET	/api/users	Get all users	ADMIN
GET	/api/users/{id}	Get user by ID	USER/ADMIN
PUT	/api/users/{id}	Update user	USER/ADMIN
DELETE	/api/users/{id}	Delete user	ADMIN
🧪 Testing with Postman

1️⃣ Register a user

POST /api/auth/register
Content-Type: application/json
{
  "username": "john_doe",
  "email": "john@example.com",
  "password": "securePassword"
}


2️⃣ Login

POST /api/auth/login
Content-Type: application/json
{
  "username": "john_doe",
  "password": "securePassword"
}


✅ Response:

{
  "token": "eyJhbGciOiJIUzI1NiIsInR..."
}


3️⃣ Use JWT Token in Header

Authorization: Bearer <your-token>


4️⃣ Call secured endpoints

GET /api/users → requires ROLE_ADMIN

GET /api/users/1 → requires ROLE_USER or ROLE_ADMIN

🔮 Future Improvements

🔄 Refresh tokens support

📧 Email verification on registration

🔗 OAuth2 login (Google, GitHub, etc.)

📝 User activity logging

📜 Swagger/OpenAPI documentation

📜 License

This project is licensed under the MIT License.
