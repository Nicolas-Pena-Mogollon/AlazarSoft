/**
 * Paquete persistencia
 */
package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Clase ArchivoConfiguracionCasaApuestas
 */
public class ArchivoConfiguracionCasaApuestas {

	private final String RUTA_ARCHIVO_CONFIG = "./Data/config.properties";
	private Properties prop;
	private File file;
	private FileInputStream fis;
	private FileOutputStream fos;

	/**
	 * Constructor vacio
	 */

	public ArchivoConfiguracionCasaApuestas() {
		prop = new Properties();
		file = new File(RUTA_ARCHIVO_CONFIG);
	}

	/**
	 * Este método se encarga de escribir los datos de la casa de apuestas en el
	 * archivo properties. <b>pre</b>Que exista el archivo properties<br>
	 * <b>post</b>Se escriben los datos ingresados en el archivo properties<br>
	 * 
	 * @param datos, es el arreglo de datos a escribir en el archivo; datos != null.
	 */

	public void escribirConfiguracionCasaApuestas(String[] datos) {
		try {
			fos = new FileOutputStream(file);
			prop.setProperty("nombreCasaApuestas", datos[0]);
			prop.setProperty("numeroSedes", datos[1]);
			prop.setProperty("presupuestoTotal", datos[2]);
			prop.store(fos, null);
			fos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Este método se encarga de leer los datos del archivo properties.
	 * <b>pre</b>Que exista el archivo properties<br>
	 * <b>post</b>Se leen los datos del properties<br>
	 * 
	 * @return retorna un arreglo con la información del archivo properties.
	 */
	public String[] leerConfiguracionCasaApuestas() {
		String[] datos = new String[3];
		if (file.exists()) {
			try {
				fis = new FileInputStream(file);
				prop.load(fis);
				datos[0] = prop.getProperty("nombreCasaApuestas");
				datos[1] = prop.getProperty("numeroSedes");
				datos[2] = prop.getProperty("presupuestoTotal");
				fis.close();
			} catch (IOException e) {
				return null;
			}
		}
		return datos;
	}

}
