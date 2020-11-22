package co.edu.unbosque.view;

import javax.swing.JTabbedPane;

public class PanelConsultasReportes extends JTabbedPane {

	private static final long serialVersionUID = 1L;
	private PanelExportarInformacion panelExportarInformacion;

	public PanelConsultasReportes() {
		
		panelExportarInformacion = new PanelExportarInformacion();

		add(panelExportarInformacion, "Exportar Información");

	}

	/**
	 * @return the panelExportarInformacion
	 */
	public PanelExportarInformacion getPanelExportarInformacion() {
		return panelExportarInformacion;
	}

	/**
	 * @param panelExportarInformacion the panelExportarInformacion to set
	 */
	public void setPanelExportarInformacion(PanelExportarInformacion panelExportarInformacion) {
		this.panelExportarInformacion = panelExportarInformacion;
	}

}
