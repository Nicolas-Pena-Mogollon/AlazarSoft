package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import co.edu.unbosque.model.Discord;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener {

	private Discord discord;
	private View view;

	public Controller() {
		this.discord = new Discord();
		this.view = new View(this);
		this.iniciarGamers();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals(view.getPanelCrearGamer().getCOMMAND_INGRESAR()))
			this.coordinarCreacionGamer();
		else if (event.getActionCommand().equals(view.getPanelLeerGamer().getCOMMAND_LEER()))
			view.getPanelLeerGamer().actualizarTabla(discord.generarTablaGamers());
		else if (event.getActionCommand().equals(view.getPanelActualizarGamer().getCOMMAND_ACTUALIZAR()))
			this.coordinarActualizarGamer();
		else if (event.getActionCommand().equals(view.getPanelActualizarGamer().getCOMMAND_BORRAR()))
			this.coordinarBorradoGamer();
		else if (event.getActionCommand().equals(view.getPanelIngresoDatosJuegos().getCOMMAND_INGRESAR()))
			this.coordinarIngresoJuegos();
		else if (event.getActionCommand().equals(view.getPanelMostrarRegistrosJuegos().getCOMMAND_LEER_JUEGOS()))
			view.getPanelMostrarRegistrosJuegos().actualizarTablaMostrarJuegos(discord.generarReporteJuegos());

	}

	private void coordinarCreacionGamer() {
		String[] data = this.view.getPanelCrearGamer().verificarEntradasCreacionGamer();
		if (data[0].equals("0")) {
			if (this.discord.verificarNickname(data[1])) {
				view.mostrarMensajeError("Nickname existente!");
			} else {
				this.discord.getGamerDao().crearGamer(data[1], this.discord.asignarID());
				this.view.mostrarMensajeInformacion(data[2]);
			}
		} else {
			view.mostrarMensajeError(data[1]);
		}
		view.getPanelCrearGamer().borrarCamposTexto();
		view.getPanelActualizarGamer().cargarId(this.discord.generarListaId());
		view.getPanelIngresoDatosJuegos().cargarIdPanelIngresoJuegos(this.discord.generarListaId());
	}

	private void coordinarActualizarGamer() {
		String[] data = this.view.getPanelActualizarGamer().verificarEntradasActualizar();
		if (data[0].equals("0")) {
			if (this.discord.verificarNickname(data[1])) {
				view.mostrarMensajeError("Nickname existente!");
			} else {
				this.discord.getGamerDao().actualizarGamer(data[1], Integer.parseInt(data[2]));
				this.view.mostrarMensajeInformacion(data[3]);
			}
		} else {
			view.mostrarMensajeError(data[1]);
		}
		view.getPanelActualizarGamer().borrarCampos();
	}

	private void coordinarBorradoGamer() {
		if (this.view.mostrarMensajeAdvertencia()) {
			String[] data = view.getPanelActualizarGamer().verificarEntradasBorrar();
			if (data[0].equals("0")) {
				int id = Integer.parseInt(data[1]);
				this.discord.getGamerDao().eliminarGamer(id);
				this.discord.getGamesDao().eliminarGame(id);
				this.view.mostrarMensajeInformacion(data[2]);
				this.view.getPanelActualizarGamer().cargarId(this.discord.generarListaId());
				this.view.getPanelIngresoDatosJuegos().cargarIdPanelIngresoJuegos(this.discord.generarListaId());
			} else {
				this.view.mostrarMensajeError(data[1]);
			}
		}
		view.getPanelActualizarGamer().borrarCampos();
	}

	private void coordinarIngresoJuegos() {
		String[] data = this.view.getPanelIngresoDatosJuegos().verificarEntradasIngresoDatosJuegos();
		if (data[0].equals("0")) {
			this.discord.getGamesDao().crearGame(data[1], Integer.parseInt(data[2]), data[3],
					Integer.parseInt(data[4]));
			this.discord.agregarPuntosGamer(Integer.parseInt(data[2]), Integer.parseInt(data[4]));
			this.discord.getGamerDao().getGamerFile().escribirArchivoGamers(this.discord.getGamerDao().getGamerDTO());
			this.view.mostrarMensajeInformacion(data[5]);
		} else {
			view.mostrarMensajeError(data[1]);
		}
		this.view.getPanelIngresoDatosJuegos().borrarCamposPanelIngresoJuego();
	}

	private void iniciarGamers() {
		this.discord.getGamerDao().leerGamers();
		this.view.getPanelActualizarGamer().cargarId(this.discord.generarListaId());
		this.view.getPanelIngresoDatosJuegos().cargarIdPanelIngresoJuegos(this.discord.generarListaId());
	}

}