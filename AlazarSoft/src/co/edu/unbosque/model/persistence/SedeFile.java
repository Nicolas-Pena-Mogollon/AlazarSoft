package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SedeFile {
	private final String rutaArchivo = "Data\\sedes.dat";
	private File file;
	private ObjectInputStream inSede;
	private ObjectOutputStream outSede;

	public SedeFile() {
		file = new File(rutaArchivo);
	}

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

	public String getRutaArchivo() {
		return rutaArchivo;
	}

}
