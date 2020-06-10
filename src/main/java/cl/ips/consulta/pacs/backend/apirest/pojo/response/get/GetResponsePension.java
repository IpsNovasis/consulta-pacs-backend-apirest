package cl.ips.consulta.pacs.backend.apirest.pojo.response.get;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import cl.ips.consulta.pacs.backend.apirest.pojo.response.DetailResponse;

public class GetResponsePension {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({ "success", "return", "body" })
	@JsonProperty("success")
	private boolean success;
	@JsonProperty("return")
	private DetailResponse detailResponse;
	@JsonProperty("pensionado")
	private PacsPensionResponse pensionado;
	
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
	public PacsPensionResponse getPensionado() {
		return pensionado;
	}
	public void setPensionado(PacsPensionResponse pensionado) {
		this.pensionado = pensionado;
	}
 
	
	
	
	
}
