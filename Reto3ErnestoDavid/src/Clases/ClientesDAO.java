package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Util.Conexion;

public class ClientesDAO {
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
