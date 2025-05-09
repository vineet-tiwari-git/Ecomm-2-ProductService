FROM maven:latest AS builder
WORKDIR /home/app
COPY . /home/app
RUN chmod +x ./mvnw
RUN mvn clean package -DskipTests

FROM bellsoft/liberica-runtime-container:jre-21-musl 

WORKDIR /home/app
#EXPOSE 8081
COPY --from=builder /home/app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
