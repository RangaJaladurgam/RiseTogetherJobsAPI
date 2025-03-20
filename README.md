# RiseTogetherJobsAPI

## Overview
RiseTogetherJobsAPI is a backend service for posting and managing IT job listings. It provides a REST API built with **Spring Boot** and **MySQL**, allowing admins to add, update, and delete job posts while enabling visitors to browse job opportunities without authentication.

## Features
- Admin authentication and authorization
- Create, update, and delete job postings
- View job listings without login
- Store job images as URLs in the database
- Built using **Spring Boot**, **React (frontend)**, and **MySQL**

## Tech Stack
- **Backend:** Spring Boot, Java, Spring Security
- **Frontend:** React (Separate repository)
- **Database:** MySQL
- **Authentication:** JWT-based Admin login
- **Deployment:** Render (or any cloud service)

## Installation & Setup
### Prerequisites
- Java 17+
- Maven
- MySQL Server

### Steps to Run Locally
1. **Clone the Repository**
   ```sh
   git clone https://github.com/RangaJaladurgam/RiseTogetherJobsAPI.git
   cd RiseTogetherJobsAPI
   ```

2. **Build & Run**
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

## API Endpoints
### Admin Operations (Requires Authentication)
- **Login Admin** → `POST /api/auth/login`
- **Add Job Post** → `POST /api/jobs`
- **Update Job Post** → `PUT /api/jobs/{id}`
- **Delete Job Post** → `DELETE /api/jobs/{id}`

### Public Endpoints
- **Get All Jobs** → `GET /api/jobs`
- **Get Job by ID** → `GET /api/jobs/{id}`

## Admin Authentication
- Admin users must authenticate using a JWT token.
- After logging in, pass the token in the request headers:
  ```sh
  Authorization: Bearer your_token_here
  ```

## Future Enhancements
- Add job categories & filters
- Improve UI with advanced search options
- Implement job expiry dates

## Contributing
Pull requests are welcome! Open an issue to discuss changes before submitting PRs.

## License
This project is open-source and available under the **MIT License**.

---
🚀 Developed by **Rangappa Naidu Jaladurgam**

