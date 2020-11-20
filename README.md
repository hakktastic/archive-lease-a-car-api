# lease a Car Api

This is a  simple microservices application which calculates the lease rate for a given car and customer.

### Background
I started developing this application as an assessment for a Job application. Before I wasn't familiar with concepts & technologies like Spring Boot and microservices. In order to be able to build this application I took two online courses:

* [Master Java Web Services and RESTful API with Spring Boot](https://www.udemy.com/course/spring-web-services-tutorial/)
* [Master Microservices with Spring Boot and Spring Cloud](https://www.udemy.com/course/microservices-with-spring-boot-and-spring-cloud/)

I completed the first course and I'm currently progressing the second course (Spring Cloud). So far so good and I'm really enjoying it!

### The application
The application itself contains of four microservices (see drawing below). The lease-calculation-service calls the three other services in order to make a lease rate calcultion. The micro services called each have an in-memory H2 database with prefilled data to make the calculation possible. 

![drawing](https://github.com/hakktastic/lease-a-car-api/blob/main/Drawing.jpg) 

##### Application Url's

Service | Url:port | H2 Console
------------ | ------------- | -------------
lease-calculation-service | http://localhost:8080
customer-service | http://localhost:8081 | http://localhost:8083/h2-console
car-service | http://localhost:8082 | http://localhost:8083/h2-console
interest-rate-calculation-service | http://localhost:8083 | http://localhost:8083/h2-console

##### Technologies
The technologies used for developing this application are as follows:

* Java
* Spring Boot:
  * Spring Web
  * Spring Data JPA
  * Spring Boot Devtools
  * Spring Boot Actuator
  * Spring Cloud OpenFeign
  * H2 Database
* Maven, JUnit & Mockito
* Eclipse, Postman
* Web Browser

### Development
The upcoming period, while completing the second I will be working on the Spring Cloud elements like: 

* Spring Security > how do I secure Rest calls?
* Swagger
* Spring Cloud Config Server
* Ribbon
* Eureka
* Zuul
* RabbitMQ
* Zipkin
* Spring Cloud Bus
* Hystrix

### Setup
In order to run this application within you favourite IDE:

* Checkout this repository from my Github
* Import the projects with Maven
* Install the Maven dependencies
* Build the projects
* Run the applications as Java- or Spring Boot application 

*Startup the lease-calculation service last because it will need the other services for the calculation.*

