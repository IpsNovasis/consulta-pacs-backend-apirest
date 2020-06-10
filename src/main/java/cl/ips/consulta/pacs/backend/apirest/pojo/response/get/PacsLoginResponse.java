package cl.ips.consulta.pacs.backend.apirest.pojo.response.get;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PacsLoginResponse {

	@JsonProperty("iRUN")
	private String iRUN;
	@JsonProperty("cDV")
	private String cDV;
	@JsonProperty("dFechaNacimiento")
	private String dFechaNacimiento;
	@JsonProperty("edad")
	private String edad;
	@JsonProperty("dFechaDefuncion")
	private String dFechaDefuncion;
	@JsonProperty("cSexo")
	private String cSexo;
	@JsonProperty("iNumeroSerieRUN")
	private String iNumeroSerieRUN;
	@JsonProperty("vcNombres")
	private String vcNombres;
	@JsonProperty("vcApellidoPaterno")
	private String vcApellidoPaterno;
	@JsonProperty("vcApellidoMaterno")
	private String vcApellidoMaterno;
	@JsonProperty("cBeneficioPacs")
	private String cBeneficioPacs;
	
	public String getcBeneficioPacs() {
		return cBeneficioPacs;
	}
	public void setcBeneficioPacs(String cBeneficioPacs) {
		this.cBeneficioPacs = cBeneficioPacs;
	}
	public String getiRUN() {
		return iRUN;
	}
	public void setiRUN(String iRUN) {
		this.iRUN = iRUN;
	}
	public String getcDV() {
		return cDV;
	}
	public void setcDV(String cDV) {
		this.cDV = cDV;
	}
	public String getdFechaNacimiento() {
		return dFechaNacimiento;
	}
	public void setdFechaNacimiento(String dFechaNacimiento) {
		this.dFechaNacimiento = dFechaNacimiento;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getdFechaDefuncion() {
		return dFechaDefuncion;
	}
	public void setdFechaDefuncion(String dFechaDefuncion) {
		this.dFechaDefuncion = dFechaDefuncion;
	}
	public String getcSexo() {
		return cSexo;
	}
	public void setcSexo(String cSexo) {
		this.cSexo = cSexo;
	}
	public String getiNumeroSerieRUN() {
		return iNumeroSerieRUN;
	}
	public void setiNumeroSerieRUN(String iNumeroSerieRUN) {
		this.iNumeroSerieRUN = iNumeroSerieRUN;
	}
	public String getVcNombres() {
		return vcNombres;
	}
	public void setVcNombres(String vcNombres) {
		this.vcNombres = vcNombres;
	}
	public String getVcApellidoPaterno() {
		return vcApellidoPaterno;
	}
	public void setVcApellidoPaterno(String vcApellidoPaterno) {
		this.vcApellidoPaterno = vcApellidoPaterno;
	}
	public String getVcApellidoMaterno() {
		return vcApellidoMaterno;
	}
	public void setVcApellidoMaterno(String vcApellidoMaterno) {
		this.vcApellidoMaterno = vcApellidoMaterno;
	}
	

	
	
	
}
