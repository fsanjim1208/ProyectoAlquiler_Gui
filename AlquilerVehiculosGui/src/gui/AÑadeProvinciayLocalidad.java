package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import accesoadatos.AccesoADatos;
import accesoadatos.Repositorio_Localidad_Provincia;
import excepciones.LongitudInvalidaException;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AÑadeProvinciayLocalidad extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private DefaultComboBoxModel dLocalidad =new DefaultComboBoxModel();
	private JComboBox cbLocalidad;
	private JComboBox cbProvincia;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccesoADatos.AbreConexion();
					AÑadeProvinciayLocalidad frame = new AÑadeProvinciayLocalidad();
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
	public AÑadeProvinciayLocalidad() throws SQLException, LongitudInvalidaException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Provincia");
		lblNewLabel.setBounds(60, 80, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Localidad");
		lblNewLabel_1.setBounds(60, 164, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		cbProvincia = new JComboBox();
		cbProvincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombreprov=(String) cbProvincia.getSelectedItem();
				try {
					dLocalidad.removeAllElements();
					dLocalidad.addAll(Repositorio_Localidad_Provincia.leeLocalidadDeProvincia(nombreprov));
					cbLocalidad.setSelectedIndex(0);
				} 
				catch (SQLException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				catch (LongitudInvalidaException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		cbProvincia.setBounds(135, 76, 158, 21);
		contentPane.add(cbProvincia);
		DefaultComboBoxModel de =new DefaultComboBoxModel();
		de.addAll(Repositorio_Localidad_Provincia.leeProvincia());
		cbProvincia.setModel(de);

		
		cbLocalidad = new JComboBox();
		cbLocalidad.setBounds(135, 117, 156, 21);
		contentPane.add(cbLocalidad);
		cbLocalidad.setModel(dLocalidad);
	
		cbProvincia.setSelectedIndex(0);
		
		
		
		textField = new JTextField();
		textField.setBounds(135, 161, 158, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("grabar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombreloc=textField.getText() ;
				String nombreprov = (String) cbProvincia.getSelectedItem();
				
				try {
					Repositorio_Localidad_Provincia.añadeLocalidad(nombreloc, nombreprov);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField.setText("");
			}
		});
		btnNewButton.setBounds(267, 210, 85, 21);
		contentPane.add(btnNewButton);
		
	
	}
}
