package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Util.Conexion;

public class CategoriasDAO {
	public static List<Categorias> mostrarCat() {
		List<Categorias>listaCat=new ArrayList<>();
		try (Connection con = Conexion.abreConexion()) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from categorias");
			while (rs.next()) {
				listaCat.add(new Categorias(rs.getInt("idcategoria"), rs.getString("nombre")));
			}
			rs.close();
		} catch (Exception ex) { 
			ex.printStackTrace();
		}finally {
			Conexion.cierraConexion();
		}
		return listaCat;
	}
	
	/**
	 * Esta funcion recive los valores de una categoria y la crea
	 * @param cat Categoria
	 */
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
