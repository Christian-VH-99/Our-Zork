package tests;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import acciones.Peticion;
import main.EntornoGson;
import main.Interprete;

public class InterpreteTest {

	public Interprete interprete;
	@Before
	public void before() {
		EntornoGson entorno = new EntornoGson();
		entorno.deserializar();
		interprete = new Interprete(entorno);
	}
	

	/** por ahora se abarcan estos tres casos */
	@Test
	public void queSeSepareCorrectamenteElComando() {
		//interprete = new Interprete("ir a la taberna");
		interprete.separarComando("ir a la taberna");
		assertEquals("ir taberna null", interprete.toString());
		interprete.recargarInterprete();
		
		interprete.separarComando("dar cerveza al fantasma");
		assertEquals("dar cerveza fantasma", interprete.toString());
		interprete.recargarInterprete();

		interprete.separarComando("dar la cerveza al fantasma");
		assertEquals("dar cerveza fantasma", interprete.toString());
	}

	@Test
	public void queUnComandoConSustantivoInexistenteDevuelveNull() {

		interprete.separarComando("dar asd");
		assertEquals(null, interprete.generarPeticion());
	}
	
	@Test
	public void queUnComandoConObjetoIndirectoInexistenteDevuelveNull() {
		
		interprete.separarComando("dar cerveza al");	
		assertEquals(null, interprete.generarPeticion());	
	}
//
	@Test
	public void queUnaOracionIncompletaDevuelveNull() {

		interprete.separarComando("dar ");
		assertEquals(null, interprete.generarPeticion());
	}
	
	@Test
	public void queUnComandoSinVerboDevuelveNull() {

		interprete.separarComando("cerveza al fantasma");

		assertEquals(null, interprete.generarPeticion());
	}
	
	@Test
	public void queUnComandoCorrectoGenenereLaPeticion() {

		interprete.separarComando("dar Anj a Isis");
		Peticion peticion = interprete.generarPeticion();

		assertEquals("dar", peticion.getNombreAccion());
		assertEquals("Anj", peticion.getNombreItem());
		assertEquals("Isis", peticion.getNombreNpc());
		interprete.recargarInterprete();
		/*-----------------------------------------------*/
		interprete.separarComando("ir a la capilla");
		peticion = interprete.generarPeticion();
		assertEquals("moverse", peticion.getNombreAccion());
		assertEquals("capilla", peticion.getNombreUbicacion());
		interprete.recargarInterprete();
		/*-----------------------------------------------*/
		interprete.separarComando("tomar Exodia");
		peticion = interprete.generarPeticion();

		assertEquals("agarrar", peticion.getNombreAccion());
		assertEquals("Exodia", peticion.getNombreItem());
		interprete.recargarInterprete();
		/*-----------------------------------------------*/
		interprete.separarComando("mirar mesa");
		peticion = interprete.generarPeticion();

		assertEquals("mirar", peticion.getNombreAccion());
		assertEquals("mesa", peticion.getNombrePLace());
		interprete.recargarInterprete();
		/*-----------------------------------------------*/
		interprete.separarComando("ayuda");
		peticion = interprete.generarPeticion();

		assertEquals("ayuda", peticion.getNombreAccion());
		interprete.recargarInterprete();
		/*-----------------------------------------------*/
		interprete.separarComando("informacion");
		peticion = interprete.generarPeticion();

		assertEquals("informacion", peticion.getNombreAccion());
		interprete.recargarInterprete();
		/*-----------------------------------------------*/
		interprete.separarComando("ir al corredor");
		peticion = interprete.generarPeticion();

		assertEquals("moverse", peticion.getNombreAccion());
		assertEquals("corredor", peticion.getNombreUbicacion());
		interprete.recargarInterprete();
		
	}
	
	@Test
	public void queUnComandoConTextoExtraFuncioneIgual() {
		
		interprete.separarComando("mirar mesa asd d asd");
		Peticion peticion = interprete.generarPeticion();

		assertEquals("mirar", peticion.getNombreAccion());
		assertEquals("mesa", peticion.getNombrePLace());		
	}
}
