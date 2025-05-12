package Main;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		menuPrincipal(sc);
	}
	public static void menuPrincipal(Scanner sc) {
		int opcion=Util.funciones.dimeEntero("Elige una opcion", sc);
		do {
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
		int opcion=Util.funciones.dimeEntero("Elige una opcion", sc);
		if(opcion==1) {
			
		}else if(opcion==2) {
			
		}else if(opcion==3) {
			
		}
	}
	//submenu de pedidos(opcion 3)
	public static void pedidos(Scanner sc) {
		int opcion=Util.funciones.dimeEntero("Elige una opcion", sc);
		if(opcion==1) {
			
		}else if(opcion==2) {
			
		}
	}
	//submenu de catalogo(opcion 2)
	public static void catalogo_prod(Scanner sc) {
		int opcion=Util.funciones.dimeEntero("Elige una opcion", sc);
		do {
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
		int opcion=Util.funciones.dimeEntero("Elige una opcion", sc);
		do {
			if(opcion==4){
				break;
			}else if(opcion==1) {
				
			}else if(opcion==2) {
				
			}else if(opcion==3) {
				gestion_clientes(sc);
			}
		}while(true);
	}
	public static void gestion_clientes(Scanner sc) {
		int opcion=Util.funciones.dimeEntero("Elige una opcion", sc);
		do {
			if(opcion==3) {
				break;
			}
			else if(opcion==1){
				
			}else if(opcion==2) {
				
			}
		}while(true);
	}

}
