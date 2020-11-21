package co.edu.unbosque.view;

import javax.swing.JTabbedPane;

public class PanelSede extends JTabbedPane {

	private static final long serialVersionUID = 1L;
	private PanelSedeCrear panelSedeCrear;
	private PanelSedeModificar panelSedeModificar;

	public PanelSede() {

		panelSedeCrear = new PanelSedeCrear();
		panelSedeModificar = new PanelSedeModificar();

		this.add(panelSedeCrear, "Añadir sede");
		this.add(panelSedeModificar, "Actualizar/Borrar información sedes");

	}

	public PanelSedeCrear getPanelSedeCrear() {
		return panelSedeCrear;
	}

	public void setPanelSedeCrear(PanelSedeCrear panelSedeCrear) {
		this.panelSedeCrear = panelSedeCrear;
	}

	public PanelSedeModificar getPanelSedeModificar() {
		return panelSedeModificar;
	}

	public void setPanelSedeModificar(PanelSedeModificar panelSedeModificar) {
		this.panelSedeModificar = panelSedeModificar;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
