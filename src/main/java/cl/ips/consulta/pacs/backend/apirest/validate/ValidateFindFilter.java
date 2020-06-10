package cl.ips.consulta.pacs.backend.apirest.validate;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidateFindFilter {

	public static final Logger LOG_ERROR = LoggerFactory.getLogger("error");

	public static Map<String, Object> validaData(Map<String, Object> parametros) {

		//
		LOG_ERROR.info("Parametros paginacion: ");
		parametros.put("iSkip", 0);
		parametros.put("iLimit", 10);
		parametros.put("cErrorMessage", null);
		parametros.put("cErrorNumber", null);
		//
		return parametros;
	}

	private ValidateFindFilter() {

	}

}
