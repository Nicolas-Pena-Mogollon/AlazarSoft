package co.edu.unbosque.view;

import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import co.edu.unbosque.model.persistence.SedesDTO;

public class PanelInformeClientePorSede extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private final String COMMAND_INFORME_CLIENTE_POR_SEDE = "Generar informe cliente por sede";
	private final String COMMAND_LIMPIAR_INFORME = "limpiar informe";

	private JLabel etiquetaSede;
	private JComboBox<String> comboSede;
	private JScrollPane scrollSede;
	private JButton botonGenerarInforme;
	private JButton botonLimpiarInforme;


	
	public PanelInformeClientePorSede() {
		setLayout(new GridLayout(2, 2));
		
		etiquetaSede = new JLabel("Escoja la sede");
		comboSede = new JComboBox<String>();
		scrollSede = new JScrollPane(comboSede);
		
		botonGenerarInforme = new JButton("Generar informe");
		botonGenerarInforme.setActionCommand(COMMAND_INFORME_CLIENTE_POR_SEDE);
		
		botonLimpiarInforme =  new JButton("Limpiar informe");
		botonLimpiarInforme.setActionCommand(COMMAND_LIMPIAR_INFORME);
		
		
		add(etiquetaSede);
		add(scrollSede);
		add(botonGenerarInforme);
		add(botonLimpiarInforme);
		
		
	
	}
	
	public void cargarComboBox(ArrayList<SedesDTO> sede) {
		this.comboSede.removeAllItems();
		this.comboSede.addItem("Seleccione");
		for (int i = 0; i < sede.size(); i++) {
			this.comboSede.addItem(sede.get(i).getUbicacion() + sede.get(i).getIdUbicacion());
		}
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

	public String getCOMMAND_INFORME_CLIENTE_POR_SEDE() {
		return COMMAND_INFORME_CLIENTE_POR_SEDE;
	}

	public String getCOMMAND_LIMPIAR_INFORME() {
		return COMMAND_LIMPIAR_INFORME;
	}

	public JLabel getEtiquetaSede() {
		return etiquetaSede;
	}

	public void setEtiquetaSede(JLabel etiquetaSede) {
		this.etiquetaSede = etiquetaSede;
	}

	public JComboBox<String> getComboSede() {
		return comboSede;
	}

	public void setComboSede(JComboBox<String> comboSede) {
		this.comboSede = comboSede;
	}

	public JScrollPane getScrollSede() {
		return scrollSede;
	}

	public void setScrollSede(JScrollPane scrollSede) {
		this.scrollSede = scrollSede;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	


}
