package modelo;

public class Circulo {
    private Punto centro;
    private double radio;

    // Constructor
    public Circulo(Punto centro, double radio) {
        this.centro = centro;
        this.radio = radio;
    }

    // Métodos getter y setter para el centro
    public Punto getCentro() {
        return centro;
    }

    public void setCentro(Punto centro) {
        this.centro = centro;
    }

    // Métodos getter y setter para el radio
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    // Método para calcular el área del círculo
    public double calcularArea() {
        return Math.PI * Math.pow(this.radio, 2);
    }

    // Método para calcular el perímetro del círculo
    public double calcularPerimetro() {
        return 2 * Math.PI * this.radio;
    }

    // Método para verificar si un punto está dentro del círculo
    public boolean contienePunto(Punto punto) {
        return centro.calcularDistancia(punto) <= this.radio;
    }

    // Método toString para representar el círculo como una cadena
    @Override
    public String toString() {
        return "Circulo{" + "centro=" + centro + ", radio=" + radio + '}';
    }
}
