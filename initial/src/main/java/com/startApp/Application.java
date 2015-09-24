package com.startApp;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource("spring-config.xml")
@SpringBootApplication
public class Application{
    static Logger log = Logger.getLogger(Application.class);
    public  static  void main(String args[]){

        SpringApplication.run(Application.class, args);


        log.debug("Hello this is a debug message");
        log.info("Hello this is an info message");
    }
}