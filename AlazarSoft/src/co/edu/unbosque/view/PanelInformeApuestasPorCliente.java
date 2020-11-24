package co.edu.unbosque.view;

import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInformeApuestasPorCliente extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private final String COMMAND_INFORME_APUESTAS_POR_CLIENTE = "Generar informe Apuestas por cliente";
	private final String COMMAND_LIMPIAR_INFORME = "limpiar informe";
	
	private JLabel etiquetaCliente;
	private JLabel etiquetaFechaInicio;
	private JLabel etiquetaFechaFin;
	private JTextField campoTextoCliente;
	private JTextField campoTextoFechaInicio;
	private JTextField campoTextoFechaFin;
	private JButton botonGenerarInforme;
	private JButton botonLimpiarInforme;
	
	
	public PanelInformeApuestasPorCliente() {
		setLayout(new GridLayout(4, 2));
		
		etiquetaCliente = new JLabel("Ingrese numero de identificaciòn del cliente");
		etiquetaFechaInicio = new JLabel("Desde la fecha");
		etiquetaFechaFin = new JLabel("Hasta la fecha");

		campoTextoCliente = new JTextField();

		
		SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
		campoTextoFechaInicio = new JTextField(dateF.format(new Date()));
		campoTextoFechaFin = new JTextField(dateF.format(new Date()));
		
		
		botonGenerarInforme = new JButton("Generar informe");
		botonGenerarInforme.setActionCommand(COMMAND_INFORME_APUESTAS_POR_CLIENTE);
		
		botonLimpiarInforme =  new JButton("Limpiar informe");
		botonLimpiarInforme.setActionCommand(COMMAND_LIMPIAR_INFORME);
		
		
		
		add(etiquetaCliente);
		add(campoTextoCliente);
		
		add(etiquetaFechaInicio);
		add(campoTextoFechaInicio);
		
		add(etiquetaFechaFin);
		add(campoTextoFechaFin);
		
		add(botonGenerarInforme);
		add(botonLimpiarInforme);
		
		
		
	
	}


	public JTextField getCampoTextoCliente() {
		return campoTextoCliente;
	}


	public void setCampoTextoCliente(JTextField campoTextoCliente) {
		this.campoTextoCliente = campoTextoCliente;
	}


	public JTextField getCampoTextoFechaInicio() {
		return campoTextoFechaInicio;
	}


	public void setCampoTextoFechaInicio(JTextField campoTextoFechaInicio) {
		this.campoTextoFechaInicio = campoTextoFechaInicio;
	}


	public JTextField getCampoTextoFechaFin() {
		return campoTextoFechaFin;
	}


	public void setCampoTextoFechaFin(JTextField campoTextoFechaFin) {
		this.campoTextoFechaFin = campoTextoFechaFin;
	}


	public JButton getBotonGenerarInforme() {
		return botonGenerarInforme;
	}


	public void setBotonGenerarInforme(JButton botonGenerarInforme) {
		this.botonGenerarInforme = botonGenerarInforme;
	}


	public JButton getBotonLimpiarInforme() {
		return botonLimpiarInforme;
	}


	public void setBotonLimpiarInforme(JButton botonLimpiarInforme) {
		this.botonLimpiarInforme = botonLimpiarInforme;
	}


	public String getCOMMAND_INFORME_APUESTAS_POR_CLIENTE() {
		return COMMAND_INFORME_APUESTAS_POR_CLIENTE;
	}


	public String getCOMMAND_LIMPIAR_INFORME() {
		return COMMAND_LIMPIAR_INFORME;
	}
	
	

}
