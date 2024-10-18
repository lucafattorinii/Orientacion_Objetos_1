package modelo;

import java.time.LocalDate;

public class ProductoPerecedor extends Producto {
	private LocalDate fechaVencimiento;
	private boolean requiereRefrigeracion;

	public ProductoPerecedor(int idProducto, int codigo, String nombre, float precio, Categoria categoria,
			int cantidadDisponible, LocalDate fechaVencimiento, boolean requiereRefrigeracion) {
		super(idProducto, codigo, nombre, precio, categoria, cantidadDisponible);
		this.fechaVencimiento = fechaVencimiento;
		this.requiereRefrigeracion = requiereRefrigeracion;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public boolean isRequiereRefrigeracion() {
		return requiereRefrigeracion;
	}

	public void setRequiereRefrigeracion(boolean requiereRefrigeracion) {
		this.requiereRefrigeracion = requiereRefrigeracion;
	}

	@Override
	public boolean esNecesarioReabastecer() {
		return fechaVencimiento.isBefore(LocalDate.now().plusDays(20));
	}

	@Override
	public String toString() {
		return "ProductoPerecedero{" + "fechaVencimiento=" + fechaVencimiento + ", requiereRefrigeracion="
				+ requiereRefrigeracion + "} " + super.toString();
	}

	@Override
	public boolean equals(Object o) {
	    return this == o || (o != null && getClass() == o.getClass() && super.equals(o) && requiereRefrigeracion == ((ProductoPerecedor) o).requiereRefrigeracion);
	}

}
