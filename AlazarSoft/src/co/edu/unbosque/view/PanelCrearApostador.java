package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import co.edu.unbosque.model.persistence.SedesDTO;

/**
 * Clase PanelCrearApostador
 */

public class PanelCrearApostador extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_CREAR_APOSTADOR = "CREACION_APOSTADOR";
	private JLabel etiquetaNombre;
	private JLabel etiquetaCedula;
	private JLabel etiquetaSede;
	private JLabel etiquetaDireccion;
	private JLabel etiquetaCelular;
	private JTextField campoTextoCedula;
	private JTextField campoTextoNombre;
	private JTextField campoTextoDireccion;
	private JTextField campoTextoCelular;
	private JComboBox<String> comboSede;
	private JScrollPane scrollSede;
	private JButton botonCrearApostador;
	private JPanel panelIngreso;
	private JPanel panelBotones;

	/**
	 * Constructor con inicialización de atributos
	 */
	
	public PanelCrearApostador() {
		setBorder(new TitledBorder("Añadir apostadores"));
		setLayout(new BorderLayout());

		panelIngreso = new JPanel();
		panelIngreso.setLayout(new GridLayout(5, 2));

		etiquetaCedula = new JLabel("Cédula");
		etiquetaNombre = new JLabel("Nombre completo");
		etiquetaSede = new JLabel("Sede");
		etiquetaDireccion = new JLabel("Dirección");
		etiquetaCelular = new JLabel("Celular");

		campoTextoCedula = new JTextField();
		campoTextoNombre = new JTextField();
		campoTextoDireccion = new JTextField();
		campoTextoCelular = new JTextField();

		comboSede = new JComboBox<String>();
		scrollSede = new JScrollPane(comboSede);

		panelIngreso.add(etiquetaSede);
		panelIngreso.add(scrollSede);

		panelIngreso.add(etiquetaCedula);
		panelIngreso.add(campoTextoCedula);

		panelIngreso.add(etiquetaNombre);
		panelIngreso.add(campoTextoNombre);

		panelIngreso.add(etiquetaDireccion);
		panelIngreso.add(campoTextoDireccion);

		panelIngreso.add(etiquetaCelular);
		panelIngreso.add(campoTextoCelular);

		panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1, 2));

		botonCrearApostador = new JButton("Añadir");
		botonCrearApostador.setActionCommand(COMMAND_CREAR_APOSTADOR);

		this.add(panelIngreso, BorderLayout.CENTER);
		this.add(botonCrearApostador, BorderLayout.PAGE_END);
	}

	public void cargarComboBox(ArrayList<SedesDTO> sede) {
		comboSede.removeAllItems();
		comboSede.addItem("Selecciona la sede");
		for (int i = 0; i < sede.size(); i++) {
			comboSede.addItem(sede.get(i).getUbicacion() + sede.get(i).getIdUbicacion());
		}
	}

	public boolean verificarCamposVacios() {
		if (!campoTextoCedula.getText().equals("") && !campoTextoCelular.getText().equals("")
				&& !campoTextoDireccion.getText().equals("") && !campoTextoNombre.getText().equals("")
				&& !comboSede.getSelectedItem().equals("Selecciona la sede")) {
			return true;
		} else {
			return false;
		}
	}

	public void limpiarCampos() {
		campoTextoCedula.setText("");
		campoTextoCelular.setText("");
		campoTextoDireccion.setText("");
		campoTextoNombre.setText("");
		comboSede.setSelectedIndex(0);
	}

	/**
	 * @return the etiquetaNombre
	 */
	public JLabel getEtiquetaNombre() {
		return etiquetaNombre;
	}

	/**
	 * @param etiquetaNombre the etiquetaNombre to set
	 */
	public void setEtiquetaNombre(JLabel etiquetaNombre) {
		this.etiquetaNombre = etiquetaNombre;
	}

	/**
	 * @return the etiquetaCedula
	 */
	public JLabel getEtiquetaCedula() {
		return etiquetaCedula;
	}

	/**
	 * @param etiquetaCedula the etiquetaCedula to set
	 */
	public void setEtiquetaCedula(JLabel etiquetaCedula) {
		this.etiquetaCedula = etiquetaCedula;
	}

	/**
	 * @return the etiquetaSede
	 */
	public JLabel getEtiquetaSede() {
		return etiquetaSede;
	}

	/**
	 * @param etiquetaSede the etiquetaSede to set
	 */
	public void setEtiquetaSede(JLabel etiquetaSede) {
		this.etiquetaSede = etiquetaSede;
	}

	/**
	 * @return the etiquetaDireccion
	 */
	public JLabel getEtiquetaDireccion() {
		return etiquetaDireccion;
	}

	/**
	 * @param etiquetaDireccion the etiquetaDireccion to set
	 */
	public void setEtiquetaDireccion(JLabel etiquetaDireccion) {
		this.etiquetaDireccion = etiquetaDireccion;
	}

	/**
	 * @return the etiquetaCelular
	 */
	public JLabel getEtiquetaCelular() {
		return etiquetaCelular;
	}

	/**
	 * @param etiquetaCelular the etiquetaCelular to set
	 */
	public void setEtiquetaCelular(JLabel etiquetaCelular) {
		this.etiquetaCelular = etiquetaCelular;
	}

	/**
	 * @return the campoTextoCedula
	 */
	public JTextField getCampoTextoCedula() {
		return campoTextoCedula;
	}

	/**
	 * @param campoTextoCedula the campoTextoCedula to set
	 */
	public void setCampoTextoCedula(JTextField campoTextoCedula) {
		this.campoTextoCedula = campoTextoCedula;
	}

	/**
	 * @return the campoTextoNombre
	 */
	public JTextField getCampoTextoNombre() {
		return campoTextoNombre;
	}

	/**
	 * @param campoTextoNombre the campoTextoNombre to set
	 */
	public void setCampoTextoNombre(JTextField campoTextoNombre) {
		this.campoTextoNombre = campoTextoNombre;
	}

	/**
	 * @return the campoTextoDireccion
	 */
	public JTextField getCampoTextoDireccion() {
		return campoTextoDireccion;
	}

	/**
	 * @param campoTextoDireccion the campoTextoDireccion to set
	 */
	public void setCampoTextoDireccion(JTextField campoTextoDireccion) {
		this.campoTextoDireccion = campoTextoDireccion;
	}

	/**
	 * @return the campoTextoCelular
	 */
	public JTextField getCampoTextoCelular() {
		return campoTextoCelular;
	}

	/**
	 * @param campoTextoCelular the campoTextoCelular to set
	 */
	public void setCampoTextoCelular(JTextField campoTextoCelular) {
		this.campoTextoCelular = campoTextoCelular;
	}

	/**
	 * @return the comboSede
	 */
	public JComboBox<String> getComboSede() {
		return comboSede;
	}

	/**
	 * @param comboSede the comboSede to set
	 */
	public void setComboSede(JComboBox<String> comboSede) {
		this.comboSede = comboSede;
	}

	/**
	 * @return the scrollSede
	 */
	public JScrollPane getScrollSede() {
		return scrollSede;
	}

	/**
	 * @param scrollSede the scrollSede to set
	 */
	public void setScrollSede(JScrollPane scrollSede) {
		this.scrollSede = scrollSede;
	}

	/**
	 * @return the botonCrearApostador
	 */
	public JButton getBotonCrearApostador() {
		return botonCrearApostador;
	}

	/**
	 * @param botonCrearApostador the botonCrearApostador to set
	 */
	public void setBotonCrearApostador(JButton botonCrearApostador) {
		this.botonCrearApostador = botonCrearApostador;
	}

	/**
	 * @return the panelIngreso
	 */
	public JPanel getPanelIngreso() {
		return panelIngreso;
	}

	/**
	 * @param panelIngreso the panelIngreso to set
	 */
	public void setPanelIngreso(JPanel panelIngreso) {
		this.panelIngreso = panelIngreso;
	}

	/**
	 * @return the panelBotones
	 */
	public JPanel getPanelBotones() {
		return panelBotones;
	}

	/**
	 * @param panelBotones the panelBotones to set
	 */
	public void setPanelBotones(JPanel panelBotones) {
		this.panelBotones = panelBotones;
	}

	/**
	 * @return the cOMMAND_CREAR_APOSTADOR
	 */
	public String getCOMMAND_CREAR_APOSTADOR() {
		return COMMAND_CREAR_APOSTADOR;
	}

}
