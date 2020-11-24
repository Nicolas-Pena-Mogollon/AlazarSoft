package co.edu.unbosque.model;

public class Informe {
	
	private String titulo;
	private String desccripción;
	private String[][] tablaDatos;
	
	public Informe(String titulo, String desccripción, String[][] tablaDatos) {
		super();
		this.titulo = titulo;
		this.desccripción = desccripción;
		this.tablaDatos = tablaDatos;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDesccripción() {
		return desccripción;
	}

	public void setDesccripción(String desccripción) {
		this.desccripción = desccripción;
	}

	public String[][] getTablaDatos() {
		return tablaDatos;
	}

	public void setTablaDatos(String[][] tablaDatos) {
		this.tablaDatos = tablaDatos;
	}
	
	
	
	
	
	
	

}
