package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Util.Conexion;

public class PedidoProductoDAO {
	public static List<Pedidoproducto> mostrarPedFech() {
		List<Pedidoproducto> listaPedFech = new ArrayList<Pedidoproducto>();
		try (Connection con = Conexion.abreConexion()) {
			PreparedStatement stmt = con.prepareStatement("select ped.fecha, cli.nombre, ped.precioTotal, ped.direccionEnvio, cat.nombre, pro.nombre, pedpro.unidades from pedidos as ped "
					+ "inner join clientes cli on ped.idcliente=cli.idcliente "
					+ "inner join pedidoproducto pedpro on ped.idpedido=pedpro.idpedido "
					+ "inner join productos pro on pedpro.idproducto=pro.idproducto "
					+ "inner join categorias cat on pro.idcategoria=cat.idcategoria "
					+ "where month(fecha)=?");
			int mes = LocalDate.now().getMonthValue();
			stmt.setInt(1, mes);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Clientes cli = new Clientes(0,rs.getString("nombre"),"",0);
				Pedidos pedido= new Pedidos(rs.getInt("idpedido"),cli, rs.getDouble("precioTotal"), rs.getString("direccionEnvio"),rs.getDate("fecha"));
				Categorias cat=new Categorias(rs.getString("nombre"));
				Productos producto=new Productos(cat,rs.getString("nombre"),0,"","","",0);
				listaPedFech.add(new Pedidoproducto(pedido,producto,rs.getInt("unidades"),0));
			}
			rs.close();
		} catch (Exception ex) { 
			ex.printStackTrace();
		}finally {
			Conexion.cierraConexion();
		}
		return listaPedFech;
	}
	public static List<Pedidoproducto> mostrarPedFech() {
		List<Pedidoproducto> listaPedFech = new ArrayList<Pedidoproducto>();
		try (Connection con = Conexion.abreConexion()) {
			PreparedStatement stmt = con.prepareStatement();
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
			}
		rs.close();
	} catch (Exception ex) { 
		ex.printStackTrace();
	}finally {
		Conexion.cierraConexion();
	}
	return listaPedFech;
	}
}
