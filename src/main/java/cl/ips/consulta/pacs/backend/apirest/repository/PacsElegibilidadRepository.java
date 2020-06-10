package cl.ips.consulta.pacs.backend.apirest.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.ips.consulta.pacs.backend.apirest.config.Properties;
import cl.ips.consulta.pacs.backend.apirest.pojo.response.get.PacsElegibilidadResponse;
import cl.ips.consulta.pacs.backend.apirest.util.JdbcTemplateUtils;

@Component
public class PacsElegibilidadRepository {

	private JdbcTemplateUtils jdbcUtils;

	public static final Logger LOG_ERROR = LoggerFactory.getLogger("error");
	private static final String SPFINDELI = "spMensajeriaPacs";
	private static final String CPERIODO = "cPeriodo";
	private static final String RUT = "iRUN";
	private static final String VCNOMBRES = "vcNombres";
	private static final String VCAPELLIDOPATERNO = "vcApellidoPaterno";
	private static final String VCAPELLIDOMATERNO = "vcApellidoMaterno";
	private static final String IIDBENEFICIO = "iIDBeneficio";
	private static final String VCDESCRIPCION = "vcDescripcion";
	private static final String VCCRITERIOEVALUADO = "vcCriterioEvaluado";
	private static final String ICODIGOMENSAJE = "iCodigoMensaje";
	private static final String VCDETALLEMENSAJE = "vcDetalleMensaje";
	private static final String CRESULTADOBENEFICIO = "cResultadoBeneficio";

	@Autowired
	private void setJdbcUtils(JdbcTemplateUtils jdbcUtils) {
		this.jdbcUtils = jdbcUtils;
	}

	@Autowired
	private Properties properties;

	public List<PacsElegibilidadResponse> findElegibilidad(Map<String, Object> params) {
		LOG_ERROR.info("Parametros Elegibilidad: ");
		LOG_ERROR.info("params: {}", params);

		Map<String, Object> dataBD = jdbcUtils.callStoreProcedure(properties.getProperties().get(SPFINDELI), params);

		List<PacsElegibilidadResponse> listaElegibilidad = new ArrayList<>();

		@SuppressWarnings("unchecked")

		List<Map<String, Object>> elegibilidad = (List<Map<String, Object>>) dataBD.get("#result-set-1");

		if (!elegibilidad.isEmpty()) {
			for (int i = 0; i < elegibilidad.size(); i++) {

				Map<String, Object> parametriaBD = elegibilidad.get(i);
				PacsElegibilidadResponse parametria = new PacsElegibilidadResponse();
				parametria.setcPeriodo(parametriaBD.get(CPERIODO).toString());
				parametria.setiRUN((int) parametriaBD.get(RUT));
				parametria.setVcNombres(parametriaBD.get(VCNOMBRES).toString());
				parametria.setVcApellidoPaterno(parametriaBD.get(VCAPELLIDOPATERNO).toString());
				parametria.setVcApellidoMaterno(parametriaBD.get(VCAPELLIDOMATERNO).toString());
				parametria.setiIDBeneficio((int) parametriaBD.get(IIDBENEFICIO));
				parametria.setVcDescripcion(parametriaBD.get(VCDESCRIPCION).toString());
				parametria.setVcCriterioEvaluado(parametriaBD.get(VCCRITERIOEVALUADO).toString());
				parametria.setiCodigoMensaje((int) parametriaBD.get(ICODIGOMENSAJE));
				parametria.setVcDetalleMensaje(parametriaBD.get(VCDETALLEMENSAJE).toString());
				parametria.setcResultadoBeneficio(parametriaBD.get(CRESULTADOBENEFICIO ).toString());
				
				
				
				//				parametria.setcPeriodo(parametriaBD.get(CPERIODO).toString());
//				parametria.setcResultadoBeneficioFijo(parametriaBD.get(CRESULTADOBENEFICIOFIJO).toString());
//				parametria.setcResultadoBeneficioVariabe(parametriaBD.get(CRESULTADOBENEFICIOVARIABE).toString());
//				parametria.setiCodigoMensaje(parametriaBD.get(ICODIGOMENSAJE).toString());
//				parametria.setiIDBeneficio(parametriaBD.get(IIDBENEFICIO).toString());
//				parametria.setiRUN(parametriaBD.get(RUT).toString());
//				parametria.setVcDescripcion(parametriaBD.get(VCDESCRIPCION).toString());
//				parametria.setVcDetalleMensaje(parametriaBD.get(VCDETALLEMENSAJE).toString());
				listaElegibilidad.add(parametria);

			}

		}
		return listaElegibilidad;
	}

}
