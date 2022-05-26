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

import accesoadatos.RepositorioCategorias;
import accesoadatos.RepositorioOficina;
import entidades.Categoria;
import entidades.Oficina;

public class BuscaCategoria extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JList ListaCategorias;
	private static BuscaEmpleados dialog;
	private Categoria categoria;
	
	public Categoria getCategoria() 
	{
		return categoria;
	}

	private  void setCategoria(Categoria categoria) 
	{
		this.categoria = categoria;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BuscaCategoria dialog = new BuscaCategoria();
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
	public BuscaCategoria() throws SQLException {
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
				ListaCategorias = new JList();
				DefaultListModel listModel = new DefaultListModel();
				listModel.addAll(RepositorioCategorias.leeCategoriasBasededatos());
				ListaCategorias.setModel(listModel);
				ListaCategorias.setSelectedIndex(0);
				scrollPane.setViewportView(ListaCategorias);
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
						
						
						categoria = (Categoria) ListaCategorias.getSelectedValue();
						
						
						
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
