package tests;

import static org.junit.Assert.assertEquals;
<<<<<<< HEAD

import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

import Ubicacion.Place;
=======
import javax.swing.JLabel;
import org.junit.Before;
import org.junit.Test;
>>>>>>> Ramiro
import Ubicacion.Ubicacion;
import acciones.AccionBase;
import acciones.Agarrar;
import acciones.Ayuda;
import acciones.Dar;
import acciones.Informacion;
import acciones.Mirar;
import acciones.Moverse;
import acciones.Peticion;
import items.Item;
<<<<<<< HEAD
import jugadores.Jugador;
=======
import jugadores.Debilidad;
import jugadores.Jugador;
import jugadores.Npc;
import main.EntornoGson;
>>>>>>> Ramiro
import main.Interprete;
import main.Juego;

/*Este test no tiene mucho sentido mas alla de probar el caso hipotetico de ingresar cada comando*/
public class ChainConInterprete {

<<<<<<< HEAD
	static AccionBase accionBase;
	static Jugador jugador;
	static Juego juego;
	static Agarrar accion;
	static Informacion informacion;	

	@BeforeClass
	static public void before() {
=======
	AccionBase accionBase;
	Jugador jugador;
	Juego juego;
	Agarrar accion;
	Informacion informacion;
	JLabel imagen;
	Ubicacion casa;
	Item itemAuxilear;
	public Interprete interprete;
	EntornoGson entorno;
	@Before
	public void before() {
		
		//aca prende el interprete 
		
		entorno = new EntornoGson();
		entorno.deserializar("piramide.json");
		interprete = new Interprete(entorno);
		//entorno para poder pobras las cosas
		
		imagen = new JLabel();
		
>>>>>>> Ramiro
		jugador = new Jugador("Juanito");
		juego = new Juego(jugador);

		Mirar mirar = new Mirar();

		accion = new Agarrar();// incial
		accion.setSiguiente(mirar);

		Ayuda ayuda = new Ayuda();
		mirar.setSiguiente(ayuda);

		informacion = new Informacion();
		ayuda.setSiguiente(informacion);

		Moverse moverse = new Moverse();
		informacion.setSiguiente(moverse);

		Dar dar = new Dar();
<<<<<<< HEAD
		informacion.setSiguiente(dar);
	}

	@Test
	public void queSiSeIngresaMoverseSeEjecuteLaAccion() {

		jugador = new Jugador("Juanito");
		juego = new Juego(jugador);

		Mirar mirar = new Mirar();

		accion = new Agarrar();// incial
		accion.setSiguiente(mirar);

		Ayuda ayuda = new Ayuda();
		mirar.setSiguiente(ayuda);

		informacion = new Informacion();
		ayuda.setSiguiente(informacion);

		Moverse moverse = new Moverse();
		informacion.setSiguiente(moverse);

		Ubicacion hotel = new Ubicacion("hotel", 'M');
		Place cama = new Place("Cama", 'F', 'S');

		hotel.agregarPlace(cama);

		juego.generarEntorno();
		/*************************/

		Interprete interprete = new Interprete("ir al hotel");
		Peticion peticion = interprete.generarPeticion();
		if (peticion != null) {
			accion.ejecutar(peticion, jugador);
		} else {
			System.out.println("Comando invalido");
		}

		Ubicacion ubicacion = jugador.getUbicacionActual();
		assertEquals("Estas en el hotel. Hay una Cama.", ubicacion.describir());

	}

	@Test // OK
	public void queSiSeIngresaAyudaSeEjecuteLaAccion() {

		Interprete interprete = new Interprete("ayuda");
		Peticion peticion = interprete.generarPeticion();

		Ubicacion casa = new Ubicacion("casa", 'F');
		jugador.setUbicacionActual(casa);
		accion.ejecutar(peticion, jugador);
	}

	@Test // OK
	public void queSiSeIngresaDarSeEjecuteLaAccion() {
		jugador = new Jugador("Juanito");
		juego = new Juego(jugador);

		Mirar mirar = new Mirar();

		accion = new Agarrar();// incial
		accion.setSiguiente(mirar);

		Ayuda ayuda = new Ayuda();
		mirar.setSiguiente(ayuda);

		informacion = new Informacion();
		ayuda.setSiguiente(informacion);

		Moverse moverse = new Moverse();
		informacion.setSiguiente(moverse);

		Dar dar = new Dar();
		informacion.setSiguiente(dar);
		/*********************************************/
		juego.generarEntorno();
		assertEquals("fantasma ", jugador.getUbicacionActual().getNpcs());

		Interprete interprete = new Interprete("darle la cerveza al fantasma");
		Peticion peticion = interprete.generarPeticion();

		accion.ejecutar(peticion, jugador);
		assertEquals("", jugador.getUbicacionActual().getNpcs());
	}
	
	@Test // OK
	public void queSiSeIngresaAgarrarSeEjecuteLaAccion() {
		
		
		juego.generarEntorno();

		/** Antes de agarrar algo */
		assertEquals("En tu inventario hay: una cerveza.", jugador.getInventario().listarItems());
		Interprete interprete = new Interprete("agarrar espejo");
		Peticion peticion = interprete.generarPeticion();
		accion.ejecutar(peticion, jugador);
		assertEquals("En tu inventario hay: una cerveza, y un espejo.", jugador.getInventario().listarItems());
	}
	
	@Test
	public void queSeEjecuteMirar() {

		Ubicacion casa = new Ubicacion("casa", 'F');
		Place mesa = new Place("mesa", 'F', 'S');
		Item botella = new Item("botella", 'F', 'S');
		Item cuchillo = new Item("cuchillo", 'M', 'S');

		mesa.agregarItem(botella);
		mesa.agregarItem(cuchillo);

		casa.agregarPlace(mesa);

		jugador.setUbicacionActual(casa);
		Interprete interprete = new Interprete("mirar mesa");
		Peticion peticion = interprete.generarPeticion();
		accion.ejecutar(peticion, jugador);

	}
	
}
=======
		moverse.setSiguiente(dar);
		
		
		//entorno 
		
		casa = new Ubicacion("casa", 'F');
		itemAuxilear = new Item("Exodia",'F','S',0);

		jugador.setUbicacionActual(entorno.getUbicacion());
		
	}

	@Test
	public void queSeEjecuteAgarrar() {
	
		interprete.recargarInterprete();
		interprete.separarComando("agarrar Exodia");
		Peticion peticion = interprete.generarPeticion();
		accion.ejecutar(peticion, jugador, imagen);
		assertEquals(true, jugador.getInventario().buscarItem("Exodia"));

	}

	@Test
	public void queSeEjecuteMirar() {

		interprete.recargarInterprete();
		interprete.separarComando("mirar");
		Peticion peticion = interprete.generarPeticion();
		assertEquals("Estas en la joyeria. Hay un altar y un cofre. Se ve a lo lejos una capilla, y una cripta.",accion.ejecutar(peticion, jugador,imagen));
	}

	@Test
	public void queSeEjecuteAyuda() {
		
		interprete.recargarInterprete();
		interprete.separarComando("ayuda");
		Peticion peticion = interprete.generarPeticion();
		String salida = "estas ubicado en ";
		salida += jugador.getUbicacionActual().getNombreGenero();
		salida += ". Puedes interactuar con todos los sitios e items que hay en este lugar\n"
				+ "para poder ver los sitios podes usar MIRAR LUGAR y para ver los items MIRAR 'nombre del sitio' \n"
				+ "tambien podes agarra los items del lugar con AGARRAR 'nombre de item' \n."
				+ "recuerda que para pasar por ciertos lugares necesitas items especificos.";
		
		assertEquals(salida,accion.ejecutar(peticion, jugador,imagen));
	}

	@Test
	public void queSeEjecuteInformacion() {

		interprete.recargarInterprete();
		interprete.separarComando("informacion");
		Peticion peticion = interprete.generarPeticion();
		String salida;
		salida = "Bienvenido ";
		salida += jugador.getNombre();
		salida += "\n_______________________________________________________________________________\n"
				+ "Lista de Comandos\r\n"
				+ "para poder moverte puede señalizar el lugar por su nombre con el vervo ir adelante IR 'nombre del lugar' \n"
				+ "tambien puedes usar 'MOVERME A *lugar al que quieras ir*' dependiendo a donde quieras moverte.\n"
				+ "en algunos sitios no vas a poder pasar porque necesitar items especificos para que se pueda habilidar ese sitio\n"
				+ "para agarrar en estos items podes usar AGARRAR 'nombre del item', .\n"
				+ "para poder ver tu entorno poder utilizar MIRAR, para  ver los sitios  \n"
				+ "MIRAR 'nombre del sitio'.\n"
				+ "Dependiendo de los items que recojas, tendras una puntuacion diferente, que no sabras hasta haber terminado el juego.\n"
				+ "________________________________________________________________________________\n";

		assertEquals(salida,accion.ejecutar(peticion, jugador,imagen));
	}
	@Test
	public void queSeEjecuteMoverse() {
		
		interprete.recargarInterprete();
		interprete.separarComando("ir capilla");
		Peticion peticion = interprete.generarPeticion();
		accion.ejecutar(peticion, jugador,imagen);
		
		assertEquals("capilla",jugador.getUbicacionActual().getNombre());
	}
	
	@Test
	public void queSeEjecuteDar() {
		
		jugador.setUbicacionActual(casa);
		jugador.getInventario().agregarItem(itemAuxilear);
		
		Npc npcAuxilear = new Npc("Momia",'M',"","",new Debilidad(itemAuxilear,"me ganaste",""),'S');
		casa.agregarNpc(npcAuxilear);
		
		assertEquals("Momia ", jugador.getUbicacionActual().listarNpcs());
		
		interprete.recargarInterprete();
		interprete.separarComando("dar Exodia a Momia");
		Peticion peticion = interprete.generarPeticion();
		accion.ejecutar(peticion, jugador,imagen);
		
		assertEquals("", jugador.getUbicacionActual().listarNpcs());
		
	}
}
>>>>>>> Ramiro
