FROM java:openjdk-8-alpine


WORKDIR /app


COPY ./target/micro-servico.jar /app/micro-servico.jar

EXPOSE 8080

CMD java -jar /app/micro-servico.jar
