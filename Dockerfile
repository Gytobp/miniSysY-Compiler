#FROM openjdk:14
#COPY . /myapp/
#WORKDIR /myapp/
#RUN javac -cp src/ src/Main.java -d dst/


# Build stage
#
FROM maven:3.6.3 AS build
COPY ./ /myapp/
WORKDIR /myapp/
#COPY src /home/app/src
#COPY pom.xml /home/app
RUN mvn -f pom.xml clean package

#
# Package stage
#
FROM openjdk:15
WORKDIR /myapp/
COPY --from=build target/miniSysY-Compiler-1.0-SNAPSHOT.jar ./dst/
