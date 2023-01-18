package pruabJFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.CardLayout;

public class PanelPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @param st 
	 */
	public PanelPrincipal(Statement st) {
		
		setTitle("Menu");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1083, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel content = new JPanel();
		content.setBounds(288, 0, 779, 542);
		contentPane.add(content);
		content.setLayout(new CardLayout(0, 0));
		
		JLabel lblTitulo = new JLabel("EH GARDEN");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblTitulo.setBounds(0, 17, 288, 70);
		contentPane.add(lblTitulo);
		
		JButton btnAddArbol = new JButton("Agregar Arbol");
		btnAddArbol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelAgregarArbol panelAgregarArbol = new PanelAgregarArbol(st);
				
				content.removeAll();
				content.add(panelAgregarArbol);
				content.revalidate();
				content.repaint();
			}
		});
		btnAddArbol.setBackground(new Color(0, 255, 0));
		btnAddArbol.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAddArbol.setBounds(0, 98, 288, 93);
		contentPane.add(btnAddArbol);
		
		JButton btnDeleteArbol = new JButton("Eliminar Arbol");
		btnDeleteArbol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelEliminarArbol panelEliminarArbol = new PanelEliminarArbol(st);
				
				content.removeAll();
				content.add(panelEliminarArbol);
				content.revalidate();
				content.repaint();
			}
		});
		btnDeleteArbol.setBackground(new Color(0, 255, 0));
		btnDeleteArbol.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnDeleteArbol.setBounds(0, 202, 288, 93);
		contentPane.add(btnDeleteArbol);
		
		JButton btnModifyArbol = new JButton("Modificar Arbol");
		btnModifyArbol.setBackground(new Color(0, 255, 0));
		btnModifyArbol.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnModifyArbol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelModificarDatos panelModificarDatos = new PanelModificarDatos(st);
				
				content.removeAll();
				content.add(panelModificarDatos);
				content.revalidate();
				content.repaint();
			}
		});
		btnModifyArbol.setBounds(0, 306, 288, 93);
		contentPane.add(btnModifyArbol);
		
		JButton btnShowArbol = new JButton("Mostrar Arboles");
		btnShowArbol.setBackground(new Color(0, 255, 0));
		btnShowArbol.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnShowArbol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMostrarDatos panelMostrarDatos = new PanelMostrarDatos(st);
				
				content.removeAll();
				content.add(panelMostrarDatos);
				content.revalidate();
				content.repaint();
			}
		});
		btnShowArbol.setBounds(0, 410, 288, 93);
		contentPane.add(btnShowArbol);
	}

}
