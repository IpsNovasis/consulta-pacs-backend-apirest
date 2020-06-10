package cl.ips.consulta.pacs.backend.apirest.pojo.response.get;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import cl.ips.consulta.pacs.backend.apirest.pojo.response.DetailResponse;

public class GetResponseLogin {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({ "success", "return", "body" })
	@JsonProperty("success")
	private boolean success;
	@JsonProperty("return")
	private DetailResponse detailResponse;
	@JsonProperty("persona")	
	private PacsLoginResponse persona;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public DetailResponse getDetailResponse() {
		return detailResponse;
	}
	public void setDetailResponse(DetailResponse detailResponse) {
		this.detailResponse = detailResponse;
	}
	public PacsLoginResponse getPersona() {
		return persona;
	}
	public void setPersona(PacsLoginResponse persona) {
		this.persona = persona;
	}

	

	

	
}