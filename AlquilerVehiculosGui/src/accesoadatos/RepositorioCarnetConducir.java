package accesoadatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import entidades.CarnetConducir;
import entidades.Cliente;
import entidades.Empleado;
import entidades.Oficina;
import excepciones.LongitudInvalidaException;

public class RepositorioCarnetConducir {

	
	
	public static ArrayList<CarnetConducir> leeCarnetConducir() throws SQLException, LongitudInvalidaException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<CarnetConducir> listaCarnetConducir = new ArrayList<CarnetConducir>();
		
		query = "Select * from CarnetConducir";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		rs = St.executeQuery(query);
		
		while (rs.next()) 
		{
			String letra=rs.getString("letra");
			String descripcion=rs.getString("descripcion");
		
			
			CarnetConducir e = new CarnetConducir(letra, descripcion);
			
			
			
			listaCarnetConducir.add(e);
		}
		return listaCarnetConducir;
	}
	
	public static CarnetConducir BuscaCarnet(String letra) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		query = "Select * from CarnetConducir where letra=?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,letra);
		rs = St.executeQuery();
				
		CarnetConducir carnet = null;

		
		while (rs.next()) 
		{
			String descripcion=rs.getString("descripcion");
			
			carnet = new CarnetConducir(letra,descripcion);
		}

		return carnet;
	}
}
