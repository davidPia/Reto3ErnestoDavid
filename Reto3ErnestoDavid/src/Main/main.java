package Main;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		menuPrincipal(sc);
	}
	public static void menuPrincipal(Scanner sc) {
		int opcion=sc.nextInt();
		do {
			if(opcion==5) {
				break;
			}else if(opcion==1) {
				mantenimientos(sc);
			}else if(opcion==2) {
				catalogo_prod(sc);
			}
		}while(true);
	}
	public static void catalogo_prod(Scanner sc) {
		int opcion=sc.nextInt();
		do {
			if(opcion==3) {
				break;
			}
			else if(opcion==1){
				
			}else if(opcion==2) {
				
			}
		}while(true);
	}
	public static void mantenimientos(Scanner sc) {
		int opcion=sc.nextInt();
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
		int opcion=sc.nextInt();
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
