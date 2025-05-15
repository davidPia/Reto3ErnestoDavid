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
			PreparedStatement stmt = con.prepareStatement("select a.fecha, b.nombre, a.precioTotal, a.direccionEnvio, e.nombre, d.nombre, c.unidades from pedidos as a "
					+ "inner join clientes b on a.idcliente=b.idcliente "
					+ "inner join pedidoproducto c on a.idpedido=c.idpedido "
					+ "inner join productos d on c.idproducto=d.idproducto "
					+ "inner join categorias e on d.idcategoria=e.idcategoria "
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
	
	public static List<Pedidos> mostrarPedCli(Clientes cliente) {
		List<Pedidos> listaPedCli = new ArrayList<Pedidos>();
		try (Connection con = Conexion.abreConexion()) {
			PreparedStatement stmt = con.prepareStatement("select a.fecha, a.precioTotal, a.direccionEnvio, e.nombre, d.nombre, c.unidades from pedidos a "
					+ "inner join clientes b on a.idcliente=b.idcliente "
					+ "inner join pedidoproducto c on a.idpedido=c.idpedido "
					+ "inner join productos d on c.idproducto=d.idproducto "
					+ "inner join categorias e on d.idcategoria=e.idcategoria "
					+ "where b.codigo=?");
			stmt.setInt(1, cliente.getCodigo());
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
