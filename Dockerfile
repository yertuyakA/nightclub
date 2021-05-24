#FROM postgres:13.1-alpine
#ENV POSTGRES_USER=n_admin
#ENV POSTGRES_PASSWORD=admin
#ENV POSTGRES_DB=night_club

FROM adoptopenjdk:11-jre-hotspot
COPY target/nightclub-1.0.0.jar nightapp.jar
ENTRYPOINT ["java", "-jar", "/nightapp.jar"]