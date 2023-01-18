package PanelPanelModificarDatos;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;

import pruabJFrame.Arbol;
import pruabJFrame.Conexion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelPanelModificarDatosNombre extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombreNuevo;

	/**
	 * Create the panel.
	 * @param id 
	 */
	public PanelPanelModificarDatosNombre(Arbol arbol, Statement st, int id) {
		setLayout(null);
		
		JLabel lblNombreActual = new JLabel("Nombre ");
		lblNombreActual.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreActual.setBounds(30, 65, 119, 33);
		add(lblNombreActual);
		
		JLabel lblNombreArbolActual = new JLabel("Nombre Antiguo");
		lblNombreArbolActual.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreArbolActual.setBounds(159, 65, 590, 33);
		add(lblNombreArbolActual);
		lblNombreArbolActual.setText(arbol.getNombreComun());
		
		JLabel lblNombreNuevo = new JLabel("Nombre");
		lblNombreNuevo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreNuevo.setBounds(30, 117, 119, 33);
		add(lblNombreNuevo);
		
		txtNombreNuevo = new JTextField();
		txtNombreNuevo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNombreNuevo.setBounds(154, 118, 595, 30);
		add(txtNombreNuevo);
		txtNombreNuevo.setColumns(10);

		JButton btnSi = new JButton("SI");
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Conexion().modificarLineaString(id, st, txtNombreNuevo.getText(), "nombre_comun");
			}
		});
		btnSi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSi.setBackground(Color.RED);
		btnSi.setBounds(623, 199, 98, 33);
		add(btnSi);
	}

}
