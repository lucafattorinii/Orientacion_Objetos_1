package test;

import modelo.Numero;

public class TestNumero {
    public static void main(String[] args) {
        // Crear una instancia de Numero
        Numero numero = new Numero(5);

        // Probar el método sumar
        System.out.println("Sumar 3: " + numero.sumar(3));

        // Probar el método multiplicar
        System.out.println("Multiplicar por 4: " + numero.multiplicar(4));

        // Probar el método esPar
        System.out.println("Es par: " + numero.esPar());

        // Probar el método esPrimo
        System.out.println("Es primo: " + numero.esPrimo());

        // Probar el método convertirAString
        System.out.println("Convertir a String: " + numero.convertirAString());

        // Probar el método convertirDouble
        System.out.println("Convertir a double: " + numero.convertirDouble());

        // Probar el método calcularPotencia
        System.out.println("Calcular potencia de 3: " + numero.calcularPotencia(3));

        // Probar el método calcularFactorial
        System.out.println("Calcular factorial: " + numero.calcularFactorial());

        // Probar el método numeroCombinatorio
        System.out.println("Número combinatorio de 5 sobre 2: " + numero.numeroCombinatorio(2));
    }
}
