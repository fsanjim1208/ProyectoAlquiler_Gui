package accesoadatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import entidades.Categoria;
import entidades.Oficina;
import entidades.Vehiculo;

public class RepositorioVehiculos {


	public static ArrayList<Vehiculo> leeVehiculosBasededatos() throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		query = "SELECT * FROM oficina";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		rs = St.executeQuery(query);
		
		while (rs.next()) 
		{
			String matricula=rs.getString("matricula");
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			GregorianCalendar fechaadquisicion;
			String codOfi=rs.getString("codigo");
			Oficina oficina=RepositorioOficina.BuscaOficina(codOfi);
			Categoria categoria;
			
			//Vehiculo o = new Vehiculo( matricula,  marca,  modelo,  color, km, fechaadquisicion,  oficina,  categoria);
			//ListaVehiculo.add(o);
		}

		
		return ListaVehiculo;
	}
}
