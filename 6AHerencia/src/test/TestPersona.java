package test;

import java.time.LocalDate;

import modelo.*;

public class TestPersona {

    public static void main(String[] args) {
        // Test caso de uso 1: Calcular edad
        System.out.println("1) Test - Calcular Edad");
        Persona persona = new Cliente("Juan", "Perez", 12345678, LocalDate.of(1990, 5, 15), "20-12345678-9", 50000f);
        System.out.println("Edad: " + persona.calcularEdad(LocalDate.of(2024, 10, 4)));  // Debería ser 34

        // Test caso de uso 2: Hablar
        System.out.println("2) Test - Hablar (Persona)");
        System.out.println(persona.hablar());

        // Test caso de uso 3: Calcular sueldo
        System.out.println("3) Test - Calcular Sueldo");
        Empleado empleado = new Empleado("Ana", "Gomez", 87654321, LocalDate.of(1985, 3, 20), 1234L, 60000f);
        System.out.println("Sueldo con 2 días ausentes: " + empleado.calcularSueldo(2));  // Debería ser un poco menos de 60000

        // Test caso de uso 4: Hablar (Empleado)
        System.out.println("4) Test - Hablar (Empleado)");
        System.out.println(empleado.hablar());

        // Test caso de uso 5: Estado del crédito
        System.out.println("5) Test - Estado del Crédito");
        Cliente cliente = new Cliente("Carlos", "Lopez", 11223344, LocalDate.of(1995, 7, 10), "20-11223344-8", 100000f);
        System.out.println(cliente.estadoCredito());  // Debería mostrar el límite de crédito

        // Test caso de uso 6: Hablar (Cliente)
        System.out.println("6) Test - Hablar (Cliente)");
        System.out.println(cliente.hablar());
    }
}
