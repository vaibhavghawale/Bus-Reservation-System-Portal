<!-- ============================================  TITLE ======================================================  -->
# REST API for Bus Reservation System Portal

<!-- ============================================  DETAILS ======================================================  -->

<li>An Collabrative Project Consisting Of the 5 Developer Depicting the implementation of Bus Reservation System Platform like Red Bus or Yatra.
<li>The REST API performs all the fundamental CRUD operations and business logics of any Trip Management System like RedBus with user authentication at every API endpoint.
<br>

 
<!-- ============================================  FEATURES ======================================================  -->
## Features

* Customer and Admin authentication & validation with session uuid having.
* Admin Features:
    * Administrator Role of the entire application
    * Only registered admins with valid session token can add/update/delete customer from main database
    * Admin can access the details of different customers and trip bookings
* Customer Features:
    * Registering themselves with application, and logging in to get the valid session token
    * Viewing list of available Route and available Bus for a trip
    * Only logged in user can access his reservations, profile updation and other features.

<!-- ============================================  CONTRIBUTORS ======================================================  -->
## Our Team Members 👨‍💻
  - **[@Vaibhav Ghawale](https://thecodervaibhav.github.io)**
  - **[@Akash Kumar Singh](https://github.com/akashsinghdto55)**
  - **[@Gitanjali Makadi](https://github.com/geetamakadi123)**
  - **[@Virendra Kumar Dwivedi](https://github.com/Virendrakumardwivedi)**
  - **[@Riya Negi](https://github.com/RiyaNegi03)**

<!-- ============================================  TECH STACK ======================================================  -->

## Tech Stack

* Java
* Spring Framework
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Postman
* Swagger UI

<!-- ============================================  MODULES ======================================================  -->

## Modules

* Login, Logout Module
* Admin Module
* User Module
* Route Module
* Bus Module
* Reservation Module
* Feedback Module

<!-- ============================================  ER - DIAGRAM ======================================================  -->

# ER Diagram

The following Diagram depicts the flow of our Entity Relation Diagram to simplify the work flow.
<br>
<br>
<img src=""></img>
<br>
<br>

<!-- ============================================  DOCUMENTATION ======================================================  -->

## Documentation

SWAGGER UI Documentation - `http://localhost:8888/swagger-ui/`

<!-- ============================================  INSTALLATION AND RUN ======================================================  -->

## Installation & Run

* Before running the API server, you should update the database config inside the [application.properties](https://github.com/thecodervaibhav/berserk-camera-3158/blob/main/BusReservationSystemPortal/src/main/resources/application.properties) file. 
* Update the port number, username and password as per your local database config.

```
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3306/mydb;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

```

<!-- ============================================  API ROOT ENDPOINTS ======================================================  -->

## API Root Endpoint

`https://localhost:8888/`
  
`http://localhost:8888/swagger-ui/`

user this data for checking purpose.
- **[@Demo Data](https://docs.google.com/document/d/1BixwmAqMjVAWdZ3jfslPvVOtOg77fsf_DHmPVhRkQBs/edit?usp=sharing)(click here to demo data)


## Responsibilities:-
### Vaibhav Ghawale 
<p>Creating a Reservation Module.</p>
