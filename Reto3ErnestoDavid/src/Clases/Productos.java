package Clases;

public class Productos {

	protected int idproducto;
	protected int idcategoria;
	protected String nombre;
	protected double precio;
	protected String descripcion;
	protected String color;
	protected String talla;
	protected int stock;
	
	public Productos() {
		super();
	}

	public Productos(int idproducto, int idcategoria, String nombre, double precio, String descripcion, String color,
			String talla, int stock) {
		super();
		this.idproducto = idproducto;
		this.idcategoria = idcategoria;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.color = color;
		this.talla = talla;
		this.stock = stock;
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public int getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Productos [idproducto=" + idproducto + ", idcategoria=" + idcategoria + ", nombre=" + nombre
				+ ", precio=" + precio + ", descripcion=" + descripcion + ", color=" + color + ", talla=" + talla
				+ ", stock=" + stock + "]";
	}
	
}
