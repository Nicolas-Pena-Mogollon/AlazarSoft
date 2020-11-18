package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import co.edu.unbosque.model.persistence.ApostadorDTO;
import co.edu.unbosque.model.persistence.SedesDTO;

public class PanelApuesta extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_REGISTRAR_APUESTA_BALOTO = "REGISTRAR_APUESTA_BALOTO";
	private final String COMMAND_CAMBIAR_TIPO_APUESTA = "CAMBIAR_PANEL";
	private JSplitPane panelContenedorDividido;
	private JLabel etiquetaFecha;
	private JLabel etiquetaSede;
	private JLabel etiquetaCedula;
	private JLabel etiquetaValorApuesta;
	private JLabel etiquetaTipoApuesta;
	private JTextField campoTextoFecha;
	private JComboBox<String> comboCedula;
	private JComboBox<String> comboSede;
	private JComboBox<String> comboTiposApuesta;
	private JScrollPane scrollCedula;
	private JScrollPane scrollSede;
	private JTextField campoTextoValorApuesta;
	private JButton botonGuardarApuestaBaloto;
	private JPanel panelIngreso;
	private PanelApuestaBaloto panelApuestaBaloto;
	private PanelApuestaSuperAstro panelApuestaSuperAstro;
	private PanelApuestaFutbol panelApuestaFutbol;

	public PanelApuesta() {
		setBorder(new TitledBorder("Registro apuestas baloto"));
		setLayout(new BorderLayout());

		panelApuestaBaloto = new PanelApuestaBaloto();
		panelApuestaSuperAstro = new PanelApuestaSuperAstro();
		panelApuestaFutbol = new PanelApuestaFutbol();
		panelIngreso = new JPanel();
		panelIngreso.setLayout(new GridLayout(5, 2));
		etiquetaFecha = new JLabel("Fecha");
		etiquetaSede = new JLabel("Sede");
		etiquetaCedula = new JLabel("Cédula");
		etiquetaValorApuesta = new JLabel("Valor de la apuesta");
		etiquetaTipoApuesta = new JLabel("Tipo de apuesta");

		
		campoTextoFecha = new JTextField(this.hora());
		comboCedula = new JComboBox<String>();
		scrollCedula = new JScrollPane(comboCedula);
		comboSede = new JComboBox<String>();
		scrollSede = new JScrollPane(comboSede);
		comboTiposApuesta = new JComboBox<String>();
		comboTiposApuesta.addItem("Seleccione el tipo de apuesta");
		comboTiposApuesta.addItem("Baloto");
		comboTiposApuesta.addItem("Super Astro");
		comboTiposApuesta.addItem("Fútbol");
		comboTiposApuesta.setActionCommand(COMMAND_CAMBIAR_TIPO_APUESTA);
		campoTextoValorApuesta = new JTextField();

		panelIngreso.add(etiquetaFecha);
		panelIngreso.add(campoTextoFecha);
		panelIngreso.add(etiquetaSede);
		panelIngreso.add(scrollSede);
		panelIngreso.add(etiquetaCedula);
		panelIngreso.add(scrollCedula);
		panelIngreso.add(etiquetaValorApuesta);
		panelIngreso.add(campoTextoValorApuesta);
		panelIngreso.add(etiquetaTipoApuesta);
		panelIngreso.add(comboTiposApuesta);

		botonGuardarApuestaBaloto = new JButton("Registrar apuesta");
		botonGuardarApuestaBaloto.setActionCommand(COMMAND_REGISTRAR_APUESTA_BALOTO);

		panelContenedorDividido = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		panelContenedorDividido.setEnabled(false);
		panelContenedorDividido.setTopComponent(panelIngreso);

		this.add(panelContenedorDividido);
		this.add(botonGuardarApuestaBaloto, BorderLayout.PAGE_END);
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
	
	public String hora() {
		SimpleDateFormat formato = new SimpleDateFormat("hh: mm: ss a dd/MM/yyyy");
		Date date = new Date();
		return formato.format(date);
	}

	public JSplitPane getPanelContenedorDividido() {
		return panelContenedorDividido;
	}

	public void setPanelContenedorDividido(JSplitPane panelContenedorDividido) {
		this.panelContenedorDividido = panelContenedorDividido;
	}

	public JTextField getCampoTextoFecha() {
		return campoTextoFecha;
	}

	public void setCampoTextoFecha(JTextField campoTextoFecha) {
		this.campoTextoFecha = campoTextoFecha;
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

	public JComboBox<String> getComboTiposApuesta() {
		return comboTiposApuesta;
	}

	public void setComboTiposApuesta(JComboBox<String> comboTiposApuesta) {
		this.comboTiposApuesta = comboTiposApuesta;
	}

	public JTextField getCampoTextoValorApuesta() {
		return campoTextoValorApuesta;
	}

	public void setCampoTextoValorApuesta(JTextField campoTextoValorApuesta) {
		this.campoTextoValorApuesta = campoTextoValorApuesta;
	}

	public JButton getBotonGuardarApuestaBaloto() {
		return botonGuardarApuestaBaloto;
	}

	public void setBotonGuardarApuestaBaloto(JButton botonGuardarApuestaBaloto) {
		this.botonGuardarApuestaBaloto = botonGuardarApuestaBaloto;
	}

	public PanelApuestaBaloto getPanelApuestaBaloto() {
		return panelApuestaBaloto;
	}

	public void setPanelApuestaBaloto(PanelApuestaBaloto panelApuestaBaloto) {
		this.panelApuestaBaloto = panelApuestaBaloto;
	}

	public PanelApuestaSuperAstro getPanelApuestaSuperAstro() {
		return panelApuestaSuperAstro;
	}

	public void setPanelApuestaSuperAstro(PanelApuestaSuperAstro panelApuestaSuperAstro) {
		this.panelApuestaSuperAstro = panelApuestaSuperAstro;
	}

	public PanelApuestaFutbol getPanelApuestaFutbol() {
		return panelApuestaFutbol;
	}

	public void setPanelApuestaFutbol(PanelApuestaFutbol panelApuestaFutbol) {
		this.panelApuestaFutbol = panelApuestaFutbol;
	}

	public String getCOMMAND_REGISTRAR_APUESTA_BALOTO() {
		return COMMAND_REGISTRAR_APUESTA_BALOTO;
	}

	public String getCOMMAND_CAMBIAR_TIPO_APUESTA() {
		return COMMAND_CAMBIAR_TIPO_APUESTA;
	}

}
