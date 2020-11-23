package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.Apuesta;
import co.edu.unbosque.model.persistence.BalotoDTO;
import co.edu.unbosque.model.persistence.MarcadoresDTO;
import co.edu.unbosque.model.persistence.SuperastroDTO;

public class ApuestasTest {

	Apuesta apuestas;
	BalotoDTO baloto1;
	MarcadoresDTO marcadores1;
	SuperastroDTO superastro1;

	@Before
	public void setUp() throws Exception {
		apuestas = new Apuesta();
		System.out.println("SetUp hecho");

	}

	@Test
	public void testVerificarRangoNumerosBaloto() {
		assertEquals("Los números se salen del rango", false,
				apuestas.verificarRangoNumerosBaloto(9, 13, 21, 33, 40, 45));
		assertEquals("Los números se salieron", true, apuestas.verificarRangoNumerosBaloto(-9, -13, -21, -33, -40, 50));

	}

	@Test
	public void testVerificarNumerosIgualesBaloto() {
		assertEquals("Los números no deberian ser iguales", false,
				apuestas.verificarNumerosIgualesBaloto(1, 9, 13, 14, 30, 40));
		assertEquals("Los números so iguales", true, apuestas.verificarNumerosIgualesBaloto(1, 9, 9, 30, 30, 40));

	}

	@Test
	public void testVerificarRangoNumerosSuperastro() {
		assertEquals("Los números no deberian salirse del rango", false,
				apuestas.verificarRangoNumerosSuperastro(3, 4, 6, 9));
		assertEquals("Los números se salen del rango", true, apuestas.verificarRangoNumerosSuperastro(13, 0, 6, 10));

	}

	@After
	public void tearDown() throws Exception {

		System.out.println("TearDown Hecho");

	}

}
