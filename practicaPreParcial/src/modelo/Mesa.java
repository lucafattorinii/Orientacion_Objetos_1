package modelo;

import java.util.Objects;

public class Mesa {
    private int idMesa;
    private int numeroMesa;
    private int capacidad;

    public Mesa(int idMesa, int numeroMesa, int capacidad) {
        this.idMesa = idMesa;
        this.numeroMesa = numeroMesa;
        this.capacidad = capacidad;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) throws Exception {
        if (numeroMesa > 0) {
            this.numeroMesa = numeroMesa;
        } else {
            throw new Exception("El número de mesa debe ser mayor que 0");
        }
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) throws Exception {
        if (capacidad > 0) {
            this.capacidad = capacidad;
        } else {
            throw new Exception("La capacidad debe ser mayor que 0");
        }
    }

    @Override
    public String toString() {
        return "Mesa{idMesa=" + idMesa + ", numeroMesa=" + numeroMesa + ", capacidad=" + capacidad + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mesa mesa = (Mesa) o;
        return numeroMesa == mesa.numeroMesa;
    }

    public boolean equals(Mesa otraMesa) {
        return this.numeroMesa == otraMesa.numeroMesa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroMesa);
    }
}
