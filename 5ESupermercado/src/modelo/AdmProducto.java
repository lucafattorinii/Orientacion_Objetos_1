package modelo;

import java.util.ArrayList; 
import java.util.List;

public class AdmProducto { 
   private List<Producto> gondola;

   public AdmProducto() { 
       gondola = new ArrayList<>(); // Inicialización de la lista
   } 

   // Caso de uso 1: Agregar un producto
   public boolean agregarProducto(String prod, float precio) throws Exception {
       int id = 1;

       // Validación de existencia del producto
       for (int i = 0; i < gondola.size(); i++) {
           if (gondola.get(i).getProducto().equals(prod)) {
               throw new Exception("El producto " + prod + " ya existe en la gondola");
           }
       }

       // Cálculo automático del ID
       if (!gondola.isEmpty()) {
           id = gondola.get(gondola.size() - 1).getIdProducto() + 1; 
       }

       Producto p = new Producto(id, prod, precio);
       gondola.add(p);
       return true;
   }

   // Caso de uso 2: Traer un producto por ID
   public Producto traerProducto(int idProducto) {
       Producto p = null;
       int i = 0;

       while (i < gondola.size() && p == null) {
           if (gondola.get(i).getIdProducto() == idProducto) {
               p = gondola.get(i);
           }
           i++;
       }
       return p; // Retorna null si no encuentra el producto
   }

   // Caso de uso 3: Eliminar un producto por ID
   public boolean eliminarProducto(int id) throws Exception {
       Producto p = traerProducto(id);
       
       if (p == null) {
           throw new Exception("El producto que quiere eliminar no existe");
       }
       
       gondola.remove(p);
       return true; // Producto eliminado con éxito
   }
   
   // Caso de uso 4: Modificar un producto por ID
   public boolean modificarProducto(int idProducto, String producto, float precio) throws Exception{
       Producto p = traerProducto(idProducto);
       
       if (p == null) {
           throw new Exception("El producto que quiere modificar no existe");
       }
       
       p.setProducto(producto);
       p.setPrecio(precio);
       
       return true; // Modificación exitosa
   }
}
