/**
 * Paquete persistencia
 */
package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase MarcadoresDAO
 */
public class MarcadoresDAO {

	private ArrayList<MarcadoresDTO> listaMarcadores;
	private ArchivoApuesta archivo;

	/**
	 * Constructor vacio
	 */
	public MarcadoresDAO() {
		this.archivo = new ArchivoApuesta();
		this.archivo.asignarRutaArchivoMarcador(this.archivo.getRUTA_MARCADORES());
		this.listaMarcadores = this.archivo.leerArchivoMarcadores(this.archivo.getFileMarcador());
	}

	/**
	 * Este método se encarga de buscar dentro del arrayList de apuestasMarcadores
	 * la apuesta exacta.
	 * 
	 * @param cedula, es la cedula del apostador; cedula != null.
	 * @param fecha,  es la fecha de la apuesta; fecha != null.
	 * @return retorna la apuesta.
	 */
	public MarcadoresDTO buscarApuesta(String cedula, Date fecha) {
		MarcadoresDTO encontrado = null;
		for (int i = 0; i < listaMarcadores.size(); i++) {
			if (listaMarcadores.get(i).getCedula().equals(cedula) && listaMarcadores.get(i).getFecha().equals(fecha)) {
				encontrado = listaMarcadores.get(i);
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
	 * @param partido,      es el partido el cual se va a jugar; partido != null.
	 * @param resultado,    es el resultado del partido; resultado != null.
	 * @return retorna true si el registro se ha realizado correctamente.
	 */

	public boolean crearApuestas(String nombre, String cedula, Date fecha, double valorApuesta, String partido,
			String resultado) {
		MarcadoresDTO marcadoresDTO;
		marcadoresDTO = new MarcadoresDTO(nombre, cedula, fecha, valorApuesta, partido, resultado);
		listaMarcadores.add(marcadoresDTO);
		archivo.escribirArchivoMarcadores(listaMarcadores);
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
		MarcadoresDTO marcadoresDTO = buscarApuesta(cedula, fecha);
		if (marcadoresDTO != null) {
			listaMarcadores.remove(marcadoresDTO);
			archivo.escribirArchivoMarcadores(listaMarcadores);
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
		for (int i = 0; i < listaMarcadores.size(); i++) {
			if (cedula.equals(listaMarcadores.get(i).getCedula()) && fecha.equals(listaMarcadores.get(i).getFecha())) {
				listaMarcadores.get(i).setNombreSede(nombreSede);
				listaMarcadores.get(i).setValorApuesta(valorApuesta);
				archivo.escribirArchivoMarcadores(listaMarcadores);
				return verificar = true;
			} else {
				verificar = false;
			}
		}
		return verificar;
	}

	/**
	 * @return the listaMarcadores
	 */
	public ArrayList<MarcadoresDTO> getListaMarcadores() {
		return listaMarcadores;
	}

	/**
	 * @param listaMarcadores the listaMarcadores to set
	 */
	public void setListaMarcadores(ArrayList<MarcadoresDTO> listaMarcadores) {
		this.listaMarcadores = listaMarcadores;
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

}
