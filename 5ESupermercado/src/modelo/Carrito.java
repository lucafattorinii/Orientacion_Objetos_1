package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private int idCarrito;
	private LocalDate fecha;
	private LocalTime hora;
	private List<ItemCarrito> lstItem; 
	private Cliente cliente;

	public Carrito(int idCarrito, LocalDate fecha, LocalTime hora, Cliente cliente) {
		this.idCarrito = idCarrito;
		this.fecha = fecha;
		this.hora = hora;
		this.cliente = cliente;
		this.lstItem = new ArrayList<>(); // Inicialización de la lista
	}

	public int getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public List<ItemCarrito> getLstItem() {
		return lstItem;
	}

	public void setLstItem(List<ItemCarrito> lstItem) {
		this.lstItem = lstItem;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

// Caso de uso 4: Agregar un item al carrito
	public boolean agregarItem(Producto producto, int cantidad) {
		ItemCarrito item = new ItemCarrito(lstItem.size() + 1, producto, cantidad);
		lstItem.add(item);
		return true; // Item agregado con éxito
	}

// Caso de uso 5: Eliminar un item del carrito
	public boolean eliminarItem(Producto producto, int cantidad) {
		boolean itemEliminado = false;
		for (int i = 0; i < lstItem.size() && !itemEliminado; i++) {
			ItemCarrito item = lstItem.get(i);
			if (item.getProducto().equals(producto)) {
				if (item.getCantidad() >= cantidad) {
					item.setCantidad(item.getCantidad() - cantidad);
					if (item.getCantidad() == 0) {
						lstItem.remove(i);
					}
					itemEliminado = true;
				}
			}
		}
		return itemEliminado; // Retorna true si se eliminó el item, false si no se encontró el item para elimiar
								
	}

	// Caso de uso 6: Calcular subtotal del carrito
	public float calcularSubTotal() {
		float subTotal = 0.0f;
		for (ItemCarrito item : lstItem) {
			subTotal += item.getCantidad() * item.getProducto().getPrecio();
		}
		return subTotal; // Retorna el subtotal calculado
	}

	// Caso de uso 7: Calcular total del carrito (puede incluir impuestos u otros
	// cargos)
	public float calcularTotal() {
		float total = calcularSubTotal();
		float impuesto = total * 0.21f; // Ejemplo de impuesto del 21%
		return total + impuesto; // Retorna el total incluyendo impuestos
	}

	@Override
	public String toString() {
		return "Carrito [ID=" + idCarrito + ", Fecha=" + fecha + ", Hora=" + hora + ", Cliente=" + cliente.toString()
				+ "]";
	}
}
