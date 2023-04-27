package com.softart.dferestapi.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;


@Configuration
@SecurityScheme(type = SecuritySchemeType.APIKEY, name = "jwt", description = "JWT Token", paramName = "Authorization", in = SecuritySchemeIn.HEADER)
@OpenAPIDefinition(info = @Info(title = "DF-e Rest API", version = "0.0.1"), security = {@SecurityRequirement(name = "jwt")})
public class OpenApiConfiguration {
}
