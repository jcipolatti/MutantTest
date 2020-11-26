package com.magneto.mutanttest;

import com.magneto.mutanttest.configuration.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
@Import(SwaggerConfiguration.class)
public class MutantTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MutantTestApplication.class, args);
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

    }
}
