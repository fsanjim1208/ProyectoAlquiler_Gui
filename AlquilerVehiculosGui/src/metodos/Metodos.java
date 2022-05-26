package metodos;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import accesoadatos.RepositorioAlquileres;
import excepciones.LongitudInvalidaException;

public class Metodos {

	/**
	 * Metodo que pasa un Date a un GregorianCalendar 
	 * @param fecha
	 * @return  GregorianCalendar 
	 */
	public static GregorianCalendar PasaDateaGregorianCalendar (Date fecha)
	{

		
		DateFormat f=new SimpleDateFormat("dd-MM-yyyy");
		String fecha3=f.format(fecha);
		
		String[] fechArray = fecha3.split("-");

		int dia = Integer.valueOf(fechArray[0]);
		int mes = Integer.valueOf(fechArray[1]) - 1;
		int anio = Integer.valueOf(fechArray[2]);


		Calendar fecha2 = new GregorianCalendar(anio, mes, dia);
		
		
		
		return (GregorianCalendar) fecha2;
	}
	
	/**
	 *  Metodo que convierte un GregorianCalendar a String 
	 * @param fecha
	 * @return String 
	 */
	public static String ConvierteGregorianCalendaraString(GregorianCalendar fecha)
	{
		String fecha2=fecha.getTime().getDate()+"/"+(fecha.getTime().getMonth()+1)+"/"+(fecha.getTime().getYear()+1900);
		return fecha2;
	}
	
	/**
	 *  Metodo que convierte un GregorianCalendar a date  
	 * @param fecha
	 * @return
	 */
	public static Date ConvierteGregorianCalendaraDate (GregorianCalendar fecha)
	{
		
		String fecha2 = ConvierteGregorianCalendaraString(fecha);
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	    
		Date fechaDate=null;
		
		try {
			fechaDate = formato.parse(fecha2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fechaDate;
	}
	
	/**
	 * metodo que calcula el codigo del alquiler
	 * @return
	 * @throws SQLException
	 * @throws LongitudInvalidaException
	 */
	public static String CalculaCodigoAlquiler() throws SQLException, LongitudInvalidaException
	{
		ArrayList listaAlquileres= RepositorioAlquileres.leeAlquileresBasedeDatos();
		int numero=listaAlquileres.size()+1;
		String codigo="";
		if (numero<=9)
		{
			codigo="AL0"+numero;
		}
		else
		{
			codigo="AL"+numero;
		}
		
	
		return codigo;
	}
	
	
	
	
	
}
