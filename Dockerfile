FROM openjdk:latest
ADD target/mutanttest-2.3.3.RELEASE.jar /usr/share/app.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/app.jar"]