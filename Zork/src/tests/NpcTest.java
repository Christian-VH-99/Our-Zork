package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import items.Item;
import jugadores.Debilidad;
import jugadores.Npc;

public class NpcTest {

	static private Item it1;
	static private Item it2;
	static private Debilidad deb;
	static private Npc npc;

	@BeforeClass
	public static void before() {
		it1 = new Item("Agua", 'F', 'S');
		it2 = new Item("Cerveza", 'F', 'S');
		deb = new Debilidad(it2, "Uh! me encanta la cereveza, solo por esta vez te dejare pasar a la taverna", "");
		npc = new Npc("Borracho", 'M', "Borracho de todos los dias", "¡Acaso pensaste pasar como si nada?!", deb, 'S');
	}

	@Test
	public void testAttackInvalido() {
		assertFalse(npc.attack(it1));// No sirvio porque quiere alcohol, no agua.
	}

	@Test
	public void testAttackValido() {

		System.out.println();
		assertTrue(npc.attack(it2)); // Le dio alcohol y paso a la taverna

	}


	//OK
	@Test
	public void testDialogos() {
		npc.addSentenciaYRespuesta("opcionA", "pasare igual, forro", "Te voy a matar aashh");
		npc.addSentenciaYRespuesta("opcionB", "Maldito borracho, movete!", "Te voy a matar aashh");

		
		System.out.println("Ingresar: decir + opcion+letraDeSentencia + nombreNPC \n");
		
		assertEquals("Ingresar: decir + opcion+letraDeSentencia + nombreNPC \r\n" + 
				"opcionB : Maldito borracho, movete!\r\n" + 
				"opcionA : pasare igual, forro\r\n" + 
				"",
				npc.getSentenciasPosibles());
	}

}
