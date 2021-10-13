package ui;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Cargando extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel txtCarg;
	
	public Cargando(){
		setResizable(false);
		setLayout(null);
	    setTitle("Cargando...");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GenerarCancionUi.class.getResource("/imagenes/mic.png")));
		
		ImageIcon dos = new ImageIcon(this.getClass().getResource("/imagenes/cargando.gif"));
        JLabel fondo2 = new JLabel();
        this.setBackground(Color.WHITE);
        fondo2.setIcon(dos);
        this.add(fondo2, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo2.setBounds(0,-45, dos.getIconWidth(), dos.getIconHeight());
		setBounds(0,0,dos.getIconWidth(),  dos.getIconHeight());
	
		setLocationRelativeTo(null);
	}
	
}
