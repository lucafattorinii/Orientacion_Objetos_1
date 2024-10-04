package modelo;

import java.time.LocalDate;

public class Empleado extends Persona {
    private long legajo;
    private float sueldoMensual;

    public Empleado(String nombre, String apellido, long dni, LocalDate fechaNacimiento, long legajo, float sueldoMensual) {
        super(nombre, apellido, dni, fechaNacimiento);
        this.legajo = legajo;
        this.sueldoMensual = sueldoMensual;
    }

    public long getLegajo() {
        return legajo;
    }

    public void setLegajo(long legajo) {
        this.legajo = legajo;
    }

    public float getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(float sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    // Caso de uso 3: Calcular sueldo considerando días ausentes
    public float calcularSueldo(int diasAusentes) {
        float sueldoDiario = sueldoMensual / 30;
        return sueldoMensual - (diasAusentes * sueldoDiario);
    }

    // Caso de uso 4: Hablar
    @Override
    public String hablar() {
        return "Hola, soy un empleado.";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && obj instanceof Empleado && legajo == ((Empleado) obj).legajo;
    }


    @Override
    public String toString() {
        return String.format("Empleado{legajo=%d, sueldoMensual=%.2f} %s", legajo, sueldoMensual, super.toString());
    }

}
