/**
 * Paquete persistencia
 */
package co.edu.unbosque.model.persistence;

/**
 * Clase ArchivoExportar
 */
public abstract class ArchivoExportar {

	protected final String[] titulosReportePDFClientes = { "Fecha", "Sede", "Cédula", "Nombre" };
	protected final String[] titulosValorTotalApuestasCliente = { "Fecha", "Cédula", "Nombre", "Valor" };
	protected final String[] titulosDetalleApuestasRealizadasClienteSede = { "Fecha", "Sede", "Cédula", "Nombre",
			"Tipo de apuesta", "Valor" };
	protected final String[] titulosTotalApuestasSedeTipoJuego = { "Fecha", "Sede", "Tipo de apuesta", "Valor" };

	/**
	 * Este método se encarga de exportar el archivo pdf o excel.
	 * 
	 * @param data,        es la tabla que se va a mostrar en el archivo; data !=
	 *                     null.
	 * @param tipoReporte, es el tipo de reporte a exportar; tipoReporte != null.
	 */
	public abstract void exportar(String[][] data, String tipoReporte);

	/**
	 * Este método se encarga de llenar los titulos a los archivos pdf o excel.
	 * 
	 * @param titulos, son los titulos a mostrar en los archivos exportados; titulos
	 *                 ! = null.
	 */

	public abstract void llenarTitulos(String[] titulos);

	public abstract String[] verificarTipoReporte(String reporte);
}
