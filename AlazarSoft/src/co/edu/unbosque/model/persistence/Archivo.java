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

import co.edu.unbosque.model.Apostador;

/**
 * Clase Archivo
 */
public class Archivo {
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
	public Archivo() {

	}

	/**
	 * se encarga de escribir en el archivo la informacion que recibe de la lista de
	 * apostadores. <b>pre</b> Que exista la lista de apostadores y el archivo<br>
	 * <b>post</b>Se agrega correctamente el apostador al archivo<br>
	 * 
	 * @param apostador, es la lista de apostadores de donde se tomará la información
	 *                  para escribirla en el archivo; apostador != null.
	 * @param file,     es el archivo en donde se guardará toda la información de
	 *                  los apostadores.
	 */
	public void escribirArchivo(ArrayList<Apostador> apostador, File file) {
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			System.out.println(file);
			salida = new ObjectOutputStream(new FileOutputStream(file));
			salida.writeObject(apostador);
			salida.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Este metodo se encarga de leer la lista de apostadores del archivo. <b>pre</b>
	 * Que exista el archivo<br>
	 * <b>Devuelve la lista de apostadores del archivo</b><br>
	 * 
	 * @param file, es el archivo en donde sen encuentran los apostadores; file !=
	 *              null.
	 * @return retorna la lista de apostadores del archivo.
	 */
	public ArrayList<Apostador> leerArchivo(File file) {
		ArrayList<Apostador> apostador = new ArrayList<Apostador>();
		if (file.length() != 0) {
			try {
				entrada = new ObjectInputStream(new FileInputStream(file));
				apostador = (ArrayList<Apostador>) entrada.readObject();
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

}