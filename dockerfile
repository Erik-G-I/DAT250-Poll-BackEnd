FROM gradle:8-jdk21-alpine

WORKDIR /home/gradle

COPY settings.gradle.kts gradlew build.gradle.kts .

COPY src src

COPY gradle gradle

RUN ./gradlew bootJar

CMD [ "./gradlew", "bootRun" ]
