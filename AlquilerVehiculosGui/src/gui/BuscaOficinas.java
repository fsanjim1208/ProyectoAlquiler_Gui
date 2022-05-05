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

import accesoadatos.RepositorioEmpleados;
import accesoadatos.RepositorioOficina;
import entidades.Empleado;
import entidades.Oficina;

public class BuscaOficinas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JList ListaEmpleados;
	private static BuscaEmpleados dialog;
	private Oficina oficina;
	
	
	public Oficina getOficina() 
	{
		return oficina;
	}

	private  void setOficina(Oficina oficina) 
	{
		this.oficina = oficina;
	}
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			BuscaOficinas dialog = new BuscaOficinas();
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
	public BuscaOficinas() throws SQLException {
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
				ListaEmpleados = new JList();
				DefaultListModel listModel = new DefaultListModel();
				listModel.addAll(RepositorioOficina.leeOficinasBasededatos());
				ListaEmpleados.setModel(listModel);
				ListaEmpleados.setSelectedIndex(0);
				scrollPane.setViewportView(ListaEmpleados);
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
						
						
						oficina = (Oficina) ListaEmpleados.getSelectedValue();
						
						
						
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
