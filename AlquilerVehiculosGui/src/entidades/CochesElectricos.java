package entidades;

import java.util.GregorianCalendar;

public class CochesElectricos extends Electrico{

	//Propiedades
	private int Nplazas;
	private String tipo;
	private int preciobase=50;
	
	//Constructor
	


	/**
	 * 
	 * Cosntructor del objeto coche electrico
	 * @param matricula String unica para cada coche electrico
	 * @param marca String marca de cada coche electrico
	 * @param modelo String modelo de cada coche electrico
	 * @param color String color del coche electrico
	 * @param km in Km que tiene cada coche electrico
	 * @param fechaadquisicion GregorianCalendar fecha de adquision del coche electrico
	 * @param oficina Oficina Oficina en la que se encuentra el coche electrico
	 * @param categoria Categoria Categoria a la que pertence el coche electrico
	 * @param autonomia int km que es capaz de recorrer el coche electrico con la bateria
	 * @param tiemporecarga int tiempo que tarda en cargar completamente la bateria del coche electrico
	 * @param numeroplazas numero de plazas que tiene el coche electrico
	 * @param tipo tipo de vehiculo que es el coche
	 */
	public CochesElectricos(String matricula, String marca, String modelo, String color, int km,
							GregorianCalendar fechaadquisicion, Oficina oficina, Categoria categoria, boolean alquilado,
							int autonomia,int tiemporecarga,int numeroplazas, String tipo) {
		super(matricula, marca, modelo, color, km, fechaadquisicion, oficina, categoria,alquilado, autonomia, tiemporecarga);
		this.setNplazas(numeroplazas);
		this.setTipo(tipo);
	}
		
	///Getters and Setters
	
	public int getNplazas() 
	{
	return Nplazas;
	}
	
	private void setNplazas(int nplazas) 
	{
		Nplazas = nplazas;
	}
	
	public String getTipo() 
	{
		return tipo;
	}
	
	private void setTipo(String tipo) 
	{
		this.tipo = tipo;
	}
	
	public int getPreciobase() {
		return preciobase;
	}

	public void setPreciobase(int preciobase) {
		this.preciobase = preciobase;
	}

	@Override
	public double CalculaPrecio(int DiasAlquilado) {
		double precio=preciobase+((preciobase*getCategoria().getRecargo())/100);
		if (getOficina().getOficinaAeropuerto())
		{
			precio=precio+((precio*getOficina().getRecargoSiAeoropuerto())/100);
		}
		precio=precio+((precio*getRecargo())/100);
		
		precio= precio * DiasAlquilado;
		
		return precio;
	}



//Metodos


}
