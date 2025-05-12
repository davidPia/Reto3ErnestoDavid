package Clases;

public class Categorias {

	protected  int idcategoria;
	protected String nombre;
	
	public Categorias() {
		super();
	}
	
	public Categorias(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Categorias(int idcategoria, String nombre) {
		super();
		this.idcategoria = idcategoria;
		this.nombre = nombre;
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

	@Override
	public String toString() {
		return "Categorias [idcategoria=" + idcategoria + ", nombre=" + nombre + "]";
	}
	
	
}
