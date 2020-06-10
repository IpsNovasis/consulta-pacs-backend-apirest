package cl.ips.consulta.pacs.backend.apirest.pojo.response.get;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PacsElegibilidadResponse {

		@JsonProperty("cPeriodo")		
		private String cPeriodo;
		@JsonProperty("iRUN")		
		private int iRUN;
		@JsonProperty("vcNombres")
		private String vcNombres;
		@JsonProperty("vcApellidoPaterno")
		private String vcApellidoPaterno;
		@JsonProperty("vcApellidoMaterno")
		private String vcApellidoMaterno;
		@JsonProperty("iIDBeneficio")
		private int iIDBeneficio;
		@JsonProperty("vcDescripcion")
		private String vcDescripcion;
		@JsonProperty("vcCriterioEvaluado")
		private String vcCriterioEvaluado;
		@JsonProperty("iCodigoMensaje")
		private int iCodigoMensaje;
		@JsonProperty("vcDetalleMensaje")
		private String vcDetalleMensaje;
		@JsonProperty("cResultadoBeneficio")
		private String cResultadoBeneficio;
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
		public int getiIDBeneficio() {
			return iIDBeneficio;
		}
		public void setiIDBeneficio(int iIDBeneficio) {
			this.iIDBeneficio = iIDBeneficio;
		}
		public String getVcDescripcion() {
			return vcDescripcion;
		}
		public void setVcDescripcion(String vcDescripcion) {
			this.vcDescripcion = vcDescripcion;
		}
		public String getVcCriterioEvaluado() {
			return vcCriterioEvaluado;
		}
		public void setVcCriterioEvaluado(String vcCriterioEvaluado) {
			this.vcCriterioEvaluado = vcCriterioEvaluado;
		}
		public int getiCodigoMensaje() {
			return iCodigoMensaje;
		}
		public void setiCodigoMensaje(int iCodigoMensaje) {
			this.iCodigoMensaje = iCodigoMensaje;
		}
		public String getVcDetalleMensaje() {
			return vcDetalleMensaje;
		}
		public void setVcDetalleMensaje(String vcDetalleMensaje) {
			this.vcDetalleMensaje = vcDetalleMensaje;
		}
		public String getcResultadoBeneficio() {
			return cResultadoBeneficio;
		}
		public void setcResultadoBeneficio(String cResultadoBeneficio) {
			this.cResultadoBeneficio = cResultadoBeneficio;
		}
		
		
		
		
		
		


}
