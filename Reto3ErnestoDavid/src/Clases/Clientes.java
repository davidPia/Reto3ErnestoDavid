package Clases;

public class Clientes {

	protected int idcliente;
	protected String nombre;
	protected String direccion;
	protected int codigo;
	
	public Clientes() {
		super();
	}
	
	
	public Clientes(int codigo) {
		super();
		this.codigo = codigo;
	}


	public Clientes(String nombre, String direccion, int codigo) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.codigo = codigo;
	}

	public Clientes(int idcliente, String nombre, String direccion, int codigo) {
		super();
		this.idcliente = idcliente;
		this.nombre = nombre;
		this.direccion = direccion;
		this.codigo = codigo;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return idcliente + "-" + nombre + " / " + direccion + " - "	+ codigo;
	}
	
	
}
