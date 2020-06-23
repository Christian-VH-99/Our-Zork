package tests;
import java.util.Scanner;
import acciones.AccionBase;
import acciones.Agarrar;
import acciones.Ayuda;
import acciones.Dar;
import acciones.Informacion;
import acciones.Mirar;
import acciones.Moverse;
import acciones.Peticion;
import jugadores.Jugador;
import main.Interprete;
import main.Juego;

public class App {
	static AccionBase accionBase;
	static Jugador jugador;
	static Juego juego;
	static Agarrar accion;
	static Informacion informacion;

	public static void main(String[] args) {

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
		/*********************************************/

		String entradaTeclado = null;
		Scanner entradaEscaner = null;
		Interprete interprete = null;
		Peticion peticion = null;

		while (!jugador.esFinDeJuego()) {

			entradaEscaner = new Scanner(System.in);
			entradaTeclado = entradaEscaner.nextLine();

			interprete = new Interprete(entradaTeclado);
			peticion = interprete.generarPeticion();
			accion.ejecutar(peticion, jugador);

		}
	}
}