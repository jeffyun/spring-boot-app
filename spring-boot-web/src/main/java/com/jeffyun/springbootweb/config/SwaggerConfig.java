package com.jeffyun.springbootweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by jeff.wu on 2017/12/27.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jeffyun.springbootweb.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }


    private ApiInfo metaData(){
        return new ApiInfoBuilder().description("spring boot rest api").build();
//        return new ApiInfo( "Spring Boot REST API",
//                "Spring Boot REST API for Online Store",
//                "1.0",
//                "Terms of service",
//                new Contact("John Thompson", "https://springframework.guru/about/", "john@springfrmework.guru"),
//                "Apache License Version 2.0",
//                "https://www.apache.org/licenses/LICENSE-2.0");
    }
}
