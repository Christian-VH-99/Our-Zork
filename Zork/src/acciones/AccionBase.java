package acciones;

public abstract class AccionBase implements AccionInterface {

	protected String nombre; 
	protected AccionInterface AccionSiguiente;
	
	// TODO: poner en super clase
	public AccionInterface getAccionSiguiente() {
		return AccionSiguiente;
	}

	@Override
	public void setSiguiente(AccionInterface siguiente) {
		this.AccionSiguiente = siguiente;
	}
	
}
