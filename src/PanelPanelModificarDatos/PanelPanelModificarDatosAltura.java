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

public class PanelPanelModificarDatosAltura extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtAltura;

	/**
	 * Create the panel.
	 */
	public PanelPanelModificarDatosAltura(Arbol arbol, Connection con, int id) {
		setLayout(null);
		
		JLabel lblNombreActual = new JLabel("Altura Antiguo");
		lblNombreActual.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreActual.setBounds(30, 65, 160, 33);
		add(lblNombreActual);
		
		JLabel lblNombreArbolActual = new JLabel("Altura Antiguo");
		lblNombreArbolActual.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreArbolActual.setBounds(200, 65, 549, 33);
		add(lblNombreArbolActual);
		lblNombreArbolActual.setText(String.valueOf(arbol.getAltura()));
		
		JLabel lblNombreNuevo = new JLabel("Altura");
		lblNombreNuevo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreNuevo.setBounds(30, 117, 160, 33);
		add(lblNombreNuevo);

		JButton btnSi = new JButton("SI");
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Conexion().modificarLineaInt(id, con, Integer.parseInt(txtAltura.getText()), "altura");
			}
		});
		btnSi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSi.setBackground(Color.RED);
		btnSi.setBounds(623, 199, 98, 33);
		add(btnSi);
		
		txtAltura = new JTextField();
		txtAltura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAltura.setBounds(200, 117, 549, 33);
		add(txtAltura);
		txtAltura.setColumns(10);
		txtAltura.setColumns(10);
	}

}