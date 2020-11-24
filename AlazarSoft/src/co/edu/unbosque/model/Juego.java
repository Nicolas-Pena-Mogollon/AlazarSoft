/**
 * Paquete modelo
 */
package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.ArchivoConfiguracionCasaApuestas;
import co.edu.unbosque.model.persistence.JuegosDAO;
import co.edu.unbosque.model.persistence.JuegosDTO;

/**
 * Clase Juego
 */
public class Juego {

	private JuegosDAO juegosDAO;
	private ArchivoConfiguracionCasaApuestas archivo;

	/**
	 * Constructor vacio
	 */
	public Juego() {
		this.juegosDAO = new JuegosDAO();
		this.archivo = new ArchivoConfiguracionCasaApuestas();
	}

	/**
	 * Este método se encarga de verificar de que no sobrepase el presupuesto total.
	 * 
	 * @param lista,         es la lista de juegos; lista != null.
	 * @param presupuesto,es el presupuesto total de la casa de apuestas;
	 *                       presupuesto != null.
	 * @return retorna true si se ha sobrepasado el presupuesto total, retorna false
	 *         si no ha sobrepasado el presupuesto total.
	 */
	public boolean verificarPresupuesto(ArrayList<JuegosDTO> lista, long presupuesto) {
		boolean verificar = false;
		long suma = 0;
		long total = 0;
		String[] datos = archivo.leerConfiguracionCasaApuestas();
		long maximo = Long.parseLong(datos[2]);
		for (int i = 0; i < lista.size(); i++) {
			suma += lista.get(i).getPresupuesto();
		}
		total = suma + presupuesto;
		System.out.println(total);
		System.out.println(suma);
		if (total > maximo) {
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;
	}

	/**
	 * Este método indica el presupuesto disponoble de la casa de apuestas.
	 * 
	 * @param lista, es la lista de juegos; lista != null.
	 * @return retorna el presupuesto disponible de la casa de apuestas.
	 */

	public long presupuestoDisponible(ArrayList<JuegosDTO> lista) {
		long presupuesto = 0;
		long suma = 0;
		String[] datos = archivo.leerConfiguracionCasaApuestas();
		long maximo = Long.parseLong(datos[2]);
		for (int i = 0; i < lista.size(); i++) {
			suma += lista.get(i).getPresupuesto();
		}
		presupuesto = maximo - suma;
		return presupuesto;
	}

	/**
	 * @return the juegosDAO
	 */
	public JuegosDAO getJuegosDAO() {
		return juegosDAO;
	}

	/**
	 * @param juegosDAO the juegosDAO to set
	 */
	public void setJuegosDAO(JuegosDAO juegosDAO) {
		this.juegosDAO = juegosDAO;
	}

}
