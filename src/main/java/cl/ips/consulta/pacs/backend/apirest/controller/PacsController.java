package cl.ips.consulta.pacs.backend.apirest.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.ips.consulta.pacs.backend.apirest.exception.ResponseException;
import cl.ips.consulta.pacs.backend.apirest.pojo.response.DetailResponse;
import cl.ips.consulta.pacs.backend.apirest.pojo.response.GenericResponse;
import cl.ips.consulta.pacs.backend.apirest.pojo.response.get.GetResponseElegibilidad;
import cl.ips.consulta.pacs.backend.apirest.pojo.response.get.GetResponseLogin;
import cl.ips.consulta.pacs.backend.apirest.pojo.response.get.GetResponsePension;
import cl.ips.consulta.pacs.backend.apirest.pojo.response.get.PacsElegibilidadResponse;
import cl.ips.consulta.pacs.backend.apirest.pojo.response.get.PacsLoginResponse;
import cl.ips.consulta.pacs.backend.apirest.pojo.response.get.PacsPensionResponse;
import cl.ips.consulta.pacs.backend.apirest.service.PacsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/pacs")
public class PacsController {

	public static final Logger LOG_SERVICE = LoggerFactory.getLogger("restservice");
	public static final Logger LOG_ERROR = LoggerFactory.getLogger("error");
	private static final String RUT = "iRUN";
	private static final String OK_REQUEST = "Respuesta exitosa";
	private static final String NOT_FOUND = "Beneficiario no existe en Base de datos";

	@Autowired
	private PacsService pacsService;

	@ControllerAdvice
	public class ErrorHandler {

		@ExceptionHandler(ResponseException.class)
		public ResponseEntity<GenericResponse> methodCatchResponseException(HttpServletRequest request,
				ResponseException e) {
			LOG_ERROR.error("Error info ", e);
			GenericResponse errorInfo = new GenericResponse(e);
			return new ResponseEntity<>(errorInfo,
					HttpStatus.valueOf(Integer.parseInt(e.getStatusResponseEnum().getStatusCode())));
		}

		@ExceptionHandler(Exception.class)
		public ResponseEntity<GenericResponse> methodCatchException(HttpServletRequest request, Exception e) {
			GenericResponse errorInfo = new GenericResponse(e);
			LOG_ERROR.error("BAD REQUEST : ", e);
			return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/login/{iRUN}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Validar autenticacion de beneficiario")
	@CrossOrigin
	@ApiResponses(value = { @ApiResponse(code = 200, message = "La solicitud fue exitosa", response = Integer[].class),
			@ApiResponse(code = 204, message = "No se encontraron registros", response = GenericResponse.class),
			@ApiResponse(code = 400, message = "Existen en errores de validación", response = GenericResponse.class),
			@ApiResponse(code = 500, message = "Ha ocurrido un error interno", response = GenericResponse.class) })

	public ResponseEntity<GetResponseLogin> loginBeneficiario(@PathVariable String iRUN)
			// , @PathVariable String iNumeroSerieRUN)
			throws IOException, ResponseException, ParseException {

		Map<String, Object> parametros = new HashMap<>();
		parametros.put(RUT, iRUN);
		// parametros.put(SERIE, iNumeroSerieRUN);

		PacsLoginResponse beneficiarioParametrics = null;
		beneficiarioParametrics = pacsService.getBeneficiarioParametrics(parametros);

		if (beneficiarioParametrics.getiRUN() == null) {
			// throw new ResponseException("No existen registros",
			// StatusResponseEnum.NO_CONTENT);
			GetResponseLogin respuesta = new GetResponseLogin();

			DetailResponse detailResponse = new DetailResponse(HttpStatus.NOT_FOUND.toString(), NOT_FOUND);

			respuesta.setPersona(null);
			respuesta.setSuccess(true);
			respuesta.setDetailResponse(detailResponse);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} else {

			GetResponseLogin respuesta = new GetResponseLogin();
			DetailResponse detailResponse = new DetailResponse(HttpStatus.OK.toString(), OK_REQUEST);

			respuesta.setPersona(beneficiarioParametrics);
			respuesta.setDetailResponse(detailResponse);
			respuesta.setSuccess(true);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/elegibilidad/{iRUN}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Obtiene Infofrmación del Resultado de Elegibilidad para Beneficios PACS")
	@CrossOrigin
	@ApiResponses(value = { @ApiResponse(code = 200, message = "La solicitud fue exitosa", response = Integer[].class),
			@ApiResponse(code = 204, message = "No se encontraron registros", response = GenericResponse.class),
			@ApiResponse(code = 400, message = "Existen en errores de validación", response = GenericResponse.class),
			@ApiResponse(code = 500, message = "Ha ocurrido un error interno", response = GenericResponse.class) })

	public ResponseEntity<GetResponseElegibilidad> elegibilidad(@PathVariable String iRUN)
			throws IOException, ResponseException, ParseException {

		Map<String, Object> parametros = new HashMap<>();
		parametros.put(RUT, iRUN);

		List<PacsElegibilidadResponse> elegibilidadParametrics = pacsService.getelegibilidadParametrics(parametros);

		if (elegibilidadParametrics.isEmpty()) {
			GetResponseElegibilidad respuesta = new GetResponseElegibilidad();
			DetailResponse detailResponse = new DetailResponse(HttpStatus.NOT_FOUND.toString(), NOT_FOUND);

			respuesta.setBody(null);
			respuesta.setSuccess(true);
			respuesta.setDetailResponse(detailResponse);
			return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
		} else {
			GetResponseElegibilidad respuesta = new GetResponseElegibilidad();
			DetailResponse detailResponse = new DetailResponse(HttpStatus.OK.toString(), OK_REQUEST);

			respuesta.setBody(elegibilidadParametrics);
			respuesta.setDetailResponse(detailResponse);
			respuesta.setSuccess(true);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);

		}
	}

	@GetMapping(value = "/pension/{iRUN}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Obtiene datos Asociados a los Valores de Pension y estado beneficio")
	@CrossOrigin
	@ApiResponses(value = { @ApiResponse(code = 200, message = "La solicitud fue exitosa", response = Integer[].class),
			@ApiResponse(code = 204, message = "No se encontraron registros", response = GenericResponse.class),
			@ApiResponse(code = 400, message = "Existen en errores de validación", response = GenericResponse.class),
			@ApiResponse(code = 500, message = "Ha ocurrido un error interno", response = GenericResponse.class) })

	public ResponseEntity<GetResponsePension> pension(@PathVariable String iRUN)
			throws IOException, ResponseException, ParseException {

		Map<String, Object> parametros = new HashMap<>();
		parametros.put(RUT, iRUN);

		PacsPensionResponse pensionParametrics = pacsService.getpensionParametrics(parametros);

		if (pensionParametrics.getiRUN() == 0) {
			GetResponsePension respuesta = new GetResponsePension();
			DetailResponse detailResponse = new DetailResponse(HttpStatus.NOT_FOUND.toString(), NOT_FOUND);

			respuesta.setPensionado(null);
			respuesta.setSuccess(true);
			respuesta.setDetailResponse(detailResponse);
			return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
		} else {
			GetResponsePension respuesta = new GetResponsePension();
			DetailResponse detailResponse = new DetailResponse(HttpStatus.OK.toString(), OK_REQUEST);

			respuesta.setPensionado(pensionParametrics);
			respuesta.setDetailResponse(detailResponse);
			respuesta.setSuccess(true);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);

		}
	}

}