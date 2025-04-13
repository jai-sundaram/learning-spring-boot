#getting the jdk
#this is the jdk we are using, amazoncorretto
FROM amazoncorretto:21
#now we need to add the jar file to the docker container, using the ADD command
#we need to mention the source and the destination
#the destination for this, we are just setting to the jar file name
ADD target/jai-demo.jar jai-demo.jar

#now, to make sure that the java application runs when we run the container, we need to input this command below
#using the ENTRYPOINT command
#the actual command: java -jar jai-demo.jar
ENTRYPOINT ["java", "-jar", "jai-demo.jar"]

#we are basically saying:
#first, get the jdk image,which is in this case is amazoncoretto
#when that runs, get the jar file, and then run the application as welld
