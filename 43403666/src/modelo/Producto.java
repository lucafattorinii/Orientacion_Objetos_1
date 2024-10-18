package modelo;

public abstract class Producto {
	protected int idProducto;
	protected int codigo;
	protected String nombre;
	protected float precio;
	protected Categoria categoria;
	protected int cantidadDisponible;

	public Producto(int idProducto, int codigo, String nombre, float precio, Categoria categoria,
			int cantidadDisponible) {
		this.idProducto = idProducto;
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
		this.cantidadDisponible = cantidadDisponible;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public int getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	// Caso de uso 6: esNecesarioReabastecer (método abstracto)
	public abstract boolean esNecesarioReabastecer();

	@Override
	public String toString() {
		return "Producto{" + "idProducto=" + idProducto + ", codigo=" + codigo + ", nombre='" + nombre + '\''
				+ ", precio=" + precio + ", categoria=" + categoria + ", cantidadDisponible=" + cantidadDisponible
				+ '}';
	}

	@Override
	public boolean equals(Object o) {
	    return this == o || (o != null && getClass() == o.getClass() && idProducto == ((Producto) o).idProducto);
	}

}
