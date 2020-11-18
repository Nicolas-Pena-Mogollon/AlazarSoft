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

	public void verificarCelular(String celular) throws CelularException {
		if (!soloNumeros(celular)) {
			throw new CelularException("Ingresó un caracter no permitido para el teléfono");
		} else if (celular.length() == 10 && celular.charAt(0) == '3') {
		} else {
			throw new CelularException("Número telefónico incorrecto");
		}

	}

	public void verificarCedula(String cedula) throws CedulaException {
		if (!soloNumeros(cedula)) {
			throw new CedulaException("Ingresó un caracter no permitido para la cedula");
		} else if (cedula.length() == 10) {
		} else {
			throw new CedulaException("Cedula incorrecta");
		}
	}

}
