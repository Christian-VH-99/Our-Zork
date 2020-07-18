package acciones;

import javax.swing.JLabel;

import jugadores.Jugador;

public class Informacion extends AccionBase {

	public Informacion() {
		nombre = "informacion";
	}

	@Override
	public String ejecutar(Peticion peticion, Jugador jugador, JLabel imagen) {

		if (peticion.getNombreAccion() == this.nombre) {

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
			return salida;
		} else {
			salida = this.accionSiguiente.ejecutar(peticion, jugador,imagen);
			return salida;
		}
	}
}
