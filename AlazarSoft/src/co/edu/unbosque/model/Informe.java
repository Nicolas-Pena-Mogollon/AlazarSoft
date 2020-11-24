package co.edu.unbosque.model;

public class Informe {
	
	private String titulo;
	private String desccripci�n;
	private String[][] tablaDatos;
	
	public Informe(String titulo, String desccripci�n, String[][] tablaDatos) {
		super();
		this.titulo = titulo;
		this.desccripci�n = desccripci�n;
		this.tablaDatos = tablaDatos;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDesccripci�n() {
		return desccripci�n;
	}

	public void setDesccripci�n(String desccripci�n) {
		this.desccripci�n = desccripci�n;
	}

	public String[][] getTablaDatos() {
		return tablaDatos;
	}

	public void setTablaDatos(String[][] tablaDatos) {
		this.tablaDatos = tablaDatos;
	}
	
	
	
	
	
	
	

}
