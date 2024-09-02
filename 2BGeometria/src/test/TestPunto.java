package test;

import modelo.Punto;

public class TestPunto {
    public static void main(String[] args) {
        // Escenario 1: Crear dos instancias de Punto distintas
        Punto punto1 = new Punto(1.0, 2.0);
        Punto punto2 = new Punto(3.0, 4.0);
        
        // Imprimir los puntos
        System.out.println("Punto 1: " + punto1);
        System.out.println("Punto 2: " + punto2);
        
        // Imprimir el resultado de equals entre los puntos
        System.out.println("Punto 1 igual a Punto 2: " + punto1.equals(punto2));
        
        // Escenario 2: Crear dos objetos de Punto iguales
        Punto punto3 = new Punto(1.0, 2.0);
        Punto punto4 = new Punto(1.0, 2.0);
        
        // Imprimir los puntos
        System.out.println("Punto 3: " + punto3);
        System.out.println("Punto 4: " + punto4);
        
        // Imprimir el resultado de equals entre los puntos
        System.out.println("Punto 3 igual a Punto 4: " + punto3.equals(punto4));
        
        // Probar el método calcularDistancia
        System.out.println("Distancia entre Punto 1 y Punto 2: " + punto1.calcularDistancia(punto2));
    }
}
