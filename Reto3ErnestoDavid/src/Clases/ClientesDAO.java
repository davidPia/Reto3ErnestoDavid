package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Util.Conexion;

public class ClientesDAO {
	public static List<Clientes> buscarCliente(Clientes cli) {
		List<Clientes>listaCli= new ArrayList<>();
		try (Connection con = Conexion.abreConexion()) {
			PreparedStatement stmt = con.prepareStatement("select * from clientes "
					+ "where idcliente=?");
			stmt.setInt(1,cli.getIdcliente());
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				listaCli.add(new Clientes(rs.getInt("idcliente"),rs.getString("nombre"),rs.getString("direccion"),rs.getInt("codigo")));
			}
			rs.close();
		} catch (Exception ex) { 
			ex.printStackTrace();
		}finally {
			Conexion.cierraConexion();
		}
		return listaCli;
		
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
