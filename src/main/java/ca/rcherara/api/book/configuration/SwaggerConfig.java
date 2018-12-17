package ca.rcherara.api.book.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ca.rcherara.api.book.controller.BookController;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author rcherara
 *
 */
@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
@ComponentScan(basePackageClasses = {
        BookController.class
})
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ca.rcherara"))  
                //.paths(PathSelectors.ant("/book.*"))            
		        .build()
		        .apiInfo(getApiInfo());
    }

    
   

	private ApiInfo getApiInfo() {
        return new ApiInfo(
                "API Book",
                "Books rest API",
                "SNAPSHOT",
                "TERMS OF SERVICE URL",
                new Contact("CHERARA REDDAH","https://rcherara.ca/en","cherara.reddah@icloud.com"),
                "Apache License Version 2.0",
                "https://github.com/springfox/springfox/blob/master/LICENSE",
                Collections.emptyList()
        );
    }
}
