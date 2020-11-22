package co.edu.unbosque.model.persistence;

public abstract class ArchivoExportar {

	protected final String[] titulosReportePDFClientes = { "FECHA", "PROVEEDOR", "MODELO", "REFERENCIA", "CILINDRAJE",
			"EXISTENCIAS", "VALOR UNIDAD", "CANTIDAD" };
	protected final String[] titulosValorTotalApuestasCliente = { "FECHA", "PROVEEDOR", "MODELO", "REFERENCIA",
			"CILINDRAJE", "EXISTENCIAS", "VALOR UNIDAD", "CANTIDAD" };
	protected final String[] titulosDetalleApuestasRealizadasClienteSede = { "FECHA", "PROVEEDOR", "MODELO", "REFERENCIA",
			"CILINDRAJE", "EXISTENCIAS", "VALOR UNIDAD", "CANTIDAD" };
	protected final String[] titulosTotalApuestasSedeTipoJuego = { "FECHA", "PROVEEDOR", "MODELO", "REFERENCIA",
			"CILINDRAJE", "EXISTENCIAS", "VALOR UNIDAD", "CANTIDAD" };

	public abstract void exportar(String[][] data, String tipoReporte);

	public abstract void llenarTitulos(String[] titulos);

	public abstract String[] verificarTipoReporte(String reporte);
}
