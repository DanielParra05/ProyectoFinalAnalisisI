package logica;

import hilos.CargarCancion;

/**
 * @author Daniel Parra
 *
 */
public class DivideYVenceras extends Thread {

	private String cancionesGenero[] = {
			"7 dias romeo@Bachata en fukuoka@corazon sin cara prince royce@darte un beso prince royce@elperdedor(aventura)@enseñame a olvidar romeo@frio,frio@hilito@incondicional@infieles romeo@me duele la cabeza el torito@me emborrachare@necio romeo@Por un beso@por un segundo@promise romeo@se busca un corazon@su veneno romeo@un beso@you romeo",
			"40 y 20 - Jose Jose@A donde va el amor - Ricardo Montaner@A medio vivir - Ricky martin@Amada amante - Roberto carlo@Amnesia - Jose jose@Amor, como he de vivir sin ti - Alejandro fernandez@ay! amor - Miriam hernandez@bajo el agua@Barquito de papel - Joan manuel serrat@Bendita tu luz - mana y Juan Luiz Guerra@coleccionista de canciones@Como dueles en los labios - mana@desde lejos@dia tras dia@en tus zapatos@lo mejor que hay en mi vida@me voy@mi historia entre tus dedos@no es necesidad@todo cambio",
			"abusadora@alegre triste@buscando tus besos@cama y mesa@dejate querer@demasiado niña@el africano@esa morena@feo y flaco@frio, frio@juana la cubana@la flaca@la quiero a morir@las avispas@llore y llore@mala mujer@no hay pesos para contar@rompecintura@suavemente@volvere",
			"angel@antologia@desde lejos@dicen@ecos de amor@hoyyamevoy@luna@mientes@que me alcance la vida@sabes@si tu me miras@SinTi@sipudiera@solo dejate amar@tanto@te soñe@te voy a amar@tengo ganas@una y otra vez@yo quisiera",
			"aca entre nos- vicente fernandez@borracho@caballo de patas blancas- antonio aguilar@copa_tras_copa@directo al corazon- pepe aguilar@el rey - vicente fernandez@el_hijo_desobediente@gabino_barrera@juan_charrasqueado@la elisa- antonio aguilar@la ley del monte-- vicente fernandez@la_cruda@la_muerte_de_un_gallero@mujere divinas- vicente  fernadez@por tu maldito amor- vicente fernadez@por una mujer bonita - pepe aguilar@si_te_vas_no_hay_lio@sublime mujer- vicente fernandez@un_chorro_de_voz@yo_soy_mexicano",
			"1. En la intimidad - OZUNA@2.Dime que tu me quieres - OZUNA@3. Si tu marido no te quiere - OZUNA@4.Corazon de seda - OZUNA@5.Escapate conmigo - OZUNA@6. Despacito - Daddy@7.Shaky Shaky - Daddy@8. Lo que paso paso - Daddy@9.Llamado de emergencia - Daddy@10.Impacto - Daddy@a lo sato@acercate@adicta@adicto@amor bandido@baila asi@buscando placer@calor@chica de barrio@curiosidad",
			"666 - Angeles del Infierno@Ay que dolor- La Derecha@De musica ligera  - Soda Stereo@El baile de los que sobran - Los prisioneros@El baile y el salon - Cafe Tacvba@El Puñal- La Derecha@Lady Blue - Enrique Bunbury@Maldito duende - Heroes del silencio@Nada me obliga - La Pestilencia@Pensando en ti - Angeles del Infierno@Rock1@Rock2@Rock3@Rock4@Rock5@Rock6@Rock7@Rock8@Rock9@Rock10",
			"al fin sali de ti@amandote@antidoti@beso a beso@demasiado corazon@el preso@flor palida@hasta ayer@hubo alguien@idilio@la quiero a morir@mi hijo y yo@mi vecina@Pa que me llamas (Miguel del amargue)@paso la noche pensando en ti@quisiera callar@señora ley@sin sentimiento (grupo niche)@te conozco bien@una aventura",
			"acuerdate@amantes Inocentes@buscaUnConfidente@casa en el aire@destrozaste mi alma@destrozasteMiAlma@esaMujer@hojaEnBlanco@me ilusione@me sobran las palabras@mis cinco sentidos@no voy a llorar @olvidala@que no me faltes tu @siete palabras @tierraMala@todoDeCabeza@tu eres la reina @unAmorVerdadero@yaNoMeDueleMas" };

	private int nivel;
	private double m[][];
	private String genero;
	private double[][] matrizGeneralDeTransicion;
	private double probabilidadesPorGenero[];
	private String[] arreglo;

	public DivideYVenceras(String[] arreglo, int nivel, double m[][], String genero,
			double[][] matrizGeneralDeTransicion, double probabilidadesPorGenero[]) {
		if (nivel == 1) {
			this.arreglo = new String[] { "bachata", "balada", "merengue", "pop", "ranchera", "regaeton", "rock",
					"salsa", "vallenato" };

		} else {
			this.arreglo = arreglo;
		}
		this.probabilidadesPorGenero = probabilidadesPorGenero;
		this.nivel = nivel;
		this.m = m;
		this.genero = genero;
		this.matrizGeneralDeTransicion = new double[30][30];
		start();
	}

	@Override
	public void run() {

		matrizGeneralDeTransicion = realizarDivideYVencerasACanciones(arreglo, nivel, m, genero,
				matrizGeneralDeTransicion, 0);
	}

	/**
	 * Muestra el contenido de una matriz en consola
	 * 
	 * @param matrizGeneral
	 */
	public void pintarMatriz(double matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.printf("%s\t", matriz[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * Realiza todo el proceso de divide y venceras para las canciones
	 * 
	 * @param lista
	 *            puden ser lista de generos, lista de canciones o una cancioón
	 * @param nivel
	 *            nivel del divide y venceras al que se quiere pasar
	 * @param m
	 *            matriz base para generar la matriz de tansicion por generos
	 * @return matriz general de tansion
	 * @throws InterruptedException
	 */
	private double[][] realizarDivideYVencerasACanciones(String[] lista, int nivel, double m[][], String nombreGenero,
			double[][] matrizGeneralDeTransicion, int indiceCancion) {

		if (nivel == 1) {
			matrizGeneralDeTransicion = new double[30][30];
		}

		for (int i = 0; i < lista.length; i++) { // Iteracion con genero solo un
													// genero, solo un llamado
			if (nivel == 1) {
				nombreGenero = lista[i];

				DivideYVenceras a = new DivideYVenceras(cancionesGenero[i].split("@"), 2, m, nombreGenero,
						matrizGeneralDeTransicion, this.probabilidadesPorGenero);
				try {
					a.join();
				} catch (Exception e) {
					System.out.println(e);
				}
				matrizGeneralDeTransicion = generarMatrizGeneral(
						matrizTotalDeGenero(a.getMatrizGeneralDeTransicion(), i), matrizGeneralDeTransicion);

			} else if (nivel == 2) {
				double[][] conteo = realizarDivideYVencerasACanciones(lista, 3, m, nombreGenero,
						matrizGeneralDeTransicion, i);
				if (i < lista.length - 1) {
					generarMatrizTransicionGenero(conteo, m);
				} else {
					double[][] ultimaIteracion = generarMatrizTransicionGenero(conteo, m);
					return ultimaIteracion;
				}

			} else if (nivel == 3) {
				return contarFrecuenciaLetras(nombreGenero, lista[indiceCancion]);
			}
		}

		return matrizGeneralDeTransicion;
	}

	/**
	 * Multiplica una matriz por un escalar
	 * @param matriz matriz a multiplicar
	 * @param escalar escalar que multiplicara la matriz
	 * @return
	 */
	private double[][] multiplicarMatrizPorUnEscalar(double[][] matriz, double escalar) {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {

				matriz[i][j] = matriz[i][j] * escalar;

			}
		}

		return matriz;
	}

	/**
	 * Suma las matrices de transición de género para obtener la matriz general
	 * 
	 * @param realizarDivideYVencerasACanciones
	 *            representa una matriz de transición por genero
	 * @param matrizGeneral
	 *            matriz general que va acomulando los valores
	 * @return devuelve la matriz general de transicion despues de sumarle un
	 *         nuevo genero
	 */
	private double[][] generarMatrizGeneral(double[][] realizarDivideYVencerasACanciones, double[][] matrizGeneral) {
		for (int i = 0; i < matrizGeneral.length; i++) {
			for (int j = 0; j < matrizGeneral.length; j++) {
				matrizGeneral[i][j] += realizarDivideYVencerasACanciones[i][j];
			}
		}
		return matrizGeneral;
	}

	/**
	 * Suma las matrices de las canciones para obtener la matriz de transición
	 * de un solo género
	 * 
	 * @param conteo
	 *            conteo de las frecuencia de las letras de cada una de las
	 *            canciones
	 * @param m
	 *            matriz de trancion por cada genero
	 * @return matriz de trancion despues de realizar una adicion del conteo de
	 *         frecuencia de una canciones
	 */
	public double[][] generarMatrizTransicionGenero(double[][] conteo, double m[][]) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				m[i][j] += conteo[i][j];
			}
		}
		return m;
	}

	/**
	 * Hace la matriz acumulada de probabiliaddes de cada genero
	 * 
	 * @param matriz
	 *            matriz de
	 * @param numeroDeLaIteracion
	 * @return
	 */
	public double[][] matrizTotalDeGenero(double[][] matriz, int numeroDeLaIteracion) {
		double denominador = 0;
		for (int i = 0; i < matriz.length; i++) {
			denominador = sumaDeLaFila(i, matriz);
			if (denominador == 0) {
				denominador = 1;
			}
			for (int j = 0; j < matriz[0].length; j++) {

				matriz[i][j] = ((double) (matriz[i][j]) / (double) (denominador));

				if (j != 0) {
					matriz[i][j] = matriz[i][j] + matriz[i][j - 1];

				}
			}
		}

		return multiplicarMatrizPorUnEscalar(matriz, probabilidadesPorGenero[numeroDeLaIteracion]);
	}

	/**
	 * Suma todos los valores de una fila
	 * 
	 * @param n
	 * @return
	 */
	public double sumaDeLaFila(int n, double m[][]) {
		double suma = 0;
		for (int i = 0; i < m[0].length; i++) {
			suma += m[n][i];
		}

		return suma;
	}

	/**
	 * Cuenta las letras que hay de otras letras de una sola canción
	 * 
	 * @param cancion
	 *            cancion a la que se le quiere realizar el conteo
	 * @return mapa que contiene la frecuencia de cada letra
	 */
	private double[][] contarFrecuenciaLetras(String nombreDelGenero, String cancion) {
		CargarCancion cargar = new CargarCancion(nombreDelGenero, cancion);
		cargar.llenarArrayList();
		cargar.generarMatrizDeFrecuencia();

		return cargar.getMatrizFrec();
	}

	public double[][] getMatrizGeneralDeTransicion() {
		return this.matrizGeneralDeTransicion;
	}

}