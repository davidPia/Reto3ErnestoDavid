package Clases;

public class Pedidoproducto {

	protected int idpedidoproducto;
	protected int idpedido;
	protected int idproducto;
	protected int unidades;
	protected double precio;
	
	public Pedidoproducto() {
		super();
	}

	public Pedidoproducto(int idpedidoproducto, int idpedido, int idproducto, int unidades, double precio) {
		super();
		this.idpedidoproducto = idpedidoproducto;
		this.idpedido = idpedido;
		this.idproducto = idproducto;
		this.unidades = unidades;
		this.precio = precio;
	}

	public int getIdpedidoproducto() {
		return idpedidoproducto;
	}

	public void setIdpedidoproducto(int idpedidoproducto) {
		this.idpedidoproducto = idpedidoproducto;
	}

	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Pedidoproducto [idpedidoproducto=" + idpedidoproducto + ", idpedido=" + idpedido + ", idproducto="
				+ idproducto + ", unidades=" + unidades + ", precio=" + precio + "]";
	}
	
}
