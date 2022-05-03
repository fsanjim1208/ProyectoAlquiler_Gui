package entidades;

import excepciones.LongitudInvalidaException;

public class Cliente extends Persona{

	private CarnetConducir tipoCarnet;
	private int ntarjetaCliente;
	
	
	//Constructores
	/**
	 * constructor del Objeto Cliente
	 * @param nombre String nombre del cliente
	 * @param ape1 String primer apellido del cliente
	 * @param ape2 String segundo apellido del cliente
	 * @param dni String Dni unico para cada cliente
	 * @param tipoCarnet TipoCarnet tipo del carnet que tiene el cliente
	 * @param ntarjetacliente String numero de tarjeta del cliente
	 * @throws LongitudInvalidaException
	 */
	public Cliente(String nombre, String ape1, String ape2, String dni,CarnetConducir tipoCarnet, int ntarjetacliente) throws LongitudInvalidaException 
	{
		super(nombre, ape1, ape2, dni);
		this.setTipoCarnet(tipoCarnet);
		this.setNtarjetaCliente(ntarjetacliente);
	}

	public Cliente(String nombre, String ape1, String dni,CarnetConducir tipoCarnet, int ntarjetacliente) throws LongitudInvalidaException 
	{
		super(nombre, ape1, dni);
		
	}
	
	public Cliente(String nombre, String ape1,String ape2, String dni) throws LongitudInvalidaException {
		super(nombre, ape1,ape2, dni);
		// TODO Auto-generated constructor stub
	}

	public CarnetConducir getTipoCarnet() 
	{
		return tipoCarnet;
	}

	public void setTipoCarnet(CarnetConducir tipoCarnet) 
	{
		this.tipoCarnet = tipoCarnet;
	}

	public int getNtarjetaCliente() 
	{
		return ntarjetaCliente;
	}

	public void setNtarjetaCliente(int ntarjetaCliente) 
	{
		this.ntarjetaCliente = ntarjetaCliente;
	}
	
	@Override
	public String toString() {
		return "Empleado: "+InformacionCompleta();
	}
}
