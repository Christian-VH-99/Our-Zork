package acciones;
import java.util.List;
import Ubicacion.Place;
import Ubicacion.Ubicacion;
import jugadores.Jugador;

public class Mirar extends AccionBase {

	public Mirar() {
		nombre = "mirar";
	}

	/* Patron */
	@Override
	public void ejecutar(Peticion peticion, Jugador jugador) {

		if (peticion.getNombreAccion() == this.nombre) {

			Ubicacion ubicacionActual = jugador.getUbicacionActual();

//			if(peticion.getPlace() != null) {
			if(peticion.getNombrePlace() != null) {

//				Place place = peticion.getPlace();
				String nombrePlace = peticion.getNombrePlace();
				List<Place> sitios = ubicacionActual.getPlace();
				
				Place.buscarYMostrarItems(nombrePlace ,sitios);
			
			}else {	
				/*si no le paso place, describe la ubicacion*/
				System.out.println(ubicacionActual.describir());
			}
			
		} else {

			this.accionSiguiente.ejecutar(peticion, jugador);
		}
	}
	
	// esto es por si queremos ver algun items en el futuro
//		public void accionar(Item item){// devuelve una descripcion del item
//			List<Place> sitios = ubicacionActual.getSitios();
//			List<Item> items;
//			int indice=0 ,indiceI=0;
//			boolean encontrado = false;
//			Place sitio;
//			while(indice < sitios.size()  && encontrado == false ) {
//				
//				sitio=sitios.get(indice);
//				items = sitio.getItems(); // agrege getItems en Place
//				
//				while(indiceI < items.size() && encontrado == false) {
//					
//					if(items.contains(item) == true){
//						encontrado = true;
//					}
//					indiceI++;
//				}
//				indice++;
//			}
//			if(encontrado == true )
//				System.out.println(item); 
//			else 
//				System.out.println("el item no esta en esta localizacion"); 
//		}

}
