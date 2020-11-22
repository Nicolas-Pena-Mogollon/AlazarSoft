package co.edu.unbosque.view;

import javax.swing.JTabbedPane;

public class PanelCasaApuestas extends JTabbedPane {

	private static final long serialVersionUID = 1L;
	private PanelIngresoCasaApuestas panelIngresoCasaApuestas;
	private PanelDatosJuegos panelDatosJuegos;

	public PanelCasaApuestas() {
		panelIngresoCasaApuestas = new PanelIngresoCasaApuestas();
		panelDatosJuegos = new PanelDatosJuegos();

		this.add(panelIngresoCasaApuestas, "Configuración Casa de Apuestas");
		this.add(panelDatosJuegos, "Ingresos de datos de Juego");

	}

	/**
	 * @return the panelIngresoCasaApuestas
	 */
	public PanelIngresoCasaApuestas getPanelIngresoCasaApuestas() {
		return panelIngresoCasaApuestas;
	}

	/**
	 * @param panelIngresoCasaApuestas the panelIngresoCasaApuestas to set
	 */
	public void setPanelIngresoCasaApuestas(PanelIngresoCasaApuestas panelIngresoCasaApuestas) {
		this.panelIngresoCasaApuestas = panelIngresoCasaApuestas;
	}

	/**
	 * @return the panelDatosJuegos
	 */
	public PanelDatosJuegos getPanelDatosJuegos() {
		return panelDatosJuegos;
	}

	/**
	 * @param panelDatosJuegos the panelDatosJuegos to set
	 */
	public void setPanelDatosJuegos(PanelDatosJuegos panelDatosJuegos) {
		this.panelDatosJuegos = panelDatosJuegos;
	}

}
