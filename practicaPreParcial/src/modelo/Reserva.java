package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Reserva {
    private int idReserva;
    private Cliente cliente;
    private LocalDate fechaReserva;
    private Mesa mesa;
    private int cantComensales;
    private List<ProdPedido> lstProdPedido;


 // Constructor que inicializa la lista y recibe parámetros
    public Reserva(int idReserva, Cliente cliente, LocalDate fechaReserva, Mesa mesa, int cantComensales) throws Exception {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.fechaReserva = fechaReserva;
        this.mesa = mesa;
        setCantComensales(cantComensales); // validacion 
        this.lstProdPedido = new ArrayList<>(); // Inicialización de la lista
    }
    public int getIdReserva() {
        return idReserva;
    }

	public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public int getCantComensales() {
        return cantComensales;
    }

	public void setCantComensales(int cantComensales) throws Exception {
		if (cantComensales <= 0 || cantComensales > mesa.getCapacidad())throw new Exception("La cantidad de comensales debe ser mayor que 0");
		this.cantComensales = cantComensales;

	}

    public List<ProdPedido> getLstProdPedido() {
        return lstProdPedido;
    }
    
    
    
    // Método para agregar un ProdPedido a una Reserva
    public boolean agregarProdPedido(String producto, double precio) throws Exception {
       
        return lstProdPedido.add(new ProdPedido(producto, precio));
    }
    
   // 5. Validar Comensales (Validación en set de la clase)
 	private boolean validarComensales(int cantComensales, Mesa mesa) throws Exception {
 		if (cantComensales > mesa.getCapacidad()) {
 			throw new Exception("La cantidad de comensales supera la capacidad de la mesa.");
 		}
 		return true;
 	}



    // Devolver Total de la Reserva
    public double devolverTotalReserva() {
        double total = 0;
        for (ProdPedido pedido : lstProdPedido) {
            total += pedido.getPrecio();
        }
        return total;
    }

    // Redefinir toString para imprimir correctamente la Reserva
    @Override
    public String toString() {
        return "Reserva{idReserva=" + idReserva + ", cliente=" + cliente + ", fechaReserva=" + fechaReserva +
               ", mesa=" + mesa + ", cantComensales=" + cantComensales + ", totalReserva=" + devolverTotalReserva() + '}';
    }

    // Redefinir equals para comparar Reservas


    @Override
	public int hashCode() {
		return Objects.hash(cantComensales, cliente, fechaReserva, idReserva, lstProdPedido, mesa);
	}
    
    @Override
    public boolean equals(Object o) {
        boolean sonIguales = false; // Variable auxiliar para almacenar el resultado

        if (this == o) {
            sonIguales = true; // Comparación de referencia
        } else if (o != null && getClass() == o.getClass()) {
            Reserva reserva = (Reserva) o; // Cast seguro
            sonIguales = idReserva == reserva.idReserva; // Comparación de idReserva
        }

        return sonIguales; 
    }


}
