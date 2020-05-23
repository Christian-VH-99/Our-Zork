package acciones;

import Ubicacion.Ubicacion;
import main.Juego;

public class Ayuda extends Accion {
	
	Ubicacion ubicacionActual;
	Juego juego;
	
	public Ayuda(Juego juego) {
		this.ubicacionActual = juego.getUbicacion();
		this.juego = juego;
		nombre="ayuda";
	}
	
	public void accionar() {
		String mensaje="estas ubicado en ";
		mensaje += ubicacionActual.getNombreGenero();
		mensaje += ". Puedes interactuar con todos los sitios e items que hay en este lugar\n" + 
				"para poder ver los sitios podes usar MIRAR LUGAR y para ver los items MIRAR 'nombre del sitio' \n" + 
				"tambien podes agarra los items del lugar con AGARRAR 'nombre de item' \n."+
				"recuerda que para pasar por ciertos lugares necesitas items especificos.";
		System.out.println(mensaje);
	}
}
