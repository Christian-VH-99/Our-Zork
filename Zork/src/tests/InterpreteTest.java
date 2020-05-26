package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Interprete;

public class InterpreteTest {


	/**por ahora se abarcan estos tres casos*/
	@Test
	public void queSeSepareCorrectamenteElComando() {
		Interprete interprete = new Interprete("ir a la taberna");
		assertEquals("ir taberna null", interprete.toString());
		
		Interprete interprete2 = new Interprete("dar cerveza al fantasma");
		assertEquals("dar cerveza fantasma", interprete2.toString());
		
		Interprete interprete3 = new Interprete("dar la cerveza al fantasma");
		assertEquals("dar cerveza fantasma", interprete3.toString());
	}
}
