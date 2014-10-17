package vista;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class retirarCursos extends JDialog{
	private JLabel titulo,cursos,fondo;
	public JTable tabla;
	public DefaultTableModel modelo;
	public JScrollPane barra;
	public JButton quitarCurso,salir;
	
	public retirarCursos(String[] curso,String[] expositor,String [] ambiente,String[] fecha){
		setTitle("Ventana Retirar Cursos");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(null);

		fondo = new JLabel();
        fondo.setBounds(0,0,800,600);
        ImageIcon fot = new ImageIcon("imagenes/2.jpg");
  	    Icon icono1 = new ImageIcon(fot.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
  	    fondo.setIcon(icono1);

		titulo = new JLabel("Retirar un Curso");
	    cursos = new JLabel("Lista de Cursos");
	    modelo = new DefaultTableModel();  
	     tabla = new JTable(modelo);
	     barra = new JScrollPane(tabla);
   quitarCurso = new JButton("Quitar Curso");
         salir = new JButton("Salir");
         
         titulo.setFont(new Font("Arial Black", Font.BOLD, 20));
         cursos.setFont(new Font("Arial Black", Font.BOLD, 15));
         modelo.addColumn("Curso");
         modelo.addColumn("Expositor");
         modelo.addColumn("Ambiente");
         modelo.addColumn("fecha");
         for(int i=0;i<curso.length;i++){
        	 Object [] fila = new Object[4];
        	 fila[0] = curso[i];
        	 fila[1] = expositor[i];
        	 fila[2] = ambiente[i];
        	 fila[3] = fecha[i];
        	 modelo.addRow ( fila );
         }
         
         titulo.setBounds(300,10,350,50);
         cursos.setBounds(50,50,250,50);
         barra.setBounds(50,90,700,400);
   quitarCurso.setBounds(50,500,150,25);
         salir.setBounds(550,520,150,50);
         
         add(titulo);
         add(cursos);
         add(barra);
         add(quitarCurso);
         add(salir);
         add(fondo);
         
         setSize(800,600);
         setLocationRelativeTo(null);
         setVisible(true);
	}
	

}
