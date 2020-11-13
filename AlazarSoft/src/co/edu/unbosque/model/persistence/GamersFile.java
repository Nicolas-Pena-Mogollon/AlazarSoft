package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GamersFile {
	private final String RUTA_ARCHIVO_GAMERS = "./Data/gamers.dat";
	private File file;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public GamersFile() {
	}

	@SuppressWarnings("unchecked")
	public ArrayList<GamerDTO> leerArchivoGamers() {
		this.file = new File(RUTA_ARCHIVO_GAMERS);
		try {
			if (file.exists()) {
				this.ois = new ObjectInputStream(new FileInputStream(file));
				ArrayList<GamerDTO> listaGamers = (ArrayList<GamerDTO>) ois.readObject();
				this.ois.close();
				return listaGamers;
			} else {
				file.createNewFile();
				return null;
			}
		} catch (IOException | ClassNotFoundException e) {
			return null;
		}
	}

	public void escribirArchivoGamers(ArrayList<GamerDTO> listaGamers) {
		this.file = new File(RUTA_ARCHIVO_GAMERS);

		try {
			this.oos = new ObjectOutputStream(new FileOutputStream(file));
			this.oos.writeObject(listaGamers);
			this.oos.close();
		} catch (IOException e) {
		}
	}

	public String getRUTA_ARCHIVO_GAMERS() {
		return RUTA_ARCHIVO_GAMERS;
	}

}
