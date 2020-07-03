package items;

public class Item {

	protected String nombre;
	protected Character genero;
	protected Character numero;
	protected String mensaje;

	public Item(String nombre, Character genero, Character numero) {
		this.nombre = nombre;
		this.genero = genero;
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public String getMensaje() {
		return mensaje;
	}

	public Character getGenero() {
		return genero;
	}

	public char getNumero() {
		return numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String descripcionItem = "";
		if (getNumero() == 'S')
			descripcionItem += getGenero() == 'F' ? "una " : "un ";
		else
			descripcionItem += getGenero() == 'F' ? "unas " : "unos ";
		descripcionItem += getNombre();
		return descripcionItem;
	}

}
