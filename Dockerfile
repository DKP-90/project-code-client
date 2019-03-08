FROM openjdk:8
ADD target/project-code-client.jar project-code-client.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","project-code-client.jar"]