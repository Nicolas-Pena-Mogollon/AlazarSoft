package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMenuCasaApuestas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton botonConfiguracionCasaApuestas;
	private JButton botonGestionSedes;
	private JButton botonGestionApostadores;
	private JButton botonGestionApuestas;
	private JButton botonPlanesPremiacion;
	private JButton botonConsultasReportes;

	public PanelMenuCasaApuestas() {

		setLayout(new GridLayout(6, 1));

		botonConfiguracionCasaApuestas = new JButton("Configuración casa de apuestas");
		botonGestionSedes = new JButton("Gestión de sedes");
		botonGestionApostadores = new JButton("Gestion de apostadores");
		botonGestionApuestas = new JButton("Gestion de las apuestas");
		botonPlanesPremiacion = new JButton("Planes y premiación");
		botonConsultasReportes = new JButton("Consulta de reportes");

		add(botonConfiguracionCasaApuestas);
		add(botonGestionSedes);
		add(botonGestionApostadores);
		add(botonGestionApuestas);
		add(botonPlanesPremiacion);
		add(botonConsultasReportes);

	}

	public JButton getBotonConfiguracionCasaApuestas() {
		return botonConfiguracionCasaApuestas;
	}

	public void setBotonConfiguracionCasaApuestas(JButton botonConfiguracionCasaApuestas) {
		this.botonConfiguracionCasaApuestas = botonConfiguracionCasaApuestas;
	}

	public JButton getBotonGestionSedes() {
		return botonGestionSedes;
	}

	public void setBotonGestionSedes(JButton botonGestionSedes) {
		this.botonGestionSedes = botonGestionSedes;
	}

	public JButton getBotonGestionApostadores() {
		return botonGestionApostadores;
	}

	public void setBotonGestionApostadores(JButton botonGestionApostadores) {
		this.botonGestionApostadores = botonGestionApostadores;
	}

	public JButton getBotonGestionApuestas() {
		return botonGestionApuestas;
	}

	public void setBotonGestionApuestas(JButton botonGestionApuestas) {
		this.botonGestionApuestas = botonGestionApuestas;
	}

	public JButton getBotonPlanesPremiacion() {
		return botonPlanesPremiacion;
	}

	public void setBotonPlanesPremiacion(JButton botonPlanesPremiacion) {
		this.botonPlanesPremiacion = botonPlanesPremiacion;
	}

	public JButton getBotonConsultasReportes() {
		return botonConsultasReportes;
	}

	public void setBotonConsultasReportes(JButton botonConsultasReportes) {
		this.botonConsultasReportes = botonConsultasReportes;
	}

}
