package co.edu.unbosque.view;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import co.edu.unbosque.controller.Controller;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelActualizarBorrarApostador panelActualizarBorrarApostador;
	private PanelInformacionApostadores panelInformacionApostadores;
	private PanelIngresoCasaApuestas panelIngresoCasaApuestas;
	private PanelMostrarRegistroJuegos panelMostrarRegistrosJuegos;
	private PanelSede panelSede;

	public View(Controller control) {

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new CardLayout());
		this.setSize(800, 250);
		this.setTitle("Casa de apuestas");
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		panelActualizarBorrarApostador = new PanelActualizarBorrarApostador();
		panelInformacionApostadores = new PanelInformacionApostadores();
		panelIngresoCasaApuestas = new PanelIngresoCasaApuestas();
		panelMostrarRegistrosJuegos = new PanelMostrarRegistroJuegos();
		panelSede = new PanelSede();

		getContentPane().add(panelIngresoCasaApuestas);
		getContentPane().add(panelInformacionApostadores);
		getContentPane().add(panelActualizarBorrarApostador);
		getContentPane().add(panelMostrarRegistrosJuegos);
		getContentPane().add(panelSede);

		// Esto es temporal
		panelActualizarBorrarApostador.setVisible(false);
		panelInformacionApostadores.setVisible(false);
		panelMostrarRegistrosJuegos.setVisible(false);
		panelSede.setVisible(false);
		panelIngresoCasaApuestas.setVisible(true);

		panelActualizarBorrarApostador.getBotonActualizar().addActionListener(control);
		panelActualizarBorrarApostador.getBotonBorrar().addActionListener(control);
		panelInformacionApostadores.getBotonLeer().addActionListener(control);
		panelIngresoCasaApuestas.getBotonGuardar().addActionListener(control);
		panelMostrarRegistrosJuegos.getBotonLeer().addActionListener(control);
		panelSede.getBotonSede().addActionListener(control);

	}

	public void mostrarMensajeError(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public boolean mostrarMensajeAdvertencia() {
		int entrada = JOptionPane.showConfirmDialog(null, "", "Advertencia",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (entrada == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void mostrarMensajeInformacion(String message) {
		JOptionPane.showMessageDialog(null, message, "Información", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public PanelActualizarBorrarApostador getPanelActualizarGamer() {
		return panelActualizarBorrarApostador;
	}

	public void setPanelActualizarGamer(PanelActualizarBorrarApostador panelActualizarGamer) {
		this.panelActualizarBorrarApostador = panelActualizarGamer;
	}

	public PanelInformacionApostadores getPanelLeerGamer() {
		return panelInformacionApostadores;
	}

	public void setPanelLeerGamer(PanelInformacionApostadores panelLeerGamer) {
		this.panelInformacionApostadores = panelLeerGamer;
	}

	public PanelIngresoCasaApuestas getPanelIngresoCasaApuestas() {
		return panelIngresoCasaApuestas;
	}

	public void setPanelIngresoCasaApuestas(PanelIngresoCasaApuestas panelIngresoCasaApuestas) {
		this.panelIngresoCasaApuestas = panelIngresoCasaApuestas;
	}

	public PanelMostrarRegistroJuegos getPanelMostrarRegistrosJuegos() {
		return panelMostrarRegistrosJuegos;
	}

	public void setPanelMostrarRegistrosJuegos(PanelMostrarRegistroJuegos panelMostrarRegistrosJuegos) {
		this.panelMostrarRegistrosJuegos = panelMostrarRegistrosJuegos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
