# IES_98452

## lab1_2
### c)
        DgroupId= com.notcogniferouslda.app
        DartifactId= become-coggers
        project archetype= quickstart
        naming conventions:
                DgroupId -> Java's Package
                DartifactId -> jar without version
### e)
        DgroupId= notcogniferouslda
        DartifactId= myweatherradar
### g)
        added a developer to the pom.xml file
	changed java version to 11
### j) 
        mvn package //compiles the project and manages the dependecies
        mvn exec:java -Dexec.mainClass="[package].[MainClass]" -Dexec.args="arg0 arg1 arg2..."