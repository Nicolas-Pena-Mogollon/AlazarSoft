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

public class PanelIngresoDatosJuego extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_INGRESAR = "INGRESAR_DATOS";
	private JLabel etiquetaNombreJuego;
	private JLabel etiquetaID;
	private JLabel etiquetaDiaSemana;
	private JLabel etiquetaPuntos;
	private JTextField campoTextoNombreJuego;
	private JComboBox<String> comboID;
	private JScrollPane scroll;
	private JComboBox<String> comboDiaSemana;
	private JTextField campoTextoPuntos;
	private JButton botonIngresar;
	private JPanel panelIngreso;

	public PanelIngresoDatosJuego() {

		setBorder(new TitledBorder("Ingreso de los datos de juego"));
		setLayout(new BorderLayout());
		panelIngreso = new JPanel();
		panelIngreso.setLayout(new GridLayout(4, 2));

		etiquetaNombreJuego = new JLabel("Juego");
		etiquetaID = new JLabel("ID");
		etiquetaDiaSemana = new JLabel("Día de la semana");
		etiquetaPuntos = new JLabel("Puntos");

		campoTextoNombreJuego = new JTextField();
		comboID = new JComboBox<String>();
		scroll = new JScrollPane(comboID);

		comboDiaSemana = new JComboBox<String>();
		comboDiaSemana.addItem("Seleccione");
		comboDiaSemana.addItem("Lunes");
		comboDiaSemana.addItem("Martes");
		comboDiaSemana.addItem("Miércoles");
		comboDiaSemana.addItem("Jueves");
		comboDiaSemana.addItem("Viernes");
		comboDiaSemana.addItem("Sábado");
		comboDiaSemana.addItem("Domingo");

		campoTextoPuntos = new JTextField();

		panelIngreso.add(etiquetaNombreJuego);
		panelIngreso.add(campoTextoNombreJuego);

		panelIngreso.add(etiquetaID);
		panelIngreso.add(scroll);

		panelIngreso.add(etiquetaDiaSemana);
		panelIngreso.add(comboDiaSemana);

		panelIngreso.add(etiquetaPuntos);
		panelIngreso.add(campoTextoPuntos);

		botonIngresar = new JButton("Registrar");
		botonIngresar.setActionCommand(COMMAND_INGRESAR);

		this.add(panelIngreso, BorderLayout.CENTER);
		this.add(botonIngresar, BorderLayout.PAGE_END);

	}

	public String[] verificarEntradasIngresoDatosJuegos() {
		String[] salida = new String[6];
		salida[0] = "0";
		if (!campoTextoNombreJuego.getText().equals("") && !campoTextoPuntos.getText().equals("")
				&& !comboDiaSemana.getSelectedItem().equals("Seleccione")
				&& !comboID.getSelectedItem().equals("Seleccione")) {
			String juego = campoTextoNombreJuego.getText();
			String id = (String) comboID.getSelectedItem();
			String diaSemana = (String) comboDiaSemana.getSelectedItem();
			String puntos = campoTextoPuntos.getText();
			try {
				if (Integer.parseInt(puntos) < 0) {
					salida[0] = "1";
					salida[1] = "Valor de puntos incorrecto";
				}
			} catch (NumberFormatException e) {
				salida[0] = "1";
				salida[1] = "Valor de puntos incorrecto";
			}
			if (salida[0].equals("0")) {
				salida[1] = juego;
				salida[2] = id;
				salida[3] = diaSemana;
				salida[4] = puntos;
				salida[5] = "Se ha actualizado la información del jugador";
			}
		} else {
			salida[0] = "1";
			salida[1] = "Los campos deben ser completados";
		}
		return salida;
	}

	public void borrarCamposPanelIngresoJuego() {
		this.comboDiaSemana.setSelectedIndex(0);
		this.comboID.setSelectedIndex(0);
		this.campoTextoNombreJuego.setText("");
		this.campoTextoPuntos.setText("");
	}

	public void cargarIdPanelIngresoJuegos(String[] data) {
		this.comboID.removeAllItems();
		this.comboID.addItem("Seleccione");
		for (int i = 0; i < data.length; i++)
			this.comboID.addItem(data[i]);
	}

	public JTextField getCampoTextoNombreJuego() {
		return campoTextoNombreJuego;
	}

	public void setCampoTextoNombreJuego(JTextField campoTextoNombreJuego) {
		this.campoTextoNombreJuego = campoTextoNombreJuego;
	}

	public JComboBox<String> getComboID() {
		return comboID;
	}

	public void setComboID(JComboBox<String> comboID) {
		this.comboID = comboID;
	}

	public JTextField getCampoTextoPuntos() {
		return campoTextoPuntos;
	}

	public void setCampoTextoPuntos(JTextField campoTextoPuntos) {
		this.campoTextoPuntos = campoTextoPuntos;
	}

	public JButton getBotonIngresar() {
		return botonIngresar;
	}

	public void setBotonIngresar(JButton botonIngresar) {
		this.botonIngresar = botonIngresar;
	}

	public String getCOMMAND_INGRESAR() {
		return COMMAND_INGRESAR;
	}

}
