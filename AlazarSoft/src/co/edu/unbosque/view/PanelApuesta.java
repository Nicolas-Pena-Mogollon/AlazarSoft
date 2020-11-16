package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanelApuesta extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_REGISTRAR_APUESTA_BALOTO = "REGISTRAR_APUESTA_BALOTO";
	private JLabel etiquetaFecha;
	private JLabel etiquetaSede;
	private JLabel etiquetaCedula;
	private JLabel etiquetaValorApuesta;
	private JTextField campoTextoFecha;
	private JComboBox<String> comboCedula;
	private JComboBox<String> comboSede;
	private JScrollPane scrollCedula;
	private JScrollPane scrollSede;
	private JTextField campoTextoValorApuesta;
	private JButton botonGuardarApuestaBaloto;
	private JPanel panelIngreso;

	public PanelApuesta() {
		setBorder(new TitledBorder("Registro apuestas baloto"));
		setLayout(new BorderLayout());

		panelIngreso = new JPanel();
		panelIngreso.setLayout(new GridLayout(5, 2));
		etiquetaFecha = new JLabel("Fecha");
		etiquetaSede = new JLabel("Sede");
		etiquetaCedula = new JLabel("Cédula");
		etiquetaValorApuesta = new JLabel("Valor de la apuesta");

		campoTextoFecha = new JTextField();
		comboCedula = new JComboBox<String>();
		scrollCedula = new JScrollPane(comboCedula);
		comboSede = new JComboBox<String>();
		scrollSede = new JScrollPane(comboSede);
		campoTextoValorApuesta = new JTextField();

		panelIngreso.add(etiquetaFecha);
		panelIngreso.add(campoTextoFecha);
		panelIngreso.add(etiquetaSede);
		panelIngreso.add(scrollSede);
		panelIngreso.add(etiquetaCedula);
		panelIngreso.add(scrollCedula);
		panelIngreso.add(etiquetaValorApuesta);
		panelIngreso.add(campoTextoValorApuesta);

		botonGuardarApuestaBaloto = new JButton("Registrar apuesta");
		botonGuardarApuestaBaloto.setActionCommand(COMMAND_REGISTRAR_APUESTA_BALOTO);

		this.add(panelIngreso, BorderLayout.CENTER);
		this.add(botonGuardarApuestaBaloto, BorderLayout.PAGE_END);

	}

}
