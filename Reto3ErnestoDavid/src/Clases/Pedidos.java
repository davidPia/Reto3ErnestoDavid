package Clases;

import java.util.Date;

public class Pedidos {

	protected int idpedido;
	protected Clientes idcliente;
	protected double precioTotal;
	protected String direccionEnvio;
	protected Date fecha;
	
	public Pedidos() {
		super();
	}

	public Pedidos(int idpedido, Clientes idcliente, double precioTotal, String direccionEnvio, Date fecha) {
		super();
		this.idpedido = idpedido;
		this.idcliente = idcliente;
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

	public Clientes getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Clientes idcliente) {
		this.idcliente = idcliente;
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
		return "Pedidos [idpedido=" + idpedido + ", idcliente=" + idcliente + ", precioTotal=" + precioTotal
				+ ", direccionEnvio=" + direccionEnvio + ", fecha=" + fecha + "]";
	}
	
}
