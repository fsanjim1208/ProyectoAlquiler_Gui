package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import accesoadatos.RepositorioCliente;
import accesoadatos.RepositorioEmpleados;
import entidades.Cliente;
import entidades.Empleado;
import excepciones.LongitudInvalidaException;

public class BuscaClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JList ListaCliente;
	private static BuscaEmpleados dialog;
	private Cliente cliente;
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			BuscaClientes dialog = new BuscaClientes();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 * @throws LongitudInvalidaException 
	 * @throws SQLException 
	 */
	public BuscaClientes() throws SQLException, LongitudInvalidaException {
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
				ListaCliente = new JList();
				DefaultListModel listModel = new DefaultListModel();
				listModel.addAll(RepositorioCliente.leeClientesBasededatos());
				ListaCliente.setModel(listModel);
				ListaCliente.setSelectedIndex(0);
				scrollPane.setViewportView(ListaCliente);
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
						
						
						cliente = (Cliente) ListaCliente.getSelectedValue();
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
