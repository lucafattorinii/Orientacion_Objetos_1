package modelo;

import java.util.Objects;

public class Categoria {

	private String nombre;

	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Categoria [nombre=" + nombre + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		return this == obj
				|| (obj != null && getClass() == obj.getClass() && Objects.equals(nombre, ((Categoria) obj).nombre));
	}

}