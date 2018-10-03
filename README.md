# Springbootapp
This project was initiated to build spring boot application to  using the following spring freamwork.

## What i wanted to achieve in this project ?
Building application that's exposed web-service end-point to end user, where the information send in HTTP requests is going to be stored in database.

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system, for my example i am using macOS 10, Other OS should have similar steps.

### Prerequisites
* [Java 8+](http://openjdk.java.net/install/) - Programming language
* [Maven](https://maven.apache.org/) - Dependency Management 
* [Docker](https://www.docker.com/) - Containerization tool
* [Docker-Compose](https://docs.docker.com/compose/install/) - Container Orchestration tool
* [MySQL Workbench](https://dev.mysql.com/downloads/workbench/) - RDBMS (or you can choose any DB that you are comfortable with)
*[Postman](https://www.getpostman.com/apps) - Tools build to test webserice 

### Installation

#### Installing Java
First you need to check what java version installed on your machine, in your terminal type:

```
java -version
```

If output contains 'jre' keyword then you need to install java jdk version, you can follow this site
for java installation [How to install java on macOS](https://tecadmin.net/install-java-8-on-centos-rhel-and-fedora/).

#### Installing Maven
After Java JDK version is being installed, we need to install Maven from Apache site, in your terminal type:

```
cd /usr/local
wget http://www-eu.apache.org/dist/maven/maven-3/3.5.4/binaries/apache-maven-3.5.4-bin.tar.gz
```

Now Extract your downloaded file:

```
sudo tar xzf apache-maven-3.5.4-bin.tar.gz
sudo ln -s apache-maven-3.5.4 maven
```

Once your extraction is finished successfully we'll set environment variables for maven :

```
sudo vi /etc/profile.d/maven.sh
```

after opening file using vim tool (vi), click on 'i' keyboard, this will activate vi in editing mode, 
navigate to the end of your file and type :

```
export M2_HOME=/usr/local/maven
export PATH=${M2_HOME}/bin:${PATH}
```

then click on 'esc' button and type ' :wq ', it is a command shortcut to write and quit.

reload your environment variables with this command :

```
source /etc/profile.d/maven.sh
```

check your installation by typing 'mvn -version', you should see output similar to the below  :

```
Apache Maven 3.5.4 (1edded0938998edf8bf061f1ceb3cfdeccf443fe; 2018-06-17T22:33:14+04:00)
Maven home: /usr/local/maven
Java version: 1.8.0_181, vendor: Oracle Corporation, runtime: /Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.13.6", arch: "x86_64", family: "mac"
Muhammads-MacBook-Pro:~ MBA$ 
```

#### Installing Docker
For installing docker, follow docker documentation on their official [https://docs.docker.com/docker-for-mac/install/), and choose your OS from left menu.

#### Installing Docker Compose
In your terminal run the below command :

```
sudo curl -L https://github.com/docker/compose/releases/download/1.22.0/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose
```

Then add executable permissions to your binary :

```
sudo chmod +x /usr/local/bin/docker-compose
```

Test your installation :

```
docker --version
```

```
docker-compose --version
```

## Project structure

Project is consisted of main project (springbootapp) built using maven build tool.
springbootapp main project contains pom.xml which includes properties, dependencies and plugins.


#### How configure spring boot application

* Add spring boot parent starter.

```
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.0.5.RELEASE</version>
	</parent>
```

* Add starter web dependency required in your application, however in this project, i've added spring boot starter web, data, actuator and mysql connector dependencies.

```
<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.12</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
	</dependencies>
```

* Add Java version property in properties section.

```
<properties>
		<java.version>1.8</java.version>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	</properties>
```

* Create java class annotated using @SpringBootApplication, that tells spring this class is starting point of spring boot application, then in main method of the class call a static method

```
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
```

* Now you can test you configuration by running the spring boot application,either from eclipse 'run as java application' neither execute "mvn spring-boot:run" but make sure to navigate to directory of the project where the pom.xml file located.

```
mvn spring-boot:run
```
If the build failed due to user permission execute "sudo mvn spring-boot:run"

```
sudo mvn spring-boot:run
```

#### What's happened when spring boot application start ?
1. Spring set up default configuration.
2. Start spring application context (Container).
3. Perform class path scan.

#### Two ways to specify spring boot application properties 
1. Using application.properites file
2. Using application.yml file 
* [Common application properties]( https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)

#### Dockerfile
To build docker image, create Dockerfile, and write the instructions required for that.
In this project, i built image that contain executable jar file of springbootapp, for more clarity take a look at Dockerfile within this project.  

#### Docker-compose
to define and run multi-container Docker applications. With Compose, you use a YAML file to configure your application’s services.

here i used docker compose because i have two images build and run into two different container, for or more clarity take a look at docker-compose.yml file within this project   


## Building and running 

#### Building
To be able to build the application, navigate to the directory where the pom.xml file located and execute the following command in terminal 

```
sudo mvn clean package
```
please note that during the build you will find that the image is build, thats because i've added maven plugin in pom.xml which will automatically build the image  

```
<plugins>
	<plugin>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-maven-plugin</artifactId>
		<executions>
			<execution>
				<goals>
					<goal>repackage</goal>
				</goals>
			</execution>
		</executions>
	</plugin>
	<plugin>
		<groupId>com.spotify</groupId>
		<artifactId>dockerfile-maven-plugin</artifactId>
		<version>1.4.0</version>
		<executions>
			<execution>
				<id>default</id>
				<goals>
					<goal>build</goal>
					<goal>push</goal>
				</goals>
			</execution>
			<execution>
				<id>tag</id>
				<goals>
					<goal>tag</goal>
				</goals>
			</execution>
		</executions>
		<configuration>
			<repository>${docker.image.name}</repository>
			<tag>${docker.image.tag}</tag>
		</configuration>
	</plugin>
</plugins>
```

* After building the project, i need to check weather the images build, for that in terminal execute the following command

```
docker images 
```
you should have similar output as showing below:

```
Muhammads-MacBook-Pro:springbootapp MBA$ docker images
REPOSITORY             TAG                 IMAGE ID            CREATED             SIZE
mba/springbootapp      latest              474ef0f5949e        6 seconds ago       136MB
```
#### Running

To be able run the project with docker execute the following command in terminal, however make sure to navigate to directory where docker-compose.yml file located 
 
```
docker-compose up
```
after execute "docker-compose up" command and you wanted to check wheather the images are loaded to running container execute the following command  

```
docker ps
```

you should have similar output as showing below:

```
Muhammads-MacBook-Pro:~ MBA$ docker ps
CONTAINER ID        IMAGE                      COMMAND                  CREATED             STATUS              PORTS                               NAMES
9efcea8d8717        mba/springbootapp:latest   "java -jar /project/…"   39 seconds ago      Up 38 seconds       0.0.0.0:8090->8080/tcp              springbootapp_springbootapp_1
84e2ea45e166        mysql:8.0.12               "docker-entrypoint.s…"   40 seconds ago      Up 39 seconds       0.0.0.0:3306->3306/tcp, 33060/tcp   springbootapp_db_1
```

## Database 

springboot application required database schema, refer back to docker-compose file where you can find "db" service which in fact override mysql:8.0.12 image installed from docker hub which running the application after executing 
"docker-compose up" command

Once the application is up and running as well as the images loaded into docker container, don't forget to run the following script in database schema "mbaDB"

#### DataBase tables script 

* Department table 

```
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_code` varchar(10) NOT NULL,
  `name` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dept_code_UNIQUE` (`dept_code`)
) ENGINE=InnoDB AUTO_INCREMENT
```
* Employee table

```
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_code` varchar(10) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `age` int(11) NOT NULL,
  `date_of_joining` datetime NOT NULL,
  `designation` varchar(45) NOT NULL,
  `dept_code` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `emp_code_UNIQUE` (`emp_code`),
  KEY `dept_code_idx` (`dept_code`),
  CONSTRAINT `dept_code` FOREIGN KEY (`dept_code`) REFERENCES `department` (`dept_code`)
) ENGINE=InnoDB AUTO_INCREMENT
```

## Author

* **Muhammad Abdelhadi ** - *Initial work* - [MBA90](https://github.com/MBA90)

## Contributing

Participating in project are most welcome, but no direct push to master, just a reviewed pull request will be merged into master,
committed code should be well formatted and documented.

## License

This project is licensed under the GPL License - see the [LICENSE.md](https://github.com/MBA90/springbootapp/blob/master/LICENSE) file for details
