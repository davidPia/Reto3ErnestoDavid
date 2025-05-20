package Clases;

import java.util.Date;

public class Pedidos {

	protected int idpedido;
	protected Clientes cliente;
	protected double precioTotal;
	protected String direccionEnvio;
	protected Date fecha;
	
	public Pedidos() {
		super();
	}
	
	public Pedidos(int idpedido, double precioTotal, String direccionEnvio, Date fecha) {
		super();
		this.idpedido = idpedido;
		this.precioTotal = precioTotal;
		this.direccionEnvio = direccionEnvio;
		this.fecha = fecha;
	}

	public Pedidos(int idpedido, Clientes cliente, double precioTotal, String direccionEnvio, Date fecha) {
		super();
		this.idpedido = idpedido;
		this.cliente = cliente;
		this.precioTotal = precioTotal;
		this.direccionEnvio = direccionEnvio;
		this.fecha = fecha; 
	}

	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes idcliente) {
		this.cliente = idcliente;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public String getDireccionEnvio() {
		return direccionEnvio;
	}

	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Pedidos [idpedido=" + idpedido + ", idcliente=" + cliente + ", precioTotal=" + precioTotal
				+ ", direccionEnvio=" + direccionEnvio + ", fecha=" + fecha + "]";
	}
	
}
