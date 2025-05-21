package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Util.Conexion;

public class PedidoProductoDAO {
	public static double sumPrecioTotal(Pedidos ped) {
		try (Connection con = Conexion.abreConexion()) {
			PreparedStatement stmt = con.prepareStatement("select sum(precio) pedidoproducto "
					+ "where idpedido=? ");
		}catch (Exception ex) { 
			ex.printStackTrace();
		}finally {
			Conexion.cierraConexion();
		}
	}
	public static void insertarPedPro(Pedidoproducto pedpro) {
		try (Connection con = Conexion.abreConexion()) {
			PreparedStatement stmt = con.prepareStatement("insert pedidoproducto (idpedido,idproducto,unidades,precio) "
					+ "values (?,?,?,?)");
			stmt.setInt(1,pedpro.getPedido().getIdpedido());
			stmt.setInt(2, pedpro.getProducto().getIdproducto());
			stmt.setInt(3, pedpro.getUnidades());
			stmt.setDouble(4, pedpro.getPrecio());
			stmt.execute();
		} catch (Exception ex) { 
			ex.printStackTrace();
		}finally {
			Conexion.cierraConexion();
		}
	}
	
	public static List<Pedidoproducto> mostrarPedFech() {
		List<Pedidoproducto> listaPed = new ArrayList<Pedidoproducto>();
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
				Clientes cli = new Clientes(0,rs.getString("cli.nombre"),"",0);
				Pedidos pedido= new Pedidos(0,cli, rs.getDouble("ped.precioTotal"), rs.getString("ped.direccionEnvio"),rs.getDate("ped.fecha"));
				Categorias cat=new Categorias(rs.getString("cat.nombre"));
				Productos producto=new Productos(cat,rs.getString("pro.nombre"),0,"","","",0);
				listaPed.add(new Pedidoproducto(pedido,producto,rs.getInt("pedpro.unidades"),0));
			}
			rs.close();
		} catch (Exception ex) { 
			ex.printStackTrace();
		}finally {
			Conexion.cierraConexion();
		}
		return listaPed;
	}
	public static List<Pedidoproducto> mostrarPedCli(Clientes cli2) {
		List<Pedidoproducto> listaPed = new ArrayList<Pedidoproducto>();
		try (Connection con = Conexion.abreConexion()) {
			PreparedStatement stmt = con.prepareStatement("select ped.fecha, ped.precioTotal, ped.direccionEnvio, cat.nombre, pro.nombre, pedpro.unidades from pedidos ped "
					+ "inner join clientes cli on ped.idcliente=cli.idcliente "
					+ "inner join pedidoproducto pedpro on ped.idpedido=pedpro.idpedido "
					+ "inner join productos pro on pedpro.idproducto=pro.idproducto "
					+ "inner join categorias cat on pro.idcategoria=cat.idcategoria "
					+ "where cli.codigo=?");
			stmt.setInt(1, cli2.getCodigo());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Clientes cli = new Clientes(0,"","",0);
				Pedidos pedido= new Pedidos(0,cli, rs.getDouble("ped.precioTotal"), rs.getString("ped.direccionEnvio"),rs.getDate("ped.fecha"));
				Categorias cat=new Categorias(rs.getString("cat.nombre"));
				Productos producto=new Productos(cat,rs.getString("pro.nombre"),0,"","","",0);
				listaPed.add(new Pedidoproducto(pedido,producto,rs.getInt("pedpro.unidades"),0));
			}
		rs.close();
	} catch (Exception ex) { 
		ex.printStackTrace();
	}finally {
		Conexion.cierraConexion();
	}
	return listaPed;
	}
}
