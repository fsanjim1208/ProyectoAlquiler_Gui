package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import accesoadatos.RepositorioEmpleados;
import accesoadatos.RepositorioOficina;
import entidades.Empleado;
import excepciones.LongitudInvalidaException;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscaEmpleados extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JList ListaEmpleados;
	private static BuscaEmpleados dialog;
	private Empleado empleado;
	
	
	public Empleado getEmpleado() 
	{
		return empleado;
	}

	private  void setEmpleado(Empleado empleado) 
	{
		this.empleado = empleado;
	}

	/**
	 * Create the dialog.
	 * @throws SQLException 
	 * @throws LongitudInvalidaException 
	 */
	public BuscaEmpleados() throws SQLException, LongitudInvalidaException {
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
				listModel.addAll(RepositorioEmpleados.leeEmpleadosBasededatos());
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
						
						
						empleado = (Empleado) ListaEmpleados.getSelectedValue();
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
