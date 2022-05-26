package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import accesoadatos.RepositorioCategorias;
import accesoadatos.RepositorioEmpleados;
import accesoadatos.RepositorioOficina;
import accesoadatos.RepositorioVehiculos;
import entidades.Categoria;
import entidades.Oficina;
import excepciones.LongitudInvalidaException;

public class Listado_empleado_oficina extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox comboBox;
	private JList list;
	private DefaultListModel listModel = new DefaultListModel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Listado_empleado_oficina dialog = new Listado_empleado_oficina();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws SQLException 
	 */
	public Listado_empleado_oficina() throws SQLException {
		setBounds(100, 100, 587, 300);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 553, 186);
		getContentPane().add(scrollPane);
		

		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Oficina ofi=(Oficina) comboBox.getSelectedItem();
				String cod_ofi=ofi.getCodigo();
				try {
					listModel.removeAllElements();
					listModel.addAll(RepositorioEmpleados.BuscaEmpleadodeOficina(cod_ofi));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LongitudInvalidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		comboBox.setBounds(211, 17, 306, 21);
		getContentPane().add(comboBox);
		DefaultComboBoxModel dOficina =new DefaultComboBoxModel();
		dOficina.addAll(RepositorioOficina.leeOficinasBasededatos());
		comboBox.setModel(dOficina);

		
		list = new JList();
		list.setModel(listModel);
		comboBox.setSelectedIndex(0);
		
		scrollPane.setViewportView(list);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(46, 21, 155, 13);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setText("Selecciona la oficina");
	}
}
