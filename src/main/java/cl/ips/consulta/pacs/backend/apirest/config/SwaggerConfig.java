package cl.ips.consulta.pacs.backend.apirest.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("cl.forum"))
				.paths(regex("/api.*")).build().apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {

		return new ApiInfoBuilder().title("Documentacion Parametria Distribuidor GFE")
				.description("Servicio para obtener, agregar, modificar y quitar parametría de Distribuidor")
				.version("1.0").build();

	}
}