package principal;

import java.sql.SQLException;

import accesoadatos.AccesoADatos;
import excepciones.LongitudInvalidaException;
import gui.BuscaEmpleados;
import gui.Metodos_Gui;
import gui.Ventana_Principal;

public class Principal {

	public Principal() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws SQLException, LongitudInvalidaException {
		// TODO Auto-generated method stub

		AccesoADatos.AbreConexion();
		
		Ventana_Principal frame = new Ventana_Principal();
		gui.Metodos_Gui.CentraVentana(frame);
		frame.setVisible(true);

//		
//		BuscaEmpleados frame = new BuscaEmpleados();
//		gui.Metodos_Gui.CentraVentana(frame);
//		frame.setVisible(true);
		
	}

}
