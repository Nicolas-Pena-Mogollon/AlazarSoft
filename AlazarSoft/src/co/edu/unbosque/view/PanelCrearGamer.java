package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelCrearGamer extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_INGRESAR = "INGRESAR";
	private JLabel etiquetaNickName;
	private JTextField campoTextoNickName;
	private JButton botonIngresar;
	private JPanel panelCont;

	public PanelCrearGamer() {

		setBorder(new TitledBorder("crear gamer"));
		this.setLayout(new BorderLayout());

		panelCont = new JPanel();
		panelCont.setLayout(new GridLayout(1,2));

		etiquetaNickName = new JLabel("NickName");
		campoTextoNickName = new JTextField();

		panelCont.add(etiquetaNickName);
		panelCont.add(campoTextoNickName);

		botonIngresar = new JButton("Registrar");
		botonIngresar.setActionCommand(COMMAND_INGRESAR);

		this.add(panelCont, BorderLayout.PAGE_START);
		this.add(botonIngresar, BorderLayout.PAGE_END);

	}

	public String[] verificarEntradasCreacionGamer() {
		String[] salida = new String[4];
		salida[0] = "0";
		if (!this.campoTextoNickName.getText().equals("")) {
			String nickName = this.campoTextoNickName.getText();
			if (nickName.length() != 8) {
				salida[0] = "1";
				salida[1] = "El nickName debe ser de 8 carácteres";
			} else {
				salida[1] = nickName;
				salida[2] = "Se ha registrado correctamente el jugador";
			}
		} else {
			salida[0] = "1";
			salida[1] = "Todos los campos deben ser completados";
		}
		return salida;
	}

	public void borrarCamposTexto() {
		campoTextoNickName.setText("");
	}

	public JLabel getEtiquetaNickName() {
		return etiquetaNickName;
	}

	public void setEtiquetaNickName(JLabel etiquetaNickName) {
		this.etiquetaNickName = etiquetaNickName;
	}

	public JTextField getCampoTextoNickName() {
		return campoTextoNickName;
	}

	public void setCampoTextoNickName(JTextField campoTextoNickName) {
		this.campoTextoNickName = campoTextoNickName;
	}

	public JButton getBotonIngresar() {
		return botonIngresar;
	}

	public void setBotonIngresar(JButton botonIngresar) {
		this.botonIngresar = botonIngresar;
	}

	public JPanel getPanelCont() {
		return panelCont;
	}

	public void setPanelCont(JPanel panelCont) {
		this.panelCont = panelCont;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCOMMAND_INGRESAR() {
		return COMMAND_INGRESAR;
	}

}
