package com.emergency.project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class MeetingSwaggerConfig {
	
	@Bean
	public Docket swaggerDocumentation() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant(MeetingController.BASE_URL +"/**"))
				.apis(RequestHandlerSelectors.basePackage("com.emergency.project"))
				.build()
				.apiInfo(apiDetais());		
	}
	
	public ApiInfo apiDetais() {
		return new ApiInfo(/*title, description, version, termsOfServiceUrl, contact, license, licenseUrl, vendorExtensions)*/
				"Meeting  API", 
				"API that keeps meeting records",
				"1.0", 
				"Free to use", 
				"Michael Shaba", 
				"Meeting API License", 
				"0717424906");
				//new springfox.documentation.service.Contact("Michael Shaba", "www.imt.co.za", "shabamichael@outlook.com"));
				//"API License"));
				//"www.imt.co.za",
				//Collections.emptyList())
			
		
	}

}
