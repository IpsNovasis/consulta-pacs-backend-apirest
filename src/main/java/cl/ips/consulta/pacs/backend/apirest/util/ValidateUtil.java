package cl.ips.consulta.pacs.backend.apirest.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.node.ObjectNode;

import cl.ips.consulta.pacs.backend.apirest.exception.ResponseException;
import cl.ips.consulta.pacs.backend.apirest.exception.StatusResponseEnum;

public class ValidateUtil {

	public static void validaData(String campo, String valor, int largo, String expresion, boolean largoExacto) throws ResponseException {
		
		if (valor == null) {
			throw new ResponseException("Campo Nulo " + campo,
					StatusResponseEnum.PRECONDITION_FAILED, true);
		} else if (valor.equals("")) {
			throw new ResponseException("Campo Vacio " + campo,
					StatusResponseEnum.PRECONDITION_FAILED, true);
		} else if ((!largoExacto) && (valor.length() > largo)) {
			throw new ResponseException("Largo Maximo " + campo,
					StatusResponseEnum.PRECONDITION_FAILED, true);
		} else if (specialCharacter(valor, expresion) && (!expresion.equals(""))) {
			throw new ResponseException(
					"Tipo de campo inválido" + campo,
					StatusResponseEnum.PRECONDITION_FAILED, true);
		}
	}
	
	public static boolean specialCharacter(String value, String expresion) {
		Pattern pattern = Pattern.compile(expresion);
		Matcher matcher = pattern.matcher(value);
		return matcher.find();
	}
	
	public static boolean isNumeric(String string) {
		return string.matches("^[-+]?\\d+(\\.\\d+)?$");
	}
	
	public static void validaBody(ObjectNode body) throws ResponseException {
		if (body.isEmpty(null)) {
			throw new ResponseException("Body no presente",
					StatusResponseEnum.PRECONDITION_FAILED, true);
		}
	}
	
	public static String validacionRut(String rut ) throws ResponseException {
		boolean rutValido = false;
		String salidarut = "";
		try {
			if (rut!=null) {
				String rutEdit = rut.toUpperCase().replace(".", "").replace("-", "");
				Integer auxiliar = Integer.parseInt(rutEdit.substring(0, rutEdit.length() - 1));
				String dv = rutEdit.substring(rutEdit.length() - 1);
				salidarut=rutEdit.substring(0, rutEdit.length() - 1)+"-"+dv;
				Integer dvCalculado = obtenerSumaPorDigitos(invertirCadena(auxiliar.toString()));
				String dvStrCalculado = "";
				
				if(dvCalculado <10) {
					dvStrCalculado = dvCalculado.toString();
				}
				
				if(dvCalculado == 10) {
					dvStrCalculado = "K";
				}
				
				if(dvCalculado == 11) {
					dvStrCalculado = "0";
				}
				
				if(dvCalculado == 11) {
					dvStrCalculado = "0";
				}
				
				if(dvStrCalculado.equalsIgnoreCase(dv)) {
					rutValido = true;
				}
			}
			//				
		} catch (java.lang.NumberFormatException e) {
			throw new ResponseException("rut invalido: "+e.getMessage(),
					StatusResponseEnum.PRECONDITION_FAILED, true);
		}
		if (!rutValido) {
			throw new ResponseException("rut invalido",
					StatusResponseEnum.PRECONDITION_FAILED, true);
		}
		return 	salidarut;

		
	}
	
    public static String invertirCadena(String cadena) {
        String cadenaInvertida = "";
        StringBuilder bld = new StringBuilder();
        for (int x = cadena.length() - 1; x >= 0; x--) {
        	bld.append(cadena.charAt(x));
        }
        cadenaInvertida = bld.toString();
        return cadenaInvertida;
    }

    public static int obtenerSumaPorDigitos(String cadena) {
        int pivote = 2;
        int longitudCadena = cadena.length();
        int cantidadTotal = 0;
        int b = 1;
        for (int i = 0; i < longitudCadena; i++) {
            if (pivote == 8) {
                pivote = 2;
            }
            int temporal = Integer.parseInt("" + cadena.substring(i, b));
            b++;
            temporal *= pivote;
            pivote++;
            cantidadTotal += temporal;
        }
        cantidadTotal = 11 - cantidadTotal % 11;
        return cantidadTotal;
    }

	private ValidateUtil() {

	}
}
