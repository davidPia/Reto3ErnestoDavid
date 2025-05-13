package Main;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Clases.Categorias;
import Clases.CategoriasDAO;
import Clases.Clientes;
import Clases.ClientesDAO;
import Clases.Productos;

public class main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		menuPrincipal(sc);
	}
	public static void menuPrincipal(Scanner sc) {
		do {
			System.out.println("1-Mantenimientos");
			System.out.println("2-Catalogo de productos");
			System.out.println("3-Pedidos");
			System.out.println("4-Informes");
			System.out.println("5-Salir");
			int opcion=Util.funciones.dimeEntero("Elige una opcion", sc);
			if(opcion==5) {
				break;
			}else if(opcion==1) {
				mantenimientos(sc);
			}else if(opcion==2) {
				catalogo_prod(sc);
			}else if(opcion==3) {
				pedidos(sc);
			}else if(opcion==4) {
				informes(sc);
			}
		}while(true);
	}
	//submenu de informes(opcion 4)
	public static void informes(Scanner sc) {
		
		do {
			System.out.println("1- Bajo stock");
			System.out.println("2-Pedidos por cliente");
			System.out.println("3-Productos más vendido");
			System.out.println("4-Salir");
			int opcion=Util.funciones.dimeEntero("Elige una opcion", sc);
			if(opcion==4) {
				break;
			}
			else if(opcion==1) {
				
			}else if(opcion==2) {
				
			}else if(opcion==3) {
				
			}
		}while(true);
		
	}
	//submenu de pedidos(opcion 3)
	public static void pedidos(Scanner sc) {
		
		do {
			System.out.println("1-Crear pedido");
			System.out.println("2-Ver pedidos");
			System.out.println("3-Salir");
			int opcion=Util.funciones.dimeEntero("Elige una opcion", sc);
			if(opcion==3){
				break;
			}else if(opcion==1) {
				
			}else if(opcion==2) {
				
			}
		}while(true);
		
	}
	//submenu de catalogo(opcion 2)
	public static void catalogo_prod(Scanner sc) {
		
		do {
			System.out.println("1-Listar productos por categoría");
			System.out.println("2-Buscar productos");
			System.out.println("3-Salir");
			int opcion=Util.funciones.dimeEntero("Elige una opcion", sc);
			if(opcion==3) {
				break;
			}
			else if(opcion==1){
				
			}else if(opcion==2) {
				
			}
		}while(true);
	}
	//submenu de mantenimientos(opcion 1)
	public static void mantenimientos(Scanner sc) {
		List<Categorias> listaCat=new ArrayList<>();
		do {
			System.out.println("1-Gestión de categorías");
			System.out.println("2-Gestión de productos");
			System.out.println("3-Gestión de clientes");
			System.out.println("4-Salir");
			int opcion=Util.funciones.dimeEntero("Elige una opcion", sc);
			if(opcion==4){
				break;
			}else if(opcion==1) {
				System.out.println("Introduce una nueva categoria");
				Categorias cat=new Categorias(sc.nextLine());
				Clases.CategoriasDAO.insertarCat(cat);
			}else if(opcion==2) {
				System.out.println("Introduce los datos de un producto:");
				System.out.println("nombre");
				String nombre=sc.nextLine();
				double precio=Util.funciones.dimeDouble("precio", sc);
				System.out.println("descripcion ");
				String descripcion=sc.nextLine();
				System.out.println("color ");
				String color=sc.nextLine();
				System.out.println("talla ");
				String talla=sc.nextLine();
				int stock=Util.funciones.dimeEntero("stock", sc);
				//Enseñar las categorias, elegir una y crear el producto
				listaCat=CategoriasDAO.mostrarCat();
				for (Categorias categorias : listaCat) {
					System.out.println(categorias);
				}
				int idcatElegida;
				Categorias catElegida= new Categorias();
				//Compruebo que la cat existe
				do {
					idcatElegida=Util.funciones.dimeEntero("Introduce el id de una categoria", sc);
				}while(!(listaCat.contains(idcatElegida)));
				
				Productos pro= new Productos(idcatElegida,nombre,precio,descripcion,color,talla,stock);
				
			}else if(opcion==3) {
				gestion_clientes(sc);
			}
		}while(true);
	}
	public static void gestion_clientes(Scanner sc) {
		do {
			System.out.println("1-Alta de nuevos clientes");
			System.out.println("2-Búsqueda por código");
			System.out.println("3-Salir");
			int opcion=Util.funciones.dimeEntero("Elige una opcion", sc);
			if(opcion==3) {
				break;
			}
			else if(opcion==1){
				System.out.println("Introduce un nombre");
				String nombre=sc.nextLine();
				System.out.println("Introduce una direccion");
				String direccion=sc.nextLine();
				int codigo=Util.funciones.dimeEntero("Introduce un codigo", sc);
				Clientes cli= new Clientes(nombre,direccion,codigo);
				ClientesDAO.nuevoCliente(cli);
			}else if(opcion==2) {
				
			}
		}while(true);
	}

}
