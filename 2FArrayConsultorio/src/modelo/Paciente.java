package modelo;

public class Paciente {
    // Atributos
    private String nombre;
    private String apellido;
    private float estatura;
    private float peso;

    // Constructor 
    public Paciente(String nombre, String apellido, float estatura, float peso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.estatura = estatura;
        this.peso = peso;
    }

    // Métodos setter y getter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String traerNombreCompleto() {
        return nombre + " " + apellido;
    }


    public float traerIMC() {
        return peso / (estatura * estatura);
    }
} 