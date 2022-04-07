package entidades;

import java.util.GregorianCalendar;

public abstract class Combustion extends Vehiculo {


	//Propiedades
	
	
	
	private String consumo;
	private int potencia;
	private String nivelEmisiones;
	
	//Constructores
	/**
	 * 
	 * Cosntructor del objeto Vehiculo
	 * @param matricula String unica para cada vehiculo
	 * @param marca String marca de cada vehiculo
	 * @param modelo String modelo de cada vehiculo
	 * @param color String color del vehiculo
	 * @param km in Km que tiene cada vehiculo
	 * @param fechaadquisicion GregorianCalendar fecha de adquision del vehiculo
	 * @param oficina Oficina Oficina en la que se encuentra el vehiculo
	 * @param categoria Categoria Categoria a la que pertence el vehiculo
	 * @param nivelemisiones int nivel de emision que emite el vehiculo
	 */
	public Combustion(String matricula, String marca, String modelo, String color, int km,
			GregorianCalendar fechaadquisicion, Oficina oficina, Categoria categoria,String nivelemisiones) 
	{
		super(matricula, marca, modelo, color, km, fechaadquisicion, oficina, categoria);
		this.setConsumo(consumo);
		this.setPotencia(potencia);
		this.setNivelEmisiones(nivelemisiones);
	}


	
	//Getters and Setters
	
	public String getConsumo() 
	{
		return consumo;
	}

	private void setConsumo(String consumo) 
	{
		this.consumo = consumo;
	}

	public int getPotencia() 
	{
		return potencia;
	}

	private void setPotencia(int potencia) 
	{
		this.potencia = potencia;
	}

	public String getNivelEmisiones() 
	{
		return nivelEmisiones;
	}

	public void setNivelEmisiones(String nivelEmisiones) 
	{
		this.nivelEmisiones = nivelEmisiones;
	}



	
	//Metodos
	

}
