package test;

import modulo.ArregloBidimensional;

public class ArregloBidimensionalTest {

    public static void main(String[] args) {
        testSumar();
        testRestar();
        testTranspuesta();
        testMultiplicarEscalar();
        testMultiplicarMatrices();
    }

    public static void testSumar() {
        double[][] matrizA = {
            {1, 2, 3},
            {4, 5, 6}
        };
        double[][] matrizB = {
            {7, 8, 9},
            {10, 11, 12}
        };
        ArregloBidimensional arreglo = new ArregloBidimensional(matrizA);
        double[][] resultado = arreglo.sumar(matrizB);
        
        double[][] esperado = {
            {8, 10, 12},
            {14, 16, 18}
        };
        System.out.println("Test Sumar:");
        System.out.println("Matriz A:");
        imprimirMatriz(matrizA);
        System.out.println("Matriz B:");
        imprimirMatriz(matrizB);
        System.out.println("Resultado:");
        imprimirMatriz(resultado);
        System.out.println("Esperado:");
        imprimirMatriz(esperado);
        System.out.println("Resultado Correcto: " + arraysIguales(esperado, resultado) + "\n");
    }

    public static void testRestar() {
        double[][] matrizA = {
            {1, 2, 3},
            {4, 5, 6}
        };
        double[][] matrizB = {
            {7, 8, 9},
            {10, 11, 12}
        };
        ArregloBidimensional arreglo = new ArregloBidimensional(matrizA);
        double[][] resultado = arreglo.restar(matrizB);
        
        double[][] esperado = {
            {-6, -6, -6},
            {-6, -6, -6}
        };
        System.out.println("Test Restar:");
        System.out.println("Matriz A:");
        imprimirMatriz(matrizA);
        System.out.println("Matriz B:");
        imprimirMatriz(matrizB);
        System.out.println("Resultado:");
        imprimirMatriz(resultado);
        System.out.println("Esperado:");
        imprimirMatriz(esperado);
        System.out.println("Resultado Correcto: " + arraysIguales(esperado, resultado) + "\n");
    }

    public static void testTranspuesta() {
        double[][] matrizA = {
            {1, 2, 3},
            {4, 5, 6}
        };
        ArregloBidimensional arreglo = new ArregloBidimensional(matrizA);
        double[][] resultado = arreglo.transpuesta();
        
        double[][] esperado = {
            {1, 4},
            {2, 5},
            {3, 6}
        };
        System.out.println("Test Transpuesta:");
        System.out.println("Matriz A:");
        imprimirMatriz(matrizA);
        System.out.println("Transpuesta:");
        imprimirMatriz(resultado);
        System.out.println("Esperado:");
        imprimirMatriz(esperado);
        System.out.println("Resultado Correcto: " + arraysIguales(esperado, resultado) + "\n");
    }

    public static void testMultiplicarEscalar() {
        double[][] matrizA = {
            {1, 2},
            {3, 4}
        };
        ArregloBidimensional arreglo = new ArregloBidimensional(matrizA);
        double[][] resultado = arreglo.multiplicar(2);
        
        double[][] esperado = {
            {2, 4},
            {6, 8}
        };
        System.out.println("Test Multiplicar por Escalar:");
        System.out.println("Matriz A:");
        imprimirMatriz(matrizA);
        System.out.println("Escalar: 2");
        System.out.println("Resultado:");
        imprimirMatriz(resultado);
        System.out.println("Esperado:");
        imprimirMatriz(esperado);
        System.out.println("Resultado Correcto: " + arraysIguales(esperado, resultado) + "\n");
    }

    public static void testMultiplicarMatrices() {
        double[][] matrizA = {
            {2, 3},
            {1, 0},
            {4, 5}
        };
        double[][] matrizB = {
            {1, 2},
            {3, 4}
        };
        ArregloBidimensional arreglo = new ArregloBidimensional(matrizA);
        double[][] resultado = arreglo.multiplicar(matrizB);
        
        double[][] esperado = {
            {11, 16},
            {1, 2},
            {19, 28}
        };
        System.out.println("Test Multiplicar Matrices:");
        System.out.println("Matriz A:");
        imprimirMatriz(matrizA);
        System.out.println("Matriz B:");
        imprimirMatriz(matrizB);
        System.out.println("Resultado:");
        imprimirMatriz(resultado);
        System.out.println("Esperado:");
        imprimirMatriz(esperado);
        System.out.println("Resultado Correcto: " + arraysIguales(esperado, resultado) + "\n");
    }

    // Método auxiliar para comparar matrices
    public static boolean arraysIguales(double[][] esperado, double[][] resultado) {
        if (esperado == null || resultado == null) return esperado == resultado;
        if (esperado.length != resultado.length || esperado[0].length != resultado[0].length) return false;
        for (int i = 0; i < esperado.length; i++) {
            for (int j = 0; j < esperado[i].length; j++) {
                if (esperado[i][j] != resultado[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Método auxiliar para imprimir matrices
    public static void imprimirMatriz(double[][] matriz) {
        if (matriz == null) {
            System.out.println("null");
            return;
        }
        for (double[] fila : matriz) {
            for (double elemento : fila) {
                System.out.print(elemento + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
