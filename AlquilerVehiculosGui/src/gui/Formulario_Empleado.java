package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import accesoadatos.AccesoADatos;
import accesoadatos.RepositorioOficina;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class Formulario_Empleado extends JFrame {

	private JPanel contentPane;
	private JTextField textfieldNombre;
	private JTextField textField;
	private JTextField textDni;
	private JTextField textApe2;
	private JTextField textApe1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario_Empleado frame = new Formulario_Empleado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Formulario_Empleado() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 251);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(31, 26, 84, 13);
		contentPane.add(lblNombre);
		
		textfieldNombre = new JTextField();
		textfieldNombre.setBounds(119, 23, 96, 19);
		contentPane.add(textfieldNombre);
		textfieldNombre.setColumns(10);
		
		JLabel lblApe1 = new JLabel("Apellido 1:");
		lblApe1.setBounds(31, 49, 67, 13);
		contentPane.add(lblApe1);
		
		JLabel lblApellido2 = new JLabel("Apellido 2:");
		lblApellido2.setBounds(31, 72, 67, 13);
		contentPane.add(lblApellido2);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(31, 95, 45, 13);
		contentPane.add(lblDni);
		
		JLabel lblFechaAlta = new JLabel("Fecha de alta:");
		lblFechaAlta.setBounds(31, 118, 78, 13);
		contentPane.add(lblFechaAlta);
		
		JLabel lblOficina = new JLabel("Oficina:");
		lblOficina.setBounds(31, 141, 50, 13);
		contentPane.add(lblOficina);
		
		JComboBox cbOficinas = new JComboBox();
		cbOficinas.setBounds(91, 137, 335, 21);
		contentPane.add(cbOficinas);
		DefaultComboBoxModel d =new DefaultComboBoxModel();
		d.addAll(RepositorioOficina.leeOficinasBasededatos());
		cbOficinas.setModel(d);
		cbOficinas.setSelectedIndex(0);
		
		
		textField = new JTextField();
		textField.setBounds(119, 115, 118, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textDni = new JTextField();
		textDni.setBounds(119, 92, 84, 19);
		contentPane.add(textDni);
		textDni.setColumns(10);
		
		textApe2 = new JTextField();
		textApe2.setBounds(119, 69, 179, 19);
		contentPane.add(textApe2);
		textApe2.setColumns(10);
		
		textApe1 = new JTextField();
		textApe1.setBounds(119, 46, 179, 19);
		contentPane.add(textApe1);
		textApe1.setColumns(10);
		
		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.setBounds(213, 179, 85, 21);
		contentPane.add(btnGrabar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(309, 179, 85, 21);
		contentPane.add(btnCancelar);
	}
}
