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

	/**
	 * devuele los clientes de la base de datos
	 * @return ArrayList de clientes
	 * @throws SQLException
	 * @throws LongitudInvalidaException
	 */
	public static ArrayList<Cliente> leeClientesBasededatos() throws SQLException, LongitudInvalidaException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Cliente> ListaCliente = new ArrayList<Cliente>();
		
		query = "SELECT * FROM clientes cli JOIN personas pe ON cli.dni=pe.dni";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		rs = St.executeQuery(query);
		
		while (rs.next()) 
		{
			String dni=rs.getString("dni");
			String nombre=rs.getString("nombre");
			String ape1=rs.getString("ap1");
			String ape2=rs.getString("ap2");
			String letra=rs.getString("CarnetConducir");
			CarnetConducir carnet=RepositorioCarnetConducir.BuscaCarnet(letra);
			
			Cliente e = new Cliente(nombre, ape1, ape2,dni ,carnet);
			ListaCliente.add(e);
		}

		return ListaCliente;
	}
	
	/**
	 * devuelve todos los clientes que tiene un determinado carnet
	 * @param carnet CarnetCondcuir
	 * @return ArrayList de clientes 
	 * @throws SQLException
	 * @throws LongitudInvalidaException
	 */
	public static ArrayList<Cliente> leeClientesporCarnet(CarnetConducir carnet) throws SQLException, LongitudInvalidaException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Cliente> ListaCliente = new ArrayList<Cliente>();
		
		query = "SELECT * FROM clientes cli JOIN personas pe ON cli.dni=pe.dni where cli.carnetconducir=?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1, carnet.getLetra());
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String dni=rs.getString("dni");
			String nombre=rs.getString("nombre");
			String ape1=rs.getString("ap1");
			String ape2=rs.getString("ap2");
			String letra=rs.getString("CarnetConducir");
			
			Cliente e = new Cliente(nombre, ape1, ape2,dni ,carnet);
			ListaCliente.add(e);
		}

		return ListaCliente;
	}
	
	/**
	 * busca un cliente a partir de un dni
	 * @param dni
	 * @return cliente
	 * @throws SQLException
	 * @throws LongitudInvalidaException
	 */
	public static Cliente BuscaCliente(String dni) throws SQLException, LongitudInvalidaException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		query = "SELECT * FROM clientes cli JOIN personas pe ON cli.dni=pe.dni where pe.dni=?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,dni);
		rs = St.executeQuery();
				
		Cliente cliente = null;

		
		while (rs.next()) 
		{
			String nombre=rs.getString("nombre");
			String ape1=rs.getString("ap1");
			String ape2=rs.getString("ap2");
			
			cliente = new Cliente(nombre,ape1, ape2, dni);
		}

		return cliente;
	}
	
	/**
	 * Metodo que añade un cliente a la base de datos
	 * @param nombre
	 * @param ape1
	 * @param ape2
	 * @param dni
	 * @param tipoCarnet
	 * @throws SQLException
	 * @throws LongitudInvalidaException
	 */
	public static void añadeCliente(String nombre, String ape1, String ape2, String dni, CarnetConducir tipoCarnet) throws SQLException, LongitudInvalidaException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		if (RepositorioEmpleados.BuscaEmpleados(dni)!=null)
		{

			query = "Insert into clientes (dni,CarnetConducir) values (?,?)";
			St = AccesoADatos.dbconexion.prepareStatement(query); 
			St.setString(1,dni);
			St.setString(2,tipoCarnet.getLetra());
			
			rs = St.executeQuery();
		}
		else
		{
			query = "Insert into personas (dni,nombre,ap1,ap2) values (?,?,?,?)";
			St = AccesoADatos.dbconexion.prepareStatement(query); 
			St.setString(2,nombre);
			St.setString(3,ape1);
			St.setString(4,ape2);
			St.setString(1,dni);
		
			rs = St.executeQuery();
			rs=null;
			
			query = "Insert into clientes (dni,CarnetConducir) values (?,?)";
			St = AccesoADatos.dbconexion.prepareStatement(query); 
			St.setString(1,dni);
			St.setString(2,tipoCarnet.getLetra());
			
			rs = St.executeQuery();
		}
	}
	
	/**
	 * Metodo que añade un cliente a la base de datos
	 * @param cliente
	 * @throws SQLException
	 * @throws LongitudInvalidaException
	 */
	public static void añadeCliente(Cliente cliente) throws SQLException, LongitudInvalidaException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		String nombre=cliente.getNombre();
		String ape1=cliente.getApe1();
		String ape2=cliente.getApe2();
		String dni=cliente.getDni();
		CarnetConducir tipoCarnet=cliente.getTipoCarnet();
		
		añadeCliente(nombre, ape1, ape2, dni, tipoCarnet);

	}
	
	/**
	 * Metodo que elimina un cliente a la base de datos
	 * @param dni
	 * @throws SQLException
	 * @throws LongitudInvalidaException
	 */
	public static void eliminaCliente(String dni) throws SQLException, LongitudInvalidaException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		if (RepositorioEmpleados.BuscaEmpleados(dni)!=null)
		{
			query = "DELETE FROM clientes where dni = ?";
			St = AccesoADatos.dbconexion.prepareStatement(query); 
			St.setString(1,dni);
			rs = St.executeQuery();
		}
		else
		{
			query = "DELETE FROM clientes where dni = ?";
			St = AccesoADatos.dbconexion.prepareStatement(query); 
			St.setString(1,dni);
			rs = St.executeQuery();
			
			rs=null;
			
			query = "DELETE FROM personas where dni = ?";
			St = AccesoADatos.dbconexion.prepareStatement(query); 
			St.setString(1,dni);
			rs = St.executeQuery();
		}
		}
			
	/**
	 * Metodo que elimina un cliente a la base de datos
	 * @param cliente
	 * @throws SQLException
	 * @throws LongitudInvalidaException
	 */
	public static void eliminaCliente(Cliente cliente) throws SQLException, LongitudInvalidaException
	{

		PreparedStatement St;
		ResultSet rs;
		String query;
		
		String dni=cliente.getDni();
		
		eliminaCliente(dni);
	}
		
	/**
	 * Metodo que modifica un cliente a la base de datos
	 * @param cliente
	 * @throws SQLException
	 * @throws LongitudInvalidaException
	 */
	public static void modificaCliente(Cliente cliente ) throws SQLException, LongitudInvalidaException
	{
		PreparedStatement St;
		ResultSet rs;
		String query;
		query = "UPDATE clientes set carnetconducir=? where dni = ?";
		
		
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,cliente.getTipoCarnet().getLetra());
		St.setString(2,cliente.getDni());
		rs = St.executeQuery();
		
		St=null;
		rs=null;
		query="UPDATE personas set nombre=?,ap1=?,ap2=? where dni = ?";
		
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,cliente.getNombre());
		St.setString(2,cliente.getApe1());
		St.setString(3,cliente.getApe2());
		St.setString(4,cliente.getDni());
		rs = St.executeQuery();
	}
}
