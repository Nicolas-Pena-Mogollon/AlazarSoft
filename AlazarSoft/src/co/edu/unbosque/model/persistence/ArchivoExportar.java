package co.edu.unbosque.model.persistence;

import com.itextpdf.text.Document;

public abstract class ArchivoExportar {

	protected final String[] titulosReportePDFClientes = { "Fecha", "Sede", "Cédula", "Nombre", "Número de celular",
			"Dirección" };
	protected final String[] titulosValorTotalApuestasCliente = { "FECHA", "PROVEEDOR", "MODELO", "REFERENCIA",
			"CILINDRAJE", "EXISTENCIAS", "VALOR UNIDAD", "CANTIDAD" };
	protected final String[] titulosDetalleApuestasRealizadasClienteSede = { "FECHA", "PROVEEDOR", "MODELO",
			"REFERENCIA", "CILINDRAJE", "EXISTENCIAS", "VALOR UNIDAD", "CANTIDAD" };
	protected final String[] titulosTotalApuestasSedeTipoJuego = { "FECHA", "PROVEEDOR", "MODELO", "REFERENCIA",
			"CILINDRAJE", "EXISTENCIAS", "VALOR UNIDAD", "CANTIDAD" };

	public abstract void exportar(Document document,String[][] data, String tipoReporte);

	public abstract void llenarTitulos(String[] titulos);

	public abstract String[] verificarTipoReporte(String reporte);

	public void exportar(String[][] data, String tipoReporte) {
		// TODO Auto-generated method stub
		
	}

}
