package modelo;

import java.util.List;

import java.time.LocalDate;
import java.util.ArrayList;

public class Sistema {
	private List<Producto> lstProductos;
	private List<Categoria> lstCategoria;
	private List<MovimientoInventario> lstMovimientoInventario;

	public Sistema() {
		this.lstProductos = new ArrayList<Producto>();
		this.lstCategoria = new ArrayList<Categoria>();
		this.lstMovimientoInventario = new ArrayList<MovimientoInventario>();
	}

	public List<Producto> getLstProductos() {
		return lstProductos;
	}

	public void setLstProductos(List<Producto> lstProductos) {
		this.lstProductos = lstProductos;
	}

	public List<Categoria> getLstCategoria() {
		return lstCategoria;
	}

	public void setLstCategoria(List<Categoria> lstCategoria) {
		this.lstCategoria = lstCategoria;
	}

	public List<MovimientoInventario> getLstMovimientoInventario() {
		return lstMovimientoInventario;
	}

	public void setLstMovimientoInventario(List<MovimientoInventario> lstMovimientoInventario) {
		this.lstMovimientoInventario = lstMovimientoInventario;
	}

	// Caso de uso 1: traerCategoria
	public Categoria traerCategoria(String nombre) {
		Categoria categoria = null;
		int i = 0;

		while (i < lstCategoria.size() && categoria == null) {
			if (lstCategoria.get(i).getNombre().equals(nombre)) {
				categoria = lstCategoria.get(i);
			}
			i++;
		}

		return categoria;
	}

	// Caso de uso 2: agregarCategoria
	public boolean agregarCategoria(String nombre) throws Exception {
		if (traerCategoria(nombre) != null) {
			throw new Exception("La categoría " + nombre + " ya existe.");
		}

		lstCategoria.add(new Categoria(nombre));
		return true;
	}

	// Caso de uso 3: traerProducto
	public Producto traerProducto(int codigo) {
		Producto producto = null;
		int i = 0;

		while (i < lstProductos.size() && producto == null) {
			if (lstProductos.get(i).getCodigo() == codigo) {
				producto = lstProductos.get(i);
			}
			i++;
		}

		return producto;
	}

	// Caso de uso 4: agregarProductoNoPerecedero
	public boolean agregarProductoNoPerecedero(int codigo, String nombre, float precio, Categoria categoria,
			int mesesGarantia, int cantidadMinima) throws Exception {
		if (traerProducto(codigo) != null) {
			throw new Exception("El producto con el código " + codigo + " ya existe.");
		}

		int id = 1;
		if (!lstProductos.isEmpty()) {
			id = lstProductos.get(lstProductos.size() - 1).getIdProducto() + 1;
		}

		ProductoNoPerecedor producto = new ProductoNoPerecedor(id, codigo, nombre, precio, categoria, 0, mesesGarantia,
				cantidadMinima);
		lstProductos.add(producto);

		return true;
	}

	// Caso de uso 5: agregarProductoPerecedero
	public boolean agregarProductoPerecedero(int codigo, String nombre, float precio, Categoria categoria,
			LocalDate fechaVencimiento, boolean requiereRefrigeracion) throws Exception {
		if (traerProducto(codigo) != null) {
			throw new Exception("El producto con el código " + codigo + " ya existe.");
		}

		int id = 1;
		if (!lstProductos.isEmpty()) {
			id = lstProductos.get(lstProductos.size() - 1).getIdProducto() + 1;
		}

		ProductoPerecedor producto = new ProductoPerecedor(id, codigo, nombre, precio, categoria, 0, fechaVencimiento,
				requiereRefrigeracion);
		lstProductos.add(producto);

		return true;
	}
	
	// Caso de uso 7: agregarMovimientoInventario
	public boolean agregarMovimientoInventario(Producto producto, LocalDate fecha, int cantidad) throws Exception {
	    if (producto.getCantidadDisponible() >= cantidad) {
	        throw new Exception("Cantidad insuficiente en inventario.");
	    }

	    for (MovimientoInventario movimiento : lstMovimientoInventario) {
	        if (movimiento.getProducto().equals(producto) && movimiento.getFecha().equals(fecha) && movimiento.getCantidad() == cantidad) {
	            throw new Exception("El movimiento de inventario ya existe.");
	        }
	    }

	    int id = 1;
	    if (!lstMovimientoInventario.isEmpty()) {
	        id = lstMovimientoInventario.get(lstMovimientoInventario.size() - 1).getIdMovimientoInventario() + 1;
	    }

	    MovimientoInventario movimiento = new MovimientoInventario(id, producto, fecha, cantidad);
	    lstMovimientoInventario.add(movimiento);
	    producto.setCantidadDisponible(producto.getCantidadDisponible() - cantidad);

	    return true;
	}



	// Caso de uso 8: traerVentas
	public List<MovimientoInventario> traerVentas(LocalDate fechaDesde, LocalDate fechaHasta) {
		List<MovimientoInventario> ventas = new ArrayList<>();

		for (MovimientoInventario movimiento : lstMovimientoInventario) {
			if (movimiento.getFecha().isAfter(fechaDesde.minusDays(1))
					&& movimiento.getFecha().isBefore(fechaHasta.plusDays(1)) && movimiento.getCantidad() < 0) {
				ventas.add(movimiento);
			}
		}

		return ventas;
	}

	// Caso de uso 9: traerVentasDeProductosRefrigerados
	public List<MovimientoInventario> traerVentasDeProductosRefrigerados(LocalDate fecha) {
	    List<MovimientoInventario> ventasRefrigeradas = new ArrayList<>();

	    for (MovimientoInventario movimiento : lstMovimientoInventario) {
	        if (movimiento.getFecha().equals(fecha) 
	            && movimiento.getProducto() instanceof ProductoPerecedor 
	            && ((ProductoPerecedor) movimiento.getProducto()).isRequiereRefrigeracion() 
	            && movimiento.getCantidad() < 0) {
	            ventasRefrigeradas.add(movimiento);
	        }
	    }

	    return ventasRefrigeradas;
	}


	// Caso de uso 10: traerProductosAReabastecer
	public List<Producto> traerProductosAReabastecer(Categoria categoria) {
		List<Producto> productosAReabastecer = new ArrayList<>();

		for (Producto producto : lstProductos) {
			if (producto.getCategoria().equals(categoria) && producto.esNecesarioReabastecer()) {
				productosAReabastecer.add(producto);
			}
		}

		return productosAReabastecer;
	}
}