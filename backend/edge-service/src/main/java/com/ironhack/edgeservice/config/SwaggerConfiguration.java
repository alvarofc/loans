package com.ironhack.edgeservice.config;

import java.util.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket api()
    {
        ParameterBuilder paramBuilder = new ParameterBuilder();
        List<Parameter> params = new ArrayList<>();
        paramBuilder.name("Authorization").modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        params.add(paramBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(params)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(Collections.singletonList(apiKey()))
                .consumes(new HashSet<String>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));
    }

    private ApiKey apiKey() {
        return new ApiKey("Authorization", "Bearer", "header");
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "CRM in Microservices API",
                "API for CRM",
                "1.0",
                "Terms of service",
                new Contact("Fantastic For Loop Project", "", "joanamartadacruz@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}