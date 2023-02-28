<h1 align="center"> Hi,<img style="width: 35px;" src="https://raw.githubusercontent.com/ABSphreak/ABSphreak/master/gifs/Hi.gif" alt=""> Everyone <a href="#" target="_blank"> Welcome </a></h1>

<!-- ============================================  TITLE ======================================================  -->
# REST API for Bus Reservation System Portal



<li>An Collaborative Project Consisting Of the 5 Developer Depicting the implementation of Bus Reservation System Platform like Red Bus or Yatra.
<li>The REST API performs all the fundamental CRUD operations and business logics of any Trip Management System like RedBus with user authentication at every API endpoint.
<br>

<!-- ============================================  ER - DIAGRAM ======================================================  -->

# ER Diagram

The following Diagram depicts the flow of our Entity Relation Diagram to simplify the work flow.
<br>![NewER](https://user-images.githubusercontent.com/101354104/209176876-e921e2ed-5e08-4128-b236-251ce955646b.jpg)
<br>
<br>
<br>

<!-- ============================================  DETAILS ======================================================  -->



 
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

    <!-- Video -->

# 👉 [Click here](https://drive.google.com/file/d/1id3nI-2F2u4dGjg9Y1eMlUXSsJEdiN1u/view?usp=sharing) to get better understanding of the application.


<!-- ============================================  CONTRIBUTORS ======================================================  -->
## Contributors👨‍💻
  👤 **[@Vaibhav Ghawale](https://thecodervaibhav.github.io)** <br>
GitHub: [codervaibhav](https://github.com/akashsinghdto55) <br>
LinkedIn: [Vaibhav Ghawale](https://www.linkedin.com/in/vaibhavghawale15/)
<br>Worked on Reservation Module

👤 **[@Akash Kumar Singh](https://akashsinghdto55.github.io/)** <br>
GitHub: [akashsinghdto55](https://github.com/thecodervaibhav) <br>
LinkedIn: [Akash Kumar Singh](https://www.linkedin.com/in/akash-singh-a11458213/)
<br>Worked on Admin Module

  👤 **[@Virendra Kumar Dwivedi](https://virendrakumardwivedi.github.io/)** <br>
GitHub: [Virendrakumardwivedi](https://github.com/Virendrakumardwivedi) <br>
LinkedIn: [Virendra kumar dwivedi](https://www.linkedin.com/in/virendra-kumar-dwivedi-824692233/)
<br>Worked on Route Module

👤 **[@Riya Negi](https://riyanegi03.github.io/)** <br>
GitHub: [RiyaNegi03](https://github.com/RiyaNegi03) <br>
LinkedIn: [Riya Negi](https://www.linkedin.com/in/riya-negi-601084210/)
<br>Worked on Bus Module

👤 **[@Gitanjali Makadi](https://geetamakadi123.github.io/)** <br>
GitHub: [geetamakadi123](https://github.com/geetamakadi123) <br>
LinkedIn: [Gitanjali Makadi](https://www.linkedin.com/in/gitanjali-m-36157a233/)
<br>Worked on Feedback Module



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

## Following pictures will help to understand flow of the Application and API's of Bus Reservation Portal System
## Start Point
<img width="957" alt="Screenshot (2376)" src="https://user-images.githubusercontent.com/101354104/209181391-5e015973-fdd3-46da-8c25-e66dcc9b0a6b.png">

## Admin Module
<img width="944" alt="Screenshot (2377)" src="https://user-images.githubusercontent.com/101354104/209181373-dd33a760-085c-4861-93ec-57a7cdf4c874.png">

## User Module
<img width="938" alt="Screenshot (2382)" src="https://user-images.githubusercontent.com/101354104/209181267-0bb48a94-b8e0-43d5-a51c-c944784d5d37.png">

## Route Module
<img width="941" alt="Screenshot (2381)" src="https://user-images.githubusercontent.com/101354104/209181296-17df297f-0316-4ed4-8447-f7a1ad594ede.png">

## Bus Module
<img width="941" alt="Screenshot (2380)" src="https://user-images.githubusercontent.com/101354104/209181319-22cc8857-24e9-4c71-9bc1-37f99d78bc48.png">


## Reservation Module
<img width="940" alt="Screenshot (2379)" src="https://user-images.githubusercontent.com/101354104/209181339-114190a4-49f7-4b66-8e99-18488bc1d982.png">

## Feedback Module
<img width="943" alt="Screenshot (2378)" src="https://user-images.githubusercontent.com/101354104/209181358-585d40ef-eaca-4cef-b430-c243c956f5f9.png">


