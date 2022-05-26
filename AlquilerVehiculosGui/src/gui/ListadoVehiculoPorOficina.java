package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import accesoadatos.RepositorioCategorias;
import accesoadatos.RepositorioEmpleados;
import accesoadatos.RepositorioOficina;
import accesoadatos.RepositorioVehiculos;
import entidades.Categoria;
import entidades.Oficina;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Rectangle;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadoVehiculoPorOficina extends JDialog {
	private JComboBox comboBox;
	private JList list;
	private DefaultListModel listModel = new DefaultListModel();

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			Listados dialog = new Listados();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 * @throws SQLException 
	 */
	public ListadoVehiculoPorOficina() throws SQLException {
		setBounds(100, 100, 587, 300);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 553, 186);
		getContentPane().add(scrollPane);
		

		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Oficina oficina =(Oficina) comboBox.getSelectedItem();
				try {
					listModel.removeAllElements();
					listModel.addAll(RepositorioVehiculos.leeVehiculosBasededatosdeOficina(oficina));
				} catch (SQLException e1) {
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
		comboBox.setSelectedIndex(2);
		
		scrollPane.setViewportView(list);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(46, 21, 155, 13);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setText("Selecciona la oficina");
	}

}
