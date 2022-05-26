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

import accesoadatos.RepositorioAlquileres;
import accesoadatos.RepositorioOficina;
import entidades.Alquiler;
import entidades.Oficina;
import excepciones.LongitudInvalidaException;

public class BuscaAlquileres extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JList ListaAlquileres;
	private Alquiler alquiler;
	

	public Alquiler getAlquiler() {
		return alquiler;
	}

	public void setAlquiler(Alquiler alquiler) {
		this.alquiler = alquiler;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			accesoadatos.AccesoADatos.AbreConexion();
			BuscaAlquileres dialog = new BuscaAlquileres();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws SQLException 
	 * @throws LongitudInvalidaException 
	 */
	public BuscaAlquileres() throws SQLException, LongitudInvalidaException {
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
				ListaAlquileres = new JList();
				DefaultListModel listModel = new DefaultListModel();
				listModel.addAll(RepositorioAlquileres.leeAlquileresBasedeDatos());
				ListaAlquileres.setModel(listModel);
				ListaAlquileres.setSelectedIndex(0);
				scrollPane.setViewportView(ListaAlquileres);
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
						
						
						alquiler = (Alquiler) ListaAlquileres.getSelectedValue();
						
						
						
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
