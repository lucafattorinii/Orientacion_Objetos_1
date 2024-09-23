package modelo;

public class ProdPedido {
    private String producto;
    private double precio;

    // Constructor
    public ProdPedido(String producto, double precio) {
        this.producto = producto;
        this.precio = precio;
    }

    // Getters
    public String getProducto() {
        return producto;
    }

    public double getPrecio() {
        return precio;
    }

    // Método toString redefinido
    @Override
    public String toString() {
        return "Producto: " + producto + ", Precio: " + precio;
    }

    // Método equals sobrecargado
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Verifica la referencia
        if (obj == null || getClass() != obj.getClass()) return false; // Verifica el tipo
        ProdPedido that = (ProdPedido) obj; // Casting seguro
        return Double.compare(that.precio, precio) == 0 && producto.equals(that.producto);
    }
}
