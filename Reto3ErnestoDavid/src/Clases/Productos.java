package Clases;

public class Productos {

	protected int idproducto;
	protected Categorias categoria;
	protected String nombre;
	protected double precio;
	protected String descripcion;
	protected String color;
	protected String talla;
	protected int stock;
	
	public Productos() {
		super();
	}
	
	
	public Productos(Categorias categoria, String nombre, int stock) {
		super();
		this.categoria = categoria;
		this.nombre = nombre;
		this.stock = stock;
	}


	public Productos(Categorias categoria, String nombre, double precio, String descripcion, String color, String talla,
			int stock) {
		super();
		this.categoria = categoria;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.color = color;
		this.talla = talla;
		this.stock = stock;
	}

	public Productos(int idproducto, Categorias categoria, String nombre, double precio, String descripcion, String color,
			String talla, int stock) {
		super();
		this.idproducto = idproducto;
		this.categoria = categoria;
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

	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
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
		return  nombre+ " | " + precio + " | " + descripcion + " | " + color + " | " + talla
				+ " | " + stock;
	}
	
	public String toStringconCat() {
		return categoria.getIdcategoria()+ " / " + nombre+ " / " + precio + " / " + descripcion + " / " + color + " / " + talla
				+ " / " + stock;
	}
	
	public String toStringVentas() {
		return categoria.getNombre()+" / "+nombre+" / "+stock;
	}
} 
