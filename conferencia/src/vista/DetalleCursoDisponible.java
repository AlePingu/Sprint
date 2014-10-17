package vista;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
public class DetalleCursoDisponible extends JFrame
{
    
    private JTable horarios;
    private JTable costos;
    public JTextField nombreCurso;
    private JTextArea detalleCurso;
    private JScrollPane r,s,t;
    private String[] titulos = {"Tipo de Pago","Costo"};
    private String[] hora = {"Fecha","Periodo","Ambiente","instructor"};
    public JButton cerrarVentana;
    private String[] periodos = {"8:15-9:45","9:45-11:15","11:15-12:45","12:45-14:15","14:15-15:45","15:45-17:15","17:15-18:45","18:45-20:15"};
    private DefaultTableModel tablaTitulos;
    private DefaultTableModel tablaHora;
    TransparentPanel fondo = new TransparentPanel();
    public DetalleCursoDisponible(String curso)
    {
        super("Detalle del Curso");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container c = getContentPane();
        fondo.setBackgroundImage(fondo.createImage("/imagenes/2.jpg").getImage());
        
     
        fondo.setLayout(new GridLayout(2,1));
        Action event= new Action();
        JPanel panel1 = new TransparentPanel();
        panel1.setLayout(new GridLayout(3,3));
        
        tablaHora = new DefaultTableModel(null,periodos);
        nombreCurso= new JTextField();
        nombreCurso.setEditable(false);
        nombreCurso.setText(curso);
        detalleCurso = new JTextArea();
        detalleCurso.setEditable(false);
        detalleCurso.setLineWrap(true);
        t = new JScrollPane(detalleCurso,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        setBounds(300,160,800,500);
        //parte para agregar el titulo del curso
        for(int i=1;i<=9;i++)
        {
            if(i == 1)
            {
                JPanel p1 = new TransparentPanel();
                p1.setLayout(new GridLayout(1,3));
                for(int j=1;j<=3;j++)
                {
                    if(j==3)
                    {
                        p1.add(new JLabel("Curso"));
                    }
                    else
                        p1.add(new TransparentPanel());
                }
                 panel1.add(p1);
             }
          // parte para agregar el campo del texto donde indicara el el nombre del curso 
            if(i == 2)
            {
               JPanel p2 = new TransparentPanel();
                p2.setLayout(new GridLayout(3,1));
                for(int k=1;k<=3;k++)
                {
                    if(k==2)
                    {
                        p2.add(nombreCurso);
                    }
                    else
                        p2.add(new TransparentPanel());
                }
               
            panel1.add(p2);
            }   
           // parte que agrega el titulo que indica el instructor 
            if(i == 4)
            {
  
                JPanel p3 = new TransparentPanel();
                p3.setLayout(new GridLayout(1,3));
                for(int m=1;m<=3;m++)
                {
                    if(m==3)
                    {
                      p3.add(new JLabel("Detalle"));   
                     }
                    else
                      p3.add(new TransparentPanel());
                }
                 panel1.add(p3);
                        
               
            }
          //parte que indica el lugar y elagregado del campo detexto que muestra la descripcion del curso
            
            if(i == 5)
            {
            panel1.add(t);  
            }
             
            
            
              
            if( i==3 || i ==6 ||i==7||i==8|| i==9 )
                panel1.add(new TransparentPanel());
        }
        // parte que agrega un JTable para los costos del curso y los horarios
       JPanel panel2 =new TransparentPanel();
       panel2.setLayout(new BorderLayout());
       
       JPanel paneltablas = new TransparentPanel();
       paneltablas.setLayout(new GridLayout(1,2,7,7));
        //parte para agregar los costos
        
        //costos = new JTable(datosEjemplo1,titulos);
        costos = new JTable();
        tablaTitulos = new DefaultTableModel(null,hora);
        agregarFilas1();
        costos.setModel(tablaTitulos);
        //String[][] datosEjemplo1 = {{"1 persona","789"},{"grupo de 5","456"},{"grupo de 10","123"},{"Expositor","333"}};
        r = new JScrollPane(costos);
        paneltablas.add(r);
        r.setViewportView(costos);
        //parte para agregar los horarios,ambiente,fechas
        //String[][] ambiente = {{"ambiente 1","07:00","08:00",},{"ambiente 2","09:00","10:00"},{"ambiente 3","10:00","11:00"},{"ambiente 4","11:00","12:00"}};
        //horarios = new JTable(ambiente,hora);
        horarios = new JTable();
        tablaHora = new DefaultTableModel(null,titulos);
        agregarFilas2();
        horarios.setModel(tablaHora);
        s= new JScrollPane(horarios);
        paneltablas.add(s);
        s.setViewportView(horarios);
        panel2.add(paneltablas,BorderLayout.CENTER);
        //parte para agregar texto que describe las tablas
        JPanel panelTitulos = new TransparentPanel();
        panelTitulos.setLayout(new GridLayout(1,2));
        panelTitulos.add(new JLabel("Horarios",JLabel.CENTER));
        panelTitulos.add(new JLabel("Costos",JLabel.CENTER));
        panel2.add(panelTitulos,BorderLayout.NORTH);
        //parte que agrega texto y un boton de cerrar
        JPanel panelDescriptivo = new TransparentPanel();
        panelDescriptivo.setLayout(new GridLayout(1,2,7,7));
        panelDescriptivo.add(new JLabel("Ventana descriptiva de un curso",JLabel.LEFT));
        cerrarVentana = new JButton("Salir");
        JPanel panelBoton = new TransparentPanel();
        panelBoton.setLayout(new GridLayout(1,5));
        for(int d=1;d<=5;d++)
        {
            if(d==5)
            {
               panelDescriptivo.add(cerrarVentana);   
            }
            else
            {
                panelDescriptivo.add(new TransparentPanel());
            }
        }
       panel2.add(panelDescriptivo,BorderLayout.SOUTH);
       cerrarVentana.addActionListener(event);
       
        fondo.add(panel1);
        fondo.add(panel2);
        c.add(fondo);
        setVisible(true);
                
     }
    /*public static void main(String []args)
    {
    DescripcionSuperMejorada v = new DescripcionSuperMejorada();
    }
    //para cerrar la ventana
    */
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
         //System.exit(0);
        this.setVisible(false);
    }
    
    private void agregarFilas1()
    {
//            //String[][] resultados = control.obtenerHorarios(nombredelcurso)
            //Aqui deben entregarme un resultado de una consulta de la base de datos de los datos que les muestro en estos ejemplos y en ese orden
            String[] resultados1 = {"06/08/14","periodo 1","ambiente1"};
            String[] resultados2 = {"07/08/14","periodo 2","ambiente2"};
            String[] resultados3 = {"08/08/14","periodo 3","ambiente3"};
            tablaTitulos.addRow(resultados1);
            tablaTitulos.addRow(resultados2);
            tablaTitulos.addRow(resultados3);
    
    }

    private void agregarFilas2()
    {
        //Aqui deben entregarme un resultado de una consulta de la base de datos de los datos que les muestro en estos ejemplos y en ese orden
        String[] resultado1 = {"grupo de 2 personas","222"};
        String[] resultado2 = {"1 persona","111"};
        String[] resultado3 = {"grupo de 4 personas","333"};
        String[] resultado4 = {"patrociandor","0"};
        tablaHora.addRow(resultado1);
        tablaHora.addRow(resultado2);
        tablaHora.addRow(resultado3);
        tablaHora.addRow(resultado4);
    }
}