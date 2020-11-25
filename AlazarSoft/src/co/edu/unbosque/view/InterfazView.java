package co.edu.unbosque.view;

import co.edu.unbosque.controller.Controller;

public interface InterfazView {

	public abstract void asignarOyentes(Controller control);

	public abstract void mostrarMensajeError(String message);

	public abstract void mostrarMensajeInformacion(String message);

}
