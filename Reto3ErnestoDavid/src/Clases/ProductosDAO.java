package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Util.Conexion;

public class ProductosDAO {
	public static void insertarCat(Productos pro) {
		try (Connection con = Conexion.abreConexion()) {
			PreparedStatement stmt = con.prepareStatement("insert into productos(idcategoria, nombre, precio, descripcion, color, talla, stock)\r\n"
					+ "values(?,?,?,?,?,?,?)");
			stmt.setInt(1,pro.getIdcategoria());
			stmt.setString(2,pro.getNombre());
			stmt.setDouble(3,pro.getPrecio());
			stmt.setString(4,pro.getDescripcion());
			stmt.setString(5,pro.getColor());
			stmt.setString(6,pro.getTalla());
			stmt.setInt(7,pro.getStock());
			stmt.execute();
		} catch (Exception ex) { 
			ex.printStackTrace();
		}finally {
			Conexion.cierraConexion();
		}
	}
}
