package co.edu.unbosque.view;

import javax.swing.JTabbedPane;

public class PanelApostadores extends JTabbedPane {

	private static final long serialVersionUID = 1L;
	private PanelCrearApostador panelCrearApostador;
	private PanelActualizarBorrarApostador panelActualizarBorrarApostador;
	private PanelInformacionApostadores panelInformacionApostadores;

	public PanelApostadores() {

		panelCrearApostador = new PanelCrearApostador();
		panelActualizarBorrarApostador = new PanelActualizarBorrarApostador();
		panelInformacionApostadores = new PanelInformacionApostadores();

		this.add(panelCrearApostador, "Añadir apostadores");
		this.add(panelActualizarBorrarApostador, "Actualizar/Borrar información apostadores");
		this.add(panelInformacionApostadores, "Mostrar información apostadores");

	}

	public PanelCrearApostador getPanelCrearApostador() {
		return panelCrearApostador;
	}

	public void setPanelCrearApostador(PanelCrearApostador panelCrearApostador) {
		this.panelCrearApostador = panelCrearApostador;
	}

	public PanelActualizarBorrarApostador getPanelActualizarBorrarApostador() {
		return panelActualizarBorrarApostador;
	}

	public void setPanelActualizarBorrarApostador(PanelActualizarBorrarApostador panelActualizarBorrarApostador) {
		this.panelActualizarBorrarApostador = panelActualizarBorrarApostador;
	}

	public PanelInformacionApostadores getPanelInformacionApostadores() {
		return panelInformacionApostadores;
	}

	public void setPanelInformacionApostadores(PanelInformacionApostadores panelInformacionApostadores) {
		this.panelInformacionApostadores = panelInformacionApostadores;
	}

}
