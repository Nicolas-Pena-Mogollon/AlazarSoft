package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArchivoJuegos {

	private File fileArchivo;
	private final String RUTA_JUEGOS = "Data\\juegos.dat";
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;

	public ArchivoJuegos() {

	}

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
