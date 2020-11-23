package co.edu.unbosque.model.persistence;

public abstract class ArchivoExportar {

	protected final String[] titulosReportePDFClientes = { "Fecha", "Sede", "Cédula", "Nombre" };
	protected final String[] titulosValorTotalApuestasCliente = { "Fecha", "Cédula", "Nombre", "Valor" };
	protected final String[] titulosDetalleApuestasRealizadasClienteSede = { "Fecha", "Sede", "Cédula", "Nombre",
			"Tipo de apuesta", "Valor" };
	protected final String[] titulosTotalApuestasSedeTipoJuego = { "Fecha", "Sede", "Tipo de apuesta", "Valor",
			"CILINDRAJE", "EXISTENCIAS", "VALOR UNIDAD", "CANTIDAD" };

	public abstract void exportar(String[][] data, String tipoReporte);

	public abstract void llenarTitulos(String[] titulos);

	public abstract String[] verificarTipoReporte(String reporte);
}
