package accesoadatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import entidades.Alquiler;
import entidades.Categoria;
import entidades.Cliente;
import entidades.CochesCombustion;
import entidades.CochesElectricos;
import entidades.Empleado;
import entidades.Furgonetas;
import entidades.Motocicletas;
import entidades.Oficina;
import entidades.Vehiculo;
import excepciones.LongitudInvalidaException;
import metodos.Metodos;

public class RepositorioAlquileres {
	
	/**
	 * devuelve todos los alquileres
	 * @return ArrayList de alquileres
	 * @throws SQLException
	 * @throws LongitudInvalidaException
	 */
	public static ArrayList<Alquiler> leeAlquileresBasedeDatos() throws SQLException, LongitudInvalidaException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Alquiler> ListaAlquiler = new ArrayList<Alquiler>();
		
		query = "select * from alquiler";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String codigo=rs.getString("codigo");

			Date fecha=rs.getDate("fechaalquila");
			GregorianCalendar fechaAlquila=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			Date fecha2=rs.getDate("fechaalquila");
			GregorianCalendar fechaDevuelve=new GregorianCalendar((fecha2.getYear()+1900), fecha2.getMonth(), fecha2.getDate());
			
			String codOfi=rs.getString("cod_ofi_alquila");
			Oficina oficina_alquila=RepositorioOficina.BuscaOficina(codOfi);
			
			String codOfi2=rs.getString("cod_ofi_devuelve");
			Oficina oficina_devuelve=RepositorioOficina.BuscaOficina(codOfi2);
			
			String dni_empleado=rs.getString("dni_empleado");
			Empleado empleado = RepositorioEmpleados.BuscaEmpleados(dni_empleado);
			
			String dni_cliente=rs.getString("dni_cliente");
			Cliente cliente = RepositorioCliente.BuscaCliente(dni_cliente);
			

			String matricula = rs.getString("matricula");
		
			double precio=rs.getDouble("precio");
			
			Vehiculo vehiculo = null;
		
			
			if (RepositorioVehiculos.buscaCocheCombustion(matricula)!=null)
			{
				 vehiculo= RepositorioVehiculos.buscaCocheCombustion(matricula);
			}
			else if (RepositorioVehiculos.buscaCocheElectricos(matricula)!=null)
			{
				 vehiculo = RepositorioVehiculos.buscaCocheElectricos(matricula);
			}
			else if (RepositorioVehiculos.buscaFurgonetas(matricula)!=null)
			{
				 vehiculo = RepositorioVehiculos.buscaFurgonetas(matricula);
			}
			else if (RepositorioVehiculos.buscaMotos(matricula)!=null)
			{
				 vehiculo = RepositorioVehiculos.buscaMotos(matricula);
			}
			
			boolean devuelto= rs.getBoolean("devuelto");
			
			Alquiler alquiler = new Alquiler(codigo, cliente, empleado, vehiculo, oficina_alquila,oficina_devuelve, fechaAlquila, fechaDevuelve, precio,devuelto);
			
			ListaAlquiler.add(alquiler);
		}

		
		return ListaAlquiler;
	}
	
	/**
	 * devuelve todos los alquileres activos 
	 * @return ArrayList de alquileres
	 * @throws SQLException
	 * @throws LongitudInvalidaException
	 */
	public static ArrayList<Alquiler> leeAlquileresBasedeDatosActivos() throws SQLException, LongitudInvalidaException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Alquiler> ListaAlquiler = new ArrayList<Alquiler>();
		
		query = "select * from alquiler WHERE devuelto=0";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String codigo=rs.getString("codigo");

			Date fecha=rs.getDate("fechaalquila");
			GregorianCalendar fechaAlquila=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			Date fecha2=rs.getDate("fechadevuelve");
			GregorianCalendar fechaDevuelve=new GregorianCalendar((fecha2.getYear()+1900), fecha2.getMonth(), fecha2.getDate());
			
			String codOfi=rs.getString("cod_ofi_alquila");
			Oficina oficina_alquila=RepositorioOficina.BuscaOficina(codOfi);
			
			String codOfi2=rs.getString("cod_ofi_devuelve");
			Oficina oficina_devuelve=RepositorioOficina.BuscaOficina(codOfi2);
			
			String dni_empleado=rs.getString("dni_empleado");
			Empleado empleado = RepositorioEmpleados.BuscaEmpleados(dni_empleado);
			
			String dni_cliente=rs.getString("dni_cliente");
			Cliente cliente = RepositorioCliente.BuscaCliente(dni_cliente);
			

			String matricula = rs.getString("matricula");
			
			Vehiculo vehiculo = null;
			
			if (RepositorioVehiculos.buscaCocheCombustion(matricula)!=null)
			{
				 vehiculo= RepositorioVehiculos.buscaCocheCombustion(matricula);
			}
			else if (RepositorioVehiculos.buscaCocheElectricos(matricula)!=null)
			{
				 vehiculo = RepositorioVehiculos.buscaCocheElectricos(matricula);
			}
			else if (RepositorioVehiculos.buscaFurgonetas(matricula)!=null)
			{
				 vehiculo = RepositorioVehiculos.buscaFurgonetas(matricula);
			}
			else if (RepositorioVehiculos.buscaMotos(matricula)!=null)
			{
				 vehiculo = RepositorioVehiculos.buscaMotos(matricula);
			}
			
			boolean devuelto= rs.getBoolean("devuelto");
			
			double precio=rs.getDouble("precio");
			
			Alquiler alquiler = new Alquiler(codigo, cliente, empleado, vehiculo, oficina_alquila,oficina_devuelve, fechaAlquila, fechaDevuelve,precio, devuelto);
			
			ListaAlquiler.add(alquiler);
		}

		
		return ListaAlquiler;
	}
	
	/**
	 * devuelve todos los alquileres finalizados
	 * @return ArrayList de alquileres
	 * @throws SQLException
	 * @throws LongitudInvalidaException
	 */
	public static ArrayList<Alquiler> leeAlquileresBasedeDatosFinalizados() throws SQLException, LongitudInvalidaException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Alquiler> ListaAlquiler = new ArrayList<Alquiler>();
		
		query = "select * from alquiler WHERE devuelto=1";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String codigo=rs.getString("codigo");

			Date fecha=rs.getDate("fechaalquila");
			GregorianCalendar fechaAlquila=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			Date fecha2=rs.getDate("fechaalquila");
			GregorianCalendar fechaDevuelve=new GregorianCalendar((fecha2.getYear()+1900), fecha2.getMonth(), fecha2.getDate());
			
			String codOfi=rs.getString("cod_ofi_alquila");
			Oficina oficina_alquila=RepositorioOficina.BuscaOficina(codOfi);
			
			String codOfi2=rs.getString("cod_ofi_devuelve");
			Oficina oficina_devuelve=RepositorioOficina.BuscaOficina(codOfi2);
			
			String dni_empleado=rs.getString("dni_empleado");
			Empleado empleado = RepositorioEmpleados.BuscaEmpleados(dni_empleado);
			
			String dni_cliente=rs.getString("dni_cliente");
			Cliente cliente = RepositorioCliente.BuscaCliente(dni_cliente);
			

			String matricula = rs.getString("matricula");
			
			Vehiculo vehiculo = null;
			
			if (RepositorioVehiculos.buscaCocheCombustion(matricula)!=null)
			{
				 vehiculo= RepositorioVehiculos.buscaCocheCombustion(matricula);
			}
			else if (RepositorioVehiculos.buscaCocheElectricos(matricula)!=null)
			{
				 vehiculo = RepositorioVehiculos.buscaCocheElectricos(matricula);
			}
			else if (RepositorioVehiculos.buscaFurgonetas(matricula)!=null)
			{
				 vehiculo = RepositorioVehiculos.buscaFurgonetas(matricula);
			}
			else if (RepositorioVehiculos.buscaMotos(matricula)!=null)
			{
				 vehiculo = RepositorioVehiculos.buscaMotos(matricula);
			}
			
			boolean devuelto= rs.getBoolean("devuelto");
			
			double precio=rs.getDouble("precio");
			
			Alquiler alquiler = new Alquiler(codigo, cliente, empleado, vehiculo, oficina_alquila,oficina_devuelve, fechaAlquila, fechaDevuelve,precio, devuelto);
			
			ListaAlquiler.add(alquiler);
		}

		
		return ListaAlquiler;
	}
	
	/**
	 * busca unn alquiler a partir del empleado que lo realizo
	 * @param dni_emple
	 * @return alquiler
	 * @throws SQLException
	 * @throws LongitudInvalidaException
	 */
	public static Alquiler BuscaAlquileresDeEmpleado(String dni_emple) throws SQLException, LongitudInvalidaException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		dni_emple=dni_emple.toUpperCase();
		
		query = "SELECT * FROM alquiler WHERE dni_empleado = ?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,dni_emple);
		rs = St.executeQuery();
				
		Alquiler a = null;

		
		while (rs.next()) 
		{
			String codigo=rs.getString("Codigo");
			
			Date fecha=rs.getDate("fechaalquila");
			GregorianCalendar FechaAlquila=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			Date fecha2=rs.getDate("fechadevuelve");
			GregorianCalendar FechaDevuelve=new GregorianCalendar((fecha2.getYear()+1900), fecha2.getMonth(), fecha2.getDate());
			
			String cod_ofi=rs.getString("cod_ofi_alquila");
			Oficina ofi_alquila=RepositorioOficina.BuscaOficina(cod_ofi);
			
			String cod_ofi2=rs.getString("cod_ofi_devuelve");
			Oficina ofi_devuelve=RepositorioOficina.BuscaOficina(cod_ofi2);
			
			String dni_empleado=rs.getString("dni_empleado");
			Empleado emple=RepositorioEmpleados.BuscaEmpleados(dni_empleado);
			
			String dni_cliente=rs.getString("dni_cliente");
			Cliente clien=RepositorioCliente.BuscaCliente(dni_cliente);
			
			String matricula=rs.getString("matricula");
			
			Vehiculo vehiculo = null;
			
			if (RepositorioVehiculos.buscaCocheCombustion(matricula)!=null)
			{
				 vehiculo= RepositorioVehiculos.buscaCocheCombustion(matricula);
			}
			else if (RepositorioVehiculos.buscaCocheElectricos(matricula)!=null)
			{
				 vehiculo = RepositorioVehiculos.buscaCocheElectricos(matricula);
			}
			else if (RepositorioVehiculos.buscaFurgonetas(matricula)!=null)
			{
				 vehiculo = RepositorioVehiculos.buscaFurgonetas(matricula);
			}
			else if (RepositorioVehiculos.buscaMotos(matricula)!=null)
			{
				 vehiculo = RepositorioVehiculos.buscaMotos(matricula);
			}
			boolean devuelto= rs.getBoolean("devuelto");
			
			double precio=rs.getDouble("precio");
			
			a = new Alquiler(codigo, clien, emple, vehiculo, ofi_alquila,ofi_devuelve, FechaAlquila, FechaDevuelve,precio, devuelto);
		}

		return a;
	}
	
	/**
	 * busca un alquiler a partir de su codigo
	 * @param codigo 
	 * @return alquiler
	 * @throws SQLException
	 * @throws LongitudInvalidaException
	 */
	public static Alquiler BuscaAlquilere(String codigo) throws SQLException, LongitudInvalidaException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		query = "SELECT * FROM alquiler WHERE codigo = ?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,codigo);
		rs = St.executeQuery();
				
		Alquiler a = null;

		
		while (rs.next()) 
		{
			
			Date fecha=rs.getDate("fechaalquila");
			GregorianCalendar FechaAlquila=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			Date fecha2=rs.getDate("fechadevuelve");
			GregorianCalendar FechaDevuelve=new GregorianCalendar((fecha2.getYear()+1900), fecha2.getMonth(), fecha2.getDate());
			
			String cod_ofi=rs.getString("cod_ofi_alquila");
			Oficina ofi_alquila=RepositorioOficina.BuscaOficina(cod_ofi);
			
			String cod_ofi2=rs.getString("cod_ofi_devuelve");
			Oficina ofi_devuelve=RepositorioOficina.BuscaOficina(cod_ofi2);
			
			String dni_empleado=rs.getString("dni_empleado");
			Empleado emple=RepositorioEmpleados.BuscaEmpleados(dni_empleado);
			
			String dni_cliente=rs.getString("dni_cliente");
			Cliente clien=RepositorioCliente.BuscaCliente(dni_cliente);
			
			String matricula=rs.getString("matricula");
			
			Vehiculo vehiculo = null;
			
			if (RepositorioVehiculos.buscaCocheCombustion(matricula)!=null)
			{
				 vehiculo= RepositorioVehiculos.buscaCocheCombustion(matricula);
			}
			else if (RepositorioVehiculos.buscaCocheElectricos(matricula)!=null)
			{
				 vehiculo = RepositorioVehiculos.buscaCocheElectricos(matricula);
			}
			else if (RepositorioVehiculos.buscaFurgonetas(matricula)!=null)
			{
				 vehiculo = RepositorioVehiculos.buscaFurgonetas(matricula);
			}
			else if (RepositorioVehiculos.buscaMotos(matricula)!=null)
			{
				 vehiculo = RepositorioVehiculos.buscaMotos(matricula);
			}
			
			boolean devuelto= rs.getBoolean("devuelto");
			
			double precio=rs.getDouble("precio");
			
			a = new Alquiler(codigo, clien, emple, vehiculo, ofi_alquila,ofi_devuelve, FechaAlquila, FechaDevuelve,precio,devuelto);
		}

		return a;
	}
	
	/**
	 * añade un alquiler a la base de datos
	 * @param alquiler
	 * @throws SQLException
	 */
	public static void añadeAlqiler(Alquiler alquiler) throws SQLException
	{
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		alquiler.getVehiculo_alqiuilado().setAlquilado(true);
		
		String codigo=alquiler.getCodigo();
		String dni_cliente=alquiler.getCliente().getDni();
		String dni_empleado=alquiler.getEmpleado().getDni();
		String matricula=alquiler.getMatricula_vehiculo_Alquilado();
		String codigo_ofi_alquila=alquiler.getLugar_alquila().getCodigo();
		String codigo_ofi_devuelve=alquiler.getLugar_devuelve().getCodigo();
		

		String fechaAlquila= Metodos.ConvierteGregorianCalendaraString(alquiler.getFecha_alquila());
		
		String fechaDevuelve= Metodos.ConvierteGregorianCalendaraString(alquiler.getFecha_devuelve());
		
		boolean devuelto = alquiler.isDevuelto();
		double precio=alquiler.getPrecio();
		
		query = "INSERT INTO alquiler (codigo,fechaalquila,fechadevuelve, cod_ofi_alquila,cod_ofi_devuelve, dni_empleado,dni_cliente,matricula,precio,devuelto) VALUES (?,?,?,?,?,?,?,?,?,?)";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,codigo);
		St.setString(2,fechaAlquila);
		St.setString(3,fechaDevuelve);
		St.setString(4,codigo_ofi_alquila);
		St.setString(5,codigo_ofi_devuelve);
		St.setString(6,dni_empleado);
		St.setString(7,dni_cliente);
		St.setString(8,matricula);
		St.setDouble(9, precio);
		St.setBoolean(10, devuelto);
		
		rs = St.executeQuery();
		
	}
	
	/**
	 * elimina un alquiler a la base de datos
	 * @param alquiler
	 * @throws SQLException
	 */
	public static void eliminaAlquileres(Alquiler alquiler) throws SQLException
	{
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		
		String codigo=alquiler.getCodigo();
		
		query = "DELETE FROM alquiler where codigo = ?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,codigo);
		rs = St.executeQuery();
	}
	
	/**
	 * devuelve un alquiler a la base de datos
	 * @param alquiler
	 * @throws SQLException
	 */
	public static void DevuelveAlquileres (Alquiler alquiler) throws SQLException
	{
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		alquiler.getVehiculo_alqiuilado().setAlquilado(true);
		
		RepositorioVehiculos.ModificaVehiculo(alquiler.getVehiculo_alqiuilado());
		
		
		
		String codigo=alquiler.getCodigo();
		
		query = "update alquiler set devuelto=1 where codigo = ?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,codigo);
		rs = St.executeQuery();
	}

}
