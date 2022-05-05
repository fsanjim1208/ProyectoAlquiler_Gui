package accesoadatos;

import java.sql.Connection;
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

public class RepositorioEmpleados {

	public static ArrayList<Empleado> leeEmpleadosBasededatos() throws SQLException, LongitudInvalidaException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Empleado> ListaEmpleados = new ArrayList<Empleado>();
		
		query = "SELECT pe.*,em.* FROM empleados em JOIN personas pe ON em.dni=pe.dni";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		rs = St.executeQuery(query);
		
		while (rs.next()) 
		{
			String dni=rs.getString("dni");
			String nombre=rs.getString("nombre");
			String ape1=rs.getString("ap1");
			String ape2=rs.getString("ap2");
			String codigoOficina=rs.getString("cod_ofi");
			Oficina oficinaEmpleado=RepositorioOficina.BuscaOficina(codigoOficina);
			
			Date fecha=rs.getDate("fechaalta");
			
			GregorianCalendar FechaAlta=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			
			Empleado e = new Empleado(nombre, ape1, ape2,dni,FechaAlta,oficinaEmpleado );
			
			
			
			ListaEmpleados.add(e);
		}

		
		return ListaEmpleados;
	}
	

	
	
	public static Empleado leeEmpleados(String dni) throws SQLException, LongitudInvalidaException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		query = "SELECT pe.*,em.* FROM empleados em JOIN personas pe ON em.dni=pe.dni where pe.dni=?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,dni);
		rs = St.executeQuery();
				
		Empleado empleado = null;

		
		while (rs.next()) 
		{
			String nombre=rs.getString("nombre");
			String ape1=rs.getString("ap1");
			String ape2=rs.getString("ap2");
			String codigoOficina=rs.getString("cod_ofi");
			
			Oficina oficinaEmpleado=RepositorioOficina.BuscaOficina(codigoOficina);
			
			Date fecha=rs.getDate("fechaalta");
			
			GregorianCalendar FechaAlta=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			empleado = new Empleado(nombre,ape1, ape2, dni,FechaAlta,oficinaEmpleado);
		}

		return empleado;
	}
	
	public static void añadeEmpleado(String nombre, String ape1, String ape2, String dni,String fechaAltEmpleado, String CodigoOficinaEmpleado) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		query = "Insert into personas (dni,nombre,ap1,ap2) values (?,?,?,?)";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,dni);
		St.setString(2,nombre);
		St.setString(3,ape1);
		St.setString(4,ape2);
		
		rs = St.executeQuery();
		rs=null;
		
		query = "Insert into empleados (dni,fechaAlta, cod_ofi) values (?,?,?)";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,dni);
		St.setString(2, fechaAltEmpleado);
		St.setString(3,CodigoOficinaEmpleado);
		
		rs = St.executeQuery();
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
		
		query = "DELETE FROM cliente where dni = ?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,dni);

		rs = St.executeQuery(query);
		rs=null;
		
		query = "DELETE FROM personas where dni = ?";
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
