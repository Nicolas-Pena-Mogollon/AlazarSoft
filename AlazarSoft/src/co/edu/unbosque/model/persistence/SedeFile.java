package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SedeFile {
	private final String rutaArchivo = "./Data/sedes.dat";
	private File file;
	private ObjectInputStream inSede;
	private ObjectOutputStream outSede;

	public SedeFile() {
		file = new File(rutaArchivo);
	}

	public String escribirRegistroSede(ArrayList<SedesDTO> listaSedes) {
		String mensaje = "Registro de Jugador Generado!";
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

	@SuppressWarnings("unchecked")
	public ArrayList<SedesDTO> leerRegistroSede() {
		if (!file.exists()) {
			try {
				inSede = new ObjectInputStream(new FileInputStream(file));
				ArrayList<SedesDTO> gamerDatos = (ArrayList<SedesDTO>) inSede.readObject();
				inSede.close();
				return gamerDatos;
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			try {
				file.createNewFile();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return null;

			}
		}
	}

	public String getRutaArchivo() {
		return rutaArchivo;
	}

}
