# 🔐springboot-role-based-auth


[![Java](https://img.shields.io/badge/Java-24-orange)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.5-brightgreen)](https://spring.io/projects/spring-boot)
[![Spring Security](https://img.shields.io/badge/Spring%20Security-Enabled-green)](https://spring.io/projects/spring-security)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Ready-blue)](https://postgresql.org/)
[![H2](https://img.shields.io/badge/H2-Development-lightblue)](https://h2database.com/)
[![JWT](https://img.shields.io/badge/JWT-Authentication-yellow)](https://jwt.io/)
[![License](https://img.shields.io/badge/License-MIT-red.svg)](https://opensource.org/licenses/MIT)

A secure and lightweight User Management System built with **Spring Boot 3.5.5** and **JWT authentication**. Simple, clean, and production-ready! ✨

---

## 🚀 **Quick Start**

### **1. Clone & Run**
```bash
git clone https://github.com/niraj/usermanagement.git
cd usermanagement
./mvnw spring-boot:run
```

### **2. Test the API**
```bash
# Register a new user
curl -X POST http://localhost:8081/auth/register \
  -H "Content-Type: application/json" \
  -d '{"email":"john@example.com","password":"password123","role":"USER"}'

# Login and get JWT token
curl -X POST http://localhost:8081/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email":"john@example.com","password":"password123"}'
```

---

## ✨ **Features**

| Feature | Status | Description |
|---------|---------|-------------|
| 🔐 **JWT Authentication** | ✅ | Secure token-based authentication |
| 👤 **User Registration** | ✅ | Email-based user registration |
| 🔑 **Password Encryption** | ✅ | BCrypt password hashing |
| 🛡️ **Role-based Access** | ✅ | USER and ADMIN role support |
| 🗄️ **Multi-Database** | ✅ | H2 (dev) + PostgreSQL (prod) |
| ⚡ **CORS Support** | ✅ | Frontend integration ready |
| 🔧 **User Management** | ✅ | Update and delete operations |

---

## 🏗️ **Architecture**

```mermaid
graph TD
    A[Client] --> B[AuthController]
    A --> C[UserController]
    A --> D[ManageController]
    
    B --> E[UserService]
    C --> E
    D --> E
    
    E --> F[UserRepo]
    F --> G[PostgreSQL/H2]
    
    H[JwtAuthenticationFilter] --> I[JwtUtil]
    H --> J[CustomUserDetailsService]
    
    B --> I
    J --> F
```

---

## 🛠️ **Tech Stack**

| Layer | Technology |
|-------|------------|
| **Backend** | Spring Boot 3.5.5 |
| **Security** | Spring Security + JWT |
| **Database** | PostgreSQL (prod), H2 (dev) |
| **ORM** | Spring Data JPA |
| **Password** | BCrypt Encryption |
| **Build** | Maven 3+ |
| **Java** | Java 24 |

---

## 📁 **Project Structure**

```
src/main/java/com/niraj/usermanagement/
├── 🚀 UsermanagementApplication.java
├── 📁 config/
│   ├── SecurityConfig.java          # Security configuration
│   └── CrossConfig.java             # CORS configuration  
├── 📁 controller/
│   ├── AuthController.java          # Login endpoint
│   ├── UserController.java          # Registration
│   ├── Manage.java                  # Admin operations
│   └── Welcome.java                 # Protected routes
├── 📁 model/
│   └── Users.java                   # User entity
├── 📁 dto/
│   └── JwtRequest.java              # Login request DTO
├── 📁 security/
│   ├── JwtUtil.java                 # JWT token utilities
│   └── JwtAuthenticationFilter.java # JWT filter
├── 📁 service/
│   ├── UserService.java             # User operations
│   ├── CustomUserDetailsService.java
│   └── CustomUserDetails.java
└── 📁 repository/
    └── UserRepo.java                # JPA repository
```

---

## ⚙️ **Configuration**

### **Database Setup**

**Development (H2):**
```properties
# Automatically configured - no setup needed!
```

**Production (PostgreSQL):**
```properties
# application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/usermanagement
spring.datasource.username=postgres  
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### **JWT Configuration**
```java
// JwtUtil.java - Customize as needed
private final String SECRET = "your-secret-key-here";
private final long expiration_time = 1000 * 60 * 60; // 1 hour
```

---

## 🔗 **API Endpoints**

### **🔓 Public Endpoints**
| Method | Endpoint | Description | Example |
|--------|----------|-------------|---------|
| `POST` | `/auth/register` | Register new user | `{"email":"user@test.com","password":"pass123","role":"USER"}` |
| `POST` | `/auth/login` | User login | `{"email":"user@test.com","password":"pass123"}` |

### **🔒 Protected Endpoints**
| Method | Endpoint | Role | Description |
|--------|----------|------|-------------|
| `GET` | `/auth/user` | USER, ADMIN | Welcome message |
| `GET` | `/auth/admin` | ADMIN only | Admin dashboard |
| `PUT` | `/auth/update` | Authenticated | Update user |
| `DELETE` | `/auth/delete` | Authenticated | Delete user |

---

## 📋 **API Examples**

### **Register User**
```http
POST http://localhost:8081/auth/register
Content-Type: application/json

{
  "email": "john@example.com",
  "password": "securePassword123",
  "role": "USER"
}
```

**Response:**
```json
{
  "id": 1,
  "email": "john@example.com",
  "password": "$2a$10$encrypted_password",
  "role": "USER"
}
```

### **Login**
```http
POST http://localhost:8081/auth/login
Content-Type: application/json

{
  "email": "john@example.com", 
  "password": "securePassword123"
}
```

**Response:**
```json
"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huQGV4YW1wbGUuY29tIiwiaWF0IjoxNjM5..."
```

### **Access Protected Route**
```http
GET http://localhost:8081/auth/user
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2hu...
```

**Response:**
```json
"Welcome to home page"
```

---

## 🧪 **Testing with Postman**

### **Step-by-Step Testing:**

1. **📝 Register User**
   - Method: `POST`
   - URL: `http://localhost:8081/auth/register`
   - Body: `{"email":"test@example.com","password":"test123","role":"USER"}`

2. **🔑 Login & Get Token**
   - Method: `POST` 
   - URL: `http://localhost:8081/auth/login`
   - Body: `{"email":"test@example.com","password":"test123"}`
   - Copy the returned JWT token

3. **🛡️ Test Protected Route**
   - Method: `GET`
   - URL: `http://localhost:8081/auth/user`
   - Headers: `Authorization: Bearer YOUR_JWT_TOKEN`

4. **👨‍💼 Test Admin Route** (register admin user first)
   - Method: `GET`
   - URL: `http://localhost:8081/auth/admin`
   - Headers: `Authorization: Bearer ADMIN_JWT_TOKEN`

---

## 🔧 **Development**

### **Prerequisites**
- ☕ Java 24+
- 📦 Maven 3.6+
- 🐘 PostgreSQL (optional)

### **Running Locally**
```bash
# Clone repository
git clone https://github.com/niraj/usermanagement.git
cd usermanagement

# Run with Maven wrapper
./mvnw clean spring-boot:run

# Or with your local Maven
mvn clean spring-boot:run
```

### **Database Options**
```bash
# Development with H2 (no setup required)
./mvnw spring-boot:run

# Production with PostgreSQL
# 1. Install PostgreSQL
# 2. Create database: CREATE DATABASE usermanagement;
# 3. Update application.properties
# 4. Run: ./mvnw spring-boot:run
```

---

## 🔐 **Security Features**

- ✅ **JWT Token Authentication** - Stateless authentication
- ✅ **Password Encryption** - BCrypt hashing  
- ✅ **Role-based Authorization** - USER/ADMIN roles
- ✅ **CORS Configuration** - Frontend integration
- ✅ **Input Validation** - Request validation
- ✅ **Session Management** - Stateless sessions

---

## 🚀 **Deployment**

### **Build JAR**
```bash
./mvnw clean package
java -jar target/usermanagement-0.0.1-SNAPSHOT.jar
```

### **Docker (Future Enhancement)**
```dockerfile
FROM openjdk:24-jdk-slim
COPY target/usermanagement-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app.jar"]
```

---

## 🛣️ **Roadmap**

- [ ] 📧 **Email Verification** - Account activation
- [ ] 🔄 **Refresh Tokens** - Enhanced security
- [ ] 📊 **User Profiles** - Extended user info
- [ ] 🔍 **Search & Pagination** - User management
- [ ] 🐳 **Docker Support** - Containerization
- [ ] ☁️ **Cloud Deployment** - AWS/Azure ready
- [ ] 📈 **API Documentation** - Swagger integration
- [ ] ✅ **Unit Tests** - Comprehensive testing

---

## 🤝 **Contributing**

1. 🍴 Fork the repository
2. 🌿 Create your feature branch (`git checkout -b feature/amazing-feature`)
3. 💾 Commit your changes (`git commit -m 'Add amazing feature'`)
4. 📤 Push to the branch (`git push origin feature/amazing-feature`)
5. 🔄 Open a Pull Request

---

## 📞 **Support**

- 📧 **Email**: nirajgiri720@gmail.com


---

## 📄 **License**

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

<div align="center">

**⭐ Star this repository if you find it helpful!**

Made with ❤️ by [Niraj](https://github.com/niraj)

---

**Happy Coding! 🚀**

</div>
