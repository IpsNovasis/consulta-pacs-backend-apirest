package cl.ips.consulta.pacs.backend.apirest.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.ips.consulta.pacs.backend.apirest.config.Properties;
import cl.ips.consulta.pacs.backend.apirest.pojo.response.get.PacsPensionResponse;
import cl.ips.consulta.pacs.backend.apirest.util.JdbcTemplateUtils;

@Component
public class PacsPensionRepository {

	
	private JdbcTemplateUtils jdbcUtils;

	public static final Logger LOG_ERROR = LoggerFactory.getLogger("error");
	private static final String SPFINDPEN = "spElegibiliddPacs";
	private static final String CPERIODO = "cPeriodo";
	private static final String RUT = "iRUN";
	private static final String CDV = "cDV";
	private static final String DFECHAPENSION = "dFechaPension";
	private static final String INUMEROMESESCOTIZADOS = "iNumeroMesesCotizados";
	private static final String CBONORECONOCEDIPRECA = "cBonoReconoceDIPRECA";
	private static final String CBONORECONOCECAPREDENA = "cBonoReconoceCAPREDENA";
	private static final String INUMEROCOTIZACIONESIPS = "iNumeroCotizacionesIPS";
	private static final String NMONTOINGRESO = "nMontoIngreso";
	private static final String NVALORUF = "nValorUF";
	private static final String DFECHAVALORUF = "dFechaValorUF";
	private static final String CRESULTADOBENEFICIOFIJO = "cResultadoBeneficioFijo";
	private static final String CRESULTADOBENEFICIOVARIABLE = "cResultadoBeneficioVariabe";

	@Autowired
	private void setJdbcUtils(JdbcTemplateUtils jdbcUtils) {
		this.jdbcUtils = jdbcUtils;
	}

	@Autowired
	private Properties properties;

	public  PacsPensionResponse findPensiones(Map<String, Object> params) {
		LOG_ERROR.info("Parametros Elegibilidad: ");
		LOG_ERROR.info("params: {}", params);

		Map<String, Object> dataBD = jdbcUtils.callStoreProcedure(properties.getProperties().get(SPFINDPEN), params);

		PacsPensionResponse dataPension = new PacsPensionResponse();

		@SuppressWarnings("unchecked")

		List<Map<String, Object>> salida = (List<Map<String, Object>>) dataBD.get("#result-set-1");

		if(!salida.isEmpty()) {
			for (int i = 0; i < salida.size(); i++) {	
				
				System.out.println("salida " + salida.get(i).toString());
				
				Map<String, Object> parametriaBD = salida.get(i);

				dataPension.setcPeriodo(parametriaBD.get(CPERIODO).toString());
				dataPension.setiRUN((int) parametriaBD.get(RUT));
				dataPension.setcDV(parametriaBD.get(CDV).toString());
		
				dataPension.setdFechaPension(parametriaBD.get(DFECHAPENSION).toString());
				dataPension.setiNumeroMesesCotizados((int) parametriaBD.get(INUMEROMESESCOTIZADOS));
				
				dataPension.setcBonoReconoceDIPRECA(parametriaBD.get(CBONORECONOCEDIPRECA).toString());
				
				dataPension.setcBonoReconoceCAPREDENA(parametriaBD.get(CBONORECONOCECAPREDENA).toString());
				
				dataPension.setiNumeroCotizacionesIPS((int) parametriaBD.get(INUMEROCOTIZACIONESIPS));
				dataPension.setnMontoIngreso((BigDecimal) parametriaBD.get(NMONTOINGRESO));
				dataPension.setnValorUF((BigDecimal) parametriaBD.get(NVALORUF));
				
				dataPension.setdFechaValorUF(parametriaBD.get(DFECHAVALORUF).toString());
				dataPension.setcResultadoBeneficioFijo(parametriaBD.get(CRESULTADOBENEFICIOFIJO).toString());
				dataPension.setcResultadoBeneficioVariabe(parametriaBD.get(CRESULTADOBENEFICIOVARIABLE).toString());
			}
		}
		return dataPension;

	}

}
