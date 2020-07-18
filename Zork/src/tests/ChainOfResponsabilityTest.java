package tests;

import static org.junit.Assert.assertEquals;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

import Ubicacion.Conexion;
import Ubicacion.Direcciones;
import Ubicacion.Place;
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
import jugadores.Debilidad;
import jugadores.Jugador;
import jugadores.Npc;
import main.Juego;

/*TODO: esta clase debe probar la cadena completa de acciones*/
public class ChainOfResponsabilityTest {

	AccionBase accionBase;
	Jugador jugador;
	Juego juego;
	Agarrar accion;
	Informacion informacion;
	JLabel imagen;
	Ubicacion casa;
	Item cerveza;

	@Before
	public void before() {

		jugador = new Jugador("Juanito");
		juego = new Juego(jugador);

		Mirar mirar = new Mirar();

		accion = new Agarrar();
		accion.setSiguiente(mirar);

		Ayuda ayuda = new Ayuda();
		mirar.setSiguiente(ayuda);

		informacion = new Informacion();
		ayuda.setSiguiente(informacion);

		Moverse moverse = new Moverse();
		informacion.setSiguiente(moverse);

		Dar dar = new Dar();
		moverse.setSiguiente(dar);

		// entorno

		casa = new Ubicacion("casa", 'F');
		Place mesa = new Place("mesa", 'F', 'S');
		Item botella = new Item("botella", 'F', 'S', 10);
		Item cuchillo = new Item("cuchillo", 'M', 'S', 10);
		cerveza = new Item("cerveza", 'F', 'S', 10);
		Item espejo = new Item("espejo", 'M', 'S', 10);

		mesa.agregarItem(botella);
		mesa.agregarItem(cuchillo);
		mesa.agregarItem(espejo);
		casa.agregarPlace(mesa);

		jugador.getInventario().agregarItem(cerveza);
		jugador.setUbicacionActual(casa);

	}

	@Test
	public void queSeEjecuteAgarrar() {

		accion.ejecutar(new Peticion("agarrar", null, "espejo", null, null), jugador, new JLabel());
		assertEquals(true, jugador.getInventario().buscarItem("espejo"));

	}

	@Test
	public void queSeEjecuteMirar() {

		assertEquals("En la mesa hay una botella, un cuchillo, y un espejo.",
				accion.ejecutar(new Peticion("mirar", null, null, null, "mesa"), jugador, new JLabel()));
	}

	@Test
	public void queSeEjecuteAyuda() {
		String salida = "estas ubicado en ";
		salida += jugador.getUbicacionActual().getNombreGenero();
		salida += ". Puedes interactuar con todos los sitios e items que hay en este lugar\n"
				+ "para poder ver los sitios podes usar MIRAR LUGAR y para ver los items MIRAR 'nombre del sitio' \n"
				+ "tambien podes agarra los items del lugar con AGARRAR 'nombre de item' \n."
				+ "recuerda que para pasar por ciertos lugares necesitas items especificos.";

		assertEquals(salida, accion.ejecutar(new Peticion("ayuda"), jugador, new JLabel()));
	}

	@Test
	public void queSeEjecuteInformacion() {

		String salida = "Bienvenido ";
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

		assertEquals(salida, accion.ejecutar(new Peticion("informacion"), jugador, new JLabel()));
	}

	@Test
	public void queSeEjecuteMoverse() {

		Ubicacion hotel = new Ubicacion("hotel", 'M');
		casa.agregarConexion(new Conexion(hotel, Direcciones.NORTE));
		accion.ejecutar(new Peticion("moverse", "hotel", null, null, null), jugador, new JLabel());

		assertEquals(hotel, jugador.getUbicacionActual());
	}

	@Test
	public void queSeEjecuteDar() {

		Npc fantasma = new Npc("fantasma", 'M', "", "", new Debilidad(cerveza, "me ganaste", ""), 'S');
		casa.agregarNpc(fantasma);
		assertEquals("fantasma ", jugador.getUbicacionActual().listarNpcs());
		accion.ejecutar(new Peticion("dar", null, "cerveza", "fantasma", null), jugador, new JLabel());
		assertEquals("", jugador.getUbicacionActual().listarNpcs());
	}
}
