package entidades;

import java.util.GregorianCalendar;

public class CochesCombustion extends Combustion{


	//Propiedades

	private int Nplazas;
	private String tipo;
	private int preciobase=50;

	//Constructores
	
	/**
	 * Constructor del Objeto VehiculosCombustion
	 * @param matricula String unica para cada coche
	 * @param marca String marca de cada coche
	 * @param modelo String modelo de cada coche
	 * @param color String color del coche
	 * @param km in Km que tiene cada coche
	 * @param fechaadquisicion GregorianCalendar fecha de adquision del vehiculo
	 * @param oficina Oficina Oficina en la que se encuentra el coche
	 * @param categoria Categoria Categoria a la que pertence el coche
	 * @param nivelemisiones int nivel de emisiones que emite el coche
	 * @param numeroplazas int numero de plazas que tiene el coche
	 * @param tipo String el tipo de coche
	 */
	public CochesCombustion(String matricula, String marca, String modelo, String color, int km,
			GregorianCalendar fechaadquisicion, Oficina oficina, Categoria categoria,boolean alquilado,
			int potencia,String consumo,String nivelemisiones,	int numeroplazas, String tipo) 
	{
		super(matricula, marca, modelo, color, km, fechaadquisicion, oficina, categoria,alquilado, nivelemisiones,potencia, consumo);
		this.setNplazas(numeroplazas);
		this.setTipo(tipo);
	}
	public CochesCombustion(String matricula, String marca, String modelo, String color, int km,
			GregorianCalendar fechaadquisicion, Oficina oficina, Categoria categoria,boolean alquilado,
			int potencia,String consumo,String nivelemisiones) 
	{
		super(matricula, marca, modelo, color, km, fechaadquisicion, oficina, categoria,alquilado, nivelemisiones,potencia, consumo);

	}

	public CochesCombustion(CochesCombustion cc) 
	{
		super(cc.getMatricula(), cc.getMarca(), cc.getModelo(), cc.getColor(), cc.getKm(), cc.getFechaadquisicion(), cc.getOficina(), cc.getCategoria(), cc.isAlquilado(),cc.getNivelEmisiones(),cc.getPotencia(), cc.getConsumo());
		this.setNplazas(cc.getNplazas());
		this.setTipo(cc.getTipo());
	}


	///Getters and Setters
	
		public int getNplazas() {
		return Nplazas;
	}

	private void setNplazas(int nplazas) {
		Nplazas = nplazas;
	}

	public String getTipo() {
		return tipo;
	}

	private void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPreciobase() {
		return preciobase;
	}
	public void setPreciobase(int preciobase) {
		this.preciobase = preciobase;
	}


	@Override
	public double CalculaPrecio(int diasalquilado) {
		double precio=preciobase+((preciobase*getCategoria().getRecargo())/100);
		
		if (getOficina().getOficinaAeropuerto())
		{
			precio=precio+((precio*getOficina().getRecargoSiAeoropuerto())/100);
		}
		
		precio= precio * diasalquilado;
		return precio;
	}




	
	//Metodos
	
}
