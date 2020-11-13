package co.edu.unbosque.model;

public class Apostador {

	String nombre = "";
	String cedula = "";
	String sede = "";
	String direccion = "";
	String celular = "";

	/**
	 * Constructor vacio
	 */
	public Apostador() {

	}

	/**
	 * Constructor especifico
	 * 
	 * @param nombre,    es el nombre del apostador; nombre != null.
	 * @param cedula,    es la cedula del apostador; cedula != null.
	 * @param sede,      es la sede donde está jugando; sede != null.
	 * @param direccion, es la dirección del apostador; direccion != null.
	 * @param celular,   es el celular del apostador; celular != null.
	 */
	public Apostador(String nombre, String cedula, String sede, String direccion, String celular) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.sede = sede;
		this.direccion = direccion;
		this.celular = celular;
	}

	public boolean soloNumeros(String celular) {
		for (int i = 0; i < celular.length(); i++) {
			char aux = celular.charAt(i);
			int digito = aux - '0';
			if (digito > 9 || digito < 0) {
				return false;
			}
		}
		return true;
	}

	public String verificarCelular(String celular) throws CelularException {
		String mensaje = "";
		try {
			if (!soloNumeros(celular)) {
				throw new CelularException("Ingresó un caracter no permitido para el teléfono");
			} else if (celular.length() == 10 && celular.charAt(0) == '3') {
				mensaje = celular;
			} else {
				throw new CelularException("Número telefónico incorrecto");
			}
		} catch (CelularException e) {
			mensaje = e.getMessage();
		}

		return mensaje;
	}

	public String verificarCedula(String cedula) throws CedulaException {
		String mensaje = "";
		try {
			if (!soloNumeros(cedula)) {
				throw new CedulaException("Ingresó un caracter no permitido para la cedula");
			} else if (celular.length() == 10) {
				mensaje = cedula;
			} else {
				throw new CedulaException("Cedula incorrecta");
			}
		} catch (CedulaException e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the sede
	 */
	public String getSede() {
		return sede;
	}

	/**
	 * @param sede the sede to set
	 */
	public void setSede(String sede) {
		this.sede = sede;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @param celular the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

}
