 package entidades;

import java.util.GregorianCalendar;

public class Alquiler{
	
;
	
	private String codigo;
	private Cliente cliente;
	private Empleado empleado;
	private Vehiculo vehiculo_alqiuilado;
	private Oficina lugar_alquiler;
	private GregorianCalendar fecha_alquila;
	private GregorianCalendar fecha_devuelve;
	
	private int diasAlquilado;
	private double precio;
	
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
			GregorianCalendar fecha_alquila, GregorianCalendar fecha_devuelve, int diaalquilado, double precio) 
	{
		this.setCodigo(codigo);
		this.setCliente(cliente);
		this.setEmpleado(empleado);
		this.setVehiculo_alqiuilado(vehiculo_alqiuilado);
		this.setLugar_alquiler(lugar_alquiler);
		this.setFecha_alquila(fecha_alquila);
		this.setFecha_devuelve(fecha_devuelve);	
		this.setDiasAlquilado(diaalquilado);
		this.setPrecio(precio);
	}
	
	public Alquiler(Alquiler alquiler)
	{
		this.setCodigo(alquiler.getCodigo());
		this.setCliente(alquiler.getCliente());
		this.setEmpleado(alquiler.getEmpleado());
		this.setVehiculo_alqiuilado(alquiler.getVehiculo_alqiuilado());
		this.setLugar_alquiler(alquiler.getLugar_alquiler());
		this.setFecha_alquila(alquiler.getFecha_alquila());
		this.setFecha_devuelve(alquiler.getFecha_devuelve());
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
	
	public Oficina getLugar_alquiler() 
	{
		return lugar_alquiler;
	}
	
	public void setLugar_alquiler(Oficina lugar_alquiler) 
	{
		this.lugar_alquiler = lugar_alquiler;
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
	
	private void setPrecio(double precio) 
	{
		this.precio = precio;
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
	
	
	
	
}
