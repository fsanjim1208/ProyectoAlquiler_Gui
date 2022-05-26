package accesoadatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import entidades.CarnetConducir;
import entidades.Categoria;
import entidades.CochesCombustion;
import entidades.CochesElectricos;
import entidades.Combustion;
import entidades.Electrico;
import entidades.Furgonetas;
import entidades.Motocicletas;
import entidades.Oficina;
import entidades.Vehiculo;
import excepciones.LongitudInvalidaException;
import metodos.Metodos;

public class RepositorioVehiculos {

/**
 * Metodo que lee todos los vehiculos almacenados en la base de datos
 * @return ArrayList de todos los vehiculos
 * @throws SQLException
 */
	public static ArrayList<Vehiculo> leeVehiculosBasededatos() throws SQLException
	{

		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		for (int i=0;i<RepositorioVehiculos.leeCochesCombustion().size();i++)
		{
			ListaVehiculo.add(RepositorioVehiculos.leeCochesCombustion().get(i));
		}
		for (int i=0;i<RepositorioVehiculos.leeCochesElectricos().size();i++)
		{
			ListaVehiculo.add(RepositorioVehiculos.leeCochesElectricos().get(i));
		}
		for (int i=0;i<RepositorioVehiculos.leeFurgonetas().size();i++)
		{
			ListaVehiculo.add(RepositorioVehiculos.leeFurgonetas().get(i));
		}
		for (int i=0;i<RepositorioVehiculos.leeMotos().size();i++)
		{
			ListaVehiculo.add(RepositorioVehiculos.leeMotos().get(i));
		}

		
		return ListaVehiculo;
	}
	
	/**
	 * Metodo que devuelve todos los vehiculos que no estan alquilados en este momento
	 * @return ArrayList de los vehiculos sin alquilar
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeVehiculosBasededatosActivos() throws SQLException
	{

		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		for (int i=0;i<RepositorioVehiculos.leeCochesCombustionActivos().size();i++)
		{
			ListaVehiculo.add(RepositorioVehiculos.leeCochesCombustionActivos().get(i));
		}
		for (int i=0;i<RepositorioVehiculos.leeCochesElectricosActivos().size();i++)
		{
			ListaVehiculo.add(RepositorioVehiculos.leeCochesElectricosActivos().get(i));
		}
		for (int i=0;i<RepositorioVehiculos.leeFurgonetasActivas().size();i++)
		{
			ListaVehiculo.add(RepositorioVehiculos.leeFurgonetasActivas().get(i));
		}
		for (int i=0;i<RepositorioVehiculos.leeMotosActivos().size();i++)
		{
			ListaVehiculo.add(RepositorioVehiculos.leeMotosActivos().get(i));
		}

		
		return ListaVehiculo;
	}
	
	/**
	 * Metodo que devuelve todos los vehiculos que estan alquilados en este momento
	 * @return ArrayList de los vehiculos alquilados
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeVehiculosBasededatosAlquilados() throws SQLException
	{

		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		for (int i=0;i<RepositorioVehiculos.leeCochesCombustionAlquilados().size();i++)
		{
			ListaVehiculo.add(RepositorioVehiculos.leeCochesCombustionAlquilados().get(i));
		}
		for (int i=0;i<RepositorioVehiculos.leeCochesElectricosAlquilados().size();i++)
		{
			ListaVehiculo.add(RepositorioVehiculos.leeCochesElectricosAlquilados().get(i));
		}
		for (int i=0;i<RepositorioVehiculos.leeFurgonetasAlquiladas().size();i++)
		{
			ListaVehiculo.add(RepositorioVehiculos.leeFurgonetasAlquiladas().get(i));
		}
		for (int i=0;i<RepositorioVehiculos.leeMotosAlquiladas().size();i++)
		{
			ListaVehiculo.add(RepositorioVehiculos.leeMotosAlquiladas().get(i));
		}

		
		return ListaVehiculo;
	}
	
	/**
	 * Metodo que devuelve todos los vehiculos que pertenece a una oficina
	 * @param ofi Objeto Oficina a los que pertenecen los vehiculos devueltos
	 * @return ArrayList de los vehiculos de esa oficina
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeVehiculosBasededatosdeOficina(Oficina ofi) throws SQLException
	{

		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		for (int i=0;i<RepositorioVehiculos.leeCochesCombustiondeOficina(ofi).size();i++)
		{
			ListaVehiculo.add(RepositorioVehiculos.leeCochesCombustiondeOficina(ofi).get(i));
		}
		for (int i=0;i<RepositorioVehiculos.leeCochesElectricosdeOficina(ofi).size();i++)
		{
			ListaVehiculo.add(RepositorioVehiculos.leeCochesElectricosdeOficina(ofi).get(i));
		}
		for (int i=0;i<RepositorioVehiculos.leeFurgonetasdeOficina(ofi).size();i++)
		{
			ListaVehiculo.add(RepositorioVehiculos.leeFurgonetasdeOficina(ofi).get(i));
		}
		for (int i=0;i<RepositorioVehiculos.leeMotosdeOficina(ofi).size();i++)
		{
			ListaVehiculo.add(RepositorioVehiculos.leeMotosdeOficina(ofi).get(i));
		}

		
		return ListaVehiculo;
	}
	
	/**
	 * Metodo que devuelve todos los vehiculos que pertenece a una categoria
	 * @param categoria Objeto Categoria a los que pertenecen los vehiculos devueltos
	 * @return ArrayList de los vehiculos de esa categoria
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeVehiculosBasededatosdeCategoria(Categoria categoria) throws SQLException
	{

		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		for (int i=0;i<RepositorioVehiculos.leeCochesCombustiondeCategoria(categoria).size();i++)
		{
			ListaVehiculo.add(RepositorioVehiculos.leeCochesCombustiondeCategoria(categoria).get(i));
		}
		for (int i=0;i<RepositorioVehiculos.leeCochesElectricosdeCategoria(categoria).size();i++)
		{
			ListaVehiculo.add(RepositorioVehiculos.leeCochesElectricosdeCategoria(categoria).get(i));
		}
		for (int i=0;i<RepositorioVehiculos.leeFurgonetasdeCategoria(categoria).size();i++)
		{
			ListaVehiculo.add(RepositorioVehiculos.leeFurgonetasdeCategoria(categoria).get(i));
		}
		for (int i=0;i<RepositorioVehiculos.leeMotosdeCategoria(categoria).size();i++)
		{
			ListaVehiculo.add(RepositorioVehiculos.leeMotosdeCategoria(categoria).get(i));
		}

		return ListaVehiculo;
	}
	
	/**
	 * MEtodo que añade un vehiculo al base de datos
	 * @param ve vehiculo que será añadido
	 * @throws SQLException
	 */
	public static void añadeVehiculos (Vehiculo ve) throws SQLException
	{
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		query = "insert into vehiculo (matricula, marca, modelo,color,km,fechaAdquisicion, cod_ofi, cod_categoria,alquilado) "
     		  + "values (?,?,?,?,?,?,?,?,0)";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,ve.getMatricula());
		St.setString(2,ve.getMarca());
		St.setString(3,ve.getModelo());
		St.setString(4,ve.getColor());
		St.setInt(5,ve.getKm());
		
		GregorianCalendar fecha=ve.getFechaadquisicion();
		String fechaadquision=fecha.getTime().getDate()+"/"+(fecha.getTime().getMonth()+1)+"/"+(fecha.getTime().getYear()+1900);
		
		St.setString(6, fechaadquision);
		St.setString(7,ve.getOficina().getCodigo());
		St.setString(8,ve.getCategoria().getCodigo());
		
		rs = St.executeQuery();
	}
	
	/**
	 * Metodo que elimina el vehiculo de la base de datos
	 * @param matricula matriucula del vehiculo que será eliminado
	 * @throws SQLException
	 */
	public static void EliminaVehiculo(String matricula) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
			
		query = "DELETE FROM vehiculo where matricula = ?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,matricula);
		rs = St.executeQuery();
			
	}

	/**
	 * Metodo que modifica un vehiculo dado en la base de datos
	 * @param vehiculo Vehiculo que será modificado
	 * @throws SQLException
	 */
	public static void ModificaVehiculo (Vehiculo vehiculo) throws SQLException
	{
		PreparedStatement St;
		ResultSet rs;
		String query;

		query = "Update vehiculo set marca=?, modelo=?, color=?, km=?, fechaadquisicion=?, cod_ofi=?, cod_categoria=? where matricula=?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,vehiculo.getMarca());
		St.setString(2,vehiculo.getModelo());
		St.setString(3,vehiculo.getColor());
		St.setInt(4,vehiculo.getKm());
		St.setString(5,Metodos.ConvierteGregorianCalendaraString(vehiculo.getFechaadquisicion()));
		St.setString(6,vehiculo.getOficina().getCodigo());
		St.setString(7,vehiculo.getCategoria().getCodigo());
		St.setString(8,vehiculo.getMatricula());
		rs = St.executeQuery();
	}
	
	
										//**********
										//COMBUSTION
										//**********
	
	/**
	 * Metodo que añade un combustion a la base de datos
	 * @param cc objeto combustion
	 * @throws SQLException
	 */
	public static void AñadeCombustion(Combustion cc) throws SQLException
	{
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		añadeVehiculos(cc);
		
		query = "insert into combustion (matricula, consumo, Potencia ,NivelEmisiones) values (?,?,?,?)";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		
		St.setString(1,cc.getMatricula());
		St.setString(2, cc.getConsumo());
		St.setInt(3,cc.getPotencia());
		St.setString(4,cc.getNivelEmisiones());

		
		rs = St.executeQuery();
	}
	
	/**
	 * Metodo que elimina un combustion de la base de datos
	 * @param matricula Matricula del combustion que será eliminado
	 * @throws SQLException
	 */
	public static void EliminaCombustion(String matricula) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
	
		query = "DELETE FROM combustion where matricula = ?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,matricula);
		rs = St.executeQuery();
		
		EliminaVehiculo(matricula);		
	}
	
	/**
	 * Metodo que modifica un combustion de la base de datos
	 * @param vehiculo combustion que sera modificado
	 * @throws SQLException
	 */
	public static void ModificaCombustion(Combustion vehiculo) throws SQLException
	{
		PreparedStatement St;
		ResultSet rs;
		String query;
	
		query = "Update combustion set consumo=?, potencia=?, nivelemisiones=? where matricula=?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,""+vehiculo.getConsumo());
		St.setString(2,""+vehiculo.getPotencia());
		St.setString(3,""+vehiculo.getNivelEmisiones());
		St.setString(4,vehiculo.getMatricula());
		rs = St.executeQuery();
		
		ModificaVehiculo(vehiculo);
	}
	
										//*********
										//ELECTRICO
										//*********
	/**
	 * Metodo que añade un electrico a la base de datos
	 * @param ce 
	 * @throws SQLException
	 */
	public static void AñadeElectrico(Electrico ce) throws SQLException
	{
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		añadeVehiculos(ce);
		
		query = "insert into electrico (matricula, autonomia, TiempoRecarga ,Recargo) values (?,?,?,15)";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		
		St.setString(1,ce.getMatricula());
		St.setInt(2, ce.getAutonomia());
		St.setInt(3,ce.getTiempoRecarga());

		
		rs = St.executeQuery();
		
	
	}
	
	/**
	 * Metodo que elimina un electrico de la base de datos
	 * @param matricula matricula del electrico que sera eliminado
	 * @throws SQLException
	 */
	public static void EliminaElectrico(String matricula) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
			
		query = "DELETE FROM electrico where matricula = ?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,matricula);
		rs = St.executeQuery();
		
		EliminaVehiculo(matricula);
			
	}
	
	/**
	 * Metodo que modifica un electrico de la base de datos
	 * @param vehiculo electrico que sera modificado
	 * @throws SQLException
	 */
	public static void ModificaElectrico(Electrico vehiculo) throws SQLException
	{
		PreparedStatement St;
		ResultSet rs;
		String query;
	
		query = "Update electrico set autonomia=?, tiemporecarga=? where matricula=?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setInt(1,vehiculo.getAutonomia());
		St.setInt(2,vehiculo.getTiempoRecarga());
		St.setString(3,vehiculo.getMatricula());
		rs = St.executeQuery();
		
		ModificaVehiculo(vehiculo);
	}
	
									//*****************
									//COCHES COMBUSTION
									//*****************
	
	/**
	 * MEtodo que lee coches de combustion de la base de datos
	 * @return ArrayList de vehiculos de combustion
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeCochesCombustion() throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		query = "select * "
				+ "from vehiculo ve join combustion co on ve.matricula=co.matricula"
				+ "                 join CochesCombustion cc on ve.matricula=cc.matricula";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String matricula=rs.getString("matricula");
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			String codOfi=rs.getString("cod_ofi");
			Oficina oficina=RepositorioOficina.BuscaOficina(codOfi);
			String cod_categoria=rs.getString("cod_categoria");
			Categoria categoria = RepositorioCategorias.leeCategoria(cod_categoria);
			String consumo=rs.getString("consumo");
			int potencia = rs.getInt("potencia");
			String emisiones = rs.getString("nivelemisiones");
			int plazas = rs.getInt("nplazas");
			String tipo= rs.getString("tipo");
			Boolean alquilado=rs.getBoolean("alquilado");
			
			Vehiculo o = new CochesCombustion(matricula, marca, modelo, color, km,fechaadquisicion, oficina, categoria,alquilado,
			                                  potencia,consumo,emisiones, plazas,  tipo);
			ListaVehiculo.add(o);
		}

		
		return ListaVehiculo;
	}
	
	/**
	 * Metodo que lee coches de combustion que estan disponibles de la base de datos
	 * @return ArrayList de vehiculos de combustion
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeCochesCombustionActivos() throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		query = "select * "
				+ "from vehiculo ve join combustion co on ve.matricula=co.matricula"
				+ "                 join CochesCombustion cc on ve.matricula=cc.matricula"
				+ " where ve.alquilado=0";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String matricula=rs.getString("matricula");
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			String codOfi=rs.getString("cod_ofi");
			Oficina oficina=RepositorioOficina.BuscaOficina(codOfi);
			String cod_categoria=rs.getString("cod_categoria");
			Categoria categoria = RepositorioCategorias.leeCategoria(cod_categoria);
			String consumo=rs.getString("consumo");
			int potencia = rs.getInt("potencia");
			String emisiones = rs.getString("nivelemisiones");
			int plazas = rs.getInt("nplazas");
			String tipo= rs.getString("tipo");
			Boolean alquilado=rs.getBoolean("alquilado");
			
			Vehiculo o = new CochesCombustion(matricula, marca, modelo, color, km,fechaadquisicion, oficina, categoria,alquilado,
			                                  potencia,consumo,emisiones, plazas,  tipo);
			ListaVehiculo.add(o);
		}

		
		return ListaVehiculo;
	}
	
	/**
	 * Metodo que lee coches de combustion que estan alquilados de la base de datos
	 * @return ArrayList de vehiculos de combustion
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeCochesCombustionAlquilados() throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		query = "select * "
				+ "from vehiculo ve join combustion co on ve.matricula=co.matricula"
				+ "                 join CochesCombustion cc on ve.matricula=cc.matricula"
				+ " where ve.alquilado=1";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String matricula=rs.getString("matricula");
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			String codOfi=rs.getString("cod_ofi");
			Oficina oficina=RepositorioOficina.BuscaOficina(codOfi);
			String cod_categoria=rs.getString("cod_categoria");
			Categoria categoria = RepositorioCategorias.leeCategoria(cod_categoria);
			String consumo=rs.getString("consumo");
			int potencia = rs.getInt("potencia");
			String emisiones = rs.getString("nivelemisiones");
			int plazas = rs.getInt("nplazas");
			String tipo= rs.getString("tipo");
			Boolean alquilado=rs.getBoolean("alquilado");
			
			Vehiculo o = new CochesCombustion(matricula, marca, modelo, color, km,fechaadquisicion, oficina, categoria,alquilado,
			                                  potencia,consumo,emisiones, plazas,  tipo);
			ListaVehiculo.add(o);
		}

		
		return ListaVehiculo;
	}
	
	/**
	 * MEtodo que lee coches de combustion de una categoria de la base de datos
	 * @param categoria Objeto Categoria a la que pertenecen los coches devueltos
	 * @return ArrayList de vehiculos de combustion
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeCochesCombustiondeCategoria(Categoria categoria) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		query = "select * "
				+ "from vehiculo ve join combustion co on ve.matricula=co.matricula"
				+ "                 join CochesCombustion cc on ve.matricula=cc.matricula"
				+ " where ve.cod_categoria=?";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,categoria.getCodigo());
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String matricula=rs.getString("matricula");
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			String codOfi=rs.getString("cod_ofi");
			Oficina oficina=RepositorioOficina.BuscaOficina(codOfi);
			
			String consumo=rs.getString("consumo");
			int potencia = rs.getInt("potencia");
			String emisiones = rs.getString("nivelemisiones");
			int plazas = rs.getInt("nplazas");
			String tipo= rs.getString("tipo");
			Boolean alquilado=rs.getBoolean("alquilado");
			
			Vehiculo o = new CochesCombustion(matricula, marca, modelo, color, km,fechaadquisicion, oficina, categoria,alquilado,
			                                  potencia,consumo,emisiones, plazas,  tipo);
			ListaVehiculo.add(o);
		}

		
		return ListaVehiculo;
	}
	
	/**
	 * MEtodo que lee coches de combustion de una oficina de la base de datos
	 * @param oficina oficina a la que pertenecen los vehiculos devueltos
	 * @return ArrayList de vehiculos de una oficina
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeCochesCombustiondeOficinaNoAlquilados(Oficina oficina) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		query = "select * "
				+ "from vehiculo ve join combustion co on ve.matricula=co.matricula"
				+ "                 join CochesCombustion cc on ve.matricula=cc.matricula"
				+ " where ve.cod_ofi=? and alquilado=0";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,oficina.getCodigo());
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String matricula=rs.getString("matricula");
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			String cod_categoria=rs.getString("cod_categoria");
			Categoria categoria = RepositorioCategorias.leeCategoria(cod_categoria);
			String consumo=rs.getString("consumo");
			int potencia = rs.getInt("potencia");
			String emisiones = rs.getString("nivelemisiones");
			int plazas = rs.getInt("nplazas");
			String tipo= rs.getString("tipo");
			Boolean alquilado=rs.getBoolean("alquilado");
			
			Vehiculo o = new CochesCombustion(matricula, marca, modelo, color, km,fechaadquisicion, oficina, categoria,alquilado,
			                                  potencia,consumo,emisiones, plazas,  tipo);
			ListaVehiculo.add(o);
		}

		
		return ListaVehiculo;
	}
	
	/**
	 * Metodo que lee coches de combustion de una oficina de la base de datos
	 * @param oficina oficina a la que pertenecen los vehiculos devueltos
	 * @return ArrayList de vehiculos de una oficina
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeCochesCombustiondeOficina(Oficina oficina) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		query = "select * "
				+ "from vehiculo ve join combustion co on ve.matricula=co.matricula"
				+ "                 join CochesCombustion cc on ve.matricula=cc.matricula"
				+ " where ve.cod_ofi=?";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,oficina.getCodigo());
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String matricula=rs.getString("matricula");
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			String cod_categoria=rs.getString("cod_categoria");
			Categoria categoria = RepositorioCategorias.leeCategoria(cod_categoria);
			String consumo=rs.getString("consumo");
			int potencia = rs.getInt("potencia");
			String emisiones = rs.getString("nivelemisiones");
			int plazas = rs.getInt("nplazas");
			String tipo= rs.getString("tipo");
			Boolean alquilado=rs.getBoolean("alquilado");
			
			Vehiculo o = new CochesCombustion(matricula, marca, modelo, color, km,fechaadquisicion, oficina, categoria,alquilado,
			                                  potencia,consumo,emisiones, plazas,  tipo);
			ListaVehiculo.add(o);
		}

		
		return ListaVehiculo;
	}
	
	/**
	 * Metodo que busca un coche a partir de su matricula
	 * @param matricula 
	 * @return devuelve el coche que tiene esa matricula
	 * @throws SQLException
	 */
	public static CochesCombustion buscaCocheCombustion(String matricula) throws SQLException
	{
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		CochesCombustion c=null;
		
		query = "select * "
				+ "from vehiculo ve join combustion co on ve.matricula=co.matricula"
				+ "                 join CochesCombustion cc on ve.matricula=cc.matricula"
				+ " where ve.matricula=?";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,matricula);
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			String codOfi=rs.getString("cod_ofi");
			Oficina oficina=RepositorioOficina.BuscaOficina(codOfi);
			String cod_categoria=rs.getString("cod_categoria");
			Categoria categoria = RepositorioCategorias.leeCategoria(cod_categoria);
			String consumo=rs.getString("consumo");
			int potencia = rs.getInt("potencia");
			String emisiones = rs.getString("nivelemisiones");
			int plazas = rs.getInt("nplazas");
			String tipo= rs.getString("tipo");
			Boolean alquilado=rs.getBoolean("alquilado");
			
			c =new CochesCombustion(matricula, marca, modelo, color, km,fechaadquisicion, oficina, categoria,alquilado,
                    potencia,consumo,emisiones, plazas,  tipo);
		}
		return c;
	}
	
	/**
	 * Metodo que añade un coche a la base de datos
	 * @param cc coche que será añadido
	 * @throws SQLException
	 */
	public static void AñadeCochesCombustion(CochesCombustion cc) throws SQLException
	{
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		AñadeCombustion(cc);
		
		query = "insert into CochesCombustion (matricula, Nplazas, Tipo,PrecioBase) values (?,?,?,50)";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,cc.getMatricula());
		St.setInt(2, cc.getNplazas());
		St.setString(3,cc.getTipo());

		
		rs = St.executeQuery();
	}
		
	/**
	 * Metodo que elimina un coche de la base de datos
	 * @param matricula
	 * @throws SQLException
	 */
	public static void EliminaCocheCombustion(String matricula) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
			
		query = "DELETE FROM CochesCombustion where matricula = ?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,matricula);
		rs = St.executeQuery();
		
		EliminaCombustion(matricula);
			
	}
	
	/**
	 * Metodo que modifica un coche en la base de datos
	 * @param vehiculo
	 * @throws SQLException
	 */
	public static void ModificaCochesCombustion(CochesCombustion vehiculo) throws SQLException
	{
		PreparedStatement St;
		ResultSet rs;
		String query;
	
		query = "Update cochescombustion set nplazas=?, tipo=? where matricula=?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setInt(1,vehiculo.getNplazas());
		St.setString(2, vehiculo.getTipo());
		St.setString(3, vehiculo.getMatricula());
		rs = St.executeQuery();
		
		ModificaCombustion(vehiculo);
	}
	
	
									//*****************
									//COCHES ELECTRICOS
									//*****************

	/**
	 * MEtodo que lee coches electricos de la base de datos
	 * @return ArrayList de vehiculos electricos
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeCochesElectricos() throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		query = "select * "
				+ "from vehiculo ve join electrico el on ve.matricula=el.matricula"
				+ "                 join Cocheselectrico ce on ve.matricula=ce.matricula";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String matricula=rs.getString("matricula");
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			
			String codOfi=rs.getString("cod_ofi");
			Oficina oficina=RepositorioOficina.BuscaOficina(codOfi);
			
			String cod_categoria=rs.getString("cod_categoria");
			Categoria categoria = RepositorioCategorias.leeCategoria(cod_categoria);
			
			int autonomia=rs.getInt("autonomia");
			int tiemporecarga=rs.getInt("tiemporecarga");
			int numeroplazas=rs.getInt("nplazas");
			String tipo = rs.getString("tipo");
			Boolean alquilado=rs.getBoolean("alquilado");
			
			Vehiculo o = new CochesElectricos(matricula,marca,modelo,color,km,fechaadquisicion,oficina,categoria,alquilado,  
											  autonomia,tiemporecarga,numeroplazas,tipo);
			ListaVehiculo.add(o);
		}

		return ListaVehiculo;
	}
	
	/**
	 * Metodo que lee coches electricos que estan disponibles de la base de datos
	 * @return ArrayList de vehiculos electricos
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeCochesElectricosActivos() throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		query = "select * "
				+ "from vehiculo ve join electrico el on ve.matricula=el.matricula"
				+ "                 join Cocheselectrico ce on ve.matricula=ce.matricula"
				+ " where ve.alquilado=0";;

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String matricula=rs.getString("matricula");
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			
			String codOfi=rs.getString("cod_ofi");
			Oficina oficina=RepositorioOficina.BuscaOficina(codOfi);
			
			String cod_categoria=rs.getString("cod_categoria");
			Categoria categoria = RepositorioCategorias.leeCategoria(cod_categoria);
			
			int autonomia=rs.getInt("autonomia");
			int tiemporecarga=rs.getInt("tiemporecarga");
			int numeroplazas=rs.getInt("nplazas");
			String tipo = rs.getString("tipo");
			Boolean alquilado=rs.getBoolean("alquilado");
			
			Vehiculo o = new CochesElectricos(matricula,marca,modelo,color,km,fechaadquisicion,oficina,categoria,alquilado,  
											  autonomia,tiemporecarga,numeroplazas,tipo);
			ListaVehiculo.add(o);
		}

		return ListaVehiculo;
	}
	
	/**
	 * Metodo que lee coches electricos que estan alquilados de la base de datos
	 * @return ArrayList de vehiculos electricos
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeCochesElectricosAlquilados() throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		query = "select * "
				+ "from vehiculo ve join electrico el on ve.matricula=el.matricula"
				+ "                 join Cocheselectrico ce on ve.matricula=ce.matricula"
				+ " where ve.alquilado=1";;

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String matricula=rs.getString("matricula");
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			
			String codOfi=rs.getString("cod_ofi");
			Oficina oficina=RepositorioOficina.BuscaOficina(codOfi);
			
			String cod_categoria=rs.getString("cod_categoria");
			Categoria categoria = RepositorioCategorias.leeCategoria(cod_categoria);
			
			int autonomia=rs.getInt("autonomia");
			int tiemporecarga=rs.getInt("tiemporecarga");
			int numeroplazas=rs.getInt("nplazas");
			String tipo = rs.getString("tipo");
			Boolean alquilado=rs.getBoolean("alquilado");
			
			Vehiculo o = new CochesElectricos(matricula,marca,modelo,color,km,fechaadquisicion,oficina,categoria,alquilado,  
											  autonomia,tiemporecarga,numeroplazas,tipo);
			ListaVehiculo.add(o);
		}

		return ListaVehiculo;
	}
	
	/**
	 * Metodo que lee coches electricos que estan en una oficina de la base de datos
	 * @param oficina oficina a la que pertenece
	 * @return ArrayList de vehiculos electricos de esa oficina
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeCochesElectricosdeOficinaNoAlquilados(Oficina oficina) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		query = "select * "
				+ "from vehiculo ve join electrico el on ve.matricula=el.matricula"
				+ "                 join Cocheselectrico ce on ve.matricula=ce.matricula"
				+ " where ve.cod_ofi=? and alquilado=0";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1, oficina.getCodigo());
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String matricula=rs.getString("matricula");
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			String cod_categoria=rs.getString("cod_categoria");
			Categoria categoria = RepositorioCategorias.leeCategoria(cod_categoria);
			
			int autonomia=rs.getInt("autonomia");
			int tiemporecarga=rs.getInt("tiemporecarga");
			int numeroplazas=rs.getInt("nplazas");
			String tipo = rs.getString("tipo");
			Boolean alquilado=rs.getBoolean("alquilado");
			
			Vehiculo o = new CochesElectricos(matricula,marca,modelo,color,km,fechaadquisicion,oficina,categoria,  
											  alquilado,autonomia,tiemporecarga,numeroplazas,tipo);
			ListaVehiculo.add(o);
		}

		return ListaVehiculo;
	}
	
	/**
	 * Metodo que lee coches electricos que estan en una oficina de la base de datos
	 * @param oficina oficina a la que pertenece
	 * @return ArrayList de vehiculos electricos de esa oficina
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeCochesElectricosdeOficina(Oficina oficina) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		query = "select * "
				+ "from vehiculo ve join electrico el on ve.matricula=el.matricula"
				+ "                 join Cocheselectrico ce on ve.matricula=ce.matricula"
				+ " where ve.cod_ofi=?";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1, oficina.getCodigo());
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String matricula=rs.getString("matricula");
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			String cod_categoria=rs.getString("cod_categoria");
			Categoria categoria = RepositorioCategorias.leeCategoria(cod_categoria);
			
			int autonomia=rs.getInt("autonomia");
			int tiemporecarga=rs.getInt("tiemporecarga");
			int numeroplazas=rs.getInt("nplazas");
			String tipo = rs.getString("tipo");
			Boolean alquilado=rs.getBoolean("alquilado");
			
			Vehiculo o = new CochesElectricos(matricula,marca,modelo,color,km,fechaadquisicion,oficina,categoria,  
											  alquilado,autonomia,tiemporecarga,numeroplazas,tipo);
			ListaVehiculo.add(o);
		}

		return ListaVehiculo;
	}

	/**
	 * Metodo que lee coches electricos que estan en una categoria de la base de datos
	 * @param categoria categoria a la que pertenece
	 * @return ArrayList de vehiculos electricos de esa categoria
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeCochesElectricosdeCategoria(Categoria categoria) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		query = "select * "
				+ "from vehiculo ve join electrico el on ve.matricula=el.matricula"
				+ "                 join Cocheselectrico ce on ve.matricula=ce.matricula"
				+ " where ve.cod_categoria=?";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,categoria.getCodigo());
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String matricula=rs.getString("matricula");
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			
			String codOfi=rs.getString("cod_ofi");
			Oficina oficina=RepositorioOficina.BuscaOficina(codOfi);	
			int autonomia=rs.getInt("autonomia");
			int tiemporecarga=rs.getInt("tiemporecarga");
			int numeroplazas=rs.getInt("nplazas");
			String tipo = rs.getString("tipo");
			Boolean alquilado=rs.getBoolean("alquilado");
			
			Vehiculo o = new CochesElectricos(matricula,marca,modelo,color,km,fechaadquisicion,oficina,categoria,  
											  alquilado,autonomia,tiemporecarga,numeroplazas,tipo);
			ListaVehiculo.add(o);
		}

		return ListaVehiculo;
	}
	
	/**
	 * Metodo que busca un coche a partir de su matricula
	 * @param matricula 
	 * @return devuelve el coche que tiene esa matricula
	 * @throws SQLException
	 */
	public static CochesElectricos buscaCocheElectricos(String matricula) throws SQLException
	{
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		CochesElectricos c=null;
		
		query = "select * "
				+ "from vehiculo ve join electrico el on ve.matricula=el.matricula"
				+ "                 join Cocheselectrico ce on ve.matricula=ce.matricula "
				+ "where ve.matricula=?";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,matricula);
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			String codOfi=rs.getString("cod_ofi");
			Oficina oficina=RepositorioOficina.BuscaOficina(codOfi);
			String cod_categoria=rs.getString("cod_categoria");
			Categoria categoria = RepositorioCategorias.leeCategoria(cod_categoria);
			int autonomia = rs.getInt("autonomia");
			int tiemporecarga = rs.getInt("tiemporecarga");
			int plazas = rs.getInt("nplazas");
			String tipo= rs.getString("tipo");
			Boolean alquilado=rs.getBoolean("alquilado");
		
			c =new CochesElectricos(matricula, marca, modelo, color, km, fechaadquisicion, oficina, categoria,
									 alquilado,autonomia, tiemporecarga, plazas,  tipo);
		}
		return c;
	}
	
	/**
	 * Metodo que añade un coche a la base de datos
	 * @param cc coche que será añadido
	 * @throws SQLException
	 */
	public static void AñadeCochesElectrico(CochesElectricos ce) throws SQLException
	{
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		AñadeElectrico(ce);
		
		
		query = "insert into CochesElectrico (matricula, Nplazas, Tipo, PrecioBase) values (?,?,?,50)";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		
		String matricula=ce.getMatricula();
		int plazas =ce.getNplazas();
		String tipo = ce.getTipo();
		
		St.setString(1,matricula);
		St.setInt(2, plazas);
		St.setString(3,tipo);	
		
		rs = St.executeQuery();
		
		
	}
	
	/**
	 * Metodo que elimina un coche a la base de datos
	 * @param cc coche que será eliminado
	 * @throws SQLException
	 */
	public static void EliminaCocheElectrico(String matricula) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
			
		query = "DELETE FROM CochesElectrico where matricula = ?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,matricula);
		rs = St.executeQuery();
		
		EliminaElectrico(matricula);
			
	}
	
	/**
	 * Metodo que modifica un coche de la base de datos
	 * @param cc coche que será modificado
	 * @throws SQLException
	 */
	public static void ModificaCocheElectrico (CochesElectricos vehiculo) throws SQLException
	{
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		query = "Update CochesElectrico set nplazas=?, tipo=? where matricula=?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setInt(1,vehiculo.getNplazas());
		St.setString(2, vehiculo.getTipo());
		St.setString(3, vehiculo.getMatricula());
		rs = St.executeQuery();
			
		ModificaElectrico(vehiculo);
	}

	
									//*****************
									//   FURGONETAS
									//*****************	
	
	/**
	 * Metodo que lee furgonetas de la base de datos
	 * @return ArrayList de furgonetas
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeFurgonetas() throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		query = "select * "
			  + "from vehiculo ve join combustion co on ve.matricula=co.matricula"
			  + "                 join Furgoneta fu on ve.matricula=fu.matricula";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String matricula=rs.getString("matricula");
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			String codOfi=rs.getString("cod_ofi");
			Oficina oficina=RepositorioOficina.BuscaOficina(codOfi);
			String cod_categoria=rs.getString("cod_categoria");
			Categoria categoria = RepositorioCategorias.leeCategoria(cod_categoria);
			String consumo=rs.getString("consumo");
			int potencia = rs.getInt("potencia");
			String emisiones = rs.getString("nivelemisiones");
			int capacidadcarga = rs.getInt("capacidadcarga");
			String letra= rs.getString("letra");
			CarnetConducir carnetrequerido= RepositorioCarnetConducir.BuscaCarnet(letra);
			Boolean alquilado=rs.getBoolean("alquilado");
		
			Vehiculo o =new Furgonetas(matricula, marca, modelo, color, km, fechaadquisicion, oficina, categoria, 
					  				alquilado,consumo, potencia, emisiones, capacidadcarga, carnetrequerido);
			
			ListaVehiculo.add(o);
		}

		
		return ListaVehiculo;
	}
	
	/**
	 * MEtodo que lee furgonetas de la base de datos que estan disponibles
	 * @return ArrayList de furgonetas
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeFurgonetasActivas() throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		query = "select * "
			  + "from vehiculo ve join combustion co on ve.matricula=co.matricula"
			  + "                 join Furgoneta fu on ve.matricula=fu.matricula"
			  + " where ve.alquilado=0";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String matricula=rs.getString("matricula");
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			String codOfi=rs.getString("cod_ofi");
			Oficina oficina=RepositorioOficina.BuscaOficina(codOfi);
			String cod_categoria=rs.getString("cod_categoria");
			Categoria categoria = RepositorioCategorias.leeCategoria(cod_categoria);
			String consumo=rs.getString("consumo");
			int potencia = rs.getInt("potencia");
			String emisiones = rs.getString("nivelemisiones");
			int capacidadcarga = rs.getInt("capacidadcarga");
			String letra= rs.getString("letra");
			CarnetConducir carnetrequerido= RepositorioCarnetConducir.BuscaCarnet(letra);
			Boolean alquilado=rs.getBoolean("alquilado");
		
			Vehiculo o =new Furgonetas(matricula, marca, modelo, color, km, fechaadquisicion, oficina, categoria, 
					  				alquilado,consumo, potencia, emisiones, capacidadcarga, carnetrequerido);
			
			ListaVehiculo.add(o);
		}

		
		return ListaVehiculo;
	}
	
	/**
	 * MEtodo que lee furgonetas de la base de datos que estan alquiladas
	 * @return ArrayList de furgonetas
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeFurgonetasAlquiladas() throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		query = "select * "
			  + "from vehiculo ve join combustion co on ve.matricula=co.matricula"
			  + "                 join Furgoneta fu on ve.matricula=fu.matricula"
			  + " where ve.alquilado=1";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String matricula=rs.getString("matricula");
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			String codOfi=rs.getString("cod_ofi");
			Oficina oficina=RepositorioOficina.BuscaOficina(codOfi);
			String cod_categoria=rs.getString("cod_categoria");
			Categoria categoria = RepositorioCategorias.leeCategoria(cod_categoria);
			String consumo=rs.getString("consumo");
			int potencia = rs.getInt("potencia");
			String emisiones = rs.getString("nivelemisiones");
			int capacidadcarga = rs.getInt("capacidadcarga");
			String letra= rs.getString("letra");
			CarnetConducir carnetrequerido= RepositorioCarnetConducir.BuscaCarnet(letra);
			Boolean alquilado=rs.getBoolean("alquilado");
		
			Vehiculo o =new Furgonetas(matricula, marca, modelo, color, km, fechaadquisicion, oficina, categoria, 
					  				alquilado,consumo, potencia, emisiones, capacidadcarga, carnetrequerido);
			
			ListaVehiculo.add(o);
		}

		
		return ListaVehiculo;
	}
		
	/**
	 * MEtodo que lee furgonetas de la base de datos de una categoria
	 * @param categoria categoria a la que pertenecen
	 * @return ArrayList de furgonetas
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeFurgonetasdeCategoria(Categoria categoria) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		query = "select * "
			  + "from vehiculo ve join combustion co on ve.matricula=co.matricula"
			  + "                 join Furgoneta fu on ve.matricula=fu.matricula"
			  + " where ve.cod_categoria=?";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1, categoria.getCodigo());
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String matricula=rs.getString("matricula");
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			String codOfi=rs.getString("cod_ofi");
			Oficina oficina=RepositorioOficina.BuscaOficina(codOfi);
			String consumo=rs.getString("consumo");
			int potencia = rs.getInt("potencia");
			String emisiones = rs.getString("nivelemisiones");
			int capacidadcarga = rs.getInt("capacidadcarga");
			String letra= rs.getString("letra");
			CarnetConducir carnetrequerido= RepositorioCarnetConducir.BuscaCarnet(letra);
			Boolean alquilado=rs.getBoolean("alquilado");
		
			Vehiculo o =new Furgonetas(matricula, marca, modelo, color, km, fechaadquisicion, oficina, categoria, 
					  				   alquilado,consumo, potencia, emisiones, capacidadcarga, carnetrequerido);
			
			ListaVehiculo.add(o);
		}

		
		return ListaVehiculo;
	}

	/**
	 * Metodo que lee furgonetas de la base de datos de una oficina
	 * @param oficina oficina a la que pertenecen
	 * @return ArrayList de furgonetas
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeFurgonetasdeOficinaNoAlquilados(Oficina oficina) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		query = "select * "
			  + "from vehiculo ve join combustion co on ve.matricula=co.matricula"
			  + "                 join Furgoneta fu on ve.matricula=fu.matricula"
			  + " where ve.cod_ofi=? and alquilado=0";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1, oficina.getCodigo());
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String matricula=rs.getString("matricula");
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			String cod_categoria=rs.getString("cod_categoria");
			Categoria categoria = RepositorioCategorias.leeCategoria(cod_categoria);
			String consumo=rs.getString("consumo");
			int potencia = rs.getInt("potencia");
			String emisiones = rs.getString("nivelemisiones");
			int capacidadcarga = rs.getInt("capacidadcarga");
			String letra= rs.getString("letra");
			CarnetConducir carnetrequerido= RepositorioCarnetConducir.BuscaCarnet(letra);
			Boolean alquilado=rs.getBoolean("alquilado");
		
			Vehiculo o =new Furgonetas(matricula, marca, modelo, color, km, fechaadquisicion, oficina, categoria, 
					  				   alquilado,consumo, potencia, emisiones, capacidadcarga, carnetrequerido);
			
			ListaVehiculo.add(o);
		}

		
		return ListaVehiculo;
	}
	
	/**
	 * Metodo que lee furgonetas de la base de datos de una oficina
	 * @param oficina oficina a la que pertenecen
	 * @return ArrayList de furgonetas
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeFurgonetasdeOficina(Oficina oficina) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		query = "select * "
			  + "from vehiculo ve join combustion co on ve.matricula=co.matricula"
			  + "                 join Furgoneta fu on ve.matricula=fu.matricula"
			  + " where ve.cod_ofi=?";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1, oficina.getCodigo());
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String matricula=rs.getString("matricula");
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			String cod_categoria=rs.getString("cod_categoria");
			Categoria categoria = RepositorioCategorias.leeCategoria(cod_categoria);
			String consumo=rs.getString("consumo");
			int potencia = rs.getInt("potencia");
			String emisiones = rs.getString("nivelemisiones");
			int capacidadcarga = rs.getInt("capacidadcarga");
			String letra= rs.getString("letra");
			CarnetConducir carnetrequerido= RepositorioCarnetConducir.BuscaCarnet(letra);
			Boolean alquilado=rs.getBoolean("alquilado");
		
			Vehiculo o =new Furgonetas(matricula, marca, modelo, color, km, fechaadquisicion, oficina, categoria, 
					  				   alquilado,consumo, potencia, emisiones, capacidadcarga, carnetrequerido);
			
			ListaVehiculo.add(o);
		}

		
		return ListaVehiculo;
	}
	
	/**
	 * Metodo que busca una furgoneta a partir de su matricula
	 * @param matricula 
	 * @return devuelve la furgoneta que tiene esa matricula
	 * @throws SQLException
	 */
	public static Furgonetas buscaFurgonetas(String matricula) throws SQLException
	{
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		Furgonetas c=null;
		
		query = "select * "
				+ "from vehiculo ve join combustion co on ve.matricula=co.matricula"
				+ "                 join furgoneta fu on ve.matricula=fu.matricula"
				+ " where ve.matricula=?";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,matricula);
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			String codOfi=rs.getString("cod_ofi");
			Oficina oficina=RepositorioOficina.BuscaOficina(codOfi);
			String cod_categoria=rs.getString("cod_categoria");
			Categoria categoria = RepositorioCategorias.leeCategoria(cod_categoria);
			String consumo=rs.getString("consumo");
			int potencia = rs.getInt("potencia");
			String emisiones = rs.getString("nivelemisiones");
			int capacidadcarga = rs.getInt("capacidadcarga");
			String letra= rs.getString("letra");
			CarnetConducir carnetrequerido= RepositorioCarnetConducir.BuscaCarnet(letra);
			Boolean alquilado=rs.getBoolean("alquilado");
		
			c =new Furgonetas(matricula, marca, modelo, color, km, fechaadquisicion, oficina, categoria, 
					  			alquilado,consumo, potencia, emisiones, capacidadcarga, carnetrequerido);
		}
		return c;
	}
	
	/**
	 * MEtodo que añade una furgoneta a la base de datos
	 * @param fu furgoneta que añade 
	 * @throws SQLException
	 */
	public static void AñadeFurgonetas(Furgonetas fu) throws SQLException
	{
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		AñadeCombustion(fu);
		
		query = "insert into Furgoneta (matricula, CapacidadCarga, letra,PrecioBase) values (?,?,?,0)";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,fu.getMatricula());
		St.setInt(2, fu.getCapacidadCarga());
		St.setString(3,fu.getCarnetRequerido().getLetra());

		
		rs = St.executeQuery();
	}
		
	/**
	 * Metodo que elimina una furgoneta
	 * @param matricula 
	 * @throws SQLException
	 */
	public static void EliminaFurgonetas(String matricula) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
			
		query = "DELETE FROM Furgoneta where matricula = ?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,matricula);
		rs = St.executeQuery();
		
		EliminaCombustion(matricula);
			
	}
	
	/**
	 * Metodo que modific ana furgoneta
	 * @param vehiculo
	 * @throws SQLException
	 */
	public static void ModificaFurgonetas (Furgonetas vehiculo) throws SQLException
	{
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		query = "Update Furgoneta set capacidadcarga=?, letra=? where matricula=?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setInt(1,vehiculo.getCapacidadCarga());
		St.setString(2, vehiculo.getCarnetRequerido().getLetra());
		St.setString(3, vehiculo.getMatricula());
		rs = St.executeQuery();
			
		ModificaCombustion(vehiculo);
	}
	
									//*****************
									//	MOTOCICLETAS
									//*****************				
	
	/**
	 * Metodo que lee motos de la base de datos
	 * @return ArrayList de motos
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeMotos() throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		query = "select * "
				+ "from vehiculo ve join electrico el on ve.matricula=el.matricula"
				+ "                 join Motocicleta mo on ve.matricula=mo.matricula";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String matricula=rs.getString("matricula");
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			

			String codOfi=rs.getString("cod_ofi");
			Oficina oficina=RepositorioOficina.BuscaOficina(codOfi);
			String cod_categoria=rs.getString("cod_categoria");
			Categoria categoria = RepositorioCategorias.leeCategoria(cod_categoria);
			
			
			int autonomia = rs.getInt("autonomia");
			int tiemporecarga = rs.getInt("tiemporecarga");
			int cilindrada = rs.getInt("cilindrada");
			String letra=rs.getString("letra");
			CarnetConducir carnetrequerido=RepositorioCarnetConducir.BuscaCarnet(letra);
			Boolean alquilado=rs.getBoolean("alquilado");
			
			Motocicletas o = new Motocicletas(matricula,  marca,modelo,color,km,fechaadquisicion,oficina,categoria,
					                          alquilado, autonomia,tiemporecarga,cilindrada,carnetrequerido );
			ListaVehiculo.add(o);
		}

		
		return ListaVehiculo;
	}
	
	/**
	 * Metodo que lee motos de la base de datos que estan disponibles
	 * @return ArrayList de motos
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeMotosActivos() throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		query = "select * "
				+ "from vehiculo ve join electrico el on ve.matricula=el.matricula"
				+ "                 join Motocicleta mo on ve.matricula=mo.matricula"
				+ " where ve.alquilado=0";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String matricula=rs.getString("matricula");
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			

			String codOfi=rs.getString("cod_ofi");
			Oficina oficina=RepositorioOficina.BuscaOficina(codOfi);
			String cod_categoria=rs.getString("cod_categoria");
			Categoria categoria = RepositorioCategorias.leeCategoria(cod_categoria);
			
			
			int autonomia = rs.getInt("autonomia");
			int tiemporecarga = rs.getInt("tiemporecarga");
			int cilindrada = rs.getInt("cilindrada");
			String letra=rs.getString("letra");
			CarnetConducir carnetrequerido=RepositorioCarnetConducir.BuscaCarnet(letra);
			Boolean alquilado=rs.getBoolean("alquilado");
			
			Motocicletas o = new Motocicletas(matricula,  marca,modelo,color,km,fechaadquisicion,oficina,categoria,
					                          alquilado, autonomia,tiemporecarga,cilindrada,carnetrequerido );
			ListaVehiculo.add(o);
		}

		
		return ListaVehiculo;
	}
	
	/**
	 * Metodo que lee motos de la base de datos que estan alquiladas
	 * @return ArrayList de motos
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeMotosAlquiladas() throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		query = "select * "
				+ "from vehiculo ve join electrico el on ve.matricula=el.matricula"
				+ "                 join Motocicleta mo on ve.matricula=mo.matricula"
				+ " where ve.alquilado=1";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String matricula=rs.getString("matricula");
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			

			String codOfi=rs.getString("cod_ofi");
			Oficina oficina=RepositorioOficina.BuscaOficina(codOfi);
			String cod_categoria=rs.getString("cod_categoria");
			Categoria categoria = RepositorioCategorias.leeCategoria(cod_categoria);
			
			
			int autonomia = rs.getInt("autonomia");
			int tiemporecarga = rs.getInt("tiemporecarga");
			int cilindrada = rs.getInt("cilindrada");
			String letra=rs.getString("letra");
			CarnetConducir carnetrequerido=RepositorioCarnetConducir.BuscaCarnet(letra);
			Boolean alquilado=rs.getBoolean("alquilado");
			
			Motocicletas o = new Motocicletas(matricula,  marca,modelo,color,km,fechaadquisicion,oficina,categoria,
					                          alquilado, autonomia,tiemporecarga,cilindrada,carnetrequerido );
			ListaVehiculo.add(o);
		}

		
		return ListaVehiculo;
	}
	
	/**
	 * Metodo que lee motos de la base de datos de una categoria
	 * @param categoria categoria a la que pertenecen
	 * @return ArrayList de motos
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeMotosdeCategoria(Categoria categoria) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		query = "select * "
				+ "from vehiculo ve join electrico el on ve.matricula=el.matricula"
				+ "                 join Motocicleta mo on ve.matricula=mo.matricula"
				+ " where ve.cod_categoria=?";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1, categoria.getCodigo());
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String matricula=rs.getString("matricula");
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			

			String codOfi=rs.getString("cod_ofi");
			Oficina oficina=RepositorioOficina.BuscaOficina(codOfi);
			
			int autonomia = rs.getInt("autonomia");
			int tiemporecarga = rs.getInt("tiemporecarga");
			int cilindrada = rs.getInt("cilindrada");
			String letra=rs.getString("letra");
			CarnetConducir carnetrequerido=RepositorioCarnetConducir.BuscaCarnet(letra);
			Boolean alquilado=rs.getBoolean("alquilado");
			
			Motocicletas o = new Motocicletas(matricula,  marca,modelo,color,km,fechaadquisicion,oficina,categoria,
					                          alquilado,autonomia,tiemporecarga,cilindrada,carnetrequerido );
			ListaVehiculo.add(o);
		}

		
		return ListaVehiculo;
	}
	
	/**
	 * Metodo que lee motos de la base de datos de una oficina
	 * @param oficina oficina a la que pertenecen
	 * @return ArrayList de motos
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeMotosdeOficinaNoAlquilados(Oficina oficina) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		query = "select * "
				+ "from vehiculo ve join electrico el on ve.matricula=el.matricula"
				+ "                 join Motocicleta mo on ve.matricula=mo.matricula"
				+ " where ve.cod_ofi=? and alquilado=0";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1, oficina.getCodigo());
		rs = St.executeQuery(query);
		
		while (rs.next()) 
		{
			String matricula=rs.getString("matricula");
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			

			String cod_categoria=rs.getString("cod_categoria");
			Categoria categoria = RepositorioCategorias.leeCategoria(cod_categoria);
			
			int autonomia = rs.getInt("autonomia");
			int tiemporecarga = rs.getInt("tiemporecarga");
			int cilindrada = rs.getInt("cilindrada");
			String letra=rs.getString("letra");
			CarnetConducir carnetrequerido=RepositorioCarnetConducir.BuscaCarnet(letra);
			Boolean alquilado=rs.getBoolean("alquilado");
			
			Motocicletas o = new Motocicletas(matricula,  marca,modelo,color,km,fechaadquisicion,oficina,categoria,
					                          alquilado,autonomia,tiemporecarga,cilindrada,carnetrequerido );
			ListaVehiculo.add(o);
		}

		
		return ListaVehiculo;
	}
	
	/**
	 * Metodo que lee motos de la base de datos de una oficina
	 * @param oficina oficina a la que pertenecen
	 * @return ArrayList de motos
	 * @throws SQLException
	 */
	public static ArrayList<Vehiculo> leeMotosdeOficina(Oficina oficina) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		
		ArrayList<Vehiculo> ListaVehiculo = new ArrayList<Vehiculo>();
		
		query = "select * "
				+ "from vehiculo ve join electrico el on ve.matricula=el.matricula"
				+ "                 join Motocicleta mo on ve.matricula=mo.matricula"
				+ " where ve.cod_ofi=?";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1, oficina.getCodigo());
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String matricula=rs.getString("matricula");
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			

			String cod_categoria=rs.getString("cod_categoria");
			Categoria categoria = RepositorioCategorias.leeCategoria(cod_categoria);
			
			int autonomia = rs.getInt("autonomia");
			int tiemporecarga = rs.getInt("tiemporecarga");
			int cilindrada = rs.getInt("cilindrada");
			String letra=rs.getString("letra");
			CarnetConducir carnetrequerido=RepositorioCarnetConducir.BuscaCarnet(letra);
			Boolean alquilado=rs.getBoolean("alquilado");
			
			Motocicletas o = new Motocicletas(matricula,  marca,modelo,color,km,fechaadquisicion,oficina,categoria,
					                          alquilado,autonomia,tiemporecarga,cilindrada,carnetrequerido );
			ListaVehiculo.add(o);
		}

		
		return ListaVehiculo;
	}
	
	/**
	 * Metodo que busca una moto a partir de su matricula
	 * @param matricula
	 * @return ArrayList de motos
	 * @throws SQLException
	 */
	public static Motocicletas buscaMotos(String matricula) throws SQLException
	{
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		Motocicletas c=null;
		
		query = "select * "
				+ "from vehiculo ve join electrico el on ve.matricula=el.matricula"
				+ "                 join motocicleta mo on ve.matricula=mo.matricula"
				+ " where ve.matricula=?";

		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,matricula);
		rs = St.executeQuery();
		
		while (rs.next()) 
		{
			String marca=rs.getString("marca");;
			String modelo=rs.getString("modelo");
			String color=rs.getString("color");
			int km=rs.getInt("km");
			
			Date fecha=rs.getDate("fechaadquisicion");
			GregorianCalendar fechaadquisicion=new GregorianCalendar((fecha.getYear()+1900), fecha.getMonth(), fecha.getDate());
			
			String codOfi=rs.getString("cod_ofi");
			Oficina oficina=RepositorioOficina.BuscaOficina(codOfi);
			String cod_categoria=rs.getString("cod_categoria");
			Categoria categoria = RepositorioCategorias.leeCategoria(cod_categoria);
			
			int autonomia = rs.getInt("autonomia");
			int tiemporecarga = rs.getInt("tiemporecarga");
			int cilindrada = rs.getInt("cilindrada");
			String letra=rs.getString("letra");
			CarnetConducir carnetrequerido=RepositorioCarnetConducir.BuscaCarnet(letra);
			Boolean alquilado=rs.getBoolean("alquilado");
			
		
			c = new Motocicletas(matricula,  marca,modelo,color,km,fechaadquisicion,oficina,categoria,
                                 alquilado,autonomia,tiemporecarga,cilindrada,carnetrequerido );
		}
		return c;
	}
	
	/**
	 * Metodo que añade una moto a la base de datos
	 * @param mo
	 * @throws SQLException
	 */
	public static void AñadeMotocicletas(Motocicletas mo) throws SQLException
	{
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		AñadeElectrico(mo);
		
		
		query = "insert into motocicleta (matricula, cilindrada, letra ,PrecioBase) values (?,?,?,10)";
		St = AccesoADatos.dbconexion.prepareStatement(query); 

		
		St.setString(1,mo.getMatricula());
		St.setInt(2, mo.getCilindrada());
		St.setString(3,mo.getCarnetRequerido().getLetra());	
		
		rs = St.executeQuery();
		
		
	}
	
	/**
	 * MEtodo que elimina una moto de la base de datos
	 * @param matricula
	 * @throws SQLException
	 */
	public static void EliminaMotocicletas(String matricula) throws SQLException
	{
		
		PreparedStatement St;
		ResultSet rs;
		String query;
			
		query = "DELETE FROM motocicleta where matricula = ?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setString(1,matricula);
		rs = St.executeQuery();
		
		EliminaElectrico(matricula);
			
	}
	
	/**
	 * Metodo que modifica motos de la base de datos
	 * @param vehiculo
	 * @throws SQLException
	 */
	public static void ModificaMotocicletas (Motocicletas vehiculo) throws SQLException
	{
		PreparedStatement St;
		ResultSet rs;
		String query;
		
		query = "Update Motocicleta set cilindrada=?, letra=? where matricula=?";
		St = AccesoADatos.dbconexion.prepareStatement(query); 
		St.setInt(1,vehiculo.getCilindrada());
		St.setString(2, vehiculo.getCarnetRequerido().getLetra());
		St.setString(3, vehiculo.getMatricula());
		rs = St.executeQuery();
			
		ModificaElectrico(vehiculo);
	}
}
