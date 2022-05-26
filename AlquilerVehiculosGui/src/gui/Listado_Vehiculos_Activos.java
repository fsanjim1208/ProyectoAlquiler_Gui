package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import accesoadatos.RepositorioVehiculos;
import entidades.Vehiculo;

public class Listado_Vehiculos_Activos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JList ListaVehiculo;
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			Listado_Vehiculos_Activos dialog = new Listado_Vehiculos_Activos();
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
	public Listado_Vehiculos_Activos(ArrayList listavehiculos) throws SQLException {
		setBounds(100, 100, 618, 380);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				ListaVehiculo = new JList();
				DefaultListModel listModel = new DefaultListModel();
				listModel.addAll(listavehiculos);
				ListaVehiculo.setModel(listModel);
				ListaVehiculo.setSelectedIndex(0);
				scrollPane.setViewportView(ListaVehiculo);
			}
		}
		
	}

}
