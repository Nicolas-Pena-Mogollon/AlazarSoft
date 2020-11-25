/**
 * Paquete persistencia
 */
package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Clase Propiedades
 */
public class Propiedades {

	String[] partidos;

	/**
	 * Constructor vacio
	 */
	public Propiedades() {

	}

	/**
	 * Este método se encarga de cargar la información del archivo properties.
	 * 
	 * @param archivo, es la ruta del archivo; archivo != null.
	 * @return retorna el properties con la información.
	 * @throws Exception excepcion que se puede presentar.
	 */

	public Properties cargarInfo(File archivo) throws Exception {
		Properties datos = new Properties();
		FileInputStream in = new FileInputStream(archivo);
		try {
			datos.load(in);
			in.close();
		} catch (Exception e) {
			throw new Exception("Error en properties");
		}
		return datos;
	}

	/**
	 * Este método se encarga cargar los datos del properties en una arreglo.
	 * 
	 * @param pDatos, es el properties que contiene la información; pDatos != null.
	 * @return retorna un arreglo con todos los datos del properties.
	 */
	public String[] inicializarDatosPartido(Properties pDatos) {

		partidos = new String[14];

		String partido = "";

		for (int i = 0; i < 14; i++) {

			partido = pDatos.getProperty("partido" + (i + 1));
			partidos[i] = partido;

		}
		return partidos;

	}

}
