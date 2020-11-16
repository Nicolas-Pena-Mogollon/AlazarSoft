package co.edu.unbosque.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;

import co.edu.unbosque.controller.Controller;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelMenuCasaApuestas panelMenuCasaApuestas;
	private PanelIngresoCasaApuestas panelIngresoCasaApuestas;
	private PanelApostadores panelApostadores;
	private PanelApuesta panelApuesta;
	private PanelSede panelSede;
	private JSplitPane splitPane;

	public View(Controller control) {

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(800, 250);
		this.setTitle("Casa de apuestas");
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		panelMenuCasaApuestas = new PanelMenuCasaApuestas();
		panelIngresoCasaApuestas = new PanelIngresoCasaApuestas();
		panelApostadores = new PanelApostadores();
		panelSede = new PanelSede();
		panelApuesta = new PanelApuesta();

		splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setLeftComponent(panelMenuCasaApuestas);
		splitPane.setRightComponent(panelApostadores);
		getContentPane().add(splitPane);
		panelMenuCasaApuestas.getBotonConfiguracionCasaApuestas().addActionListener(control);
		panelMenuCasaApuestas.getBotonGestionSedes().addActionListener(control);
		panelMenuCasaApuestas.getBotonGestionApostadores().addActionListener(control);
		panelMenuCasaApuestas.getBotonGestionApuestas().addActionListener(control);
		panelMenuCasaApuestas.getBotonPlanesPremiacion().addActionListener(control);
		panelMenuCasaApuestas.getBotonConsultasReportes().addActionListener(control);
		panelIngresoCasaApuestas.getBotonGuardar().addActionListener(control);
		revalidate();
		repaint();

	}

	public void mostrarMensajeError(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public boolean mostrarMensajeAdvertencia() {
		int entrada = JOptionPane.showConfirmDialog(null, "", "Advertencia", JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);
		if (entrada == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void mostrarMensajeInformacion(String message) {
		JOptionPane.showMessageDialog(null, message, "Información", JOptionPane.INFORMATION_MESSAGE);
	}

	public PanelMenuCasaApuestas getPanelMenuCasaApuestas() {
		return panelMenuCasaApuestas;
	}

	public void setPanelMenuCasaApuestas(PanelMenuCasaApuestas panelMenuCasaApuestas) {
		this.panelMenuCasaApuestas = panelMenuCasaApuestas;
	}

	public PanelIngresoCasaApuestas getPanelIngresoCasaApuestas() {
		return panelIngresoCasaApuestas;
	}

	public void setPanelIngresoCasaApuestas(PanelIngresoCasaApuestas panelIngresoCasaApuestas) {
		this.panelIngresoCasaApuestas = panelIngresoCasaApuestas;
	}

	public PanelApostadores getPanelApostadores() {
		return panelApostadores;
	}

	public void setPanelApostadores(PanelApostadores panelApostadores) {
		this.panelApostadores = panelApostadores;
	}

	public PanelSede getPanelSede() {
		return panelSede;
	}

	public void setPanelSede(PanelSede panelSede) {
		this.panelSede = panelSede;
	}

	public PanelApuesta getPanelApuesta() {
		return panelApuesta;
	}

	public void setPanelApuesta(PanelApuesta panelApuesta) {
		this.panelApuesta = panelApuesta;
	}

	public JSplitPane getSplitPane() {
		return splitPane;
	}

	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}

}
