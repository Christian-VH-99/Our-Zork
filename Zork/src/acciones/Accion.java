package acciones;

public abstract class Accion {

	protected String nombre; 
	
	//public abstract void accionar();
	
	/*id, me sirve para cuando quiera identificar la accion a ejecutar (en clase interprete)
	 * 
	 * for(Accion accion : acciones) // uso polimorfismo
	 * 		if(IDverbo == accion.getNombre())
	 * 				accion.accionar();
	 * */
}
