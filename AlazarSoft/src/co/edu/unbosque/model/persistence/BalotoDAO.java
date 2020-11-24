/**
 * Paquete persistencia
 */
package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase BalotoDAO
 */
public class BalotoDAO {

	private ArchivoApuesta archivo;
	private ArrayList<BalotoDTO> listaBaloto;

	/**
	 * Constructor vacio
	 */

	public BalotoDAO() {
		this.archivo = new ArchivoApuesta();
		this.archivo.asignarRutaArchivoBaloto(this.archivo.getRUTA_BALOTO());
		this.listaBaloto = this.archivo.leerArchivoBaloto(this.archivo.getFileBaloto());
	}

	/**
	 * Este método se encarga de buscar dentro del arrayList de apuestasBaloto la
	 * apuesta exacta.
	 * 
	 * @param cedula, es la cedula del apostador; cedula != null.
	 * @param fecha,  es la fecha de la apuesta; fecha != null.
	 * @return retorna la apuesta.
	 */

	public BalotoDTO buscarApuesta(String cedula, Date fecha) {
		BalotoDTO encontrado = null;
		for (int i = 0; i < listaBaloto.size(); i++) {
			if (listaBaloto.get(i).getCedula().equals(cedula) && listaBaloto.get(i).getFecha().equals(fecha)) {
				encontrado = listaBaloto.get(i);
			}
		}
		return encontrado;
	}

	/**
	 * Este método se encarga de crear la apuesta con todos los datos
	 * correspondientes.
	 * 
	 * @param nombre,       es el nombre de la sede en donde se realiza la apuesta;
	 *                      nombre != null.
	 * @param cedula,       es la cedula del apostador; cedula != null.
	 * @param fecha,        es la fecha de la apuesta; fecha != null.
	 * @param valorApuesta, es el precio de la apuesta; valorApuesta != null.
	 * @param numeroJuego,  es el número de juego del baloto; numeroJuego != null.
	 * @return retorna true si el registro se ha realizado correctamente.
	 */

	public boolean crearApuestas(String nombre, String cedula, Date fecha, double valorApuesta, String numeroJuego) {
		BalotoDTO balotoDTO;
		balotoDTO = new BalotoDTO(nombre, cedula, fecha, valorApuesta, numeroJuego);
		listaBaloto.add(balotoDTO);
		archivo.escribirArchivoBaloto(listaBaloto);
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
		BalotoDTO balotoDTO = buscarApuesta(cedula, fecha);
		if (balotoDTO != null) {
			listaBaloto.remove(balotoDTO);
			archivo.escribirArchivoBaloto(listaBaloto);
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
		for (int i = 0; i < listaBaloto.size(); i++) {
			if (cedula.equals(listaBaloto.get(i).getCedula()) && fecha.equals(listaBaloto.get(i).getFecha())) {
				listaBaloto.get(i).setNombreSede(nombreSede);
				listaBaloto.get(i).setValorApuesta(valorApuesta);
				archivo.escribirArchivoBaloto(listaBaloto);
				return verificar = true;
			} else {
				verificar = false;
			}
		}
		return verificar;
	}

	/**
	 * @return the archivo
	 */
	public ArchivoApuesta getArchivo() {
		return archivo;
	}

	/**
	 * @param archivo the archivo to set
	 */
	public void setArchivo(ArchivoApuesta archivo) {
		this.archivo = archivo;
	}

	/**
	 * @return the listaBaloto
	 */
	public ArrayList<BalotoDTO> getListaBaloto() {
		return listaBaloto;
	}

	/**
	 * @param listaBaloto the listaBaloto to set
	 */
	public void setListaBaloto(ArrayList<BalotoDTO> listaBaloto) {
		this.listaBaloto = listaBaloto;
	}

}
