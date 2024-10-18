package modelo;

public class ProductoNoPerecedor extends Producto {
	private int mesesGarantia;
	private int cantidadMinima;

	public ProductoNoPerecedor(int idProducto, int codigo, String nombre, float precio, Categoria categoria,
			int cantidadDisponible, int mesesGarantia, int cantidadMinima) {
		super(idProducto, codigo, nombre, precio, categoria, cantidadDisponible);
		this.mesesGarantia = mesesGarantia;
		this.cantidadMinima = cantidadMinima;
	}

	public int getMesesGarantia() {
		return mesesGarantia;
	}

	public int getCantidadMinima() {
		return cantidadMinima;
	}

	@Override
	public boolean esNecesarioReabastecer() {
		return cantidadDisponible < cantidadMinima;
	}

	@Override
	public String toString() {
		return "ProductoNoPerecedero{" + "mesesGarantia=" + mesesGarantia + ", cantidadMinima=" + cantidadMinima + "} "
				+ super.toString();
	}

	@Override
	public boolean equals(Object o) {
	    return this == o || (o != null && getClass() == o.getClass() && super.equals(o) && mesesGarantia == ((ProductoNoPerecedor) o).mesesGarantia);
	}

}
