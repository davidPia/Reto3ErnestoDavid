package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Util.Conexion;

public class ClientesDAO {
	public static void modificarCliente(Clientes cli) {
		try (Connection con = Conexion.abreConexion()) {
			PreparedStatement stmt = con.prepareStatement("update clientes "
					+ "set nombre=?, direccion=?, codigo=? "
					+ "where idcliente=?");
			stmt.setString(1, cli.getNombre());
			stmt.setString(2, cli.getDireccion());
			stmt.setInt(3,cli.getCodigo());
			stmt.setInt(4, cli.getIdcliente());
			stmt.executeUpdate();
	} catch (Exception ex) { 
		ex.printStackTrace();
	}finally {
		Conexion.cierraConexion();
	}
	}
	public static  Clientes buscarCliente(Clientes cli) {
		Clientes clienteNuevo= new Clientes();
		try (Connection con = Conexion.abreConexion()) {
			PreparedStatement stmt = con.prepareStatement("select * from clientes "
					+ "where codigo=?");
			stmt.setInt(1,cli.getCodigo());
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				clienteNuevo=(new Clientes(rs.getInt("idcliente"),rs.getString("nombre"),rs.getString("direccion"),rs.getInt("codigo")));
				return clienteNuevo;
			}else {
				return null;
			}
		} catch (Exception ex) { 
			ex.printStackTrace();
		}finally {
			Conexion.cierraConexion();
		}
		return null;
		
	}
	public static void nuevoCliente(Clientes cli) {
		try (Connection con = Conexion.abreConexion()) {
			PreparedStatement stmt = con.prepareStatement("insert into clientes(nombre, direccion, codigo)\r\n"
					+ "values(?,?,?);");
			stmt.setString(1,cli.getNombre());
			stmt.setString(2, cli.getDireccion());
			stmt.setInt(3, cli.getCodigo());
		
			stmt.execute();
		} catch (Exception ex) { 
			ex.printStackTrace();
		}finally {
			Conexion.cierraConexion();
		}
	}
	
}
