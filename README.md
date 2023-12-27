# Kirana Store API

This repository contains the source code for the Kirana Store API.

## Endpoints

### Record a new financial transaction

Endpoint: `POST /api/transactions/record`

Description: Record a new financial transaction.

### Retrieve a list of all recorded transactions

Endpoint: `GET /api/transactions/list`

Description: Retrieve a list of all recorded transactions.

### Retrieve a grouped list of transactions by date

Endpoint: `GET /api/transactions/grouped-list`

Description: Retrieve a grouped list of transactions by date.

## How to Run the Application

To run the Kirana Store API locally, follow these steps:

1. Clone the repository: `git clone https://github.com/mohittk/kiranastore`
2. Build the project: `./mvnw clean install`
3. Add db-secrets: Open `application.properties` from `/src/main/resources/application.properties` and add db-secrets to the file.
4. Run the application: `./mvnw spring-boot:run`


