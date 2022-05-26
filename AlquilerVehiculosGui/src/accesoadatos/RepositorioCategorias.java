package accesoadatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Categoria;
import excepciones.LongitudInvalidaException;

public class RepositorioCategorias {

	/**
	 * devuelve las categorias de la base de datos
	 * @return ArrayList de Categorias
	 * @throws SQLException
	 */
	public static ArrayList<Categoria> leeCategoriasBasededatos() throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Categoria> ListaCategoria = new ArrayList<Categoria>();
		
		query = "SELECT * FROM categorias";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String codigo=rs.getString("codigo");
			String descripcion=rs.getString("descripcion");
			int recargo=rs.getInt("recargo");
			
			Categoria e = new Categoria(codigo, descripcion, recargo);
			ListaCategoria.add(e);
		}

		return ListaCategoria;
	}
	
	/**
	 * busca una categoria a partir de su codigo
	 * @param codigo
	 * @return una categoria
	 * @throws SQLException
	 */
	public static Categoria leeCategoria(String codigo) throws SQLException 
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		query = "SELECT * FROM Categorias WHERE codigo = ?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,codigo);
		rs = St.executeQuery();
				
		Categoria categoria = null;

		
		while (rs.next()) 
		{
			String codigo2=rs.getString("codigo");
			String descripcion=rs.getString("descripcion");
			int recargo=rs.getInt("recargo");
			
			categoria = new Categoria(codigo2, descripcion, recargo);
		}

		return categoria;
	}
	
	
	
	
	
}
