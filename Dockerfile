FROM amazoncorretto:20
ADD /web/target/web-1.0-SNAPSHOT.jar school.jar
ENTRYPOINT ["java", "-jar", "school.jar"]