package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import accesoadatos.RepositorioAlquileres;
import entidades.Alquiler;
import entidades.Vehiculo;
import excepciones.LongitudInvalidaException;

public class Listados_Alquileres extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Object filas [][];
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			Listados_Alquileres dialog = new Listados_Alquileres();
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
	public Listados_Alquileres(ArrayList alquiler,String mensaje) throws SQLException, LongitudInvalidaException {
		setBounds(100, 100, 792, 328);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			
			ArrayList<Alquiler> alquileres = alquiler;
			
			table = new JTable();
			contentPanel.add(table);
			
			filas = new Object [alquiler.size()+1][9];
			String [] columna= {"Código","Vehiculo","Dni Empleado","Dni cliente","Fecha inicio","Oficina recoge","Fecha entrega","Oficina recoge",mensaje};
			
			filas[0][0]="Código";
			filas[0][1]="Vehiculo";
			filas[0][2]="Dni Empleado";	
			filas[0][3]="Dni Cliente";
			filas[0][4]="Fecha inicio";
			filas[0][5]="Oficina alquila";	
			filas[0][6]="Fecha devuelve";
			filas[0][7]="Oficina devuelve";
			filas[0][8]=mensaje;
			
			
			
			for (int i=1;i<alquileres.size()+1;i++)
			{
				filas[i][0]=alquileres.get(i-1).getCodigo();
				filas[i][1]=alquileres.get(i-1).getVehiculo_alqiuilado().getMatricula();
				filas[i][2]=alquileres.get(i-1).getEmpleado().getDni();
				filas[i][3]=alquileres.get(i-1).getCliente().getDni();
				filas[i][4]=metodos.Metodos.ConvierteGregorianCalendaraString(alquileres.get(i-1).getFecha_alquila());
				filas[i][5]=alquileres.get(i-1).getLugar_alquila().getCodigo();
				filas[i][6]=metodos.Metodos.ConvierteGregorianCalendaraString(alquileres.get(i-1).getFecha_devuelve());
				filas[i][7]=alquileres.get(i-1).getLugar_devuelve().getCodigo();
				filas[i][8]=alquileres.get(i-1).getPrecio()+" €";
			}
			
			DefaultTableModel modelo=new DefaultTableModel(filas,columna);
			table.setModel(modelo);
			table.getColumnModel().getColumn(2).setPreferredWidth(83);
			table.getColumnModel().getColumn(5).setPreferredWidth(83);
			table.getColumnModel().getColumn(6).setPreferredWidth(84);
			table.getColumnModel().getColumn(7).setPreferredWidth(85);

		}
		}
	}


