package entidades;

import java.util.GregorianCalendar;

import excepciones.LongitudInvalidaException;

public class Empleado extends Persona{

	//Propiedades
	
		
		private GregorianCalendar fechaAltEmpleado;
		private Oficina OficinaEmpleado;

		
	    //CONSTRUCTORES
		/**
		 * Constructor para el objeto Empleado
		 * @param nombre String nombre de cada empleado
		 * @param ape1 String primer apellido de cada empleado
		 * @param dni String dni unico para cada empleado
		 * @throws LongitudInvalidaException
		 */
		public Empleado(String nombre, String ape1, String dni) throws LongitudInvalidaException {
			super(nombre, ape1, dni);
			// TODO Auto-generated constructor stub
		}
		
		/**
		 * 
		 * @param nombre String nombre de cada empleado
		 * @param ape1 String primer apellido de cada empleado
		 * @param ape2 String segundo apellido de cada empleado
		 * @param dni String dni unico para cada empleado
		 * @param fechaAltEmpleado GregorianCalendra fecha de alta del empleado en la empresa
		 * @param OficinaEmpleado Oficina en la que trabaja el empleado
		 * @throws LongitudInvalidaException
		 */
		public Empleado(String nombre, String ape1, String ape2, String dni,GregorianCalendar fechaAltEmpleado, Oficina OficinaEmpleado) throws LongitudInvalidaException {
			super(nombre, ape1, ape2, dni);
			// TODO Auto-generated constructor stub
		}

		
		//GETTERS AND SETTERS
		public GregorianCalendar getFechaAltEmpleado() {
			return fechaAltEmpleado;
		}

		public void setFechaAltEmpleado(GregorianCalendar fechaAltEmpleado) {
			this.fechaAltEmpleado = fechaAltEmpleado;
		}

		public Oficina getOficinaEmpleado() {
			return OficinaEmpleado;
		}

		public void setOficinaEmpleado(Oficina oficinaEmpleado) {
			OficinaEmpleado = oficinaEmpleado;
		}
		
		@Override
		public String toString() {
			return "Empleado "+ InformacionCompleta();
		}
}
