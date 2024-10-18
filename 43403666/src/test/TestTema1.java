package test;

import java.time.LocalDate;
import java.util.List;

import modelo.*;

public class TestTema1 {
	public static void main(String[] args) {
		Sistema sistema = new Sistema();

		// Caso de uso 1: Agregar Categorías
		System.out.println("\n==============================\n");
		System.out.println("1) Agregar Categorías:");
		try {
			sistema.agregarCategoria("Bebidas");
			sistema.agregarCategoria("Almacen");
			sistema.agregarCategoria("Decoracion");
			for (Categoria categoria : sistema.getLstCategoria()) {
				System.out.println(categoria);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Categoria bebidas = sistema.traerCategoria("Bebidas");
		Categoria almacen = sistema.traerCategoria("Almacen");
		Categoria decoracion = sistema.traerCategoria("Decoracion");

		// Caso de uso 2: Agregar Productos
		System.out.println("\n==============================\n");
		System.out.println("2) Agregar Productos:");
		try {

			sistema.agregarProductoPerecedero(1001, "Yogurt", 900.0f, bebidas, LocalDate.of(2024, 10, 20), true);
			sistema.agregarProductoPerecedero(1002, "Agua", 1000.0f, bebidas, LocalDate.of(2024, 11, 20), true);
			sistema.agregarProductoPerecedero(2001, "Arroz", 1000.0f, almacen, LocalDate.of(2025, 1, 1), true);
			sistema.agregarProductoPerecedero(3001, "Pegamento", 8000.0f, decoracion, LocalDate.of(2024, 10, 18), true);
			sistema.agregarProductoNoPerecedero(3002, "Lija", 250.0f, decoracion, 6, 10);
			sistema.agregarProductoNoPerecedero(3003, "Martillo", 600.0f, decoracion, 12, 5);

			for (Producto producto : sistema.getLstProductos()) {
				System.out.println(producto);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Caso de uso 3: Agregar Movimientos de Inventario
		System.out.println("\n==============================\n");
		System.out.println("3) Agregar Movimientos de Inventario:");
		try {
			Producto yogurt = sistema.traerProducto(1001);
			Producto agua = sistema.traerProducto(1002);
			Producto arroz = sistema.traerProducto(2001);
			Producto pegamento = sistema.traerProducto(3001);
			Producto lija = sistema.traerProducto(3002);
			Producto martillo = sistema.traerProducto(3003);

			sistema.agregarMovimientoInventario(yogurt, LocalDate.of(2024, 10, 10), 50);
			sistema.agregarMovimientoInventario(agua, LocalDate.of(2024, 10, 10), 30);
			sistema.agregarMovimientoInventario(arroz, LocalDate.of(2024, 10, 10), 80);
			sistema.agregarMovimientoInventario(pegamento, LocalDate.of(2024, 10, 10), 40);
			sistema.agregarMovimientoInventario(lija, LocalDate.of(2024, 10, 10), 11);
			sistema.agregarMovimientoInventario(martillo, LocalDate.of(2024, 10, 10), 40);

			// Agregar ventas
			sistema.agregarMovimientoInventario(yogurt, LocalDate.of(2024, 10, 13), -10);
			sistema.agregarMovimientoInventario(agua, LocalDate.of(2024, 10, 13), -4);
			sistema.agregarMovimientoInventario(lija, LocalDate.of(2024, 10, 13), -3);

			for (MovimientoInventario movimiento : sistema.getLstMovimientoInventario()) {
				System.out.println(movimiento);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Caso de uso 4: Traer ventas de productos refrigerados

		System.out.println("\n==============================\n");
		System.out.println("4) Traer ventas de productos refrigerados del día 2024-10-13:");
		try {
			List<MovimientoInventario> ventasRefrigeradas = sistema
					.traerVentasDeProductosRefrigerados(LocalDate.of(2024, 10, 13));
			for (MovimientoInventario venta : ventasRefrigeradas) {
				System.out.println(venta);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Caso de uso 5: Traer productos a reabastecer para la categoría "Decoracion"
		System.out.println("\n==============================\n");
		System.out.println("5) Traer productos a reabastecer para la categoría 'Decoracion':");
		try {

			List<Producto> productosAReabastecer = sistema.traerProductosAReabastecer(decoracion);
			for (Producto producto : productosAReabastecer) {
				System.out.println(producto);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Caso de uso 6: Intentar agregar un producto existente
		System.out.println("\n==============================\n");
		System.out.println("6) Intentar agregar un producto existente:");
		try {
			sistema.agregarProductoPerecedero(1001, "Yogurt", 900.0f, bebidas, LocalDate.of(2024, 10, 20), true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Caso de uso 7: Intentar agregar un movimiento de inventario con cantidad
		// insuficiente
		System.out.println("\n==============================\n");
		System.out.println("7) Intentar agregar un movimiento de inventario con cantidad insuficiente:");
		try {
			Producto martillo = sistema.traerProducto(3003);
			sistema.agregarMovimientoInventario(martillo, LocalDate.of(2024, 10, 13), -50);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
