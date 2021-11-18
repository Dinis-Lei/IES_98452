# Lab 3

## 3.1 b)

- 
- findAll(), save(user), findById(id), delete(user), they are all found in CrudRepository
- in memory
- in the annotation @NotBlank on the User class


## lab3_3

The files Movies.txt and Quotes.txt have data data can be loaded to the app.
Movies and Quotes are posted on "/api/addmovie" and "/api/addquotes" respectively.

"/api/quote" is used to show a random quote. "/api/quote?show={id}" shows a random quote from a given movie.



## lab3_3 d)
	
run:

	docker-compose up


## REVIEW QUESTIONS

### a)

A @Controller corresponds to the typical MVC Controller.
The @RestController is a combination of both the @Controller and @ResponseBody annotation.
@Controller creates a Map of Model Object and finds a view while @RestController simply returns object and object data directly written into http response as JSON orXML.  

### b)


### c)

The annotations @Table, @Column, @Id found in the Entity are JPA annotations that serve to specify a Table of the Entity, map the the entity attribute to the database column and specify the Entity identifier.

### d)

Autowiring feature of spring framework enables you to inject the object dependency implicitly. It internally uses setter or constructor injection.

Autowiring can't be used to inject primitive and string values. It works with reference only.
