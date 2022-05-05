package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import excepciones.LongitudInvalidaException;

public class Ventana_Principal extends JFrame {

	private JPanel contentPane;
	

	

	



	/**
	 * Create the frame.
	 */
	public Ventana_Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Ficheros maestros");
		menuBar.add(mnNewMenu);
		
		JMenuItem mnNewMenu_2 = new JMenuItem("Oficinas");
		mnNewMenu.add(mnNewMenu_2);
		mnNewMenu_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Formulario_Oficina v;
				try 
				{
					try {
						v = new Formulario_Oficina();
						Metodos_Gui.CentraVentana(v);
						v.setVisible(true);
					} catch (LongitudInvalidaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} 
				catch (SQLException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				

			}
		});
		

		
		JMenuItem mnNewMenu_3 = new JMenuItem("Empleados");
		mnNewMenu.add(mnNewMenu_3);
		mnNewMenu_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Formulario_Empleado v;
				try {
					v = new Formulario_Empleado();
					Metodos_Gui.CentraVentana(v);
					v.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				

			}
		});
	
		JMenu mnNewMenu_1 = new JMenu("Procesos Diarios");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Alquileres");
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_4 = new JMenu("Listados e Informes");
		menuBar.add(mnNewMenu_4);
		
		JMenu mnNewMenu_5 = new JMenu("Vehiculos");
		mnNewMenu_4.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Por Categorias");
		mnNewMenu_5.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Por Oficinas");
		mnNewMenu_5.add(mntmNewMenuItem_7);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(228, 5, 32));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("C:\\Users\\ferku\\OneDrive\\Escritorio\\AVIS.png"));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblLogo, BorderLayout.CENTER);
	}

}
