package cl.ips.consulta.pacs.backend.apirest.validate;

import java.util.HashMap;
import java.util.Map;

import cl.ips.consulta.pacs.backend.apirest.exception.ResponseException;
import cl.ips.consulta.pacs.backend.apirest.util.ValidateUtil;

public class ValidateDelete {

	private static final String EXPRECOM = "[^A-Za-z0-9]";
	private static final String LETTERS = "[^A-Za-z]";
	private static final String RUT = "pkRutDistribuidor";
	private static final String ESTADO = "pkEstadoVehiculo";
	private static final String MARCA = "PkCodMarcaVehiculo";
	private static final String USER = "cUsuarioModificacion";
	private static final String ERROR = "cErrorNumber";
	private static final String DESERROR = "cErrorMessage";

	public static Map<String, Object> validaData(String dealerDocumentNumber, String vehicleStatus, Integer vehicleBrandCode, String userModification)
			throws  ResponseException {

		String rutDealer= "";
		if(dealerDocumentNumber.equalsIgnoreCase("TODOS")) {
			rutDealer= dealerDocumentNumber.toUpperCase();
		}else {
			rutDealer = ValidateUtil.validacionRut(dealerDocumentNumber);
		}
		ValidateUtil.validaData(ESTADO, vehicleStatus, 5, LETTERS, true);
		ValidateUtil.validaData(USER, userModification, 8, EXPRECOM, true);

		Map<String, Object> params = new HashMap<>();
		params.put(RUT, rutDealer);
		params.put(ESTADO,vehicleStatus);
		params.put(MARCA, vehicleBrandCode);
		params.put(USER, userModification);
		params.put(DESERROR, null);
		params.put(ERROR, null);

		return params;
	}

	private ValidateDelete() {

	}
}
