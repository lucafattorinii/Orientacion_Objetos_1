package test;

import modelo.Circulo;
import modelo.Punto;

public class TestCirculo {
    public static void main(String[] args) {
        // Crear un punto para el centro del círculo
        Punto centro = new Punto(0.0, 0.0);

        // Crear un círculo con el centro y radio especificados
        Circulo circulo = new Circulo(centro, 5.0);
        
        // Imprimir el círculo
        System.out.println("Círculo: " + circulo);

        // Probar el método calcularArea
        System.out.println("Área del círculo: " + circulo.calcularArea());

        // Probar el método calcularPerimetro
        System.out.println("Perímetro del círculo: " + circulo.calcularPerimetro());

        // Crear puntos para probar si están dentro del círculo
        Punto puntoDentro = new Punto(3.0, 4.0);
        Punto puntoFuera = new Punto(6.0, 6.0);

        // Probar el método contienePunto
        System.out.println("El punto " + puntoDentro + " está dentro del círculo: " + circulo.contienePunto(puntoDentro));
        System.out.println("El punto " + puntoFuera + " está dentro del círculo: " + circulo.contienePunto(puntoFuera));
    }
}
