
Vaadin application in a runnable Jar file
===

This version uses embedded Jetty server to execute the application.


To test this out run:

    git clone https://github.com/samie/runnable-jar-vaadin.git
    cd runnable-jar-vaadin
    mvn clean package
    ./target/runnable-jar-vaadin-1.0-SNAPSHOT &
    open http://localhost:8080/
