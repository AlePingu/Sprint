import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class detalleCurso extends JDialog {
	public JLabel titulo,curso,fondo;
	public JTable tabla;
	public JScrollPane barra;
    public DefaultTableModel modelo;
    public JButton salir,imprimir;
    
    public detalleCurso(String nombre,String[] nombreparticipante,String[] carnet,String[] monto,String[] tipoPago){
    	setTitle("Repote de curso");
    	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	setLayout(null);
    	
    	fondo = new JLabel();
        fondo.setBounds(0,0,800,600);
        ImageIcon fot = new ImageIcon("imagenes/2.jpg");
  	    Icon icono1 = new ImageIcon(fot.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
  	    fondo.setIcon(icono1);
    	
       titulo = new JLabel("REPORTE DE CURSO");	
    	curso = new JLabel("CURSO : "+nombre.toUpperCase());
    	
       modelo = new DefaultTableModel();
        tabla = new JTable(modelo);
        barra = new JScrollPane(tabla);
        
        salir = new JButton("Salir");
     imprimir = new JButton("Imprimir reporte");
     
     titulo.setFont(new Font("Arial Black", Font.BOLD, 20));
     curso.setFont(new Font("Arial Black", Font.BOLD, 15));
     
     modelo.addColumn("Participante");
     modelo.addColumn("Cedula Identidad");
     modelo.addColumn("Monto");
     modelo.addColumn("Tipo de Pago");
     
     for(int i=0;i<nombreparticipante.length;i++){
    	 Object [] fila = new Object[4];
    	 fila[0] = nombreparticipante[i];
    	 fila[1] = carnet[i];
    	 fila[2] = monto[i];
    	 fila[3] = tipoPago[i];
    	 modelo.addRow ( fila );
     }
    	titulo.setBounds(250,20,350,50);
    	 curso.setBounds(100,60,450,50);
     	 barra.setBounds(100,100,600,400);
      imprimir.setBounds(100,515,150,25);
         salir.setBounds(600,530,150,40);
         
         add(titulo);
         add(curso);
         add(barra);
         add(imprimir);
         add(salir);
         add(fondo);
         
         setSize(800,600);
         setLocationRelativeTo(null);
         setVisible(true);
    }
    public static void main(String[] args) {
		String [] nombre = {"denis parra","daniel torrez","laura delgadillo"};
		String [] carnet = {"111111111","22222222","3333333"};
		String [] monto = {"100","100","50"};
		String [] tipo = {"Estudiante","Expositor","Vip"};
		String curso = "Generacion de Software";
		new detalleCurso(curso,nombre, carnet, monto, tipo);
	}
}
