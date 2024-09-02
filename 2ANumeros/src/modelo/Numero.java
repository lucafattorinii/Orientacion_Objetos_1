package modelo;

public class Numero {
    private int n;

    public Numero(int n) {
        this.n = n;
    }

    // Método para sumar un número entero
    public int sumar(int n1) {
        return this.n + n1;
    }

    // Método para multiplicar por un número entero
    public int multiplicar(int n1) {
        return this.n * n1;
    }

    // Método para verificar si el número es par
    public boolean esPar() {
        return this.n % 2 == 0;
    }

    // Método para verificar si el número es primo
    public boolean esPrimo() {
        if (this.n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(this.n); i++) {
            if (this.n % i == 0) return false;
        }
        return true;
    }

    // Método para convertir el número a String
    public String convertirAString() {
        return String.valueOf(this.n);
    }

    // Método para convertir el número a double
    public double convertirDouble() {
        return Double.parseDouble(String.valueOf(this.n));
    }

    // Método para calcular la potencia
    public double calcularPotencia(int exp) {
        return Math.pow(this.n, exp);
    }

    // Método para calcular el factorial
    public int calcularFactorial() {
        if (this.n < 0) return 1;
        int factorial = 1;
        for (int i = 1; i <= this.n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    // Método para calcular el número combinatorio (n sobre k)
    public int numeroCombinatorio(int n1) {
        if (n1 < 0 || this.n < 0 || this.n < n1) return 0;
        return calcularFactorial() / (new Numero(n1).calcularFactorial() * new Numero(this.n - n1).calcularFactorial());
    }
}
