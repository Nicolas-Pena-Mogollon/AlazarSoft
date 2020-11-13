package co.edu.unbosque.model.persistence;

import java.io.Serializable;

public class GameDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombreGame;
	private int id;
	private String diaSemana;
	private int puntos;

	public GameDTO(String nombreGame, int id, String diaSemana, int puntos) {
		this.nombreGame = nombreGame;
		this.id = id;
		this.diaSemana = diaSemana;
		this.puntos = puntos;
	}

	public String getNombreGame() {
		return nombreGame;
	}

	public void setNombreGame(String nombreGame) {
		this.nombreGame = nombreGame;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

}
