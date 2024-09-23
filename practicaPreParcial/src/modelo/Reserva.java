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
    public Reserva(int idReserva, Cliente cliente, LocalDate fechaReserva, Mesa mesa, int cantComensales) {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.fechaReserva = fechaReserva;
        this.mesa = mesa;
        this.cantComensales = cantComensales;
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
        if (cantComensales > 0) {
            this.cantComensales = cantComensales;
        } else {
            throw new Exception("La cantidad de comensales debe ser mayor que 0");
        }
    }

    public List<ProdPedido> getLstProdPedido() {
        return lstProdPedido;
    }

    public boolean agregarProdPedido(String prodPedido, double precio) throws Exception {
        // Validar precio
        if (precio <= 0) {
            throw new Exception("El precio del producto debe ser mayor a 0.");
        }

        // Comprobar si el producto ya existe en la lista
        for (ProdPedido prod : lstProdPedido) {
            if (prod.getProducto().equals(prodPedido)) {
                throw new Exception("El producto " + prodPedido + " ya existe en la lista.");
            }
        }

        // Crear y agregar el nuevo producto pedido
        ProdPedido nuevoProdPedido = new ProdPedido(prodPedido, precio);
        lstProdPedido.add(nuevoProdPedido);

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
    public boolean equals(Object o) {
        if (this == o) return true; // Comparación de referencia
        if (o == null || getClass() != o.getClass()) return false; // Verifica tipo y nulidad
        Reserva reserva = (Reserva) o; // Cast seguro
        return idReserva == reserva.idReserva; // Comparación de idReserva
    }


    @Override
    public int hashCode() {
        return Objects.hash(idReserva);
    }
}
