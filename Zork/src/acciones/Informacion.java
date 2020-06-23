package acciones;

import jugadores.Jugador;

public class Informacion extends AccionBase {

	public Informacion() {
		nombre = "informacion";
	}

	@Override
	public void ejecutar(Peticion peticion, Jugador jugador) {

		if (peticion.getNombreAccion() == this.nombre) {

			String mensaje = "Bienvenido ";
			mensaje += jugador.getNombre();
			mensaje += " a este mundo de fantasia. \n" + "El objetivo de este juego es ........\n"
					+ "_______________________________________________________________________________________________________________\n"
					+ "Lista de Comandos\r\n"
					+ "para poder moverte puede señalizar el lugar por su nombre con el vervo ir adelante IR 'nombre del lugar' \n"
					+ "tambien puedes usar 'MOVERME A *lugar al que quieras ir*' dependiendo a donde quieras moverte.\n"
					+ "en algunos sitios no vas a poder pasar porque necesitar items especificos para que se pueda habilidar ese sitio\n"
					+ "para agarrar en estos items podes usar AGARRAR 'nombre del item', .\n"
					+ "para poder ver tu entorno poder utilizar MIRAR, para  ver los sitios  \n"
					+ "MIRAR 'nombre del sitio'.";
			System.out.println(mensaje);

		} else {
			this.accionSiguiente.ejecutar(peticion, jugador);
		}
	}
}
