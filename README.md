Entrega final do curso online "Princípios de Desenvolvimento Ágil de Software" do Instituto Tecnológico de Aeronáutica (ITA);
# Esse Eu Já Li

"Esse Eu Já Li!" is a gamified book reading portal where users can mark books they have read and earn points based on each book's page count. The system rewards users with genre-specific trophies when they complete a set number of books in the same category.

## Final Assignment

This project is the final assignment for the Agile Software Methodology course at ITA.

## Features

- **User Login:**  
  Users can log in using their email and password.

- **Book Listing:**  
  A list of pre-registered books is displayed, including basic information such as title, author, genre, and a brief summary.

- **Book Details:**  
  Users can view detailed information about each book, including the number of pages.

- **Mark as Read:**  
  When a user marks a book as read, they receive:
  - **1 base point** per book, plus
  - **1 additional point** for every 100 pages  
    (e.g., a book with 72 pages gives 1 point, 124 pages gives 2 points, and 350 pages gives 4 points).

- **Genre Trophies:**  
  For every five books read in the same genre, the user earns a trophy titled "Reader of [Genre]". For example, reading five Science Fiction books will award the trophy "Reader of Science Fiction".

- **User Ranking:**  
  The system displays a ranking of the top 10 users based on their total points.

- **User Profile:**  
  Each user has a personal profile page that shows their accumulated points and the trophies they have earned.

## Technologies Used

- **Java (OpenJDK 11/23)**
- **Spring Boot**
- **Spring Data JPA**
- **H2 In-Memory Database**
- **Maven**

## How to Run

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/your-username/esse-eu-ja-li.git
   cd esse-eu-ja-li

2. **Build the Project:**

   ```bash
    mvn clean install

3. **Run the Application:**

   ```bash
    mvn spring-boot:run

4 . **Access the Application:**

The application will be running on http://localhost:8080.

## API Endpoints
*Login:*
   ```bash
    POST /api/login?email={email}&password={password}
   ```
Example:
   ```bash
POST http://localhost:8080/api/login?email=alice@example.com&password=password123
   ```
*List Books:*
   ```bash
GET /api/books
   ```
*Book Details:*
   ```bash
GET /api/books/{id}
   ```
*Mark Book as Read:*
   ```bash
POST /api/books/{id}/mark-read?userId={userId}
   ```
*User Ranking:*
   ```bash
GET /api/ranking
   ```
*User Profile:*
   ```bash
GET /api/profile?userId={userId}
   ```
## H2 Database Console
You can access the H2 database console to inspect the in-memory database:

- *URL:* http://localhost:8080/h2-console
- *JDBC URL:* jdbc:h2:mem:testdb
- *User Name:* sa
- *Password:* (leave blank)

## License
This project is licensed under the MIT License.
