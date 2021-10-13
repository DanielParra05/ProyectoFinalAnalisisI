package ui;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.*;

import logica.GenerarCancion;

public class GenerarCancionUi extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtReggaeton, txtRock, txtPop, txtBachata, txtBalada, txtRanchero, txtVallenato, txtSalsa,
			txtMerengue, txtLetra;
	private JButton btnSalvar, btnGenerar, btnSalir;
	private GenerarCancion generarCancion;
	private JComboBox<String> comboBox;
	private VectorDeNumeros vectores;
	private VerCancionGeneradaUi interfazVer;

	public GenerarCancionUi() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GenerarCancionUi.class.getResource("/imagenes/mic.png")));
		setTitle("Generar canci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBorder((Border) new TitledBorder(null, "Probabilidades g\u00E9nero", TitledBorder.CENTER,
				TitledBorder.TOP, null, null));
		panel.setBounds(10, 43, 378, 190);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Rock");
		lblNewLabel.setBounds(10, 27, 67, 14);
		panel.add(lblNewLabel);

		JLabel lblPop = new JLabel("Pop");
		lblPop.setBounds(10, 52, 67, 14);
		panel.add(lblPop);

		JLabel lblBachata = new JLabel("Bachata");
		lblBachata.setBounds(10, 77, 67, 14);
		panel.add(lblBachata);

		JLabel lblReggaeton = new JLabel("Reggaeton");
		lblReggaeton.setBounds(10, 102, 67, 14);
		panel.add(lblReggaeton);

		JLabel lblBalada = new JLabel("Balada");
		lblBalada.setBounds(10, 127, 67, 14);
		panel.add(lblBalada);

		JLabel lblSalsa = new JLabel("Salsa");
		lblSalsa.setBounds(203, 27, 70, 14);
		panel.add(lblSalsa);

		JLabel lblVallenato = new JLabel("Vallenato");
		lblVallenato.setBounds(203, 52, 70, 14);
		panel.add(lblVallenato);

		JLabel lblRanchero = new JLabel("Ranchero");
		lblRanchero.setBounds(203, 77, 70, 14);
		panel.add(lblRanchero);

		JLabel lblMerengue = new JLabel("Merengue");
		lblMerengue.setBounds(203, 102, 78, 14);
		panel.add(lblMerengue);

		JLabel lblLetra = new JLabel("Letra");
		lblLetra.setBounds(203, 127, 78, 14);
		panel.add(lblLetra);

		txtReggaeton = new JTextField();
		txtReggaeton.setBounds(87, 99, 89, 20);
		panel.add(txtReggaeton);
		txtReggaeton.setColumns(10);

		txtRock = new JTextField();
		txtRock.setColumns(10);
		txtRock.setBounds(87, 24, 89, 20);
		panel.add(txtRock);

		txtPop = new JTextField();
		txtPop.setColumns(10);
		txtPop.setBounds(87, 49, 89, 20);
		panel.add(txtPop);

		txtBachata = new JTextField();
		txtBachata.setColumns(10);
		txtBachata.setBounds(87, 74, 89, 20);
		panel.add(txtBachata);

		txtBalada = new JTextField();
		txtBalada.setColumns(10);
		txtBalada.setBounds(87, 124, 89, 20);
		panel.add(txtBalada);

		txtRanchero = new JTextField();
		txtRanchero.setColumns(10);
		txtRanchero.setBounds(275, 77, 93, 20);
		panel.add(txtRanchero);

		txtVallenato = new JTextField();
		txtVallenato.setColumns(10);
		txtVallenato.setBounds(275, 52, 93, 20);
		panel.add(txtVallenato);

		txtSalsa = new JTextField();
		txtSalsa.setColumns(10);
		txtSalsa.setBounds(275, 27, 93, 20);
		panel.add(txtSalsa);

		txtMerengue = new JTextField();
		txtMerengue.setColumns(10);
		txtMerengue.setBounds(275, 102, 93, 20);
		panel.add(txtMerengue);

		txtLetra = new JTextField();
		txtLetra.setBounds(275, 125, 93, 20);
		panel.add(txtLetra);

		vectores = new VectorDeNumeros(this);
		generarCancion = new GenerarCancion(this, vectores);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this);
		btnSalvar.setBounds(146, 155, 89, 23);
		panel.add(btnSalvar);

		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(217, 243, 89, 23);
		contentPane.add(btnSalir);

		btnGenerar = new JButton("Generar");
		btnGenerar.setBounds(94, 243, 89, 23);
		btnGenerar.addActionListener(this);
		contentPane.add(btnGenerar);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}

		});

		comboBox = new JComboBox<>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String[] prob;
				switch (comboBox.getSelectedIndex()) {
				case 1:
					prob = generarCancion.cargarProbabilidades(comboBox.getSelectedItem().toString());
					asignarValores(prob[0], prob[1], prob[2], prob[3], prob[4], prob[5], prob[6], prob[7], prob[8]);
					break;
				case 2:
					prob = generarCancion.cargarProbabilidades(comboBox.getSelectedItem().toString());
					asignarValores(prob[0], prob[1], prob[2], prob[3], prob[4], prob[5], prob[6], prob[7], prob[8]);
					break;
				case 3:
					prob = generarCancion.cargarProbabilidades(comboBox.getSelectedItem().toString());
					asignarValores(prob[0], prob[1], prob[2], prob[3], prob[4], prob[5], prob[6], prob[7], prob[8]);
					break;
				case 4:
					prob = generarCancion.cargarProbabilidades(comboBox.getSelectedItem().toString());
					asignarValores(prob[0], prob[1], prob[2], prob[3], prob[4], prob[5], prob[6], prob[7], prob[8]);
					break;
				case 5:
					prob = generarCancion.cargarProbabilidades(comboBox.getSelectedItem().toString());
					asignarValores(prob[0], prob[1], prob[2], prob[3], prob[4], prob[5], prob[6], prob[7], prob[8]);
					break;
				case 6:
					prob = generarCancion.cargarProbabilidades(comboBox.getSelectedItem().toString());
					asignarValores(prob[0], prob[1], prob[2], prob[3], prob[4], prob[5], prob[6], prob[7], prob[8]);
					break;
				case 7:
					prob = generarCancion.cargarProbabilidades(comboBox.getSelectedItem().toString());
					asignarValores(prob[0], prob[1], prob[2], prob[3], prob[4], prob[5], prob[6], prob[7], prob[8]);
					break;
				case 8:
					prob = generarCancion.cargarProbabilidades(comboBox.getSelectedItem().toString());
					asignarValores(prob[0], prob[1], prob[2], prob[3], prob[4], prob[5], prob[6], prob[7], prob[8]);
					break;
				case 9:
					prob = generarCancion.cargarProbabilidades(comboBox.getSelectedItem().toString());
					asignarValores(prob[0], prob[1], prob[2], prob[3], prob[4], prob[5], prob[6], prob[7], prob[8]);
					break;
				default:
					asignarValores("", "", "", "", "", "", "", "", "");
					break;
				}
			}
		});
		comboBox.setBounds(82, 12, 269, 20);
		contentPane.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Seleccionar genero", "Rock", "Pop",
				"Bachata", "Reggaeton", "Balada", "Salsa", "Vallenato", "Ranchero", "Merengue" }));

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(GenerarCancionUi.class.getResource("/imagenes/fondoApp.jpg")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 403, 277);
		contentPane.add(label);
	}

	/**
	 * Asigna los valores de las probabilidades en el JFrame
	 */
	private void asignarValores(String bachata, String balada, String merengue, String pop, String ranchero,
			String reggaeton, String rock, String salsa, String vallenato) {

		txtRock.setText(rock);
		txtPop.setText(pop);
		txtBachata.setText(bachata);
		txtReggaeton.setText(reggaeton);
		txtBalada.setText(balada);
		txtSalsa.setText(salsa);
		txtVallenato.setText(vallenato);
		txtRanchero.setText(ranchero);
		txtMerengue.setText(merengue);
	}

	/**
	 * Confirma si una cadena es un numero
	 * 
	 * @param cadena
	 * @return
	 */
	private static boolean isNumeric(String cadena) {
		try {
			Double.parseDouble(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	/**
	 * Confirma si las porpiedades ingresadas son correctas
	 * 
	 * @return
	 */
	private boolean confirmarCampos() {
		if (comboBox.getSelectedIndex() != -1 && comboBox.getSelectedIndex() != 0) {

			if (!txtRock.getText().isEmpty() && !txtPop.getText().isEmpty() && !txtBachata.getText().isEmpty()
					&& !txtReggaeton.getText().isEmpty() && !txtBalada.getText().isEmpty()
					&& !txtSalsa.getText().isEmpty() && !txtVallenato.getText().isEmpty()
					&& !txtRanchero.getText().isEmpty() && !txtMerengue.getText().isEmpty()
					&& !txtLetra.getText().isEmpty()) {

				if (isNumeric(txtRock.getText()) && isNumeric(txtPop.getText()) && isNumeric(txtBachata.getText())
						&& isNumeric(txtReggaeton.getText()) && isNumeric(txtBalada.getText())
						&& isNumeric(txtSalsa.getText()) && isNumeric(txtVallenato.getText())
						&& isNumeric(txtRanchero.getText()) && isNumeric(txtMerengue.getText())
						&& !(isNumeric(txtLetra.getText())) && !(txtLetra.getText().trim().length() > 1)) {
					return true;

				} else {
					JOptionPane.showMessageDialog(null, "Revise los datos ingresados");
					return false;
				}

			} else {
				JOptionPane.showMessageDialog(null, "Algun campo necesario está sin diligenciar.");
				return false;
			}

		} else {
			JOptionPane.showMessageDialog(null, "Seleccione un género para generar la canción");
			return false;
		}

	}

	/**
	 * Obtiene la primera letra de la cancion que se va agenerar
	 * 
	 * @return
	 */
	public char getLetra() {
		char[] arreglo = txtLetra.getText().toCharArray();

		if (arreglo.length == 0) {
			return ' ';
		} else {

			return arreglo[0];
		}

	}

	public VerCancionGeneradaUi getInterfazVer() {
		return interfazVer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnGenerar) {

			if (confirmarCampos()) {
				double probabilidades[] = new double[9];
				probabilidades[0] = Double.parseDouble(txtBachata.getText());
				probabilidades[1] = Double.parseDouble(txtBalada.getText());
				probabilidades[2] = Double.parseDouble(txtMerengue.getText());
				probabilidades[3] = Double.parseDouble(txtPop.getText());
				probabilidades[4] = Double.parseDouble(txtRanchero.getText());
				probabilidades[5] = Double.parseDouble(txtReggaeton.getText());
				probabilidades[6] = Double.parseDouble(txtRock.getText());
				probabilidades[7] = Double.parseDouble(txtSalsa.getText());
				probabilidades[8] = Double.parseDouble(txtVallenato.getText());

				if (generarCancion.probabilidadesCorrectas(probabilidades)) {
					// hiloCarga = new HiloCargar();
					generarCancion.asignarLetraInicial();
					generarCancion.metodoGenerador(probabilidades);

					interfazVer = new VerCancionGeneradaUi(this, generarCancion.obtenerCancionGenerada(),
							comboBox.getSelectedItem().toString(), generarCancion.getLetraQueMasRepite(), vectores);

					this.setVisible(false);
					interfazVer.setVisible(true);

				} else {
					JOptionPane.showMessageDialog(null, "Las probabilidades son superiores o inferiores al 100%.");
				}
			}

		}

		if (e.getSource() == btnSalir) {
			System.exit(0);
		}

		if (e.getSource() == btnSalvar) {

			if (confirmarCampos()) {
				double probabilidades[] = new double[9];
				probabilidades[0] = Double.parseDouble(txtBachata.getText());
				probabilidades[1] = Double.parseDouble(txtBalada.getText());
				probabilidades[2] = Double.parseDouble(txtMerengue.getText());
				probabilidades[3] = Double.parseDouble(txtPop.getText());
				probabilidades[4] = Double.parseDouble(txtRanchero.getText());
				probabilidades[5] = Double.parseDouble(txtReggaeton.getText());
				probabilidades[6] = Double.parseDouble(txtRock.getText());
				probabilidades[7] = Double.parseDouble(txtSalsa.getText());
				probabilidades[8] = Double.parseDouble(txtVallenato.getText());

				if (generarCancion.probabilidadesCorrectas(probabilidades)) {
					generarCancion.guardarProbabilidades(probabilidades, comboBox.getSelectedItem().toString());
					JOptionPane.showMessageDialog(null, "Propiedades guardadas");
				} else {
					JOptionPane.showMessageDialog(null, "Las probabilidades son superiores o inferiores al 100%.");
				}
			}
		}

	}

}
