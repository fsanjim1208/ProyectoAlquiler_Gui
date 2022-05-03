package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import accesoadatos.AccesoADatos;
import accesoadatos.RepositorioOficina;
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



	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Formulario_Empleado() throws SQLException {
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
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Oficina oficina= (Oficina) cbOficinas.getSelectedItem();
				String codigoOficina=oficina.getCodigo();
				
				try 
				{
					accesoadatos.RepositorioEmpleados.aņadeEmpleado(textNombre.getText(),textApe1.getText(),textApe2.getText(),
																	textDni.getText(),lblFecha.getText(),codigoOficina);
				} 
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				textDni.setText("");
				textNombre.setText("");
				textApe1.setText("");
				textApe2.setText("");
				cbOficinas.setSelectedIndex(0);
				lblFecha.setText("");
			
			}
		});

		btnGrabar.setBounds(323, 288, 85, 21);
		contentPane.add(btnGrabar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnCancelar.setBounds(513, 288, 85, 21);
		contentPane.add(btnCancelar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textDni.getText().equals(""))
				{
					try 
					{
						buscador = new BuscaEmpleados();
						buscador.setVisible(true);
						Metodos_Gui.CentraVentana(buscador);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (LongitudInvalidaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					textDni.setText(buscador.getEmpleado().getDni());
					textNombre.setText(buscador.getEmpleado().getNombre());
					textApe1.setText(buscador.getEmpleado().getApe1());
					textApe2.setText(buscador.getEmpleado().getApe2());
					cbOficinas.setSelectedItem(buscador.getEmpleado().getOficinaEmpleado());
					GregorianCalendar fecha=buscador.getEmpleado().getFechaAltEmpleado();
					String fechaalt= fecha.getTime().getDate()+"/"+(fecha.getTime().getMonth()+1)+"/"+(fecha.getTime().getYear()+1900);
					TextFieldFechaAlta.setText(fechaalt);
					lblFecha.setText(fechaalt);
				}
				else
				{
					
				}
			}
		});
		btnBuscar.setBounds(213, 22, 85, 21);
		contentPane.add(btnBuscar);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(355, 23, 214, 157);
		contentPane.add(calendar);
		calendar.setVisible(false);
		
		JButton btnNewButton = new JButton("Abrir Calendario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calendar.setVisible(true);
				btnSeleccionar.setVisible(true);
			}
		});
		btnNewButton.setBounds(213, 184, 126, 21);
		contentPane.add(btnNewButton);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textDni.setText("");
				textNombre.setText("");
				textApe1.setText("");
				textApe2.setText("");
				cbOficinas.setSelectedIndex(0);
				lblFecha.setText("");
			}
		});
		btnLimpiar.setBounds(418, 288, 85, 21);
		contentPane.add(btnLimpiar);
		
		TextFieldFechaAlta = new JTextField();
		TextFieldFechaAlta.setEnabled(false);
		TextFieldFechaAlta.setBounds(70, 289, 96, 19);
		contentPane.add(TextFieldFechaAlta);
		TextFieldFechaAlta.setColumns(10);
		TextFieldFechaAlta.setVisible(false);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String dia =calendar.getDate().getDate()+"/"+(calendar.getDate().getMonth()+1)+"/"+(calendar.getDate().getYear()+1900);; 
				
				//JOptionPane.showMessageDialog(null, dia);
				
				TextFieldFechaAlta.setText(dia);
				lblFecha.setText(dia);
			}
		});
		btnSeleccionar.setBounds(407, 184, 107, 21);
		btnSeleccionar.setVisible(false);
		contentPane.add(btnSeleccionar);
		
		panelFecha = new JPanel();
		panelFecha.setBackground(Color.WHITE);
		panelFecha.setBounds(119, 188, 67, 19);
		contentPane.add(panelFecha);
		panelFecha.setLayout(null);
		
		lblFecha = new JLabel("");
		lblFecha.setBounds(5, 0, 62, 19);
		panelFecha.add(lblFecha);
		
		
	
	}
}
