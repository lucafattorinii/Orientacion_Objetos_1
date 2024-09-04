package test;

import java.util.Arrays;
import modelo.ArregloUnidimensional;

public class ArregloUnidimensionalTest {
    public static void main(String[] args) {
        int[] vector = {4, 1, 2, 2, 7, 3, 4, 1, 1};
        ArregloUnidimensional arreglo = new ArregloUnidimensional(vector);

        System.out.println("Menor: " + arreglo.traerElMenor()); // Debería imprimir 1
        System.out.println("Mayor: " + arreglo.traerElMayor()); // Debería imprimir 7
        System.out.println("Promedio: " + arreglo.calcularPromedio()); // Debería imprimir 2.777...
        System.out.println("Ordenado Ascendente: " + Arrays.toString(arreglo.ordenarAscendente())); // Debería imprimir [1, 1, 1, 2, 2, 3, 4, 4, 7]
        System.out.println("Ordenado Descendente: " + Arrays.toString(arreglo.ordenarDescendente())); // Debería imprimir [7, 4, 4, 3, 2, 2, 1, 1, 1]
        System.out.println("Frecuencia del número 1: " + arreglo.traerFrecuencia(1)); // Debería imprimir 3
        System.out.println("Moda: " + arreglo.traerModa()); // Debería imprimir 1
    }
}

