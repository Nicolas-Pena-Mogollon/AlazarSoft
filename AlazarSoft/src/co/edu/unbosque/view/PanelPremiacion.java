/**
 * Paquete vista
 */
package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 * Clase PanelPremiacion
 */

public class PanelPremiacion extends JTabbedPane {

	private static final long serialVersionUID = 1L;
	private JPanel panelPremiacionBaloto;
	private JTextArea campoTextoPremiacionBaloto;
	private JScrollPane scrollCampoTextoPremiacionBaloto;
	private JPanel panelPremiacionSuperastro;
	private JTextArea campoTextoPremiacionSuperastro;
	private JScrollPane scrollCampoTextoPremiacionSuperastro;
	private JPanel panelPremiacionFutbol;
	private JTextArea campoTextoPremiacionFutbol;
	private JScrollPane scrollCampoTextoPremiacionFutbol;

	/**
	 * Constructor con inicialización de atributos
	 */

	public PanelPremiacion() {
		panelPremiacionBaloto = new JPanel(new GridLayout(1, 1));
		campoTextoPremiacionBaloto = new JTextArea();
		campoTextoPremiacionBaloto.setEditable(false);
		campoTextoPremiacionBaloto.setLineWrap(true);
		campoTextoPremiacionBaloto.setWrapStyleWord(true);
		campoTextoPremiacionBaloto.setOpaque(false);
		scrollCampoTextoPremiacionBaloto = new JScrollPane(campoTextoPremiacionBaloto);
		panelPremiacionBaloto.add(scrollCampoTextoPremiacionBaloto);

		panelPremiacionSuperastro = new JPanel(new GridLayout(1, 1));
		campoTextoPremiacionSuperastro = new JTextArea();
		campoTextoPremiacionSuperastro.setEditable(false);
		campoTextoPremiacionSuperastro.setLineWrap(true);
		campoTextoPremiacionSuperastro.setWrapStyleWord(true);
		campoTextoPremiacionSuperastro.setOpaque(false);
		scrollCampoTextoPremiacionSuperastro = new JScrollPane(campoTextoPremiacionSuperastro);
		panelPremiacionSuperastro.add(scrollCampoTextoPremiacionSuperastro);

		panelPremiacionFutbol = new JPanel(new GridLayout(1, 1));
		campoTextoPremiacionFutbol = new JTextArea();
		campoTextoPremiacionFutbol.setEditable(false);
		campoTextoPremiacionFutbol.setLineWrap(true);
		campoTextoPremiacionFutbol.setWrapStyleWord(true);
		campoTextoPremiacionFutbol.setOpaque(false);
		scrollCampoTextoPremiacionFutbol = new JScrollPane(campoTextoPremiacionFutbol);
		panelPremiacionFutbol.add(scrollCampoTextoPremiacionFutbol);

		this.add(panelPremiacionBaloto, "Plan de Premios Baloto");
		this.add(panelPremiacionSuperastro, "Plan de Premios SuperAstro");
		this.add(panelPremiacionFutbol, "Plan de Premios Marcadores");
	}

	/**
	 * Organiza los datos para mostrarlos en la interfaz gráfica, asignando valores
	 * en el JTextFiel
	 */

	public void llenarInformacion(String[] entrada) {
		this.campoTextoPremiacionSuperastro.setText(entrada[0]);
		this.campoTextoPremiacionBaloto.setText(entrada[1]);
		this.campoTextoPremiacionFutbol.setText(entrada[2]);

	}

	/**
	 * @return the panelPremiacionBaloto
	 */
	public JPanel getPanelPremiacionBaloto() {
		return panelPremiacionBaloto;
	}

	/**
	 * @param panelPremiacionBaloto the panelPremiacionBaloto to set
	 */
	public void setPanelPremiacionBaloto(JPanel panelPremiacionBaloto) {
		this.panelPremiacionBaloto = panelPremiacionBaloto;
	}

	/**
	 * @return the campoTextoPremiacionBaloto
	 */
	public JTextArea getCampoTextoPremiacionBaloto() {
		return campoTextoPremiacionBaloto;
	}

	/**
	 * @param campoTextoPremiacionBaloto the campoTextoPremiacionBaloto to set
	 */
	public void setCampoTextoPremiacionBaloto(JTextArea campoTextoPremiacionBaloto) {
		this.campoTextoPremiacionBaloto = campoTextoPremiacionBaloto;
	}

	/**
	 * @return the scrollCampoTextoPremiacionBaloto
	 */
	public JScrollPane getScrollCampoTextoPremiacionBaloto() {
		return scrollCampoTextoPremiacionBaloto;
	}

	/**
	 * @param scrollCampoTextoPremiacionBaloto the scrollCampoTextoPremiacionBaloto
	 *                                         to set
	 */
	public void setScrollCampoTextoPremiacionBaloto(JScrollPane scrollCampoTextoPremiacionBaloto) {
		this.scrollCampoTextoPremiacionBaloto = scrollCampoTextoPremiacionBaloto;
	}

	/**
	 * @return the panelPremiacionSuperastro
	 */
	public JPanel getPanelPremiacionSuperastro() {
		return panelPremiacionSuperastro;
	}

	/**
	 * @param panelPremiacionSuperastro the panelPremiacionSuperastro to set
	 */
	public void setPanelPremiacionSuperastro(JPanel panelPremiacionSuperastro) {
		this.panelPremiacionSuperastro = panelPremiacionSuperastro;
	}

	/**
	 * @return the campoTextoPremiacionSuperastro
	 */
	public JTextArea getCampoTextoPremiacionSuperastro() {
		return campoTextoPremiacionSuperastro;
	}

	/**
	 * @param campoTextoPremiacionSuperastro the campoTextoPremiacionSuperastro to
	 *                                       set
	 */
	public void setCampoTextoPremiacionSuperastro(JTextArea campoTextoPremiacionSuperastro) {
		this.campoTextoPremiacionSuperastro = campoTextoPremiacionSuperastro;
	}

	/**
	 * @return the scrollCampoTextoPremiacionSuperastro
	 */
	public JScrollPane getScrollCampoTextoPremiacionSuperastro() {
		return scrollCampoTextoPremiacionSuperastro;
	}

	/**
	 * @param scrollCampoTextoPremiacionSuperastro the
	 *                                             scrollCampoTextoPremiacionSuperastro
	 *                                             to set
	 */
	public void setScrollCampoTextoPremiacionSuperastro(JScrollPane scrollCampoTextoPremiacionSuperastro) {
		this.scrollCampoTextoPremiacionSuperastro = scrollCampoTextoPremiacionSuperastro;
	}

	/**
	 * @return the panelPremiacionFutbol
	 */
	public JPanel getPanelPremiacionFutbol() {
		return panelPremiacionFutbol;
	}

	/**
	 * @param panelPremiacionFutbol the panelPremiacionFutbol to set
	 */
	public void setPanelPremiacionFutbol(JPanel panelPremiacionFutbol) {
		this.panelPremiacionFutbol = panelPremiacionFutbol;
	}

	/**
	 * @return the campoTextoPremiacionFutbol
	 */
	public JTextArea getCampoTextoPremiacionFutbol() {
		return campoTextoPremiacionFutbol;
	}

	/**
	 * @param campoTextoPremiacionFutbol the campoTextoPremiacionFutbol to set
	 */
	public void setCampoTextoPremiacionFutbol(JTextArea campoTextoPremiacionFutbol) {
		this.campoTextoPremiacionFutbol = campoTextoPremiacionFutbol;
	}

	/**
	 * @return the scrollCampoTextoPremiacionFutbol
	 */
	public JScrollPane getScrollCampoTextoPremiacionFutbol() {
		return scrollCampoTextoPremiacionFutbol;
	}

	/**
	 * @param scrollCampoTextoPremiacionFutbol the scrollCampoTextoPremiacionFutbol
	 *                                         to set
	 */
	public void setScrollCampoTextoPremiacionFutbol(JScrollPane scrollCampoTextoPremiacionFutbol) {
		this.scrollCampoTextoPremiacionFutbol = scrollCampoTextoPremiacionFutbol;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
