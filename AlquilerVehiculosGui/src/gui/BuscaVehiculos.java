package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import accesoadatos.RepositorioOficina;
import accesoadatos.RepositorioVehiculos;
import entidades.CochesCombustion;
import entidades.Oficina;
import entidades.Vehiculo;

public class BuscaVehiculos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JList ListaVehiculo;
	private static BuscaEmpleados dialog;
	private Vehiculo vehiculo;
	
	
	public Vehiculo getVehiculo() 
	{
		return vehiculo;
	}

	private  void setVehiculo(Vehiculo vehiculo) 
	{
		this.vehiculo = vehiculo;
	}


	/**
	 * Create the dialog.
	 * @throws SQLException 
	 */
	public BuscaVehiculos(ArrayList<Vehiculo> vehiculosLista) throws SQLException {
		setModal(true);
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
				listModel.addAll(vehiculosLista);
				ListaVehiculo.setModel(listModel);
				ListaVehiculo.setSelectedIndex(0);
				scrollPane.setViewportView(ListaVehiculo);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton SelectButton = new JButton("Seleccionar");
				SelectButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						vehiculo = (Vehiculo) ListaVehiculo.getSelectedValue();
						
						
						setVisible(false);
		
					}
					
				});
				SelectButton.setActionCommand("OK");
				buttonPane.add(SelectButton);
				getRootPane().setDefaultButton(SelectButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				buttonPane.add(cancelButton);
			}
		}
	}

}
