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
	
	public String[][] generarTablaApostador() {
		String salida[][]= new String[apostadorDao.getListaApostador().size()][5];
		for (int i = 0; i < apostadorDao.getListaApostador().size(); i++) {
			salida[i][0]=apostadorDao.getListaApostador().get(i).getCedula();
			salida[i][1]=apostadorDao.getListaApostador().get(i).getNombre();
			salida[i][2]=apostadorDao.getListaApostador().get(i).getCelular();
			salida[i][3]=apostadorDao.getListaApostador().get(i).getDireccion();
			salida[i][4]=apostadorDao.getListaApostador().get(i).getSede();
		}
		return salida;
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
