package com.joblisting.joblistingservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Job Listing Service",
                version = "1.0.0",
                description = "Enables users to add and retrieve job postings",
                termsOfService = "nope",
                contact = @Contact(
                        name = "Nivaas",
                        email = "nivaasanna24@gmail.com"
                    ),
                license = @License (name = "license", url = "nope")
        )
)
public class JobListingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobListingServiceApplication.class, args);
    }

}
