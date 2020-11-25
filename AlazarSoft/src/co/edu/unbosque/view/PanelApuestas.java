/**
 * Paquete vista
 */
package co.edu.unbosque.view;

import javax.swing.JTabbedPane;

/**
 * Clase PanelApuestas
 */

public class PanelApuestas extends JTabbedPane {

	/**
	 * Asociacion clase PanelCrearApuesta 
	 * Asociacion clase PanelModificarApuesta
	 * Asociacion clase PanelMostrarBorrarApuesta
	 */

	private static final long serialVersionUID = 1L;
	private PanelCrearApuesta panelCrearApuesta;
	private PanelModificarApuesta panelModificarApuesta;
	private PanelMostrarBorrarApuesta panelMostrarBorrarApuesta;

	/**
	 * Constructor con inicialización de atributos
	 */

	public PanelApuestas() {
		panelCrearApuesta = new PanelCrearApuesta();
		panelModificarApuesta = new PanelModificarApuesta();
		panelMostrarBorrarApuesta = new PanelMostrarBorrarApuesta();
		add(panelCrearApuesta, "Registrar apuestas");
		add(panelModificarApuesta, "Modificar apuestas");
		add(panelMostrarBorrarApuesta, "Ver y borrar apuestas");

	}

	/**
	 * @return the panelCrearApuesta
	 */
	public PanelCrearApuesta getPanelCrearApuesta() {
		return panelCrearApuesta;
	}

	/**
	 * @param panelCrearApuesta the panelCrearApuesta to set
	 */
	public void setPanelCrearApuesta(PanelCrearApuesta panelCrearApuesta) {
		this.panelCrearApuesta = panelCrearApuesta;
	}

	/**
	 * @return the panelModificarApuesta
	 */
	public PanelModificarApuesta getPanelModificarApuesta() {
		return panelModificarApuesta;
	}

	/**
	 * @param panelModificarApuesta the panelModificarApuesta to set
	 */
	public void setPanelModificarApuesta(PanelModificarApuesta panelModificarApuesta) {
		this.panelModificarApuesta = panelModificarApuesta;
	}

	/**
	 * @return the panelMostrarBorrarApuesta
	 */
	public PanelMostrarBorrarApuesta getPanelMostrarBorrarApuesta() {
		return panelMostrarBorrarApuesta;
	}

	/**
	 * @param panelMostrarBorrarApuesta the panelMostrarBorrarApuesta to set
	 */
	public void setPanelMostrarBorrarApuesta(PanelMostrarBorrarApuesta panelMostrarBorrarApuesta) {
		this.panelMostrarBorrarApuesta = panelMostrarBorrarApuesta;
	}

}
