package pruabJFrame;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import PanelPanelModificarDatos.PanelPanelModificarDatosAltura;
import PanelPanelModificarDatos.PanelPanelModificarDatosHabitat;
import PanelPanelModificarDatos.PanelPanelModificarDatosNombre;
import PanelPanelModificarDatos.PanelPanelModificarDatosNombreCientifico;
import PanelPanelModificarDatos.PanelPanelModificarDatosOrigen;

import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PanelModificarDatos extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtBuscarPorID;
	private Arbol arbol = null;
	private int id;
	/**
	 * Create the panel.
	 */
	public PanelModificarDatos(Statement st) {
		setLayout(null);
		
		JLabel lblErrorArbolNotFoud = new JLabel("");
		lblErrorArbolNotFoud.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorArbolNotFoud.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblErrorArbolNotFoud.setBounds(45, 233, 706, 30);
		add(lblErrorArbolNotFoud);
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblID.setBounds(45, 60, 46, 30);
		add(lblID);
		
		txtBuscarPorID = new JTextField();
		txtBuscarPorID.setColumns(10);
		txtBuscarPorID.setBounds(111, 60, 469, 33);
		add(txtBuscarPorID);
		
		JButton btnBuscarID = new JButton("Buscar");
		btnBuscarID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = Integer.parseInt(txtBuscarPorID.getText());
				arbol = new Conexion().buscarPorId(id,new Conexion().buscarEnTabla(st, "arboles"));
				if (arbol == null) {
					lblErrorArbolNotFoud.setText("ARBOL NO ENCONTRADO");
					lblErrorArbolNotFoud.setForeground(Color.red);
				}else {
					lblErrorArbolNotFoud.setText("");
				}
			}
		});
		btnBuscarID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscarID.setBounds(629, 60, 98, 33);
		add(btnBuscarID);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 172, 759, 2);
		add(separator);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 268, 759, 263);
		add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JButton btnCambiarNombre = new JButton("Nombre");
		btnCambiarNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelPanelModificarDatosNombre panelPanelModificarDatosNombre = new PanelPanelModificarDatosNombre(arbol, st, id);
				
				panel.removeAll();
				panel.add(panelPanelModificarDatosNombre);
				panel.revalidate();
				panel.repaint();
			}
		});
		btnCambiarNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCambiarNombre.setBounds(39, 195, 98, 33);
		add(btnCambiarNombre);
		
		JButton btnCambiarNombreCientifico = new JButton("NombreCientifico");
		btnCambiarNombreCientifico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelPanelModificarDatosNombreCientifico panelPanelModificarDatosNombreCientifico = new PanelPanelModificarDatosNombreCientifico(arbol, st, id);
				
				panel.removeAll();
				panel.add(panelPanelModificarDatosNombreCientifico);
				panel.revalidate();
				panel.repaint();
			}
		});
		btnCambiarNombreCientifico.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCambiarNombreCientifico.setBounds(181, 195, 143, 33);
		add(btnCambiarNombreCientifico);
		
		JButton btnCambiarHabitat = new JButton("Habitat");
		btnCambiarHabitat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelPanelModificarDatosHabitat panelModificarDatosHabitat = new PanelPanelModificarDatosHabitat(arbol, st, id);
				
				panel.removeAll();
				panel.add(panelModificarDatosHabitat);
				panel.revalidate();
				panel.repaint();
			}
		});
		btnCambiarHabitat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCambiarHabitat.setBounds(369, 195, 98, 33);
		add(btnCambiarHabitat);
		
		JButton btnCambiarAltura = new JButton("Altura");
		btnCambiarAltura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelPanelModificarDatosAltura panelPanelModificarDatosAltura = new PanelPanelModificarDatosAltura(arbol, st, id);
				
				panel.removeAll();
				panel.add(panelPanelModificarDatosAltura);
				panel.revalidate();
				panel.repaint();
			}
		});
		btnCambiarAltura.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCambiarAltura.setBounds(514, 195, 98, 33);
		add(btnCambiarAltura);
		
		JButton btnCambiarOrigen = new JButton("Origen");
		btnCambiarOrigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelPanelModificarDatosOrigen panelPanelModificarDatosOrigen = new PanelPanelModificarDatosOrigen(arbol, st, id);
				
				panel.removeAll();
				panel.add(panelPanelModificarDatosOrigen);
				panel.revalidate();
				panel.repaint();
			}
		});
		btnCambiarOrigen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCambiarOrigen.setBounds(653, 195, 98, 33);
		add(btnCambiarOrigen);
		
		
	}
}
