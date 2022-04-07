package principal;

import gui.Metodos_Gui;
import gui.Ventana_Principal;

public class Principal {

	public Principal() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ventana_Principal frame = new Ventana_Principal();
		gui.Metodos_Gui.CentraVentana(frame);
		frame.setVisible(true);
		
		
	}

}
