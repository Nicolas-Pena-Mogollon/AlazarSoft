/**
 * Paquete vista
 */
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

import co.edu.unbosque.model.persistence.SedesDTO;

/**
 * Clase PanelCrearApuesta
 */
public class PanelCrearApuesta extends JPanel {

	/**
	 * Asociacion clase PanelApuestaBaloto Asociacion clase PanelApuestaSuperAstro
	 * Asociacion clase PanelApuestaFutbol
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private final String COMMAND_REGISTRAR_APUESTA = "REGISTRAR_APUESTA";
	private final String COMMAND_CAMBIAR_TIPO_APUESTA = "CAMBIAR_PANEL";
	private JSplitPane panelContenedorDividido;
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
	private JButton botonGuardarApuestaBaloto;
	private JPanel panelIngreso;
	private PanelApuestaBaloto panelApuestaBaloto;
	private PanelApuestaSuperAstro panelApuestaSuperAstro;
	private PanelApuestaFutbol panelApuestaFutbol;

	/**
	 * Constructor con inicializaci�n de atributos
	 */

	public PanelCrearApuesta() {
		setBorder(new TitledBorder("Registro de apuestas"));
		setLayout(new BorderLayout());

		panelApuestaBaloto = new PanelApuestaBaloto();
		panelApuestaSuperAstro = new PanelApuestaSuperAstro();
		panelApuestaFutbol = new PanelApuestaFutbol();
		panelIngreso = new JPanel();
		panelIngreso.setLayout(new GridLayout(5, 2));
		etiquetaFecha = new JLabel("Fecha");
		etiquetaSede = new JLabel("Sede");
		etiquetaCedula = new JLabel("C�dula");
		etiquetaValorApuesta = new JLabel("Valor de la apuesta");
		etiquetaTipoApuesta = new JLabel("Tipo de apuesta");

		campoTextoFecha = new JTextField(this.hora());
		campoTextoFecha.setEditable(false);
		campoTextoCedula = new JTextField();
		comboSede = new JComboBox<String>();
		scrollSede = new JScrollPane(comboSede);
		comboTiposApuesta = new JComboBox<String>();
		comboTiposApuesta.addItem("Seleccione el tipo de apuesta");
		comboTiposApuesta.addItem("Baloto");
		comboTiposApuesta.addItem("Super Astro");
		comboTiposApuesta.addItem("F�tbol");
		comboTiposApuesta.setActionCommand(COMMAND_CAMBIAR_TIPO_APUESTA);
		campoTextoValorApuesta = new JTextField();

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

		botonGuardarApuestaBaloto = new JButton("Registrar apuesta");
		botonGuardarApuestaBaloto.setActionCommand(COMMAND_REGISTRAR_APUESTA);

		panelContenedorDividido = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		panelContenedorDividido.setEnabled(false);
		panelContenedorDividido.setTopComponent(panelIngreso);

		this.add(panelContenedorDividido);
		this.add(botonGuardarApuestaBaloto, BorderLayout.PAGE_END);
	}

	/**
	 * Se carga el Combobox con los valores de la sede
	 * 
	 * @param sede
	 */

	public void cargarComboBox(ArrayList<SedesDTO> sede) {
		this.comboSede.removeAllItems();
		this.comboSede.addItem("Seleccione");
		for (int i = 0; i < sede.size(); i++) {
			this.comboSede.addItem(sede.get(i).getUbicacion() + sede.get(i).getIdUbicacion());
		}
	}

	/**
	 * Verifica que los campos de texto de Baloto esten con valores
	 * 
	 * @return verificar
	 */

	public boolean verificarCamposBaloto() {
		boolean verificar = false;
		if (!campoTextoCedula.getText().equals("") && !comboSede.getSelectedItem().equals("Seleccione")
				&& !comboTiposApuesta.getSelectedItem().equals("Seleccione el tipo de apuesta")
				&& !panelApuestaBaloto.getCampoTextoPrimerNumero().getText().equals("")
				&& !panelApuestaBaloto.getCampoTextoSegundoNumero().getText().equals("")
				&& !panelApuestaBaloto.getCampoTextoTercerNumero().getText().equals("")
				&& !panelApuestaBaloto.getCampoTextoCuartoNumero().getText().equals("")
				&& !panelApuestaBaloto.getCampoTextoQuintoNumero().getText().equals("")
				&& !panelApuestaBaloto.getCampoTextoSextoNumero().getText().equals("")
				&& !campoTextoValorApuesta.getText().equals("")) {
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;
	}

	/**
	 * Limpia los campos de texto y borra los valores que tengan en la interfaz
	 */

	public void limpiarCamposBaloto() {
		campoTextoCedula.setText("");
		comboSede.setSelectedIndex(0);
		comboTiposApuesta.setSelectedIndex(0);
		campoTextoValorApuesta.setText("");
		panelApuestaBaloto.getCampoTextoPrimerNumero().setText("");
		panelApuestaBaloto.getCampoTextoSegundoNumero().setText("");
		panelApuestaBaloto.getCampoTextoTercerNumero().setText("");
		panelApuestaBaloto.getCampoTextoCuartoNumero().setText("");
		panelApuestaBaloto.getCampoTextoQuintoNumero().setText("");
		panelApuestaBaloto.getCampoTextoSextoNumero().setText("");
	}

	/**
	 * Verifica que los campos de texto de SuperAstro esten con valores
	 * 
	 * @return verificar
	 */
	public boolean verificarCamposSuperAstro() {
		boolean verificar = false;
		if (!campoTextoCedula.getText().equals("Seleccione") && !comboSede.getSelectedItem().equals("Seleccione")
				&& !comboTiposApuesta.getSelectedItem().equals("Seleccione el tipo de apuesta")
				&& !campoTextoValorApuesta.getText().equals("")
				&& !panelApuestaSuperAstro.getCampoTextoPrimerNumero().getText().equals("")
				&& !panelApuestaSuperAstro.getCampoTextoSegundoNumero().getText().equals("")
				&& !panelApuestaSuperAstro.getCampoTextoTercerNumero().getText().equals("")
				&& !panelApuestaSuperAstro.getCampoTextoCuartoNumero().getText().equals("")
				&& !panelApuestaSuperAstro.getSignoZodiacal().getSelectedItem().equals("Seleccione un signo")) {
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;
	}

	/**
	 * Limpia los campos de texto y borra los valores que tengan en la interfaz
	 */

	public void limpiarCamposSuperAstro() {
		campoTextoCedula.setText("");
		comboSede.setSelectedIndex(0);
		comboTiposApuesta.setSelectedIndex(0);
		campoTextoValorApuesta.setText("");
		panelApuestaSuperAstro.getCampoTextoPrimerNumero().setText("");
		panelApuestaSuperAstro.getCampoTextoSegundoNumero().setText("");
		panelApuestaSuperAstro.getCampoTextoTercerNumero().setText("");
		panelApuestaSuperAstro.getCampoTextoCuartoNumero().setText("");
		panelApuestaSuperAstro.getSignoZodiacal().setSelectedIndex(0);
	}

	/**
	 * Verifica que los campos de texto de Marcadores de f�tbol esten con valores
	 * 
	 * @return verificar
	 */
	public boolean verificarCamposFutbol() {
		boolean verificar = false;
		if (!campoTextoCedula.getText().equals("Seleccione") && !comboSede.getSelectedItem().equals("Seleccione")
				&& !comboTiposApuesta.getSelectedItem().equals("Seleccione el tipo de apuesta")
				&& !campoTextoValorApuesta.getText().equals("")
				&& !panelApuestaFutbol.getComboPartidos().getSelectedItem().equals("Seleccione")
				&& !panelApuestaFutbol.getComboOpcionResultado().getSelectedItem().equals("Seleccione")) {
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;
	}

	/**
	 * Limpia los campos de texto y borra los valores que tengan en la interfaz
	 */
	public void limpiarCamposFutbol() {
		campoTextoCedula.setText("");
		;
		comboSede.setSelectedIndex(0);
		comboTiposApuesta.setSelectedIndex(0);
		campoTextoValorApuesta.setText("");
		panelApuestaFutbol.getComboPartidos().setSelectedIndex(0);
		panelApuestaFutbol.getComboOpcionResultado().setSelectedIndex(0);
	}

	/**
	 * Cambia de panel para guardar los datos de cada apuesta. <b> pre</> Necesita
	 * haber llenado todos los datos para guardar yn hechizo
	 */

	public void cambiarPanel() {
		if (comboTiposApuesta.getSelectedItem().equals("Baloto"))
			panelContenedorDividido.setBottomComponent(panelApuestaBaloto);
		else if (comboTiposApuesta.getSelectedItem().equals("Super Astro"))
			panelContenedorDividido.setBottomComponent(panelApuestaSuperAstro);
		else if (comboTiposApuesta.getSelectedItem().equals("F�tbol"))
			panelContenedorDividido.setBottomComponent(panelApuestaFutbol);
	}

	/**
	 * Crea el mensaje que mostrara los parametros usados en modo de recibo
	 * 
	 * @param fecha
	 * @param sede
	 * @param cedula
	 * @param valor
	 * @param numeroJuego
	 * @return
	 */

	public String facturaBaloto(String fecha, String sede, String cedula, double valor, String numeroJuego) {
		String factura = "";
		factura += "Fecha: " + fecha + "\n" + "Sede: " + sede + "\n" + "C�dula: " + cedula + "\n" + "Valor: " + valor
				+ "\n" + "NumeroJuego: " + numeroJuego + "\n";
		return factura;
	}

	/**
	 * * Crea el mensaje que mostrara los parametros usados en modo de recibo
	 * 
	 * @param fecha
	 * @param sede
	 * @param cedula
	 * @param valor
	 * @param numeroJuego
	 * @param signo
	 * @return
	 */

	public String facturaSuperastro(String fecha, String sede, String cedula, double valor, String numeroJuego,
			String signo) {
		String factura = "";
		factura += "Fecha: " + fecha + "\n" + "Sede: " + sede + "\n" + "C�dula: " + cedula + "\n" + "Valor: " + valor
				+ "\n" + "NumeroJuego: " + numeroJuego + "\n" + "Signo: " + signo + "\n";
		return factura;
	}

	/**
	 * * Crea el mensaje que mostrara los parametros usados en modo de recibo
	 * 
	 * @param fecha
	 * @param sede
	 * @param cedula
	 * @param valor
	 * @param numeroJuego
	 * @param signo
	 * @return
	 */
	public String facturaFutbol(String fecha, String sede, String cedula, double valor, String partido,
			String resultado) {
		String factura = "";
		factura += "Fecha: " + fecha + "\n" + "Sede: " + sede + "\n" + "C�dula: " + cedula + "\n" + "Valor: " + valor
				+ "\n" + "Partido: " + partido + "\n" + "Resultado: " + resultado + "\n";
		return factura;
	}

	public String hora() {
		SimpleDateFormat formato = new SimpleDateFormat("hh: mm: ss a dd/MM/yyyy");
		Date date = new Date();
		return formato.format(date);
	}

	/**
	 * @return the panelContenedorDividido
	 */
	public JSplitPane getPanelContenedorDividido() {
		return panelContenedorDividido;
	}

	/**
	 * @param panelContenedorDividido the panelContenedorDividido to set
	 */
	public void setPanelContenedorDividido(JSplitPane panelContenedorDividido) {
		this.panelContenedorDividido = panelContenedorDividido;
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
	 * @return the botonGuardarApuestaBaloto
	 */
	public JButton getBotonGuardarApuestaBaloto() {
		return botonGuardarApuestaBaloto;
	}

	/**
	 * @param botonGuardarApuestaBaloto the botonGuardarApuestaBaloto to set
	 */
	public void setBotonGuardarApuestaBaloto(JButton botonGuardarApuestaBaloto) {
		this.botonGuardarApuestaBaloto = botonGuardarApuestaBaloto;
	}

	/**
	 * @return the panelApuestaBaloto
	 */
	public PanelApuestaBaloto getPanelApuestaBaloto() {
		return panelApuestaBaloto;
	}

	/**
	 * @param panelApuestaBaloto the panelApuestaBaloto to set
	 */
	public void setPanelApuestaBaloto(PanelApuestaBaloto panelApuestaBaloto) {
		this.panelApuestaBaloto = panelApuestaBaloto;
	}

	/**
	 * @return the panelApuestaSuperAstro
	 */
	public PanelApuestaSuperAstro getPanelApuestaSuperAstro() {
		return panelApuestaSuperAstro;
	}

	/**
	 * @param panelApuestaSuperAstro the panelApuestaSuperAstro to set
	 */
	public void setPanelApuestaSuperAstro(PanelApuestaSuperAstro panelApuestaSuperAstro) {
		this.panelApuestaSuperAstro = panelApuestaSuperAstro;
	}

	/**
	 * @return the panelApuestaFutbol
	 */
	public PanelApuestaFutbol getPanelApuestaFutbol() {
		return panelApuestaFutbol;
	}

	/**
	 * @param panelApuestaFutbol the panelApuestaFutbol to set
	 */
	public void setPanelApuestaFutbol(PanelApuestaFutbol panelApuestaFutbol) {
		this.panelApuestaFutbol = panelApuestaFutbol;
	}

	/**
	 * @return the cOMMAND_REGISTRAR_APUESTA
	 */
	public String getCOMMAND_REGISTRAR_APUESTA() {
		return COMMAND_REGISTRAR_APUESTA;
	}

	/**
	 * @return the cOMMAND_CAMBIAR_TIPO_APUESTA
	 */
	public String getCOMMAND_CAMBIAR_TIPO_APUESTA() {
		return COMMAND_CAMBIAR_TIPO_APUESTA;
	}
}
