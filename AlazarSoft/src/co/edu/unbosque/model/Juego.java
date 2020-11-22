package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.JuegosDAO;

public class Juego {

	private JuegosDAO juegosDAO;

	public Juego() {
		this.juegosDAO = new JuegosDAO();
	}

	/**
	 * @return the juegosDAO
	 */
	public JuegosDAO getJuegosDAO() {
		return juegosDAO;
	}

	/**
	 * @param juegosDAO the juegosDAO to set
	 */
	public void setJuegosDAO(JuegosDAO juegosDAO) {
		this.juegosDAO = juegosDAO;
	}
	
	
}
