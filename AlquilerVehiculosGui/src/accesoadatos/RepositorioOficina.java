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
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Oficina> ListaOficina = new ArrayList<Oficina>();
		
		query = "SELECT * FROM oficina";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
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
	
	public static Oficina BuscaOficina(String codigoOficina) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		query = "SELECT * FROM oficina WHERE codigo = ?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,codigoOficina);
		rs = St.executeQuery();
				
		Oficina o = null;

		
		while (rs.next()) 
		{
			String codigo=rs.getString("Codigo");
			String descripcion=rs.getString("Descripcion");
			String localidad=rs.getString("nombreloc");
			String provincia=rs.getString("nombreprov");
			Boolean SiAeropuerto=rs.getBoolean("oficinaaeropuerto");
			
			o = new Oficina(codigo,descripcion, localidad, provincia,SiAeropuerto);
		}

		return o;
	}
	
	public static void añadeOficina(String codigo, String descripcion, boolean oficinaaeropuerto,String nombreloc, String nombreprov) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		query = "Insert into oficina (codigo,descripcion,oficinaaeropuerto,recargosiaeropuerto, nombreloc,nombreprov) values (?,?,?,10,?,?)";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,codigo);
		St.setString(2,descripcion);
		St.setBoolean(3,oficinaaeropuerto);
		St.setString(4,nombreloc);
		St.setString(5,nombreprov);
		
		rs = St.executeQuery();
	}
	
	public static void añadeOficina(Oficina o) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		String codigo=o.getCodigo();
		String descripcion=o.getDescripcion();
		String localidad=o.getLocalidad();
		String provincia=o.getProvincia();
		Boolean SiAeropuerto=o.getOficinaAeropuerto();
		
		query = "Insert * insert into oficina (codigo,descripcion,oficinaaeropuerto,recargosiaeropuerto, nombreloc,nombreprov) values (?,?,?,10,?,?);";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,codigo);
		St.setString(2,descripcion);
		St.setBoolean(3,SiAeropuerto);
		St.setString(4,localidad);
		St.setString(5,provincia);
		
		rs = St.executeQuery(query);
	}
	
	public static void eliminaOficina(String codigo) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		query = "DELETE FROM oficina where codigo = ? ;";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,codigo);

		rs = St.executeQuery(query);
	}
	
	public static void eliminaOficina(Oficina o) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		String codigo=o.getCodigo();
		
		query = "DELETE FROM oficina where codigo = ? ;";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,codigo);

		rs = St.executeQuery(query);
	}
	
	
	public static void modificaOficina(Oficina oficinavieja, Oficina oficinanueva) throws SQLException
	{
		eliminaOficina(oficinavieja);
		añadeOficina(oficinanueva);
	}
		//meter aqui todos los metodos para interactuar con la base de datos 
}
