package cl.ips.consulta.pacs.backend.apirest.util;

import java.io.IOException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import cl.ips.consulta.pacs.backend.apirest.exception.ResponseException;
import cl.ips.consulta.pacs.backend.apirest.exception.StatusResponseEnum;

@Component
public class ServiceUtil {
	
	/** The Constant Errores del Servicio. */
	public static final Logger LOG_ERROR = LoggerFactory.getLogger("error");
	
	public static String getStatus(String usuario, String urlSecurity, String obj) throws IOException, ResponseException {
		String status = "N";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList());
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Lidtplusuario", usuario);
		headers.add("lNombreObjeto", obj);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(urlSecurity, HttpMethod.GET, entity, String.class);
		}catch(Exception ex) {
			LOG_ERROR.error("Error en servicio : ", urlSecurity, ex);
			throw new ResponseException("Servicio "+urlSecurity+" no responde debido a "+ex, StatusResponseEnum.PRECONDITION_FAILED, true);
		}
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode body = mapper.readTree(response.getBody());
		JsonNode bod = body.get("body");
		if (!bod.isEmpty(null)) {
			JsonNode detalle = bod.get("DetallePermisos");
				if (detalle.findValue("permiso").asText().equals("S")) {
					status = "S";
				}else {
					status = "N";
				}		
		}

		return status;

	}
	
	private ServiceUtil() {

	}
}
