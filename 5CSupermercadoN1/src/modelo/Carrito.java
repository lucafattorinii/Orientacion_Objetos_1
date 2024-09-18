package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private int idCarrito;
    private LocalDate fecha;
    private LocalDate hora;
    private List<ItemCarrito> lstItem;

    public Carrito(int idCarrito, LocalDate fecha, LocalDate hora) {
        this.idCarrito = idCarrito;
        this.fecha = fecha;
        this.hora = hora;
        this.lstItem = new ArrayList<>();
    }

    public boolean agregarItem(Producto producto, int cantidad) {
        boolean encontrado = false;
        for (ItemCarrito item : lstItem) {
            if (item.getProducto().getIdProducto() == producto.getIdProducto()) {
                item.setCantidad(item.getCantidad() + cantidad);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            lstItem.add(new ItemCarrito(lstItem.size() + 1, producto, cantidad));
        }
        return true;
    }

    public boolean eliminarItem(Producto producto, int cantidad) {
        boolean eliminado = false;
        for (ItemCarrito item : lstItem) {
            if (item.getProducto().getIdProducto() == producto.getIdProducto()) {
                if (item.getCantidad() > cantidad) {
                    item.setCantidad(item.getCantidad() - cantidad);
                } else {
                    lstItem.remove(item);
                }
                eliminado = true;
                break;
            }
        }
        return eliminado;
    }

    public float calcularSubTotal() {
        float subtotal = 0;
        for (ItemCarrito item : lstItem) {
            subtotal += item.calcularSubTotal();
        }
        return subtotal;
    }

    public float calcularTotal() {
        return calcularSubTotal(); // Si hay impuestos, se agregan aquí
    }

    public List<ItemCarrito> getLstItem() {
        return lstItem;
    }
}
