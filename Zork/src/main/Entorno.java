package main;

import java.util.ArrayList;

<<<<<<< HEAD

=======
>>>>>>> Ramiro
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
<<<<<<< HEAD
	//private EndGame fin;
	private ArrayList<Peticion> finales = new ArrayList<Peticion>(4);

	ArrayList<String> itemsList=new ArrayList<String>(16);
	ArrayList<String> ubicacionesList=new ArrayList<String>(12);
	ArrayList<String> npcsList=new ArrayList<String>(5);
	ArrayList<String> placesList=new ArrayList<String>(16);

=======
	private ArrayList<FinDeJuego> finales = new ArrayList<FinDeJuego>(4);

	ArrayList<String> itemsList = new ArrayList<String>(16);
	ArrayList<String> ubicacionesList = new ArrayList<String>(12);
	ArrayList<String> npcsList = new ArrayList<String>(5);
	ArrayList<String> placesList = new ArrayList<String>(16);
>>>>>>> Ramiro

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public String getBienvenida() {
		return bienvenida;
	}

<<<<<<< HEAD
	public ArrayList<Peticion> getFinales() {
=======
	public ArrayList<FinDeJuego> getFinales() {
>>>>>>> Ramiro
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

<<<<<<< HEAD
		bienvenida = "Después de tanto esfuerzo lograste llegar a la sala de joyas donde encontraste lo que tanto anhelaba El Udyat!!!, pero por culpa de la maldición impuesta Horus por robar su tesoro las salas de la pirámide se están cerrando, tenes que salir lo antes posible.";
=======
		bienvenida = "Después de tanto esfuerzo lograste llegar a la sala de joyas donde encontraste lo que tanto anhelabas, El Udyat!!!, pero por culpa de la maldición impuesta por Horus al robar su tesoro, las salas de la pirámide se están derrumbando, tenes que salir lo antes posible.";
>>>>>>> Ramiro

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
<<<<<<< HEAD
		Place vitrinaCapilla = new Place("vitrina", 'F', 'S');
		Place altarVestibulo = new Place("altar", 'M', 'S');
		Place paredVestibulo = new Place("Mesa", 'F', 'S');
		Place cupulaCorredor = new Place("cupula", 'F', 'S');
		Place alfombraCorredor = new Place("alfombra", 'F', 'S');
=======
		Place vasarCapilla = new Place("vasar", 'M', 'S');
		Place sagrarioVestibulo = new Place("sagrario", 'M', 'S');
		Place arconVestibulo = new Place("muro", 'M', 'S');
		Place columnaCorredor = new Place("columna", 'F', 'S');
		Place descansoCorredor = new Place("descanso", 'M', 'S');
>>>>>>> Ramiro
		Place mesaSantuario = new Place("mesa", 'F', 'S');
		Place estanteSantuario = new Place("estante", 'M', 'S');
		Place sarcofagoCripta = new Place("sarcofago", 'M', 'S');
		Place vitrinaCripta = new Place("vitrina", 'F', 'S');
		Place vasijaMazmorra = new Place("vasija", 'F', 'S');
<<<<<<< HEAD
		Place bancoMazmorra = new Place("banco", 'F', 'S');
=======
		Place paredMazmorra = new Place("pared", 'F', 'S');
>>>>>>> Ramiro
		Place esqueletoTrampa = new Place("esqueleto", 'M', 'S');
		Place piedraTrampa = new Place("piedra", 'F', 'S');

		// Items
<<<<<<< HEAD
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
=======
		altarJoyeria.agregarItem(new Item("Udyat", 'M', 'S', 100));
		Item exodia = new Item("Exodia", 'M', 'S', 70);
		cofreJoyeria.agregarItem(exodia);
		vasarCapilla.agregarItem(new Item("rubi", 'M', 'S', 50));
		Item anj = new Item("Anj", 'M', 'S', 50);
		ambonCapilla.agregarItem(anj);
		sagrarioVestibulo.agregarItem(new Item("Sphynx", 'M', 'S', 10));
		arconVestibulo.agregarItem(new Item("jeroglificos", 'M', 'P', -50));//
		descansoCorredor.agregarItem(new Item("cetro", 'M', 'S', 30));
		columnaCorredor.agregarItem(new Item("pergamino", 'M', 'S', 20));//
		mesaSantuario.agregarItem(new Item("espada", 'F', 'S', 25));
		estanteSantuario.agregarItem(new Item("estatuilla", 'F', 'S', -20));
		sarcofagoCripta.agregarItem(new Item("corona", 'F', 'S', 60));
		vitrinaCripta.agregarItem(new Item("chacal", 'M', 'S', 40));
		vasijaMazmorra.agregarItem(new Item("serpiente", 'F', 'S', -25));
		paredMazmorra.agregarItem(new Item("cadenas", 'F', 'P', 0));//
		esqueletoTrampa.agregarItem(new Item("calavera", 'F', 'S', -100));
		piedraTrampa.agregarItem(new Item("daga", 'F', 'S', 0));
>>>>>>> Ramiro

		// agregar places
		joyeria.agregarPlace(altarJoyeria);
		joyeria.agregarPlace(cofreJoyeria);
<<<<<<< HEAD
		capilla.agregarPlace(vitrinaCapilla);
		capilla.agregarPlace(ambonCapilla);
		vestibulo.agregarPlace(altarVestibulo);
		vestibulo.agregarPlace(paredVestibulo);
		corredor.agregarPlace(cupulaCorredor);
		corredor.agregarPlace(alfombraCorredor);
=======
		capilla.agregarPlace(vasarCapilla);
		capilla.agregarPlace(ambonCapilla);
		vestibulo.agregarPlace(sagrarioVestibulo);
		vestibulo.agregarPlace(arconVestibulo);
		corredor.agregarPlace(columnaCorredor);
		corredor.agregarPlace(descansoCorredor);
>>>>>>> Ramiro
		santuario.agregarPlace(mesaSantuario);
		santuario.agregarPlace(estanteSantuario);
		cripta.agregarPlace(vitrinaCripta);
		cripta.agregarPlace(sarcofagoCripta);
<<<<<<< HEAD
		mazmorra.agregarPlace(bancoMazmorra);
=======
		mazmorra.agregarPlace(paredMazmorra);
>>>>>>> Ramiro
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
<<<<<<< HEAD

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
		
		
=======
		Npc momia = new Npc("Momia", 'F', "- ves a una Momia",
				"Yo solia ser el gran Tutmosis I todo el mundo estaba bajo mis pies, pero ahora solo hay polvo debajo de ellos",
				'S');
		momia.addSentenciaYRespuesta("opcionA", "¿Cuanto tiempo queda hasta que se derrumbe esto?",
				"No queda mucho, corre y encuentra la salida lo antes psoble.");
		momia.addSentenciaYRespuesta("opcionB", "¿Como puedo salir?", "Yugi te puede ayudar si tu lo ayudas.");
		momia.addSentenciaYRespuesta("opcionC", "¿Hace cuanto estas aqui?", "Ya perdi nocion del tiempo.");
		cripta.agregarNpc(momia);

		Npc espectro = new Npc("Espectro", 'M', "- ves a un Espectro",
				"¡Estas paredes estan llenas de conocimiento, podrias aprender de ellas.", 'S');
		espectro.addSentenciaYRespuesta("opcionA", "Necesito salir, ¿Entrotrare la saldia en estas paredes?",
				"¡Estas paredes nos cuentan la eterna busqueda de la diosa Isis, ella merodea por las mazmorras esperando a que alguien encuentre y le entrege el Anj!");
		espectro.addSentenciaYRespuesta("opcionB", "¿Como sabes leer jeroglificos?",
				"Estuve aqui cuando los escribieron.");
		espectro.addSentenciaYRespuesta("opcionC", "Das mucho miedo, me asustaste.", "No fue mi intencion asustarte.");
		vestibulo.agregarNpc(espectro);

		Npc ermitanio = new Npc("Ermitanio", 'M', "- ves a un Ermitanio ",
				"La unica salida de aca es usando esa daga que esta incrustada en la pierda JAJAJAJAJAJAJA", 'S');
		ermitanio.addSentenciaYRespuesta("opcionA", "Sos una perdida de tiempo, vos no serias capaz de ayudarme.",
				"Te equivocas hijo, con la daga podras salir, tiene poderes.");
		ermitanio.addSentenciaYRespuesta("opcionB", "¿Por que estas aqui?", "Para guiar a las almas perdidas como tu.");
		ermitanio.addSentenciaYRespuesta("opcionC", "Sos un viejo loco.",
				"Yo soy el unico cuerdo en este mundo de locos.");
		fosa.agregarNpc(ermitanio);

		// NPC utiles
		Debilidad deIsis = new Debilidad(anj,
				"Gracias aventurero por encontrar mi llave, te concedere la salida al exterior como agradecimiento.",
				"dar");
		Debilidad deYugi = new Debilidad(exodia,
				"NO PUEDO CREER QUE LO HAYAS ENCONTRADO!!, como recompensa te sacare con mi collar del milenio", "dar");
		Npc isis = new Npc("Isis", 'F', "- Observas a una deidad poderosa, es Isis",
				"He estado en la busqueda de mi Anj por años", deIsis, 'S');
		isis.addSentenciaYRespuesta("opcionA", "¿Usted puede ayudarme a salir de aqui?",
				"Si me das el Anj, como recompensa podria ayudarte.");
		isis.addSentenciaYRespuesta("opcionB", "¿Cuanto tiempo has buscado el Anj?",
				"Lo he estado buscando por eones.");
		isis.addSentenciaYRespuesta("opcionC", "Wow, eres hermosa.",
				"No estas a la altura de una Diosa como yo, mortal atrevido vas a lograr que te mate.");
		mazmorra.agregarNpc(isis);

		Npc yugi = new Npc("Yugi", 'M', "- Observas a Yugi ",
				"Para poder salir tienes 2 opciones, darme a exodia o usar la espada", deYugi, 'S');
		yugi.addSentenciaYRespuesta("opcionA", "¿Como podria ayudarme una simple espad?", "Usala y veras.");
		yugi.addSentenciaYRespuesta("opcionB", "¿Para que quieres a Exodia?",
				"Para poder derrotar a Bakura el Rey de los Ladrones.");
		santuario.agregarNpc(yugi);

		ubicacion = joyeria;

		// final1: dar carta a Yugi
		FinDeJuego final1 = new FinDeJuego(new Peticion("dar", null, "Exodia", "Yugi", null),
				"Yugi ha logrado salvarte. Ahora eres libre para hacer lo que quieras", "GANASTE");

		// final2: dar llave a Isis
		FinDeJuego final2 = new FinDeJuego(new Peticion("dar", null, "Anj", "Isis", null),
				"En un parpadeo has aparecido sobre las arenas del desierto. La Diosa Isis te ha salvado. ", "GANASTE");

		// final3: usar espada
		FinDeJuego final3 = new FinDeJuego(new Peticion("usar", null, "espada", null, null),
				"Al usar la espada, la cual contenia un espiritu en su interio, fuiste poseido y ataqcaste a Yugi. Pero este se defendio con su carta trampa, haciendo que realices la auto-moricion",
				"PERDISTE");

		// final4: usar daga
		FinDeJuego final4 = new FinDeJuego(new Peticion("usar", null, "daga", null, null),
				"No soportabas mas el olor hediondo que tenia el Ermitanio y decidiste suicidarte.", "PERDISTE");

>>>>>>> Ramiro
		finales.add(final1);
		finales.add(final2);
		finales.add(final3);
		finales.add(final4);
<<<<<<< HEAD
		
=======

>>>>>>> Ramiro
		/*-----------------------------------------------*/
		itemsList.add("Exodia");
		itemsList.add("Udyat");
		itemsList.add("rubi");
		itemsList.add("Sphynx");
		itemsList.add("jeroglificos");
		itemsList.add("cetro");
<<<<<<< HEAD
		itemsList.add("tallado");
=======
		itemsList.add("pergamino");
>>>>>>> Ramiro
		itemsList.add("espada");
		itemsList.add("estatuilla");
		itemsList.add("corona");
		itemsList.add("chacal");
		itemsList.add("serpiente");
		itemsList.add("cadenas");
<<<<<<< HEAD
		itemsList.add("cadaver");
=======
		itemsList.add("calavera");
>>>>>>> Ramiro
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
<<<<<<< HEAD
		placesList.add("cofre");
		placesList.add("altar");
		placesList.add("ambon");
		placesList.add("exhibidor");
		placesList.add("mesa");
		placesList.add("cupula");
		placesList.add("banco");
=======
		placesList.add("altar");
		placesList.add("cofre");
		placesList.add("ambon");
		placesList.add("vasar");
		placesList.add("sagrario");
		placesList.add("muro");
		placesList.add("columna");
		placesList.add("descanso");
		placesList.add("mesa");
>>>>>>> Ramiro
		placesList.add("estante");
		placesList.add("sarcofago");
		placesList.add("vitrina");
		placesList.add("vasija");
<<<<<<< HEAD
		placesList.add("piedra");
		placesList.add("alrededor");
		placesList.add("inventario");

	}
=======
		placesList.add("pared");
		placesList.add("esqueleto");
		placesList.add("piedra");
		placesList.add("alrededor");
		placesList.add("inventario");
	}

	public void generarEntornoPirata() {
		bienvenida = "Te encuentras en un muelle. Es de noche pero la luna ilumina todo el lugar. En el suelo hay algunos objetos, y sientes muchas ganas de ir hacia una taberna.";
		// ubicaciones
		Ubicacion muelle = new Ubicacion("muelle", 'M');
		Ubicacion taberna = new Ubicacion("taberna", 'F');
		// places
		Place suelo = new Place("suelo", 'M', 'S');

		muelle.agregarConexion(new Conexion(taberna, Direcciones.SUR, "Pirata"));

		suelo.agregarItem(new Item("espejo", 'M', 'S', 0));
		Item cerveza = new Item("cerveza", 'F', 'S', 0);
		suelo.agregarItem(cerveza);
		suelo.agregarItem(new Item("barreta", 'F', 'S', 0));

		muelle.agregarPlace(suelo);

		Debilidad debilidadFantasman = new Debilidad(cerveza,
				"¡Me encanta la cerveza de raiz!' El pirata fantasma se veía entusiasmado por tu ofrecimiento... sin embargo, cuando lo rociaste comenzó a desintegrarse. La mitad de arriba de su cuerpo se desvaneció, y las piernas inmediatamente echaron a correr.",
				"dar");
		muelle.agregarNpc(new Npc("Pirata", 'M', "- ves un Pirata fantasma. ",
				"'¡No hay nada que me digas que me haga cambiar de opinión!'", debilidadFantasman, 'S'));

		itemsList.add("espejo");
		itemsList.add("cerveza");
		itemsList.add("barreta");

		placesList.add("suelo");
		placesList.add("alrededor");
		placesList.add("inventario");

		npcsList.add("Pirata");//

		ubicacionesList.add("muelle");
		ubicacionesList.add("taberna");

		// final1: usar espejo
		FinDeJuego final1 = new FinDeJuego(new Peticion("usar", null, "espejo", null, null),
				"¡Oh, no! Acabas de descubrir que tú también eres un pirata fantasma... ¡el horror!", "PERDISTE");
		// final2: ir a taberna
		FinDeJuego final2 = new FinDeJuego(new Peticion("moverse", "taberna", null, null, null),
				"¡Enhorabuena! Llegaste a la taberna, donde te espera una noche de borrachera con Grog y otros colegas piratas.",
				"GANASTE");

		finales.add(final1);
		finales.add(final2);

		ubicacion = muelle;
	}

>>>>>>> Ramiro
}
