FROM anapsix/alpine-java:8_server-jre_unlimited

RUN mkdir -p /home/workspace/x-workout

WORKDIR /home/workspace/x-workout

EXPOSE 8091

VOLUME /Users/xian/Documents/docker/volume/x-workout:/home/workspace/x-workout

ADD ./target/x-workout-server-1.0.0-SNAPSHOT.jar ./app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

CMD ["--spring.profiles.active=dev"]
