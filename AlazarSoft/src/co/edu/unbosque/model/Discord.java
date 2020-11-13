package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.GameDAO;
import co.edu.unbosque.model.persistence.GamerDAO;

public class Discord {

	private GamerDAO gamerDao;
	private GameDAO gamesDao;

	public Discord() {
		this.gamerDao = new GamerDAO();
		this.gamesDao = new GameDAO();
	}

	public String[][] generarReporteJuegos() {
		String[][] data = new String[this.gamesDao.getGamesDTO().size()][3];
		int cont = 0;
		String nickName = "";
		for (int i = 0; i < this.gamerDao.getGamerDTO().size(); i++) {
			nickName = this.gamerDao.getGamerDTO().get(i).getNickName();
			for (int j = 0; j < this.gamesDao.getGamesDTO().size(); j++) {
				if (this.gamerDao.getGamerDTO().get(i).getId() == this.gamesDao.getGamesDTO().get(j).getId()) {
					data[cont][0] = nickName;
					data[cont][1] = this.gamesDao.getGamesDTO().get(j).getNombreGame();
					data[cont][2] = String.valueOf(this.gamesDao.getGamesDTO().get(j).getPuntos());
					cont++;
				}
			}
		}
		return data;
	}

	public String[][] generarTablaGamers() {
		String[][] data = new String[this.gamerDao.getGamerDTO().size()][3];
		for (int i = 0; i < this.gamerDao.getGamerDTO().size(); i++) {
			data[i][0] = String.valueOf(this.gamerDao.getGamerDTO().get(i).getId());
			data[i][1] = this.gamerDao.getGamerDTO().get(i).getNickName();
			data[i][2] = String.valueOf(this.gamerDao.getGamerDTO().get(i).getPuntos());
		}
		return data;
	}

	public String[] generarListaId() {
		String[] salida = new String[this.gamerDao.getGamerDTO().size()];
		for (int i = 0; i < salida.length; i++) {
			salida[i] = String.valueOf(this.gamerDao.getGamerDTO().get(i).getId());
		}
		return salida;
	}

	public boolean verificarNickname(String nickName) {
		boolean salida = false;
		for (int i = 0; i < this.gamerDao.getGamerDTO().size(); i++)
			if (this.gamerDao.getGamerDTO().get(i).getNickName().equals(nickName))
				salida = true;
		return salida;
	}

	public void agregarPuntosGamer(int id, int puntos) {
		for (int i = 0; i < gamerDao.getGamerDTO().size(); i++)
			if (gamerDao.getGamerDTO().get(i).getId() == id)
				gamerDao.getGamerDTO().get(i).setPuntos(gamerDao.getGamerDTO().get(i).getPuntos() + puntos);
	}

	public int asignarID() {
		return this.gamerDao.getGamerDTO().get(this.gamerDao.getGamerDTO().size() - 1).getId() + 1;
	}

	public GamerDAO getGamerDao() {
		return gamerDao;
	}

	public void setGamerDao(GamerDAO gamerDao) {
		this.gamerDao = gamerDao;
	}

	public GameDAO getGamesDao() {
		return gamesDao;
	}

	public void setGamesDao(GameDAO gamesDao) {
		this.gamesDao = gamesDao;
	}

}
