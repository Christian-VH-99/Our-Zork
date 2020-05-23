package acciones;

import Ubicacion.Ubicacion;
import main.Juego;

public class Moverse extends Accion{

	
	Ubicacion ubicacionActual;
	Juego juego;
	
	public Moverse(Juego juego) {
		
		this.ubicacionActual = juego.getUbicacion();
		this.juego = juego;
		nombre = "moverse";
	}
	

	/* NOTA: usamos clases para cada accion para luego poder aplicar algun patron de diseño. 
			 Habria que unificar la interfaz de todas las acciones con un objeto propertires*/
	public void accionar(Ubicacion nuevaLocation) {
	
		Ubicacion ubicacion = juego.getUbicacion();
		int permitido = ubicacion.sePuedeMoverAConexion(nuevaLocation);
		if(permitido == 1) {	
			juego.setLocation(nuevaLocation);
			System.out.println(juego.getUbicacion().describir());
		}else if(permitido == -1) {
			System.out.println("no podes moverte ahi");
		}
	}

}
