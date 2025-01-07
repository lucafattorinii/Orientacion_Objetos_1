package modelo;

public class Cliente {
    private int idCliente;
    private String cliente;
    private long dni;
    private String direccion;

    public Cliente(int idCliente, String cliente, long dni, String direccion) {
        this.idCliente = idCliente;
        this.cliente = cliente;
        this.dni = dni;
        this.direccion = direccion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (this == obj) {
        	equal = true;
        } else if (obj instanceof Cliente) {
            Cliente other = (Cliente) obj;
            equal = this.idCliente == other.idCliente || this.dni == other.dni;
        }
        return equal;
    }
    
     @Override
     public String toString() {
         return "Cliente [ID=" + idCliente +
                ", Nombre=" + cliente +
                ", DNI=" + dni +
                ", Dirección=" + direccion +
                "]";
     }
}