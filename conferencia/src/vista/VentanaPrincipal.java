package vista;

import java.awt.Image;

import javax.swing.*;



public class VentanaPrincipal extends JFrame{
	public JButton logear,listaCursos;
	private JLabel fondo;
	public VentanaPrincipal(){
		super("Ventana Principal");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		fondo = new JLabel();
        fondo.setBounds(0,0,800,600);
        ImageIcon fot = new ImageIcon("imagenes/2.jpg");
  	    Icon icono1 = new ImageIcon(fot.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
  	    fondo.setIcon(icono1);
		
		logear = new JButton("Iniciar Sesion");
		listaCursos = new JButton("Lista de cursos");
		
		logear.setBounds(50,50,150,25);
		listaCursos.setBounds(50,80,150,25);
		
		add(logear);
		add(listaCursos);
		add(fondo);
		setSize(400,400);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}