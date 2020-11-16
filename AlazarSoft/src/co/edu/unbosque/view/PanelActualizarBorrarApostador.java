package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelActualizarBorrarApostador extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_ACTUALIZAR = "ACTUALIZAR";
	private final String COMMAND_BORRAR = "BORRAR";
	private JLabel etiquetaNombre;
	private JLabel etiquetaCedula;
	private JLabel etiquetaSede;
	private JLabel etiquetaDireccion;
	private JLabel etiquetaCelular;
	private JComboBox<String> comboCedula;
	private JComboBox<String> comboSede;
	private JScrollPane scrollCedula;
	private JScrollPane scrollSede;
	private JTextField campoTextoNombre;
	private JTextField campoTextoDireccion;
	private JTextField campoTextoCelular;
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

	public String[] verificarEntradasActualizar() {
		String[] salida = new String[4];
		salida[0] = "0";
		String id = (String) comboCedula.getSelectedItem();
		String nickName = campoTextoNombre.getText();
		if (!nickName.equals("") && !id.equals("Seleccione")) {
			if (nickName.length() == 8) {
				salida[1] = nickName;
				salida[2] = id;
				salida[3] = "Se ha actualizado la información del jugador";
			} else {
				salida[0] = "1";
				salida[1] = "El nickName debe ser de 8 carácteres";
			}
		} else {
			salida[0] = "1";
			salida[1] = "Los campos deben ser completados";
		}
		return salida;
	}

	public String[] verificarEntradasBorrar() {
		String[] salida = new String[3];
		salida[0] = "0";
		if (!comboCedula.getSelectedItem().equals("Seleccione")) {
			salida[1] = (String) comboCedula.getSelectedItem();
			salida[2] = "Se ha borrado el jugador";
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

	public void cargarId(String[] data) {
		this.comboCedula.removeAllItems();
		this.comboCedula.addItem("Seleccione");
		for (int i = 0; i < data.length; i++)
			this.comboCedula.addItem(data[i]);
	}

	public JLabel getEtiquetaID() {
		return etiquetaCedula;
	}

	public void setEtiquetaID(JLabel etiquetaID) {
		this.etiquetaCedula = etiquetaID;
	}

	public JLabel getEtiquetaNickName() {
		return etiquetaNombre;
	}

	public void setEtiquetaNickName(JLabel etiquetaNickName) {
		this.etiquetaNombre = etiquetaNickName;
	}

	public JComboBox<String> getComboID() {
		return comboCedula;
	}

	public void setComboID(JComboBox<String> comboID) {
		this.comboCedula = comboID;
	}

	public JTextField getCampoTextoNickName() {
		return campoTextoNombre;
	}

	public void setCampoTextoNickName(JTextField campoTextoNickName) {
		this.campoTextoNombre = campoTextoNickName;
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

	public JPanel getPanelIngreso() {
		return panelIngreso;
	}

	public void setPanelIngreso(JPanel panelIngreso) {
		this.panelIngreso = panelIngreso;
	}

	public JPanel getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(JPanel panelBotones) {
		this.panelBotones = panelBotones;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCOMMAND_ACTUALIZAR() {
		return COMMAND_ACTUALIZAR;
	}

	public String getCOMMAND_BORRAR() {
		return COMMAND_BORRAR;
	}

	public JScrollPane getScroll() {
		return scrollCedula;
	}

	public void setScroll(JScrollPane scroll) {
		this.scrollCedula = scroll;
	}
}
