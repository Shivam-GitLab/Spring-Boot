# 📓 Journal App

A simple Journal Web Application built using **Java**, **Spring Boot**, **REST APIs**, and **MongoDB**.  
This app allows users to securely create, read, update, and delete (CRUD) journal entries.

## 🚀 Features

- ✍️ Add a new journal entry
- 🗂 View all journal entries
- 🔄 Update an existing entry
- ❌ Delete a journal entry
- 🔐 User authentication (basic)
- ✅ Input validation

## 🛠 Tech Stack

- **Backend**: Java, Spring Boot
- **Database**: MongoDB
- **API**: RESTful APIs
- **Build Tool**: Maven
- **Testing**: Postman / Swagger

## 📁 Project Structure

journal-app/
│
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com.journalapp/
│ │ │ ├── controller/
│ │ │ ├── model/
│ │ │ ├── repository/
│ │ │ ├── service/
│ │ │ └── JournalApp.java
│ │ └── resources/
│ │ ├── application.properties
│ │ └── static/
│
├── pom.xml
└── README.md

markdown
Copy
Edit

## 🔧 Setup Instructions

### Prerequisites

- Java 17+
- Maven
- MongoDB installed or running in the cloud (e.g., MongoDB Atlas)

### Run Locally

1. **Clone the repo**

```bash
git clone https://github.com/yourusername/journal-app.git
cd journal-app
