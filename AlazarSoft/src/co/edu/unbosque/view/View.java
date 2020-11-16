package co.edu.unbosque.view;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import co.edu.unbosque.controller.Controller;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelActualizarBorrarApostador panelActualizarGamer;
	private PanelInformacionApostadores panelLeerGamer;
	private PanelIngresoCasaApuestas panelIngresoCasaApuestas;
	private PanelMostrarRegistroJuegos panelMostrarRegistrosJuegos;

	public View(Controller control) {

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new CardLayout());
		this.setSize(800, 250);
		this.setTitle("Casa de apuestas");
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		panelActualizarGamer = new PanelActualizarBorrarApostador();
		panelLeerGamer = new PanelInformacionApostadores();
		panelIngresoCasaApuestas = new PanelIngresoCasaApuestas();
		panelMostrarRegistrosJuegos = new PanelMostrarRegistroJuegos();

		getContentPane().add(panelIngresoCasaApuestas);
		getContentPane().add(panelLeerGamer);
		getContentPane().add(panelActualizarGamer);
		getContentPane().add(panelMostrarRegistrosJuegos);

		// Esto es temporal
		panelActualizarGamer.setVisible(false);
		panelLeerGamer.setVisible(false);
		panelMostrarRegistrosJuegos.setVisible(false);
		panelIngresoCasaApuestas.setVisible(true);

		panelActualizarGamer.getBotonActualizar().addActionListener(control);
		panelActualizarGamer.getBotonBorrar().addActionListener(control);
		panelLeerGamer.getBotonLeer().addActionListener(control);
		panelIngresoCasaApuestas.getBotonGuardar().addActionListener(control);
		panelMostrarRegistrosJuegos.getBotonLeer().addActionListener(control);

	}

	public void mostrarMensajeError(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public boolean mostrarMensajeAdvertencia() {
		int entrada = JOptionPane.showConfirmDialog(null, "Está seguro de querer borrar el gamer", "Advertencia",
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
		return panelActualizarGamer;
	}

	public void setPanelActualizarGamer(PanelActualizarBorrarApostador panelActualizarGamer) {
		this.panelActualizarGamer = panelActualizarGamer;
	}

	public PanelInformacionApostadores getPanelLeerGamer() {
		return panelLeerGamer;
	}

	public void setPanelLeerGamer(PanelInformacionApostadores panelLeerGamer) {
		this.panelLeerGamer = panelLeerGamer;
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
