import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;
public class formularioExpo extends JPanel{
	public JLabel fondo,titulo,nombreEti,nombre,horaInicio,asignaHora,curso,descripcion,dia;
	public JTextField campoCurso;
	public JButton aceptar,agregaHora,cancelar;
	public JTextArea campoHora,descripcionCurso;
	private JScrollPane barra;
	public JDateChooser fecha;
	public JComboBox periodo;
	public formularioExpo(String nombreExpositor){
	      setName("Formulario de registro de exposicion");
	      setLayout(null);
	      
	        fondo = new JLabel();
	        fondo.setBounds(0,0,800,600);
	        ImageIcon fot = new ImageIcon("imagenes/2.jpg");
	  	    Icon icono1 = new ImageIcon(fot.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
	  	    fondo.setIcon(icono1);
	         fecha = new JDateChooser();
	         
	         String horas [] = {"8:15 - 9:45","9:45 - 11:15","11:15 - 12:45","12:45 - 14:15","14:15 - 15:45","15:45 - 17:15","17:15 -18:45","18:45 - 20:15"};
	         
	         titulo = new JLabel("REGISTRAR EXPOSICION");
	      nombreEti = new JLabel("NOMBRE : ");
	         nombre = new JLabel(nombreExpositor.toUpperCase());
	     horaInicio = new JLabel("PERIODO : ");
	          curso = new JLabel("CURSO : ");
	    descripcion = new JLabel("DESCRIPCION DEL CURSO : ");
	     asignaHora = new JLabel("HORAS ASIGNADAS : ");
	            dia = new JLabel("DIA : ");
	        periodo = new JComboBox(horas);
	          titulo.setFont(new Font("Arial Black", Font.BOLD, 20));
           nombreEti.setFont(new Font("Arial Black", Font.BOLD, 15));
              nombre.setFont(new Font("Arial Black", Font.BOLD, 15));
          horaInicio.setFont(new Font("Arial Black", Font.BOLD, 15));
           curso.setFont(new Font("Arial Black", Font.BOLD, 15));
         descripcion.setFont(new Font("Arial Black", Font.BOLD, 15));
          asignaHora.setFont(new Font("Arial Black", Font.BOLD, 15));
                 dia.setFont(new Font("Arial Black", Font.BOLD, 15));
	    
        
         campoCurso = new JTextField(50);
            aceptar = new JButton("Aceptar");
         agregaHora = new JButton("Verifica Hora");
           cancelar = new JButton("Cancelar"); 
        		   
          campoHora = new JTextArea();
   descripcionCurso = new JTextArea();
          barra = new JScrollPane(descripcionCurso);
          
          descripcionCurso.setLineWrap(true);
         
   	          titulo.setBounds(250,-15,400,100);
   	       nombreEti.setBounds(100,50,250,50);
   	          nombre.setBounds(200,50,250,50);
   	      horaInicio.setBounds(100,80,300,50);
   	         periodo.setBounds(200,90,150,25);
   	      agregaHora.setBounds(550,140,150,25);
   	      asignaHora.setBounds(100,120,250,50);
   	       campoHora.setBounds(270,160,200,100);
   	           curso.setBounds(100,270,150,50);
   	      campoCurso.setBounds(180,285,150,22);
   	     descripcion.setBounds(100,300,300,50);
   	           barra.setBounds(100,340,600,200);
   	         aceptar.setBounds(400,550,150,40);
   	        cancelar.setBounds(600,550,150,40);
   	        dia.setBounds(540,95,100,25);
   	        fecha.setBounds(600,95,150,25);
   	           add(titulo);
   	           add(nombreEti);
   	           add(nombre);
   	           add(horaInicio);
   	           add(periodo);
   	           add(agregaHora);
   	           add(asignaHora);
   	           add(campoHora);
   	           add(curso);
   	           add(campoCurso);
   	           add(descripcion);
   	           add(barra);
   	           add(aceptar);
   	           add(cancelar);
               add(fecha);
               add(dia);
   	           add(fondo);
   	           setSize(800,600);
   	           setVisible(true);
   	           
	
	}
	/*
	public void actionPerformed(ActionEvent evento) {
		
	}
	*/
}
