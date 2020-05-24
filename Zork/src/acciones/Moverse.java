package acciones;
import Ubicacion.Ubicacion;
import jugadores.Jugador;

public class Moverse extends Accion{

	
	Ubicacion ubicacionActual;
	Jugador jugador;
	
	public Moverse(Jugador jugador) {
		
		this.ubicacionActual = jugador.getUbicacionActual();
		this.jugador = jugador;
		nombre = "moverse";
	}
	

	/* NOTA: usamos clases para cada accion para luego poder aplicar algun patron de diseño. 
			 Habria que unificar la interfaz de todas las acciones con un objeto propertires*/
	public void accionar(Ubicacion nuevaLocation) {
	
		int permitido = ubicacionActual.sePuedeMoverAConexion(nuevaLocation);
		if(permitido == 1) {	
			jugador.setUbicacionActual(nuevaLocation);
		}else if(permitido == -1) {
			System.out.println("no podes moverte ahi");
		}
	}

}
