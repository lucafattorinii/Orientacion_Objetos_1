package test;

import java.time.LocalDate;

import modelo.Carrito;
import modelo.Producto;
import modelo.Supermercado;

public class TestSupermercado {

    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado();

        // 1) agregarProducto
        System.out.println("1) Prueba de agregarProducto\n---------------------");
        try {
            System.out.println("Intentando agregar productos...");
            supermercado.agregarProducto("Manzana", 1.5f);
            supermercado.agregarProducto("Banana", 1.0f);
            System.out.println("Productos agregados correctamente.");

            // Intentar agregar un producto que ya existe
            System.out.println("Intentando agregar un producto que ya existe:");
            supermercado.agregarProducto("Manzana", 1.5f);
        } catch (Exception e) {
            System.out.println("Error en la prueba de agregarProducto: " + e.getMessage());
        }

        System.out.println("---------------------\n");

        // 2) traerProducto
        System.out.println("2) Prueba de traerProducto\n---------------------");
        Producto productoTraido = supermercado.traerProducto(1);
        if (productoTraido != null) {
            System.out.println("Producto traído: " + productoTraido);
        } else {
            System.out.println("Error: El producto no existe.");
        }

        System.out.println("---------------------\n");

        // 3) modificarProducto
        System.out.println("3) Prueba de modificarProducto\n---------------------");
        try {
            System.out.println("Modificando producto...");
            boolean modificado = supermercado.modificarProducto(1, "Manzana Verde", 1.8f);
            if (modificado) {
                Producto p = supermercado.traerProducto(1);
                if (p != null && p.getProducto().equals("Manzana Verde") && p.getPrecio() == 1.8f) {
                    System.out.println("Producto modificado correctamente: " + p);
                } else {
                    System.out.println("Error en los datos del producto modificado.");
                }
            } else {
                System.out.println("Error al modificar producto.");
            }
        } catch (Exception e) {
            System.out.println("Error en la prueba de modificarProducto: " + e.getMessage());
        }

        System.out.println("---------------------\n");

        // 4) eliminarProducto
        System.out.println("4) Prueba de eliminarProducto\n---------------------");
        try {
            System.out.println("Eliminando producto...");
            boolean eliminado = supermercado.eliminarProducto(2);
            if (eliminado) {
                Producto p = supermercado.traerProducto(2);
                if (p == null) {
                    System.out.println("Producto eliminado correctamente.");
                } else {
                    System.out.println("Error: El producto no se eliminó correctamente.");
                }
            } else {
                System.out.println("Error al eliminar producto.");
            }
        } catch (Exception e) {
            System.out.println("Error en la prueba de eliminarProducto: " + e.getMessage());
        }

        System.out.println("---------------------\n");

        // 5) agregarItem
        System.out.println("5) Prueba de agregarItem\n---------------------");
        Producto manzana = new Producto(1, "Manzana Verde", 1.8f);
        Producto banana = new Producto(2, "Banana", 1.0f);
        Carrito carrito = new Carrito(1, LocalDate.now(), LocalDate.now());

        try {
            System.out.println("Agregando ítem al carrito...");
            supermercado.agregarCarrito(carrito);
            boolean itemAgregado = supermercado.agregarItem(carrito, manzana, 5);
            if (itemAgregado) {
                System.out.println("Ítem agregado correctamente.");
            } else {
                System.out.println("Error al agregar ítem.");
            }
        } catch (Exception e) {
            System.out.println("Error en la prueba de agregarItem: " + e.getMessage());
        }

        System.out.println("---------------------\n");

        // 6) eliminarItem
        System.out.println("6) Prueba de eliminarItem\n---------------------");
        try {
            System.out.println("Eliminando ítem del carrito...");
            boolean itemEliminado = supermercado.eliminarItem(carrito, manzana, 3);
            if (itemEliminado) {
                System.out.println("Ítem eliminado correctamente.");
            } else {
                System.out.println("Error al eliminar ítem.");
            }
        } catch (Exception e) {
            System.out.println("Error en la prueba de eliminarItem: " + e.getMessage());
        }

        System.out.println("---------------------\n");

        // 7) calcularSubTotal y 8) calcularTotal
        System.out.println("7) Prueba de calcularSubTotal y 8) calcularTotal\n---------------------");
        try {
            System.out.println("Calculando subtotal...");
            float subtotal = supermercado.calcularSubTotal(carrito);
            System.out.println("Subtotal: " + subtotal);

            System.out.println("Calculando total...");
            float total = supermercado.calcularTotal(carrito);
            System.out.println("Total: " + total);
        } catch (Exception e) {
            System.out.println("Error en la prueba de calcularSubTotal o calcularTotal: " + e.getMessage());
        }

        System.out.println("---------------------\n");
        System.out.println("Pruebas finalizadas.");
    }
}
