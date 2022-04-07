package accesoadatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Oficina;

public class RepositorioOficina {

	
	public static ArrayList<Oficina> leeOficinasBasededatos() throws SQLException
	{
		Connection conexion= AccesoADatos.AbreConexion();
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Oficina> ListaOficina = new ArrayList<Oficina>();
		
		query = "SELECT * FROM oficina";
		St = conexion.prepareStatement(query); 
		rs = St.executeQuery(query);
		
		while (rs.next()) 
		{
			String codigo=rs.getString("Codigo");
			String descripcion=rs.getString("Descripcion");
			String localidad=rs.getString("nombreloc");
			String provincia=rs.getString("nombreprov");
			Boolean SiAeropuerto=rs.getBoolean("oficinaaeropuerto");
			
			Oficina o = new Oficina(codigo,descripcion, localidad, provincia,SiAeropuerto);
			ListaOficina.add(o);
		}

		
		return ListaOficina;
	}
		//meter aqui todos los metodos para interactuar con la base de datos 
}
