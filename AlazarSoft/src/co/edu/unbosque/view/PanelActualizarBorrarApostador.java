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

import co.edu.unbosque.model.persistence.ApostadorDTO;
import co.edu.unbosque.model.persistence.SedesDTO;

public class PanelActualizarBorrarApostador extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_ACTUALIZAR = "ACTUALIZAR_INFO_APOSTADOR";
	private final String COMMAND_BORRAR = "BORRAR_APOSTADOR";
	private JLabel etiquetaNombre;
	private JLabel etiquetaCedula;
	private JLabel etiquetaSede;
	private JLabel etiquetaDireccion;
	private JLabel etiquetaCelular;
	private JTextField campoTextoNombre;
	private JTextField campoTextoDireccion;
	private JTextField campoTextoCelular;
	private JComboBox<String> comboCedula;
	private JComboBox<String> comboSede;
	private JScrollPane scrollCedula;
	private JScrollPane scrollSede;
	private JButton botonActualizar;
	private JButton botonBorrar;
	private JPanel panelIngreso;
	private JPanel panelBotones;

	public PanelActualizarBorrarApostador() {

		setBorder(new TitledBorder("Actualizar/Borrar apostadores"));
		setLayout(new BorderLayout());
		panelIngreso = new JPanel();
		panelIngreso.setLayout(new GridLayout(5, 2));

		etiquetaCedula = new JLabel("Cédula");
		etiquetaNombre = new JLabel("Nombre completo");
		etiquetaSede = new JLabel("Sede");
		etiquetaDireccion = new JLabel("Dirección");
		etiquetaCelular = new JLabel("Celular");

		comboCedula = new JComboBox<String>();
		scrollCedula = new JScrollPane(comboCedula);
		comboSede = new JComboBox<String>();
		scrollSede = new JScrollPane(comboSede);

		campoTextoNombre = new JTextField();
		campoTextoDireccion = new JTextField();
		campoTextoCelular = new JTextField();

		panelIngreso.add(etiquetaSede);
		panelIngreso.add(scrollSede);

		panelIngreso.add(etiquetaCedula);
		panelIngreso.add(scrollCedula);

		panelIngreso.add(etiquetaNombre);
		panelIngreso.add(campoTextoNombre);

		panelIngreso.add(etiquetaDireccion);
		panelIngreso.add(campoTextoDireccion);

		panelIngreso.add(etiquetaCelular);
		panelIngreso.add(campoTextoCelular);

		panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1, 2));

		botonActualizar = new JButton("Actualizar");
		botonActualizar.setActionCommand(COMMAND_ACTUALIZAR);
		botonBorrar = new JButton("Borrar");
		botonBorrar.setActionCommand(COMMAND_BORRAR);

		panelBotones.add(botonActualizar);
		panelBotones.add(botonBorrar);

		this.add(panelIngreso, BorderLayout.CENTER);
		this.add(panelBotones, BorderLayout.PAGE_END);

	}

	public String[] verificarEntradasActualizarInformacionApostador() {
		String[] salida = new String[6];
		salida[0] = "0";
		if ((!campoTextoNombre.getText().equals("") || !campoTextoDireccion.getText().equals("")
				|| !campoTextoCelular.getText().equals("") || !comboSede.getSelectedItem().equals("Seleccione"))
				&& !comboCedula.getSelectedItem().equals("Seleccione")) {
			salida[1] = campoTextoNombre.getText();
			salida[2] = campoTextoDireccion.getText();
			salida[3] = campoTextoCelular.getText();
			salida[4] = String.valueOf(comboSede.getSelectedItem());
			salida[5] = String.valueOf(comboCedula.getSelectedItem());
		} else {
			salida[0] = "1";
			salida[1] = "Los campos deben ser completados";
		}
		return salida;
	}

	public String[] verificarEntradasBorrarInformacionApostador() {
		String[] salida = new String[3];
		salida[0] = "0";
		if (!comboCedula.getSelectedItem().equals("Seleccione")) {
			salida[1] = (String) comboCedula.getSelectedItem();
			salida[2] = "Se ha borrado el apostador";
		} else {
			salida[0] = "1";
			salida[1] = "Los campos deben ser completados";
		}
		return salida;
	}

	public void borrarCampos() {
		this.campoTextoNombre.setText("");
		this.comboCedula.setSelectedIndex(0);
	}

	public void cargarId(ArrayList<ApostadorDTO> data) {
		this.comboCedula.removeAllItems();
		this.comboCedula.addItem("Seleccione");
		for (int i = 0; i < data.size(); i++)
			this.comboCedula.addItem(data.get(i).getCedula());
	}
	
	public void cargarComboBox(ArrayList<SedesDTO> sede) {
		this.comboSede.removeAllItems();
		this.comboSede.addItem("Seleccione");
		for (int i = 0; i < sede.size(); i++) {
			this.comboSede.addItem(sede.get(i).getUbicacion());
		}
	}

	public JComboBox<String> getComboCedula() {
		return comboCedula;
	}

	public void setComboCedula(JComboBox<String> comboCedula) {
		this.comboCedula = comboCedula;
	}

	public JComboBox<String> getComboSede() {
		return comboSede;
	}

	public void setComboSede(JComboBox<String> comboSede) {
		this.comboSede = comboSede;
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

	public JButton getBotonActualizar() {
		return botonActualizar;
	}

	public void setBotonActualizar(JButton botonActualizar) {
		this.botonActualizar = botonActualizar;
	}

	public JButton getBotonBorrar() {
		return botonBorrar;
	}

	public void setBotonBorrar(JButton botonBorrar) {
		this.botonBorrar = botonBorrar;
	}

	public String getCOMMAND_ACTUALIZAR() {
		return COMMAND_ACTUALIZAR;
	}

	public String getCOMMAND_BORRAR() {
		return COMMAND_BORRAR;
	}

}
