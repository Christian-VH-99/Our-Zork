package tests;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import acciones.Peticion;
import main.Interprete;

public class InterpreteTest {

//	@BeforeClass
//	public void antes() {
//	}
	static Interprete interprete;

	/** por ahora se abarcan estos tres casos */
	@Test
	public void queSeSepareCorrectamenteElComando() {
		interprete = new Interprete("ir a la taberna");
		assertEquals("ir taberna null", interprete.toString());

		Interprete interprete2 = new Interprete("dar cerveza al fantasma");
		assertEquals("dar cerveza fantasma", interprete2.toString());

		Interprete interprete3 = new Interprete("dar la cerveza al fantasma");
		assertEquals("dar cerveza fantasma", interprete3.toString());
	}

	@Test
	public void queUnComandoConSustantivoInexistenteDevuelveNull() {

		interprete = new Interprete("dar asd");
		assertEquals(null, interprete.generarPeticion());
	}
	
	@Test
	public void queUnComandoConObjetoIndirectoInexistenteDevuelveNull() {
		
		interprete = new Interprete("dar cerveza al asd");
		
		assertEquals(null, interprete.generarPeticion());
		
	}

	@Test
	public void queUnaOracionIncompletaDevuelveNull() {

		interprete = new Interprete("dar ");
		assertEquals(null, interprete.generarPeticion());
	}
	
	@Test
	public void queUnComandoSinVerboDevuelveNull() {

		interprete = new Interprete("asd cerveza al fantasma");

		assertEquals(null, interprete.generarPeticion());
	}
	
	@Test
	public void queUnComandoCorrectoGenenereLaPeticion() {

		interprete = new Interprete("dar cerveza al fantasma");
		Peticion peticion = interprete.generarPeticion();

		assertEquals("dar", peticion.getNombreAccion());
		assertEquals("cerveza", peticion.getNombreItem());
		assertEquals("fantasma", peticion.getNombreNpc());

		/*-----------------------------------------------*/
		interprete = new Interprete("ir a la taberna");
		peticion = interprete.generarPeticion();

		assertEquals("moverse", peticion.getNombreAccion());
		assertEquals("taberna", peticion.getNombreUbicacion());
		
		/*-----------------------------------------------*/
		interprete = new Interprete("tomar espejo");
		peticion = interprete.generarPeticion();

		assertEquals("agarrar", peticion.getNombreAccion());
		assertEquals("espejo", peticion.getNombreItem());
		
		/*-----------------------------------------------*/
		interprete = new Interprete("mirar mesa");
		peticion = interprete.generarPeticion();

		assertEquals("mirar", peticion.getNombreAccion());
		assertEquals("mesa", peticion.getNombrePLace());
		
		/*-----------------------------------------------*/
		interprete = new Interprete("ayuda");
		peticion = interprete.generarPeticion();

		assertEquals("ayuda", peticion.getNombreAccion());
		
		/*-----------------------------------------------*/
		interprete = new Interprete("informacion");
		peticion = interprete.generarPeticion();

		assertEquals("informacion", peticion.getNombreAccion());
		/*-----------------------------------------------*/
		interprete = new Interprete("ir al hotel");
		peticion = interprete.generarPeticion();

		assertEquals("moverse", peticion.getNombreAccion());
		assertEquals("hotel", peticion.getNombreUbicacion());
		
	}
	
	@Test
	public void queUnComandoConTextoExtraFuncioneIgual() {
		
		interprete = new Interprete("mirar mesa asd d asd");
		Peticion peticion = interprete.generarPeticion();

		assertEquals("mirar", peticion.getNombreAccion());
		assertEquals("mesa", peticion.getNombrePLace());		
	}
}
