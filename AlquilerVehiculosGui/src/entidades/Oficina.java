package entidades;

public class Oficina implements Comparable <Oficina>{

	private String Codigo;
	private String Descripcion;
	private String Localidad;
	private String Provincia;
	private Boolean OficinaAeropuerto;
	private int RecargoSiaeropuerto=10;
	
	//CONSTRUCTORES
	/**
	 * Constructor del Objeto Oficina
	 * @param codigo String unica para cada oficina 
	 * @param descripcion String pequeña descripcion de cada oficina
	 * @param localidad String localidad donde se encuentra la oficina
	 * @param provincia String Provincia donde se enuentra la oficina
	 * @param oficinaAeropuerto Boolean que indica si la oficina se encuentra en aeropuerto o no
	 * 					true si se encuentra y false si no
	 */
	public Oficina(String codigo,String descripcion, String localidad, String provincia, Boolean oficinaAeropuerto) 
	{
		super();
		this.setCodigo(codigo);
		this.setDescripcion(descripcion);
		this.setLocalidad(localidad);
		this.setProvincia(provincia);
		this.setOficinaAeropuerto(oficinaAeropuerto);
	}
	
	
	//GETTERS AND SETTERS
	public String getCodigo() 
	{
		return Codigo;
	}

	public void setCodigo(String codigo) 
	{
		Codigo = codigo;
	}

	public String getDescripcion() 
	{
		return Descripcion;
	}

	public void setDescripcion(String descripcion) 
	{
		Descripcion = descripcion;
	}

	public String getLocalidad() 
	{
		return Localidad;
	}

	public void setLocalidad(String localidad) 
	{
		Localidad = localidad;
	}

	public String getProvincia() 
	{
		return Provincia;
	}

	public void setProvincia(String provincia) 
	{
		Provincia = provincia;
	}

	public Boolean getOficinaAeropuerto() 
	{
		return OficinaAeropuerto;
	}

	public void setOficinaAeropuerto(Boolean oficinaAeropuerto) 
	{
		OficinaAeropuerto = oficinaAeropuerto;
	}

	public int getRecargoSiAeoropuerto() 
	{
		return RecargoSiaeropuerto;
	}

	@Override
	public String toString() {
	
		String aeropuerto="";
		if (OficinaAeropuerto==true)
		{
			aeropuerto="AEROPUERTO";
		}
		//return Descripcion+" con codigo "+Codigo;
		return aeropuerto+" "+Localidad +" - "+ Codigo;
	}

	@Override
	public boolean equals(Object obj)
	{
		Oficina guest = (Oficina) obj;
	
		return 	(this.Codigo.equals(guest.Codigo));
	}
	

	@Override
	public int compareTo(Oficina o) {
		int resultado=0;
		
		if ( this.getCodigo().compareTo(o.getCodigo())<0 )
		{
			resultado=-1;
		}
		else if (this.getCodigo().compareTo(o.getCodigo())>0 ) 
		{
			resultado = 1;
		}
		else
		{
			resultado = 0;
		}
		
		return resultado;
	}
	
}
