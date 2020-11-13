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

public class PanelActualizarBorrarGamer extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_ACTUALIZAR = "ACTUALIZAR";
	private final String COMMAND_BORRAR = "BORRAR";
	private JLabel etiquetaID;
	private JLabel etiquetaNickName;
	private JComboBox<String> comboID;
	private JScrollPane scroll;
	private JTextField campoTextoNickName;
	private JButton botonActualizar;
	private JButton botonBorrar;
	private JPanel panelIngreso;
	private JPanel panelBotones;

	public PanelActualizarBorrarGamer() {

		setBorder(new TitledBorder("Actualizar datos gamer"));
		setLayout(new BorderLayout());
		panelIngreso = new JPanel();
		panelIngreso.setLayout(new GridLayout(4, 1));

		etiquetaID = new JLabel("ID");
		etiquetaNickName = new JLabel("NickName");

		comboID = new JComboBox<String>();
		scroll = new JScrollPane(comboID);
		campoTextoNickName = new JTextField();

		panelIngreso.add(etiquetaID);
		panelIngreso.add(scroll);

		panelIngreso.add(etiquetaNickName);
		panelIngreso.add(campoTextoNickName);

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
		String id = (String) comboID.getSelectedItem();
		String nickName = campoTextoNickName.getText();
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
		if (!comboID.getSelectedItem().equals("Seleccione")) {
			salida[1] = (String) comboID.getSelectedItem();
			salida[2] = "Se ha borrado el jugador";
		} else {
			salida[0] = "1";
			salida[1] = "Los campos deben ser completados";
		}
		return salida;
	}

	public void borrarCampos() {
		this.campoTextoNickName.setText("");
		this.comboID.setSelectedIndex(0);
	}

	public void cargarId(String[] data) {
		this.comboID.removeAllItems();
		this.comboID.addItem("Seleccione");
		for (int i = 0; i < data.length; i++)
			this.comboID.addItem(data[i]);
	}

	public JLabel getEtiquetaID() {
		return etiquetaID;
	}

	public void setEtiquetaID(JLabel etiquetaID) {
		this.etiquetaID = etiquetaID;
	}

	public JLabel getEtiquetaNickName() {
		return etiquetaNickName;
	}

	public void setEtiquetaNickName(JLabel etiquetaNickName) {
		this.etiquetaNickName = etiquetaNickName;
	}

	public JComboBox<String> getComboID() {
		return comboID;
	}

	public void setComboID(JComboBox<String> comboID) {
		this.comboID = comboID;
	}

	public JTextField getCampoTextoNickName() {
		return campoTextoNickName;
	}

	public void setCampoTextoNickName(JTextField campoTextoNickName) {
		this.campoTextoNickName = campoTextoNickName;
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
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

}
