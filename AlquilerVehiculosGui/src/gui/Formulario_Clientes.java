package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import accesoadatos.RepositorioAlquileres;
import accesoadatos.RepositorioCarnetConducir;
import accesoadatos.RepositorioCliente;
import accesoadatos.RepositorioEmpleados;
import accesoadatos.RepositorioOficina;
import entidades.Alquiler;
import entidades.CarnetConducir;
import entidades.Cliente;
import entidades.Empleado;
import entidades.Oficina;
import excepciones.LongitudInvalidaException;
import javax.swing.ImageIcon;

public class Formulario_Clientes extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	public JTextField textDni;
	private JTextField textApe2;
	private JTextField textApe1;
	private BuscaClientes buscador ;
	private JButton btnBorrar;
	private JComboBox cbCarnetConducir;


//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Formulario_Clientes frame = new Formulario_Clientes();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws LongitudInvalidaException 
	 */
	public Formulario_Clientes() throws SQLException, LongitudInvalidaException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 479, 308);
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
		lblDni.setBounds(31, 26, 45, 13);
		contentPane.add(lblDni);
		
		JLabel lblCarnetConducir = new JLabel("CarnetConducir");
		lblCarnetConducir.setBounds(31, 195, 84, 13);
		contentPane.add(lblCarnetConducir);
		
		
		textDni = new JTextField();
		textDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					try {
						if(RepositorioCliente.BuscaCliente(textDni.getText())!=null)
						{
							textNombre.setText(RepositorioCliente.BuscaCliente(textDni.getText()).getNombre());
							textDni.setEnabled(false);
							textApe1.setText(RepositorioCliente.BuscaCliente(textDni.getText()).getApe1());
							textApe2.setText(RepositorioCliente.BuscaCliente(textDni.getText()).getApe2());
							
							cbCarnetConducir.setSelectedItem(RepositorioCliente.BuscaCliente(textDni.getText()).getTipoCarnet());
							
							btnBorrar.setVisible(true);
							
						}
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

		cbCarnetConducir = new JComboBox();
		cbCarnetConducir.setBounds(145, 191, 231, 21);
		contentPane.add(cbCarnetConducir);
		DefaultComboBoxModel de =new DefaultComboBoxModel();
		de.addAll(RepositorioCarnetConducir.leeCarnetConducir());
		cbCarnetConducir.setModel(de);
		cbCarnetConducir.setSelectedIndex(0);
		
		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.setIcon(new ImageIcon(Formulario_Clientes.class.getResource("/imagenes/diskette.png")));
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if (RepositorioCliente.BuscaCliente(textDni.getText())==null)
					{
						Cliente cliente= new Cliente(textNombre.getText(), textApe1.getText(), textApe2.getText(), textDni.getText(), (CarnetConducir) cbCarnetConducir.getSelectedItem());
						RepositorioCliente.añadeCliente(cliente);
						LimpiaFormulario();
					}
					else 
					{
						Cliente clientenuevo=new Cliente(textNombre.getText(), textApe1.getText(), textApe2.getText(), textDni.getText(), (CarnetConducir) cbCarnetConducir.getSelectedItem());
						RepositorioCliente.modificaCliente(clientenuevo);
						LimpiaFormulario();
					}

				} catch (LongitudInvalidaException | SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
							
				LimpiaFormulario();
		
			
			}
		});

		btnGrabar.setBounds(145, 237, 96, 21);
		contentPane.add(btnGrabar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(Formulario_Clientes.class.getResource("/imagenes/close.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		btnCancelar.setBounds(346, 237, 109, 21);
		contentPane.add(btnCancelar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(Formulario_Clientes.class.getResource("/imagenes/zoom.png")));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

					try 
					{
						buscador = new BuscaClientes();
						Metodos_Gui.CentraVentana(buscador);
						buscador.setVisible(true);
												
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (LongitudInvalidaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					textDni.setText(buscador.getCliente().getDni());
					textDni.setEnabled(false);
					textNombre.setText(buscador.getCliente().getNombre());
					textApe1.setText(buscador.getCliente().getApe1());
					textApe2.setText(buscador.getCliente().getApe2());
					cbCarnetConducir.setSelectedItem((CarnetConducir)buscador.getCliente().getTipoCarnet());
					
					btnBorrar.setVisible(true);
				
			}
		});
		btnBuscar.setBounds(213, 22, 109, 21);
		contentPane.add(btnBuscar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				textDni.setText("");
				textDni.setEnabled(true);
				textNombre.setText("");
				textApe1.setText("");
				textApe2.setText("");
				cbCarnetConducir.setSelectedIndex(0);
				
				btnBorrar.setVisible(false);
			}
		});
		btnLimpiar.setBounds(251, 237, 85, 21);
		contentPane.add(btnLimpiar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setIcon(new ImageIcon(Formulario_Clientes.class.getResource("/imagenes/recycle_bin.png")));
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					RepositorioCliente.eliminaCliente(textDni.getText());
				} catch (SQLException | LongitudInvalidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				textDni.setText("");
				textDni.setEnabled(true);
				textNombre.setText("");
				textApe1.setText("");
				textApe2.setText("");
				cbCarnetConducir.setSelectedIndex(0);cbCarnetConducir.setSelectedIndex(0);
				btnBorrar.setVisible(false);
				
			}
		});
		btnBorrar.setBounds(31, 237, 104, 21);
		contentPane.add(btnBorrar);
		

		
		
	}
	
	private void LimpiaFormulario()
	{
		textDni.setText("");
		textNombre.setText("");
		textApe1.setText("");
		textApe2.setText("");
		cbCarnetConducir.setSelectedIndex(0);
	}

}
