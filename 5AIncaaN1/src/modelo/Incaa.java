package modelo;

import java.util.ArrayList;
import java.util.List;

public class Incaa {
    private List<Pelicula> catalogo;

    public Incaa() {
        catalogo = new ArrayList<>();
    }

    public boolean agregarPelicula(String nombre) throws Exception {
        for (Pelicula pelicula : catalogo) {
            if (pelicula.getPelicula().equals(nombre)) {
                throw new Exception("La película ya existe en el catálogo.");
            }
        }
        int nuevoId = catalogo.size() + 1; // Genera un nuevo ID
        catalogo.add(new Pelicula(nuevoId, nombre));
        return true;
    }

    public Pelicula traerPelicula(int idPelicula) {
        Pelicula peliculaEncontrada = null; // Inicializamos la variable a null

        for (Pelicula pelicula : catalogo) {
            if (pelicula.getIdPelicula() == idPelicula) {
                peliculaEncontrada = pelicula; // Asignamos la película encontrada
            }
        }

        return peliculaEncontrada; // Retornamos la variable al final del método
    }

    public List<Pelicula> traerPelicula(String partePelicula) {
        List<Pelicula> resultado = new ArrayList<>();
        for (Pelicula pelicula : catalogo) {
            if (pelicula.getPelicula().contains(partePelicula)) {
                resultado.add(pelicula);
            }
        }
        return resultado; // Devuelve la lista de películas que contienen el texto
    }

    public void modificarPelicula(int idPelicula, String nuevoNombre) throws Exception {
        Pelicula pelicula = traerPelicula(idPelicula);
        if (pelicula == null) {
            throw new Exception("La película no existe.");
        }
        pelicula.setPelicula(nuevoNombre);
    }

    public boolean eliminarPelicula(int idPelicula) throws Exception {
        Pelicula pelicula = traerPelicula(idPelicula);
        if (pelicula == null) {
            throw new Exception("La película no existe.");
        }
        catalogo.remove(pelicula);
        return true; // Retorna true si se eliminó correctamente
    }
}
