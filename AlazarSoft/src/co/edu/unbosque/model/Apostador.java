/**
 * Paquete modelo
 */
package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ApostadorDAO;

/**
 * Clase apostador
 */
public class Apostador {

	/**
	 * Asociacion clase ApostadorDAO
	 */
	private ApostadorDAO apostadorDao;

	/**
	 * Constructor vacio
	 */
	public Apostador() {
		apostadorDao = new ApostadorDAO();
	}

	/**
	 * Este método se encarga de generar una matriz para la tabla en donde se
	 * mostrará la información de los apostadores.
	 * 
	 * @return retorna la matriz con la información de los apostadores;
	 */
	public String[][] generarTablaApostador() {
		String salida[][] = new String[apostadorDao.getListaApostador().size()][5];
		for (int i = 0; i < apostadorDao.getListaApostador().size(); i++) {
			salida[i][0] = apostadorDao.getListaApostador().get(i).getCedula();
			salida[i][1] = apostadorDao.getListaApostador().get(i).getNombre();
			salida[i][2] = apostadorDao.getListaApostador().get(i).getCelular();
			salida[i][3] = apostadorDao.getListaApostador().get(i).getDireccion();
			salida[i][4] = apostadorDao.getListaApostador().get(i).getSede();
		}
		return salida;
	}

	/**
	 * Este método se encarga de verificar de que no se ingrese ningún otro tipo de
	 * caracter que no sea número.
	 * 
	 * @param numero, es el numero a verificar; celular != null.
	 * @return retorna true si se ha digitado correctamente el número, en caso
	 *         contrario retornará false.
	 */
	public boolean soloNumeros(String numero) {
		for (int i = 0; i < numero.length(); i++) {
			char aux = numero.charAt(i);
			int digito = aux - '0';
			if (digito > 9 || digito < 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Este método se encarga de verificar correctamente el formato del celular a
	 * registrar. <b>pre</b>Que exista el número telefónico a verificar<br>
	 * <b>post</b>Atrapa la exepción correspondiente<br>
	 * 
	 * @param celular, es el celular a verificar; celular != null.
	 * @throws CelularException Excepción celular.
	 */
	
	public void verificarCelular(String celular) throws CelularException {
		if (!soloNumeros(celular)) {
			throw new CelularException("Ingresó un caracter no permitido para el teléfono");
		} else if (celular.length() == 10 && celular.charAt(0) == '3') {
		} else {
			throw new CelularException("Número telefónico incorrecto");
		}

	}
	/**
	 * Este método se encarga de verificar correctamente el formato de la cédula a
	 * registrar. <b>pre</b>Que exista la cédula a verificar<br>
	 * <b>post</b>Atrapa la exepción correspondiente<br>
	 * 
	 * @param cedula, es la cédula a verificar; cedula != null.
	 * @throws CedulaException Excepción cedula.
	 */
	
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
