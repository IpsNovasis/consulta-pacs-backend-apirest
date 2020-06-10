package cl.ips.consulta.pacs.backend.apirest.repository;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.ips.consulta.pacs.backend.apirest.config.Properties;
import cl.ips.consulta.pacs.backend.apirest.pojo.response.get.PacsLoginResponse;
import cl.ips.consulta.pacs.backend.apirest.util.JdbcTemplateUtils;

@Component
public class PacsLoginRepository {

	private JdbcTemplateUtils jdbcUtils;

	public static final Logger LOG_ERROR = LoggerFactory.getLogger("error");
	private static final String SPFIND = "spLogin";
	private static final String RUT = "iRUN";
	private static final String SERIE = "iNumeroSerieRUN";
	private static final String DV = "cDV";
	private static final String FECHANACIMIENTO = "dFechaNacimiento";
	private static final String EDAD = "edad";
	private static final String FECHADEFUNCION = "dFechaDefuncion";
	private static final String SEXO = "cSexo";	
	private static final String NOMBRES = "vcNombres";
	private static final String APELLIDOPATERNO = "vcApellidoPaterno";
	private static final String APELLIDOMATERNO = "vcApellidoMaterno";
	private static final String BENEFICIARIOPACS = "cBeneficioPacs";

	@Autowired
	private void setJdbcUtils(JdbcTemplateUtils jdbcUtils) {
		this.jdbcUtils = jdbcUtils;
	}

	@Autowired
	private Properties properties;

	public PacsLoginResponse findBeneficiario(Map<String, Object> params) {
		LOG_ERROR.info("Parametros Login: ");
		LOG_ERROR.info("params: {}", params);
		
		Map<String, Object> dataBD = jdbcUtils.callStoreProcedure(properties.getProperties().get(SPFIND), params);
		
		//List<PacsLoginResponse> listaParametria = new ArrayList<>();
		PacsLoginResponse dataLogin = new PacsLoginResponse();
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> salida = (List<Map<String, Object>>) dataBD.get("#result-set-1");
		
		if(!salida.isEmpty()) {
			for (int i = 0; i < salida.size(); i++) {	
				
				System.out.println("salida " + salida.get(i).toString());
				
				Map<String, Object> parametriaBD = salida.get(i);

				
				dataLogin.setiRUN(parametriaBD.get(RUT).toString());
				dataLogin.setcDV(parametriaBD.get(DV).toString());
		
				dataLogin.setdFechaNacimiento(parametriaBD.get(FECHANACIMIENTO).toString());
				dataLogin.setEdad(parametriaBD.get(EDAD).toString());
				
				dataLogin.setdFechaDefuncion(parametriaBD.get(FECHADEFUNCION).toString());
				
				dataLogin.setcSexo(parametriaBD.get(SEXO).toString());
				dataLogin.setiNumeroSerieRUN(parametriaBD.get(SERIE).toString());
				dataLogin.setVcNombres(parametriaBD.get(NOMBRES).toString());
				dataLogin.setVcApellidoPaterno(parametriaBD.get(APELLIDOPATERNO).toString());
				dataLogin.setVcApellidoMaterno(parametriaBD.get(APELLIDOMATERNO).toString());
				dataLogin.setcBeneficioPacs(parametriaBD.get(BENEFICIARIOPACS).toString());
				//listaParametria.add(dataLogin);
			}
		}
		return dataLogin;

	}

}
