package logica;

import persistencia.gestion_archivos_properties.Propiedades;
import ui.Cargando;
import ui.GenerarCancionUi;
import ui.VectorDeNumeros;

public class GenerarCancion {

	private Propiedades propiedades;
	private VectorDeNumeros vectorNumeros;
	private char letraQueMasRepite;
	private char letraInicial;
	private double[] vectorProbabilidadAleatorio;
	private char[] vectorDeCaracteres;
	private int[] numeroDeVecesLetras;
	private Cargando cargar;
	private GenerarCancionUi generar;
	private String clavePropGenero[] = { "Bachata", "Balada", "Merengue", "Pop", "Ranchero", "Reggaeton", "Rock", "Salsa", "Vallenato" };

	private char letras[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q',
			'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ',', '.', ' '};
	private DivideYVenceras divide;

	public GenerarCancion(GenerarCancionUi generar, VectorDeNumeros vectorNumeros) {
		vectorProbabilidadAleatorio = new double[1500];
		this.vectorNumeros = vectorNumeros;
		numeroDeVecesLetras = new int[30];
		vectorDeCaracteres = new char[1500];
		this.generar = generar;
		asignarLetraInicial();
	}
	
	/**
	 * Asigna la letra inicial a la cancion generada
	 */
	public void asignarLetraInicial(){
		
		letraInicial = generar.getLetra();
		vectorDeCaracteres[0] = letraInicial;
	}

	/**
	 * Guarda las probabilidades nuevas en el archivo porperties
	 * @param probabilidades
	 * @param genero
	 */
	public void guardarProbabilidades(double[] probabilidades, String genero) {
		propiedades = new Propiedades(genero);
		for (int i = 0; i < probabilidades.length; i++) {
			propiedades.actPropiedad(clavePropGenero[i], Double.toString(probabilidades[i]));
		}

	}

	/**
	 * Obtiene el arreglo de probabilidades de un genero
	 * @param genero  genero para el cual se cargaran las probabilidades
	 * @return arreglo con las porbabilidades segun el genero seleccionado
	 */
	public String[] cargarProbabilidades(String genero) {
		propiedades = new Propiedades(genero);
		String[] probabilidades = new String[9];

		for (int i = 0; i < probabilidades.length; i++) {
			probabilidades[i] = propiedades.getPropiedad(clavePropGenero[i]);

		}
		
		return probabilidades;
	}

	/**
	 * Confirma si las porbabilidades ingresadas son correctas
	 * @param probabilidades probabilidades ingresadas
	 * @return true si las propiedades estan correctas
	 */
	public boolean probabilidadesCorrectas(double[] probabilidad) {
		double acum = 0.0;
		for (int i = 0; i < probabilidad.length; i++) {
			acum += probabilidad[i];
		}
		
		return (acum >= 0.99 && acum <= 1);

	}

	/**
	 * Comienza el divide y venceras con las porbabilidsdes seleccionadas
	 * @param probabilidadGenero
	 */
	public void metodoGenerador(double probabilidadGenero[]) {
		divide = new DivideYVenceras(new String[0], 1, new double[30][30], "", new double[30][30], probabilidadGenero);
		try {
			divide.join();
		} catch (Exception e) {
			System.out.println(e);
		}finally{
			
		}
		System.out.println("Matriz acumulada, generada con exito!");
		vectorAleatorio();
		}

	/**
	 * Genera el vector aleatorio de probabilidades
	 */
	public void vectorAleatorio() {

		char actual;
		double probabilidad = 0;

		for (int i = 0; i < vectorProbabilidadAleatorio.length; i++) {
			vectorProbabilidadAleatorio[i] = Math.random();
			probabilidad = vectorProbabilidadAleatorio[i];
			actual = vectorDeCaracteres[i];
			for (int j = 0; j < divide.getMatrizGeneralDeTransicion()[0].length; j++) {
				// System.out.println(posicionCaracter(actual)+" "+j);
				if (divide.getMatrizGeneralDeTransicion()[posicionCaracter(actual)][j] >= probabilidad) {

					if (i != vectorProbabilidadAleatorio.length - 1) {
						vectorDeCaracteres[i + 1] = letras[j];
						numeroDeVecesLetras[j] += 1;
					}
					break;
				}

			}
		}

		vectorNumeros.actualizarLista(vectorProbabilidadAleatorio);
		
	}

	/**
	 * Obtiene la posicion de un caracter en el arreglo letras
	 * @param a caracter a obtener posicion
	 * @return
	 */
	public int posicionCaracter(char a) {
		for (int i = 0; i < letras.length; i++) {
			if (letras[i] == a) {
				return i;
			}
		}

		return 29;

	}

	/**
	 * Obtiene la cancion generada
	 * @return cancion generada
	 */
	public String obtenerCancionGenerada() {
		String cancion = "";

		for (int i = 0; i < vectorDeCaracteres.length; i++) {
			if (i != 0 && i % 83 == 0) {
				cancion += '\n';
			}
			cancion += vectorDeCaracteres[i];
		}
		letraQueMasRepite = letraMasRepetida();
		return cancion;
	}

	/**
	 * retorna la letra mas repetida de toda la cancion
	 * @return
	 */
	public char letraMasRepetida() {
		int iNumeroMayor, iPosicion;
		iNumeroMayor = numeroDeVecesLetras[0];
		iPosicion = 0;
		for (int x = 1; x < numeroDeVecesLetras.length; x++) {
			if (numeroDeVecesLetras[x] > iNumeroMayor) {
				iPosicion = x;
				iNumeroMayor = numeroDeVecesLetras[x];
			}
		}
		return letras[iPosicion];

	}

	public char getLetraQueMasRepite() {
		return letraQueMasRepite;
	}
	
}
