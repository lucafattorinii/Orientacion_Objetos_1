package modelo;

public class Punto {
    private double x;
    private double y;

    // Constructor
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Métodos getter y setter para x
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    // Métodos getter y setter para y
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Método para calcular la distancia entre dos puntos
    public double calcularDistancia(Punto otro) {
        return Math.sqrt(Math.pow(this.x - otro.x, 2) + Math.pow(this.y - otro.y, 2));
    }

    // Método equals para comparar puntos
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Punto punto = (Punto) obj;
        return Double.compare(punto.x, x) == 0 && Double.compare(punto.y, y) == 0;
    }

    // Método toString para representar el punto como una cadena
    @Override
    public String toString() {
        return "Punto{" + "x=" + x + ", y=" + y + '}';
    }
}
