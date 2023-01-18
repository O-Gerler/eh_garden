package pruabJFrame;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class PanelAgregarArbol extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombreComun;
	private JTextField txtNombreCientifico;
	private JTextField txtHabitat;
	private JTextField txtAltura;
	private JTextField txtOrigen;

	/**
	 * Create the panel.
	 * @param st 
	 */
	public PanelAgregarArbol(Statement st) {
		setLayout(null);
		
		JLabel lblNombreComun = new JLabel("Nombre comun");
		lblNombreComun.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreComun.setBounds(56, 72, 173, 36);
		add(lblNombreComun);
		
		txtNombreComun = new JTextField();
		txtNombreComun.setBounds(223, 72, 383, 36);
		add(txtNombreComun);
		txtNombreComun.setColumns(10);
		
		JLabel lblNombreCientifico = new JLabel("Nombre cinetifico");
		lblNombreCientifico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreCientifico.setBounds(56, 135, 155, 36);
		add(lblNombreCientifico);
		
		txtNombreCientifico = new JTextField();
		txtNombreCientifico.setColumns(10);
		txtNombreCientifico.setBounds(223, 135, 383, 36);
		add(txtNombreCientifico);
		
		JLabel lblHabitat = new JLabel("Habitat");
		lblHabitat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHabitat.setBounds(56, 200, 106, 36);
		add(lblHabitat);
		
		txtHabitat = new JTextField();
		txtHabitat.setColumns(10);
		txtHabitat.setBounds(223, 200, 383, 36);
		add(txtHabitat);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAltura.setBounds(56, 266, 106, 36);
		add(lblAltura);
		
		txtAltura = new JTextField();
		txtAltura.setColumns(10);
		txtAltura.setBounds(223, 266, 383, 36);
		add(txtAltura);
		
		JLabel lblOrigen = new JLabel("Origen");
		lblOrigen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOrigen.setBounds(56, 334, 106, 36);
		add(lblOrigen);
		
		txtOrigen = new JTextField();
		txtOrigen.setColumns(10);
		txtOrigen.setBounds(223, 334, 383, 36);
		add(txtOrigen);
		
		JButton btnEnviar = new JButton("Enviar\r\n");
		btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreComun = txtNombreComun.getText();
				String nombreCientifico = txtNombreCientifico.getText();
				String habitat = txtHabitat.getText();
				int altura = Integer.parseInt(txtAltura.getText());
				String origen = txtOrigen.getText();
				
				new Conexion().addArbol(st, nombreComun, nombreCientifico, habitat, altura, origen);
			}
		});
		btnEnviar.setBounds(564, 442, 96, 30);
		add(btnEnviar);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombreComun.setText("");
				txtNombreCientifico.setText("");
				txtHabitat.setText("");
				txtAltura.setText("");
				txtOrigen.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setBounds(441, 442, 96, 30);
		add(btnReset);
		
	}
}
