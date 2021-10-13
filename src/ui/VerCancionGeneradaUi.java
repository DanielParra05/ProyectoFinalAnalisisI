package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class VerCancionGeneradaUi extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblGnero, lblLetraMasRepetida;
	
	
	public VerCancionGeneradaUi(GenerarCancionUi interfazPrincipal, String cancionGenerada, String genero,
			char letraRepetida, VectorDeNumeros vectores) {
		setTitle("Canci\u00F3n");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VerCancionGeneradaUi.class.getResource("/imagenes/mic.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 528, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblGnero = new JLabel("Genero:");
		lblGnero.setBounds(10, 11, 46, 14);
		contentPane.add(lblGnero);

		lblLetraMasRepetida = new JLabel("Caracter con mas ciclos=> '" + letraRepetida + "'");
		lblLetraMasRepetida.setBounds(300, 11, 300, 14);
		contentPane.add(lblLetraMasRepetida);

		textField = new JTextField(genero);
		textField.setEditable(false);
		textField.setBounds(66, 8, 184, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Canci\u00F3n generada", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(10, 36, 502, 306);
		contentPane.add(panel);
		panel.setLayout(null);

		JTextArea textArea = new JTextArea(cancionGenerada);
		JScrollPane a = new JScrollPane(textArea);
		a.setBounds(10, 22, 482, 273);
		panel.add(a);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}

		});

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				interfazPrincipal.setVisible(true);
			}
		});
		btnAceptar.setBounds(140, 355, 89, 23);
		setLocationRelativeTo(null);
		contentPane.add(btnAceptar);

		JButton btnVer = new JButton("Ver Vector");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				vectores.setVisible(true);
			}
		});
		btnVer.setBounds(300, 355, 100, 23);
		setLocationRelativeTo(null);
		contentPane.add(btnVer);
	}
}
