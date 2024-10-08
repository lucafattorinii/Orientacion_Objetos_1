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

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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
	public int hashCode() {
		return Objects.hash(idProducto, precio, producto);
	}

	
	
	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", producto=" + producto + ", precio=" + precio + "]";
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return idProducto == other.idProducto && Float.floatToIntBits(precio) == Float.floatToIntBits(other.precio)
				&& Objects.equals(producto, other.producto);
	}
    
    
}
