package test;

import modelo.Cliente;
import modelo.Mesa;
import modelo.Reserva;
import modelo.SistemaRestaurante;

import java.time.LocalDate;
import java.util.List;

public class TestSistemaRestaurante {
    public static void main(String[] args) {
        SistemaRestaurante sistema = new SistemaRestaurante();

        // CU 1: Traer Cliente por DNI
        System.out.println("\nCU 1 ===============\n");
        Cliente cliente1 = sistema.traerCliente(12345678);
        System.out.println("Cliente encontrado: " + (cliente1 != null ? cliente1.toString() : "No encontrado"));

        // CU 2: Agregar Cliente
        System.out.println("\nCU 2 ===============\n");
        try {
            sistema.agregarCliente("Juan", "Pérez", 12345678, "123456789");
            sistema.agregarCliente("Ana", "Gómez", 87654321, "987654321");
            System.out.println("Clientes agregados exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar cliente: " + e.getMessage());
        }

        // CU 3: Traer Cliente por DNI
        System.out.println("\nCU 3 ===============\n");
        Cliente cliente = sistema.traerCliente(12345678);
        System.out.println("Cliente encontrado: " + (cliente != null ? cliente.toString() : "No encontrado"));

        // CU 4: Agregar Mesa
        System.out.println("\nCU 4 ===============\n");
        try {
            sistema.agregarMesa(1, 4);
            sistema.agregarMesa(2, 6);
            System.out.println("Mesas agregadas exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar mesa: " + e.getMessage());
        }

        // CU 5: Traer Mesa por número
        System.out.println("\nCU 5 ===============\n");
        Mesa mesa = sistema.traerMesa(1);
        System.out.println("Mesa encontrada: " + (mesa != null ? mesa.toString() : "No encontrada"));

        // CU 6: Validar Comensales al Agregar Reserva
        System.out.println("\nCU 6 ===============\n");
        try {
            mesa = sistema.traerMesa(1);
            sistema.agregarReserva(cliente, LocalDate.now(), mesa, 3); // Intentar agregar una reserva con 3 comensales
            System.out.println("Reserva agregada con 3 comensales. Validación exitosa.");
        } catch (Exception e) {
            System.out.println("Error al agregar reserva: " + e.getMessage());
        }

        // CU 7: Agregar Reserva
        System.out.println("\nCU 7 ===============\n");
        try {
            sistema.agregarReserva(cliente, LocalDate.now(), mesa, 4);
            System.out.println("Reserva agregada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar reserva: " + e.getMessage());
        }

        // CU 8: Traer Reserva por número de mesa y fecha
        System.out.println("\nCU 8 ===============\n");
        Reserva reserva = sistema.traerReserva(1, LocalDate.now());
        System.out.println("Reserva encontrada: " + (reserva != null ? reserva.toString() : "No encontrada"));

        // CU 9: Traer Reservas en un rango de fechas
        System.out.println("\nCU 9 ===============\n");
        List<Reserva> reservasEnRango = sistema.traerRes(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
        System.out.println("Reservas en rango: " + reservasEnRango.size());

        // CU 10: Traer Mesas libres para una fecha específica
        System.out.println("\nCU 10 ===============\n");
        List<Mesa> mesasLibres = sistema.traerMesasLibreParaFecha(LocalDate.now());
        System.out.println("Mesas libres para hoy: " + mesasLibres.size());
        for (Mesa m : mesasLibres) {
            System.out.println(m.toString());
        }

        // CU 11: Agregar Producto Pedido
        System.out.println("\nCU 11 ===============\n");
        Reserva reserva1 = sistema.traerReserva(1, LocalDate.now()); // Obtener la reserva
        if (reserva1 != null) {
            boolean prodAgregado = false;
            try {
                prodAgregado = reserva.agregarProdPedido( "Pizza", 10.99);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Producto agregado: " + prodAgregado);
        } else {
            System.out.println("No se encontró la reserva.");
        }

        // CU 12: Devolver Total Reserva
        System.out.println("\nCU 12 ===============\n");
        if (reserva1 != null) {
            double totalReserva = reserva1.devolverTotalReserva();
            System.out.println("Total de la reserva: " + totalReserva);
        } else {
            System.out.println("No se encontró la reserva para calcular el total.");
        }
    }
}
