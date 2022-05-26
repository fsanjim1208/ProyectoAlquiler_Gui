package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class Metodos_Gui {

	/**
	 * MEtodo que centra la ventana de un JFrame
	 * @param v
	 */
	public static void CentraVentana(JFrame v) 
	{
		//leems el tamaño de la pantalla donde se ejecuta el programa
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		//ajustamos el tamaño del Jframe para que salga centrado
		v.setLocation(dim.width/2-v.getSize().width/2, dim.height/2-v.getSize().height/2);
	}
	
	/**
	 * MEtodo que centra la ventana de un JDialog
	 * @param v
	 */
	public static void CentraVentana(JDialog v) 
	{
		//leems el tamaño de la pantalla donde se ejecuta el programa
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		//ajustamos el tamaño del Jframe para que salga centrado
		v.setLocation(dim.width/2-v.getSize().width/2, dim.height/2-v.getSize().height/2);
	}
	
	/**
	 * MEtodo que maximiza la ventana de un JFrame
	 * @param v
	 */
	public static void Tamañomaximo(JFrame v) 
	{
		//leems el tamaño de la pantalla donde se ejecutga el programa
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		//ajustamos el tamaño del Jframe para que salga centrado
		v.setSize(dim);
	}

	/**
	 * MEtodo que maximiza la ventana de un JDialog
	 * @param v
	 */
	public static void Tamañomaximo(JDialog v) 
	{
		//leems el tamaño de la pantalla donde se ejecutga el programa
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		//ajustamos el tamaño del Jframe para que salga centrado
		v.setSize(dim);
	}
}
