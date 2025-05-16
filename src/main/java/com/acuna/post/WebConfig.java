package com.acuna.post;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173", "https://final-ui-liart.vercel.app/") // Add your Vercel URL
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allow common methods
                .allowedHeaders("*"); // Allow all headers
    }
}
