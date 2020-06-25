package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Ubicacion.*;
import acciones.AccionBase;
import acciones.Agarrar;
import acciones.Ayuda;
import acciones.Dar;
import acciones.Informacion;
import acciones.Mirar;
import acciones.Moverse;
import acciones.Peticion;
//import acciones.Moverse;
import items.Inventario;
import items.Item;
import jugadores.Debilidad;
import jugadores.Jugador;
import jugadores.Npc;

public class JuegoMazeRunner {

	private Interprete interprete;
	private EndGame fin;
	private File file;
	private List<Ubicacion> ubicaciones;
	private Jugador jugador;
	private String entradaJugador;

//// constructor y  metodo generador para hacer los test para la primera entrega ////
	public JuegoMazeRunner(Jugador jugador) {
		this.jugador = jugador;
	}

	public void generarEntorno() {

		/********************************************/
		Ubicacion caja = new Ubicacion("caja", 'F');
		caja.setMensajeDeingreso(
				"Te despiertas en una caja metálica semejante a un ascensor. Lo único que recuerdas es tu nombre: Thomas. A tu alrededor hay una pared con un interruptor y en el suelo una linterna.");
		Place suelo = new Place("suelo", 'M', 'S');
		suelo.agregarItem(new Item("linterna", 'F', 'S'));

		Place pared = new Place("pared", 'M', 'S');

		caja.agregarPlace(suelo);
		caja.agregarPlace(pared);
		/********************************************/
		Ubicacion fogata = new Ubicacion("fogata", 'F');
		fogata.setMensajeDeingreso(
				"¡Activaste el interruptor y las puertas se han abierto! Sales afuera a un gran Área campal parecida a un cuadrado perfecto. La caja vuelve a bajar desapareciendo como por arte de magia. Te espera un grupo de jóvenes que te miran asombrados. Uno de ellos toma la iniciativa y dice: ‘¡Bienvenido al Laberinto novato!’. Miras a tu alrededor y hay una fila de asientos junto a una mesa larga y en el centro una llameante fogata. En la mesa hay un gran banquete.");
		Place filaDeAcientos = new Place("fila de asientos", 'F', 'S');

		fogata.agregarPlace(filaDeAcientos);
		/********************************************/
		Ubicacion puertaNorte = new Ubicacion("puerta norte", 'F');
		puertaNorte.setMensajeDeingreso(
				"“¡Has entrado al Laberinto por el Norte! Recorres un largo tramo hasta que te encuentras con una situación inesperada. En el piso, junto a una de las paredes del Laberinto, se encuentra un Corredor. Pero algo extraño sucede…¡se está desangrando! Del otro lado, se encuentra una cantimplora seguramente con agua. Decide que hacer");
		
		/********************************************/
		Ubicacion salidaNorte= new Ubicacion("salida norte", 'F');
		salidaNorte.setMensajeDeingreso("“¡Has encontrado una salida! Por fin sales al exterior. Comienzas a sentir la fresca brisa del día cuando de repente… ¡eres atravesado por un brazo en forma de cuchilla! El Penitente que has derrotado no estaba solo, su amigo ha vengado su muerte. Después de un tiempo, el nombre Thomas es agregado a la lista de fallecidos.");
		
		/********************************************/
		Ubicacion segundaZonaNorte = new Ubicacion("segunda zona norte", 'F');
		segundaZonaNorte.setMensajeDeingreso("¡Cuidado! Te has cruzado con un Penitente. Decide rápido que hacer.");
		
		/********************************************/
		Ubicacion puertaSur = new Ubicacion("puerta sur", 'F');

		/********************************************/
		Ubicacion zonaDeSuministros = new Ubicacion("zona de suministros", 'F');

		zonaDeSuministros.setMensajeDeingreso(
				"Te encuentras en una especie de carpa amplia con varios objetos de combate y de salud. A tu alrededor se encuentra un cofre y un estante con armas.");

		Place estante = new Place("estante", 'M', 'S');
		estante.agregarItem(new Item("machete", 'M', 'S'));
		estante.agregarItem(new Item("arco", 'M', 'S'));

		/********************************************/
		Ubicacion salaDeMapas = new Ubicacion("sala de mapas", 'F');
		salaDeMapas.setMensajeDeingreso(
				"Te encuentras en un salón con toques antiguos lleno de papeles ilegibles y mapas desparramados por todo el lugar. A tu alrededor hay un escritorio y una ventana donde se encuentra un individuo de piel morena mirando hacia afuera.Con que eres el nuevo. Déjame decirte una cosa. Estamos aquí hace más de 4 años. Yo fui el primero en llegar y hasta ahora nadie ha podido escapar. Allí afuera el problema no es el Laberinto sino los Penitentes, monstruos que te aniquilan apenas verte. Creemos que hay una SALIDA detrás de ellos. Ve con cuidado si piensas ir por ese camino. Y si te cruzas con uno, siempre usa armas a DISTANCIA.”");

		/******************* Conexiones ****************/

		// la direccion podria ir directamente como sinonimo en vez de como argumento
		caja.agregarConexion(new Conexion(fogata, "arriba"));
		fogata.agregarConexion(new Conexion(puertaNorte, "norte"));
		fogata.agregarConexion(new Conexion(puertaSur, "sur"));
		fogata.agregarConexion(new Conexion(zonaDeSuministros, "este"));
		fogata.agregarConexion(new Conexion(salaDeMapas, "oeste"));

		salaDeMapas.agregarConexion(new Conexion(fogata, "oeste"));
		zonaDeSuministros.agregarConexion(new Conexion(fogata, "este"));
		

		/******************* Jugador ****************/

		jugador.setUbicacionActual(caja);
//		jugador.setInventario(inventario);
	}

	public static void main(String[] args) {

		// TODO: a modo de ejemplo, se debe probar esto con la nueva historia
		AccionBase accionBase;
		Jugador jugador;
		JuegoMazeRunner juego;
		Agarrar accion;
		Informacion informacion;
		jugador = new Jugador("Juanito");
		juego = new JuegoMazeRunner(jugador);

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
		/*********************************************/

		String entradaTeclado = null;
		Scanner entradaEscaner = null;
		Interprete interprete = null;
		Peticion peticion = null;

		do {
			entradaEscaner = new Scanner(System.in);
			entradaTeclado = entradaEscaner.nextLine();

			interprete = new Interprete(entradaTeclado);
			peticion = interprete.generarPeticion();
			accion.ejecutar(peticion, jugador);

		} while (!juego.esFinDeJuego(peticion, jugador));

		System.out.println("Fin del juego, felicidades!");
	}

	private boolean esFinDeJuego(Peticion peticion, Jugador jugador2) {

		// hay que cargarlo en base a historia
		ArrayList<Peticion> condicionesFinDeJuegoList = new ArrayList<Peticion>();

		// NOTA: se debera comparar el estado actual del jugador con cada uno de los
		// finales posibles
		for (Peticion peticion2 : condicionesFinDeJuegoList) {

		}

		return false;
	}

}
