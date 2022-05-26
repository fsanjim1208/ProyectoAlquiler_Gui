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

import accesoadatos.RepositorioAlquileres;
import accesoadatos.RepositorioOficina;
import accesoadatos.RepositorioVehiculos;
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
		mnNewMenu.setIcon(new ImageIcon(Ventana_Principal.class.getResource("/imagenes/gear.png")));
		menuBar.add(mnNewMenu);
		
		
		JMenuItem MenuEmpleados = new JMenuItem("Empleados");
		MenuEmpleados.setIcon(new ImageIcon(Ventana_Principal.class.getResource("/imagenes/administrator.png")));
		mnNewMenu.add(MenuEmpleados);
		

		MenuEmpleados.addActionListener(new ActionListener() {
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
		
		JMenuItem MenuClientes = new JMenuItem("Clientes");
		MenuClientes.setIcon(new ImageIcon(Ventana_Principal.class.getResource("/imagenes/clients.png")));
		mnNewMenu.add(MenuClientes);
		MenuClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Formulario_Clientes v;
				try {
					v = new Formulario_Clientes();
					Metodos_Gui.CentraVentana(v);
					v.setVisible(true);
				} catch (SQLException | LongitudInvalidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		JMenuItem MenuOficinas = new JMenuItem("Oficinas");
		MenuOficinas.setIcon(new ImageIcon(Ventana_Principal.class.getResource("/imagenes/group.png")));
		mnNewMenu.add(MenuOficinas);
		MenuOficinas.addActionListener(new ActionListener() 
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
		
		
		
		
		JMenuItem MenuVehiculos = new JMenuItem("Vehiculos");
		MenuVehiculos.setIcon(new ImageIcon(Ventana_Principal.class.getResource("/imagenes/bus.png")));
		mnNewMenu.add(MenuVehiculos);
	
		MenuVehiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Formulario_Vehiculos v;
				try {
					v = new Formulario_Vehiculos();
					Metodos_Gui.CentraVentana(v);
					v.setVisible(true);
				} catch (SQLException | LongitudInvalidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JMenuItem MenuCategorias = new JMenuItem("Categorias");
		MenuCategorias.setIcon(new ImageIcon(Ventana_Principal.class.getResource("/imagenes/gear.png")));
		mnNewMenu.add(MenuCategorias);
	
		MenuCategorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Formulario_Categorias v;
				try {
					v = new Formulario_Categorias();
					Metodos_Gui.CentraVentana(v);
					v.setVisible(true);
				} catch (SQLException | LongitudInvalidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				

			}
		});
		
		JMenu mnNewMenu_1 = new JMenu("Procesos Diarios");
		mnNewMenu_1.setIcon(new ImageIcon(Ventana_Principal.class.getResource("/imagenes/attachment.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuAlquileres = new JMenuItem("Alquileres");
		menuAlquileres.setIcon(new ImageIcon(Ventana_Principal.class.getResource("/imagenes/time_sheet.png")));
		mnNewMenu_1.add(menuAlquileres);
		
		menuAlquileres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormularioAlquileres v;
				try {
					v = new FormularioAlquileres();
					Metodos_Gui.CentraVentana(v);
					v.setVisible(true);
				} catch (SQLException | LongitudInvalidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				

			}
		});
		
		JMenu mnNewMenu_4 = new JMenu("Listados e Informes");
		mnNewMenu_4.setIcon(new ImageIcon(Ventana_Principal.class.getResource("/imagenes/clipboard.png")));
		menuBar.add(mnNewMenu_4);
		
		JMenu mnNewMenu_5 = new JMenu("Vehiculos");
		mnNewMenu_4.add(mnNewMenu_5);
		
		JMenuItem menuvehiculosCategoria = new JMenuItem("Por Categorias");
		mnNewMenu_5.add(menuvehiculosCategoria);
		menuvehiculosCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listado_vehiculo_categoria v;
				try {
					v = new Listado_vehiculo_categoria();
					Metodos_Gui.CentraVentana(v);
					v.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JMenuItem menuVehiculoporofi = new JMenuItem("Por Oficinas");
		mnNewMenu_5.add(menuVehiculoporofi);
		
		menuVehiculoporofi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoVehiculoPorOficina v;
				try {
					v = new ListadoVehiculoPorOficina();
					Metodos_Gui.CentraVentana(v);
					v.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				

			}
		});
		
		JMenuItem menuVehiculosdisponibles = new JMenuItem("Disponibles");
		mnNewMenu_5.add(menuVehiculosdisponibles);
		
		menuVehiculosdisponibles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listado_Vehiculos_Activos v;
				try {
					v = new Listado_Vehiculos_Activos(RepositorioVehiculos.leeVehiculosBasededatosActivos());
					Metodos_Gui.CentraVentana(v);
					v.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				

			}
		});
		
		JMenuItem menuVehiculosAlquilados = new JMenuItem("Alquilados");
		mnNewMenu_5.add(menuVehiculosAlquilados);
		
		menuVehiculosAlquilados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listado_Vehiculos_Activos v;
				try {
					v = new Listado_Vehiculos_Activos(RepositorioVehiculos.leeVehiculosBasededatosAlquilados());
					Metodos_Gui.CentraVentana(v);
					v.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				

			}
		});
		
		JMenu menualquileres = new JMenu("Alquileres");
		mnNewMenu_4.add(menualquileres);
		
		JMenuItem menutodosalquileres = new JMenuItem("Todos los alquileres");
		menualquileres.add(menutodosalquileres);
		menutodosalquileres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listados_Alquileres v;
				try {
					v = new Listados_Alquileres(RepositorioAlquileres.leeAlquileresBasedeDatos(),"Precio");
					Metodos_Gui.CentraVentana(v);
					v.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LongitudInvalidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				

			}
		});
		
		JMenuItem menualquileresactivos = new JMenuItem("Activos");
		menualquileres.add(menualquileresactivos);
		menualquileresactivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listados_Alquileres v;
				try {
					v = new Listados_Alquileres(RepositorioAlquileres.leeAlquileresBasedeDatosActivos(),"Precio estimado");
					Metodos_Gui.CentraVentana(v);
					v.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LongitudInvalidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				

			}
		});
		
		JMenuItem menualquileresfinalizados = new JMenuItem("Finalizados");
		menualquileres.add(menualquileresfinalizados);
		menualquileresfinalizados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listados_Alquileres v;
				try {
					v = new Listados_Alquileres(RepositorioAlquileres.leeAlquileresBasedeDatosFinalizados(),"Precio");
					Metodos_Gui.CentraVentana(v);
					v.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LongitudInvalidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				

			}
		});
		
		JMenu menuEmpleados = new JMenu("Empleados");
		mnNewMenu_4.add(menuEmpleados);
		
		JMenuItem menuEmpledoOficina = new JMenuItem("Oficina");
		menuEmpleados.add(menuEmpledoOficina);
		menuEmpledoOficina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listado_empleado_oficina v;
				try {
					v = new Listado_empleado_oficina();
					Metodos_Gui.CentraVentana(v);
					v.setVisible(true);				

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
				
		JMenu menuCliente = new JMenu("Clientes");
		mnNewMenu_4.add(menuCliente);
		
		JMenuItem menuclienteprovincia = new JMenuItem("Provincia");
		menuCliente.add(menuclienteprovincia);
		menuclienteprovincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listado_Cliente v;
				try {
					v = new Listado_Cliente();
					Metodos_Gui.CentraVentana(v);
					v.setVisible(true);
				} catch (SQLException | LongitudInvalidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		
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
