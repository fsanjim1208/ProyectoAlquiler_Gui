package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import accesoadatos.RepositorioEmpleados;
import accesoadatos.RepositorioOficina;
import accesoadatos.Repositorio_Localidad_Provincia;
import entidades.Oficina;
import excepciones.LongitudInvalidaException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Formulario_Oficina extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextArea textArea;
	private JComboBox cbLocalidad;
	private JComboBox cbProvincia;
	private JCheckBox CheckBoxAeropuerto;
	private BuscaOficinas buscador ;
	private boolean SiAeropuerto;
	private DefaultComboBoxModel dLocalidad =new DefaultComboBoxModel();
	private JButton btnBorrar;
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Formulario_Oficina frame = new Formulario_Oficina();
//					Metodos_Gui.CentraVentana(frame);
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
	public Formulario_Oficina() throws SQLException, LongitudInvalidaException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(27, 40, 45, 13);
		contentPane.add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					try {
//						if(RepositorioEmpleados.leeEmpleados(textDni.getText())!=null)
//						{
							textFieldCodigo.setText(textFieldCodigo.getText().toUpperCase());
							textArea.setText(RepositorioOficina.BuscaOficina(textFieldCodigo.getText()).getDescripcion());				
							cbProvincia.setSelectedItem((String)RepositorioOficina.BuscaOficina(textFieldCodigo.getText()).getProvincia());
							cbLocalidad.setSelectedItem((String)RepositorioOficina.BuscaOficina(textFieldCodigo.getText()).getLocalidad());
							CheckBoxAeropuerto.setSelected(RepositorioOficina.BuscaOficina(textFieldCodigo.getText()).getOficinaAeropuerto());
							btnBorrar.setVisible(true);
							
//						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				}
			}
		});
		textFieldCodigo.setBounds(130, 37, 45, 19);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(27, 85, 93, 13);
		contentPane.add(lblDescripcion);
		
		textArea = new JTextArea();
		textArea.setBounds(130, 75, 228, 37);
		contentPane.add(textArea);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(27, 131, 73, 13);
		contentPane.add(lblProvincia);
		
		cbProvincia = new JComboBox();
		cbProvincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//JOptionPane.showMessageDialog(null, "holaa");
				String nombreprov=(String) cbProvincia.getSelectedItem();
				try {
					dLocalidad.removeAllElements();
					dLocalidad.addAll(Repositorio_Localidad_Provincia.leeLocalidadDeProvincia(nombreprov));
					cbLocalidad.setSelectedIndex(0);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LongitudInvalidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		cbProvincia.setBounds(130, 127, 156, 21);
		contentPane.add(cbProvincia);
		DefaultComboBoxModel de =new DefaultComboBoxModel();
		de.addAll(Repositorio_Localidad_Provincia.leeProvincia());
		cbProvincia.setModel(de);
		
		cbLocalidad = new JComboBox();
		cbLocalidad.setBounds(130, 156, 156, 21);
		contentPane.add(cbLocalidad);
		cbLocalidad.setModel(dLocalidad);
		cbProvincia.setSelectedIndex(0);
		
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(27, 164, 73, 13);
		contentPane.add(lblLocalidad);
		
		JLabel lblAeropuerto = new JLabel("Aeropuerto");
		lblAeropuerto.setBounds(27, 201, 93, 13);
		contentPane.add(lblAeropuerto);
		
		CheckBoxAeropuerto = new JCheckBox("");
		CheckBoxAeropuerto.setBounds(133, 193, 93, 21);
		contentPane.add(CheckBoxAeropuerto);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					buscador = new BuscaOficinas();
					Metodos_Gui.CentraVentana(buscador);
					buscador.setVisible(true);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				textFieldCodigo.setText(buscador.getOficina().getCodigo());
				textArea.setText(buscador.getOficina().getDescripcion());
				cbLocalidad.setSelectedItem((String) buscador.getOficina().getLocalidad());
				cbProvincia.setSelectedItem((String) buscador.getOficina().getProvincia());
				CheckBoxAeropuerto.setSelected(buscador.getOficina().getOficinaAeropuerto());
				btnBorrar.setVisible(true);
			}
		});
		btnBuscar.setBounds(185, 36, 85, 21);
		contentPane.add(btnBuscar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(323, 232, 85, 21);
		contentPane.add(btnCancelar);
		
		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (CheckBoxAeropuerto.isSelected())
				{
					SiAeropuerto=true;
				}
				else
				{
					SiAeropuerto=false;
				}
				
				String localidad=(String) cbLocalidad.getSelectedItem();
				String provincia=(String) cbProvincia.getSelectedItem();
				
				try 
				{
					accesoadatos.RepositorioOficina.añadeOficina(textFieldCodigo.getText(),textArea.getText(),SiAeropuerto,
																	localidad,provincia);
				} 
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				textFieldCodigo.setText("");
				textArea.setText("");
				cbProvincia.setSelectedIndex(0);
				cbLocalidad.setSelectedIndex(0);
				CheckBoxAeropuerto.setSelected(false);
			
			}
		});
		btnGrabar.setBounds(228, 232, 85, 21);
		contentPane.add(btnGrabar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (CheckBoxAeropuerto.isSelected())
				{
					SiAeropuerto=true;
				}
				else
				{
					SiAeropuerto=false;
				}
				
				String localidad=(String) cbLocalidad.getSelectedItem();
				String provincia=(String) cbProvincia.getSelectedItem();
				
				try 
				{
					accesoadatos.RepositorioOficina.eliminaOficina(textFieldCodigo.getText());
				} 
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textFieldCodigo.setText("");
				textArea.setText("");
				cbProvincia.setSelectedIndex(0);
				cbLocalidad.setSelectedIndex(0);
				CheckBoxAeropuerto.setSelected(false);
			}
		});
		btnBorrar.setBounds(141, 232, 85, 21);
		contentPane.add(btnBorrar);
		btnBorrar.setVisible(false);
	}
}
