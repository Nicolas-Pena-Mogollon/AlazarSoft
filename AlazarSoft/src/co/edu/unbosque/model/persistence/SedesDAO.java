/**
 * Paquete persistencia
 */
package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

/**
 * Clase SedesDAO
 */
public class SedesDAO {

	private ArrayList<SedesDTO> dataSedes;
	private SedeFile sedeFile;

	/**
	 * Constructor vacio
	 */

	public SedesDAO() {
		dataSedes = new ArrayList<SedesDTO>();
		sedeFile = new SedeFile();
		leerSede();
	}

	public void crearRegistroBase() {

	}

	/**
	 * Este método se encarga de crear sedes dentro del archivo.
	 * 
	 * @param nuevaSede, es la sede a registrar; sede != null.
	 * @return retorna un mensaje indicando el correcto registro.
	 */
	public String crearSede(SedesDTO nuevaSede) {
		dataSedes.add(nuevaSede);
		sedeFile.escribirRegistroSede(dataSedes);
		return "Proceso correcto";
	}

	/**
	 * Este método se encarga de leer el archivo de sedes para luego cargarlos a una
	 * ArrayList.
	 * 
	 * @return retorna un ArrayList con toda la información del archivo.
	 */

	public ArrayList<SedesDTO> leerSede() {
		if (sedeFile.leerRegistroSede() == null) {
			crearRegistroBase();
		} else {
			dataSedes = (sedeFile.leerRegistroSede());
		}
		return dataSedes;
	}

	/**
	 * Este método se encarga de actualizar la información de las sedes regstradas.
	 * 
	 * @param IdUbicacion, es la id de la ubicación; IdUbicacion != null.
	 * @param ubicacion,   es la ubicación de la sede; ubicacion != null.
	 * @param empleados,   es el número de empleados a editar; empleados != null.
	 * @return retorna un mensaje indicando la correcta modificación.
	 */
	public String actualizarSede(int IdUbicacion, String ubicacion, int empleados) {
		for (int i = 0; i < dataSedes.size(); i++) {
			if (IdUbicacion == dataSedes.get(i).getIdUbicacion()) {
				if (!ubicacion.equals("")) {
					dataSedes.get(i).setUbicacion(ubicacion);
					;
				}
				if (empleados != -8) {
					dataSedes.get(i).setEmpleados(empleados);
					;

				}
			}
		}
		sedeFile.escribirRegistroSede(dataSedes);
		return "Registro actualizado";

	}

	/**
	 * @return the dataSedes
	 */
	public ArrayList<SedesDTO> getDataSedes() {
		return dataSedes;
	}

	/**
	 * @param dataSedes the dataSedes to set
	 */
	public void setDataSedes(ArrayList<SedesDTO> dataSedes) {
		this.dataSedes = dataSedes;
	}

	/**
	 * @return the sedeFile
	 */
	public SedeFile getSedeFile() {
		return sedeFile;
	}

	/**
	 * @param sedeFile the sedeFile to set
	 */
	public void setSedeFile(SedeFile sedeFile) {
		this.sedeFile = sedeFile;
	}

}
