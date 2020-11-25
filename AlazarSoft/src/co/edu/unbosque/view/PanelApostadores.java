/**
 * Paquete vista
 */
package co.edu.unbosque.view;

import javax.swing.JTabbedPane;

/**
 * Clase PanelApostadores
 */

public class PanelApostadores extends JTabbedPane {

	/**
	 * Asociacion clase PanelCrearApostador Asociacion clase
	 * PanelActualizarBorrarApostador Asociacion clase PanelInformacionApostadores
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private PanelCrearApostador panelCrearApostador;
	private PanelActualizarBorrarApostador panelActualizarBorrarApostador;
	private PanelInformacionApostadores panelInformacionApostadores;

	/**
	 * Constructor con inicialización de atributos
	 */

	public PanelApostadores() {

		panelCrearApostador = new PanelCrearApostador();
		panelActualizarBorrarApostador = new PanelActualizarBorrarApostador();
		panelInformacionApostadores = new PanelInformacionApostadores();

		this.add(panelCrearApostador, "Añadir apostadores");
		this.add(panelActualizarBorrarApostador, "Actualizar/Borrar información apostadores");
		this.add(panelInformacionApostadores, "Mostrar información apostadores");

	}

	/**
	 * 
	 * @return panelCrearApostador
	 */

	public PanelCrearApostador getPanelCrearApostador() {
		return panelCrearApostador;
	}

	/**
	 * 
	 * @param panelCrearApostador
	 */
	public void setPanelCrearApostador(PanelCrearApostador panelCrearApostador) {
		this.panelCrearApostador = panelCrearApostador;
	}

	/**
	 * 
	 * @return panelActualizarBorrarApostador
	 */
	public PanelActualizarBorrarApostador getPanelActualizarBorrarApostador() {
		return panelActualizarBorrarApostador;
	}

	/**
	 * 
	 * @param panelActualizarBorrarApostador
	 */
	public void setPanelActualizarBorrarApostador(PanelActualizarBorrarApostador panelActualizarBorrarApostador) {
		this.panelActualizarBorrarApostador = panelActualizarBorrarApostador;
	}

	/**
	 * 
	 * @return panelInformacionApostadores
	 */
	public PanelInformacionApostadores getPanelInformacionApostadores() {
		return panelInformacionApostadores;
	}

	/**
	 * 
	 * @param panelInformacionApostadores
	 */
	public void setPanelInformacionApostadores(PanelInformacionApostadores panelInformacionApostadores) {
		this.panelInformacionApostadores = panelInformacionApostadores;
	}

}
