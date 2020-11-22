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
	
	public int[] quicksortRecurivo(int numeros[]) {
		return quicksort2(numeros, 0, numeros.length-1);
	}
	
	public int[] quicksort2(int numeros[], int izq, int der){
		if(izq >= der) {
			return numeros;
		}
		int i = izq, d = der;
		if(izq != der) {
			int pivote;
			int aux;
			pivote = izq;
			while(izq != der) {
				while(numeros[der] >= numeros[pivote] && izq < der) {
					der--;
				}
				while(numeros[izq] < numeros[pivote] && izq < der) {
					izq++;
				}
				if(der!=izq) {
					aux = numeros[der];
					numeros[der] = numeros[izq];
					numeros[izq] = aux;
				}
			}
			if(izq == der) {
				quicksort2(numeros, i, izq-1);
				quicksort2(numeros, izq + 1, d);
			}
		}else {
			return numeros;
		}
		return numeros;
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
