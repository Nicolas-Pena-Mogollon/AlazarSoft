/**
 * Paquete persistencia
 */
package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

/**
 * Clase JuegosDAO
 */
public class JuegosDAO {

	private ArrayList<JuegosDTO> listaJuegos;
	private ArchivoJuegos archivoJuegos;

	/**
	 * Constructor vacio
	 */
	public JuegosDAO() {
		this.archivoJuegos = new ArchivoJuegos();
		this.archivoJuegos.asignarRutaArchivoJuegos(archivoJuegos.getRUTA_JUEGOS());
		this.listaJuegos = this.archivoJuegos.leerArchivo(this.archivoJuegos.getFileArchivo());
	}

	/**
	 * Este método se encarga de buscar dentro del arrayList de juegos el juego
	 * exacta.
	 * 
	 * @param nombre, es la nombre del juego; nombre != null.
	 * @return retorna el juego.
	 */

	public JuegosDTO buscarJuego(String nombre) {
		JuegosDTO encontrado = null;
		for (int i = 0; i < listaJuegos.size(); i++) {
			if (nombre.equals(listaJuegos.get(i).getNombreJuego())) {
				encontrado = listaJuegos.get(i);
			}
		}
		return encontrado;
	}

	/**
	 * Este método se encarga de registrar el juego.
	 * 
	 * @param nombreJuego, es el nombre del juego a registrar; nombreJuego != null.
	 * @param tipoJuego,   es el tipo del juego a registrar; tipoJuego != null.
	 * @param presupuesto, es el presupuesto destinado para el juego; presupuesto =!
	 *                     null.
	 * @return retorna true si el registro se ha realizado correctamente, retorna
	 *         false si el juego ya se encuentra registrado;
	 */

	public boolean agregarJuego(String nombreJuego, String tipoJuego, long presupuesto) {
		boolean verificar = false;
		JuegosDTO juegos;
		juegos = new JuegosDTO(nombreJuego, tipoJuego, presupuesto);
		if (buscarJuego(nombreJuego) == null) {
			listaJuegos.add(juegos);
			archivoJuegos.escribirArchivo(listaJuegos);
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;
	}

	/**
	 * @return the listaJuegos
	 */
	public ArrayList<JuegosDTO> getListaJuegos() {
		return listaJuegos;
	}

	/**
	 * @param listaJuegos the listaJuegos to set
	 */
	public void setListaJuegos(ArrayList<JuegosDTO> listaJuegos) {
		this.listaJuegos = listaJuegos;
	}

}
