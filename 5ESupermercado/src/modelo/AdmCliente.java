package modelo;

import java.util.ArrayList; 
import java.util.List;

public class AdmCliente { 
   private List<Cliente> lstCliente;

   public AdmCliente() { 
       lstCliente = new ArrayList<>(); // Inicialización de la lista
   } 
   
   
   public List<Cliente> getLstCliente() {
	return lstCliente;
}

public void setLstCliente(List<Cliente> lstCliente) {
	this.lstCliente = lstCliente;
}



// Caso de uso 8: Agregar un cliente
   public boolean agregarCliente(String clienteNombre, long dni, String direccion) throws Exception{
       for (int i=0; i<lstCliente.size(); i++) { // Búsqueda con while para verificar existencia del cliente.
           if (lstCliente.get(i).getDni() == dni){
               throw new Exception("El cliente ya existe.");
           }
       }
       
       int idCliente= lstCliente.size()+1; // Calcular ID automáticamente.
       lstCliente.add(new Cliente(idCliente, clienteNombre, dni, direccion));
       
       return true; // Cliente agregado con éxito.
   }
   


// Caso de uso 9: Traer un cliente por ID.
   public Cliente traerCliente(int idCliente) {
       Cliente clienteEncontrado = null;
       int i = 0;

       while (i < lstCliente.size() && clienteEncontrado == null) {
           if (lstCliente.get(i).getIdCliente() == idCliente) {
               clienteEncontrado = lstCliente.get(i);
           }
           i++;
       }

       return clienteEncontrado; // Retorna el cliente encontrado o null si no lo encuentra.
   }
   
     // Caso de uso 10: Eliminar un cliente por ID.
     public boolean eliminarCliente(int idCliente)throws Exception{
         for(int i=0;i<lstCliente.size();i++){
             if(lstCliente.get(i).getIdCliente()==idCliente){
                 lstCliente.remove(i);
                 return true;// Cliente eliminado con éxito.
             }
         }
         throw new Exception("El cliente no existe."); // Levanta excepción si el cliente no existe.
     }
}
