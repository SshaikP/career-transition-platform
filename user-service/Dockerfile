#My First DOcker file to containerize the SkillOrbit application
#Use java image
FROM eclipse-temurin:17-jdk

#Set the working directory
WORKDIR /app

#Copy the jar file to the container
COPY target/user-service-0.0.1-SNAPSHOT.jar user-service.jar

#run the jar file
ENTRYPOINT ["java","-jar","user-service.jar"]
