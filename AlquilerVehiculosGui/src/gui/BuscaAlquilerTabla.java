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

import accesoadatos.RepositorioAlquileres;
import accesoadatos.RepositorioOficina;
import entidades.Alquiler;
import entidades.Oficina;
import excepciones.LongitudInvalidaException;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscaAlquilerTabla extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Object filas [][];
	private Alquiler alquiler;

	public Alquiler getAlquiler() {
		return alquiler;
	}

	private void setAlquiler(Alquiler alquiler) {
		this.alquiler = alquiler;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			accesoadatos.AccesoADatos.AbreConexion();
			BuscaAlquilerTabla dialog = new BuscaAlquilerTabla();
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
	public BuscaAlquilerTabla() throws SQLException, LongitudInvalidaException {
		setModal(true);
		setBounds(100, 100, 832, 332);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			table = new JTable();
			contentPanel.add(table);
			
			filas = new Object [RepositorioAlquileres.leeAlquileresBasedeDatosActivos().size()+1][8];
			String [] columna= {"Código","Vehiculo","Dni Empleado","Dni cliente","Fecha inicio","Oficina recoge","Fecha entrega","Oficina recoge"};
			
			filas[0][0]="Código";
			filas[0][1]="Vehiculo";
			filas[0][2]="Dni Empleado";	
			filas[0][3]="Dni Cliente";
			filas[0][4]="Fecha inicio";
			filas[0][5]="Oficina alquila";	
			filas[0][6]="Fecha devuelve";
			filas[0][7]="Oficina devuelve";
			
			
			
			for (int i=1;i<(RepositorioAlquileres.leeAlquileresBasedeDatosActivos()).size()+1;i++)
			{
				Alquiler al=RepositorioAlquileres.leeAlquileresBasedeDatosActivos().get(i-1);
				filas[i][0]=al.getCodigo();
				filas[i][1]=al.getVehiculo_alqiuilado().getMatricula();
				filas[i][2]=al.getEmpleado().getDni();
				filas[i][3]=al.getCliente().getDni();
				filas[i][4]=metodos.Metodos.ConvierteGregorianCalendaraString(al.getFecha_alquila());
				filas[i][5]=al.getLugar_alquila().getCodigo();
				filas[i][6]=metodos.Metodos.ConvierteGregorianCalendaraString(al.getFecha_devuelve());
				filas[i][7]=al.getLugar_devuelve().getCodigo();
			}
			
			DefaultTableModel modelo=new DefaultTableModel(filas,columna);
			table.setModel(modelo);
			table.getColumnModel().getColumn(2).setPreferredWidth(83);
			table.getColumnModel().getColumn(5).setPreferredWidth(83);
			table.getColumnModel().getColumn(6).setPreferredWidth(84);
			table.getColumnModel().getColumn(7).setPreferredWidth(85);

		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton BtnSeleccionar = new JButton("Seleccionar");
				BtnSeleccionar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String codigo =(String) filas[table.getSelectedRow()][0];
						try {
							alquiler = RepositorioAlquileres.BuscaAlquilere(codigo);
						} catch (SQLException | LongitudInvalidaException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						setVisible(false);
					}
				});
				BtnSeleccionar.setActionCommand("OK");
				buttonPane.add(BtnSeleccionar);
				getRootPane().setDefaultButton(BtnSeleccionar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
