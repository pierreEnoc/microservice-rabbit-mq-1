package com.pierre_api.services_1.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocOpenApiConfig {

    public OpenAPI openAPI() {
      return new OpenAPI()
              .info(
                      new Info()
                              .title("Rest Api - Pedidos")
                              .description(" API para realizacao de pedidos")
                              .license(new License().name("Apache 2.0").url("https://httpd.apache.org/licenses/LICENSE-2.0"))
                              .contact(new Contact().name("Pierre Enoc").email("enoc.pierre@gmail.com"))
              );

    }
}
