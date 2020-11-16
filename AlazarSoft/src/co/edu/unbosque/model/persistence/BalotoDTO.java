package co.edu.unbosque.model.persistence;

public class BalotoDTO extends Apuesta {

	private static final long serialVersionUID = 1L;
	
	String numeroJuego = "";

	public BalotoDTO(String nombreSede, String cedula, java.util.Date fecha, double valorApuesta, String numeroJuego) {
		super(nombreSede, cedula, fecha, valorApuesta);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the numeroJuego
	 */
	public String getNumeroJuego() {
		return numeroJuego;
	}

	/**
	 * @param numeroJuego the numeroJuego to set
	 */
	public void setNumeroJuego(String numeroJuego) {
		this.numeroJuego = numeroJuego;
	}
	
	
}
