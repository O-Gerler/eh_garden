package PanelPanelModificarDatos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pruabJFrame.Arbol;
import pruabJFrame.Conexion;

public class PanelPanelModificarDatosNombreCientifico extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombreCientifico;

	/**
	 * Create the panel.
	 */
	public PanelPanelModificarDatosNombreCientifico(Arbol arbol, Connection con, int id) {
		setLayout(null);
		
		JLabel lblNombreActual = new JLabel("Nombre  Cientifico");
		lblNombreActual.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreActual.setBounds(30, 65, 182, 33);
		add(lblNombreActual);
		
		JLabel lblNombreArbolActual = new JLabel("Nombre Antiguo");
		lblNombreArbolActual.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreArbolActual.setBounds(222, 65, 527, 33);
		add(lblNombreArbolActual);
		lblNombreArbolActual.setText(arbol.getNombreCientifico());
		
		JLabel lblNombreNuevo = new JLabel("Nombre  Cientifico");
		lblNombreNuevo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreNuevo.setBounds(30, 117, 182, 33);
		add(lblNombreNuevo);

		JButton btnSi = new JButton("SI");
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Conexion().modificarLineaString(id, con, txtNombreCientifico.getText(), "nombre_cientifico");
			}
		});
		btnSi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSi.setBackground(Color.RED);
		btnSi.setBounds(623, 199, 98, 33);
		add(btnSi);
		
		txtNombreCientifico = new JTextField();
		txtNombreCientifico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNombreCientifico.setBounds(222, 117, 527, 33);
		add(txtNombreCientifico);
		txtNombreCientifico.setColumns(10);
	}

}
