package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaRestaurante {
    private List<Cliente> lstClientes;
    private List<Mesa> lstMesas;
    private List<Reserva> lstReservas;

    public SistemaRestaurante() {
        this.lstClientes = new ArrayList<>();
        this.lstMesas = new ArrayList<>();
        this.lstReservas = new ArrayList<>();
    }
    

    public List<Cliente> getLstClientes() {
		return lstClientes;
	}



	public void setLstClientes(List<Cliente> lstClientes) {
		this.lstClientes = lstClientes;
	}



	public List<Mesa> getLstMesas() {
		return lstMesas;
	}



	public void setLstMesas(List<Mesa> lstMesas) {
		this.lstMesas = lstMesas;
	}



	public List<Reserva> getLstReservas() {
		return lstReservas;
	}



	public void setLstReservas(List<Reserva> lstReservas) {
		this.lstReservas = lstReservas;
	}



	// 1. Traer Cliente por DNI (Búsqueda única con while y corte de control)
    public Cliente traerCliente(long dni) {
        int i = 0;
        boolean encontrado = false;
        Cliente cliente = null;
        while (i < lstClientes.size() && !encontrado) {
            if (lstClientes.get(i).getDni() == dni) {
                cliente = lstClientes.get(i);
                encontrado = true;
            }
            i++;
        }
        return cliente;
    }

    // 2. Agregar Cliente (Cálculo automático de ID)
    public boolean agregarCliente(String nombre, String apellido, long dni, String telefono) throws Exception {
        if (traerCliente(dni) != null) {
            throw new Exception("Ya existe un cliente con el DNI proporcionado.");
        }

        int id = lstClientes.isEmpty() ? 1 : lstClientes.get(lstClientes.size() - 1).getIdCliente() + 1;
        Cliente nuevoCliente = new Cliente(id, nombre, apellido, dni, telefono);
        lstClientes.add(nuevoCliente);
        return true;
    }

    // 3. Traer Mesa por número (Búsqueda única con while)
    public Mesa traerMesa(int numeroMesa) {
        int i = 0;
        boolean encontrado = false;
        Mesa mesa = null;
        while (i < lstMesas.size() && !encontrado) {
            if (lstMesas.get(i).getNumeroMesa() == numeroMesa) {
                mesa = lstMesas.get(i);
                encontrado = true;
            }
            i++;
        }
        return mesa;
    }

    // 4. Agregar Mesa (ID calculado automáticamente)
    public boolean agregarMesa(int numeroMesa, int capacidad) throws Exception {
        if (traerMesa(numeroMesa) != null) {
            throw new Exception("Ya existe una mesa con el número proporcionado.");
        }

        int id = lstMesas.isEmpty() ? 1 : lstMesas.get(lstMesas.size() - 1).getIdMesa() + 1;
        Mesa nuevaMesa = new Mesa(id, numeroMesa, capacidad);
        lstMesas.add(nuevaMesa);
        return true;
    }


    // 6. Traer Reserva por número de mesa y fecha (Búsqueda única con while)
    public Reserva traerReserva(int numeroMesa, LocalDate fechaReserva) {
        int i = 0;
        boolean encontrado = false;
        Reserva reserva = null;
        while (i < lstReservas.size() && !encontrado) {
            Reserva r = lstReservas.get(i);
            if (r.getMesa().getNumeroMesa() == numeroMesa && r.getFechaReserva().equals(fechaReserva)) {
                reserva = r;
                encontrado = true;
            }
            i++;
        }
        return reserva;
    }
    

    // 7. Agregar Reserva (ID calculado automáticamente)
    public boolean agregarReserva(Cliente cliente, LocalDate fecha, Mesa mesa, int cantComensales) throws Exception {
        if (traerReserva(mesa.getNumeroMesa(), fecha) != null) {
            throw new Exception("La mesa ya tiene una reserva para esa fecha.");
        }

        validarComensales(cantComensales, mesa);

        int id = lstReservas.isEmpty() ? 1 : lstReservas.get(lstReservas.size() - 1).getIdReserva() + 1;
        
        Reserva nuevaReserva = new Reserva(id, cliente, fecha, mesa, cantComensales);
        lstReservas.add(nuevaReserva);
        return true;
    }


    // 8. Traer Reservas en un rango de fechas (Búsqueda múltiple con for)
    public List<Reserva> traerRes(LocalDate desde, LocalDate hasta) {
        List<Reserva> reservasEnRango = new ArrayList<>();
        for (Reserva reserva : lstReservas) {
            if (!reserva.getFechaReserva().isBefore(desde) && !reserva.getFechaReserva().isAfter(hasta)) {
                reservasEnRango.add(reserva);
            }
        }
        return reservasEnRango;
    }

    // 9. Traer Mesas libres para una fecha específica (Búsqueda múltiple con for)
    public List<Mesa> traerMesasLibreParaFecha(LocalDate fecha) {
        List<Mesa> mesasLibres = new ArrayList<>();
        for (Mesa mesa : lstMesas) {
            if (traerReserva(mesa.getNumeroMesa(), fecha) == null) {
                mesasLibres.add(mesa);
            }
        }
        return mesasLibres;
    }
  

    // Método para calcular el total de una Reserva
    public double devolverTotalReserva(Reserva reserva) {
        double total = 0;
        for (ProdPedido prodPedido : reserva.getLstProdPedido()) {
            total += prodPedido.getPrecio();
        }
        return total;
    }


    @Override
    public String toString() {
        return "SistemaRestaurante{" +
                "lstClientes=" + lstClientes +
                ", lstMesas=" + lstMesas +
                ", lstReservas=" + lstReservas +
                '}';
    }
}
