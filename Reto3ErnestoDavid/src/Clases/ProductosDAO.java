package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Util.Conexion;

public class ProductosDAO {
	public static List<Productos> listarProdCat(Categorias cat) {
		List<Productos> listaProd = new ArrayList<>();

		try (Connection con = Conexion.abreConexion()) {
			PreparedStatement stmt = con.prepareStatement("select * from productos a "
					+ "inner join categorias b on a.idcategoria=b.idcategoria "
					+ "where b.nombre=?");
			stmt.setString(1, cat.getNombre());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				listaProd.add(new Productos(rs.getInt("idcategoria"), rs.getString("nombre"), rs.getDouble("precio"),
						rs.getString("descripcion"), rs.getString("color"), rs.getString("talla"), rs.getInt("stock")));
			}
		} catch (Exception ex) {

			ex.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}
		return listaProd;
	}

	public static List<Productos> buscarPro(Productos pro) {
		List<Productos> listaPro = new ArrayList<>();
		int contador=0;
		String sql = "select * from productos where 1=1 ";
		try (Connection con = Conexion.abreConexion()) {
			if (!(pro.getNombre().equals(""))) {
				sql = sql.concat("and nombre=?");
				contador=contador+1;
			}
			if (!(pro.getTalla().equals(""))) {
				sql = sql.concat("and talla=?");
				contador=contador+4;
			}
			if (!(pro.getColor().equals(""))) {
				sql = sql.concat("and color=?");
				contador=contador+6;
			}
			System.out.println(sql);
			PreparedStatement stmt = con.prepareStatement(sql);
			if(contador==1) {
				stmt.setString(1,pro.getNombre());
			}else if(contador==4) {
				stmt.setString(1,pro.getTalla());
			}else if(contador==6) {
				stmt.setString(1,pro.getColor());
			}else if(contador==5) {
				stmt.setString(1,pro.getNombre());
				stmt.setString(2,pro.getTalla());
			}else if(contador==11) {
				stmt.setString(1,pro.getNombre());
				stmt.setString(2,pro.getTalla());
				stmt.setString(3,pro.getColor());
			}else if(contador==7) {
				stmt.setString(1,pro.getNombre());
				stmt.setString(2,pro.getColor());
			}else if(contador==10) {
				stmt.setString(2,pro.getTalla());
				stmt.setString(3,pro.getColor());
			}
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				listaPro.add(new Productos(rs.getInt("idcategoria"), rs.getString("nombre"), rs.getDouble("precio"),
						rs.getString("descripcion"), rs.getString("color"), rs.getString("talla"), rs.getInt("stock")));
			}
		}catch(Exception ex ){
			ex.printStackTrace();
		}finally{
			Conexion.cierraConexion();
		}
		return listaPro;
			
	}

	public static void insertarPro(Productos pro) {
		try (Connection con = Conexion.abreConexion()) {
			PreparedStatement stmt = con.prepareStatement(
					"insert into productos(idcategoria, nombre, precio, descripcion, color, talla, stock) "
							+ "values(?,?,?,?,?,?,?)");
			stmt.setInt(1, pro.getIdcategoria());
			stmt.setString(2, pro.getNombre());
			stmt.setDouble(3, pro.getPrecio());
			stmt.setString(4, pro.getDescripcion());
			stmt.setString(5, pro.getColor());
			stmt.setString(6, pro.getTalla());
			stmt.setInt(7, pro.getStock());
			stmt.execute();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}
	}
}
