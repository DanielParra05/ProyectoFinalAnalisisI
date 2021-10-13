package persistencia.gestion_archivos_txt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerArchivo {

	private File archivo;
	private Scanner miSc;

	public LeerArchivo(String ruta) {
		archivo = new File(ruta + ".txt");

		try {
			miSc = new Scanner(archivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String leerArchivo() {
		String cancion = "";
		while (miSc.hasNextLine()) {
			String aux = miSc.nextLine().toLowerCase();
			cancion += aux;
			cancion += "\n";
		}
		miSc.close();

		return cancion;
	}
}
