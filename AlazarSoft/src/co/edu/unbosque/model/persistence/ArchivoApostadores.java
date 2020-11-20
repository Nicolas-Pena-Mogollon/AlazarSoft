/**
 * paquete persistencia, encargado de la permanencia de informacion en el programa
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
 * Clase Archivo
 */
public class ArchivoApostadores {
	/**
	 * Es el archivo
	 */
	private File fileArchivo;
	/**
	 * Ruta del archivo apostadores
	 */
	private final String RUTA_APOSTADORES = "./Data/apostadores.dat";
	/**
	 * es la entrada de los datos
	 */
	private ObjectInputStream entrada;
	/**
	 * es la salida de los datos
	 */
	private ObjectOutputStream salida;

	/**
	 * constructor vacio
	 */
	public ArchivoApostadores() {

	}

	/**
	 * se encarga de escribir en el archivo la informacion que recibe de la lista de
	 * apostadores. <b>pre</b> Que exista la lista de apostadores y el archivo<br>
	 * <b>post</b>Se agrega correctamente el apostador al archivo<br>
	 * 
	 * @param apostador, es la lista de apostadores de donde se tomará la
	 *                   información para escribirla en el archivo; apostador !=
	 *                   null.
	 * @param file,      es el archivo en donde se guardará toda la información de
	 *                   los apostadores.
	 */
	public void escribirArchivo(ArrayList<ApostadorDTO> apostador) {
		if (!fileArchivo.exists()) {
			try {
				fileArchivo.delete();
				fileArchivo.createNewFile();
				System.out.println(fileArchivo);
				salida = new ObjectOutputStream(new FileOutputStream(fileArchivo));
				salida.writeObject(apostador);
				salida.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * Este metodo se encarga de leer la lista de apostadores del archivo.
	 * <b>pre</b> Que exista el archivo<br>
	 * <b>Devuelve la lista de apostadores del archivo</b><br>
	 * 
	 * @param file, es el archivo en donde sen encuentran los apostadores; file !=
	 *              null.
	 * @return retorna la lista de apostadores del archivo.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<ApostadorDTO> leerArchivo(File file) {
		ArrayList<ApostadorDTO> apostador = new ArrayList<ApostadorDTO>();
		if (file.length() != 0) {
			try {
				entrada = new ObjectInputStream(new FileInputStream(file));
				apostador = (ArrayList<ApostadorDTO>) entrada.readObject();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return apostador;
	}

	/**
	 * Este metodo se encarga de asignar la ruta del archivo e inicializar
	 * fileArchivo
	 * 
	 * @param ruta
	 */
	public void asignarRutaArchivoApostadores(String ruta) {
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
	 * @return the RUTA_APOSTADORES
	 */
	public String getRUTA_APOSTADORES() {
		return RUTA_APOSTADORES;
	}

}