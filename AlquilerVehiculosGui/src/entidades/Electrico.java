package entidades;

import java.util.GregorianCalendar;

public abstract class Electrico extends Vehiculo{
	private int autonomia;
	private int tiempoRecarga;
	private int recargo=15;
	
	//Constructores
	/**
	 * Cosntructor de Electrico
	 * @param matricula String unica para cada vehiculo
	 * @param marca String marca de cada vehiculo
	 * @param modelo String modelo de cada vehiculo
	 * @param color String color del vehiculo
	 * @param km in Km que tiene cada vehiculo
	 * @param fechaadquisicion GregorianCalendar fecha de adquision del vehiculo
	 * @param oficina Oficina Oficina en la que se encuentra el vehiculo
	 * @param categoria Categoria Categoria a la que pertence el vehiculo
	 * @param autonomia int km que es capaz de recorrer el vehiculo con la bateria
	 * @param tiemporecarga int tiempo que tarda en cargar completamente la bateria del vehiculo
	 */
	public Electrico(String matricula, String marca, String modelo, String color, int km,
			GregorianCalendar fechaadquisicion, Oficina oficina, Categoria categoria, boolean alquilado,
			int autonomia, int tiemporecarga) {
		super(matricula, marca, modelo, color, km, fechaadquisicion, oficina, categoria, alquilado);
		this.setAutonomia(tiemporecarga);
		this.setTiempoRecarga(tiemporecarga);
	}
	
	//Getters and Setters
	
	public void setAutonomia(int autonimia) {
		this.autonomia = autonimia;
	}
	public void setTiempoRecarga(int tiempoRecarga) {
		this.tiempoRecarga = tiempoRecarga;
	}
	public int getAutonomia() {
		return autonomia;
	}
	public int getTiempoRecarga() {
		return tiempoRecarga;
	}
	
	public int getRecargo() {
		return recargo;
	}
	
	//Metodos
	

}
