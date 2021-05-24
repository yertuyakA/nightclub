FROM adoptopenjdk:11-jre-hotspot
COPY target/nightclub-1.0.0.jar nightapp.jar
ENTRYPOINT ["java", "-jar", "/nightapp.jar"]