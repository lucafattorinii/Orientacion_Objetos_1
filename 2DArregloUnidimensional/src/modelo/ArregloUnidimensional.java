package modelo;


public class ArregloUnidimensional {
    private int[] vector;

    public ArregloUnidimensional(int[] vector) {
        this.vector = vector;
    }

    public int traerElMenor() {
        int menor = vector[0];
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] < menor) {
                menor = vector[i];
            }
        }
        return menor;
    }

    public int traerElMayor() {
        int mayor = vector[0];
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] > mayor) {
                mayor = vector[i];
            }
        }
        return mayor;
    }

    public double calcularPromedio() {
        int suma = 0;
        for (int num : vector) {
            suma += num;
        }
        return (double) suma / vector.length;
    }

    public int[] ordenarAscendente() {
        int[] copia = vector.clone();
        ordenar(copia, true);
        return copia;
    }

    public int[] ordenarDescendente() {
        int[] copia = vector.clone();
        ordenar(copia, false);
        return copia;
    }

    private void ordenar(int[] array, boolean ascendente) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (ascendente) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                } else {
                    if (array[j] < array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
    }

    public int traerFrecuencia(int numero) {
        int frecuencia = 0;
        for (int num : vector) {
            if (num == numero) {
                frecuencia++;
            }
        }
        return frecuencia;
    }

    public int traerModa() {
        int moda = vector[0];
        int maxFrecuencia = traerFrecuencia(vector[0]);

        for (int i = 1; i < vector.length; i++) {
            int frecuencia = traerFrecuencia(vector[i]);
            if (frecuencia > maxFrecuencia) {
                maxFrecuencia = frecuencia;
                moda = vector[i];
            }
        }

        return moda;
    }
}

