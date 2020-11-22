package co.edu.unbosque.view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class PanelPremiacion extends JTabbedPane {

	private static final long serialVersionUID = 1L;
	private JPanel panelPremiacionBaloto;
	private JPanel panelPremiacionSuperastro;
	private JPanel panelPremiacionFutbol;

	public PanelPremiacion() {
		panelPremiacionBaloto = new JPanel();
		panelPremiacionSuperastro = new JPanel();
		panelPremiacionFutbol = new JPanel();

		this.add(panelPremiacionBaloto, "Plan de Premios Baloto");
		this.add(panelPremiacionSuperastro, "Plan de Premios SuperAstro");
		this.add(panelPremiacionFutbol, "Plan de Premios Marcadores");

	}

	public JPanel getPanelPremiacionBaloto() {
		return panelPremiacionBaloto;
	}

	public void setPanelPremiacionBaloto(JPanel panelPremiacionBaloto) {
		this.panelPremiacionBaloto = panelPremiacionBaloto;
	}

	public JPanel getPanelPremiacionSuperastro() {
		return panelPremiacionSuperastro;
	}

	public void setPanelPremiacionSuperastro(JPanel panelPremiacionSuperastro) {
		this.panelPremiacionSuperastro = panelPremiacionSuperastro;
	}

	public JPanel getPanelPremiacionFutbol() {
		return panelPremiacionFutbol;
	}

	public void setPanelPremiacionFutbol(JPanel panelPremiacionFutbol) {
		this.panelPremiacionFutbol = panelPremiacionFutbol;
	}

}
