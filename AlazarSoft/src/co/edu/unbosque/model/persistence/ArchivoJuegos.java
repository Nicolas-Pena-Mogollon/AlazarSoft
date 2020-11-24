/**
 * Paquete persistencia
 */
package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Clase ArchivoJuegos
 */
public class ArchivoJuegos {

	private File fileArchivo;
	private final String RUTA_JUEGOS = "Data\\juegos.dat";
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;

	/**
	 * Constructor vacio
	 */

	public ArchivoJuegos() {

	}

	/**
	 * Este metodo se encarga de escribir la información de los juegos en el archivo
	 * juegos.dat.
	 * 
	 * @param juegos, es la lista de juegos de donde se va tomar la información para
	 *                escribirla en el archivo; juegos != null.
	 */

	public void escribirArchivo(ArrayList<JuegosDTO> juegos) {
		if (!fileArchivo.exists()) {
			try {
				fileArchivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			fileArchivo.delete();
			System.out.println(fileArchivo);
			salida = new ObjectOutputStream(new FileOutputStream(fileArchivo));
			salida.writeObject(juegos);
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Este método se encarga de leer la información del archivo juegos.dat.
	 * 
	 * @param file, es el archivo en el cual se va a leer la información; file !=
	 *              null.
	 * @return retorna un arrayList con toda la información que contenga el archivo.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<JuegosDTO> leerArchivo(File file) {
		ArrayList<JuegosDTO> juegos = new ArrayList<JuegosDTO>();
		if (file.length() != 0) {
			try {
				entrada = new ObjectInputStream(new FileInputStream(file));
				juegos = (ArrayList<JuegosDTO>) entrada.readObject();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return juegos;
	}

	/**
	 * Este metodo se encarga de asignar la ruta del archivo e inicializar
	 * fileArchivo
	 * 
	 * @param ruta, es la ruta del archivo; ruta != null.
	 */

	public void asignarRutaArchivoJuegos(String ruta) {
		fileArchivo = new File(ruta);
	}

	/**
	 * @return the fileArchivo
	 */
	public File getFileArchivo() {
		return fileArchivo;
	}

	/**
	 * @param fileArchivo the fileArchivo to set
	 */
	public void setFileArchivo(File fileArchivo) {
		this.fileArchivo = fileArchivo;
	}

	/**
	 * @return the rUTA_JUEGOS
	 */
	public String getRUTA_JUEGOS() {
		return RUTA_JUEGOS;
	}

}
