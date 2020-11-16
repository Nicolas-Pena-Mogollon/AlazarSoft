package co.edu.unbosque.model.persistence;

import java.sql.Date;

public class MarcadoresDTO extends Apuesta {

	private static final long serialVersionUID = 1L;

	public MarcadoresDTO(String nombreSede, String cedula, Date fecha, double valorApuesta) {
		super(nombreSede, cedula, fecha, valorApuesta);
		// TODO Auto-generated constructor stub
	}

}
