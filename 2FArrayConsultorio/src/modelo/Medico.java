package modelo;

public class Medico {
    private String nombre;
    private String apellido;
    private String especialidad;
    private Paciente[] pacientesFrecuentes;

    public Medico(String nombre, String apellido, String especialidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
    }



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	public float calcularIMC(Paciente paciente) {
        return paciente.traerIMC();
    }

    public String traerNombreCompleto() {
        return nombre + " " + apellido;
    }

    public String traerEspecialidad() {
        return especialidad;
    }
    
    public String traerDescripcionCompleta() {
        return "Médico: " + traerNombreCompleto() + " (Especialidad: " + especialidad + ")";
    }
    
    
    // 2FArrayConsultorio
    
     public double traerPromedioPeso() {
        double suma = 0;
        for (Paciente paciente : pacientesFrecuentes) {
            suma += paciente.getPeso();
        }
        return suma / pacientesFrecuentes.length;
    }

    public Paciente traerPacienteMayorEstatura() {
        Paciente mayorEstatura = pacientesFrecuentes[0];
        for (Paciente paciente : pacientesFrecuentes) {
            if (paciente.getEstatura() > mayorEstatura.getEstatura()) {
                mayorEstatura = paciente;
            }
        }
        return mayorEstatura;
    }

    public Paciente traerMenorIMC() {
        Paciente menorIMC = pacientesFrecuentes[0];
        for (Paciente paciente : pacientesFrecuentes) {
            if (calcularIMC(paciente) < calcularIMC(menorIMC)) {
                menorIMC = paciente;
            }
        }
        return menorIMC;
    }
}



