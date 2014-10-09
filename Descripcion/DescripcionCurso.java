/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class DescripcionCurso extends JFrame
{
    private JLabel nombreInstructor;
    private JLabel nombreCurso;
    private JTable horarios;
    private JTable costos;
    private JTextField campo1,campo2;
    private JScrollPane r,s;
    private String[] titulos = {"Tipo de Pago","Costo"};
    private String[] hora = {"Ambiente","Hora de Inicio","Hora Final"};
    private JButton cerrarVentana;
    public DescripcionCurso()
    {
        super("Detalle del Curso");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new GridLayout(2,1));
        Action event= new Action();
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3,3));
        campo1 = new JTextField();
        campo1.setEditable(false);
        campo2 = new JTextField();
        campo2.setEditable(false);
        setBounds(300,160,800,500);
        //parte para agregar el titulo del curso
        for(int i=1;i<=9;i++)
        {
            if(i == 1)
            {
                JPanel p1 = new JPanel();
                p1.setLayout(new GridLayout(1,3));
                for(int j=1;j<=3;j++)
                {
                    if(j==3)
                    {
                        p1.add(new JLabel("Curso"));
                    }
                    else
                        p1.add(new JPanel());
                }
                 panel1.add(p1);
             }
          // parte para agregar el campo del texto donde indicara el el nombre del curso 
            if(i == 2)
            {
               JPanel p2 = new JPanel();
                p2.setLayout(new GridLayout(3,1));
                for(int k=1;k<=3;k++)
                {
                    if(k==2)
                    {
                        p2.add(campo1);
                    }
                    else
                        p2.add(new JPanel());
                }
               
            panel1.add(p2);
            }   
           // parte que agrega el titulo que indica el instructor 
            if(i == 4)
            {
  
                JPanel p3 = new JPanel();
                p3.setLayout(new GridLayout(1,3));
                for(int m=1;m<=3;m++)
                {
                    if(m==3)
                    {
                      p3.add(new JLabel("Instructor"));   
                     }
                    else
                      p3.add(new JPanel());
                }
                 panel1.add(p3);
                        
               
            }
          //parte que indica el lugar y elagregado del campo detexto que muestra el nombre del instructor
            if(i == 5)
            {
                 JPanel p4 = new JPanel();
                 p4.setLayout(new GridLayout(3,1));
                 for(int q=1;q<=3;q++)
                {
                    if(q==2)
                    {
                      p4.add(campo2);   
                    }
                    else
                      p4.add(new JPanel());
                }
              panel1.add(p4);  
            }
              
            if( i==3 || i==6 || i==7 || i==8 || i==9 )
                panel1.add(new JPanel());
        }
        // parte que agrega un JTable para los costos del curso y los horarios
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,2));
        //parte para agregar los costos
        JPanel panel2_1 = new JPanel();
        panel2_1.setLayout(new BorderLayout());
        String[][] datosEjemplo1 = {{"1 persona","789"},{"grupo de 5","456"},{"grupo de 10","123"},{"Expositor","333"}};
        costos = new JTable(datosEjemplo1,titulos);
        r = new JScrollPane(costos);
        panel2_1.add(new JLabel("Costos y promociones"),BorderLayout.NORTH);
        panel2_1.add(r,BorderLayout.CENTER);
        
        panel2_1.add(new JLabel("Ventana Descriptica"),BorderLayout.SOUTH);
        panel2.add(panel2_1);
        //parte para agregar los horarios
        JPanel panel2_2 = new JPanel();
        panel2_2.setLayout(new BorderLayout());
        String[][] ambiente = {{"ambiente 1","07:00","08:00",},{"ambiente 2","09:00","10:00"},{"ambiente 3","10:00","11:00"},{"ambiente 4","11:00","12:00"}};
        horarios = new JTable(ambiente,hora);
        s= new JScrollPane(horarios);
        panel2_2.add(s,BorderLayout.CENTER);
        panel2_2.add(new JLabel("Horarios y ambientes"),BorderLayout.NORTH);
        //parte para agragar el boton de cerrar
       
        cerrarVentana = new JButton("Cerrar");
        JPanel panelCerrar = new JPanel();
        panelCerrar.setLayout(new GridLayout(1,3));
        
        for(int z=1;z<=3;z++)
        {
            if(z==3)
            {
            panelCerrar.add(cerrarVentana);
            }
            else
            panelCerrar.add(new JPanel());    
        }
        cerrarVentana.addActionListener(event);
        panel2_2.add(panelCerrar,BorderLayout.SOUTH);
        panel2.add(panel2_2);
        c.add(panel1);
        c.add(panel2);
        setVisible(true);
                
     }
    public static void main(String []args)
    {
    DescripcionCurso v = new DescripcionCurso();
    }
    //para cerrar la ventana
    public class Action implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            
            if(e.getSource()==cerrarVentana)
            cerrar();
        }
    }
public void cerrar()
    {        
         System.exit(0);
    }
}
