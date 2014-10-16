package vista;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class detalleEconomicoCursos extends JDialog {
private JLabel titulo,fondo;
public JButton detalle,imprimir,salir;
public JTable tabla;
public DefaultTableModel modelo;
public JScrollPane barra;
public detalleEconomicoCursos(String [] cursos,String [] inscritos,String [] montoRecaudado){
	setTitle("Detalle de Cursos");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setLayout(null);
	
	fondo = new JLabel();
    fondo.setBounds(0,0,800,600);
    ImageIcon fot = new ImageIcon("imagenes/2.jpg");
    Icon icono1 = new ImageIcon(fot.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
	fondo.setIcon(icono1);
	titulo = new JLabel("DETALLE DE CURSOS VIGENTES");
   detalle = new JButton("Mostrar detalle de curso");
  imprimir = new JButton("Imprimir tabla");
     salir = new JButton("Salir");
    modelo = new DefaultTableModel();
     tabla = new JTable(modelo);
     barra = new JScrollPane(tabla);
     
     modelo.addColumn("Curso");
     modelo.addColumn("Inscritos");
     modelo.addColumn("Monto Recaudado");
     

     titulo.setFont(new Font("Arial Black", Font.BOLD, 20));
     
     titulo.setBounds(200,10,450,50);
      barra.setBounds(100,60,600,400);
    detalle.setBounds(100,475,250,25);
   imprimir.setBounds(400,475,150,25);
      salir.setBounds(600,500,150,40);
      
      add(titulo);
      add(barra);
      add(detalle); 
	  add(imprimir);
	  add(salir);
	  add(fondo);
	  setSize(800,600);
	  setLocationRelativeTo(null);
	  setVisible(true);
}

}
