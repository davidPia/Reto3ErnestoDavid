package Main;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



import Clases.Categorias;
import Clases.CategoriasDAO;
import Clases.Clientes;
import Clases.ClientesDAO;
import Clases.PedidoProductoDAO;
import Clases.Pedidoproducto;
import Clases.Pedidos;
import Clases.PedidosDAO;
import Clases.Productos;
import Clases.ProductosDAO;
import Util.funciones;

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
				List<Productos> mostrarProBajoStock = ProductosDAO.listarProdBajoStock();
				for (Productos productos : mostrarProBajoStock) {
					System.out.println(productos);
				}
				int numPro = funciones.dimeEntero("Introduce la cantidad en la que quieres aumentar el stock", sc);
				if (numPro>0) {
					ProductosDAO.actualizarStock(numPro);
				}
			}else if(opcion==2) {
				int codigo = funciones.dimeEntero("Introduce el codigo de un cliente", sc);
				Clientes cliente = new Clientes(codigo);
				List<Pedidoproducto> mostrarPedCli = PedidoProductoDAO.mostrarPedCli(cliente);
				for (Pedidoproducto pedidoproducto : mostrarPedCli) {
					System.out.println(pedidoproducto.toStringSinCli());
				}
			}else if(opcion==3) {
				List<Productos> productosMasVendidos = ProductosDAO.listarProdVentas();
				for (Productos productos : productosMasVendidos) {
					System.out.println(productos.toStringVentas());
				}
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
				crearPedido(sc);
				
			}else if(opcion==2) {
				List<Pedidoproducto> mostrarPedFech = PedidoProductoDAO.mostrarPedFech();
				for (Pedidoproducto Pedidoproducto : mostrarPedFech) {
					System.out.println(Pedidoproducto);
				}
			}
		}while(true);
		
	}
	public static void crearPedido(Scanner sc) {
		Clientes cliElegido=new Clientes();
		Clientes cliBuscado= new Clientes();
		Productos proElegido=new Productos();
		Productos proBuscado= new Productos();
		
		
		do {
			cliElegido.setCodigo(Util.funciones.dimeEntero("Introduce un codigo de cliente", sc));
			cliBuscado=ClientesDAO.buscarCliente(cliElegido);
			if(cliBuscado!=null) {
				break;
			}
		}while(true);
		System.out.println(cliBuscado.getNombre());
		String nombreProd="";
		
		Pedidos pedidoCreado=PedidosDAO.insertarPedido(cliBuscado);
		Pedidoproducto pedpro= new Pedidoproducto();
		do {
			
			pedpro.setPedido(pedidoCreado);
			String otro= Util.funciones.dimeString("Desea anadir un producto (si/no)", sc);
			if(otro.equalsIgnoreCase("no")) {
				break;
			}else if(otro.equalsIgnoreCase("si")){
				nombreProd=Util.funciones.dimeString("Introduce el nombre de un producto (intro para salir)", sc);
				proElegido.setNombre(nombreProd);
				
				proBuscado=ProductosDAO.buscarProTodo(proElegido);
				if(proBuscado!=null) {
					int unidadesDeseadas= Util.funciones.dimeEntero("Cuantas unidades quieres", sc);
					if(proBuscado.getStock()==0 || proBuscado.getStock()<0) {
						System.out.println("No queda ninguna unidad");
					}else {
						if(proBuscado.getStock()<unidadesDeseadas) {
							unidadesDeseadas=proBuscado.getStock(); 
						}
						proBuscado.setStock(proBuscado.getStock()-unidadesDeseadas);
						ProductosDAO.restarStock(proBuscado, unidadesDeseadas);
						pedpro.setUnidades(unidadesDeseadas);
						pedpro.setPedido(pedidoCreado);
						pedpro.setIdproducto(proBuscado);
						pedpro.setPrecio(proBuscado.getPrecio()*unidadesDeseadas);
						PedidoProductoDAO.insertarPedPro(pedpro);
					}
					
				}
			}
		}while(true);
		PedidoProductoDAO.sumPrecioTotal(pedidoCreado);
		
		
	}

	//submenu de catalogo(opcion 2)
	public static void catalogo_prod(Scanner sc) {
		List<Categorias> listaCat= new ArrayList<>();
		List<Productos> listaPro= new ArrayList<>();
		do {
			System.out.println("1-Listar productos por categoría");
			System.out.println("2-Buscar productos");
			System.out.println("3-Salir");
			int opcion=Util.funciones.dimeEntero("Elige una opcion", sc);
			if(opcion==3) {
				break;
			}
			else if(opcion==1){
				mostrarCategorias(listaCat);
				
				String nombreCat=Util.funciones.dimeString("Elige una categoria", sc);
				Categorias catElegi=new Categorias(0,nombreCat);
				listaPro=ProductosDAO.listarProdCat(catElegi);
				for (Productos productos : listaPro) {
					System.out.println(productos);
				}
			}else if(opcion==2) {
				Productos pro= new Productos();
				System.out.println("Introduzca el producto que desea buscar");
				System.out.println("Nombre: ");
				pro.setNombre(sc.nextLine());
				System.out.println("Talla: ");
				pro.setTalla(sc.nextLine());
				System.out.println("Color: ");
				pro.setColor(sc.nextLine());
				buscarProductos(listaPro, pro);
			}
		}while(true);
	}
	//submenu de mantenimientos(opcion 1)
	public static void mantenimientos(Scanner sc) {
		List<Categorias> listaCat=new ArrayList<>();
		listaCat=CategoriasDAO.mostrarCat();
		do {
			System.out.println("1-Gestión de categorías");
			System.out.println("2-Gestión de productos");
			System.out.println("3-Gestión de clientes");
			System.out.println("4-Salir");
			int opcion=Util.funciones.dimeEntero("Elige una opcion", sc);
			if(opcion==4){
				break;
			}else if(opcion==1) {
				Categorias cat=new Categorias(Util.funciones.dimeString("Introduce una nueva categoria", sc));
				Clases.CategoriasDAO.insertarCat(cat);
			}else if(opcion==2) {
				System.out.println("Introduce los datos de un producto:");
				System.out.println();
				String nombre=Util.funciones.dimeString("nombre", sc);
				double precio=Util.funciones.dimeDouble("precio", sc);
				String descripcion=Util.funciones.dimeString("descripcion ", sc);
				String color=Util.funciones.dimeString("color ", sc);
				String talla=Util.funciones.dimeString("talla ", sc);
				int stock=Util.funciones.dimeEntero("stock", sc);
				//Enseñar las categorias, elegir una y crear el producto
				mostrarCategorias(listaCat);
				int idcatElegida=0;
				Categorias catElegida= new Categorias();
				Categorias cat2=new Categorias (idcatElegida,"");
				//Compruebo que la cat existe
				do {
					idcatElegida=Util.funciones.dimeEntero("Introduce el id de una categoria", sc);
					cat2.setIdcategoria(idcatElegida);
				}while(!(listaCat.contains(cat2)));
				cat2.setIdcategoria(idcatElegida);
				
				Productos pro= new Productos(cat2,nombre,precio,descripcion,color,talla,stock);
				ProductosDAO.insertarPro(pro);
			}else if(opcion==3) {
				gestion_clientes(sc);
			}
		}while(true);
	}
	
	public static void gestion_clientes(Scanner sc) {
		List<Clientes> listaCli= new ArrayList<>();
		do {
			System.out.println("1-Alta de nuevos clientes");
			System.out.println("2-Búsqueda por código");
			System.out.println("3-Salir");
			int opcion=Util.funciones.dimeEntero("Elige una opcion", sc);
			if(opcion==3) {
				break;
			}
			else if(opcion==1){
				String nombre=Util.funciones.dimeString("Introduce un nombre", sc);
				String direccion=Util.funciones.dimeString("Introduce una direccion", sc);
				int codigo;
				Clientes cli=new Clientes();
				do {
					codigo=Util.funciones.dimeEntero("Introduce un codigo", sc);
					if(ClientesDAO.buscarCliente(cli)==null) {
						break;
					}
				}while(true);
				cli.setNombre(nombre);
				cli.setDireccion(direccion);
				cli.setCodigo(codigo);
				ClientesDAO.nuevoCliente(cli);
				
			}else if(opcion==2) {
				Clientes cliBuscar=new Clientes();
				cliBuscar.setCodigo(Util.funciones.dimeEntero("Introduce un codigo de cliente ", sc));
				Clientes clienteElegido=ClientesDAO.buscarCliente(cliBuscar);
				if(clienteElegido==null) {
					System.out.println("No existe un cliente con ese id");
				}else {
						System.out.println(clienteElegido);
						clienteElegido.setNombre(Util.funciones.dimeString("Introduce el nuevo nombre", sc));
						clienteElegido.setDireccion(Util.funciones.dimeString("Introduce la nueva direccion", sc));
						int codigo;
						do {
							codigo=Util.funciones.dimeEntero("Introduce un codigo", sc);
							if(ClientesDAO.buscarCliente(clienteElegido)==null) {
								break;
							}
						}while(true);
						clienteElegido.setCodigo(codigo);
						ClientesDAO.modificarCliente(clienteElegido);
					//CAMBIAR DATOS
						
				}
			}
		}while(true);
	}
	public static void mostrarCategorias(List<Categorias> listaCat) {
		
		for (Categorias categorias : listaCat) {
			System.out.println(categorias);
		}
	}
	public static void buscarProductos(List<Productos> listaPro,Productos pro) {
		listaPro=ProductosDAO.buscarPro(pro);
		for (Productos productos : listaPro) {
			System.out.println(productos.toStringconCat());
		}
	}
	
}
