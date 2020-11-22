package co.edu.unbosque.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import co.edu.unbosque.model.persistence.BalotoDAO;
import co.edu.unbosque.model.persistence.BalotoDTO;
import co.edu.unbosque.model.persistence.MarcadoresDAO;
import co.edu.unbosque.model.persistence.MarcadoresDTO;
import co.edu.unbosque.model.persistence.SuperastroDAO;
import co.edu.unbosque.model.persistence.SuperastroDTO;

public class Apuesta {

	private BalotoDAO balotoDAO;
	private SuperastroDAO superastroDAO;
	private MarcadoresDAO marcadoresDAO;

	public Apuesta() {
		balotoDAO = new BalotoDAO();
		superastroDAO = new SuperastroDAO();
		marcadoresDAO = new MarcadoresDAO();
	}

	public boolean borrarApuesta(String tipoApuesta, String fecha, String cedula) throws ParseException {
		SimpleDateFormat dateF = new SimpleDateFormat("hh: mm: ss a dd/MM/yyyy");
		boolean salida = false;
		if (tipoApuesta.equals("Super Astro")) {
			if (superastroDAO.eliminarApuesta(cedula, dateF.parse(fecha))) {
				salida = true;
			} else {
				salida = false;
			}
		} else if (tipoApuesta.equals("Baloto")) {
			if (balotoDAO.eliminarApuesta(cedula, dateF.parse(fecha))) {
				salida = true;
			} else {
				salida = false;
			}
		} else if (tipoApuesta.equals("Fútbol")) {
			if (marcadoresDAO.eliminarApuesta(cedula, dateF.parse(fecha))) {
				salida = true;
			} else {
				salida = false;
			}
		} else {
			salida = false;
		}
		return salida;
	}

	private int contarDatosTipoApuestaYSede(String tipoApuesta, String sede) {
		int cont = 0;
		String sedeSinIdentificador = sede.substring(0, sede.indexOf("-"));
		if (tipoApuesta.equals("Super Astro")) {
			for (int i = 0; i < superastroDAO.getListaSuperastro().size(); i++)
				if (sedeSinIdentificador.equals(superastroDAO.getListaSuperastro().get(i).getNombreSede()))
					cont++;
		} else if (tipoApuesta.equals("Baloto")) {
			for (int i = 0; i < balotoDAO.getListaBaloto().size(); i++)
				if (sedeSinIdentificador.equals(balotoDAO.getListaBaloto().get(i).getNombreSede()))
					cont++;
		} else if (tipoApuesta.equals("Fútbol")) {
			for (int i = 0; i < marcadoresDAO.getListaMarcadores().size(); i++)
				if (sedeSinIdentificador.equals(marcadoresDAO.getListaMarcadores().get(i).getNombreSede()))
					cont++;
		}
		return cont;
	}

	public String[][] generarTablaApuestas(String tipoApuesta, String sede) {
		String[][] salida = new String[this.contarDatosTipoApuestaYSede(tipoApuesta, sede)][4];
		SimpleDateFormat dateF = new SimpleDateFormat("hh: mm: ss a dd/MM/yyyy");
		String sedeSinIdentificador = sede.substring(0, sede.indexOf("-"));
		if (tipoApuesta.equals("Super Astro")) {
			for (int i = 0; i < salida.length; i++) {
				if (sedeSinIdentificador.equals(superastroDAO.getListaSuperastro().get(i).getNombreSede())) {
					salida[i][0] = dateF.format(superastroDAO.getListaSuperastro().get(i).getFecha());
					salida[i][1] = superastroDAO.getListaSuperastro().get(i).getCedula();
					salida[i][2] = superastroDAO.getListaSuperastro().get(i).getNumeroJuego() + "-"
							+ superastroDAO.getListaSuperastro().get(i).getSigno();
					salida[i][3] = String.valueOf(superastroDAO.getListaSuperastro().get(i).getValorApuesta());
				}
			}
		} else if (tipoApuesta.equals("Baloto")) {
			for (int i = 0; i < salida.length; i++) {
				if (sedeSinIdentificador.equals(balotoDAO.getListaBaloto().get(i).getNombreSede())) {
					salida[i][0] = dateF.format(balotoDAO.getListaBaloto().get(i).getFecha());
					salida[i][1] = balotoDAO.getListaBaloto().get(i).getCedula();
					salida[i][2] = balotoDAO.getListaBaloto().get(i).getNumeroJuego();
					salida[i][3] = String.valueOf(balotoDAO.getListaBaloto().get(i).getValorApuesta());
				}
			}
		} else if (tipoApuesta.equals("Fútbol")) {
			for (int i = 0; i < salida.length; i++) {
				if (sedeSinIdentificador.equals(marcadoresDAO.getListaMarcadores().get(i).getNombreSede())) {
					salida[i][0] = dateF.format(marcadoresDAO.getListaMarcadores().get(i).getFecha());
					salida[i][1] = marcadoresDAO.getListaMarcadores().get(i).getCedula();
					salida[i][2] = marcadoresDAO.getListaMarcadores().get(i).getPartido() + "-"
							+ marcadoresDAO.getListaMarcadores().get(i).getResultado();
					salida[i][3] = String.valueOf(marcadoresDAO.getListaMarcadores().get(i).getValorApuesta());
				}
			}
		}
		return salida;
	}

	public boolean verificarRangoNumerosBaloto(int primerNumero, int segundoNumero, int tercerNumero, int cuartoNumero,
			int quintoNumero, int sextoNumero) {
		boolean verificar = false;
		if ((primerNumero < 1 || primerNumero > 45) || (segundoNumero < 1 || segundoNumero > 45)
				|| (tercerNumero < 1 || tercerNumero > 45) || (cuartoNumero < 1 || cuartoNumero > 45)
				|| (quintoNumero < 1 || quintoNumero > 45) || (sextoNumero < 1 || sextoNumero > 45)) {
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;

	}

	public boolean verificarNumerosIgualesBaloto(int primerNumero, int segundoNumero, int tercerNumero,
			int cuartoNumero, int quintoNumero, int sextoNumero) {
		boolean verificar = false;
		if ((primerNumero == segundoNumero) || (primerNumero == tercerNumero) || (primerNumero == cuartoNumero)
				|| (primerNumero == quintoNumero) || (primerNumero == sextoNumero) || (segundoNumero == tercerNumero)
				|| (segundoNumero == cuartoNumero) || (segundoNumero == quintoNumero) || (segundoNumero == sextoNumero)
				|| (tercerNumero == cuartoNumero) || (tercerNumero == quintoNumero) || (tercerNumero == sextoNumero)
				|| (cuartoNumero == quintoNumero) || (cuartoNumero == sextoNumero) || (quintoNumero == sextoNumero)) {
			verificar = true;

		} else {
			verificar = false;
		}
		return verificar;
	}

	public boolean verificarRangoNumerosSuperastro(int primerNumero, int segundoNumero, int tercerNumero,
			int cuartoNumero) {
		boolean verificar = false;
		if ((primerNumero < 0 || primerNumero > 9) || (segundoNumero < 0 || segundoNumero > 9)
				|| (tercerNumero < 0 || tercerNumero > 9) || (cuartoNumero < 0 || cuartoNumero > 9)) {
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;
	}
	
	public static BalotoDTO[] quicksortRecurivoBaloto(BalotoDTO[] numeros) {
		return quicksort2Baloto(numeros, 0, numeros.length - 1);
	}

	public static BalotoDTO[] quicksort2Baloto(BalotoDTO[] numeros, int izq, int der) {
		if (izq >= der) {
			return numeros;
		}
		int i = izq, d = der;
		if (izq != der) {
			int pivote;
			BalotoDTO aux = null;
			pivote = izq;
			while (izq != der) {
				while ((numeros[der].getFecha().before(numeros[pivote].getFecha()) || numeros[der].getFecha() == numeros[pivote].getFecha()) && izq < der) {
					der--;

				}
				while (numeros[izq].getFecha().after(numeros[pivote].getFecha()) && izq < der) {
					izq++;
				}
				if (der != izq) {
					aux = numeros[der];	
			
					numeros[der] = numeros[izq];
					numeros[izq] = aux;
				}
			}
			if (izq == der) {
				quicksort2Baloto(numeros, i, izq - 1);
				quicksort2Baloto(numeros, izq + 1, d);
			}
		} else {
			return numeros;
		}
		return numeros;
	}
	
	public static SuperastroDTO[] quicksortRecurivoSuperastro(SuperastroDTO[] numeros) {
		return quicksort2Superastro(numeros, 0, numeros.length - 1);
	}

	public static SuperastroDTO[] quicksort2Superastro(SuperastroDTO[] numeros, int izq, int der) {
		if (izq >= der) {
			return numeros;
		}
		int i = izq, d = der;
		if (izq != der) {
			int pivote;
			SuperastroDTO aux = null;
			pivote = izq;
			while (izq != der) {
				while ((numeros[der].getFecha().before(numeros[pivote].getFecha()) || numeros[der].getFecha() == numeros[pivote].getFecha()) && izq < der) {
					der--;

				}
				while (numeros[izq].getFecha().after(numeros[pivote].getFecha()) && izq < der) {
					izq++;
				}
				if (der != izq) {
					aux = numeros[der];	
			
					numeros[der] = numeros[izq];
					numeros[izq] = aux;
				}
			}
			if (izq == der) {
				quicksort2Superastro(numeros, i, izq - 1);
				quicksort2Superastro(numeros, izq + 1, d);
			}
		} else {
			return numeros;
		}
		return numeros;
	}
	
	public static MarcadoresDTO[] quicksortRecurivoMarcadores(MarcadoresDTO[] numeros) {
		return quicksort2Marcadores(numeros, 0, numeros.length - 1);
	}

	public static MarcadoresDTO[] quicksort2Marcadores(MarcadoresDTO[] numeros, int izq, int der) {
		if (izq >= der) {
			return numeros;
		}
		int i = izq, d = der;
		if (izq != der) {
			int pivote;
			MarcadoresDTO aux = null;
			pivote = izq;
			while (izq != der) {
				while ((numeros[der].getFecha().before(numeros[pivote].getFecha()) || numeros[der].getFecha() == numeros[pivote].getFecha()) && izq < der) {
					der--;

				}
				while (numeros[izq].getFecha().after(numeros[pivote].getFecha()) && izq < der) {
					izq++;
				}
				if (der != izq) {
					aux = numeros[der];	
			
					numeros[der] = numeros[izq];
					numeros[izq] = aux;
				}
			}
			if (izq == der) {
				quicksort2Marcadores(numeros, i, izq - 1);
				quicksort2Marcadores(numeros, izq + 1, d);
			}
		} else {
			return numeros;
		}
		return numeros;
	}

	/**
	 * @return the balotoDAO
	 */
	public BalotoDAO getBalotoDAO() {
		return balotoDAO;
	}

	/**
	 * @param balotoDAO the balotoDAO to set
	 */
	public void setBalotoDAO(BalotoDAO balotoDAO) {
		this.balotoDAO = balotoDAO;
	}

	/**
	 * @return the superastroDAO
	 */
	public SuperastroDAO getSuperastroDAO() {
		return superastroDAO;
	}

	/**
	 * @param superastroDAO the superastroDAO to set
	 */
	public void setSuperastroDAO(SuperastroDAO superastroDAO) {
		this.superastroDAO = superastroDAO;
		
	}

	/**
	 * @return the marcadoresDAO
	 */
	public MarcadoresDAO getMarcadoresDAO() {
		return marcadoresDAO;
	}

	/**
	 * @param marcadoresDAO the marcadoresDAO to set
	 */
	public void setMarcadoresDAO(MarcadoresDAO marcadoresDAO) {
		this.marcadoresDAO = marcadoresDAO;
	}

}
