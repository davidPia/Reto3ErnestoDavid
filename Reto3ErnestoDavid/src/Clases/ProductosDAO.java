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
				Categorias cat3= new Categorias(rs.getInt("idcategoria"),"");
				listaProd.add(new Productos(cat3, rs.getString("nombre"), rs.getDouble("precio"),
						rs.getString("descripcion"), rs.getString("color"), rs.getString("talla"), rs.getInt("stock")));
			}
		} catch (Exception ex) {

			ex.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}
		return listaProd;
	}
	public static  Productos buscarProTodo(Productos pro) {
		Productos proElegido = null;
		try (Connection con = Conexion.abreConexion()) {
			PreparedStatement stmt = con.prepareStatement("select * from productos "
					+ "where nombre='?'");
			stmt.setString(1, pro.getNombre());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Categorias cat=new Categorias(rs.getInt("idcategoria"),"");
				proElegido=new Productos(cat,rs.getString("nombre"),rs.getDouble("precio"),rs.getString("descripcion"),rs.getString("color"),rs.getString("talla"),rs.getInt("stock"));
			}
		} catch (Exception ex) {

			ex.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}
		return proElegido;
	}
	
	
	
	
	public static List<Productos> buscarPro(Productos pro) {
		List<Productos> listaPro = new ArrayList<>();
		int contador=1;
		String sql = "select * from productos where 1=1 ";
		try (Connection con = Conexion.abreConexion()) {
			if (!(pro.getNombre().equals(""))) {
				sql = sql.concat("and nombre=?");
				
			}
			if (!(pro.getTalla().equals(""))) {
				sql = sql.concat("and talla=?");
				
			}
			if (!(pro.getColor().equals(""))) {
				sql = sql.concat("and color=?");
				
			}
		
			PreparedStatement stmt = con.prepareStatement(sql);
			if (!(pro.getNombre().equals(""))) {
				stmt.setString(contador++,pro.getNombre());
				
			}
			if (!(pro.getTalla().equals(""))) {
				stmt.setString(contador++,pro.getTalla());
			}if (!(pro.getColor().equals(""))) {
				stmt.setString(contador,pro.getColor());
			}
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Categorias cat= new Categorias(rs.getInt("idcategoria"),"");
				listaPro.add(new Productos(cat, rs.getString("nombre"), rs.getDouble("precio"),
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
			stmt.setInt(1, pro.getCategoria().getIdcategoria());
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
	
	public static List<Productos> listarProdBajoStock() {
		List<Productos> listaProd = new ArrayList<>();

		try (Connection con = Conexion.abreConexion()) {
			PreparedStatement stmt = con.prepareStatement("select * from productos "
					+ "where stock<5");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Categorias cat3= new Categorias(rs.getInt("idcategoria"),"");
				listaProd.add(new Productos(cat3, rs.getString("nombre"), rs.getDouble("precio"),
						rs.getString("descripcion"), rs.getString("color"), rs.getString("talla"), rs.getInt("stock")));
			}
		} catch (Exception ex) {

			ex.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}
		return listaProd;
	}
	
	public static void actualizarStock(int num) {
		try (Connection con = Conexion.abreConexion()) {
			PreparedStatement stmt = con.prepareStatement(
					"update productos "
					+ "set stock=stock+? "
					+ "where stock<5 and ?>0");
			stmt.setInt(1, num);
			stmt.setInt(2, num);
			stmt.execute();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}
	}
	
	public static List<Productos> listarProdVentas() {
		List<Productos> listaProd = new ArrayList<>();

		try (Connection con = Conexion.abreConexion()) {
			PreparedStatement stmt = con.prepareStatement("select c.nombre, a.nombre, a.stock from productos a "
					+ "inner join pedidoproducto b on b.idproducto=a.idproducto "
					+ "inner join categorias c on c.idcategoria=a.idcategoria "
					+ "group by b.idproducto "
					+ "having sum(b.unidades)=(select sum(unidades) from pedidoproducto "
					+ "group by idproducto "
					+ "order by sum(unidades) DESC limit 1)");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Categorias cat = new Categorias(0, rs.getString("c.nombre"));
				listaProd.add(new Productos(cat, rs.getString("a.nombre"), rs.getInt("a.stock")));
			}
		} catch (Exception ex) {

			ex.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}
		return listaProd;
	}
}
