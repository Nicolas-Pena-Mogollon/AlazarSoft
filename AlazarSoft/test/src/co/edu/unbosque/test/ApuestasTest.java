package co.edu.unbosque.test;

import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.Apuesta;
import co.edu.unbosque.model.persistence.BalotoDTO;
import co.edu.unbosque.model.persistence.MarcadoresDTO;
import co.edu.unbosque.model.persistence.SuperastroDTO;

public class ApuestasTest {

	Apuesta apuestas;
	ArrayList<BalotoDTO> baloto;
	ArrayList<MarcadoresDTO> marcadores;
	ArrayList<SuperastroDTO> superastro;
	BalotoDTO baloto1;
	MarcadoresDTO marcadores1;
	SuperastroDTO superastro1;

	@Before
	public void setUp() throws Exception {
		Date fecha = new Date();
		apuestas = new Apuesta();
		baloto = apuestas.getBalotoDAO().getListaBaloto();
		marcadores = apuestas.getMarcadoresDAO().getListaMarcadores();
		superastro = apuestas.getSuperastroDAO().getListaSuperastro();
		baloto1 = new BalotoDTO("Usaquen", "1000149678", fecha, 10000.00, "1-2-3-4-5-6");
		marcadores1 = new MarcadoresDTO("Usaquen", "1000149678", fecha, 20000.00, "Real Madrid - Alavés", "Empate");
		superastro1 = new SuperastroDTO("Usaquen", "1000149678", fecha, 20000.00, "7-8-9-1", "Escorpio");
		baloto.add(baloto1);
		marcadores.add(marcadores1);
		superastro.add(superastro1);
		System.out.println("SetUp hecho");

	}

	@Test
	public void testBorrarApuesta() {
		
	}

	@Test
	public void testVerificarRangoNumerosBaloto() {

	}

	@Test
	public void testVerificarNumerosIgualesBaloto() {

	}

	@Test
	public void testVerificarRangoNumerosSuperastro() {

	}

	@After
	public void tearDown() throws Exception {

		System.out.println("TearDown Hecho");

	}

}
