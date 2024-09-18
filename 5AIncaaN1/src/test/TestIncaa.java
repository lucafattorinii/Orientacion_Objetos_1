package test;

import java.util.List;

import modelo.*;

public class TestIncaa {
    public static void main(String[] args) {
        
        // Crear objeto Incaa
        Incaa incaa = new Incaa();
        
        // Prueba: Agregar películas
        try {
            System.out.println("Agregando 'Inception': " + incaa.agregarPelicula("Inception"));
            System.out.println("Agregando 'Interstellar': " + incaa.agregarPelicula("Interstellar"));
            System.out.println("Agregando 'Inception': " + incaa.agregarPelicula("Inception")); // Debe lanzar excepción
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Prueba: Traer película por ID
        Pelicula p1 = incaa.traerPelicula(1);
        System.out.println("Traer película con ID 1: " + (p1 != null ? p1.getPelicula() : "No encontrada"));

        // Prueba: Traer películas por parte del título
        List<Pelicula> peliculasEncontradas = incaa.traerPelicula("In");
        System.out.println("Películas que contienen 'In':");
        for (Pelicula p : peliculasEncontradas) {
            System.out.println(p.getIdPelicula() + ": " + p.getPelicula());
        }

        // Prueba: Modificar película
        try {
            incaa.modificarPelicula(1, "Inception Modified");
            System.out.println("Película modificada: " + incaa.traerPelicula(1).getPelicula());
            incaa.modificarPelicula(99, "No Existente"); // Debe lanzar excepción
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Prueba: Eliminar película
        try {
            boolean eliminado = incaa.eliminarPelicula(2);
            System.out.println("Película eliminada con éxito: " + eliminado);
            incaa.eliminarPelicula(99); // Debe lanzar excepción
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
