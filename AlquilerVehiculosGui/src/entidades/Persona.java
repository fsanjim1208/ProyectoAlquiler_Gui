package entidades;

import excepciones.LongitudInvalidaException;

public class Persona implements Comparable <Persona>{

	//propiedades
	
		private static final long serialVersionUID = 8799656478674716613L;
		
		private String Nombre;
		private String Ape1;
		private String Ape2;
		private String Dni;
		
		private int longitudNombre = 35;
		private int longitudApe1 = 20;
		private int longitudApe2 = 20;
		
		
		
		
		
		
		//Constructores
		/**
		 * constructor del Objeto Persona
		 * @param nombre String nombre de cada persona
		 * @param ape1 String primer apellido de la persona
		 * @param ape2 String segundo apellido de la persona
		 * @param dni String dni unico de cada persona
		 * @throws LongitudInvalidaException
		 */
		public Persona(String nombre, String ape1, String ape2, String dni) throws LongitudInvalidaException {
			this.setDni(dni);
			this.setNombre(nombre);
			this.setApe1(ape1);
			this.setApe2(ape2);

		}

		public Persona(String nombre,String ape1,String dni) throws LongitudInvalidaException
		{
			this.setDni(dni);
			this.setNombre(nombre);
			this.setApe1(ape1);
			this.Ape2="";
		}

		
		//Getters and Setters
		
		public String getNombre() 
		{
			return Nombre;
		}


		private void setNombre(String nombre) throws LongitudInvalidaException
		{
			if (nombre.length()<= longitudNombre)
			{
				this.Nombre = nombre;
			}
			else
			{
				throw new LongitudInvalidaException();
			}
		}


		public String getApe1() 
		{
			return Ape1;
		}


		private void setApe1(String ape1) throws LongitudInvalidaException 
		{
			if (ape1.length()<= longitudApe1)
			{
				this.Ape1 = ape1;
			}
			else
			{
				throw new LongitudInvalidaException();
			}
		}


		public String getApe2() 
		{
			return Ape2;
		}


		public void setApe2(String ape2) throws LongitudInvalidaException 
		{
			if (ape2.length()<= longitudApe2)
			{
				this.Ape2 = ape2;
			}
			else
			{
				throw new LongitudInvalidaException();
			}
		}


		public String getDni() 
		{
			return Dni;
		}


		private void setDni(String dni) 
		{
			Dni = dni;
		}

		//Metodos
		
		public String NombreCompleto ()
		{
			return this.Nombre+" "+this.Ape1+" "+this.Ape2;
		}
		
		public String InformacionCompleta ()
		{
			return NombreCompleto()+" con DNI:"+this.Dni;
		}
		
		@Override
		public String toString()
		{
			return this.InformacionCompleta();
		}
		
		
		@Override
		public boolean equals(Object obj)
		{
			Persona guest = (Persona) obj;
		
			return 	(this.Dni==guest.Dni);
		}


		@Override
		public int compareTo(Persona o) {
			int resultado=0;
			if ( this.NombreCompleto().compareTo(o.NombreCompleto())<0 )
			{
				resultado=-1;
			}
			else if (this.NombreCompleto().compareTo(o.NombreCompleto())>0 ) 
			{
				resultado = 1;
			}
			else
			{
				 if (this.Dni.compareTo(o.Dni)<0) 
				 {  
					 resultado = -1;    
				 } 
				 else if (this.Dni.compareTo(o.Dni)>0)
				 {   
					 resultado = 1;   
				 }
				 else 
				 {   
					 resultado = 0;   
				 }
		    }	
			
			return resultado;
		}

}
