package test;

import modelo.Medico;
import modelo.Paciente;

public class TestConsultorio {
    public static void main(String[] args) {
        Medico medico = new Medico("Daniel", "López", "General");

        Paciente paciente1 = new Paciente("José", "Pérez", 1.80f, 85);
        Paciente paciente2 = new Paciente("Jorge", "Fernández", 1.72f, 105);
        Paciente paciente3 = new Paciente("José", "Pérez", 1.80f, 85);

        System.out.println("Pacientes:");
        System.out.println(paciente1.traerNombreCompleto());
        System.out.println(paciente2.traerNombreCompleto());

        // Visita 1
        System.out.println("Visita 1:");
        System.out.println(medico.traerDescripcionCompleta());
        System.out.println(paciente1.traerNombreCompleto() + ": IMC " + medico.calcularIMC(paciente1));
        System.out.println(paciente2.traerNombreCompleto() + ": IMC " + medico.calcularIMC(paciente2));

        // Modificar pesos
        paciente1.setPeso(75);
        paciente2.setPeso(95);

        // Visita 2
        System.out.println("\nVisita 2:");
        System.out.println(medico.traerDescripcionCompleta());
        System.out.println(paciente1.traerNombreCompleto() + ": IMC " + medico.calcularIMC(paciente1));
        System.out.println(paciente2.traerNombreCompleto() + ": IMC " + medico.calcularIMC(paciente2));
        
        
        //2F
        
        
        System.out.println("\nVisita 2FArrayConsultorio:");
       

        // Test de calcularIMC
        System.out.println(paciente3.traerNombreCompleto() + ": IMC " + medico.calcularIMC(paciente3));

        // Test de traerPromedioPeso
        System.out.println("Promedio de peso: " + medico.traerPromedioPeso());

        // Test de traerPacienteMayorEstatura
        System.out.println("Paciente con mayor estatura: " + medico.traerPacienteMayorEstatura().traerNombreCompleto());

        // Test de traerMenorIMC
        System.out.println("Paciente con menor IMC: " + medico.traerMenorIMC().traerNombreCompleto());
        
        
    }
}