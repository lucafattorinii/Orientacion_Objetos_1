package modelo;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
    private List<Producto> gondola; // Lista de productos en la góndola
    private List<Carrito> carritos; // Lista de carritos

    public Supermercado() {
        this.gondola = new ArrayList<>();
        this.carritos = new ArrayList<>();
    }

    public boolean agregarProducto(String producto, float precio) throws Exception {
        int id = 1;

        for (Producto p : gondola) {
            if (p.getProducto().equals(producto)) {
                throw new Exception("El producto ya existe en la góndola.");
            }
        }
        gondola.add(new Producto(id, producto, precio));
        return true;
    }

    public Producto traerProducto(int idProducto) {
        Producto producto = null;
        int i = 0;

        while (i < gondola.size() && producto == null) {
            if (gondola.get(i).getIdProducto() == idProducto) {
                producto = gondola.get(i);
            }
            i++;
        }
        return producto;
    }

    public boolean modificarProducto(int idProducto, String nombreNuevo, float precioNuevo) throws Exception {
        Producto producto = traerProducto(idProducto);
        if (producto == null) {
            throw new Exception("El producto no existe en la góndola.");
        } else {
            producto.setProducto(nombreNuevo);
            producto.setPrecio(precioNuevo);
        }
        return true;
    }

    public boolean eliminarProducto(int idProducto) throws Exception {
        Producto p = traerProducto(idProducto);
        if (p == null) {
            throw new Exception("El producto no existe en la góndola.");
        } else if (isProductoEnCarritos(p)) {
            throw new Exception("El producto está en algún carrito y no se puede eliminar.");
        } else {
            gondola.remove(p);
        }
        return true;
    }

    private boolean isProductoEnCarritos(Producto producto) {
        boolean encontrado = false;
        for (Carrito carrito : carritos) {
            for (ItemCarrito item : carrito.getLstItem()) {
                if (item.getProducto().equals(producto)) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) break;
        }
        return encontrado;
    }

    public void agregarCarrito(Carrito carrito) {
        this.carritos.add(carrito);
    }

    public void eliminarCarrito(Carrito carrito) {
        this.carritos.remove(carrito);
    }

    public boolean agregarItem(Carrito carrito, Producto producto, int cantidad) throws Exception {
        if (!gondola.contains(producto)) {
            throw new Exception("El producto no existe en la góndola.");
        }

        boolean itemAgregado = carrito.agregarItem(producto, cantidad);
        return itemAgregado;
    }

    public boolean eliminarItem(Carrito carrito, Producto producto, int cantidad) {
        boolean itemEliminado = carrito.eliminarItem(producto, cantidad);
        return itemEliminado;
    }

    public float calcularSubTotal(Carrito carrito) {
        return carrito.calcularSubTotal();
    }

    public float calcularTotal(Carrito carrito) {
        return carrito.calcularTotal();
    }
}
