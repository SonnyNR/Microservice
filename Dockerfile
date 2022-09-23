# define base docker image
FROM openjdk:8
ADD target/demo-0.0.1-SNAPSHOT.jar sooa-reg-and-auth.jar
ENTRYPOINT ["java", "-jar", "sooa-reg-and-auth.jar"]