package cl.ips.consulta.pacs.backend.apirest.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import cl.ips.consulta.pacs.backend.apirest.exception.ResponseException;
import cl.ips.consulta.pacs.backend.apirest.pojo.response.get.PacsElegibilidadResponse;
import cl.ips.consulta.pacs.backend.apirest.pojo.response.get.PacsLoginResponse;
import cl.ips.consulta.pacs.backend.apirest.pojo.response.get.PacsPensionResponse;

public interface PacsService {
	
	PacsLoginResponse getBeneficiarioParametrics(Map<String, Object> params) throws IOException, ResponseException, ParseException;

	List<PacsElegibilidadResponse> getelegibilidadParametrics(Map<String, Object> params) throws IOException, ResponseException, ParseException;

	PacsPensionResponse getpensionParametrics(Map<String, Object> params) throws IOException, ResponseException, ParseException;

}
