package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;

public class ArchivoExcel extends ArchivoExportar {
	private final String RUTA_REPORTEPDF_CLIENTES = "./Export/reporteClientesSede.xls";
	private final String RUTA_REPORTEPDF_TOTAL_APUESTAS_CLIENTES = "./Export/reporteApuestasClientes.xls";
	private final String RUTA_REPORTE_DETALLES_APUESTAS_POR_CLIENTE = "./Export/reporteApuestasClienteSede.xls";
	private final String RUTA_REPORTE_TOTAL_APUESTAS_POR_SEDE = "./Export/reporteTotalApuestasSedeJuego.xls";
	private File file;
	private HSSFWorkbook workBook;
	private HSSFSheet hoja1;
	private CellStyle estiloTitulo;

	public ArchivoExcel() {
		// TODO Auto-generated constructor stub
		verificarDirectorio();
	}

	@Override
	public void exportar(String[][] data, String tipoReporte) {
		// TODO Auto-generated method stub
		workBook = new HSSFWorkbook();
		// Creo la hoja
		hoja1 = workBook.createSheet(tipoReporte);
		this.crearFormato();
		this.llenarTitulos(this.verificarTipoReporte(tipoReporte));
		for (int i = 0; i < data.length; ++i) {
			HSSFRow dataRow = hoja1.createRow(i + 1);

			for (int j = 0; j < data[i].length; j++) {
				dataRow.createCell(j).setCellValue(data[i][j]);
			}
		}
		this.ajustarColumnas();
		try {
			FileOutputStream elFichero = new FileOutputStream(file);
			workBook.write(elFichero);
			elFichero.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void llenarTitulos(String[] titulos) {
		// TODO Auto-generated method stub
		HSSFRow filaTitulo = hoja1.createRow(0);
		for (int i = 0; i < titulos.length; ++i) {
			String nombreTitulos = titulos[i];
			// Se crean las celdas que contienen los títulos
			HSSFCell celda = filaTitulo.createCell(i);
			// Se le agrega el estilo a la celda
			celda.setCellStyle(estiloTitulo);
			// Se pasa el título a la celda
			celda.setCellValue(nombreTitulos);
		}

	}

	@Override
	public String[] verificarTipoReporte(String tipoReporte) {
		if (tipoReporte.equals("Listado de clientes por sede")) {
			file = new File(RUTA_REPORTEPDF_CLIENTES);
			return titulosReportePDFClientes;
		} else if (tipoReporte.equals("Valor total de apuestas por cliente")) {
			file = new File(RUTA_REPORTEPDF_TOTAL_APUESTAS_CLIENTES);
			return titulosValorTotalApuestasCliente;
		} else if (tipoReporte.equals("Detalle de apuestas realizadas por cliente y sede")) {
			file = new File(RUTA_REPORTE_DETALLES_APUESTAS_POR_CLIENTE);
			return titulosDetalleApuestasRealizadasClienteSede;
		} else if (tipoReporte.equals("Total de apuestas por sede y tipo de juego")) {
			file = new File(RUTA_REPORTE_TOTAL_APUESTAS_POR_SEDE);
			return titulosTotalApuestasSedeTipoJuego;
		} else {
			return null;
		}
	}

	private void crearFormato() {
		estiloTitulo = workBook.createCellStyle();
		// Se crea una fuente
		Font font = workBook.createFont();
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		// Se le da el tipo de fuente a ese estilo
		estiloTitulo.setFont(font);
		// Se le dan características a las celdas
		estiloTitulo.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
		estiloTitulo.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		estiloTitulo.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		estiloTitulo.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		estiloTitulo.setBorderRight(HSSFCellStyle.BORDER_THIN);
		estiloTitulo.setBorderTop(HSSFCellStyle.BORDER_THIN);
	}

	private void ajustarColumnas() {
		// getRow(x).getLastCellNum() obtiene el número de celdas de la primera fila
		for (int i = 0; i < hoja1.getRow(0).getLastCellNum(); i++) {
			// Se da automáticamente el tamaño a cada colúmna de la hoja
			hoja1.autoSizeColumn(i);
		}
	}

	private void verificarDirectorio() {
		File f = new File("./Export");
		if (!f.exists()) {
			f.mkdir();
		}
	}
}
