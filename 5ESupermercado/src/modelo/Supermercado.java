package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Supermercado {
    private AdmProducto admProducto; // Administración de productos
    private AdmCliente admCliente; // Administración de clientes
    private AdmCarrito admCarrito; // Administración de carritos

    public Supermercado() { // Constructor sin parámetros
        admProducto = new AdmProducto(); // Inicialización de AdmProducto
        admCliente = new AdmCliente(); // Inicialización de AdmCliente
        admCarrito = new AdmCarrito(); // Inicialización de AdmCarrito
    }
    
   
    public AdmProducto getAdmProducto() {
		return admProducto;
	}

	public void setAdmProducto(AdmProducto admProducto) {
		this.admProducto = admProducto;
	}


	public AdmCliente getAdmCliente() {
		return admCliente;
	}

	public void setAdmCliente(AdmCliente admCliente) {
		this.admCliente = admCliente;
	}


	public AdmCarrito getAdmCarrito() {
		return admCarrito;
	}


	public void setAdmCarrito(AdmCarrito admCarrito) {
		this.admCarrito = admCarrito;
	}

	// Método para agregar un producto
    public boolean agregarProducto(String nombreProducto, float precio) throws Exception {
        boolean resultado = admProducto.agregarProducto(nombreProducto, precio);
        return resultado; // Retorno único
    }

    // Método para traer un producto por ID
    public Producto traerProducto(int idProducto) {
        Producto producto = admProducto.traerProducto(idProducto);
        return producto; // Retorno único
    }

    // Método para eliminar un producto por ID
    public boolean eliminarProducto(int idProducto) throws Exception {
        boolean resultado = admProducto.eliminarProducto(idProducto);
        return resultado; // Retorno único
    }

    // Método para modificar un producto por ID
    public boolean modificarProducto(int idProducto, String nombreProducto, float precio) throws Exception {
        boolean resultado = admProducto.modificarProducto(idProducto, nombreProducto, precio);
        return resultado; // Retorno único
    }

    // Método para agregar un cliente
    public boolean agregarCliente(String nombreCliente, long dni, String direccion) throws Exception {
        boolean resultado = admCliente.agregarCliente(nombreCliente, dni, direccion);
        return resultado; // Retorno único
    }

    // Método para traer un cliente por ID
    public Cliente traerCliente(int idCliente) {
        Cliente cliente = admCliente.traerCliente(idCliente);
        return cliente; // Retorno único
    }

    // Método para eliminar un cliente por ID
    public boolean eliminarCliente(int idCliente) throws Exception {
        boolean resultado = admCliente.eliminarCliente(idCliente);
        return resultado; // Retorno único
    }

    // Método para agregar un carrito
    public boolean agregarCarrito(LocalDate fecha, LocalTime hora, Cliente cliente) throws Exception {
        boolean resultado = admCarrito.agregarCarrito(fecha, hora, cliente);
        return resultado; // Retorno único
    }

    // Método para traer un carrito por ID
    public Carrito traerCarrito(int idCarrito) {
        Carrito carrito = admCarrito.traerCarrito(idCarrito);
        return carrito; // Retorno único
    }

    // Método para eliminar un carrito por ID
    public boolean eliminarCarrito(int idCarrito) throws Exception {
        boolean resultado = admCarrito.eliminarCarrito(idCarrito);
        return resultado; // Retorno único
    }
}