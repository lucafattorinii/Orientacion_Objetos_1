package modelo;

import java.util.Objects;

public class Producto {
    private int idProducto;
    private String producto;
    private float precio;

    public Producto(int idProducto, String producto, float precio) {
        this.idProducto = idProducto;
        this.producto = producto;
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", producto='" + producto + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (this == obj) {
            equal = true;
        } else if (obj instanceof Producto) {
            Producto other = (Producto) obj;
            equal = this.idProducto == other.idProducto;
        }
        return equal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto);
    }
}
