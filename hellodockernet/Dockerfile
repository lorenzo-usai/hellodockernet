FROM openjdk:8

COPY /target/*-jar-with-dependencies.jar /app/app.jar

#add wait-for-it
ADD https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh /
RUN chmod +x wait-for-it.sh

CMD ["./wait-for-it.sh", "mongodb:27017", "--timeout=30", "--strict", "--", "java", "-jar", "/app/app.jar", "mongodb"]