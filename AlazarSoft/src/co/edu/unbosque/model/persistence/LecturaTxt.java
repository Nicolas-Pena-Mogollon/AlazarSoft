/**
 * Paquete persistencia
 */
package co.edu.unbosque.model.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase LecturaTxt
 */
public class LecturaTxt {

	private final String rutaArchivo = "./Data/Planes_de_premiacion.txt";
	private File fileTxt;

	public LecturaTxt() {
		fileTxt = new File(rutaArchivo);
	}

	/**
	 * Estede m�todo se encarga de leer la informaci�n que se encuentra dentro del
	 * archivo de texto.
	 * 
	 * @return retorna un arreglo con todos los datos del archivo de texto.
	 */
	public String[] leerArchivo() {
		String[] salida = new String[3];
		salida[0] = "";
		salida[1] = "";
		salida[2] = "";
		String linea = "";
		try {
			FileReader fr = new FileReader(fileTxt);
			BufferedReader br = new BufferedReader(fr);
			linea = br.readLine();
			while (linea != null && !linea.equals("Plan de premios de Baloto:")) {
				salida[0] += linea + "\n\n";
				linea = br.readLine();
			}
			while (linea != null && !linea.equals("Plan de premios de Marcadores de F�tbol:")) {
				salida[1] += linea + "\n\n";
				linea = br.readLine();
			}
			while (linea != null) {
				salida[2] += linea + "\n\n";
				linea = br.readLine();
			}
			fr.close();
		} catch (IOException e) {
			return null;
		}
		return salida;
	}
}
