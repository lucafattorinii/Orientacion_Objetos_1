package modelo;

import java.util.Objects;

public class Pelicula {
    private int idPelicula;
    private String pelicula;

    public Pelicula(int idPelicula, String pelicula) {
        this.idPelicula = idPelicula;
        this.pelicula = pelicula;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }
    
    

    @Override
	public String toString() {
		return "Pelicula [idPelicula=" + idPelicula + ", pelicula=" + pelicula + "]";
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Pelicula)) return false;
        Pelicula other = (Pelicula) obj;
        return idPelicula == other.idPelicula;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPelicula);
    }
}
