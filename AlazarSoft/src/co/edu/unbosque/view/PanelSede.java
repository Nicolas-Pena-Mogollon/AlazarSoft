/**
 * Paquete vista
 */
package co.edu.unbosque.view;

import javax.swing.JTabbedPane;

/**
 * Clase PanelSede
 */

public class PanelSede extends JTabbedPane {
	
	/**
	 * Asociacion clase PanelSedeCrear 
	 * Asociacion clase PanelSedeModificar
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelSedeCrear panelSedeCrear;
	private PanelSedeModificar panelSedeModificar;

	/**
	 * Constructor con inicializaci�n de atributos
	 */
	public PanelSede() {

		panelSedeCrear = new PanelSedeCrear();
		panelSedeModificar = new PanelSedeModificar();

		this.add(panelSedeCrear, "A�adir sede");
		this.add(panelSedeModificar, "Actualizar informaci�n de sedes");

	}

	/**
	 * @return the panelSedeCrear
	 */
	public PanelSedeCrear getPanelSedeCrear() {
		return panelSedeCrear;
	}

	/**
	 * @param panelSedeCrear the panelSedeCrear to set
	 */
	public void setPanelSedeCrear(PanelSedeCrear panelSedeCrear) {
		this.panelSedeCrear = panelSedeCrear;
	}

	/**
	 * @return the panelSedeModificar
	 */
	public PanelSedeModificar getPanelSedeModificar() {
		return panelSedeModificar;
	}

	/**
	 * @param panelSedeModificar the panelSedeModificar to set
	 */
	public void setPanelSedeModificar(PanelSedeModificar panelSedeModificar) {
		this.panelSedeModificar = panelSedeModificar;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
