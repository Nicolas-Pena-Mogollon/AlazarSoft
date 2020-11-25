package co.edu.unbosque.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.Sede;
import co.edu.unbosque.model.persistence.SedesDTO;

public class SedesTest {

	Sede sede;
	ArrayList<SedesDTO> sedesLista;
	SedesDTO sede1;

	@Before
	public void setUp() throws Exception {
		sede = new Sede();
		sedesLista = sede.getSedesDao().leerSede();
		System.out.println("SetUp hecho");
	}

	@Test
	public void testGenerarId() {
		assertNotNull("No pueden haber dos id iguales", sede.generarIdSede());

	}

	@Test
	public void testCrearTablaSede() {
		assertNotNull("La tabla no debe estar vacia", sede.crearTablaSede());

	}

	@Test
	public void testLlenarTablaSede() {
		assertNotNull("El id deberia ser obtenido", sede.llenarTablaSede());
	}

	@Test
	public void ObtenerSedes() {
		assertNotNull("Se debio obtener la sede", sede.obtenerSedes());
	}

	@Test
	public void testCrearSede() {
		sede1 = new SedesDTO(0, "Usaquén", 45);
		assertNotNull("La sede debio ser agregada", sede.getSedesDao().crearSede(sede1));
		sede.getSedesDao().getDataSedes().remove(sede1);
		sede.getSedesDao().getSedeFile().escribirRegistroSede(sede.getSedesDao().getDataSedes());

	}

	@Test
	public void testActualizarSede() {
		assertNotEquals("La sede debio actualizarse", sede.getSedesDao().actualizarSede(2, 54), sede1);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("TearDown Hecho");

	}

}
