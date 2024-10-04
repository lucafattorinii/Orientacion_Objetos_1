package modelo;

import java.time.LocalDate;

public class Cliente extends Persona {
    private String cuit;
    private float limiteCredito;

    public Cliente(String nombre, String apellido, long dni, LocalDate fechaNacimiento, String cuit, float limiteCredito) {
        super(nombre, apellido, dni, fechaNacimiento);
        this.cuit = cuit;
        this.limiteCredito = limiteCredito;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public float getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(float limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    // Caso de uso 5: Estado del crédito
    public String estadoCredito() {
        return "El límite de crédito es: " + limiteCredito;
    }

    // Caso de uso 6: Hablar
    @Override
    public String hablar() {
        return "Hola, soy un cliente.";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Cliente cliente = (Cliente) obj;
        return cuit.equals(cliente.cuit);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cuit='" + cuit + '\'' +
                ", limiteCredito=" + limiteCredito +
                "} " + super.toString();
    }
}

