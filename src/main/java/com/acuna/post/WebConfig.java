package com.acuna.post;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins(
                "http://localhost:5173",                              // Local dev environment
                "https://your-frontend.vercel.app"                    // Your Vercel frontend URL
            )
            .allowedMethods("*")  // Allow all HTTP methods (GET, POST, PUT, DELETE, etc.)
            .allowedHeaders("*")  // Allow all headers
            .allowCredentials(true); // Allow credentials if you need it
    }
}
