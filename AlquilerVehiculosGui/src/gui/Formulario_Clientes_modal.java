package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import accesoadatos.RepositorioCarnetConducir;
import accesoadatos.RepositorioCliente;
import entidades.CarnetConducir;
import entidades.Cliente;
import excepciones.LongitudInvalidaException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Formulario_Clientes_modal extends JDialog {

	private final JPanel contentPane = new JPanel();
	private JTextField textNombre;
	public JTextField textDni;
	private JTextField textApe2;
	private JTextField textApe1;
	private BuscaClientes buscador ;
	private JButton btnBorrar;
	private JComboBox cbCarnetConducir;
	private Cliente cliente;
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			accesoadatos.AccesoADatos.AbreConexion();
			Formulario_Clientes_modal dialog = new Formulario_Clientes_modal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws LongitudInvalidaException 
	 * @throws SQLException 
	 */
	public Formulario_Clientes_modal() throws SQLException, LongitudInvalidaException {
		setModal(true);
		setBounds(100, 100, 385, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton ButtonGrabar = new JButton("Grabar");
				ButtonGrabar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
							cliente = new Cliente(textNombre.getText(), textApe1.getText(), textApe2.getText(), textDni.getText(), (CarnetConducir) cbCarnetConducir.getSelectedItem());
						} catch (LongitudInvalidaException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						try {
							RepositorioCliente.añadeCliente(cliente);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (LongitudInvalidaException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						setVisible(false);
						
					}
				});
				ButtonGrabar.setActionCommand("OK");
				buttonPane.add(ButtonGrabar);
				getRootPane().setDefaultButton(ButtonGrabar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		contentPane.setLayout(null);
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(73, 63, 84, 13);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(149, 60, 109, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblApe1 = new JLabel("Apellido 1:");
		lblApe1.setBounds(73, 104, 67, 13);
		contentPane.add(lblApe1);
		
		JLabel lblApellido2 = new JLabel("Apellido 2:");
		lblApellido2.setBounds(73, 150, 67, 13);
		contentPane.add(lblApellido2);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(97, 27, 45, 13);
		contentPane.add(lblDni);
		
		JLabel lblCarnetConducir = new JLabel("CarnetConducir");
		lblCarnetConducir.setBounds(20, 195, 105, 13);
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
		
		textDni.setBounds(162, 24, 67, 19);
		contentPane.add(textDni);
		textDni.setColumns(10);
		
		textApe2 = new JTextField();
		textApe2.setBounds(136, 147, 139, 19);
		contentPane.add(textApe2);
		textApe2.setColumns(10);
		
		textApe1 = new JTextField();
		textApe1.setBounds(136, 101, 139, 19);
		contentPane.add(textApe1);
		textApe1.setColumns(10);

		cbCarnetConducir = new JComboBox();
		cbCarnetConducir.setBounds(135, 191, 211, 21);
		contentPane.add(cbCarnetConducir);
		DefaultComboBoxModel de =new DefaultComboBoxModel();
		de.addAll(RepositorioCarnetConducir.leeCarnetConducir());
		cbCarnetConducir.setModel(de);
		cbCarnetConducir.setSelectedIndex(0);
		
		
		
	}

}
