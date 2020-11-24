package co.edu.unbosque.view;

import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInformeApuestasPorClienteSede extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel etiquetaOpcionExportar;
	private JLabel etiquetaFiltroFecha;
	private JLabel etiquetaFecha;
	private JComboBox<String> comboOpcionExportar;
	private JComboBox<String> comboFiltroFecha;
	private JTextField campoTextoFecha;
	
	
	public PanelInformeApuestasPorClienteSede() {
		setLayout(new GridLayout(3, 2));
		
		etiquetaFiltroFecha = new JLabel("Escoja el filtrado por feeecha");
		etiquetaOpcionExportar = new JLabel("Información a exportar");
		etiquetaFecha = new JLabel("Escriba la fecha en formato dd/mm/yyyy");
		
		comboFiltroFecha = new JComboBox<String>();
		comboFiltroFecha.addItem("Seleccione");
		comboFiltroFecha.addItem("día, mes y año");
		comboFiltroFecha.addItem("mes y año");
		comboFiltroFecha.addItem("año");

		comboOpcionExportar = new JComboBox<String>();
		comboOpcionExportar.addItem("Seleccione");
		comboOpcionExportar.addItem("Listado de clientes por sede");
		comboOpcionExportar.addItem("Valor total de apuestas por cliente");
		comboOpcionExportar.addItem("Detalle de apuestas realizadas por cliente y sede");
		comboOpcionExportar.addItem("Total de apuestas por sede y tipo de juego");
		SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
		campoTextoFecha = new JTextField(dateF.format(new Date()));
		
		
		add(etiquetaOpcionExportar);
		add(comboOpcionExportar);
		add(etiquetaFiltroFecha);
		add(comboFiltroFecha);
		add(etiquetaFecha);
		add(campoTextoFecha);
		
	
	}
	
	

	/**
	 * @return the comboOpcionExportar
	 */
	public JComboBox<String> getComboOpcionExportar() {
		return comboOpcionExportar;
	}

	/**
	 * @param comboOpcionExportar the comboOpcionExportar to set
	 */
	public void setComboOpcionExportar(JComboBox<String> comboOpcionExportar) {
		this.comboOpcionExportar = comboOpcionExportar;
	}

	/**
	 * @return the comboFiltroFecha
	 */
	public JComboBox<String> getComboFiltroFecha() {
		return comboFiltroFecha;
	}

	/**
	 * @param comboFiltroFecha the comboFiltroFecha to set
	 */
	public void setComboFiltroFecha(JComboBox<String> comboFiltroFecha) {
		this.comboFiltroFecha = comboFiltroFecha;
	}
	
	/**
	 * @return the campoTextoFecha
	 */
	public JTextField getCampoTextoFecha() {
		return campoTextoFecha;
	}

	/**
	 * @param campoTextoFecha the campoTextoFecha to set
	 */
	public void setCampoTextoFecha(JTextField campoTextoFecha) {
		this.campoTextoFecha = campoTextoFecha;
	}


}
