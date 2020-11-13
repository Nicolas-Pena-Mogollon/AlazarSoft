package co.edu.unbosque.model.persistence;

import java.io.Serializable;

public class GamerDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nickName;
	private int puntos;
	private int id;

	public GamerDTO(String nickName, int puntos, int id) {
		this.nickName = nickName;
		this.puntos = puntos;
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
