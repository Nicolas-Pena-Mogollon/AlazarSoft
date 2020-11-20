package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ApostadorDAO;

public class Apostador {

	/**
	 * Asociacion clase ApostadorDAO
	 */
	private ApostadorDAO apostadorDao;

	public Apostador() {
		apostadorDao = new ApostadorDAO();
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
			throw new CelularException("Ingres� un caracter no permitido para el tel�fono");
		} else if (celular.length() == 10 && celular.charAt(0) == '3') {
		} else {
			throw new CelularException("N�mero telef�nico incorrecto");
		}

	}

	public void verificarCedula(String cedula) throws CedulaException {
		if (!soloNumeros(cedula)) {
			throw new CedulaException("Ingres� un caracter no permitido para la cedula");
		} else if (cedula.length() == 10) {
		} else {
			throw new CedulaException("Cedula incorrecta");
		}
	}

	/**
	 * @return the apostadorDao
	 */
	public ApostadorDAO getApostadorDao() {
		return apostadorDao;
	}

	/**
	 * @param apostadorDao the apostadorDao to set
	 */
	public void setApostadorDao(ApostadorDAO apostadorDao) {
		this.apostadorDao = apostadorDao;
	}

}
