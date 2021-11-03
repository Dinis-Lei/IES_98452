# Lab 2

## **Review Questions**

---
### **A.**

A servlet container provides a runtime enviroment for Java applications. This means dynamically generate web pages on the server side. It is achived by the use of servlets.

Servlet is an interface that has 3 methods during its lifecycle:

- *init()*, allows the servlet to access initialization parameters from the web application.

- *service()*, determines the kind of request being made and dispatches it to an appropriate method to handle the request.

- *destroy()*, releases the resources being held.

    
The servlet container is responsible for each servlet creation, execution and destruction.

---
### **B.**

Spring uses MVC (Model, View, Controller) to serve web content. 
- **Model** is the logical layer of the application. Spring framework has the org.springframework.ui.Model that allows to map attributes to be later rendered on views.
- **View** is the "front-end" layer and is usually stored in the templates folder on a Spring project
- **Controller** accepts input and converts it to commands for the model or view. Spring has a special annotation to designate a class as a Controller.



---
### **C.**

starters are a list of Spring Boot's dependeny descriptors that allow access to Spring's technology, making development quick and easy to start.

---
### **D.**

Using @SpringBootApplication annotation is the same as using the following 3 annotations:

- **@EnableAutoConfiguration**: enable Spring Boot’s auto-configuration mechanism
- **@ComponentScan**: enable @Component scan on the package where the application is located
- **@Configuration**: allow to register extra beans in the context or import additional configuration classes

---
### **E.**

- **Accept and respond with JSON**: JSON is the standard for transferring data so your REST API should be able to receive and send data in this format.

- **Maintain good security practices**: Most comunication between client and server should be private so it is important to follow  security protocols such as SSL (secure socket layer).

- **Cache data to improve performance**: Instead of always querying the database every time we want information, we can store data in the local memory cache. This will improve the preformance for the client but may lead to showcase outdated data.

- **Handle errors gracefully and return standard error codes**: When errors occur we should return the correct HTTP response code of the kinf of error, this will give enough information to mantainers of the API, allowing them to understand the error.

- **Versioning our APIs**: We should have a different version of the API every time that we implement deatures that may break a clients project. This makes so that clients don't have to be forced to move to a new version.

