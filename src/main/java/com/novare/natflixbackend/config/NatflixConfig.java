package com.novare.natflixbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class NatflixConfig {

    /**
     * Global CORS configuration
     * Reference: https://spring.io/guides/gs/rest-service-cors/
     * https://reflectoring.io/spring-cors/
     */
    @Bean
    public WebMvcConfigurer corsConfig() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Yo can define the path however I'm definind like all paths. (endpoints)
                registry.addMapping("/**")
                        // you can define the origin be careful with the localhost and specific port
                        // where webapp is running.
                        .allowedOrigins("http://localhost:3000")
                        // you can add the methods that you want to allow the access to server.
                        .allowedMethods("GET", "POST")
                        // Default maxAge is set to 1800 seconds (30 minutes). Indicates how long the preflight
                        // responses can be cached.
                        .maxAge(3600);
            }
        };
    }

}
