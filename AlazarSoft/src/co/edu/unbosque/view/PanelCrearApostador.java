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
			comboSede.addItem(sede.get(i).getUbicacion());
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

	public JTextField getCampoTextoCedula() {
		return campoTextoCedula;
	}

	public void setCampoTextoCedula(JTextField campoTextoCedula) {
		this.campoTextoCedula = campoTextoCedula;
	}

	public JTextField getCampoTextoNombre() {
		return campoTextoNombre;
	}

	public void setCampoTextoNombre(JTextField campoTextoNombre) {
		this.campoTextoNombre = campoTextoNombre;
	}

	public JTextField getCampoTextoDireccion() {
		return campoTextoDireccion;
	}

	public void setCampoTextoDireccion(JTextField campoTextoDireccion) {
		this.campoTextoDireccion = campoTextoDireccion;
	}

	public JTextField getCampoTextoCelular() {
		return campoTextoCelular;
	}

	public void setCampoTextoCelular(JTextField campoTextoCelular) {
		this.campoTextoCelular = campoTextoCelular;
	}

	public JComboBox<String> getComboSede() {
		return comboSede;
	}

	public void setComboSede(JComboBox<String> comboSede) {
		this.comboSede = comboSede;
	}

	public JButton getBotonCrearApostador() {
		return botonCrearApostador;
	}

	public void setBotonCrearApostador(JButton botonCrearApostador) {
		this.botonCrearApostador = botonCrearApostador;
	}

	public String getCOMMAND_CREAR_APOSTADOR() {
		return COMMAND_CREAR_APOSTADOR;
	}

}
