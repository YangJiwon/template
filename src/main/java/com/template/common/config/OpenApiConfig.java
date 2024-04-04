package com.template.common.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(
		title = "테스트 서비스",
		description = "테스트 서비스에 대해 설명하는 문서입니다.",
		version = "1.0"
))
@Configuration
public class OpenApiConfig {

}
