package modelo;

import java.time.LocalDate;

public class MovimientoInventario {
	private int idMovimientoInventario;
	private Producto producto;
	private LocalDate fecha;
	private int cantidad;

	public MovimientoInventario(int idMovimientoInventario, Producto producto, LocalDate fecha, int cantidad) {
		this.idMovimientoInventario = idMovimientoInventario;
		this.producto = producto;
		this.fecha = fecha;
		this.cantidad = cantidad;
	}

	public int getIdMovimientoInventario() {
		return idMovimientoInventario;
	}

	public Producto getProducto() {
		return producto;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public int getCantidad() {
		return cantidad;
	}

	@Override
	public String toString() {
		return "MovimientoInventario{" + "idMovimientoInventario=" + idMovimientoInventario + ", producto=" + producto
				+ ", fecha=" + fecha + ", cantidad=" + cantidad + '}';
	}
	@Override
	public boolean equals(Object o) {
	    return this == o || (o != null && getClass() == o.getClass() && idMovimientoInventario == ((MovimientoInventario) o).idMovimientoInventario);
	}

}
