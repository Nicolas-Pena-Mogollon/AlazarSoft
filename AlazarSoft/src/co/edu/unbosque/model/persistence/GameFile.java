package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GameFile {
	private final String RUTA_ARCHIVO_GAME = "./Data/game.dat";
	private File file;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public GameFile() {
	}

	@SuppressWarnings("unchecked")
	public ArrayList<GameDTO> leerArchivoGames() {
		this.file = new File(RUTA_ARCHIVO_GAME);
		try {
			if (file.exists()) {
				this.ois = new ObjectInputStream(new FileInputStream(file));
				ArrayList<GameDTO> listaGame = (ArrayList<GameDTO>) ois.readObject();
				this.ois.close();
				return listaGame;
			} else {
				file.createNewFile();
				return null;
			}
		} catch (IOException | ClassNotFoundException e) {
			return null;
		}
	}

	public void escribirArchivoGames(ArrayList<GameDTO> listaGames) {
		this.file = new File(RUTA_ARCHIVO_GAME);
		try {
			this.oos = new ObjectOutputStream(new FileOutputStream(file));
			this.oos.writeObject(listaGames);
			this.oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getRUTA_ARCHIVO_GAME() {
		return RUTA_ARCHIVO_GAME;
	}

}
