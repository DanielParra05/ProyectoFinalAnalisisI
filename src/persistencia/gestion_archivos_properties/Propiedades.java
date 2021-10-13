package persistencia.gestion_archivos_properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

public class Propiedades {

	private ArrayList<String> propiedades = new ArrayList<>();
	private Properties prop;
	private File f;
	private String genero;

	public Propiedades(String genero) {
		this.genero = genero;
	}

	/**
	 * Obtiene una propiedad segun su clave
	 * @param clave
	 * @return
	 */
	public String getPropiedad(String clave) {
		Properties propiedades = new Properties();
		InputStream entrada = null;

		try {
			entrada = new FileInputStream("src/archivosProperties/probabilidades" + genero + ".properties");
			propiedades.load(entrada);
			return propiedades.getProperty(clave);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/**
	 * Actualiza una propiedad con un nuevo valor
	 * @param clave propiedad a las que se le cambiara el valor
	 * @param valor nuevo
	 */
	public void actPropiedad(String clave, String valor) {
		prop = new Properties();
		try {
			f = new File("src/archivosProperties/probabilidades" + genero + ".properties");
			prop.load(new FileInputStream(f));
			for (Enumeration i = prop.keys(); i.hasMoreElements();) {
				Object obj = i.nextElement();
				propiedades.add("" + obj);
				propiedades.add(prop.getProperty(obj.toString()));
			}
			escribirPropiedad(clave, valor);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Escribe una propiedad
	 * @param clave nombre de la prpiedad
	 * @param valor asignacion para la porpiedad
	 */
	private void escribirPropiedad(String clave, String valor) {
		if (prop.containsKey(clave)) {
			if (prop != null) {
				prop.setProperty(clave, valor);
				propiedades.set(propiedades.indexOf(clave) + 1, valor);
			}
		} else {
			prop.put(clave, valor);
			propiedades.add(clave);
			propiedades.add(valor);
		}
		FileOutputStream salida;
		try {
			salida = new FileOutputStream(f);
			prop.save(salida, "Configuración probabilidades de los géneros.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
