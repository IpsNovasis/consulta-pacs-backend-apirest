package cl.ips.consulta.pacs.backend.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import cl.ips.consulta.pacs.backend.apirest.config.Properties;

@SpringBootApplication
@EnableConfigurationProperties(Properties.class)
public class ConsultaPacsBackendApirestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultaPacsBackendApirestApplication.class, args);
	}
	
}
