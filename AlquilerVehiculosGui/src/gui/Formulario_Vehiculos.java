package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import accesoadatos.AccesoADatos;
import accesoadatos.RepositorioCarnetConducir;
import accesoadatos.RepositorioCategorias;
import accesoadatos.RepositorioOficina;
import accesoadatos.RepositorioVehiculos;
import entidades.CarnetConducir;
import entidades.Categoria;
import entidades.CochesCombustion;
import entidades.CochesElectricos;
import entidades.Furgonetas;
import entidades.Motocicletas;
import entidades.Oficina;
import excepciones.LongitudInvalidaException;
import metodos.Metodos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Formulario_Vehiculos extends JFrame {

	
	

	private JPanel contentPane;
	private JLabel lblMatricula;
	private JLabel lblMarca;
	private JLabel lblColor;
	private JLabel lblKm;
	private JLabel lblFechaAdquisicion;
	private JLabel lblTipoVehiculo;
	private JTextField textMatricula;
	private JTextField textMarca;
	private JTextField textModelo;
	private JTextField textColor;
	private JTextField textKm;
	private JComboBox cbOficina;
	private JComboBox cbCategoria;
	private JLabel lblConsumo;
	private JLabel lblPotencia;
	private JLabel lblEmisiones;
	private JLabel lblAutonomia;
	private JLabel lblRecarga;
	private JLabel lblPlazas;
	private JLabel lblTipo;
	private JLabel lblCilindrada;
	private JLabel lblCarnetConducir;
	private JLabel lblCapacidad;
	private JButton btnCancelar;
	private JTextField textAutonomia;
	private JTextField textRecarga;
	private JComboBox cbTipoVehiculo;
	private JTextField textCapacidad;
	private JSpinner TextPlazas;
	private JComboBox cbTipo;
	private JComboBox cbCarnet;
	private JTextField textCilindrada;
	private JTextField textConsumo;
	private JTextField textEmisiones;
	private JTextField textPotencia;
	private BuscaVehiculos buscador1;
	private BuscaVehiculos buscador2;
	private BuscaVehiculos buscador3;
	private BuscaVehiculos buscador4;
	private JDateChooser TextFechaAdquisicion;
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AccesoADatos.AbreConexion();
//					
//					Formulario_Vehiculos frame = new Formulario_Vehiculos();
//					Metodos_Gui.CentraVentana(frame);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws LongitudInvalidaException 
	 */
	public Formulario_Vehiculos() throws SQLException, LongitudInvalidaException {
		setResizable(false);
		setBounds(100, 100, 762, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMatricula = new JLabel("Matricula");
		lblMatricula.setBounds(24, 65, 55, 13);
		contentPane.add(lblMatricula);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(213, 65, 45, 13);
		contentPane.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(24, 96, 45, 13);
		contentPane.add(lblModelo);
		
		lblColor = new JLabel("Color");
		lblColor.setBounds(213, 99, 45, 13);
		contentPane.add(lblColor);
		
		lblKm = new JLabel("Kilometros");
		lblKm.setBounds(24, 134, 118, 13);
		contentPane.add(lblKm);
		
		lblFechaAdquisicion = new JLabel("Fecha Adquisición");
		lblFechaAdquisicion.setBounds(155, 132, 118, 13);
		contentPane.add(lblFechaAdquisicion);
		
		JLabel lblOficina = new JLabel("Oficina");
		lblOficina.setBounds(24, 169, 55, 13);
		contentPane.add(lblOficina);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(24, 204, 69, 13);
		contentPane.add(lblCategoria);
		
		lblTipoVehiculo = new JLabel("Tipo de Vehiculo");
		lblTipoVehiculo.setBounds(171, 24, 95, 13);
		contentPane.add(lblTipoVehiculo);
		
		cbTipoVehiculo = new JComboBox();
		cbTipoVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cbTipoVehiculo.getSelectedIndex()==0)
				{
					limpiaFormulario();
					
					lblTipo.setVisible(true);
					lblTipo.setBounds(480, 68, 45, 13);
					
					cbTipo.setVisible(true);
					cbTipo.setBounds(520, 65, 125, 21);
					cbTipo.setSelectedIndex(0);
		
					lblAutonomia.setVisible(true);
					lblAutonomia.setBounds(480, 100, 69, 13);
					
					textAutonomia.setVisible(true);
					textAutonomia.setBounds(545, 97, 96, 19);
					
					lblRecarga.setVisible(true);
					lblRecarga.setBounds(480, 134, 103, 13);
					
					textRecarga.setVisible(true);
					textRecarga.setBounds(575, 131, 55, 19);
										
					lblPlazas.setVisible(true);
					lblPlazas.setBounds(480, 169, 45, 13);
					
					TextPlazas.setVisible(true);
					TextPlazas.setBounds(521, 166, 40, 20);
					
					lblEmisiones.setVisible(false);
					textEmisiones.setVisible(false);
					lblConsumo.setVisible(false);
					textConsumo.setVisible(false);
					lblPotencia.setVisible(false);
					textPotencia.setVisible(false);
					lblCapacidad.setVisible(false);
					textCapacidad.setVisible(false);
					lblCilindrada.setVisible(false);
					textCilindrada.setVisible(false);
					lblCarnetConducir.setVisible(false);
					cbCarnet.setVisible(false);
				}
				else if (cbTipoVehiculo.getSelectedIndex()==1)
				{
					limpiaFormulario();
					
					lblTipo.setVisible(true);
					lblTipo.setBounds(480, 68, 45, 13);
					
					cbTipo.setVisible(true);
					cbTipo.setBounds(520, 65, 125, 21);

					lblPotencia.setVisible(true);		
					lblPotencia.setBounds(480, 98, 69, 13);
					
					textPotencia.setVisible(true);
					textPotencia.setBounds(545, 95, 96, 19);
					
					lblConsumo.setVisible(true);
					lblConsumo.setBounds(480, 128, 103, 13);
					
					textConsumo.setVisible(true);
					textConsumo.setBounds(545, 125, 55, 19);
					
					lblEmisiones.setVisible(true);
					lblEmisiones.setBounds(480, 158, 103, 13);
					
					textEmisiones.setVisible(true);
					textEmisiones.setBounds(575, 154, 103, 20);
					
					lblPlazas.setVisible(true);
					lblPlazas.setBounds(480, 188, 45, 13);
					
					TextPlazas.setVisible(true);
					TextPlazas.setBounds(521, 185, 40, 20);

					
					lblAutonomia.setVisible(false);
					textAutonomia.setVisible(false);
					lblRecarga.setVisible(false);
					textRecarga.setVisible(false);
					lblCapacidad.setVisible(false);
					textCapacidad.setVisible(false);
					lblCilindrada.setVisible(false);
					textCilindrada.setVisible(false);
					lblCarnetConducir.setVisible(false);
					cbCarnet.setVisible(false);
				}
				else if (cbTipoVehiculo.getSelectedIndex()==2)
				{
					limpiaFormulario();
					
					lblCilindrada.setVisible(true);
					lblCilindrada.setBounds(480, 68, 100, 13);
					
					textCilindrada.setVisible(true);
					textCilindrada.setBounds(545, 65, 125, 21);
					
					lblCarnetConducir.setVisible(true);
					lblCarnetConducir.setBounds(480, 134, 103, 13);
					
					cbCarnet.setVisible(true);
					cbCarnet.setBounds(590, 131, 120, 19);
					
					lblAutonomia.setVisible(true);
					textAutonomia.setVisible(true);
					
					lblRecarga.setVisible(true);
					lblRecarga.setBounds(480, 169, 110, 13);
					
					textRecarga.setVisible(true);
					textRecarga.setBounds(585, 166, 70, 20);
					
					lblPlazas.setVisible(false);
					TextPlazas.setVisible(false);
					lblTipo.setVisible(false);
					cbTipo.setVisible(false);
					lblConsumo.setVisible(false);
					textConsumo.setVisible(false);
					lblPotencia.setVisible(false);
					textPotencia.setVisible(false);
					lblCapacidad.setVisible(false);
					textCapacidad.setVisible(false);
					lblEmisiones.setVisible(false);
					textEmisiones.setVisible(false);
					
				}
				else
				{
					
					limpiaFormulario();
					
					lblCarnetConducir.setVisible(true);
					lblCarnetConducir.setBounds(480, 68, 120, 13);
					
					cbCarnet.setVisible(true);
					cbCarnet.setBounds(580, 65, 125, 21);

					lblPotencia.setVisible(true);		
					lblPotencia.setBounds(480, 98, 69, 13);
					
					textPotencia.setVisible(true);
					textPotencia.setBounds(545, 95, 96, 19);
					
					lblConsumo.setVisible(true);
					lblConsumo.setBounds(480, 128, 103, 13);
					
					textConsumo.setVisible(true);
					textConsumo.setBounds(545, 125, 55, 19);
					
					lblEmisiones.setVisible(true);
					lblEmisiones.setBounds(480, 158, 103, 13);
					
					textEmisiones.setVisible(true);
					textEmisiones.setBounds(575, 154, 103, 20);
					
					lblCapacidad.setVisible(true);
					lblCapacidad.setBounds(480, 188, 140, 13);
					
					textCapacidad.setVisible(true);
					textCapacidad.setBounds(600, 185, 40, 20);		
					
					lblPlazas.setVisible(false);
					TextPlazas.setVisible(false);
					lblTipo.setVisible(false);
					cbTipo.setVisible(false);
					lblAutonomia.setVisible(false);
					textAutonomia.setVisible(false);
					lblRecarga.setVisible(false);	
					textRecarga.setVisible(false);
					lblCilindrada.setVisible(false);
					textCilindrada.setVisible(false);
				}
			}
		});
		cbTipoVehiculo.setModel(new DefaultComboBoxModel(new String[] {"Coche el\u00E9ctrico", "Coche combusti\u00F3n", "Motocicleta", "Furgoneta"}));
		cbTipoVehiculo.setBounds(274, 20, 140, 21);
		contentPane.add(cbTipoVehiculo);
		
		textMatricula = new JTextField();
		textMatricula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
	
					try {
						if (RepositorioVehiculos.buscaCocheElectricos(textMatricula.getText())!=null ) 
						{
							RellenaCocheElectrico(RepositorioVehiculos.buscaCocheElectricos(textMatricula.getText()));
						}
						else if (RepositorioVehiculos.buscaCocheCombustion(textMatricula.getText())!=null )
						{
							RellenaCocheCombustion(RepositorioVehiculos.buscaCocheCombustion(textMatricula.getText()));
						}
						else if (RepositorioVehiculos.buscaMotos(textMatricula.getText())!=null )
						{
							RellenaMotocicletas(RepositorioVehiculos.buscaMotos(textMatricula.getText()));
						}
						else if (RepositorioVehiculos.buscaFurgonetas(textMatricula.getText())!=null )
						{
							RellenaFurgonetas(RepositorioVehiculos.buscaFurgonetas(textMatricula.getText()));
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					ActivaFormuMenosMatricula();
				}
				
			}
		});
		textMatricula.setBounds(89, 62, 60, 19);
		contentPane.add(textMatricula);
		textMatricula.setColumns(10);
		
		textMarca = new JTextField();
		textMarca.setBounds(258, 62, 96, 19);
		contentPane.add(textMarca);
		textMarca.setColumns(10);
		
		textModelo = new JTextField();
		textModelo.setColumns(10);
		textModelo.setBounds(89, 93, 90, 19);
		contentPane.add(textModelo);
		
		textColor = new JTextField();
		textColor.setColumns(10);
		textColor.setBounds(258, 93, 96, 19);
		contentPane.add(textColor);
		
		textKm = new JTextField();
		textKm.setColumns(10);
		textKm.setBounds(89, 131, 45, 19);
		contentPane.add(textKm);
		
		cbOficina = new JComboBox();
		cbOficina.setBounds(89, 165, 215, 21);
		contentPane.add(cbOficina);
		DefaultComboBoxModel d =new DefaultComboBoxModel();
		d.addAll(RepositorioOficina.leeOficinasBasededatos());
		cbOficina.setModel(d);
		cbOficina.setSelectedIndex(0);
		
		cbCategoria = new JComboBox();
		cbCategoria.setBounds(89, 200, 188, 21);
		contentPane.add(cbCategoria);
		DefaultComboBoxModel de =new DefaultComboBoxModel();
		de.addAll(RepositorioCategorias.leeCategoriasBasededatos());
		cbCategoria.setModel(de);
		cbCategoria.setSelectedIndex(0);
		
		lblConsumo = new JLabel("Consumo");
		lblConsumo.setVisible(false);
		lblConsumo.setBounds(480, 188, 69, 13);
		contentPane.add(lblConsumo);
		
		lblPotencia = new JLabel("Potencia");
		lblPotencia.setBounds(24, 251, 20, 13);
		contentPane.add(lblPotencia);
		lblPotencia.setVisible(false);
		
		lblEmisiones = new JLabel("Nivel Emisiones");
		lblEmisiones.setBounds(62, 231, 20, 13);
		contentPane.add(lblEmisiones);
		lblEmisiones.setVisible(false);
		
		lblAutonomia = new JLabel("Autonomia");
		lblAutonomia.setBounds(480, 100, 69, 13);
		contentPane.add(lblAutonomia);
		
		lblRecarga = new JLabel("Tiempo Recarga");
		lblRecarga.setBounds(480, 134, 103, 13);
		contentPane.add(lblRecarga);
		
		lblPlazas = new JLabel("Plazas");
		lblPlazas.setBounds(480, 169, 45, 13);
		contentPane.add(lblPlazas);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(480, 68, 45, 13);
		contentPane.add(lblTipo);
		
		lblCilindrada = new JLabel("Cilindrada");
		lblCilindrada.setBounds(89, 231, 20, 13);
		contentPane.add(lblCilindrada);
		lblCilindrada.setVisible(false);
		
		lblCarnetConducir = new JLabel("Carnet Conducir");
		lblCarnetConducir.setBounds(47, 251, 29, 13);
		contentPane.add(lblCarnetConducir);
		lblCarnetConducir.setVisible(false);
		
		lblCapacidad = new JLabel("Capacidad de Carga");
		lblCapacidad.setBounds(24, 227, 29, 13);
		contentPane.add(lblCapacidad);
		lblCapacidad.setVisible(false);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(Formulario_Vehiculos.class.getResource("/imagenes/close.png")));
		btnCancelar.setBounds(593, 232, 118, 21);
		contentPane.add(btnCancelar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiaFormulario();
			}
		});
		
		btnLimpiar.setBounds(498, 232, 85, 21);
		contentPane.add(btnLimpiar);
		
		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.setIcon(new ImageIcon(Formulario_Vehiculos.class.getResource("/imagenes/diskette.png")));
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean cc = false;
				boolean ce = false;
				boolean fu = false;
				boolean mo = false;
				try {
					cc = (RepositorioVehiculos.buscaCocheCombustion(textMatricula.getText())==null);
					ce=(RepositorioVehiculos.buscaCocheElectricos(textMatricula.getText())==null);
					fu=(RepositorioVehiculos.buscaFurgonetas(textMatricula.getText())==null);
					mo=(RepositorioVehiculos.buscaMotos(textMatricula.getText())==null);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (cc && ce && fu && mo)
				{
					AlmacenaVehiculo();
				}
				else if (!cc && ce && fu && mo)
				{
					ModificaCC();
				}
				else if (cc && !ce && fu && mo)
				{
					ModificaCE();
				}
				else if (cc && ce && !fu && mo)
				{
					ModificaFU();
				}
				else if (cc && ce && fu && !mo)
				{
					ModificaMO();
				}	
				
				limpiaFormulario();
			}
		});
		btnGrabar.setBounds(379, 232, 103, 21);
		contentPane.add(btnGrabar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setIcon(new ImageIcon(Formulario_Vehiculos.class.getResource("/imagenes/recycle_bin.png")));
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				if (cbTipoVehiculo.getSelectedIndex()==0)
				{
					try {
						RepositorioVehiculos.EliminaCocheElectrico(textMatricula.getText());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "No se ha podido eliminar el vehiculo");
					}
					limpiaFormulario();
				}
				else if (cbTipoVehiculo.getSelectedIndex()==1)
				{
					try {
						RepositorioVehiculos.EliminaCocheCombustion(textMatricula.getText());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "No se ha podido eliminar el vehiculo");
					}
					limpiaFormulario();
				}
				else if (cbTipoVehiculo.getSelectedIndex()==2)
				{
					try {
						RepositorioVehiculos.EliminaMotocicletas(textMatricula.getText());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "No se ha podido eliminar el vehiculo");
					}
					limpiaFormulario();
				}
				else
				{
					try {
						RepositorioVehiculos.EliminaFurgonetas(textMatricula.getText());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "No se ha podido eliminar el vehiculo");
					}
					limpiaFormulario();				
				}
				
				
				
				
				
			}
		});
		btnBorrar.setBounds(256, 232, 103, 21);
		contentPane.add(btnBorrar);
		
		textAutonomia = new JTextField();
		textAutonomia.setBounds(545, 97, 96, 19);
		contentPane.add(textAutonomia);
		textAutonomia.setColumns(10);
		
		textRecarga = new JTextField();
		textRecarga.setText("");
		textRecarga.setBounds(575, 131, 55, 19);
		contentPane.add(textRecarga);
		textRecarga.setColumns(10);
		
		TextFechaAdquisicion = new JDateChooser();
		TextFechaAdquisicion.setBounds(263, 128, 114, 19);
		contentPane.add(TextFechaAdquisicion);
		
		textCapacidad = new JTextField();
		textCapacidad.setVisible(false);
		textCapacidad.setBounds(155, 231, 29, 19);
		contentPane.add(textCapacidad);
		textCapacidad.setColumns(10);
		
		TextPlazas = new JSpinner();
		TextPlazas.setModel(new SpinnerNumberModel(0, null, 10, 1));
		TextPlazas.setBounds(521, 166, 40, 20);
		contentPane.add(TextPlazas);
		
		cbCarnet = new JComboBox();
		cbCarnet.setVisible(false);
		cbCarnet.setBounds(119, 231, 29, 21);
		contentPane.add(cbCarnet);
		DefaultComboBoxModel dCarnet =new DefaultComboBoxModel();
		dCarnet.addAll(RepositorioCarnetConducir.leeCarnetConducir());
		cbCarnet.setModel(dCarnet);
		cbCarnet.setSelectedIndex(0);
		
		cbTipo = new JComboBox();
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"Berlina", "Compacto", "Deportivo", "Monovolumen", "Suv", "Todoterreno"}));
		cbTipo.setBounds(520, 65, 125, 21);
		contentPane.add(cbTipo);
		
		textCilindrada = new JTextField();
		textCilindrada.setVisible(false);
		textCilindrada.setBounds(194, 231, 29, 19);
		contentPane.add(textCilindrada);
		textCilindrada.setColumns(10);
		
		textConsumo = new JTextField();
		textConsumo.setVisible(false);
		textConsumo.setBounds(545, 185, 55, 19);
		contentPane.add(textConsumo);
		textConsumo.setColumns(10);
		
		textEmisiones = new JTextField();
		textEmisiones.setVisible(false);
		textEmisiones.setBounds(258, 231, 19, 19);
		contentPane.add(textEmisiones);
		textEmisiones.setColumns(10);
		
		textPotencia = new JTextField();
		textPotencia.setVisible(false);
		textPotencia.setBounds(287, 228, 96, 19);
		contentPane.add(textPotencia);
		textPotencia.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(Formulario_Vehiculos.class.getResource("/imagenes/zoom.png")));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				if (cbTipoVehiculo.getSelectedIndex()==0)
				{
					try {
						buscador1 = new BuscaVehiculos(RepositorioVehiculos.leeCochesElectricos());
						buscador1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						buscador1.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					CochesElectricos ce=null;
					
					
					try {
						ce=RepositorioVehiculos.buscaCocheElectricos(buscador1.getVehiculo().getMatricula());
					} catch (SQLException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					textMatricula.setText(ce.getMatricula());
					textModelo.setText(ce.getModelo());
					textMarca.setText(ce.getMarca());
					textColor.setText(ce.getColor());
					textKm.setText(""+ce.getKm());
					cbOficina.setSelectedItem((Oficina) ce.getOficina());
					cbCategoria.setSelectedItem((Categoria) ce.getCategoria());
					TextFechaAdquisicion.setCalendar(ce.getFechaadquisicion());
					cbTipo.setSelectedItem(ce.getTipo());
					textAutonomia.setText(""+ce.getAutonomia());
					textRecarga.setText(""+ce.getTiempoRecarga());
					TextPlazas.setValue(ce.getNplazas());
					
					ActivaFormuMenosMatricula();
					
				}
				else if (cbTipoVehiculo.getSelectedIndex()==1)
				{
					try {
						buscador2 = new BuscaVehiculos(RepositorioVehiculos.leeCochesCombustion());
						buscador2.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						buscador2.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					CochesCombustion cc=null;
					
					try {
						cc=RepositorioVehiculos.buscaCocheCombustion(buscador2.getVehiculo().getMatricula());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					textMatricula.setText(cc.getMatricula());
					textModelo.setText(cc.getModelo());
					textMarca.setText(cc.getMarca());
					textColor.setText(cc.getColor());
					textKm.setText(""+cc.getKm());
					cbOficina.setSelectedItem((Oficina) cc.getOficina());
					cbCategoria.setSelectedItem((Categoria) cc.getCategoria());
					TextFechaAdquisicion.setCalendar(cc.getFechaadquisicion());
					cbTipo.setSelectedItem(cc.getTipo());
					textPotencia.setText(""+cc.getPotencia());
					textConsumo.setText(cc.getConsumo());
					textEmisiones.setText(cc.getNivelEmisiones());
					TextPlazas.setValue(cc.getNplazas());
					ActivaFormuMenosMatricula();
				}
				else if (cbTipoVehiculo.getSelectedIndex()==2)
				{
					try {
						buscador3 = new BuscaVehiculos(RepositorioVehiculos.leeMotos());
						buscador3.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						buscador3.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					Motocicletas mo=null;
					
					try {
						mo=RepositorioVehiculos.buscaMotos(buscador3.getVehiculo().getMatricula());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					textMatricula.setText(mo.getMatricula());
					textModelo.setText(mo.getModelo());
					textMarca.setText(mo.getMarca());
					textColor.setText(mo.getColor());
					textKm.setText(""+mo.getKm());
					cbOficina.setSelectedItem((Oficina) mo.getOficina());
					cbCategoria.setSelectedItem((Categoria) mo.getCategoria());
					TextFechaAdquisicion.setCalendar(mo.getFechaadquisicion());
					textCilindrada.setText(""+mo.getCilindrada());
					textAutonomia.setText(""+mo.getAutonomia());
					cbCarnet.setSelectedItem((CarnetConducir) mo.getCarnetRequerido());
					textRecarga.setText(""+mo.getTiempoRecarga());
					ActivaFormuMenosMatricula();
				}
				else
				{
					try {
						buscador4 = new BuscaVehiculos(RepositorioVehiculos.leeFurgonetas());
						buscador4.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						buscador4.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					Furgonetas mo=null;
					
					try {
						mo=RepositorioVehiculos.buscaFurgonetas(buscador4.getVehiculo().getMatricula());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					textMatricula.setText(mo.getMatricula());
					textModelo.setText(mo.getModelo());
					textMarca.setText(mo.getMarca());
					textColor.setText(mo.getColor());
					textKm.setText(""+mo.getKm());
					cbOficina.setSelectedItem((Oficina) mo.getOficina());
					cbCategoria.setSelectedItem((Categoria) mo.getCategoria());
					TextFechaAdquisicion.setCalendar(mo.getFechaadquisicion());
					textPotencia.setText(""+mo.getPotencia());
					textConsumo.setText(mo.getConsumo());
					textEmisiones.setText(mo.getNivelEmisiones());
					cbCarnet.setSelectedItem(mo.getCarnetRequerido());
					textCapacidad.setText(""+mo.getCapacidadCarga());
					ActivaFormuMenosMatricula();
				}

			}
		});
		btnBuscar.setBounds(440, 20, 109, 21);
		contentPane.add(btnBuscar);
		
		DesactivaFormuMenosMatricula();
	}
	
	private void limpiaFormulario()
	{
		textMatricula.setText("");
		textMarca.setText("");
		textModelo.setText("");
		textColor.setText("");
		textKm.setText("");
		TextFechaAdquisicion.setDate(null);
		cbOficina.setSelectedIndex(0);
		cbCategoria.setSelectedIndex(0);
		cbTipo.setSelectedIndex(0);
		cbCarnet.setSelectedIndex(0);
		textAutonomia.setText("");
		textRecarga.setText("");
		textEmisiones.setText("");
		textConsumo.setText("");
		textCapacidad.setText("");
		textPotencia.setText("");
		TextPlazas.setValue(0);
		textCilindrada.setText("");
		DesactivaFormuMenosMatricula();
		
	}
	
	private void DesactivaFormuMenosMatricula()
	{
		textMatricula.setEnabled(true);
		textMarca.setEnabled(false);
		textModelo.setEnabled(false);
		textColor.setEnabled(false);
		textKm.setEnabled(false);
		TextFechaAdquisicion.setEnabled(false);
		cbOficina.setEnabled(false);
		cbCategoria.setEnabled(false);
		cbTipo.setEnabled(false);
		cbCarnet.setEnabled(false);
		textAutonomia.setEnabled(false);
		textRecarga.setEnabled(false);
		textEmisiones.setEnabled(false);
		textConsumo.setEnabled(false);
		textCapacidad.setEnabled(false);
		textPotencia.setEnabled(false);
		TextPlazas.setEnabled(false);
		textCilindrada.setEnabled(false);
	}
	
	private void ActivaFormuMenosMatricula()
	{
		textMatricula.setEnabled(false);
		textMarca.setEnabled(true);
		textModelo.setEnabled(true);
		textColor.setEnabled(true);
		textKm.setEnabled(true);
		TextFechaAdquisicion.setEnabled(true);
		cbOficina.setEnabled(true);
		cbCategoria.setEnabled(true);
		cbTipo.setEnabled(true);
		cbCarnet.setEnabled(true);
		textAutonomia.setEnabled(true);
		textRecarga.setEnabled(true);
		textEmisiones.setEnabled(true);
		textConsumo.setEnabled(true);
		textCapacidad.setEnabled(true);
		textPotencia.setEnabled(true);
		TextPlazas.setEnabled(true);
		textCilindrada.setEnabled(true);
	}
	
	private void RellenaCocheElectrico (CochesElectricos ce)
	{
		textMatricula.setText(ce.getMatricula());
		textMarca.setText(ce.getMarca());
		textModelo.setText(ce.getModelo());
		textColor.setText(ce.getColor());
		textKm.setText(""+ce.getKm());
		TextFechaAdquisicion.setDate(Metodos.ConvierteGregorianCalendaraDate(ce.getFechaadquisicion()));
		cbOficina.setSelectedItem(ce.getOficina());
		cbCategoria.setSelectedItem(ce.getCategoria());
		cbTipoVehiculo.setSelectedItem(ce.getTipo());
		textAutonomia.setText(""+ce.getAutonomia());
		textRecarga.setText(""+ce.getTiempoRecarga());
		TextPlazas.setValue(ce.getNplazas());
		
	}
	
	private void RellenaMotocicletas (Motocicletas ce)
	{
		textMatricula.setText(ce.getMatricula());
		textMarca.setText(ce.getMarca());
		textModelo.setText(ce.getModelo());
		textColor.setText(ce.getColor());
		textKm.setText(""+ce.getKm());
		TextFechaAdquisicion.setDate(Metodos.ConvierteGregorianCalendaraDate(ce.getFechaadquisicion()));
		cbOficina.setSelectedItem(ce.getOficina());
		cbCategoria.setSelectedItem(ce.getCategoria());
		cbCarnet.setSelectedItem(ce.getCarnetRequerido());
		textAutonomia.setText(""+ce.getAutonomia());
		textRecarga.setText(""+ce.getTiempoRecarga());
		textCilindrada.setText(""+ce.getCilindrada());
	
	}
	
	private void RellenaFurgonetas (Furgonetas ce)
	{
		textMatricula.setText(ce.getMatricula());
		textMarca.setText(ce.getMarca());
		textModelo.setText(ce.getModelo());
		textColor.setText(ce.getColor());
		textKm.setText(""+ce.getKm());
		TextFechaAdquisicion.setDate(Metodos.ConvierteGregorianCalendaraDate(ce.getFechaadquisicion()));
		cbOficina.setSelectedItem(ce.getOficina());
		cbCategoria.setSelectedItem(ce.getCategoria());
		cbCarnet.setSelectedItem(ce.getCarnetRequerido());
		textCapacidad.setText(""+ce.getCapacidadCarga());
		textConsumo.setText(""+ce.getConsumo());
		textEmisiones.setText(""+ce.getNivelEmisiones());
		
	}
	
	private void RellenaCocheCombustion (CochesCombustion ce)
	{
		textMatricula.setText(ce.getMatricula());
		textMarca.setText(ce.getMarca());
		textModelo.setText(ce.getModelo());
		textColor.setText(ce.getColor());
		textKm.setText(""+ce.getKm());
		TextFechaAdquisicion.setDate(Metodos.ConvierteGregorianCalendaraDate(ce.getFechaadquisicion()));
		cbOficina.setSelectedItem(ce.getOficina());
		cbCategoria.setSelectedItem(ce.getCategoria());
		cbTipoVehiculo.setSelectedItem(ce.getTipo());
		textConsumo.setText(""+ce.getConsumo());
		textEmisiones.setText(""+ce.getNivelEmisiones());
		TextPlazas.setValue(ce.getNplazas());
		
	}
	
	private void AlmacenaVehiculo ()
	{
		if (cbTipoVehiculo.getSelectedIndex()==0)
		{
			int km =Integer.parseInt( textKm.getText());
			int autonomia = Integer.parseInt(textAutonomia.getText());
			int recarga = Integer.parseInt(textRecarga.getText());

			Calendar fechaAdquisicion = metodos.Metodos.PasaDateaGregorianCalendar(TextFechaAdquisicion.getDate());
			
			CochesElectricos ce = new CochesElectricos(textMatricula.getText(), textMarca.getText(), textModelo.getText(), 
					textColor.getText(), km, (GregorianCalendar) fechaAdquisicion ,(Oficina) cbOficina.getSelectedItem(),
					(Categoria) cbCategoria.getSelectedItem(),false, autonomia, recarga, (int) TextPlazas.getValue(), (String) cbTipo.getSelectedItem());
			

			try {
				RepositorioVehiculos.AñadeCochesElectrico(ce);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			limpiaFormulario();
		}
		else if (cbTipoVehiculo.getSelectedIndex()==1)
		{
			
			int km =Integer.parseInt( textKm.getText());
			int consumo = Integer.parseInt(textConsumo.getText());

			Calendar fechaAdquisicion = metodos.Metodos.PasaDateaGregorianCalendar(TextFechaAdquisicion.getDate());
			
			CochesCombustion cc =new CochesCombustion(textMatricula.getText(), textMarca.getText(), textModelo.getText(), textColor.getText(),
					km,(GregorianCalendar) fechaAdquisicion ,(Oficina) cbOficina.getSelectedItem()  ,(Categoria) cbCategoria.getSelectedItem(), 
					false,consumo, textPotencia.getText(), textEmisiones.getText(),(int) TextPlazas.getValue(),(String) cbTipo.getSelectedItem());
			
			try {
				RepositorioVehiculos.AñadeCochesCombustion(cc);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "No se ha podido grabar al vehiculo");
			}
			limpiaFormulario();
		}
		else if (cbTipoVehiculo.getSelectedIndex()==2)
		{
			
			int autonomia = Integer.parseInt(textAutonomia.getText());
			int recarga = Integer.parseInt(textRecarga.getText());
			int cilindrada = Integer.parseInt(textCilindrada.getText());
			int km =Integer.parseInt( textKm.getText());
			
			Calendar fechaAdquisicion = metodos.Metodos.PasaDateaGregorianCalendar(TextFechaAdquisicion.getDate());
			
			Motocicletas mo = new Motocicletas(textMatricula.getText(), textMarca.getText(), textModelo.getText(), textColor.getText(),
					km,(GregorianCalendar) fechaAdquisicion ,(Oficina) cbOficina.getSelectedItem()  ,(Categoria) cbCategoria.getSelectedItem(),
					false,autonomia, recarga, cilindrada,(CarnetConducir) cbCarnet.getSelectedItem());
			
			try {
				RepositorioVehiculos.AñadeMotocicletas(mo);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			limpiaFormulario();
		}
		else if (cbTipoVehiculo.getSelectedIndex()==3)
		{
			int km =Integer.parseInt( textKm.getText());
			int potencia = Integer.parseInt(textPotencia.getText());
			int capacidad = Integer.parseInt(textCapacidad.getText());

			Calendar fechaAdquisicion = metodos.Metodos.PasaDateaGregorianCalendar(TextFechaAdquisicion.getDate());
			
			Furgonetas cc =new Furgonetas(textMatricula.getText(), textMarca.getText(), textModelo.getText(), textColor.getText(),
					km,(GregorianCalendar) fechaAdquisicion ,(Oficina) cbOficina.getSelectedItem()  ,(Categoria) cbCategoria.getSelectedItem(), 
					false,textConsumo.getText(),potencia, textEmisiones.getText(),capacidad, (CarnetConducir) cbCarnet.getSelectedItem());
			
			try {
				RepositorioVehiculos.AñadeFurgonetas(cc);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "No se ha podido grabar al vehiculo");
			}
			limpiaFormulario();			
		}
	}
	
	public void ModificaCC() 
	{
		int km =Integer.parseInt( textKm.getText());
		int consumo = Integer.parseInt(textConsumo.getText());

		Calendar fechaAdquisicion = metodos.Metodos.PasaDateaGregorianCalendar(TextFechaAdquisicion.getDate());
		
		CochesCombustion ccochecombustion =new CochesCombustion(textMatricula.getText(), textMarca.getText(), textModelo.getText(), textColor.getText(),
				km,(GregorianCalendar) fechaAdquisicion ,(Oficina) cbOficina.getSelectedItem()  ,(Categoria) cbCategoria.getSelectedItem(), 
				false,consumo, textPotencia.getText(), textEmisiones.getText(),(int) TextPlazas.getValue(),(String) cbTipo.getSelectedItem());
	
		
			try {
				RepositorioVehiculos.ModificaCochesCombustion(ccochecombustion);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	public void ModificaCE()
	{
		int km =Integer.parseInt( textKm.getText());
		int autonomia = Integer.parseInt(textAutonomia.getText());
		int recarga = Integer.parseInt(textRecarga.getText());

		Calendar fechaAdquisicion = metodos.Metodos.PasaDateaGregorianCalendar(TextFechaAdquisicion.getDate());
		
		CochesElectricos ce = new CochesElectricos(textMatricula.getText(), textMarca.getText(), textModelo.getText(), 
				textColor.getText(), km, (GregorianCalendar) fechaAdquisicion ,(Oficina) cbOficina.getSelectedItem(),
				(Categoria) cbCategoria.getSelectedItem(),false, autonomia, recarga, (int) TextPlazas.getValue(), (String) cbTipo.getSelectedItem());
		
		
			try {
				RepositorioVehiculos.ModificaCocheElectrico(ce);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "No se ha podido modificar el vehiculo");
			}

		
	}
	
	public void ModificaFU()
	{
		int km =Integer.parseInt( textKm.getText());
		int potencia = Integer.parseInt(textPotencia.getText());
		int capacidad = Integer.parseInt(textCapacidad.getText());

		Calendar fechaAdquisicion = metodos.Metodos.PasaDateaGregorianCalendar(TextFechaAdquisicion.getDate());
		
		Furgonetas cc =new Furgonetas(textMatricula.getText(), textMarca.getText(), textModelo.getText(), textColor.getText(),
				km,(GregorianCalendar) fechaAdquisicion ,(Oficina) cbOficina.getSelectedItem()  ,(Categoria) cbCategoria.getSelectedItem(), 
				false,textConsumo.getText(),potencia, textEmisiones.getText(),capacidad, (CarnetConducir) cbCarnet.getSelectedItem());
		
	
			try {
				RepositorioVehiculos.ModificaFurgonetas(cc);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	public void ModificaMO()
	{
		int autonomia = Integer.parseInt(textAutonomia.getText());
		int recarga = Integer.parseInt(textRecarga.getText());
		int cilindrada = Integer.parseInt(textCilindrada.getText());
		int km =Integer.parseInt( textKm.getText());
		
		Calendar fechaAdquisicion = metodos.Metodos.PasaDateaGregorianCalendar(TextFechaAdquisicion.getDate());
		
		Motocicletas mo = new Motocicletas(textMatricula.getText(), textMarca.getText(), textModelo.getText(), textColor.getText(),
				km,(GregorianCalendar) fechaAdquisicion ,(Oficina) cbOficina.getSelectedItem()  ,(Categoria) cbCategoria.getSelectedItem(),
				false,autonomia, recarga, cilindrada,(CarnetConducir) cbCarnet.getSelectedItem());
		
		try {
			RepositorioVehiculos.ModificaMotocicletas(mo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "No se ha podido modificar el vehiculo");
		}
	}

}
