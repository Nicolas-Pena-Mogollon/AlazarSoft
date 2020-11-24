/**
 * Paquete persistencia
 */
package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Clase SedeFile
 */
public class SedeFile {
	private final String rutaArchivo = "Data\\sedes.dat";
	private File file;
	private ObjectInputStream inSede;
	private ObjectOutputStream outSede;

	/**
	 * Constructor vacio
	 */
	public SedeFile() {
		file = new File(rutaArchivo);
	}

	/**
	 * Se encarga de escribir en el archivo la informacion que recibe de la lista de
	 * apuestas de sedes. <b>pre</b>Que exista la lista de sedes y el archivo<br>
	 * <b>post</b>Se agrega correctamente la sede del archivo<br>
	 * 
	 * @param listaSedes, es la lista de sedes de donde se tomará la información
	 *                    para escribirla en el archivo; listaSedes != null.
	 * @return retorna un mensaje indicando el correcto registro.
	 */
	public String escribirRegistroSede(ArrayList<SedesDTO> listaSedes) {
		String mensaje = "Registro de Sede Generado!";
		try {
			outSede = new ObjectOutputStream(new FileOutputStream(file));
			outSede.writeObject(listaSedes);
			outSede.close();
		} catch (IOException e) {
			e.printStackTrace();
			mensaje = "Error de IO";
		}
		return mensaje;
	}

	/**
	 * Este metodo se encarga de leer la lista de sedes de baloto del archivo.
	 * <b>Devuelve la lista de apuestas de baloto del archivo</b><br>
	 * 
	 * @return retorna la lista de sedes del archivo.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<SedesDTO> leerRegistroSede() {
		ArrayList<SedesDTO> sedesDatos = new ArrayList<SedesDTO>();
		if (file.length() != 0) {
			try {
				inSede = new ObjectInputStream(new FileInputStream(file));
				sedesDatos = (ArrayList<SedesDTO>) inSede.readObject();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return sedesDatos;
	}

	/**
	 * @return the rutaArchivo
	 */
	public String getRutaArchivo() {
		return rutaArchivo;
	}

}
