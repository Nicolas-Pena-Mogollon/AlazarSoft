package co.edu.unbosque.view;

import javax.swing.JTabbedPane;

public class PanelApuestas extends JTabbedPane {

	private static final long serialVersionUID = 1L;
	private PanelCrearApuesta panelCrearApuesta;

	public PanelApuestas() {
		add(panelCrearApuesta, "Registrar apuestas");
	}

	public PanelCrearApuesta getPanelCrearApuesta() {
		return panelCrearApuesta;
	}

	public void setPanelCrearApuesta(PanelCrearApuesta panelCrearApuesta) {
		this.panelCrearApuesta = panelCrearApuesta;
	}

}
