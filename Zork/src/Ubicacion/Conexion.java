package Ubicacion;

public class Conexion {

	protected Ubicacion ubicacion;
	protected Direcciones direccion;
	protected boolean habilitado;
	protected String obstaculo;

	public Conexion(Ubicacion ubicacion, Direcciones direccion) {
		this.ubicacion = ubicacion;
		this.direccion = direccion;
		this.habilitado = true;
	}

	public Conexion(Ubicacion ubicacion, Direcciones direccion, String obstaculo) {
		this.ubicacion = ubicacion;
		this.direccion = direccion;
		this.obstaculo = obstaculo;
		this.habilitado = false;
	}

//// GETTERS ////
	public Ubicacion getLocation() {
		return ubicacion;
	}

	public String getObstaculo() {
		return obstaculo;
	}

	public Direcciones getDireccion() {
		return direccion;
	}

	public boolean getHabilitado() {
		return habilitado;
	}

	public void habilitar() {
		habilitado = true;
	}

	public void deshabilitar() {
		habilitado = false;
	}

	public String descripcion() {
		String descripcion = "Al ";
		descripcion += getDireccion() + ubicacion.getNombre();
		return descripcion;
	}

	public boolean tieneObstaculo(String personaje) {
		return this.obstaculo != null && obstaculo.equals(personaje);
	}

}
