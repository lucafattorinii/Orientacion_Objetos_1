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
        return super.equals(obj) && obj instanceof Cliente && cuit.equals(((Cliente) obj).cuit);
    }


    @Override
    public String toString() {
        return String.format("Cliente{cuit='%s', limiteCredito=%.2f} %s", cuit, limiteCredito, super.toString());
    }

}

