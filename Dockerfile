from openjdk:17-jdk-slim
workdir /zentask
copy target/zentask-0.0.1-SNAPSHOT.jar zentask.jar
entrypoint ["java", "-jar", "zentask.jar"]