package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AdmCarrito { 
    private List<Carrito> lstCarrito; // Lista de carritos

    public AdmCarrito() { 
        lstCarrito = new ArrayList<>(); // Inicialización de la lista
    } 
    
   
    public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}

	public void setLstCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}



	// Caso de uso 11: Agregar un carrito
    public boolean agregarCarrito(LocalDate fecha, LocalTime hora, Cliente cliente) throws Exception {
        // Verificar si el carrito ya existe para el cliente
        for (int i = 0; i < lstCarrito.size(); i++) {
            if (lstCarrito.get(i).getCliente().equals(cliente)) {
                throw new Exception("El carrito ya existe para este cliente."); // Levanta excepción si el carrito ya existe
            }
        }

        int idCarrito = lstCarrito.size() + 1; // Calcular ID automáticamente
        Carrito nuevoCarrito = new Carrito(idCarrito, fecha, hora, cliente); // Crear nuevo carrito
        lstCarrito.add(nuevoCarrito); // Agregar a la lista
        
        return true; // Carrito agregado con éxito
    }

    // Caso de uso 12: Traer un carrito por ID
    public Carrito traerCarrito(int idCarrito) {
        Carrito carritoEncontrado = null;
        int i = 0;

        while (i < lstCarrito.size() && carritoEncontrado == null) {
            if (lstCarrito.get(i).getIdCarrito() == idCarrito) { // Acceso correcto al ID del carrito
                carritoEncontrado = lstCarrito.get(i); // Asignar el carrito encontrado
            }
            i++;
        }
        
        return carritoEncontrado; // Retorna null si no encuentra el carrito
    }

    // Caso de uso 13: Eliminar un carrito por ID
    public boolean eliminarCarrito(int idCarrito) throws Exception {
        Carrito carrito = traerCarrito(idCarrito); // Buscar el carrito por ID

        if (carrito == null) {
            throw new Exception("El carrito no existe."); // Levanta excepción si el carrito no existe
        }

        lstCarrito.remove(carrito); // Eliminar el carrito de la lista
        return true; // Carrito eliminado con éxito
    }
}