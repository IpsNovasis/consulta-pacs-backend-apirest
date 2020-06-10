package cl.ips.consulta.pacs.backend.apirest.pojo.response.get;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import cl.ips.consulta.pacs.backend.apirest.pojo.response.DetailResponse;

public class GetResponseElegibilidad {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({ "success", "return", "body" })
	@JsonProperty("success")
	private boolean success;
	@JsonProperty("return")
	private DetailResponse detailResponse;
	@JsonProperty("body")
	private List<PacsElegibilidadResponse> body;
	
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
	public List<PacsElegibilidadResponse> getBody() {
		return body;
	}
	public void setBody(List<PacsElegibilidadResponse> body) {
		this.body = body;
	}
	
	

}