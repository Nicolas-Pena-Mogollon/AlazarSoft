package co.edu.unbosque.model.persistence;

public class MarcadoresDTO extends ApuestaDTO {

	private static final long serialVersionUID = 1L;
	private String partido = "";
	private String resultado = "";

	public MarcadoresDTO(String nombreSede, String cedula, java.util.Date fecha, double valorApuesta, String partido,
			String resultado) {
		super(nombreSede, cedula, fecha, valorApuesta);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the partido
	 */
	public String getPartido() {
		return partido;
	}

	/**
	 * @param partido the partido to set
	 */
	public void setPartido(String partido) {
		this.partido = partido;
	}

	/**
	 * @return the resultado
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

}
