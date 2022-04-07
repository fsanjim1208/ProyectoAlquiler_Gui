package entidades;

public class Categoria {


	//PROPIEDADES
	private String Codigo;
	private String Descripcion;
	private int recargo;

	
	//CONSTRUCTORES 
	/**
	 * constructor del objeto Categoria
	 * @param codigo String codigo unico para cada categoria
	 * @param descripcion String pequeña descripccion de la categoria
	 * @param recargo int recargo para calcular el precio del alquiler
	 */
	public Categoria(String codigo, String descripcion, int recargo) 
	{
		this.setCodigo(codigo);
		this.setDescripcion(descripcion);
		this.setRecargo(recargo);
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

	public int getRecargo() {
		return recargo;
	}

	public void setRecargo(int recargo) 
	{
		this.recargo = recargo;
	}


	@Override
	public String toString() {
		return "Categoria " + Descripcion + " con codigo -"+Codigo + "- con un recargo del " + recargo + "%";
	}
	
	


}
