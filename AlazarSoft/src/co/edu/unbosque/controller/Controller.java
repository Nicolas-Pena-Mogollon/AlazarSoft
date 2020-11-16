package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.CasaDeApuestas;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener {

	private CasaDeApuestas casaApuestas;
	private View vista;

	public Controller() {
		vista = new View(this);
		casaApuestas = new CasaDeApuestas();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().equals(vista.getPanelIngresoCasaApuestas().getCOMMAND_INGRESAR()))
			this.coordinarConfiguracionCasaApuestas();
	}

	public void coordinarConfiguracionCasaApuestas() {
		String[] entradas = vista.getPanelIngresoCasaApuestas().verificarEntradasIngresoDatosJuegos();
		if (entradas[0].equals("0")) {
			casaApuestas.guardarConfiguracionCasaDeApuestas(entradas[1], Integer.parseInt(entradas[2]),
					Long.parseLong(entradas[3]));
			vista.mostrarMensajeInformacion(entradas[4]);
		} else {
			vista.mostrarMensajeError(entradas[1]);
		}
		vista.getPanelIngresoCasaApuestas().borrarCamposIngresoCasaApuestas();
	}
}
