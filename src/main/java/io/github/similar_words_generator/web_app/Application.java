package io.github.similar_words_generator.web_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        SeedService seedService = new SeedService();
        seedService.initSeedsLocation();
    }
}
