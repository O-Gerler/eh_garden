package pruabJFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Conexion {
	
	private static final String IP = "jdbc:mysql://localhost/";
	private static final String BBDD = "eh_garden";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	PreparedStatement pst = null;

	public Statement conectarBBDD (Connection con) throws SQLException {
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			con = DriverManager.getConnection( IP + BBDD, USER, PASSWORD );
			System.out.println("funciona");
			
			
			return con.createStatement();
	
	}
	
	public ResultSet buscarEnTabla(Statement st, String tabla) {
		try {
			return st.executeQuery("Select * FROM " + tabla);		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void addArbol(Connection con , Arbol arbol) {
		try {
			pst = con.prepareStatement("INSERT INTO arboles (nombre_comun,nombre_cientifico,habitat,altura,origen)"
					+ "VALUES (?,?,?,?,?)");
			pst.setString(1, arbol.getNombreComun());
			pst.setString(2, arbol.getNombreCientifico());
			pst.setString(3, arbol.getHabitat());
			pst.setInt(4, arbol.getAltura());
			pst.setString(5, arbol.getOrigen());
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean buscarUsuario(String username, String password, ResultSet rs) {
		
		try {
			while(rs.next()) {
				if (username.equals(rs.getString(2)) && password.equals(rs.getString(3))) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Arbol buscarPorId(int id, ResultSet rs) {
		Arbol a = null;
		
		try {
			while (rs.next()) {
				if(id == rs.getInt(1)) {
					a = new Arbol();
					a.setId(id);
					a.setNombreComun(rs.getString(2));
					a.setNombreCientifico(rs.getString(3));
					a.setHabitat(rs.getString(4));
					a.setAltura(rs.getInt(5));
					a.setOrigen(rs.getString(6));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}
	
	public void eliminarLinea(int id, Statement st) {
		try {
			st.execute("DELETE FROM arboles WHERE id = " + id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modificarLineaString(int id, Connection con, String lineaNueva, String columna) {
		//UPDATE `arboles` SET `nombre_comun` = 'aaaaaaa' WHERE `arboles`.`id` = 3;
		try {
			pst = con.prepareStatement("UPDATE arboles SET ?=? WHERE id=?");
			pst.setString(1, columna);
			pst.setString(2, lineaNueva);
			pst.setInt(3, id);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void modificarLineaInt(int id, Connection con, int lineaNueva, String columna) {
		try {
			//UPDATE `arboles` SET `altura` = '1223' WHERE `arboles`.`id` = 3;
			pst = con.prepareStatement("UPDATE arboles SET ?=? WHERE id=?");
			pst.setString(1, columna);
			pst.setInt(2, lineaNueva);
			pst.setInt(3, id);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public ArrayList<ArrayList<String>> devolverTodosLosDatos(Statement st, String tabla) {
		ArrayList<ArrayList<String>> datos = new ArrayList<>();
		ResultSet rs = this.buscarEnTabla(st, tabla);
		try {
			while(rs.next()) {
				ArrayList<String> datosString = new ArrayList<>();
				datosString.add(rs.getString(1));
				datosString.add(rs.getString(2));
				datosString.add(rs.getString(3));
				datosString.add(rs.getString(4));
				datosString.add(rs.getString(5));
				datosString.add(rs.getString(6));
				
				datos.add(datosString);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return datos;
		
	}
	
}
