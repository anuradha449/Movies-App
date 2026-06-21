
# 🎬 Movies App

A full-stack web application for browsing, adding, and managing movies. Built with **Spring Boot** for the backend and **React + Vite** for the frontend.

---

## 📂 Project Structure

```
Movies App/
├── backend/               # Spring Boot Backend (Port 8080)
│   └── movies-app/        # Main Java project folder
└── frontend/              # React + Vite Frontend (Port 5173)
    └── Firstproject/      # React source code
```

---

## ✨ Features

- 🎥 **Browse Movies** – View a list of all available movies.
- ➕ **Add New Movies** – Submit new movie entries (title, genre, rating, etc.).
- 🔍 **Search & Filter** – Find movies by title or genre.
- 🗑️ **Delete Movies** – Remove movies from the database.
- 📱 **Responsive UI** – Works beautifully on desktop and mobile devices.

---

## 🛠️ How to Run This Project

### 1. Clone the Repository

```bash
git clone https://github.com/anuradha449/Movies-App.git
cd Movies-App
```

---

### 2. Run the Backend (Spring Boot)

**Prerequisites:** Java 17+ and Maven installed.

```bash
cd backend/movies-app
mvn clean install
mvn spring-boot:run
```

> ✅ The backend will run at: **`http://localhost:8080`**

---

### 3. Run the Frontend (React + Vite)

**Prerequisites:** Node.js and npm installed.

Open a **new** terminal window and run:

```bash
cd frontend/Firstproject
npm install
npm run dev
```

> ✅ The frontend will run at: **`http://localhost:5173`**

---

### 4. Open the App

Open your web browser and go to:

> **`http://localhost:5173`**

You will see the Movies App home page.

---

## 🔑 API Endpoints (Backend)

| Method | Endpoint          | Description             |
|--------|-------------------|-------------------------|
| GET    | `/api/movies`     | Get all movies          |
| GET    | `/api/movies/{id}`| Get a single movie      |
| POST   | `/api/movies`     | Add a new movie         |
| PUT    | `/api/movies/{id}`| Update a movie          |
| DELETE | `/api/movies/{id}`| Delete a movie          |

---

## 🧪 Technologies Used

| Frontend        | Backend           | Tools          |
|-----------------|-------------------|----------------|
| React + Vite    | Java 17           | Git & GitHub   |
| Axios           | Spring Boot       | Maven          |
| CSS3            | Spring Data JPA   | npm            |
|                 | H2 / MySQL        |                |

---

## 🤝 Contributing

This is a student project. Feel free to fork, modify, and use it for your own learning and development.

---

## 📧 Contact

Created by **Anuradha**  
🔗 GitHub: [anuradha449](https://github.com/anuradha449)
```
