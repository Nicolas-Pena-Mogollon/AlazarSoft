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

public class PanelModificarApuesta extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_MODIFICAR_APUESTA = "MODIFICAR_APUESTA";
	private JLabel etiquetaFecha;
	private JLabel etiquetaSede;
	private JLabel etiquetaCedula;
	private JLabel etiquetaValorApuesta;
	private JLabel etiquetaTipoApuesta;
	private JTextField campoTextoFecha;
	private JTextField campoTextoCedula;
	private JComboBox<String> comboSede;
	private JComboBox<String> comboTiposApuesta;
	private JScrollPane scrollSede;
	private JTextField campoTextoValorApuesta;
	private JButton botonModificarApuesta;
	private JPanel panelIngreso;

	public PanelModificarApuesta() {
		setBorder(new TitledBorder("Modificar apuestas"));
		setLayout(new BorderLayout());

		panelIngreso = new JPanel();
		panelIngreso.setLayout(new GridLayout(5, 2));
		etiquetaFecha = new JLabel("Fecha");
		etiquetaSede = new JLabel("Sede");
		etiquetaCedula = new JLabel("Cédula");
		etiquetaValorApuesta = new JLabel("Valor de la apuesta");
		etiquetaTipoApuesta = new JLabel("Tipo de apuesta");

		campoTextoCedula = new JTextField();
		comboSede = new JComboBox<String>();
		scrollSede = new JScrollPane(comboSede);
		comboTiposApuesta = new JComboBox<String>();
		comboTiposApuesta.addItem("Seleccione el tipo de apuesta");
		comboTiposApuesta.addItem("Baloto");
		comboTiposApuesta.addItem("Super Astro");
		comboTiposApuesta.addItem("Fútbol");
		campoTextoValorApuesta = new JTextField();
		campoTextoFecha = new JTextField();

		panelIngreso.add(etiquetaFecha);
		panelIngreso.add(campoTextoFecha);
		panelIngreso.add(etiquetaSede);
		panelIngreso.add(scrollSede);
		panelIngreso.add(etiquetaCedula);
		panelIngreso.add(campoTextoCedula);
		panelIngreso.add(etiquetaValorApuesta);
		panelIngreso.add(campoTextoValorApuesta);
		panelIngreso.add(etiquetaTipoApuesta);
		panelIngreso.add(comboTiposApuesta);

		botonModificarApuesta = new JButton("Modificar");
		botonModificarApuesta.setActionCommand(COMMAND_MODIFICAR_APUESTA);

		add(panelIngreso, BorderLayout.CENTER);
		add(botonModificarApuesta, BorderLayout.PAGE_END);
	}

	public boolean verificarCampos() {
		boolean verificar = false;
		if (!campoTextoCedula.getText().equals("") && !campoTextoValorApuesta.getText().equals("")
				&& !comboSede.getSelectedItem().equals("Seleccione")
				&& !comboTiposApuesta.getSelectedItem().equals("Seleccione el tipo de apuesta")) {
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;
	}

	public void cargarComboBox(ArrayList<SedesDTO> sede) {
		this.comboSede.removeAllItems();
		this.comboSede.addItem("Seleccione");
		for (int i = 0; i < sede.size(); i++) {
			this.comboSede.addItem(sede.get(i).getUbicacion() + sede.get(i).getIdUbicacion());
		}
	}

	public void limpiarCampos() {
		campoTextoCedula.setText("");
		comboSede.setSelectedIndex(0);
		comboTiposApuesta.setSelectedIndex(0);
		campoTextoValorApuesta.setText("");
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
	 * @return the comboTiposApuesta
	 */
	public JComboBox<String> getComboTiposApuesta() {
		return comboTiposApuesta;
	}

	/**
	 * @param comboTiposApuesta the comboTiposApuesta to set
	 */
	public void setComboTiposApuesta(JComboBox<String> comboTiposApuesta) {
		this.comboTiposApuesta = comboTiposApuesta;
	}

	/**
	 * @return the campoTextoValorApuesta
	 */
	public JTextField getCampoTextoValorApuesta() {
		return campoTextoValorApuesta;
	}

	/**
	 * @param campoTextoValorApuesta the campoTextoValorApuesta to set
	 */
	public void setCampoTextoValorApuesta(JTextField campoTextoValorApuesta) {
		this.campoTextoValorApuesta = campoTextoValorApuesta;
	}

	/**
	 * @return the cOMMAND_MODIFICAR_APUESTA
	 */
	public String getCOMMAND_MODIFICAR_APUESTA() {
		return COMMAND_MODIFICAR_APUESTA;
	}

	/**
	 * @return the botonModificarApuesta
	 */
	public JButton getBotonModificarApuesta() {
		return botonModificarApuesta;
	}

	/**
	 * @param botonModificarApuesta the botonModificarApuesta to set
	 */
	public void setBotonModificarApuesta(JButton botonModificarApuesta) {
		this.botonModificarApuesta = botonModificarApuesta;
	}

}
