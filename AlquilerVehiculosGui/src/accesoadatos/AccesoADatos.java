package accesoadatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class AccesoADatos {

	public static Connection AbreConexion()
	{
		Connection conexion = null;
		try 
		{
			conexion=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Fernando","Fernando");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conexion;
	}
	

}
