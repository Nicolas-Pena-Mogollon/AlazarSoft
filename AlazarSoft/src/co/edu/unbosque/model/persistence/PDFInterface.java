package co.edu.unbosque.model.persistence;

public interface PDFInterface {

	public final String RUTA_REPORTEPDF_CLIENTES = "reporteClientes.pdf";
	public final String RUTA_REPORTEPDF_TOTAL_APUESTAS_CLIENTES = "reporteClientes.pdf";
	public final String RUTA_REPORTE_DETALLES_APUESTAS_POR_CLIENTE = "reporteClientes.pdf";
	public final String RUTA_REPORTE_TOTAL_APUESTAS_POR_SEDE = "reporteClientes.pdf";
	public final String[] titulosReportePDFClientes = { "FECHA", "PROVEEDOR", "MODELO", "REFERENCIA", "CILINDRAJE",
			"EXISTENCIAS", "VALOR UNIDAD", "CANTIDAD" };
	

	public abstract void exportarPDF(String[][] data, String tipoReporte);
	public abstract String[] seleccionarTitulosCeldas(String tipoReporte);
}
