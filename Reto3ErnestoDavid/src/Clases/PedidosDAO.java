package Clases;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Util.Conexion;
import Util.funciones;

public class PedidosDAO {
	
	public static Pedidos insertarPedido(Clientes cli) {
		try (Connection con = Conexion.abreConexion()) {
			PreparedStatement stmt = con.prepareStatement("insert into pedidos(idcliente,precioTotal,direccionEnvio,fecha) "
					+ "values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			LocalDate ld= LocalDate.now();
			Date d=Util.funciones.convierte_LocalDate_a_Date(ld);
			stmt.setInt(1, cli.getIdcliente());
			stmt.setInt(2, 0);
			stmt.setString(3, cli.getDireccion());
			stmt.setDate(4, funciones.convierteFecha(d));
			stmt.execute();
			//recuperamos la clave generada()
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				Pedidos ped= new Pedidos(rs.getInt(1),cli,0, cli.getDireccion(),d);
				return ped;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}
		return null;
		
	}
	
	
}
