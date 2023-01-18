package PanelPanelModificarDatos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pruabJFrame.Arbol;
import pruabJFrame.Conexion;

public class PanelPanelModificarDatosHabitat extends JPanel {
	private JTextField txtHabitat;

	/**
	 * Create the panel.
	 */
	public PanelPanelModificarDatosHabitat(Arbol arbol, Statement st, int id) {
		setLayout(null);
		
		JLabel lblNombreActual = new JLabel("Habitat Antiguo");
		lblNombreActual.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreActual.setBounds(30, 65, 160, 33);
		add(lblNombreActual);
		
		JLabel lblNombreArbolActual = new JLabel("Habitat Antiguo");
		lblNombreArbolActual.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreArbolActual.setBounds(200, 65, 549, 33);
		add(lblNombreArbolActual);
		lblNombreArbolActual.setText(arbol.getHabitat());
		
		JLabel lblNombreNuevo = new JLabel("Habitat");
		lblNombreNuevo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreNuevo.setBounds(30, 117, 160, 33);
		add(lblNombreNuevo);

		JButton btnSi = new JButton("SI");
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Conexion().modificarLineaString(id, st, txtHabitat.getText(), "habitat");
			}
		});
		btnSi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSi.setBackground(Color.RED);
		btnSi.setBounds(623, 199, 98, 33);
		add(btnSi);
		
		txtHabitat = new JTextField();
		txtHabitat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtHabitat.setBounds(200, 117, 549, 33);
		add(txtHabitat);
		txtHabitat.setColumns(10);
		txtHabitat.setColumns(10);
	}

}
