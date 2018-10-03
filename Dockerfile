FROM openjdk:8-jdk-alpine

RUN mkdir -p /project/springbootapp

ADD target/springbootapp-0.0.1-SNAPSHOT.jar /project/springbootapp
		   
ENTRYPOINT ["java","-jar","/project/springbootapp/springbootapp-0.0.1-SNAPSHOT.jar"]

