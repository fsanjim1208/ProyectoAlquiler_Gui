package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.jgoodies.common.base.SystemUtils;

import accesoadatos.RepositorioAlquileres;
import accesoadatos.RepositorioCategorias;
import accesoadatos.RepositorioCliente;
import accesoadatos.RepositorioEmpleados;
import accesoadatos.RepositorioOficina;
import accesoadatos.RepositorioVehiculos;
import accesoadatos.Repositorio_Localidad_Provincia;
import entidades.Alquiler;
import entidades.CarnetConducir;
import entidades.Categoria;
import entidades.Cliente;
import entidades.CochesCombustion;
import entidades.CochesElectricos;
import entidades.Empleado;
import entidades.Furgonetas;
import entidades.Motocicletas;
import entidades.Oficina;
import excepciones.LongitudInvalidaException;
import metodos.Metodos;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;

public class FormularioAlquileres extends JFrame {

	private JPanel contentPane;
	private JComboBox cbEmpleado;
	private JComboBox cbOficina_Recoge;
	private JButton btnNuevoCliente;
	private JButton btnExistente;
	private JTextField textCodigo;
	private DefaultComboBoxModel dVehiculo =new DefaultComboBoxModel();
	private BuscaAlquilerTabla buscador ;
	private JComboBox cbOficina_Devuelve;
	private JTextField textVehiculo;
	private JComboBox cbCliente;
	private JComboBox cbTipo;
	private JButton btnBuscaVehiculo;
	private BuscaVehiculos buscador1;
	private BuscaVehiculos buscador2;
	private BuscaVehiculos buscador3;
	private BuscaVehiculos buscador4;
	private JDateChooser textFAlquila;
	private JDateChooser textFDevuelve;
	private JButton btndevolver;
	private JLabel lblPrecio;
	private JLabel lblPrecio_estimado;
	private JButton btnPrecio;
	private JButton btnGrabar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					accesoadatos.AccesoADatos.AbreConexion();;
					FormularioAlquileres frame = new FormularioAlquileres();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws LongitudInvalidaException 
	 * @throws SQLException 
	 */
	public FormularioAlquileres() throws SQLException, LongitudInvalidaException {
		setBounds(100, 100, 669, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(55, 33, 45, 13);
		contentPane.add(lblCodigo);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(55, 283, 45, 13);
		contentPane.add(lblCliente);
		
		JLabel lblEmpleado = new JLabel("Empleado");
		lblEmpleado.setBounds(55, 233, 76, 13);
		contentPane.add(lblEmpleado);
		
		JLabel lblOficina_Recoge = new JLabel("Oficina recoge");
		lblOficina_Recoge.setBounds(293, 83, 100, 13);
		contentPane.add(lblOficina_Recoge);
		
		JLabel lblFecha_alquila = new JLabel("Fecha Alquila");
		lblFecha_alquila.setBounds(55, 83, 103, 13);
		contentPane.add(lblFecha_alquila);
		
		JLabel lblFechaDevolucion = new JLabel("Fecha Devolucion");
		lblFechaDevolucion.setBounds(55, 133, 174, 13);
		contentPane.add(lblFechaDevolucion);

		cbOficina_Recoge = new JComboBox();	
		cbOficina_Recoge.setBounds(403, 81, 230, 21);
		contentPane.add(cbOficina_Recoge);
		DefaultComboBoxModel dOficina =new DefaultComboBoxModel();
		dOficina.addAll(RepositorioOficina.leeOficinasBasededatos());
		cbOficina_Recoge.setModel(dOficina);
		cbOficina_Recoge.setSelectedIndex(0);
				
		cbEmpleado = new JComboBox();
		cbEmpleado.setBounds(120, 229, 305, 21);
		contentPane.add(cbEmpleado);
		DefaultComboBoxModel dEmpleado =new DefaultComboBoxModel();
		dEmpleado.addAll(RepositorioEmpleados.leeEmpleadosBasededatos());
		cbEmpleado.setModel(dEmpleado);
		cbEmpleado.setSelectedIndex(0);
		
		btnExistente = new JButton("Existente");
		btnExistente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BuscaClientes v = null;
				try {
					v = new BuscaClientes();
					Metodos_Gui.CentraVentana(v);
					v.setVisible(true);
				} catch (SQLException | LongitudInvalidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				cbCliente.setSelectedItem(v.getCliente().getDni());
				
			}
		});
		btnExistente.setBounds(435, 279, 88, 21);
		contentPane.add(btnExistente);
		
		btnNuevoCliente = new JButton("Nuevo");
		btnNuevoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Formulario_Clientes_modal v = null;
				try {
					v = new Formulario_Clientes_modal();
					Metodos_Gui.CentraVentana(v);
					v.setVisible(true);
				} catch (SQLException | LongitudInvalidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				cbCliente.setSelectedItem(v.getCliente().getDni());
			}
		});
		btnNuevoCliente.setBounds(531, 279, 74, 21);
		contentPane.add(btnNuevoCliente);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(110, 30, 45, 19);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		textCodigo.setEnabled(false);
		DefaultComboBoxModel dCategoria =new DefaultComboBoxModel();
		dCategoria.addAll(RepositorioCategorias.leeCategoriasBasededatos());
		
		textFAlquila = new JDateChooser();
		textFAlquila.setBounds(149, 81, 136, 19);
		contentPane.add(textFAlquila);
		
		textFDevuelve = new JDateChooser();
		textFDevuelve.setBounds(165, 131, 120, 19);
		contentPane.add(textFDevuelve);
		Oficina ofi= (Oficina) cbOficina_Recoge.getSelectedItem();
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				try {
					buscador = new BuscaAlquilerTabla();
				} catch (SQLException | LongitudInvalidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Metodos_Gui.CentraVentana(buscador);
				buscador.setVisible(true);
				
				Alquiler al= buscador.getAlquiler();
				textCodigo.setText(al.getCodigo());
				cbOficina_Recoge.setSelectedItem(al.getLugar_alquila());
				cbOficina_Devuelve.setSelectedItem(al.getLugar_devuelve());
				textFAlquila.setDate(metodos.Metodos.ConvierteGregorianCalendaraDate(al.getFecha_alquila()));
				textFDevuelve.setDate(metodos.Metodos.ConvierteGregorianCalendaraDate(al.getFecha_devuelve()));
				textVehiculo.setText(al.getVehiculo_alqiuilado().getMatricula());
				try {
					if (RepositorioVehiculos.buscaCocheElectricos(al.getVehiculo_alqiuilado().getMatricula()) != null)
					{
						cbTipo.setSelectedIndex(0);
					}
					else if (RepositorioVehiculos.buscaCocheCombustion(al.getVehiculo_alqiuilado().getMatricula()) != null)
					{
						cbTipo.setSelectedIndex(1);
					}
					else if (RepositorioVehiculos.buscaFurgonetas(al.getVehiculo_alqiuilado().getMatricula()) != null)
					{
						cbTipo.setSelectedIndex(2);
					}
					else if (RepositorioVehiculos.buscaMotos(al.getVehiculo_alqiuilado().getMatricula()) != null)
					{
						cbTipo.setSelectedIndex(3);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cbEmpleado.setSelectedItem(al.getEmpleado());
				cbCliente.setSelectedItem(al.getCliente());
				
				cbTipo.setEnabled(false);
				textVehiculo.setEnabled(false);
				cbEmpleado.setEnabled(false);
				cbCliente.setEnabled(false);
				btnBuscaVehiculo.setEnabled(false);
				btnExistente.setEnabled(false);
				btnNuevoCliente.setEnabled(false);
				textFAlquila.setEnabled(false);
				cbOficina_Recoge.setEnabled(false);
				btnPrecio.setVisible(false);
				lblPrecio.setVisible(true);
				lblPrecio_estimado.setVisible(true);
				btndevolver.setVisible(true);
				String codigo = null;
				try {
					codigo = Metodos.CalculaCodigoAlquiler();
				} catch (SQLException | LongitudInvalidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Cliente cliente = (Cliente) cbCliente.getSelectedItem();
				Empleado empleado = (Empleado) cbEmpleado.getSelectedItem();
				Oficina ofi_recoge= (Oficina) cbOficina_Recoge.getSelectedItem();
				Oficina ofi_devuelve = (Oficina) cbOficina_Devuelve.getSelectedItem();
				GregorianCalendar f_alquila= Metodos.PasaDateaGregorianCalendar(textFAlquila.getDate());
				GregorianCalendar f_devuelve= Metodos.PasaDateaGregorianCalendar(textFDevuelve.getDate());
				
				
				Alquiler alquiler=new Alquiler(codigo, cliente, empleado, textVehiculo.getText(), ofi_recoge, 
						                       ofi_devuelve, f_alquila, f_devuelve, false);
				
				
				String precio=""+al.getPrecio()+" €";
				
				lblPrecio.setText(precio);
				btnGrabar.setVisible(true);
			}
		});
		btnBuscar.setBounds(180, 29, 85, 21);
		contentPane.add(btnBuscar);
		
		JLabel lblOficina_Devuelve = new JLabel("Oficina devuelve");
		lblOficina_Devuelve.setBounds(303, 133, 103, 13);
		contentPane.add(lblOficina_Devuelve);
		
		cbOficina_Devuelve = new JComboBox();
		cbOficina_Devuelve.setBounds(415, 131, 230, 21);
		contentPane.add(cbOficina_Devuelve);
		DefaultComboBoxModel dOficina2 =new DefaultComboBoxModel();
		dOficina2.addAll(RepositorioOficina.leeOficinasBasededatos());
		cbOficina_Devuelve.setModel(dOficina2);
		cbOficina_Devuelve.setSelectedIndex(0);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					
					if (RepositorioAlquileres.BuscaAlquilere(textCodigo.getText())==null)
					{
						String codigo=Metodos.CalculaCodigoAlquiler();
						Cliente cliente = (Cliente) cbCliente.getSelectedItem();
						Empleado empleado = (Empleado) cbEmpleado.getSelectedItem();
						Oficina ofi_recoge= (Oficina) cbOficina_Recoge.getSelectedItem();
						Oficina ofi_devuelve = (Oficina) cbOficina_Devuelve.getSelectedItem();
						GregorianCalendar f_alquila= Metodos.PasaDateaGregorianCalendar(textFAlquila.getDate());
						GregorianCalendar f_devuelve= Metodos.PasaDateaGregorianCalendar(textFDevuelve.getDate());
						
						Alquiler alquiler=new Alquiler(codigo, cliente, empleado, textVehiculo.getText(), ofi_recoge, 
								                       ofi_devuelve, f_alquila, f_devuelve, false);
						double precio =Alquiler.CalculaPrecio(alquiler);
						alquiler.setPrecio(precio);
						RepositorioAlquileres.añadeAlqiler(alquiler);
						LimpiaFormnulario();
					}
					
					
				} catch (SQLException | LongitudInvalidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGrabar.setBounds(328, 369, 85, 21);
		contentPane.add(btnGrabar);
		btnGrabar.setVisible(false);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiaFormnulario();
			}
		});
		btnLimpiar.setBounds(438, 369, 85, 21);
		contentPane.add(btnLimpiar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(548, 369, 85, 21);
		contentPane.add(btnSalir);
		
		btndevolver = new JButton("Devolver");
		btndevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String codigo = textCodigo.getText();
				Cliente cliente = (Cliente) cbCliente.getSelectedItem();
				Empleado empleado = (Empleado) cbEmpleado.getSelectedItem();
				Oficina ofi_recoge= (Oficina) cbOficina_Recoge.getSelectedItem();
				Oficina ofi_devuelve = (Oficina) cbOficina_Devuelve.getSelectedItem();
				GregorianCalendar f_alquila= Metodos.PasaDateaGregorianCalendar(textFAlquila.getDate());
				GregorianCalendar f_devuelve= Metodos.PasaDateaGregorianCalendar(textFDevuelve.getDate());
				
				Alquiler alquiler=new Alquiler(codigo, cliente, empleado, textVehiculo.getText(), ofi_recoge, 
						                       ofi_devuelve, f_alquila, f_devuelve, false);
				try {
					RepositorioAlquileres.DevuelveAlquileres(alquiler);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				LimpiaFormnulario();
				
			}
		});
		btndevolver.setBounds(211, 369, 92, 21);
		contentPane.add(btndevolver);
		btndevolver.setVisible(false);
		
		JLabel lblVehiculo = new JLabel("Vehiculo");
		lblVehiculo.setBounds(333, 182, 59, 13);
		contentPane.add(lblVehiculo);
		
		textVehiculo = new JTextField();
		textVehiculo.setBounds(398, 180, 76, 19);
		contentPane.add(textVehiculo);
		textVehiculo.setColumns(10);
		
		cbCliente = new JComboBox();
		cbCliente.setBounds(120, 279, 305, 21);
		contentPane.add(cbCliente);
		DefaultComboBoxModel dcliente =new DefaultComboBoxModel();
		dcliente.addAll(RepositorioCliente.leeClientesBasededatos());
		cbCliente.setModel(dcliente);
		cbCliente.setSelectedIndex(0);
		
		btnBuscaVehiculo = new JButton("Buscar");
		btnBuscaVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (cbTipo.getSelectedIndex()==0)
				{
					try {
						buscador1 = new BuscaVehiculos(RepositorioVehiculos.leeCochesElectricosdeOficinaNoAlquilados((Oficina) cbOficina_Recoge.getSelectedItem()));
						buscador1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						buscador1.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					CochesElectricos ce=null;
					
					
					try {
						ce=RepositorioVehiculos.buscaCocheElectricos(buscador1.getVehiculo().getMatricula());
					} catch (SQLException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					textVehiculo.setText(ce.getMatricula());
					
				}
				else if (cbTipo.getSelectedIndex()==1)
				{
					try {
						buscador2 = new BuscaVehiculos(RepositorioVehiculos.leeCochesCombustiondeOficinaNoAlquilados((Oficina) cbOficina_Recoge.getSelectedItem()));
						buscador2.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						buscador2.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					CochesCombustion cc=null;
					
					try {
						cc=RepositorioVehiculos.buscaCocheCombustion(buscador2.getVehiculo().getMatricula());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					textVehiculo.setText(cc.getMatricula());
				}
				else if (cbTipo.getSelectedIndex()==2)
				{
					try {
						buscador3 = new BuscaVehiculos(RepositorioVehiculos.leeMotosdeOficinaNoAlquilados((Oficina) cbOficina_Recoge.getSelectedItem()));
						buscador3.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						buscador3.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					Motocicletas mo=null;
					
					try {
						mo=RepositorioVehiculos.buscaMotos(buscador3.getVehiculo().getMatricula());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					textVehiculo.setText(mo.getMatricula());
				}
				else
				{
					try {
						buscador4 = new BuscaVehiculos(RepositorioVehiculos.leeFurgonetasdeOficinaNoAlquilados((Oficina) cbOficina_Recoge.getSelectedItem()));
						buscador4.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						buscador4.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					Furgonetas fu=null;
					
					try {
						fu=RepositorioVehiculos.buscaFurgonetas(buscador4.getVehiculo().getMatricula());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					textVehiculo.setText(fu.getMatricula());

				}
			}
		});
		btnBuscaVehiculo.setBounds(494, 178, 85, 21);
		contentPane.add(btnBuscaVehiculo);
		
		JLabel lblTipo = new JLabel("Tipo de vehiculo");
		lblTipo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipo.setBounds(55, 183, 103, 13);
		contentPane.add(lblTipo);
		
		cbTipo = new JComboBox();
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"Coche Electrico", "Coche Combusti\u00F3n", "Furgonetas", "Motocicletas"}));
		cbTipo.setBounds(169, 180, 136, 21);
		contentPane.add(cbTipo);
		
		lblPrecio = new JLabel("");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setBounds(64, 334, 92, 42);
		contentPane.add(lblPrecio);
		
		lblPrecio_estimado = new JLabel("Precio estimado");
		lblPrecio_estimado.setVisible(false);
		lblPrecio_estimado.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio_estimado.setBounds(64, 328, 94, 13);
		contentPane.add(lblPrecio_estimado);
		
		btnPrecio = new JButton("Calcula Precio");
		btnPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblPrecio.setVisible(true);
				lblPrecio_estimado.setVisible(true);
				
				String codigo = null;
				try {
					codigo = Metodos.CalculaCodigoAlquiler();
				} catch (SQLException | LongitudInvalidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Cliente cliente = (Cliente) cbCliente.getSelectedItem();
				Empleado empleado = (Empleado) cbEmpleado.getSelectedItem();
				Oficina ofi_recoge= (Oficina) cbOficina_Recoge.getSelectedItem();
				Oficina ofi_devuelve = (Oficina) cbOficina_Devuelve.getSelectedItem();
				GregorianCalendar f_alquila= Metodos.PasaDateaGregorianCalendar(textFAlquila.getDate());
				GregorianCalendar f_devuelve= Metodos.PasaDateaGregorianCalendar(textFDevuelve.getDate());
				
				Alquiler alquiler=new Alquiler(codigo, cliente, empleado, textVehiculo.getText(), ofi_recoge, 
						                       ofi_devuelve, f_alquila, f_devuelve, false);
				
				String precio=""+Alquiler.CalculaPrecio(alquiler)+" €";
				
				lblPrecio.setText(precio);
				
				btnPrecio.setVisible(false);
				btnGrabar.setVisible(true);
			}
		});
		btnPrecio.setBounds(309, 369, 120, 21);
		contentPane.add(btnPrecio);

	}
	
	private void LimpiaFormnulario ()
	{
		textCodigo.setText("");
		textVehiculo.setText("");
		cbOficina_Devuelve.setSelectedIndex(0);
		cbOficina_Recoge.setSelectedIndex(0);
		cbCliente.setSelectedIndex(0);
		cbEmpleado.setSelectedIndex(0);
		cbTipo.setSelectedIndex(0);
		textFAlquila.setDate(null);
		textFDevuelve.setDate(null);
		lblPrecio.setText("");
		lblPrecio_estimado.setVisible(false);
		lblPrecio.setVisible(false);
		btnGrabar.setVisible(false);
		btnPrecio.setVisible(true);
		cbTipo.setEnabled(true);
		textVehiculo.setEnabled(true);
		cbEmpleado.setEnabled(true);
		cbCliente.setEnabled(true);
		btnExistente.setEnabled(true);
		btnNuevoCliente.setEnabled(true);
		textFAlquila.setEnabled(true);
		cbOficina_Recoge.setEnabled(true);
		btnBuscaVehiculo.setEnabled(true);
	}
}
