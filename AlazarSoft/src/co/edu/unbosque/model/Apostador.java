package co.edu.unbosque.model;

public class Apostador {
	
	public Apostador() {
		
	}
	
	public boolean soloNumeros(String celular) {
		for (int i = 0; i < celular.length(); i++) {
			char aux = celular.charAt(i);
			int digito = aux - '0';
			if (digito > 9 || digito < 0) {
				return false;
			}
		}
		return true;
	}

	public String verificarCelular(String celular) throws CelularException {
		String mensaje = "";
		try {
			if (!soloNumeros(celular)) {
				throw new CelularException("Ingresó un caracter no permitido para el teléfono");
			} else if (celular.length() == 10 && celular.charAt(0) == '3') {
				mensaje = celular;
			} else {
				throw new CelularException("Número telefónico incorrecto");
			}
		} catch (CelularException e) {
			mensaje = e.getMessage();
		}

		return mensaje;
	}

	public String verificarCedula(String cedula) throws CedulaException {
		String mensaje = "";
		try {
			if (!soloNumeros(cedula)) {
				throw new CedulaException("Ingresó un caracter no permitido para la cedula");
			} else if (cedula.length() == 10) {
				mensaje = cedula;
			} else {
				throw new CedulaException("Cedula incorrecta");
			}
		} catch (CedulaException e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

}
