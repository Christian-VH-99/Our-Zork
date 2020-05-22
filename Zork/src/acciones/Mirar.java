package acciones;

import java.util.List;

import Ubicacion.Place;
import Ubicacion.Ubicacion;
import main.Juego;



public class Mirar extends Accion { 

	Ubicacion ubicacionActual;
	Juego juego;
	
	public Mirar(Juego juego) {
		this.ubicacionActual = juego.getUbicacion();
		this.juego = juego;
		nombre="mirar";
	}
	
	public void accionar(){
		System.out.println(ubicacionActual.describir());
	}

	public void accionar(Place place){ // devuelve la lista de imtems en este lugar
		List<Place> sitios = ubicacionActual.getSitios(); // agregue getSitios en ubicacion
		if(sitios.contains(place) == true) 
			System.out.println(place.listarItems());
		else
			System.out.print("sitio no existente para mirar");
	}
// esto es por si queremos ver algun items en el futuro
//	public void accionar(Item item){// devuelve una descripcion del item
//		List<Place> sitios = ubicacionActual.getSitios();
//		List<Item> items;
//		int indice=0 ,indiceI=0;
//		boolean encontrado = false;
//		Place sitio;
//		while(indice < sitios.size()  && encontrado == false ) {
//			
//			sitio=sitios.get(indice);
//			items = sitio.getItems(); // agrege getItems en Place
//			
//			while(indiceI < items.size() && encontrado == false) {
//				
//				if(items.contains(item) == true){
//					encontrado = true;
//				}
//				indiceI++;
//			}
//			indice++;
//		}
//		if(encontrado == true )
//			System.out.println(item); 
//		else 
//			System.out.println("el item no esta en esta localizacion"); 
//	}
}
