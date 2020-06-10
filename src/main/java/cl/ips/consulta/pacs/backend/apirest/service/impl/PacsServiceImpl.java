package cl.ips.consulta.pacs.backend.apirest.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ips.consulta.pacs.backend.apirest.exception.ResponseException;
import cl.ips.consulta.pacs.backend.apirest.pojo.response.get.PacsElegibilidadResponse;
import cl.ips.consulta.pacs.backend.apirest.pojo.response.get.PacsLoginResponse;
import cl.ips.consulta.pacs.backend.apirest.pojo.response.get.PacsPensionResponse;
import cl.ips.consulta.pacs.backend.apirest.repository.PacsElegibilidadRepository;
import cl.ips.consulta.pacs.backend.apirest.repository.PacsLoginRepository;
import cl.ips.consulta.pacs.backend.apirest.repository.PacsPensionRepository;
import cl.ips.consulta.pacs.backend.apirest.service.PacsService;

@Service
public class PacsServiceImpl implements PacsService {

	@Autowired
	private PacsLoginRepository pacsLoginRepository;

	@Override
	public PacsLoginResponse getBeneficiarioParametrics(Map<String, Object> params)
			throws IOException, ResponseException, ParseException {

		return pacsLoginRepository.findBeneficiario(params);
	}

	@Autowired
	private PacsElegibilidadRepository pacsElegibilidadRepository;

	@Override
	public List<PacsElegibilidadResponse> getelegibilidadParametrics(Map<String, Object> params)
			throws IOException, ResponseException, ParseException {
		// TODO Auto-generated method stub
		return pacsElegibilidadRepository.findElegibilidad(params);
	}

	@Autowired
	private PacsPensionRepository pacsPensionRepository;

	@Override
	public PacsPensionResponse getpensionParametrics(Map<String, Object> params)
			throws IOException, ResponseException, ParseException {
		// TODO Auto-generated method stub
		return pacsPensionRepository.findPensiones(params);

	}

}
