package entidades;


import java.util.GregorianCalendar;

public class Motocicletas extends Electrico{

	//Propiedades

	
	private int cilindrada;
	private CarnetConducir CarnetRequerido;
	int preciobase =10;
	


	//Constructores
	/**
	 * 
	 * @param matricula String unica para cada moto
	 * @param marca String marca de cada moto
	 * @param modelo String modelo de cada moto
	 * @param color String color del moto
	 * @param km in Km que tiene cada moto
	 * @param fechaadquisicion GregorianCalendar fecha de adquision del moto
	 * @param oficina Oficina Oficina en la que se encuentra el moto
	 * @param categoria Categoria Categoria a la que pertence el moto
	 * @param autonomia int km que dura la bateria del coche
	 * @param tiemporecarga int tiempo que tarda en completarse la carga
	 * @param cilindrada int cilindrada que tiene la moto
	 * @param carnetrequerido TipoCarnet carnet requerido para conducir la moto
	 */
	public Motocicletas(String matricula, String marca, String modelo, String color, int km,
			GregorianCalendar fechaadquisicion, Oficina oficina, Categoria categoria, boolean alquilado,
			int autonomia,int tiemporecarga,int cilindrada, CarnetConducir carnetrequerido) 
	{
		super(matricula, marca, modelo, color, km, fechaadquisicion, oficina, categoria,alquilado, autonomia, tiemporecarga);
		this.setCilindrada(cilindrada);
		this.setCarnetRequerido(carnetrequerido);
	}

	//Getters and Setters

	public int getCilindrada() 
	{
		return cilindrada;
	}

	private void setCilindrada(int cilindrada) 
	{
		this.cilindrada = cilindrada;
	}

	public CarnetConducir getCarnetRequerido() 
	{
		return CarnetRequerido;
	}

	private void setCarnetRequerido(CarnetConducir carnetRequerido) 
	{
		CarnetRequerido = carnetRequerido;
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
