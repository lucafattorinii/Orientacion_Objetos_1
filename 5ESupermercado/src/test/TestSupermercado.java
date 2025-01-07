package test;

import modelo.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class TestSupermercado {
	public static void main(String[] args) {
		Supermercado supermercado = new Supermercado();
		
		
		
		System.out.println("\n======================\n");
		// 1) agregarProducto
		System.out.println("1) agregarProducto");
		boolean productoAgregado;
		try {
			productoAgregado = supermercado.getAdmProducto().agregarProducto("Manzana", 10.5f);
			System.out.println("Producto agregado: " + productoAgregado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n======================\n");

		// 2) traerProducto
		System.out.println("2) traerProducto");
		Producto producto = supermercado.getAdmProducto().traerProducto(1);
		System.out.println("Producto traído: " + producto);

		
		System.out.println("\n======================\n");
		
		// 3) eliminarProducto
		System.out.println("3) eliminarProducto");
		boolean productoEliminado;
		try {
			productoEliminado = supermercado.getAdmProducto().eliminarProducto(1);
			System.out.println("Producto eliminado: " + productoEliminado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n======================\n");

		// 4) agregarItem
		System.out.println("4) agregarItem");
		Carrito carrito = new Carrito(1, LocalDate.now(), LocalTime.now(),
				new Cliente(1, "Juan Perez", 12345678L, "Calle Falsa 123"));
		Producto producto2 = new Producto(2, "Banana", 15.0f);
		try {
			supermercado.getAdmProducto().agregarProducto("Banana", 15.0f);

			boolean itemAgregado = carrito.agregarItem(producto2, 5);
			System.out.println("Item agregado: " + itemAgregado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n======================\n");

		// 5) eliminarItem
		System.out.println("5) eliminarItem");
		boolean itemEliminado = carrito.eliminarItem(producto2, 5);
		System.out.println("Item eliminado: " + itemEliminado);

		System.out.println("\n======================\n");
		
		// 6) calcularSubTotal
		System.out.println("6) calcularSubTotal");
		carrito.agregarItem(producto2, 5);
		float subTotal = carrito.calcularSubTotal();
		System.out.println("Subtotal: " + subTotal);

		
		System.out.println("\n======================\n");
		
		// 7) calcularTotal
		System.out.println("7) calcularTotal");
		float total = carrito.calcularTotal();
		System.out.println("Total: " + total);

		System.out.println("\n======================\n");
		
		// 8) agregarCliente
		System.out.println("8) agregarCliente");
		try {
			boolean clienteAgregado = supermercado.getAdmCliente().agregarCliente("Juan Perez", 12345678L,
					"Calle Falsa 123");
			System.out.println("Cliente agregado: " + clienteAgregado);
		} catch (Exception e) {
			System.out.println("Error al agregar cliente: " + e.getMessage());
		}
		
		System.out.println("\n======================\n");

		// 9) traerCliente
		System.out.println("9) traerCliente");
		Cliente cliente = supermercado.getAdmCliente().traerCliente(1);
		System.out.println("Cliente traído: " + cliente);

		System.out.println("\n======================\n");
		
		// 10) eliminarCliente
		System.out.println("10) eliminarCliente");
		try {
			boolean clienteEliminado = supermercado.getAdmCliente().eliminarCliente(1);
			System.out.println("Cliente eliminado: " + clienteEliminado);
		} catch (Exception e) {
			System.out.println("Error al eliminar cliente: " + e.getMessage());
		}
		
		System.out.println("\n======================\n");

		// 11) agregarCarrito
		System.out.println("11) agregarCarrito");
		try {
			boolean carritoAgregado = supermercado.getAdmCarrito().agregarCarrito(LocalDate.now(), LocalTime.now(),
					cliente);
			System.out.println("Carrito agregado: " + carritoAgregado);
		} catch (Exception e) {
			System.out.println("Error al agregar carrito: " + e.getMessage());
		}
		
		System.out.println("\n======================\n");

		// 12) traerCarrito
		System.out.println("12) traerCarrito");
		Carrito carritoTraido = supermercado.getAdmCarrito().traerCarrito(1);
		System.out.println("Carrito traído: " + carritoTraido);

		System.out.println("\n======================\n");
		
		// 13) eliminarCarrito
		System.out.println("13) eliminarCarrito");
		try {
			boolean carritoEliminado = supermercado.getAdmCarrito().eliminarCarrito(1);
			System.out.println("Carrito eliminado: " + carritoEliminado);
		} catch (Exception e) {
			System.out.println("Error al eliminar carrito: " + e.getMessage());
		}
		
		System.out.println("\n======================\n");

		// 14) calcularTotal
		System.out.println("14) calcularTotal");
		try {
			Carrito carrito1 = supermercado.getAdmCarrito().traerCarrito(1);
			if (carrito1 != null) {
				float totalCliente = carrito1.calcularTotal();
				System.out.println("Total del cliente: " + totalCliente);
			} else {
				System.out.println("Carrito no encontrado.");
			}
		} catch (Exception e) {
			System.out.println("Error al calcular total del cliente: " + e.getMessage());
		}
		
		System.out.println("\n======================\n");

		// 15) calcularTotal(int dniCliente)
		System.out.println("15) calcularTotal(int dniCliente)");
		try {
			float totalDniCliente = 0;
			for (Carrito carrito1 : supermercado.getAdmCarrito().getLstCarrito()) {
				if (carrito1.getCliente().getDni() == 12345678L) {
					totalDniCliente += carrito1.calcularTotal();
				}
			}
			System.out.println("Total del cliente por DNI: " + totalDniCliente);
		} catch (Exception e) {
			System.out.println("Error al calcular total del cliente por DNI: " + e.getMessage());
		}
		
		System.out.println("\n======================\n");

		// 16) calcularTotal(LocalDate fechaInicio, LocalDate fechaFin)
		System.out.println("16) calcularTotal(LocalDate fechaInicio, LocalDate fechaFin)");
		try {
			float totalFecha = 0;
			for (Carrito carrito1 : supermercado.getAdmCarrito().getLstCarrito()) {
				if (!carrito1.getFecha().isBefore(LocalDate.now().minusDays(1))
						&& !carrito1.getFecha().isAfter(LocalDate.now())) {
					totalFecha += carrito1.calcularTotal();
				}
			}
			System.out.println("Total entre fechas: " + totalFecha);
		} catch (Exception e) {
			System.out.println("Error al calcular total entre fechas: " + e.getMessage());
		}
		
		System.out.println("\n======================\n");

		// 17) calcularTotal(LocalDate fecha)
		System.out.println("17) calcularTotal(LocalDate fecha)");
		try {
			float totalFechaUnica = 0;
			for (Carrito carrito1 : supermercado.getAdmCarrito().getLstCarrito()) {
				if (carrito1.getFecha().equals(LocalDate.now())) {
					totalFechaUnica += carrito1.calcularTotal();
				}
			}
			System.out.println("Total en fecha: " + totalFechaUnica);
		} catch (Exception e) {
			System.out.println("Error al calcular total en fecha: " + e.getMessage());
		}
		
		System.out.println("\n======================\n");

		// 18) calcularTotal(int mes, int anio)
		System.out.println("18) calcularTotal(int mes, int anio)");
		try {
			float totalMesAnio = 0;
			for (Carrito carrito1 : supermercado.getAdmCarrito().getLstCarrito()) {
				if (carrito1.getFecha().getMonthValue() == 10 && carrito1.getFecha().getYear() == 2024) {
					totalMesAnio += carrito1.calcularTotal();
				}
			}
			System.out.println("Total del mes y año: " + totalMesAnio);
		} catch (Exception e) {
			System.out.println("Error al calcular total del mes y año: " + e.getMessage());
		}
		
		System.out.println("\n======================\n");

		// 19) calcularTotal(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente)
		System.out.println("19) calcularTotal(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente)");
		try {
			float totalFechaCliente = 0;
			for (Carrito carrito1 : supermercado.getAdmCarrito().getLstCarrito()) {
				if (carrito1.getCliente().equals(cliente) && !carrito1.getFecha().isBefore(LocalDate.now().minusDays(1))
						&& !carrito1.getFecha().isAfter(LocalDate.now())) {
					totalFechaCliente += carrito1.calcularTotal();
				}
			}
			System.out.println("Total entre fechas para cliente: " + totalFechaCliente);
		} catch (Exception e) {
			System.out.println("Error al calcular total entre fechas para cliente: " + e.getMessage());
		}
		
		System.out.println("\n======================\n");

		// 20) calcularTotal(LocalDate fecha, Cliente cliente)
		System.out.println("20) calcularTotal(LocalDate fecha, Cliente cliente)");
		try {
			float totalFechaClienteUnica = 0;
			for (Carrito carrito1 : supermercado.getAdmCarrito().getLstCarrito()) {
				if (carrito1.getCliente().equals(cliente) && carrito1.getFecha().equals(LocalDate.now())) {
					totalFechaClienteUnica += carrito1.calcularTotal();
				}
			}
			System.out.println("Total en fecha para cliente: " + totalFechaClienteUnica);
		} catch (Exception e) {
			System.out.println("Error al calcular total en fecha para cliente: " + e.getMessage());
		}
		
		System.out.println("\n======================\n");

		// 21) calcularTotal(int mes, int anio, Cliente cliente)
		System.out.println("21) calcularTotal(int mes, int anio, Cliente cliente)");
		try {
			float totalMesAnioCliente = 0;
			for (Carrito carrito1 : supermercado.getAdmCarrito().getLstCarrito()) {
				if (carrito1.getCliente().equals(cliente) && carrito1.getFecha().getMonthValue() == 10
						&& carrito1.getFecha().getYear() == 2024) {
					totalMesAnioCliente += carrito1.calcularTotal();
				}
			}
			System.out.println("Total del mes y año para cliente: " + totalMesAnioCliente);
		} catch (Exception e) {
			System.out.println("Error al calcular total del mes y año para cliente: " + e.getMessage());
		}
		
		System.out.println("\n======================\n");

		// 22) calcularTotal(int mes, int anio, int dniCliente)
		System.out.println("22) calcularTotal(int mes, int anio, int dniCliente)");
		try {
			float totalMesAnioDniCliente = 0;
			for (Carrito carrito111 : supermercado.getAdmCarrito().getLstCarrito()) {
				if (carrito111.getCliente().getDni() == 12345678L && carrito111.getFecha().getMonthValue() == 10
						&& carrito111.getFecha().getYear() == 2024) {
					totalMesAnioDniCliente += carrito111.calcularTotal();
				}
			}
			System.out.println("Total del mes y año para cliente por DNI: " + totalMesAnioDniCliente);
		} catch (Exception e) {
			System.out.println("Error al calcular total del mes y año para cliente por DNI: " + e.getMessage());
		}
		
		System.out.println("\n======================\n");

	}
}
