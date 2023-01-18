package pruabJFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class InicioSesion extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario user = new Usuario();
	private JPanel contentPane;
	private JTextField txtUsername;
	private JButton btnSalir, btnAceptar;
	private final JPasswordField txtPassword = new JPasswordField();

	/**
	 * Create the frame.
	 * @param st 
	 */
	public InicioSesion(Statement st) {
		
		iniciarComponente(st);
		
		setTitle("Inicio de sesion");
		setLocationRelativeTo(null);
		setResizable(false);

	}
	
	public Usuario getUsuario() {
		return user;
	}

	private void iniciarComponente(Statement st) {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel labelTitulo = new JLabel("Inicio de Sesion");
		labelTitulo.setBounds(15, 5, 319, 37);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnSalir == e.getSource()) {
					System.exit(0);
				}
			}
		});
		btnSalir.setBounds(58, 149, 112, 23);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 63, 66, 20);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(88, 63, 246, 20);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 103, 66, 17);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnAceptar == e.getSource()) {
					String username = txtUsername.getText();
					String password = String.valueOf(txtPassword.getPassword());
					
					if (new Conexion().buscarUsuario(username, password,new Conexion().buscarEnTabla(st, "usuarios"))) {
						PanelPrincipal p2 = new PanelPrincipal(st);
						p2.setVisible(true);
						p2.setLocationRelativeTo(null);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "INVALID LOGIN");
					}
				}
			}
		});
		btnAceptar.setBounds(180, 149, 112, 23);
		
		
		contentPane.setLayout(null);
		contentPane.add(lblUsername);
		contentPane.add(txtUsername);
		contentPane.add(labelTitulo);
		contentPane.add(btnSalir);
		contentPane.add(btnAceptar);
		contentPane.add(lblPassword);
		txtPassword.setBounds(88, 101, 246, 20);
		contentPane.add(txtPassword);
	}
}
