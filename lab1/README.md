# IES_98452

## lab1_2
### c)
* DgroupId= com.notcogniferouslda.app
* DartifactId= become-coggers
* project archetype= quickstart
* naming conventions:

        - DgroupId -> Java's Package

        - DartifactId -> jar without version

### e)
DgroupId= notcogniferouslda

DartifactId= myweatherradar
### g)
added a developer to the pom.xml file

changed java version to 11

### j) 
        mvn package //compiles the project and manages the dependecies

        mvn exec:java -Dexec.mainClass="[package].[MainClass]" -Dexec.args="arg0 arg1 arg2..."
        
## Docker

        docker run "image_name" 
Run docker image

-d -> Run container in the background

-p 80:80 -> map port 80 of the host to port 80 in the container

        docker build [OPTIONS] PATH
        
 Criar uma imagem a partir de um docker file

-t -> give the image a tag

docker run --name pg-docker -e POSTGRES_PASSWORD=docker -e PGDATA=/tmp -d -p 5433:5432 -v ${PWD}:/var/lib/postgresql/data postgres:11

-p -> mapeia o port do host ao port do container

-e -> define enviroment variables

-v -> assing a local path to an image path

        docker exec -it pg-docker psql -U postgres

Run the psql inside the container

        # syntax=docker/dockerfile:1
        FROM python:3.7-alpine
        WORKDIR /code
        ENV FLASK_APP=app.py
        ENV FLASK_RUN_HOST=0.0.0.0
        RUN apk add --no-cache gcc musl-dev linux-headers
        COPY requirements.txt requirements.txt
        RUN pip install -r requirements.txt
        EXPOSE 5000
        COPY . .
        CMD ["flask", "run"]


- Build an image starting with the Python 3.7 image.
- Set the working directory to /code.
- Set environment variables used by the flask command.
- Install gcc and other dependencies
- Copy requirements.txt and install the Python dependencies.
- Add metadata to the image to describe that the container- is listening on port 5000
- Copy the current directory . in the project to the- workdir . in the image.
- Set the default command for the container to flask run.


## REVIEW QUESTIONS

### a)

The Default lifecycle consists in different build phases (23 in total). The main phases are:
                
- validate -> See if the project is correct and the availability of the necessary information
- compile -> compile the source code of the project
- test -> test with an unit testing framework the compiled source code 
- package -> package the compiled code in its distributable format, such as a JAR.
- verify -> run checks to ensure that quality criteria is met
- install -> install the package into the local repository, for use as a dependency in other projects locally
- deploy -> done in the build environment, copies the final package to the remote repository for sharing with other developers and projects.

### b)
        
Maven is a build tool used to facilitate the management of your software project and to handle build activities and its resulting artifacts.
Even though it is ot his primary purpose, Maven can be used to run your project by using different plugins to execute your Class.

### c)

        git clone <repository name>
        git branch <branch name>
        [modifications]
        git add <changed files>
        git commit -m <insightful message>
        git push <remote> <branch name>




         
        
	
