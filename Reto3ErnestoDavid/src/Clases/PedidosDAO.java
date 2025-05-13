package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Util.Conexion;

public class PedidosDAO {

	public static List<Pedidos> mostrarPedFech() {
		List<Pedidos> listaPedFech = new ArrayList<Pedidos>();
		try (Connection con = Conexion.abreConexion()) {
			PreparedStatement stmt = con.prepareStatement("select * from pedidos "
					+ "where month(fecha)=?");
			int mes = LocalDate.now().getMonthValue();
			stmt.setInt(1, mes);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				listaPedFech.add(new Pedidos(rs.getInt("idpedido"), rs.getInt("idcliente"), rs.getDouble("precioTotal"), rs.getString("direccionEnvio"), rs.getDate("fecha")));
			}
			rs.close();
		} catch (Exception ex) { 
			ex.printStackTrace();
		}finally {
			Conexion.cierraConexion();
		}
		return listaPedFech;
	}
	
	public static List<Pedidos> mostrarPedCli() {
		List<Pedidos> listaPedCli = new ArrayList<Pedidos>();
		try (Connection con = Conexion.abreConexion()) {
			PreparedStatement stmt = con.prepareStatement("select * from pedidos "
					+ "inner join clientes b on a.idcliente=b.idcliente "
					+ "where b.codigo=?");
			int mes = LocalDate.now().getMonthValue();
			stmt.setInt(1, mes);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				listaPedCli.add(new Pedidos(rs.getInt("idpedido"), rs.getInt("idcliente"), rs.getDouble("precioTotal"), rs.getString("direccionEnvio"), rs.getDate("fecha")));
			}
			rs.close();
		} catch (Exception ex) { 
			ex.printStackTrace();
		}finally {
			Conexion.cierraConexion();
		}
		return listaPedCli;
	}
}
