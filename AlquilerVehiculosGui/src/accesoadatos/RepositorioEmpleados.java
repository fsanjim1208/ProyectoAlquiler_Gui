package accesoadatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import entidades.Alquiler;
import entidades.CarnetConducir;
import entidades.Cliente;
import entidades.Empleado;
import entidades.Oficina;
import excepciones.LongitudInvalidaException;

public class RepositorioEmpleados {

	/**
	 * devuelve todos los empleados de la base de datos
	 * @return ArrayList de empleados
	 * @throws SQLException
	 * @throws LongitudInvalidaException
	 */
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
	
	/**
	 * Busca un empleado a partir de su DNI
	 * @param dni
	 * @return devuelve un empleado
	 * @throws SQLException
	 * @throws LongitudInvalidaException
	 */
	public static Empleado BuscaEmpleados(String dni) throws SQLException, LongitudInvalidaException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		dni=dni.toUpperCase();
		
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
	
	/**
	 * devuelve todos los empleados de una oficina
	 * @param cod_ofi codigo de la ofician por la que buscar
	 * @return ArrayList de empleados
	 * @throws SQLException
	 * @throws LongitudInvalidaException
	 */
	public static ArrayList<Empleado> BuscaEmpleadodeOficina (String cod_ofi) throws SQLException, LongitudInvalidaException
	{

		
		PreparedStatement St;
		ResultSet rs;
		String query;
	
		ArrayList<Empleado> ListaEmpleados = new ArrayList<Empleado>();
		
		query = "SELECT pe.*,em.* FROM empleados em JOIN personas pe ON em.dni=pe.dni where em.cod_ofi=?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,cod_ofi);
		rs = St.executeQuery();
				
		Empleado empleado = null;

		
		while (rs.next()) 
		{
			String nombre=rs.getString("nombre");
			String ape1=rs.getString("ap1");
			String ape2=rs.getString("ap2");
			String dni=rs.getString("dni");
			
			Oficina oficinaEmpleado=RepositorioOficina.BuscaOficina(cod_ofi);
			
			Date fecha=rs.getDate("fechaalta");
			
			GregorianCalendar FechaAlta=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			empleado = new Empleado(nombre,ape1, ape2, dni,FechaAlta,oficinaEmpleado);
			
			ListaEmpleados.add(empleado);
		}

		return ListaEmpleados;
	}
	
	/**
	 * Metodo que añade un empleado a la base de datos
	 * @param nombre
	 * @param ape1
	 * @param ape2
	 * @param dni
	 * @param fechaAltEmpleado
	 * @param CodigoOficinaEmpleado
	 * @throws SQLException
	 * @throws LongitudInvalidaException
	 */
	public static void añadeEmpleado(String nombre, String ape1, String ape2, String dni,String fechaAltEmpleado, String CodigoOficinaEmpleado) throws SQLException, LongitudInvalidaException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		if (RepositorioCliente.BuscaCliente(dni)==null)
		{
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
		else
		{
			query = "Insert into empleados (dni,fechaAlta, cod_ofi) values (?,?,?)";
			St = AccesoADatos.dbconexion.prepareStatement(query); 
			St.setString(1,dni);
			St.setString(2, fechaAltEmpleado);
			St.setString(3,CodigoOficinaEmpleado);
			
			rs = St.executeQuery();
		}
	}
	
	/**
	 * Metodo que añade un empleado a la base de datos
	 * @param empleado
	 * @throws SQLException
	 * @throws LongitudInvalidaException
	 */
	public static void añadeEmpleado(Empleado empleado) throws SQLException, LongitudInvalidaException
	{
		
		String nombre=empleado.getNombre();
		String ape1=empleado.getApe1();
		String ape2=empleado.getApe2();
		String dni=empleado.getDni();
		GregorianCalendar fecha=empleado.getFechaAltEmpleado();
		String fechaAlta=fecha.getTime().getDate()+"/"+(fecha.getTime().getMonth()+1)+"/"+(fecha.getTime().getYear()+1900);
		String codigo_ofi=empleado.getOficinaEmpleado().getCodigo();
		
		añadeEmpleado(nombre, ape1, ape2, dni, fechaAlta, codigo_ofi);
	}
	
	/**
	 * Metodo que elimina un empleado a la base de datos
	 * @param dni
	 * @throws SQLException
	 * @throws LongitudInvalidaException
	 */
	public static void EliminaEmpleado(String dni) throws SQLException, LongitudInvalidaException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		if(RepositorioCliente.BuscaCliente(dni)==null)
		{
			
			query = "DELETE FROM empleados where dni = ?";
			St = AccesoADatos.dbconexion.prepareStatement(query); 
			St.setString(1,dni);
			rs = St.executeQuery();
			
			rs=null;
			St=null;
			
			query = "DELETE FROM personas where dni = ?";
			St = AccesoADatos.dbconexion.prepareStatement(query); 
			St.setString(1,dni);

			rs = St.executeQuery();
		}
		else
		{
			query = "DELETE FROM empleados where dni = ?";
			St = AccesoADatos.dbconexion.prepareStatement(query); 
			St.setString(1,dni);
			rs = St.executeQuery();
		}
	}
	
	/**
	 * Metodo que elimina un empleado a la base de datos
	 * @param empleado
	 * @throws SQLException
	 * @throws LongitudInvalidaException
	 */
	public static void eliminaEmpleado(Empleado empleado) throws SQLException, LongitudInvalidaException
	{
		
		String dni=empleado.getDni();
		
		EliminaEmpleado(dni);
	}
		
	/**
	 * Metodo que modifica un empleado a la base de datos
	 * @param empleadoviejo
	 * @param empleadonuevo
	 * @throws SQLException
	 * @throws LongitudInvalidaException
	 */
	public static void modificaEmpleado(Empleado empleadoviejo, Empleado empleadonuevo ) throws SQLException, LongitudInvalidaException
	{
		Alquiler alquiler=RepositorioAlquileres.BuscaAlquileresDeEmpleado(empleadoviejo.getDni());
		RepositorioAlquileres.eliminaAlquileres(alquiler);
		eliminaEmpleado(empleadoviejo);
		añadeEmpleado(empleadonuevo);
		alquiler.setEmpleado(empleadonuevo);
		RepositorioAlquileres.añadeAlqiler(alquiler);
	}
}
