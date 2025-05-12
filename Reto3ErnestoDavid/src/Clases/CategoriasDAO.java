package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Util.Conexion;

public class CategoriasDAO {
	public static void insertarCat(Categorias cat) {
		try (Connection con = Conexion.abreConexion()) {
			PreparedStatement stmt = con.prepareStatement("Insert into categorias(nombre) values (?)");
			stmt.setString(1,cat.getNombre());
			stmt.execute();
		} catch (Exception ex) { 
			ex.printStackTrace();
		}finally {
			Conexion.cierraConexion();
		}
	}
}
