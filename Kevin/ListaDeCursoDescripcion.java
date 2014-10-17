/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
public class ListaDeCursoDescripcion extends JFrame
{
   private ArrayList<String> milista;
   private Controlador control;
   private Conexion conector;
   private String[] cursos;
   private JLabel titulo;
   private JPanel panelNumeros,panelCursos;
   private JButton botonSalir,botonAtras; 
   public JButton[] botones;
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
        llenarBotones();
        fondo.add(panelCursos,BorderLayout.CENTER);
        //agrego numeros al lado izquierdo para enumerar
       panelNumeros.setLayout(new GridLayout(milista.size(),1,20,20));
       for(int s=1;s<=milista.size();s++)
       {
          panelNumeros.add(new JLabel(String.valueOf(s)));
       }
       fondo.add(panelNumeros,BorderLayout.WEST);
       setVisible(true);
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
   
   //Alejandro aqui borras la parte con la conexion directamente trabajas con el resultSet,por favor te lo encargo, la ventana ya sabe lo que debe hacer,solo debes enviarle eso.
   public void llenarBotones() 
	 {
          try
            {
                 Class.forName("org.postgresql.Driver");//Es la clase que se usa para el driver
		 String url = "jdbc:postgresql://localhost:5432/prueba";//Ruta de la Base De Datos
		 Connection cn = DriverManager.getConnection(url,"postgres","publica");//Es la conexión con la BD
		 Statement st = cn.createStatement(); //Trae los datos
                 ResultSet rs = st.executeQuery("select * from costos");
                 System.out.println("conexion establecida");
                 milista = new ArrayList<String>();
                 int tam;
                
                 while(rs.next())
                 {
                     milista.add(rs.getString(1));
                 }
                tam = (int)Math.sqrt((double)milista.size());
               
                panelCursos.setLayout(new GridLayout(tam,tam,20,20));
                botones =new JButton[milista.size()];
                 int r=0;
                for(String s : milista)
                {
                   
                    botones[r] = new JButton(s);
                    panelCursos.add(botones[r]);
                    r=r+1;
                }
             //fondo.add(panelCursos,BorderLayout.CENTER);   
            }
            
                  
          catch(ClassNotFoundException ex)
	 	{
		 System.out.println("Error en el driver");
                }
	 catch (SQLException e) 
	 	{
		 System.out.println("Error en la conexion");
                }
	
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
    
}
