package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.Apostador;
import co.edu.unbosque.model.persistence.ApostadorDTO;

public class ApostadoresTest {

	Apostador apostador;
	ArrayList<ApostadorDTO> apostadores;
	ApostadorDTO apostador1;

	@Before
	public void setUp() throws Exception {
		apostador = new Apostador();
		apostadores = apostador.getApostadorDao().getListaApostador();
		apostador1 = new ApostadorDTO("Camila", "1000149678", "Usaquén", "Calle 115 #10-45", "3115314191");
		System.out.println("SetUp hecho");

	}

	@Test
	public void testSoloNumeros() {
		assertEquals("Solo puede ingresar números", true, apostador.soloNumeros("3115314191"));
		assertEquals("No ingreso números", false, apostador.soloNumeros(apostador1.getNombre()));
	}

	@Test
	public void testGenerarTablaApostador() {
		assertNotNull("La tabla no debe estar vacia", apostador1);
	}

	@Test
	public void testBuscarApostador() {
		assertNotNull("El apostador debio ser buscado",
				apostador.getApostadorDao().buscarApostador(apostador1.getCedula()));
	}

	@Test
	public void testAgregarApostador() {
		assertNotNull("El apostador debio ser agregado",
				apostador.getApostadorDao().agregarApostador(apostador1.getNombre(), apostador1.getCedula(),
						apostador1.getSede(), apostador1.getDireccion(), apostador1.getCelular()));
	}

	@Test
	public void testEliminarApostador() {
		assertTrue("El apostador debio ser eliminado",
				apostador.getApostadorDao().eliminarApostador(apostador1.getCedula()));
	}

	@Test
	public void testEditarApostador() {
		assertNotEquals("El apostador debio ser editado", apostador.getApostadorDao().editarApostador("1193499871",
				"Nicolás", "Usaquén", "Cra 7B #153A-14", "3103655035"));
	}

	@Test
	public void testVerificarNumeroTelefonico() {
		assertTrue("El número deberia estar verificador",
				apostador.getApostadorDao().verificarNumeroTelefonico(apostadores, apostador1.getCelular()));
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("TearDown Hecho");
	}

}
