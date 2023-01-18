package pruabJFrame;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class PanelEliminarArbol extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtBuscarPorID;

	/**
	 * Create the panel.
	 * @param st 
	 */
	public PanelEliminarArbol(Statement st) {
		setLayout(null);
		

		JLabel lblArbolNotDFound = new JLabel("");
		lblArbolNotDFound.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblArbolNotDFound.setHorizontalAlignment(SwingConstants.CENTER);
		lblArbolNotDFound.setBounds(10, 135, 759, 24);
		add(lblArbolNotDFound);
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblID.setBounds(45, 63, 46, 30);
		add(lblID);
		
		txtBuscarPorID = new JTextField();
		txtBuscarPorID.setBounds(131, 60, 469, 33);
		add(txtBuscarPorID);
		txtBuscarPorID.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 170, 759, 2);
		add(separator);
		
		JLabel lblLinea = new JLabel("Linea a eliminar");
		lblLinea.setHorizontalAlignment(SwingConstants.CENTER);
		lblLinea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLinea.setBounds(20, 183, 759, 30);
		add(lblLinea);
		
		JLabel lblBBDDId = new JLabel("ID");
		lblBBDDId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBBDDId.setBounds(45, 224, 255, 30);
		add(lblBBDDId);
		
		JLabel lblDDBBNombreComun = new JLabel("Nombre comun");
		lblDDBBNombreComun.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDDBBNombreComun.setBounds(45, 258, 255, 36);
		add(lblDDBBNombreComun);
		
		JLabel lblBBDDNombreCientifico = new JLabel("Nombre cinetifico");
		lblBBDDNombreCientifico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBBDDNombreCientifico.setBounds(46, 305, 254, 36);
		add(lblBBDDNombreCientifico);
		
		JLabel lblBBDDHabitat = new JLabel("Habitat");
		lblBBDDHabitat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBBDDHabitat.setBounds(46, 346, 254, 36);
		add(lblBBDDHabitat);
		
		JLabel lblBBDDAltura = new JLabel("Altura");
		lblBBDDAltura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBBDDAltura.setBounds(46, 387, 254, 36);
		add(lblBBDDAltura);
		
		JLabel lblBBDDOrigen = new JLabel("Origen");
		lblBBDDOrigen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBBDDOrigen.setBounds(46, 434, 254, 36);
		add(lblBBDDOrigen);
		
		JLabel lblNombreComun_1_1 = new JLabel("Quiere eliminar la linea");
		lblNombreComun_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreComun_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreComun_1_1.setBounds(399, 305, 307, 36);
		add(lblNombreComun_1_1);
		
		JButton btnNo = new JButton("NO");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBBDDId.setText("ID");
				lblDDBBNombreComun.setText("NOMBRE");
				lblBBDDNombreCientifico.setText("NOMBRE CIENTIFICO");
				lblBBDDHabitat.setText("HABITAT");
				lblBBDDAltura.setText("ALTURA");
				lblBBDDOrigen.setText("ORIGEN");
			}
		});
		btnNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNo.setBounds(435, 357, 98, 33);
		add(btnNo);
		
		JButton btnSi = new JButton("SI");
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Conexion().eliminarLinea(Integer.parseInt(lblBBDDId.getText()), st);
			}
		});
		btnSi.setBackground(new Color(255, 0, 0));
		btnSi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSi.setBounds(577, 357, 98, 33);
		add(btnSi);
		
		JButton btnBuscarID = new JButton("Buscar");
		btnBuscarID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txtBuscarPorID.getText());
				Arbol arbol = new Conexion().buscarPorId(id,new Conexion().buscarEnTabla(st, "arboles"));
				if (arbol == null) {
					lblArbolNotDFound.setText("ARBOL NO ENCONTRADO");
					lblArbolNotDFound.setForeground(Color.red);
					lblBBDDId.setText("ERROR");
					lblDDBBNombreComun.setText("ERROR");
					lblBBDDNombreCientifico.setText("ERROR");
					lblBBDDHabitat.setText("ERROR");
					lblBBDDAltura.setText("ERROR");
					lblBBDDOrigen.setText("ERROR");
				}else {
					lblBBDDId.setText(String.valueOf(arbol.getId()));
					lblDDBBNombreComun.setText(arbol.getNombreComun());
					lblBBDDNombreCientifico.setText(arbol.getNombreCientifico());
					lblBBDDHabitat.setText(arbol.getHabitat());
					lblBBDDAltura.setText(String.valueOf(arbol.getAltura()));
					lblBBDDOrigen.setText(arbol.getOrigen());
				}
			}
		});
		btnBuscarID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscarID.setBounds(635, 60, 98, 33);
		add(btnBuscarID);
		

	}
}
