FROM bellsoft/liberica-runtime-container:jdk-21-stream-musl as builder
WORKDIR /home/app
COPY . /home/app
RUN ./mvnw clean package -DskipTests

FROM bellsoft/liberica-runtime-container:jre-21-musl 

WORKDIR /home/app
#EXPOSE 8081
COPY --from=builder /home/app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
