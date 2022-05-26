package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import accesoadatos.AccesoADatos;
import accesoadatos.RepositorioAlquileres;
import accesoadatos.RepositorioEmpleados;
import accesoadatos.RepositorioOficina;
import entidades.Alquiler;
import entidades.Empleado;
import entidades.Oficina;
import excepciones.LongitudInvalidaException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Formulario_Empleado extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	public JTextField textDni;
	private JTextField textApe2;
	private JTextField textApe1;
	private BuscaEmpleados buscador ;
	private JComboBox cbOficinas;
	private JTextField TextFieldFechaAlta;
	private JButton btnSeleccionar;
	private JPanel panelFecha;
	private JLabel lblFecha;
	private JButton btnBorrar;



	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Formulario_Empleado() throws SQLException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 622, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(31, 62, 84, 13);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(119, 59, 179, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblApe1 = new JLabel("Apellido 1:");
		lblApe1.setBounds(31, 103, 67, 13);
		contentPane.add(lblApe1);
		
		JLabel lblApellido2 = new JLabel("Apellido 2:");
		lblApellido2.setBounds(31, 149, 67, 13);
		contentPane.add(lblApellido2);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBackground(Color.PINK);
		lblDni.setBounds(31, 26, 45, 13);
		contentPane.add(lblDni);
		
		JLabel lblFechaAlta = new JLabel("Fecha de alta:");
		lblFechaAlta.setBounds(31, 188, 78, 13);
		contentPane.add(lblFechaAlta);
		
		JLabel lblOficina = new JLabel("Oficina:");
		lblOficina.setBounds(31, 229, 50, 13);
		contentPane.add(lblOficina);
		
		cbOficinas = new JComboBox();
		cbOficinas.setBounds(101, 225, 335, 21);
		contentPane.add(cbOficinas);
		DefaultComboBoxModel d =new DefaultComboBoxModel();
		d.addAll(RepositorioOficina.leeOficinasBasededatos());
		cbOficinas.setModel(d);
		cbOficinas.setSelectedIndex(0);
		
		textDni = new JTextField();
		textDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					try {
//						if(RepositorioEmpleados.leeEmpleados(textDni.getText())!=null)
//						{
							textNombre.setText(RepositorioEmpleados.BuscaEmpleados(textDni.getText()).getNombre());
							textDni.setEnabled(false);
							textApe1.setText(RepositorioEmpleados.BuscaEmpleados(textDni.getText()).getApe1());
							textApe2.setText(RepositorioEmpleados.BuscaEmpleados(textDni.getText()).getApe2());
							
							GregorianCalendar fecha=RepositorioEmpleados.BuscaEmpleados(textDni.getText()).getFechaAltEmpleado();
							String fechaalt= fecha.getTime().getDate()+"/"+(fecha.getTime().getMonth()+1)+"/"+(fecha.getTime().getYear()+1900);
							TextFieldFechaAlta.setText(fechaalt);
							lblFecha.setText(fechaalt);
							
							cbOficinas.setSelectedItem((Oficina)RepositorioEmpleados.BuscaEmpleados(textDni.getText()).getOficinaEmpleado());
							
							btnBorrar.setVisible(true);
							
//						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (LongitudInvalidaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		textDni.setBounds(119, 23, 84, 19);
		contentPane.add(textDni);
		textDni.setColumns(10);
		
		textApe2 = new JTextField();
		textApe2.setBounds(119, 146, 179, 19);
		contentPane.add(textApe2);
		textApe2.setColumns(10);
		
		textApe1 = new JTextField();
		textApe1.setBounds(119, 100, 179, 19);
		contentPane.add(textApe1);
		textApe1.setColumns(10);
		
		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.setIcon(new ImageIcon(Formulario_Empleado.class.getResource("/imagenes/diskette.png")));
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if (RepositorioEmpleados.BuscaEmpleados(textDni.getText())==null)
					{
						Oficina oficina= (Oficina) cbOficinas.getSelectedItem();
						String codigoOficina=oficina.getCodigo();
						
						try 
						{
						
							accesoadatos.RepositorioEmpleados.añadeEmpleado(textNombre.getText(),textApe1.getText(),textApe2.getText(),
																			textDni.getText(),lblFecha.getText(),codigoOficina);
						} 
						catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "No se ha podido grabar al empleado");
						}
					}
					else if (RepositorioEmpleados.BuscaEmpleados(textDni.getText())!=null && 
							 RepositorioAlquileres.BuscaAlquileresDeEmpleado(textDni.getText())!=null)
					{

						Alquiler alquiler=RepositorioAlquileres.BuscaAlquileresDeEmpleado(textDni.getText());
						
						Empleado empleadoviejo = alquiler.getEmpleado();
						
						Oficina oficina= (Oficina) cbOficinas.getSelectedItem();
						String codigoOficina=oficina.getCodigo();
						
						
						GregorianCalendar fecha=(GregorianCalendar) Calendar.getInstance();
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						fecha.setTime(sdf.parse(TextFieldFechaAlta.getText()));
						
						Empleado empleadonuevo=new Empleado(textNombre.getText(),textApe1.getText(),textApe2.getText(),
								textDni.getText(),fecha,oficina);
						
						RepositorioEmpleados.modificaEmpleado(empleadoviejo, empleadonuevo);
					
					}
					else if (RepositorioEmpleados.BuscaEmpleados(textDni.getText())!=null && 
							 RepositorioAlquileres.BuscaAlquileresDeEmpleado(textDni.getText())==null)
					{
						Empleado empleviejo= buscador.getEmpleado();
						
						RepositorioEmpleados.eliminaEmpleado(empleviejo);
						
						Oficina oficina= (Oficina) cbOficinas.getSelectedItem();
						String codigoOficina=oficina.getCodigo();
						
						GregorianCalendar fecha=(GregorianCalendar) Calendar.getInstance();
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						fecha.setTime(sdf.parse(TextFieldFechaAlta.getText()));
						Empleado empleadonuevo=new Empleado(textNombre.getText(),textApe1.getText(),textApe2.getText(),
								textDni.getText(),fecha,oficina);
						
						RepositorioEmpleados.añadeEmpleado(empleadonuevo);
					}
					else 
					{
						
					}

				} catch (SQLException | LongitudInvalidaException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//Limpiar formulario
				textDni.setText("");
				textNombre.setText("");
				textApe1.setText("");
				textApe2.setText("");
				cbOficinas.setSelectedIndex(0);
				lblFecha.setText("");
			
			}
		});

		btnGrabar.setBounds(285, 288, 96, 21);
		contentPane.add(btnGrabar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(Formulario_Empleado.class.getResource("/imagenes/close.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		btnCancelar.setBounds(486, 288, 112, 21);
		contentPane.add(btnCancelar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(Formulario_Empleado.class.getResource("/imagenes/zoom.png")));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textDni.getText().equals(""))
				{
					try 
					{
						buscador = new BuscaEmpleados();
						Metodos_Gui.CentraVentana(buscador);
						buscador.setVisible(true);
												
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (LongitudInvalidaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					textDni.setText(buscador.getEmpleado().getDni());
					textDni.setEnabled(false);
					textNombre.setText(buscador.getEmpleado().getNombre());
					textApe1.setText(buscador.getEmpleado().getApe1());
					textApe2.setText(buscador.getEmpleado().getApe2());
					cbOficinas.setSelectedItem(buscador.getEmpleado().getOficinaEmpleado());
					GregorianCalendar fecha=buscador.getEmpleado().getFechaAltEmpleado();
					String fechaalt= fecha.getTime().getDate()+"/"+(fecha.getTime().getMonth()+1)+"/"+(fecha.getTime().getYear()+1900);
					TextFieldFechaAlta.setText(fechaalt);
					lblFecha.setText(fechaalt);
					btnBorrar.setVisible(true);
				}
				else
				{
					
				}
			}
		});
		btnBuscar.setBounds(213, 22, 107, 21);
		contentPane.add(btnBuscar);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(355, 23, 214, 157);
		contentPane.add(calendar);
		calendar.setVisible(true);
		
		JButton btnNewButton = new JButton("Abrir Calendario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calendar.setVisible(true);
				btnSeleccionar.setVisible(true);
			}
		});
		btnNewButton.setBounds(213, 184, 126, 21);
		contentPane.add(btnNewButton);
		btnNewButton.setVisible(false);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				textDni.setText("");
				textDni.setEnabled(true);
				textNombre.setText("");
				textApe1.setText("");
				textApe2.setText("");
				cbOficinas.setSelectedIndex(0);
				lblFecha.setText("");
				btnBorrar.setVisible(false);
			}
		});
		btnLimpiar.setBounds(391, 288, 85, 21);
		contentPane.add(btnLimpiar);
		
		TextFieldFechaAlta = new JTextField();
		TextFieldFechaAlta.setEnabled(false);
		TextFieldFechaAlta.setBounds(70, 289, 96, 19);
		contentPane.add(TextFieldFechaAlta);
		TextFieldFechaAlta.setColumns(10);
		TextFieldFechaAlta.setVisible(false);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setIcon(new ImageIcon(Formulario_Empleado.class.getResource("/imagenes/add.png")));
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String dia =calendar.getDate().getDate()+"/"+(calendar.getDate().getMonth()+1)+"/"+(calendar.getDate().getYear()+1900);; 
				
				//JOptionPane.showMessageDialog(null, dia);
				
				TextFieldFechaAlta.setText(dia);
				lblFecha.setText(dia);
			}
		});
		btnSeleccionar.setBounds(391, 184, 141, 21);
		btnSeleccionar.setVisible(true);
		contentPane.add(btnSeleccionar);
		
		panelFecha = new JPanel();
		panelFecha.setBackground(Color.WHITE);
		panelFecha.setBounds(119, 188, 67, 19);
		contentPane.add(panelFecha);
		panelFecha.setLayout(null);
		
		lblFecha = new JLabel("");
		lblFecha.setBounds(5, 0, 62, 19);
		panelFecha.add(lblFecha);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setIcon(new ImageIcon(Formulario_Empleado.class.getResource("/imagenes/recycle_bin.png")));
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					RepositorioEmpleados.EliminaEmpleado(textDni.getText());
				} catch (SQLException | LongitudInvalidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				textDni.setText("");
				textNombre.setText("");
				textApe1.setText("");
				textApe2.setText("");
				cbOficinas.setSelectedIndex(0);
				lblFecha.setText("");
				btnBorrar.setVisible(false);
				
			}
		});
		btnBorrar.setBounds(176, 288, 99, 21);
		contentPane.add(btnBorrar);
		btnBorrar.setVisible(false);
		
	
	}
}
