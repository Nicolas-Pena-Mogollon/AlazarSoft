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
	 * Este m�todo se encarga de generar una matriz para la tabla en donde se
	 * mostrar� la informaci�n de los apostadores.
	 * 
	 * @return retorna la matriz con la informaci�n de los apostadores;
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
	 * Este m�todo se encarga de verificar de que no se ingrese ning�n otro tipo de
	 * caracter que no sea n�mero.
	 * 
	 * @param numero, es el numero a verificar; celular != null.
	 * @return retorna true si se ha digitado correctamente el n�mero, en caso
	 *         contrario retornar� false.
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
	 * Este m�todo se encarga de verificar correctamente el formato del celular a
	 * registrar. <b>pre</b>Que exista el n�mero telef�nico a verificar<br>
	 * <b>post</b>Atrapa la exepci�n correspondiente<br>
	 * 
	 * @param celular, es el celular a verificar; celular != null.
	 * @throws CelularException Excepci�n celular.
	 */
	
	public void verificarCelular(String celular) throws CelularException {
		if (!soloNumeros(celular)) {
			throw new CelularException("Ingres� un caracter no permitido para el tel�fono");
		} else if (celular.length() == 10 && celular.charAt(0) == '3') {
		} else {
			throw new CelularException("N�mero telef�nico incorrecto");
		}

	}
	/**
	 * Este m�todo se encarga de verificar correctamente el formato de la c�dula a
	 * registrar. <b>pre</b>Que exista la c�dula a verificar<br>
	 * <b>post</b>Atrapa la exepci�n correspondiente<br>
	 * 
	 * @param cedula, es la c�dula a verificar; cedula != null.
	 * @throws CedulaException Excepci�n cedula.
	 */
	
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
