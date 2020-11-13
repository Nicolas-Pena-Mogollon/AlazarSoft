package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import co.edu.unbosque.controller.Controller;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTabbedPane pestanas;
	private PanelCrearGamer panelCrearGamer;
	private PanelActualizarBorrarGamer panelActualizarGamer;
	private PanelLeerGamer panelLeerGamer;
	private PanelIngresoDatosJuego panelIngresoDatosJuegos;
	private PanelMostrarRegistroJuegos panelMostrarRegistrosJuegos;

	public View(Controller control) {

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 250);
		this.setTitle("Gamers de Discord");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);

		pestanas = new JTabbedPane();
		panelCrearGamer = new PanelCrearGamer();
		panelActualizarGamer = new PanelActualizarBorrarGamer();
		panelLeerGamer = new PanelLeerGamer();
		panelIngresoDatosJuegos = new PanelIngresoDatosJuego();
		panelMostrarRegistrosJuegos = new PanelMostrarRegistroJuegos();

		pestanas.add(panelCrearGamer, "Crear Gamer");
		pestanas.add(panelLeerGamer, "Leer Gamers");
		pestanas.add(panelActualizarGamer, "Actualizar/Borrar Gamers");
		pestanas.add(panelIngresoDatosJuegos, "Ingresar datos de juego");
		pestanas.add(panelMostrarRegistrosJuegos, "Datos de los juegos");

		getContentPane().add(pestanas);
		revalidate();
		repaint();

		panelCrearGamer.getBotonIngresar().addActionListener(control);
		panelActualizarGamer.getBotonActualizar().addActionListener(control);
		panelActualizarGamer.getBotonBorrar().addActionListener(control);
		panelLeerGamer.getBotonLeer().addActionListener(control);
		panelIngresoDatosJuegos.getBotonIngresar().addActionListener(control);
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

	public JTabbedPane getPestanas() {
		return pestanas;
	}

	public void setPestanas(JTabbedPane pestanas) {
		this.pestanas = pestanas;
	}

	public PanelCrearGamer getPanelCrearGamer() {
		return panelCrearGamer;
	}

	public void setPanelCrearGamer(PanelCrearGamer panelCrearGamer) {
		this.panelCrearGamer = panelCrearGamer;
	}

	public PanelActualizarBorrarGamer getPanelActualizarGamer() {
		return panelActualizarGamer;
	}

	public void setPanelActualizarGamer(PanelActualizarBorrarGamer panelActualizarGamer) {
		this.panelActualizarGamer = panelActualizarGamer;
	}

	public PanelLeerGamer getPanelLeerGamer() {
		return panelLeerGamer;
	}

	public void setPanelLeerGamer(PanelLeerGamer panelLeerGamer) {
		this.panelLeerGamer = panelLeerGamer;
	}

	public PanelIngresoDatosJuego getPanelIngresoDatosJuegos() {
		return panelIngresoDatosJuegos;
	}

	public void setPanelIngresoDatosJuegos(PanelIngresoDatosJuego panelIngresoDatosJuegos) {
		this.panelIngresoDatosJuegos = panelIngresoDatosJuegos;
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
