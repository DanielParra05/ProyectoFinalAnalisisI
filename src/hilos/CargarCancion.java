package hilos;

import java.util.ArrayList;

import persistencia.gestion_archivos_txt.LeerArchivo;

public class CargarCancion {

	private ArrayList<String> lineascancion;


	private String cancion;
	private double[][] matrizFrec;
	private char letras[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q',
			'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ',', '.', ' ' };
	private LeerArchivo leerArc;
	private int numeroDeLetrasDeCancion = 0;
	private String nombreCancion;
	private String ruta;

	public CargarCancion(String nombreGenCargar, String nombreCancion) {
		this.nombreCancion = nombreCancion.replace(".txt", "");
		ruta = "src/banco_canciones/" + nombreGenCargar + "/" + this.nombreCancion;
		leerArc = new LeerArchivo(ruta);
		lineascancion = new ArrayList<>();
		cancion = "";
		matrizFrec = new double[30][30];
	}

	/**
	 * Conteo de letras anteriores a cada una
	 */
	public void generarMatrizDeFrecuencia() {
		for (int i = 0; i < letras.length; i++) {
			for (int j = cancion.length() - 1; j > 0; j--) {
				if (letras[i] == cancion.charAt(j)) {

					if (letras[i] == cancion.charAt(j)) {
						if ((cancion.charAt(j - 1) - 97) < 0 || cancion.charAt(j - 1) == 241) {
							matrizFrec[i][posicionEnMatriz(cancion.charAt(j - 1))] += 1;
						} else {
							try {
								matrizFrec[i][cancion.charAt(j - 1) - 97] += 1;
							} catch (Exception e) {
								e.printStackTrace();
								System.out.println(nombreCancion + "  " + (int) cancion.charAt(j - 1));
							}
						}
					}
				}
			}
		}
	}

	/**
	 * posicion en el arreglo de un punto, espacio o coma
	 * 
	 * @param n numero ascii del caracter
	 * @return posicion del caracter en el arreglo letras
	 */
	public static int posicionEnMatriz(int n) {

		if (n == 46) { // si es punto
			return 28;
		} else if (n == 44) { // si es coma
			return 27;
		} else if (n == 241) { // si es ñ
			return 14;
		} else {
			return 29; // Espacio
		}

	}

	/**
	 * Cargar el archivo de la correspondiente cancion a un arrayList
	 */
	public void llenarArrayList() {

		String cancion = leerArc.leerArchivo();
		String lineas[] = cancion.split("\n");
		for (int i = 0; i < lineas.length; i++) {
			
			lineascancion.add(lineas[i]);
			this.cancion += lineas[i];
		}
		numeroDeLetrasDeCancion = cancion.length();
		cancion = cancion.replace("\n", "");
		cancion = cancion.replaceAll(" ", "");
	}

	public int getNumeroDeLetrasDeCancion() {
		return numeroDeLetrasDeCancion;
	}

	public double[][] getMatrizFrec() {
		return matrizFrec;
	}
	public ArrayList<String> getLineascancion() {
		return lineascancion;
	}

}
