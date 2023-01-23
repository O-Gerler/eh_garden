package pruabJFrame;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		
		Conexion conexion = new Conexion();
		try {
			con = conexion.establecerConexion(con);
			st = conexion.conectarBBDD(con);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		try {
			InicioSesion frame = new InicioSesion(st, con);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
