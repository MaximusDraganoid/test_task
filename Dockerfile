FROM gradle:jdk8
COPY . /home/gradle/project
WORKDIR /home/gradle/project
ENTRYPOINT ["gradle"]
CMD ["bootRun"]