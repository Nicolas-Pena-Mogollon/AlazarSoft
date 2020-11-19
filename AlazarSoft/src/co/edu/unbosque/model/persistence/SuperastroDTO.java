package co.edu.unbosque.model.persistence;

public class SuperastroDTO extends Apuesta {

	private static final long serialVersionUID = 1L;
	private String numeroJuego = "";
	private String signo = "";

	public SuperastroDTO(String nombreSede, String cedula, java.util.Date fecha, double valorApuesta,
			String numeroJuego, String signo) {
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

	/**
	 * @return the signo
	 */
	public String getSigno() {
		return signo;
	}

	/**
	 * @param signo the signo to set
	 */
	public void setSigno(String signo) {
		this.signo = signo;
	}

}
