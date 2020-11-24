/**
 * Paquete persistencia
 */
package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase SuperastroDAO
 */
public class SuperastroDAO {

	private ArrayList<SuperastroDTO> listaSuperastro;
	private ArchivoApuesta archivo;

	/**
	 * Constructor vacio
	 */
	public SuperastroDAO() {
		this.archivo = new ArchivoApuesta();
		this.archivo.asignarRutaArchivoSupeastro(this.archivo.getRUTA_SUPERASTRO());
		this.listaSuperastro = this.archivo.leerArchivoSuperastro(this.archivo.getFileSuperastro());
	}

	/**
	 * Este método se encarga de buscar dentro del arrayList de apuestasSuperastro
	 * la apuesta exacta.
	 * 
	 * @param cedula, es la cedula del apostador; cedula != null.
	 * @param fecha,  es la fecha de la apuesta; fecha != null.
	 * @return retorna la apuesta.
	 */
	public SuperastroDTO buscarApuesta(String cedula, Date fecha) {
		SuperastroDTO encontrado = null;
		for (int i = 0; i < listaSuperastro.size(); i++) {
			if (listaSuperastro.get(i).getCedula().equals(cedula) && listaSuperastro.get(i).getFecha().equals(fecha)) {
				encontrado = listaSuperastro.get(i);
			}
		}
		return encontrado;
	}

	/**
	 * 
	 * @param nombre,       es el nombre de la sede en donde se realiza la apuesta;
	 *                      nombre != null.
	 * @param cedula,       es la cedula del apostador; cedula != null.
	 * @param fecha,        es la fecha de la apuesta; fecha != null.
	 * @param valorApuesta, es el precio de la apuesta; valorApuesta != null.
	 * @param numeroJuego,  es el número de juego del baloto; numeroJuego != null.
	 * @param signo,        es el signo de la apuesta a jugar; signo != null.
	 * @return retorna true si el registro se ha realizado correctamente.
	 */

	public boolean crearApuestas(String nombre, String cedula, Date fecha, double valorApuesta, String numeroJuego,
			String signo) {
		SuperastroDTO superastroDTO;
		superastroDTO = new SuperastroDTO(nombre, cedula, fecha, valorApuesta, numeroJuego, signo);
		listaSuperastro.add(superastroDTO);
		archivo.escribirArchivoSuperastro(listaSuperastro);
		return true;
	}

	/**
	 * Este método se encarga de eliminar la apuesta.
	 * 
	 * @param cedula, es la cedula del apostador; cedula != null.
	 * @param fecha,  es la fecha de la apuesta a borrar; fecha != null. @return,
	 *                retorna true si la apuesta se ha eliminado correctamente,
	 *                retorna false si la apuesta no se encuentra registrada.
	 */

	public boolean eliminarApuesta(String cedula, Date fecha) {
		boolean verificar = false;
		SuperastroDTO superastroDTO = buscarApuesta(cedula, fecha);
		if (superastroDTO != null) {
			listaSuperastro.remove(superastroDTO);
			archivo.escribirArchivoSuperastro(listaSuperastro);
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;
	}

	/**
	 * Este método se encarga de editar la apuesta.
	 * 
	 * @param cedula,       es la cedula del apostador; cedula != null.
	 * @param fecha,        es la fecha de la apuesta; fecha != null.
	 * @param nombreSede,   es el nombre de la sede en donde se realizo la apuesta;
	 *                      nombreSede != null.
	 * @param valorApuesta, es el valor de la apuesta; valorApuesta != null.
	 * @return retorna true si la moficicación se ha realizado correctamente,
	 *         retorna false si la apuesta no se encuentra registrada.
	 */

	public boolean editarApuesta(String cedula, Date fecha, String nombreSede, double valorApuesta) {
		boolean verificar = false;
		for (int i = 0; i < listaSuperastro.size(); i++) {
			System.out.println(fecha);
			System.out.println(listaSuperastro.get(i).getFecha());
			if (cedula.equals(listaSuperastro.get(i).getCedula()) && fecha.equals(listaSuperastro.get(i).getFecha())) {
				listaSuperastro.get(i).setNombreSede(nombreSede);
				listaSuperastro.get(i).setValorApuesta(valorApuesta);
				archivo.escribirArchivoSuperastro(listaSuperastro);
				return verificar = true;
			} else {
				verificar = false;
			}
		}
		return verificar;
	}

	/**
	 * @return the listaSuperastro
	 */
	public ArrayList<SuperastroDTO> getListaSuperastro() {
		return listaSuperastro;
	}

	/**
	 * @param listaSuperastro the listaSuperastro to set
	 */
	public void setListaSuperastro(ArrayList<SuperastroDTO> listaSuperastro) {
		this.listaSuperastro = listaSuperastro;
	}

}
