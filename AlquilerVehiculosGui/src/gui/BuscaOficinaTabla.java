package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import accesoadatos.RepositorioOficina;
import entidades.Oficina;

import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class BuscaOficinaTabla extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BuscaOficinaTabla dialog = new BuscaOficinaTabla();
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
	public BuscaOficinaTabla() throws SQLException {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			table = new JTable();
			contentPanel.add(table);
			Object columnas[] = {"NOMBRES","CEDULA","DIRECCION","SEXO (M/F)","HOBBIES"};
			Object[] fila = new Object[10];
			
			//FormularioCapa contador = new FormularioCapa();
			
			Oficina pnew; //esta es la clase que tiene las variables de persona
			 
			                                                                                   

			
			 DefaultTableModel modelotabla = new DefaultTableModel(columnas,0); //0 son las filas
			 
			 
			 
			 ArrayList<Oficina> list = RepositorioOficina.leeOficinasBasededatos();


			    for(int i=0;i<10;i++){
			    fila[i]=list.get(i).getCodigo();
			    fila[i]=list.get(i).getDescripcion();
			    fila[i]=list.get(i).getLocalidad();
			    fila[i]=list.get(i).getProvincia();
			        modelotabla.addRow(fila);
			    }
			 
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
