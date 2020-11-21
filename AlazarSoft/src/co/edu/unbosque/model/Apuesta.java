package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.BalotoDAO;
import co.edu.unbosque.model.persistence.MarcadoresDAO;
import co.edu.unbosque.model.persistence.SuperastroDAO;

public class Apuesta {

	private BalotoDAO balotoDAO = new BalotoDAO();
	private SuperastroDAO superastroDAO = new SuperastroDAO();
	private MarcadoresDAO marcadoresDAO = new MarcadoresDAO();

	public Apuesta() {

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
