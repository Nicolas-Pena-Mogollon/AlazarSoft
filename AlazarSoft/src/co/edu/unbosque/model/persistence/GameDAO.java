package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public class GameDAO {

	private ArrayList<GameDTO> gamesDTO;
	private GameFile gamesFile;

	public GameDAO() {
		gamesDTO = new ArrayList<GameDTO>();
		gamesFile = new GameFile();
		leerGame();
	}

	public void crearGame(String nombreGame, int id, String diaSemana, int puntos) {
		this.gamesDTO.add(new GameDTO(nombreGame, id, diaSemana, puntos));
		this.gamesFile.escribirArchivoGames(gamesDTO);
	}

	public ArrayList<GameDTO> leerGame() {
		if (this.gamesFile.leerArchivoGames() != null)
			this.gamesDTO = this.gamesFile.leerArchivoGames();
		return this.gamesDTO;
	}

	public void eliminarGame(int id) {
		for (int i = 0; i < this.gamesDTO.size(); i++) {
			if (this.gamesDTO.get(i).getId() == id) {
				this.gamesDTO.remove(i);
			}
		}
		this.gamesFile.escribirArchivoGames(gamesDTO);
	}

	public ArrayList<GameDTO> getGamesDTO() {
		return gamesDTO;
	}

	public void setGamesDTO(ArrayList<GameDTO> gamesDTO) {
		this.gamesDTO = gamesDTO;
	}

	public GameFile getGamesFile() {
		return gamesFile;
	}

	public void setGamesFile(GameFile gamesFile) {
		this.gamesFile = gamesFile;
	}

}
