package acciones;

import Ubicacion.Ubicacion;
import main.Juego;

public class Informacion extends Accion {
	
	Ubicacion ubicacionActual;
	Juego juego;
	
	public Informacion (Juego juego) {
		this.ubicacionActual = juego.getUbicacion();
		this.juego = juego;
		nombre="Informacion";
		}
	public void accionar() {
		String mensaje="Bienvenido ";
		mensaje += juego.getNombreJugador();
		mensaje += " a este mundo de fantasia. \n"
				+ "El objetivo de este juego es ........\n"
				+"_______________________________________________________________________________________________________________\n" + 
				"Lista de Comandos\r\n" + 
				"para poder moverte puede señalizar el lugar por su nombre con el vervo ir adelante IR 'nombre del lugar' \n" + 
				"tambien puedes usar 'MOVERME A *lugar al que quieras ir*' dependiendo a donde quieras moverte.\n" + 
				"en algunos sitios no vas a poder pasar porque necesitar items especificos para que se pueda habilidar ese sitio\n" + 
				"para agarrar en estos items podes usar AGARRAR 'nombre del item', .\n" + 
				"para poder ver tu entorno poder utilizar MIRAR, para  ver los sitios  \n" + 
				"MIRAR 'nombre del sitio'.";
		System.out.println(mensaje);
	}
}
