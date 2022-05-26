package accesoadatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import entidades.Empleado;
import excepciones.LongitudInvalidaException;

public class Repositorio_Localidad_Provincia {

	public static ArrayList<String> leeProvincia() throws SQLException, LongitudInvalidaException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		ArrayList<String> ListaProvincia = new ArrayList<String>();
		
		query = "SELECT * FROM Provincia order by nombre asc";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String Nombreloc=rs.getString("nombre");
			ListaProvincia.add(Nombreloc);
		}
		return ListaProvincia;
	}
	
	
	
	public static ArrayList<String> leeLocalidad() throws SQLException, LongitudInvalidaException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		ArrayList<String> ListaLocalidad = new ArrayList<String>();
		
		query = "SELECT * FROM Localidad order by nombreloc asc";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String Nombreloc=rs.getString("nombreloc");
			ListaLocalidad.add(Nombreloc);
		}
		return ListaLocalidad;
	}
	
	
	public static ArrayList<String> leeLocalidadDeProvincia(String nombreprov) throws SQLException, LongitudInvalidaException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		ArrayList<String> ListaLocalidad = new ArrayList<String>();
		
		query = "SELECT * FROM Localidad where nombreprov=? order by nombreloc asc";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,nombreprov);
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String Nombreloc=rs.getString("nombreloc");
			ListaLocalidad.add(Nombreloc);
		}
		return ListaLocalidad;
	}
	
	public static void añadeLocalidad(String nombreloc,String nombreprov) throws SQLException
	{		
		PreparedStatement St;
		ResultSet rs;
		String query;

		query = "insert into localidad (nombreprov,nombreloc,codloc) values(upper(?),upper(?),207)";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,nombreloc);
		St.setString(2,nombreprov);
		
		rs = St.executeQuery();
	}
	
	
}
