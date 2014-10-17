package vista;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
public class ventanaDetalleConfirmacionCurso extends JDialog {
	 private JLabel titulo,nombreExpositor,curso,horario,descripcion,fondo;
	 public JTextArea horas,descripcionCurso;
	 public JButton confirmar,cancelar,salir;
	 public JScrollPane barra;
	 public ventanaDetalleConfirmacionCurso(String nombre,String nombreCurso,String Horas,String descripcionCursop){
		 
		 setTitle("Confirmacion de un Curso");
		 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		 setLayout(null);
		 
		    fondo = new JLabel();
	        fondo.setBounds(0,0,800,600);
	        ImageIcon fot = new ImageIcon("imagenes/2.jpg");
	  	    Icon icono1 = new ImageIcon(fot.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
	  	    fondo.setIcon(icono1);
	  	    
	  	    titulo = new JLabel("Detalle del curso a confirmar ");
	  	    nombreExpositor = new JLabel("Nombre : "+nombre);
	  	    curso = new JLabel("Curso : "+nombreCurso);
	  	    horario = new JLabel("Horario : ");
	  	    descripcion = new JLabel("Descripcion de Curso :");
	  	    
	  	    titulo.setFont(new Font("Arial Black", Font.BOLD, 20));
   nombreExpositor.setFont(new Font("Arial Black", Font.BOLD, 15));
             curso.setFont(new Font("Arial Black", Font.BOLD, 15));
           horario.setFont(new Font("Arial Black", Font.BOLD, 15));
       descripcion.setFont(new Font("Arial Black", Font.BOLD, 15));
       
             horas = new JTextArea();
             horas.setLineWrap(true);
             horas.setText(Horas);
             horas.setEditable(false);
             
             descripcionCurso = new JTextArea();
             descripcionCurso.setLineWrap(true);
             descripcionCurso.setText(descripcionCursop);
             descripcionCurso.setEditable(false);
             barra = new JScrollPane(descripcionCurso);
             
             confirmar = new JButton("Confirmar Curso");
              cancelar = new JButton("Denegar Curso");
                 salir = new JButton("Salir");
                 
                 titulo.setBounds(250,10,450,50);
        nombreExpositor.setBounds(150,50,250,50);
                  curso.setBounds(170,100,450,50);
                horario.setBounds(161,150,250,50);
                  horas.setBounds(250,180,300,80);
            descripcion.setBounds(50,250,450,50);
                  barra.setBounds(250,285,450,200);
              confirmar.setBounds(150,500,150,25);
               cancelar.setBounds(350,500,150,25);
                  salir.setBounds(600,510,150,50);
                  
                  add(titulo);
                  add(nombreExpositor);
                  add(curso);
                  add(horario);
                  add(horas);
                  add(descripcion);
                  add(barra);
                  add(confirmar);
                  add(cancelar);
                  add(salir);
                  add(fondo);
                  setSize(800,600);
                  setLocationRelativeTo(null);
                  setVisible(true);
	 }
	

}
