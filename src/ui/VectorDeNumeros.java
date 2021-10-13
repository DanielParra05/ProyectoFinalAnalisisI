package ui;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 *
 * @author Daniel Parra
 */
public class VectorDeNumeros extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnAceptar;
	DefaultListModel<Object> a;
	GenerarCancionUi generarCancionUi;
	private final JList<Object> lista;

	private final JLabel txtIndicador;

	public VectorDeNumeros(GenerarCancionUi generarCancionUi) {
		setLayout(null);
		this.generarCancionUi = generarCancionUi;
		a = new DefaultListModel<>();
		setIconImage(Toolkit.getDefaultToolkit().getImage(VerCancionGeneradaUi.class.getResource("/imagenes/mic.png")));
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(20, 280, 100, 30);
		getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(this);
		txtIndicador = new JLabel("Probabilidades");
		txtIndicador.setBounds(20, 10, 600, 25);
		txtIndicador.setFont(new java.awt.Font("Arial Black", 10, 20));
		getContentPane().add(txtIndicador);
		lista = new JList<Object>();
		JScrollPane scroll = new JScrollPane(lista);
		scroll.setBounds(20, 40, 530, 220);
		add(scroll);

		setTitle("Vector de numeros");

		setSize(578, 356);
		setLocationRelativeTo(null);
		setResizable(false);
		setBackground(Color.white);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnAceptar) {
			setVisible(false);
			generarCancionUi.getInterfazVer().setVisible(true);
			setVisible(false);
		}

	}

	public void actualizarLista(double[] n) {

		a.clear();

		for (int i = 0; i < n.length; i++) {

			a.addElement(i + ") " + n[i]);

		}

		lista.setModel(a);

	}

}
