/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;
import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class DetalleCursoDisponibleo extends JFrame
{
    private JTable horarios;
    private JTable costos;
    public JTextField nombreCurso;
    private JTextArea detalleCurso;
    private JScrollPane r,s,t;
    private String[] montos = {"Tipo de Pago","Costo"};
    private String[] hora = {"Fecha","Periodo","Ambiente","instructor"};
    private JButton cerrarVentana;
    private String[] periodos = {"8:15-9:45","9:45-11:15","11:15-12:45","12:45-14:15","14:15-15:45","15:45-17:15","17:15-18:45","18:45-20:15"};
    private DefaultTableModel tablaHoras;
    private DefaultTableModel tablaMontos;
    private String descripcionC;
    TransparentPanel fondo = new TransparentPanel();
    public DetalleCursoDisponible(String curso)
    {
        super("Detalle del Curso");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container c = getContentPane();
        fondo.setBackgroundImage(fondo.createImage("/Imagenes/2.jpg").getImage());
        fondo.setLayout(new GridLayout(2,1));
        Action event= new Action();
        JPanel panel1 = new TransparentPanel();
        panel1.setLayout(new GridLayout(3,3));
        tablaMontos = new DefaultTableModel(null,periodos);
        nombreCurso= new JTextField();
        nombreCurso.setEditable(false);
        nombreCurso.setText(curso);
        llenarDescripcion();
        detalleCurso = new JTextArea(descripcionC);
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
        costos = new JTable();
        tablaHoras = new DefaultTableModel(null,hora);
         llenarHorarios();
        costos.setModel(tablaHoras);
        r = new JScrollPane(costos);
        paneltablas.add(r);
        r.setViewportView(costos);
        //parte para agregar los horarios,ambiente,fechas
        horarios = new JTable();
        tablaMontos = new DefaultTableModel(null,montos);
        //agregarFilas2();
        llenarMontos();
        horarios.setModel(tablaMontos);
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
    //lo mismo aqui tambien, tienes que hacer la consulta  
    public void llenarMontos() 
	 {
            try
            {
                 Class.forName("org.postgresql.Driver");//Es la clase que se usa para el driver
		 String url = "jdbc:postgresql://localhost:5432/prueba";//Ruta de la Base De Datos
		 Connection cn = DriverManager.getConnection(url,"postgres","publica");//Es la conexión con la BD
		 Statement st = cn.createStatement(); //Trae los datos
                 ResultSet rs = st.executeQuery("select * from costos");
                 //System.out.println("conexion establecida");
                 ResultSetMetaData rsMd = rs.getMetaData();
                 int cantidadColumnas = rsMd.getColumnCount();

                   while(rs.next())
                    {
                        Object[] fila = new Object[cantidadColumnas];
                        for (int i = 0; i < cantidadColumnas; i++) 
                        {
                          fila[i]=rs.getObject(i+1);
                        }
                        tablaMontos.addRow(fila);
                    }
               }
                  
          catch(ClassNotFoundException ex)
	 	{
		 System.out.println("Error en el driver");
                }
	 catch (SQLException e) 
	 	{
		 System.out.println("Error en laconexion");
                }
	
         }
    public void llenarHorarios() 
	 {
            try
            {
                 Class.forName("org.postgresql.Driver");//Es la clase que se usa para el driver
		 String url = "jdbc:postgresql://localhost:5432/prueba";//Ruta de la Base De Datos
		 Connection cn = DriverManager.getConnection(url,"postgres","publica");//Es la conexión con la BD
		 Statement st = cn.createStatement(); //Trae los datos
                 ResultSet rs = st.executeQuery("select * from horarios");
                 //System.out.println("conexion establecida");
                 ResultSetMetaData rsMd = rs.getMetaData();
                 int cantidadColumnas = rsMd.getColumnCount();

                   while(rs.next())
                    {
                        Object[] fila = new Object[cantidadColumnas];
                        for (int i = 0; i < cantidadColumnas; i++) 
                        {
                          fila[i]=rs.getObject(i+1);
                        }
                        tablaHoras.addRow(fila);
                    }
               }
                  
          catch(ClassNotFoundException ex)
	 	{
		 System.out.println("Error en el driver");
                }
	 catch (SQLException e) 
	 	{
		 System.out.println("Error en laconexion");
                }
	
         } 
     public void llenarDescripcion() 
	 {
            try
            {
                 Class.forName("org.postgresql.Driver");//Es la clase que se usa para el driver
		 String url = "jdbc:postgresql://localhost:5432/prueba";//Ruta de la Base De Datos
		 Connection cn = DriverManager.getConnection(url,"postgres","publica");//Es la conexión con la BD
		 Statement st = cn.createStatement(); //Trae los datos
                 ResultSet rs = st.executeQuery("select * from descripcion");
                 System.out.println("conexion establecida");
                 descripcionC = rs.getString(1);
                
                  
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
        String tex = "curso 1";
        DetalleCursoDisponible v = new DetalleCursoDisponible(tex);
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
         
        this.setVisible(false);
    }
 
}
