package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public class GamerDAO {
	private ArrayList<GamerDTO> gamerDTO;
	private GamersFile gamerFile;

	public GamerDAO() {
		this.gamerDTO = new ArrayList<GamerDTO>();
		this.gamerFile = new GamersFile();
		this.crearBots();
	}

	public void crearBots() {
		this.gamerDTO.add(new GamerDTO("Scorpius", 0, 0));
		this.gamerDTO.add(new GamerDTO("NIPEMO30", 0, 1));
		this.gamerDTO.add(new GamerDTO("JajajsXD", 0, 2));
		this.gamerDTO.add(new GamerDTO("Trolldot", 0, 3));
		this.gamerDTO.add(new GamerDTO("DeathWol", 0, 4));
	}

	public void crearGamer(String nickName, int id) {
		this.gamerDTO.add(new GamerDTO(nickName, 0, id));
		this.gamerFile.escribirArchivoGamers(gamerDTO);
	}

	public ArrayList<GamerDTO> leerGamers() {
		if (this.gamerFile.leerArchivoGamers() != null)
			this.gamerDTO = this.gamerFile.leerArchivoGamers();
		return this.gamerDTO;
	}

	public void actualizarGamer(String nickName, int id) {
		for (int i = 0; i < this.gamerDTO.size(); i++)
			if (this.gamerDTO.get(i).getId() == id)
				this.gamerDTO.get(i).setNickName(nickName);
		
		this.gamerFile.escribirArchivoGamers(gamerDTO);
	}

	public void eliminarGamer(int id) {
		for (int i = 0; i < this.gamerDTO.size(); i++) {
			if (this.gamerDTO.get(i).getId() == id) {
				this.gamerDTO.remove(i);
			}
		}
		this.gamerFile.escribirArchivoGamers(gamerDTO);
	}

	public ArrayList<GamerDTO> getGamerDTO() {
		return gamerDTO;
	}

	public void setGamerDTO(ArrayList<GamerDTO> gamerDTO) {
		this.gamerDTO = gamerDTO;
	}

	public GamersFile getGamerFile() {
		return gamerFile;
	}

	public void setGamerFile(GamersFile gamerFile) {
		this.gamerFile = gamerFile;
	}

}
