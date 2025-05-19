
package Util;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;



public class funciones {
	public static boolean esInt(String s) {

		try {
			int i = Integer.parseInt(s);
			return true;
		} catch (Exception ex) {
			return false;
		}

	}

	public static boolean esDouble(String s) {

		try {
			Double i = Double.parseDouble(s);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public static int dimeEntero(String texto, Scanner sc) {
		do {
			try {
				System.out.println(texto);
				String s1 = sc.nextLine();
				int num = Integer.parseInt(s1);
				return num;
			} catch (Exception ex) {
				System.out.println("Introduce un formato valido");
			}
		} while (true);
	}

	public static double dimeDouble(String texto, Scanner sc) {
		do {
			try {
				System.out.println(texto);
				String s1 = sc.nextLine();
				Double num = Double.parseDouble(s1);
				return num;
			} catch (Exception ex) {
				System.out.println("Introduce un formato valido");
			}
		} while (true);
	}
	public static LocalDate dimeFecha(String texto, Scanner sc) {
		DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		do {
			try {
				System.out.println(texto);
				String fecha_s = sc.nextLine();
				LocalDate ld = LocalDate.parse(fecha_s, formato1);
				return ld;
			} catch (Exception ex) {
				System.out.println("Introduce una fecha valida");

			}
		} while (true);

	}
	public static boolean esPrimo(int num) {
		for (int i = num - 1; i > 1; i--) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	public static void muestraListaInt(List<Integer> lista) {
		for (int i = 0; i < lista.size(); i++) {
			System.out.print(i == 0 ? lista.get(i) : ", " + lista.get(i));
		}
		System.out.println();
	}
	public static String dimeString(String texto,Scanner sc) {
		String s;
		do {
			System.out.println(texto);
			s=sc.nextLine().trim();
		}while(s.isEmpty());
		return s;
	}
	
	public static  double redondea(double num) {
		return Math.round(num*100)/(double)100;
	}
	public static Date convierte_String_a_Date(String fecha)
    {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.setLenient(false);
    		return sdf.parse(fecha);
		} catch (Exception e) {
			return null;
		}
    }
	
	
	//de Date a String
	public static String convierte_Date_a_String(Date fDate)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(fDate);
	}
	
	//de Date a LocalDate
	public static LocalDate convierte_Date_a_LocalDate(Date fDate)
	{
		return fDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	//de LocalDate a Date
	public static Date convierte_LocalDate_a_Date(LocalDate fLocalDate)
	{
		java.util.Date d = Date.from(fLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		return new Date(d.getTime());
	}

}


