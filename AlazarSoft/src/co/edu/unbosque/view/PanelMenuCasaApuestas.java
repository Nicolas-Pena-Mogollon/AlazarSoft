package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMenuCasaApuestas extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_CONFIGURACION_CASA_APUESTAS = "CONFIGURACION_CASA_APUESTAS";
	private final String COMMAND_GESTION_SEDES = "GESTION_SEDES";
	private final String COMMAND_GESTION_APOSTADORES = "GESTION_APOSTADORES";
	private final String COMMAND_GESTION_APUESTAS = "GESTION_APUESTAS";
	private final String COMMAND_PLANES_PREMIACION = "PLANES_PREMIACION";
	private final String COMMAND_CONSULTA_REPORTES = "CONSULTA_REPORTES";

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

		botonConfiguracionCasaApuestas.setActionCommand(COMMAND_CONFIGURACION_CASA_APUESTAS);
		botonGestionSedes.setActionCommand(COMMAND_GESTION_SEDES);
		botonGestionApostadores.setActionCommand(COMMAND_GESTION_APOSTADORES);
		botonGestionApuestas.setActionCommand(COMMAND_GESTION_APUESTAS);
		botonPlanesPremiacion.setActionCommand(COMMAND_PLANES_PREMIACION);
		botonConsultasReportes.setActionCommand(COMMAND_CONSULTA_REPORTES);

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCOMMAND_CONFIGURACION_CASA_APUESTAS() {
		return COMMAND_CONFIGURACION_CASA_APUESTAS;
	}

	public String getCOMMAND_GESTION_SEDES() {
		return COMMAND_GESTION_SEDES;
	}

	public String getCOMMAND_GESTION_APOSTADORES() {
		return COMMAND_GESTION_APOSTADORES;
	}

	public String getCOMMAND_GESTION_APUESTAS() {
		return COMMAND_GESTION_APUESTAS;
	}

	public String getCOMMAND_PLANES_PREMIACION() {
		return COMMAND_PLANES_PREMIACION;
	}

	public String getCOMMAND_CONSULTA_REPORTES() {
		return COMMAND_CONSULTA_REPORTES;
	}

}
