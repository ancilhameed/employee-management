package com.employee.management.system;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final ApiInfo EMP_MNGMNT_API_INFO = new ApiInfo("Employee Management System",
			"This application is used for managing employee data.", "1.0.0:SNAPSHOT",
			"emp-mngmnt.com", "Ancil Hameed", null, null);

	private static final Set<String> PRODUCES_AND_CONSUMES = new HashSet<>(
			Arrays.asList("application/xml", "application/json"));

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(EMP_MNGMNT_API_INFO).produces(PRODUCES_AND_CONSUMES)
				.consumes(PRODUCES_AND_CONSUMES);
	}

}
