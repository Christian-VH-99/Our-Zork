package main;

import java.util.ArrayList;


import Ubicacion.Conexion;
import Ubicacion.Direcciones;
import Ubicacion.Place;
import Ubicacion.Ubicacion;
import acciones.Peticion;
import items.Item;
import jugadores.Debilidad;
import jugadores.Npc;

public class Entorno {

	private Ubicacion ubicacion;
	private String bienvenida;
	//private EndGame fin;
	private ArrayList<Peticion> finales = new ArrayList<Peticion>(4);

	ArrayList<String> itemsList=new ArrayList<String>(16);
	ArrayList<String> ubicacionesList=new ArrayList<String>(12);
	ArrayList<String> npcsList=new ArrayList<String>(5);
	ArrayList<String> placesList=new ArrayList<String>(16);


	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public String getBienvenida() {
		return bienvenida;
	}

	public ArrayList<Peticion> getFinales() {
		return finales;
	}

	public ArrayList<String> getItemsList() {
		return itemsList;
	}

	public ArrayList<String> getUbicacionesList() {
		return ubicacionesList;
	}

	public ArrayList<String> getNpcsList() {
		return npcsList;
	}

	public ArrayList<String> getPlacesList() {
		return placesList;
	}

	public void generarEntornoDentroPiramide() {

		bienvenida = "Después de tanto esfuerzo lograste llegar a la sala de joyas donde encontraste lo que tanto anhelaba El Udyat!!!, pero por culpa de la maldición impuesta Horus por robar su tesoro las salas de la pirámide se están cerrando, tenes que salir lo antes posible.";

		// ubicaciones
		Ubicacion joyeria = new Ubicacion("joyeria", 'F');
		Ubicacion capilla = new Ubicacion("capilla", 'F');
		Ubicacion cripta = new Ubicacion("cripta", 'F');
		Ubicacion corredor = new Ubicacion("corredor", 'M');
		Ubicacion vestibulo = new Ubicacion("vestibulo", 'M');
		Ubicacion santuario = new Ubicacion("santuario", 'M');
		Ubicacion fosa = new Ubicacion("fosa", 'F');
		Ubicacion mazmorra = new Ubicacion("mazmorra", 'F');

		// places
		Place altarJoyeria = new Place("altar", 'M', 'S');
		Place cofreJoyeria = new Place("cofre", 'M', 'S');
		Place ambonCapilla = new Place("ambon", 'M', 'S');
		Place vitrinaCapilla = new Place("vitrina", 'F', 'S');
		Place altarVestibulo = new Place("altar", 'M', 'S');
		Place paredVestibulo = new Place("Mesa", 'F', 'S');
		Place cupulaCorredor = new Place("cupula", 'F', 'S');
		Place alfombraCorredor = new Place("alfombra", 'F', 'S');
		Place mesaSantuario = new Place("mesa", 'F', 'S');
		Place estanteSantuario = new Place("estante", 'M', 'S');
		Place sarcofagoCripta = new Place("sarcofago", 'M', 'S');
		Place vitrinaCripta = new Place("vitrina", 'F', 'S');
		Place vasijaMazmorra = new Place("vasija", 'F', 'S');
		Place bancoMazmorra = new Place("banco", 'F', 'S');
		Place esqueletoTrampa = new Place("esqueleto", 'M', 'S');
		Place piedraTrampa = new Place("piedra", 'F', 'S');

		// Items
		altarJoyeria.agregarItem(new Item("Udyat", 'M', 'S'));
		Item exodia = new Item("Exodia", 'M', 'S');
		cofreJoyeria.agregarItem(exodia);
		vitrinaCapilla.agregarItem(new Item("rubi", 'F', 'S'));
		Item anj = new Item("Anj", 'F', 'S');
		ambonCapilla.agregarItem(anj);
		altarVestibulo.agregarItem(new Item("Sphynx", 'M', 'S'));
		paredVestibulo.agregarItem(new Item("jeroglificos", 'M', 'P'));//
		alfombraCorredor.agregarItem(new Item("cetro", 'M', 'S'));
		cupulaCorredor.agregarItem(new Item("tallado", 'M', 'S'));//
		mesaSantuario.agregarItem(new Item("espada", 'F', 'S'));
		estanteSantuario.agregarItem(new Item("estatuilla", 'F', 'S'));
		sarcofagoCripta.agregarItem(new Item("corona", 'F', 'S'));
		vitrinaCripta.agregarItem(new Item("chacal", 'M', 'S'));
		vasijaMazmorra.agregarItem(new Item("serpiente", 'F', 'S'));
		bancoMazmorra.agregarItem(new Item("cadenas", 'F', 'P'));//
		esqueletoTrampa.agregarItem(new Item("calavera", 'F', 'S'));
		piedraTrampa.agregarItem(new Item("daga", 'F', 'S'));

		// agregar places
		joyeria.agregarPlace(altarJoyeria);
		joyeria.agregarPlace(cofreJoyeria);
		capilla.agregarPlace(vitrinaCapilla);
		capilla.agregarPlace(ambonCapilla);
		vestibulo.agregarPlace(altarVestibulo);
		vestibulo.agregarPlace(paredVestibulo);
		corredor.agregarPlace(cupulaCorredor);
		corredor.agregarPlace(alfombraCorredor);
		santuario.agregarPlace(mesaSantuario);
		santuario.agregarPlace(estanteSantuario);
		cripta.agregarPlace(vitrinaCripta);
		cripta.agregarPlace(sarcofagoCripta);
		mazmorra.agregarPlace(bancoMazmorra);
		mazmorra.agregarPlace(vasijaMazmorra);
		fosa.agregarPlace(esqueletoTrampa);
		fosa.agregarPlace(piedraTrampa);

		// agregar conexiones
		joyeria.agregarConexion(new Conexion(capilla, Direcciones.NORTE));
		joyeria.agregarConexion(new Conexion(cripta, Direcciones.ESTE));
		capilla.agregarConexion(new Conexion(vestibulo, Direcciones.ESTE));
		cripta.agregarConexion(new Conexion(corredor, Direcciones.ESTE));
		vestibulo.agregarConexion(new Conexion(corredor, Direcciones.SUR));
		corredor.agregarConexion(new Conexion(santuario, Direcciones.ESTE));
		corredor.agregarConexion(new Conexion(mazmorra, Direcciones.SUR));
		mazmorra.agregarConexion(new Conexion(fosa, Direcciones.OESTE));

		// NPCs bobos

		vestibulo.agregarNpc(new Npc("Espectro", 'M', "- ves a un Espectro",
				"¡Estas paredes nos cuentan la eterna busqueda de la Anj, ella merodea por las mazmorras esperando a que alguien se la entregue!",
				'S'));
		cripta.agregarNpc(new Npc("Momia", 'F', "- ves a una Momia",
				"Yo solia ser el gran Tutmosis I todo el mundo estaba bajo mis pies, pero ahora solo hay polvo debajo de ellos",
				'S'));
		fosa.agregarNpc(new Npc("Ermitanio", 'M', "- ves a un Ermitanio ",
				"La unica salida de aca es usando esa daga JAJAJAJAJAJAJA", 'S'));

		// NPC utiles
		Debilidad deIsis = new Debilidad(anj,
				"Gracias aventurero por encontrar mi llave, te concedere la salida al exterior como agradecimiento", "dar");
		Debilidad deYugi = new Debilidad(exodia, "NO PUEDO CREER QUE LO HAYAS ENCONTRADO!!, como recompensa te sacare con mi collar del milenio", "dar");
		mazmorra.agregarNpc(new Npc("Isis", 'F', "- Observas a una deidad poderosa, es Isis",
				"He estado en la busqueda de mi llave por años", deIsis, 'S'));
		santuario.agregarNpc(new Npc("Yugi", 'M', "- Observas a Yugi ", "Para poder salir tienes 2 opciones, darme a exodia o usar la espada", deYugi, 'S'));
		ubicacion = joyeria;

		// final1: dar carta a Yugi
		Peticion final1 = new Peticion("dar", null, "Exodia", "Yugi", null);

		// final2: dar llave a Isis
		Peticion final2 = new Peticion("dar", null, "Anj", "Isis", null);

		// final3: usar espda
		Peticion final3 = new Peticion("usar", null, "espada", null, null);

		// final4: usar daga
		Peticion final4 = new Peticion("usar", null, "daga", null, null);
		
		
		finales.add(final1);
		finales.add(final2);
		finales.add(final3);
		finales.add(final4);
		
		/*-----------------------------------------------*/
		itemsList.add("Exodia");
		itemsList.add("Udyat");
		itemsList.add("rubi");
		itemsList.add("Sphynx");
		itemsList.add("jeroglificos");
		itemsList.add("cetro");
		itemsList.add("tallado");
		itemsList.add("espada");
		itemsList.add("estatuilla");
		itemsList.add("corona");
		itemsList.add("chacal");
		itemsList.add("serpiente");
		itemsList.add("cadenas");
		itemsList.add("cadaver");
		itemsList.add("daga");
		itemsList.add("Anj");
		/*-----------------------------------------------*/
		ubicacionesList.add("joyeria");
		ubicacionesList.add("capilla");
		ubicacionesList.add("cripta");
		ubicacionesList.add("corredor");
		ubicacionesList.add("vestibulo");
		ubicacionesList.add("santuario");
		ubicacionesList.add("fosa");
		ubicacionesList.add("mazmorra");
		ubicacionesList.add("NORTE");
		ubicacionesList.add("SUR");
		ubicacionesList.add("ESTE");
		ubicacionesList.add("OESTE");

		/*-----------------------------------------------*/
		npcsList.add("Espectro");
		npcsList.add("Yugi");//
		npcsList.add("Momia");
		npcsList.add("Ermitanio");
		npcsList.add("Isis");//
		/*-----------------------------------------------*/
		placesList.add("cofre");
		placesList.add("altar");
		placesList.add("ambon");
		placesList.add("exhibidor");
		placesList.add("mesa");
		placesList.add("cupula");
		placesList.add("banco");
		placesList.add("estante");
		placesList.add("sarcofago");
		placesList.add("vitrina");
		placesList.add("vasija");
		placesList.add("piedra");
		placesList.add("alrededor");
		placesList.add("inventario");

	}
}
