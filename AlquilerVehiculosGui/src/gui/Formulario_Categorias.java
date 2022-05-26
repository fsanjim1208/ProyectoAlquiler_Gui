package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import accesoadatos.AccesoADatos;
import accesoadatos.Repositorio_Localidad_Provincia;
import excepciones.LongitudInvalidaException;

public class Formulario_Categorias extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextArea textArea;
	private BuscaCategoria buscador ;
	private JTextField textFieldRecargo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccesoADatos.AbreConexion();
					Formulario_Categorias frame = new Formulario_Categorias();
					Metodos_Gui.CentraVentana(frame);
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
	public Formulario_Categorias() throws SQLException, LongitudInvalidaException {
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
		textFieldCodigo.setBounds(130, 37, 45, 19);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(27, 100, 93, 13);
		contentPane.add(lblDescripcion);
		
		textArea = new JTextArea();
		textArea.setBounds(130, 85, 228, 37);
		contentPane.add(textArea);
		

		JLabel lblRecargo = new JLabel("Recargo");
		lblRecargo.setBounds(27, 153, 45, 13);
		contentPane.add(lblRecargo);
		
		textFieldRecargo = new JTextField();
		textFieldRecargo.setBounds(130, 150, 33, 19);
		contentPane.add(textFieldRecargo);
		textFieldRecargo.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					buscador = new BuscaCategoria();
					Metodos_Gui.CentraVentana(buscador);
					buscador.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				textFieldCodigo.setText(buscador.getCategoria().getCodigo());
				textArea.setText(buscador.getCategoria().getDescripcion());
				String recargo=""+buscador.getCategoria().getRecargo();
				textFieldRecargo.setText(recargo);

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
				
			}
		});
		btnGrabar.setBounds(228, 232, 85, 21);
		contentPane.add(btnGrabar);
		
	
		
	}
}
