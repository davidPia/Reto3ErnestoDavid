package Clases;

public class Pedidoproducto {

	protected int idpedidoproducto;
	protected Pedidos pedido;
	protected Productos producto;
	protected int unidades;
	protected double precio;
	
	public Pedidoproducto() {
		super();
	}
	
	public Pedidoproducto(Pedidos pedido, Productos producto, int unidades, double precio) {
		super();
		this.pedido = pedido;
		this.producto = producto;
		this.unidades = unidades;
		this.precio = precio;
	}

	public Pedidoproducto(int idpedidoproducto, Pedidos pedido, Productos producto, int unidades, double precio) {
		super();
		this.idpedidoproducto = idpedidoproducto;
		this.pedido = pedido;
		this.producto = producto;
		this.unidades = unidades;
		this.precio = precio;
	}

	public int getPedidoproducto() {
		return idpedidoproducto;
	}

	public void setPedidoproducto(int idpedidoproducto) {
		this.idpedidoproducto = idpedidoproducto;
	}

	public Pedidos getPedido() {
		return pedido;
	}

	public void setPedido(Pedidos pedido) {
		this.pedido = pedido;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setIdproducto(Productos producto) {
		this.producto = producto;
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
		return pedido.getFecha()+" | "+pedido.getCliente().getNombre() +" |  "+ pedido.getPrecioTotal()+" | "+pedido.getDireccionEnvio()+ " | "+ producto.getCategoria().getNombre() + " | " + producto.getNombre() +" | "+ unidades;
	}
	public String toStringSinCli() {
		return  pedido.getFecha()+" | "+pedido.getPrecioTotal()+" | "+pedido.getDireccionEnvio()+" | "+producto.getCategoria().getNombre() +" | " + producto.getNombre() +" | "+unidades;
	}
}
