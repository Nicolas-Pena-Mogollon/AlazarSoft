package co.edu.unbosque.view;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import co.edu.unbosque.controller.Controller;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelMenuCasaApuestas panelMenuCasaApuestas;
	private PanelIngresoCasaApuestas panelIngresoCasaApuestas;
	private PanelApostadores panelApostadores;
	private PanelSede panelSede;

	public View(Controller control) {

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new CardLayout());
		this.setSize(800, 250);
		this.setTitle("Casa de apuestas");
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		panelMenuCasaApuestas = new PanelMenuCasaApuestas();
		panelIngresoCasaApuestas = new PanelIngresoCasaApuestas();
		panelApostadores= new PanelApostadores();
		panelSede = new PanelSede();
		getContentPane().add(panelIngresoCasaApuestas);
		getContentPane().add(panelApostadores);
		getContentPane().add(panelSede);
		getContentPane().add(panelMenuCasaApuestas);

		// Esto es temporal
		panelMenuCasaApuestas.setVisible(true);
		panelApostadores.setVisible(false);
		panelIngresoCasaApuestas.setVisible(false);
		panelSede.setVisible(false);
		
		panelMenuCasaApuestas.getBotonConfiguracionCasaApuestas().addActionListener(control);
		panelMenuCasaApuestas.getBotonGestionSedes().addActionListener(control);
		panelMenuCasaApuestas.getBotonGestionApostadores().addActionListener(control);
		panelMenuCasaApuestas.getBotonGestionApuestas().addActionListener(control);
		panelMenuCasaApuestas.getBotonPlanesPremiacion().addActionListener(control);
		panelMenuCasaApuestas.getBotonConsultasReportes().addActionListener(control);
		panelIngresoCasaApuestas.getBotonGuardar().addActionListener(control);
		



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

	public PanelIngresoCasaApuestas getPanelIngresoCasaApuestas() {
		return panelIngresoCasaApuestas;
	}

	public void setPanelIngresoCasaApuestas(PanelIngresoCasaApuestas panelIngresoCasaApuestas) {
		this.panelIngresoCasaApuestas = panelIngresoCasaApuestas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
