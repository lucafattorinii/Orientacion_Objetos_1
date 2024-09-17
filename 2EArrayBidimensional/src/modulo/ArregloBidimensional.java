package modulo;

public class ArregloBidimensional {
    private double[][] matrizA;

    // Constructor
    public ArregloBidimensional(double[][] matrizA) {
        this.matrizA = matrizA;
    }

    // Sumar matrices
    public double[][] sumar(double[][] matrizB) {
        if (!sonDimensionesIguales(matrizA, matrizB)) return null;
        double[][] resultado = new double[matrizA.length][matrizA[0].length];
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
                resultado[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }
        return resultado;
    }

    // Restar matrices
    public double[][] restar(double[][] matrizB) {
        if (!sonDimensionesIguales(matrizA, matrizB)) return null;
        double[][] resultado = new double[matrizA.length][matrizA[0].length];
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
                resultado[i][j] = matrizA[i][j] - matrizB[i][j];
            }
        }
        return resultado;
    }

    // Transpuesta de la matriz
    public double[][] transpuesta() {
        double[][] transpuesta = new double[matrizA[0].length][matrizA.length];
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
                transpuesta[j][i] = matrizA[i][j];
            }
        }
        return transpuesta;
    }

    // Multiplicar matriz por un escalar
    public double[][] multiplicar(double numero) {
        double[][] resultado = new double[matrizA.length][matrizA[0].length];
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
                resultado[i][j] = matrizA[i][j] * numero;
            }
        }
        return resultado;
    }

    // Multiplicar matrices
    public double[][] multiplicar(double[][] matrizB) {
        if (matrizA[0].length != matrizB.length) return null;
        double[][] resultado = new double[matrizA.length][matrizB[0].length];
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizB[0].length; j++) {
                for (int k = 0; k < matrizA[0].length; k++) {
                    resultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }
        return resultado;
    }

    // Método auxiliar para verificar si las dimensiones son iguales
    private boolean sonDimensionesIguales(double[][] matriz1, double[][] matriz2) {
        return matriz1.length == matriz2.length && matriz1[0].length == matriz2[0].length;
    }
}
