package pruabJFrame;

import javax.swing.JPanel;

import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PanelMostrarDatos extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelMostrarDatos(Statement st) {
		setLayout(null);
		
		JLabel lblDatos = new JLabel("New label");
		lblDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatos.setVerticalAlignment(SwingConstants.TOP);
		lblDatos.setBounds(32, 69, 747, 473);
		add(lblDatos);
		
		ArrayList<ArrayList<String>> datos = new Conexion().devolverTodosLosDatos(st, "arboles");
		
		String todosLosDatos = "<html><table>"
				+ "<tr><td>ID</td><td>NOMBRE COMUN</td><td>NOMBRE CIENTIFICO</td><td>HABITAT</td><td>ALTURA</td><td>ORIGEN</td></tr>";
		
		for (ArrayList<String> arrayList : datos) {
			todosLosDatos += "<tr>";
			ArrayList<String> datosString = arrayList;
			for (String s : datosString) {
				todosLosDatos += "<td>" + s + "</td>";
			}
			todosLosDatos += "<tr>";
		}
		

		todosLosDatos.concat("</table></html>");
		
		lblDatos.setText(todosLosDatos);
		
		

	}
}
