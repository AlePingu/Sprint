
package ventanas;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Descripcion extends JFrame 
{
    private JButton atras,ver,salir;
    private JList listaCursos;
    private JTextArea detalles;
    private JLabel tituloCurso,tituloDescripcion;
    private JScrollPane s,q;
    private JPanel panel;
   
    public Descripcion()
   
    {
        super("Descripcion de los Cursos");
        setSize(800,500);
        setLocation(300,160);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        Action event = new Action();
        c.setLayout( new GridLayout(1,3));
//  Esta parte va a ingresar el texto        
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3,1));
        tituloCurso = new JLabel("Curso :");
        JPanel panel1_1 = new JPanel();
        panel1_1.setLayout(null);
        panel1_1.add(tituloCurso);
        tituloCurso.setBounds(0,83,55,55);
        panel1.add(panel1_1);
 // Esta parte va a ingresasr una lista Seleccionable      
        String[] cadenas = {"1","2","444444","4","5","77","66600000000088","3232","3333","565"};
        listaCursos = new JList(cadenas);
        s= new JScrollPane(listaCursos);
        s.setBounds(1,1,1,1);
        panel1.add(s);
 //Esta Parte va a ingresar el texto 2      
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3,1));
        JPanel panel2_2 = new JPanel();
        panel2_2.setLayout(null);
        tituloDescripcion = new JLabel("Descripcion del Curso:");
        panel2_2.add(tituloDescripcion);
        tituloDescripcion.setBounds(0,83,155,55);
        panel2.add(panel2_2);
  //Esta Parte se coloca el campo de texto donde se va referir el curso:
        JTextArea ades = new JTextArea();
        ades.setEditable(false); 
        q = new JScrollPane(ades,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel2.add(q);
  //Esta parte se coloca el boton para salir de la ventana      
        JPanel panel2_3 = new JPanel();
        panel2_3.setLayout(new GridLayout(3,2,7,7));
        atras = new JButton("<<atras");
        for(int i=1;i<=6;i++)
        {
            if(i==3)
            {
            panel2_3.add(atras);
            }
            else
            {
            panel2_3.add(new JPanel());
            }
        }
        panel2.add(panel2_3);
    //Esta parte va a ser de los botones de cerrar y ver derscripcion del curso...
         JPanel panel3 = new JPanel();
         panel3.setLayout(new GridLayout(3,1));
         JPanel panel3_1 = new JPanel();
         panel3_1.setLayout(null);
         panel3.add(panel3_1);
         JPanel panel3_2 = new JPanel();
         panel3_2.setLayout(new GridLayout(3,2,7,7));
         ver = new JButton("Ver"); 
         for(int i=1;i<=6;i++)
          {
             if(i==1)
              {
               //JLabel detalle = new JLabel("Ver detalle del curso:");
               JPanel panel333 =new JPanel();
               panel333.setLayout(new GridLayout(2,1));
               JPanel panel3_2_1 = new JPanel();
               JPanel panel3_2_2 = new JPanel();
               panel3_2_1.add(new JLabel("Ver Detalle"));
               panel3_2_2.add(new JLabel("del Curso:"));
               panel333.add(panel3_2_1);
               panel333.add(panel3_2_2);
               panel3_2.add(panel333);
              }
              if(i==4)
              {
               panel3_2.add(ver);
              }
               else
              {
               panel3_2.add(new JPanel());
              }
          }
         panel3.add(panel3_2);
    //parte en que se coloca el boton para salir
         JPanel panel3_3 = new JPanel();
         panel3_3.setLayout(new GridLayout(3,2,7,7));
         salir = new JButton("Salir");
         for(int i=1;i<=6;i++)
            {
                 if(i==4)
                     {
                         panel3_3.add(salir);
                     }
                 else
                     {
                          panel3_3.add(new JPanel());
                     }
            }
         salir.addActionListener(event);  
         panel3.add(panel3_3);
        setVisible(true);
        c.add(panel1);
        c.add(panel2);
        c.add(panel3);
        setVisible(true);
      
    }
    public static void main(String []args)
    {
    Descripcion c = new Descripcion();
    }

public class Action implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            
            if(e.getSource()==salir)
            cerrar();
        }
    }
        public void cerrar()
        {        
         System.exit(0);
        }
}
