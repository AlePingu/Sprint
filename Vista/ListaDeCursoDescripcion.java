/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
public class ListaDeCursoDescripcion extends JFrame
{
   private Controlador control;
   private Conexion conector;
   private String[] cursos;
   private JLabel titulo;
   private JPanel panelNumeros,panelCursos;
   private JButton botonSalir,botonAtras; 
   public JButton[] botones;
   //private ImagenFondo fondo = new ImagenFondo();
    private TransparentPanel fondo = new TransparentPanel();
   public ListaDeCursoDescripcion()
    {
        super("Cursos Disponibles para inscripcion");
        fondo.setBackgroundImage(fondo.createImage("/Imagenes/2.jpg").getImage()); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        fondo.setLayout(new BorderLayout(5,5));
        setBounds(300,160,800,500);
        
        Action event = new Action();
        panelNumeros = new TransparentPanel();
        panelCursos = new TransparentPanel();
        botonSalir = new JButton("Salir");
        botonAtras = new JButton("<< Atras");
        //agrego el titulo
        JPanel panelTitulo = new TransparentPanel();
        panelTitulo.setLayout(new GridLayout(1,3,7,7));
        titulo = new JLabel("Cursos Registrados:");
        for(int h=1;h<=3;h++)
        {
            if(h==2)
            {
                panelTitulo.add(titulo);
            }
            else
            {
                panelTitulo.add(new TransparentPanel());
            }
        }
         fondo.add(panelTitulo,BorderLayout.NORTH);
        //agrego los cursos
       
        String[] curso = {"sis2","curso 2","curso 3","curso 4","curso 5","curso 6","curso 7","curso 8","curso 9","curso 10","curso 11"};
        int tam = (int)Math.sqrt((double)curso.length);
        panelCursos.setLayout(new GridLayout(tam,tam,20,20));
        botones =new JButton[curso.length];
        for(int j=0;j<=(int)curso.length-1;j++)
        {
            botones[j] = new JButton(curso[j]);
            panelCursos.add(botones[j]);
            
        }
        fondo.add(panelCursos,BorderLayout.CENTER);
        //agrego numeros al lado izquierdo para enumerar
       
       panelNumeros.setLayout(new GridLayout(tam,1,20,20));
       for(int s=1;s<=tam;s++)
       {
           panelNumeros.add(new JLabel(String.valueOf(s)));
       }
       fondo.add(panelNumeros,BorderLayout.WEST);
       //setVisible(true);
       //parte para agregar el boton atras,boton para salir, y las indicaciones
       JPanel panelC = new TransparentPanel();
       panelC.setLayout(new GridLayout(1,2));
       panelC.add(new JLabel("Aprete un boton para ver Detalle"));
       JPanel panelBotones = new TransparentPanel();
       panelBotones.setLayout(new GridLayout(1,2,110,110));
       panelBotones.add(botonAtras);
       panelBotones.add(botonSalir);
       botonSalir.addActionListener(event);  
       panelC.add(panelBotones);
       fondo.add(panelC,BorderLayout.SOUTH);
       c.add(fondo);
    }
    public static void main(String []args)
    {
        //CursosDisponibles cu = new CursosDisponibles(new Controlador(), new Conexion());
        new ListaDeCursoDescripcion();
    }
    public class Action implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            
            if(e.getSource()==botonSalir)
            cerrar();
        }
    }
        public void cerrar()
        {        
         System.exit(0);
        }
    public void esVisible()
    {
        this.setVisible(true);
    }
}
