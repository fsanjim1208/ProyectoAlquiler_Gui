package entidades;

public class CarnetConducir {

	private String letra;
	private String Descripcion;
	
	//CONSTRUCTOR
	/**
	 * 	Constructor del objeto CarnetConducir
	 * @param letra letra que identifica al carnet
	 * @param descripcion pequeña descripcion del carnet
	 */
	public CarnetConducir(String letra, String descripcion) 
	{
		this.setLetra(letra);
		this.setDescripcion(descripcion);
	}

	//GUETTERS AND SETTERS
	public String getLetra() 
	{
		return letra;
	}

	public void setLetra(String letra) 
	
	{
		this.letra = letra;
	}

	public String getDescripcion() 
	{
		return Descripcion;
	}

	public void setDescripcion(String descripcion) 
	{
		Descripcion = descripcion;
	}

}
