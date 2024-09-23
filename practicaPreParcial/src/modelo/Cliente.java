package modelo;

import java.util.Objects;

public class Cliente {
    private int idCliente;
    private String nombre;
    private String apellido;
    private long dni;
    private String telefono;

    public Cliente(int idCliente, String nombre, String apellido, long dni, String telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public long getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono != null && !telefono.isEmpty()) {
            this.telefono = telefono;
        } else {
            throw new IllegalArgumentException("El teléfono no puede ser nulo o vacío");
        }
    }

    @Override
    public String toString() {
        return "Cliente{idCliente=" + idCliente + ", nombre='" + nombre + "', apellido='" + apellido + "', dni=" + dni + ", telefono='" + telefono + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return dni == cliente.dni;
    }

    public boolean equals(Cliente otroCliente) {
        return this.dni == otroCliente.dni;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
}
