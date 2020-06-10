package cl.ips.consulta.pacs.backend.apirest.pojo.request;

public class PacsLoginEntity {
 
	private Long iRUN;
 	private String cDV;
 	private String FechaNacimiento;
 	private int edad;
 	private String FechaDefuncion;
 	private String cSexo;
 	private String iNumeroSerieRUN;
	private String vcNombres;
	private String vcApellidoPaterno;
	private String vcApellidoMaterno;
	private String cBeneficioPacs;
	public Long getiRUN() {
		return iRUN;
	}
	public void setiRUN(Long iRUN) {
		this.iRUN = iRUN;
	}
	public String getcDV() {
		return cDV;
	}
	public void setcDV(String cDV) {
		this.cDV = cDV;
	}
	public String getFechaNacimiento() {
		return FechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getFechaDefuncion() {
		return FechaDefuncion;
	}
	public void setFechaDefuncion(String fechaDefuncion) {
		FechaDefuncion = fechaDefuncion;
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
	public String getcBeneficioPacs() {
		return cBeneficioPacs;
	}
	public void setcBeneficioPacs(String cBeneficioPacs) {
		this.cBeneficioPacs = cBeneficioPacs;
	}
	
	
	

}
