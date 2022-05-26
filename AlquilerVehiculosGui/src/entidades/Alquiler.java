 package entidades;

import java.sql.Date;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import accesoadatos.RepositorioVehiculos;
import metodos.Metodos;

public class Alquiler{
	
;
	
	private String codigo;
	private Cliente cliente;
	private Empleado empleado;
	private static Vehiculo vehiculo_alqiuilado;
	private static Oficina lugar_alquila;
	private static Oficina lugar_devuelve;
	private static GregorianCalendar fecha_alquila;
	private static GregorianCalendar fecha_devuelve;
	private String matricula_vehiculo_Alquilado;
	private int diasAlquilado;
	private double precio;
	private boolean devuelto;
	
	//CONSTRUCTOR

	/**
	 * constructor para crear un Objeto de tipo Alquiler
	 * @param codigo String con formato "ALXX" donde las x son numeros, es unica para cada alquiler
	 * @param cliente Objeto del tipo Cliente 
	 * @param empleado Objeto del tipo Empleado 
	 * @param vehiculo_alqiuilado Objeto del tipo Vehiculo 
	 * @param lugar_alquiler Objeto del tipo Oficina 
	 * @param fecha_alquila Objeto del tipo GregorianCalendar 
	 * @param fecha_devuelve Objeto del tipo GregorianCalendar
	 */
	public Alquiler(String codigo, Cliente cliente, Empleado empleado, Vehiculo vehiculo_alqiuilado, Oficina lugar_alquiler,
			Oficina lugar_devuelve,GregorianCalendar fecha_alquila, GregorianCalendar fecha_devuelve, int diaalquilado, double precio,boolean devuelto) 
	{
		this.setCodigo(codigo);
		this.setCliente(cliente);
		this.setEmpleado(empleado);
		this.setVehiculo_alqiuilado(vehiculo_alqiuilado);
		this.setLugar_alquila(lugar_alquiler);
		this.setLugar_devuelve(lugar_devuelve);
		this.setFecha_alquila(fecha_alquila);
		this.setFecha_devuelve(fecha_devuelve);	
		this.setDiasAlquilado(diaalquilado);
		this.setPrecio(precio);
		this.setDevuelto(devuelto);
	}
	


	public Alquiler(String codigo, Cliente cliente, Empleado empleado, Vehiculo vehiculo_alqiuilado, Oficina lugar_alquiler,
			Oficina lugar_devuelve,GregorianCalendar fecha_alquila, GregorianCalendar fecha_devuelve,double precio, boolean devuelto) 
	{
		this.setCodigo(codigo);
		this.setCliente(cliente);
		this.setEmpleado(empleado);
		this.setVehiculo_alqiuilado(vehiculo_alqiuilado);
		this.setLugar_alquila(lugar_alquiler);
		this.setLugar_devuelve(lugar_devuelve);
		this.setFecha_alquila(fecha_alquila);
		this.setFecha_devuelve(fecha_devuelve);	
		this.setDevuelto(devuelto);
		this.setPrecio(precio);

	}
	
	public Alquiler(String codigo, Cliente cliente, Empleado empleado, String matricula_vehiculo_alqiuilado, Oficina lugar_alquiler,
			Oficina lugar_devuelve,GregorianCalendar fecha_alquila, GregorianCalendar fecha_devuelve,double precio, boolean devuelto) 
	{
		this.setCodigo(codigo);
		this.setCliente(cliente);
		this.setEmpleado(empleado);
		this.setMatricula_vehiculo_Alquilado(matricula_vehiculo_alqiuilado);
		this.setLugar_alquila(lugar_alquiler);
		this.setLugar_devuelve(lugar_devuelve);
		this.setFecha_alquila(fecha_alquila);
		this.setFecha_devuelve(fecha_devuelve);	
		this.setDevuelto(devuelto);
		this.setPrecio(precio);
	}
	public Alquiler(String codigo, Cliente cliente, Empleado empleado, String matricula_vehiculo_alqiuilado, Oficina lugar_alquiler,
			Oficina lugar_devuelve,GregorianCalendar fecha_alquila, GregorianCalendar fecha_devuelve, boolean devuelto) 
	{
		this.setCodigo(codigo);
		this.setCliente(cliente);
		this.setEmpleado(empleado);
		this.setMatricula_vehiculo_Alquilado(matricula_vehiculo_alqiuilado);
		this.setLugar_alquila(lugar_alquiler);
		this.setLugar_devuelve(lugar_devuelve);
		this.setFecha_alquila(fecha_alquila);
		this.setFecha_devuelve(fecha_devuelve);	
		this.setDevuelto(devuelto);
	}

	public Alquiler(Alquiler alquiler)
	{
		this.setCodigo(alquiler.getCodigo());
		this.setCliente(alquiler.getCliente());
		this.setEmpleado(alquiler.getEmpleado());
		this.setVehiculo_alqiuilado(alquiler.getVehiculo_alqiuilado());
		this.setLugar_alquila(alquiler.getLugar_alquila());
		this.setLugar_devuelve(alquiler.getLugar_devuelve());
		this.setFecha_alquila(alquiler.getFecha_alquila());
		this.setFecha_devuelve(alquiler.getFecha_devuelve());
		this.setDevuelto(alquiler.isDevuelto());
	}
	
	//GETTERS AND SETTERS
	public String getCodigo() 
	{
		return codigo;
	}

	public void setCodigo(String codigo) 
	{
		this.codigo = codigo;
	}
	
	public Cliente getCliente() 
	{
		return cliente;
	}

	public void setCliente(Cliente cliente) 
	{
		this.cliente = cliente;
	}
	
	public Empleado getEmpleado() 
	{
		return empleado;
	}
	
	public void setEmpleado(Empleado empleado) 
	{
		this.empleado = empleado;
	}
	
	public Vehiculo getVehiculo_alqiuilado() 
	{
		return vehiculo_alqiuilado;
	}
	
	public void setVehiculo_alqiuilado(Vehiculo vehiculo_alqiuilado) 
	{
		this.vehiculo_alqiuilado = vehiculo_alqiuilado;
	}
	
	public Oficina getLugar_alquila() {
		return lugar_alquila;
	}

	public void setLugar_alquila(Oficina lugar_alquila) {
		this.lugar_alquila = lugar_alquila;
	}

	public Oficina getLugar_devuelve() {
		return lugar_devuelve;
	}

	public void setLugar_devuelve(Oficina lugar_devuelve) {
		this.lugar_devuelve = lugar_devuelve;
	}
	
	public GregorianCalendar getFecha_alquila() 
	{
		return fecha_alquila;
	}
	
	public void setFecha_alquila(GregorianCalendar fecha_alquila) 
	{
		this.fecha_alquila = fecha_alquila;
	}
	
	public GregorianCalendar getFecha_devuelve() 
	{ 
		return fecha_devuelve;
	}
	
	public void setFecha_devuelve(GregorianCalendar fecha_devuelve) 
	{
		this.fecha_devuelve = fecha_devuelve;
	}
	
	public int getDiasAlquilado() 
	{ 
		return diasAlquilado;
	}
	
	private void setDiasAlquilado(int diasalquilado) 
	{
		this.diasAlquilado = diasalquilado;
	}
	
	public double getPrecio() 
	{ 
		return precio;
	}
	
	public void setPrecio(double precio) 
	{
		this.precio = precio;
	}
	public String getMatricula_vehiculo_Alquilado() 
	{
		return matricula_vehiculo_Alquilado;
	}

	public void setMatricula_vehiculo_Alquilado(String matricula_vehiculo_Alquilado) 
	{
		this.matricula_vehiculo_Alquilado = matricula_vehiculo_Alquilado;
	}
	
	public boolean isDevuelto() {
		return devuelto;
	}

	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "El codigo del alquiler es " + codigo + ", lo realizó el cliente " + cliente + " y alquiló " +  vehiculo_alqiuilado + 
				"a un precio de "+precio+fecha_alquila.getCalendarType(); 
				//+ fecha_alquila+ " de "+fecha_alquila+ " y lo devuelve el " + fecha_devuelve;
	}
	
	private static int CalculaDiasAlquilado(Alquiler al)
	{
		int dias=0;
		
		long inicioms= al.getFecha_alquila().getTimeInMillis();
		long finms=al.getFecha_devuelve().getTimeInMillis();
		
		
		
		dias= (int) ((Math.abs(finms-inicioms))/(10000*60*60*24));
		
		return dias;
	}
	
	public static double CalculaPrecio(Alquiler al)
	{
		double preciobase= 0;
		try {
			if (RepositorioVehiculos.buscaCocheCombustion(al.getVehiculo_alqiuilado().getMatricula())!=null)
			{
				CochesCombustion cc = (CochesCombustion) al.getVehiculo_alqiuilado();
				preciobase=cc.getPreciobase();
				preciobase=preciobase+((preciobase*cc.getCategoria().getRecargo())/100);
			}
			else  if (RepositorioVehiculos.buscaCocheElectricos(al.getVehiculo_alqiuilado().getMatricula())!=null)
			{
				CochesElectricos ce = (CochesElectricos) al.getVehiculo_alqiuilado();
				preciobase=ce.getPreciobase();
				preciobase=preciobase+((preciobase*ce.getRecargo())/100);
				preciobase=preciobase+((preciobase*ce.getCategoria().getRecargo())/100);
			}
			else  if (RepositorioVehiculos.buscaFurgonetas(al.getVehiculo_alqiuilado().getMatricula())!=null)
			{
				Furgonetas fu = (Furgonetas) al.getVehiculo_alqiuilado();
				preciobase=fu.getPreciobase();
				preciobase=preciobase+((preciobase*fu.getCategoria().getRecargo())/100);
			}
			else  if (RepositorioVehiculos.buscaMotos(al.getVehiculo_alqiuilado().getMatricula())!=null)
			{
				Motocicletas mo = (Motocicletas) al.getVehiculo_alqiuilado();
				preciobase=mo.getPreciobase();
				preciobase=preciobase+((preciobase*mo.getRecargo())/100);
				preciobase=preciobase+((preciobase*mo.getCategoria().getRecargo())/100);
			}
			
			if (al.getLugar_alquila().getOficinaAeropuerto() || al.getLugar_devuelve().getOficinaAeropuerto())
			{
				preciobase=preciobase+((preciobase * al.getLugar_alquila().getRecargoSiAeoropuerto())/100);
			}
			
			int diasalquilado=(int) (Math. random()*6+3);
			
			preciobase=preciobase*diasalquilado;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return preciobase;
	}
	

	
	
}
