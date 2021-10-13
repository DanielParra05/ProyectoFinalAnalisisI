package aplicacion;

import ui.Cargando;
import ui.GenerarCancionUi;

/**
 * Clase principal del generador
 * 
 * @author Daniel Parra - Carlos Munoz - Daniel Beltran
 *
 */
public class Main {

	public static void main(String args[]) {
		Cargando cargando = new Cargando();
		cargando.setVisible(true);

		try{
			Thread.sleep(1000);
			
		}catch(Exception e){
			System.out.println(e);
		}

		cargando.setVisible(false);
		GenerarCancionUi frame = new GenerarCancionUi();
		frame.setVisible(true);

	}
}
