package cl.ips.consulta.pacs.backend.apirest.pojo.response.get;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PacsPensionResponse {
	
	@JsonProperty("cPeriodo")
	private String cPeriodo;
	@JsonProperty("iRUN")
	private int iRUN;
	@JsonProperty("cDV")
	private String cDV;
	@JsonProperty("dFechaPension")
	private String dFechaPension;
	@JsonProperty("iNumeroMesesCotizados")
	private int iNumeroMesesCotizados;
	@JsonProperty("cBonoReconoceDIPRECA")
	private String cBonoReconoceDIPRECA;
	@JsonProperty("cBonoReconoceCAPREDENA")
	private String cBonoReconoceCAPREDENA;
	@JsonProperty("iNumeroCotizacionesIPS")
	private int iNumeroCotizacionesIPS;
	@JsonProperty("nMontoIngreso")
	private BigDecimal nMontoIngreso;
	@JsonProperty("nValorUF")
	private BigDecimal nValorUF;
	@JsonProperty("dFechaValorUF")
	private String dFechaValorUF;
	@JsonProperty("cResultadoBeneficioFijo")
	private String cResultadoBeneficioFijo;
	@JsonProperty("cResultadoBeneficioVariabe")
	private String cResultadoBeneficioVariabe;
	public String getcPeriodo() {
		return cPeriodo;
	}
	public void setcPeriodo(String cPeriodo) {
		this.cPeriodo = cPeriodo;
	}
	public int getiRUN() {
		return iRUN;
	}
	public void setiRUN(int iRUN) {
		this.iRUN = iRUN;
	}
	public String getcDV() {
		return cDV;
	}
	public void setcDV(String cDV) {
		this.cDV = cDV;
	}
	public String getdFechaPension() {
		return dFechaPension;
	}
	public void setdFechaPension(String dFechaPension) {
		this.dFechaPension = dFechaPension;
	}
	public int getiNumeroMesesCotizados() {
		return iNumeroMesesCotizados;
	}
	public void setiNumeroMesesCotizados(int iNumeroMesesCotizados) {
		this.iNumeroMesesCotizados = iNumeroMesesCotizados;
	}
	public String getcBonoReconoceDIPRECA() {
		return cBonoReconoceDIPRECA;
	}
	public void setcBonoReconoceDIPRECA(String cBonoReconoceDIPRECA) {
		this.cBonoReconoceDIPRECA = cBonoReconoceDIPRECA;
	}
	public String getcBonoReconoceCAPREDENA() {
		return cBonoReconoceCAPREDENA;
	}
	public void setcBonoReconoceCAPREDENA(String cBonoReconoceCAPREDENA) {
		this.cBonoReconoceCAPREDENA = cBonoReconoceCAPREDENA;
	}
	public int getiNumeroCotizacionesIPS() {
		return iNumeroCotizacionesIPS;
	}
	public void setiNumeroCotizacionesIPS(int iNumeroCotizacionesIPS) {
		this.iNumeroCotizacionesIPS = iNumeroCotizacionesIPS;
	}
	public BigDecimal getnMontoIngreso() {
		return nMontoIngreso;
	}
	public void setnMontoIngreso(BigDecimal nMontoIngreso) {
		this.nMontoIngreso = nMontoIngreso;
	}
	public BigDecimal getnValorUF() {
		return nValorUF;
	}
	public void setnValorUF(BigDecimal nValorUF) {
		this.nValorUF = nValorUF;
	}
	public String getdFechaValorUF() {
		return dFechaValorUF;
	}
	public void setdFechaValorUF(String dFechaValorUF) {
		this.dFechaValorUF = dFechaValorUF;
	}
	public String getcResultadoBeneficioFijo() {
		return cResultadoBeneficioFijo;
	}
	public void setcResultadoBeneficioFijo(String cResultadoBeneficioFijo) {
		this.cResultadoBeneficioFijo = cResultadoBeneficioFijo;
	}
	public String getcResultadoBeneficioVariabe() {
		return cResultadoBeneficioVariabe;
	}
	public void setcResultadoBeneficioVariabe(String cResultadoBeneficioVariabe) {
		this.cResultadoBeneficioVariabe = cResultadoBeneficioVariabe;
	}
	

	
	
}
