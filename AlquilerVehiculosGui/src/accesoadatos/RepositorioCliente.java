package accesoadatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.CarnetConducir;
import entidades.Cliente;
import excepciones.LongitudInvalidaException;

public class RepositorioCliente {

	public static ArrayList<Cliente> leeClientesBasededatos() throws SQLException, LongitudInvalidaException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Cliente> ListaCliente = new ArrayList<Cliente>();
		
		query = "SELECT pe.* FROM clientes cli JOIN personas pe ON cli.dni=pe.dni";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		rs = St.executeQuery(query);
		
		while (rs.next()) 
		{
			String dni=rs.getString("dni");
			String nombre=rs.getString("nombre");
			String ape1=rs.getString("ap1");
			String ape2=rs.getString("ap2");
			
			Cliente e = new Cliente(nombre, ape1, ape2,dni );
			ListaCliente.add(e);
		}

		return ListaCliente;
	}
	
	
	public static Cliente leeCliente(String dni) throws SQLException, LongitudInvalidaException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		query = "SELECT * FROM cliente WHERE dni = ?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,dni);
		rs = St.executeQuery(query);
				
		Cliente cliente = null;

		
		while (rs.next()) 
		{
			String nombre=rs.getString("nombre");
			String ape1=rs.getString("ape1");
			String ape2=rs.getString("ape2");
			
			cliente = new Cliente(nombre,ape1, ape2, dni);
		}

		return cliente;
	}
	
	public static void añadeCliente(String nombre, String ape1, String ape2, String dni, CarnetConducir tipoCarnet) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		query = "Insert * insert into persona (dni,nombre,ap1,ap2) values (?,?,?,?);";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,nombre);
		St.setString(2,ape1);
		St.setString(4,ape2);
		St.setString(5,dni);
		
		rs = St.executeQuery(query);
		rs=null;
		
		query = "Insert * insert into clientes (dni,CarnetConducir) values (?,?);";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,dni);
		St.setString(2,tipoCarnet.getLetra());
		
		rs = St.executeQuery(query);
	}
	
	public static void añadeCliente(Cliente cliente) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		String nombre=cliente.getNombre();
		String ape1=cliente.getApe1();
		String ape2=cliente.getApe2();
		String dni=cliente.getDni();
		CarnetConducir tipoCarnet=cliente.getTipoCarnet();
		
		query = "Insert * insert into persona (dni,nombre,ap1,ap2) values (?,?,?,?);";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,nombre);
		St.setString(2,ape1);
		St.setString(4,ape2);
		St.setString(5,dni);
		
		rs = St.executeQuery(query);
		rs=null;
		
		query = "Insert * insert into clientes (dni,CarnetConducir) values (?,?);";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,dni);
		St.setString(2,tipoCarnet.getLetra());
		
		rs = St.executeQuery(query);

	}
	
	public static void eliminaCliente(String dni) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		query = "DELETE FROM cliente where dni = ? ;";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,dni);

		rs = St.executeQuery(query);
		rs=null;
		
		query = "DELETE FROM personas where dni = ? ;";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,dni);

		rs = St.executeQuery(query);
	}
	
	public static void eliminaCliente(Cliente cliente) throws SQLException
	{

		PreparedStatement St;
		ResultSet rs;
		String query;
		
		String dni=cliente.getDni();
		
		query = "DELETE FROM cliente where dni = ? ;";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,dni);

		rs = St.executeQuery(query);
		rs=null;
		
		query = "DELETE FROM personas where dni = ? ;";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,dni);

		rs = St.executeQuery(query);
	}
	
	
	public static void modificaCliente(Cliente clienteviejo, Cliente clientenuevo ) throws SQLException
	{
		eliminaCliente(clienteviejo);
		añadeCliente(clientenuevo);
	}
}
