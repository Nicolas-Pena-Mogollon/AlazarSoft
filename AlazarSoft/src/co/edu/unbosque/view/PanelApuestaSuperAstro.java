package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * Clase PanelApuestaSuperAstro
 */

public class PanelApuestaSuperAstro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel etiquetaNumero;
	private JLabel etiquetaSigno;
	private JTextField campoTextoPrimerNumero;
	private JTextField campoTextoSegundoNumero;
	private JTextField campoTextoTercerNumero;
	private JTextField campoTextoCuartoNumero;
	private JComboBox<String> SignoZodiacal;
	private JPanel panelCamposDeTextoNumero;

	/**
	 * Constructor con inicialización de atributos
	 */

	public PanelApuestaSuperAstro() {
		setBorder(new TitledBorder("Apuesta Super Astro"));
		setLayout(new GridLayout(1, 2));

		SignoZodiacal = new JComboBox<String>();
		etiquetaSigno = new JLabel("Signo del Zodiaco");
		etiquetaNumero = new JLabel("Número");

		panelCamposDeTextoNumero = new JPanel();
		panelCamposDeTextoNumero.setLayout(new GridLayout(1, 4));

		campoTextoPrimerNumero = new JTextField();
		campoTextoSegundoNumero = new JTextField();
		campoTextoTercerNumero = new JTextField();
		campoTextoCuartoNumero = new JTextField();

		campoTextoPrimerNumero.setBorder(new LineBorder(Color.GRAY));
		campoTextoSegundoNumero.setBorder(new LineBorder(Color.GRAY));
		campoTextoTercerNumero.setBorder(new LineBorder(Color.GRAY));
		campoTextoCuartoNumero.setBorder(new LineBorder(Color.GRAY));

		panelCamposDeTextoNumero.add(campoTextoPrimerNumero);
		panelCamposDeTextoNumero.add(campoTextoSegundoNumero);
		panelCamposDeTextoNumero.add(campoTextoTercerNumero);
		panelCamposDeTextoNumero.add(campoTextoCuartoNumero);

		this.add(etiquetaNumero);
		this.add(panelCamposDeTextoNumero);
		this.add(etiquetaSigno);
		this.add(SignoZodiacal);
		llenarComboZodiaco();
		SignoZodiacal.setSelectedIndex(0);
	}

	/**
	 * Se llena el combobox de los signos zodiacales
	 */

	public void llenarComboZodiaco() {
		SignoZodiacal.addItem("Seleccione un signo");
		SignoZodiacal.addItem("Aries");
		SignoZodiacal.addItem("Tauro");
		SignoZodiacal.addItem("Geminis");
		SignoZodiacal.addItem("Cancer");
		SignoZodiacal.addItem("Leo");
		SignoZodiacal.addItem("Virgo");
		SignoZodiacal.addItem("Libra");
		SignoZodiacal.addItem("Escorpio");
		SignoZodiacal.addItem("Sagitario");
		SignoZodiacal.addItem("Capricornio");
		SignoZodiacal.addItem("Acuario");
		SignoZodiacal.addItem("Piscis");

	}

	/**
	 * @return the etiquetaNumero
	 */
	public JLabel getEtiquetaNumero() {
		return etiquetaNumero;
	}

	/**
	 * @param etiquetaNumero the etiquetaNumero to set
	 */
	public void setEtiquetaNumero(JLabel etiquetaNumero) {
		this.etiquetaNumero = etiquetaNumero;
	}

	/**
	 * @return the etiquetaSigno
	 */
	public JLabel getEtiquetaSigno() {
		return etiquetaSigno;
	}

	/**
	 * @param etiquetaSigno the etiquetaSigno to set
	 */
	public void setEtiquetaSigno(JLabel etiquetaSigno) {
		this.etiquetaSigno = etiquetaSigno;
	}

	/**
	 * @return the campoTextoPrimerNumero
	 */
	public JTextField getCampoTextoPrimerNumero() {
		return campoTextoPrimerNumero;
	}

	/**
	 * @param campoTextoPrimerNumero the campoTextoPrimerNumero to set
	 */
	public void setCampoTextoPrimerNumero(JTextField campoTextoPrimerNumero) {
		this.campoTextoPrimerNumero = campoTextoPrimerNumero;
	}

	/**
	 * @return the campoTextoSegundoNumero
	 */
	public JTextField getCampoTextoSegundoNumero() {
		return campoTextoSegundoNumero;
	}

	/**
	 * @param campoTextoSegundoNumero the campoTextoSegundoNumero to set
	 */
	public void setCampoTextoSegundoNumero(JTextField campoTextoSegundoNumero) {
		this.campoTextoSegundoNumero = campoTextoSegundoNumero;
	}

	/**
	 * @return the campoTextoTercerNumero
	 */
	public JTextField getCampoTextoTercerNumero() {
		return campoTextoTercerNumero;
	}

	/**
	 * @param campoTextoTercerNumero the campoTextoTercerNumero to set
	 */
	public void setCampoTextoTercerNumero(JTextField campoTextoTercerNumero) {
		this.campoTextoTercerNumero = campoTextoTercerNumero;
	}

	/**
	 * @return the campoTextoCuartoNumero
	 */
	public JTextField getCampoTextoCuartoNumero() {
		return campoTextoCuartoNumero;
	}

	/**
	 * @param campoTextoCuartoNumero the campoTextoCuartoNumero to set
	 */
	public void setCampoTextoCuartoNumero(JTextField campoTextoCuartoNumero) {
		this.campoTextoCuartoNumero = campoTextoCuartoNumero;
	}

	/**
	 * @return the signoZodiacal
	 */
	public JComboBox<String> getSignoZodiacal() {
		return SignoZodiacal;
	}

	/**
	 * @param signoZodiacal the signoZodiacal to set
	 */
	public void setSignoZodiacal(JComboBox<String> signoZodiacal) {
		SignoZodiacal = signoZodiacal;
	}

	/**
	 * @return the panelCamposDeTextoNumero
	 */
	public JPanel getPanelCamposDeTextoNumero() {
		return panelCamposDeTextoNumero;
	}

	/**
	 * @param panelCamposDeTextoNumero the panelCamposDeTextoNumero to set
	 */
	public void setPanelCamposDeTextoNumero(JPanel panelCamposDeTextoNumero) {
		this.panelCamposDeTextoNumero = panelCamposDeTextoNumero;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
