package entidades;

import java.util.GregorianCalendar;

public class Furgonetas extends Combustion{


	//Propiedades

	
	private int CapacidadCarga;
	private CarnetConducir CarnetRequerido;
	int preciobase =70;
	


	//Constructores
	/**
	 * 
	 * @param matricula String unica para cada furgoneta
	 * @param marca String marca de cada furgoneta
	 * @param modelo String modelo de cada furgoneta
	 * @param color String color del furgoneta
	 * @param km in Km que tiene cada furgoneta
	 * @param fechaadquisicion GregorianCalendar fecha de adquision del furgoneta
	 * @param oficina Oficina Oficina en la que se encuentra el furgoneta
	 * @param categoria Categoria Categoria a la que pertence el furgoneta
	 * @param nivelemisiones int nivel de emisiones que emite la furgoneta
	 * @param capacidadcarga int capacidad que es capaz de cargar la furgoneta
	 * @param carnetrequerido TipoCarnet carnet requerido para conducir la furgoneta
	 */
	public Furgonetas(String matricula, String marca, String modelo, String color, int km,
					  GregorianCalendar fechaadquisicion, Oficina oficina, Categoria categoria, boolean alquilado,
					  String consumo,int potencia,String nivelemisiones,int capacidadcarga, CarnetConducir carnetrequerido) {
		super(matricula, marca, modelo, color, km, fechaadquisicion, oficina, categoria,alquilado, consumo,potencia,nivelemisiones);
		this.setCapacidadCarga(capacidadcarga);
		this.setCarnetRequerido(carnetrequerido);
	}
		
	//Getters and Setters
	public int getCapacidadCarga() {
		return CapacidadCarga;
	}
	public void setCapacidadCarga(int capacidadCarga) {
		CapacidadCarga = capacidadCarga;
	}
	public CarnetConducir getCarnetRequerido() {
		return CarnetRequerido;
	}
	public void setCarnetRequerido(CarnetConducir carnetRequerido) {
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
		
		precio= precio * DiasAlquilado;
		
		return precio;
	}

	
	//metodos
}
