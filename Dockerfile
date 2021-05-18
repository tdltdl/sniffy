FROM maven:3.8.1-openjdk-11

ADD . /usr/src/mymaven

RUN cd /usr/src/mymaven && \
    mvn -v && \
    mvn -B verify --file pom.xml -U -P ci -Dgpg.skip=true -Dmaven.wagon.http.retryHandler.count=3