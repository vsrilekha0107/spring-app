package com.eg.spring_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
@SpringBootApplication
public class SpringAppApplication {
 
    public static void main(String[] args) {
SpringApplication.run(SpringAppApplication.class, args);
 
        // Create an object of your custom class and test it
        Data data = new Data();
        data.init();
        data.validateOperator("25", "20", "greater than"); // Example test
    }
}



