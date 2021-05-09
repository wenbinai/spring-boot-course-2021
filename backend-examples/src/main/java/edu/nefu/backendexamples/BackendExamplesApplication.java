package edu.nefu.backendexamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class BackendExamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendExamplesApplication.class, args);
    }

}
