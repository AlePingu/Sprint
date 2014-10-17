package vista;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class VentanaConfirmacionCurso extends JDialog {
private JLabel titulo,fondo;
public JTable tabla;
public JScrollPane barra;
public DefaultTableModel modelo;
public JButton verDetalle,salir;
public VentanaConfirmacionCurso(String [] numero,String[] expositor,String [] cursos){
	
	setTitle("Cursos a Confirmar");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setLayout(null);
	
	
	titulo = new JLabel("Solicitudes Pendientes de Cursos");

	fondo = new JLabel();
    fondo.setBounds(0,0,800,600);
    ImageIcon fot = new ImageIcon("imagenes/2.jpg");
	Icon icono1 = new ImageIcon(fot.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
	fondo.setIcon(icono1);
	

	titulo.setFont(new Font("Arial Black", Font.BOLD, 20));
	
	modelo = new DefaultTableModel();
	tabla = new JTable(modelo);
	barra = new JScrollPane(tabla);
	
	modelo.addColumn("Numero de Peticion");
	modelo.addColumn("Expositor");
	modelo.addColumn("Curso");
	
	verDetalle = new JButton("Ver Detalle de Curso");
	     salir = new JButton("Salir");
	     
	     for(int i=0;i<numero.length;i++){
	    	 Object [] fila = new Object[3];
	    	 fila[0] = numero[i];
	    	 fila[1] = expositor[i];
	    	 fila[2] = cursos[i];
	    	 modelo.addRow ( fila );
	     }
	     
	     titulo.setBounds(200,10,450,50);
	      barra.setBounds(100,50,600,425);
	 verDetalle.setBounds(100,500,200,25);
	      salir.setBounds(550,500,150,50);
	      
	      add(titulo);
	      add(barra);
	      add(verDetalle);
	      add(salir);
	      add(fondo);
	      
	      setSize(800,600);
	      setLocationRelativeTo(null);
	      setVisible(true);
}


}
