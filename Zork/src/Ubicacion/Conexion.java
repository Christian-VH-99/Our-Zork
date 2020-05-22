package Ubicacion;

//import java.util.Iterator;

public class Conexion { // TODO: hecho, falta armar tests.
	
	protected Ubicacion ubicacion;
	protected String direccion;
	protected boolean habilitado;
	protected String obstaculo;
	
	public Conexion(Ubicacion ubicacion, String direccion) {
		this.ubicacion = ubicacion;
		this.direccion = direccion;
		this.habilitado = true;
	}
	
	public Conexion(Ubicacion ubicacion, String direccion, String obstaculo) {
		this.ubicacion = ubicacion;
		this.direccion = direccion;
		this.obstaculo = obstaculo;
		this.habilitado = false;
	}

	public Ubicacion getLocation() {
		return ubicacion;
	}
	
	public void habilitar() {
		habilitado = true;
	}	
	public void deshabilitar() {
		habilitado = false;
	}
	public String getObstaculo() {
		return obstaculo;
	}
	public String getDireccion() {
		return direccion;
	}
	
	public boolean getHabilitado(){
		return habilitado;
	}
	
	public String descripcion() {
		String descripcion = "Al ";
		descripcion += getDireccion() + ubicacion.getNombre();
		return descripcion;
	}
	
	public boolean tieneObstaculo(String personaje) {

		if(this.obstaculo != null) {
			if(obstaculo.equals(personaje)) {
				return true;
			}
		}
		return false;
	}
	
}

