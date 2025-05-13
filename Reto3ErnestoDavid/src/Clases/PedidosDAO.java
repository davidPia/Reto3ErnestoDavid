package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import Util.Conexion;

public class PedidosDAO {

	public static void mostrarPedFech() {
		try (Connection con = Conexion.abreConexion()) {
			PreparedStatement stmt = con.prepareStatement("select * from pedidos "
					+ "where month(fecha)=?");
			int mes = LocalDate.now().getMonthValue();
			stmt.setInt(1, mes);
			stmt.execute();
		} catch (Exception ex) { 
			ex.printStackTrace();
		}finally {
			Conexion.cierraConexion();
		}
	}
}
