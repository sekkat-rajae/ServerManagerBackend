# **ServerManagerBackend**
A simple API created using Spring Boot to manage servers in a network. Using this API, you can Add, Delete, Update, Ping, and store servers along with their current status.
You can access the frontend by following this link: https://github.com/sekkat-rajae/ServerManagerFrontend

---
## **Technology Stack**
- Framework: Spring Boot
- Database: Postgres 

---
## **API Endpoints**

| Method | Endpoint             | Description             |
|--------|----------------------|-------------------------|
| GET    | `server/list`       | Fetch all servers      |
| GET   | `server/ping/{ipAddress}`       | Ping the server with the ipAddress       |
| POST | `server/save`  | Add a new server      |
| DELETE | `server/delete/{id}`  | Delete the server with the current id       |
| GET | `server/get/{id}`  | fetch the server with the current id       |
| DELETE | `server/delete/{id}`  | Delete the server with the current id       |
