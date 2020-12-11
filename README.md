# lease a Car Api

This is a  simple microservices application which calculates the lease rate for a given car and customer.

### Background
I started developing this application as an assessment for a Job application. Before I wasn't familiar with concepts & technologies like Spring Boot and microservices. In order to be able to build this application I took two online courses:

* [Master Java Web Services and RESTful API with Spring Boot](https://www.udemy.com/course/spring-web-services-tutorial/)
* [Master Microservices with Spring Boot and Spring Cloud](https://www.udemy.com/course/microservices-with-spring-boot-and-spring-cloud/)

I completed the first course and I'm currently progressing the second course (Spring Cloud). So far so good and I'm really enjoying it!

### The application
The application itself contains of four microservices (see drawing below). The lease-calculation-service calls the three other services in order to make a lease rate calcultion. The micro services called each have an in-memory H2 database with prefilled data to make the calculation possible. 

*Drawing will be updated with naming server & load balancer*

![drawing](https://github.com/hakktastic/lease-a-car-api/blob/main/Drawing.jpg) 

##### Application Url's

Service | Url:port | H2 Console | API Documentation
------------ | ------------- | -------------  | -------------
lease-calculation-service | http://localhost:8080 | - | http://localhost:8080/swagger-ui/#/lease-calculation-controller
customer-service | http://localhost:8081 | http://localhost:8083/h2-console | http://localhost:8081/swagger-ui/#/customer-controller
car-service | http://localhost:8082 | http://localhost:8082/h2-console | http://localhost:8082/swagger-ui/#/car-controller
interest-rate-calculation-service | http://localhost:8083 | http://localhost:8083/h2-console | http://localhost:8083/swagger-ui/#/interest-rate-controller
Netflix Eureka Naming Server | http://localhost:8761 | - | -
Netflix Zuul Api Gateway Server | http://localhost:8765 | - | -
Zipkin  | http://localhost:9411/zipkin/ | - | -
Spring Cloud Config Server | http://localhost:8888 | - | -

##### Technologies
The technologies used for developing this application are as follows:

* Java
* Spring Boot:
  * Spring Web
  * Spring Data JPA
  * Spring Boot Devtools
  * Spring Boot Actuator
  * Spring Cloud OpenFeign
  * Spring Cloud Config Server
  * Spring Cloud Sleuth
  * Netflix Ribbon Load Balancer
  * Netflix Eureka Naming Server
  * Netflix Zuul API Gateway Server
  * MQRabbit
  * Zipkin Tracing Server
  * H2 Database
  * Springfox (Swagger)
* Maven, JUnit & Mockito
* Eclipse, Postman
* Web Browser

### Development
The upcoming period, while completing the second course I will be working on the Spring Cloud elements like: 

####SHORT TERM
* Netflix Hystrix > Manage failures and fallbacks
* Refactor Maven projects to Maven multi-module projects in combination with DDD
* Dockerize projects
	* include in maven build process (spotify docker maven plugin)
	* improve caching by splitting up dependencies & classes (maven dependency plugin)
	* Change from H2 to Docker MySQL database; use H2 for tests
* Spring Security > how do I secure Rest calls?

####MID TERM
* Instead of Netflix Ribbon load balancer try use Spring Cloud Load Balancer
* Spring Cloud Bus > Dynamic configuration changing

### Setup
In order to run this application within you favourite IDE:

* Checkout this repository from my Github
* Import the projects with Maven
* Install the Maven dependencies
* Build the projects
* Download and Install latest version of [RabbitMQ](https://www.rabbitmq.com/download.html)
	* A prerequisite for RabbitMQ is the installation of Erlang libraries
	* Download and install the libraries of Erlang: [Erlang OTP](https://www.erlang.org/downloads)
* Download [Zipkin Tracing Server](https://search.maven.org/remote_content?g=io.zipkin&a=zipkin-server&v=LATEST&c=exec) (executable jar)
* Run the applications as Java- or Spring Boot application 
	* Start the Eureka Naming Server
	* Start the micros services implementations
	* Start the Zuul API Gateway Server
* Start RabbitMQ
* Start Zipkin Tracing Server
	* Windows: use [launch-zipkin-server.cmd](https://github.com/hakktastic/lease-a-car-api/blob/main/launch-zipkin-server.cmd)
