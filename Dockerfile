FROM openjdk:22-jdk
COPY target/JobApp.jar JobApp.jar
ENTRYPOINT ["java","-jar","JobApp.jar"]