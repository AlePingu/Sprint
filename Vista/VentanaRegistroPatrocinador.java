package Vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class VentanaRegistroPatrocinador extends JDialog 
{
   private JTextField nombre,descripcion;
   public JButton registrar,atras;
   private JPanel panel;
   private JLabel n,d;   
	public VentanaRegistroPatrocinador() 
	{
         setSize(400,300);
         setLocation(100,100);
         getContentPane().setLayout(null);
         
         panel = new JPanel();
         panel.setBounds(0,0,384,262);
         panel.setLayout(null);
         getContentPane().add(panel);         
         
         nombre = new JTextField();         
         nombre.setBounds(128, 65, 164, 20);
         panel.add(nombre);         
         
         descripcion = new JTextField();
         descripcion.setBounds(128, 117, 164, 43);
         panel.add(descripcion);         
         
         registrar = new JButton("Registrar");
         registrar.setBounds(103, 171, 89, 23);
         panel.add(registrar);
         
         n = new JLabel("");
         n.setText("ingrese el nombre de \n la organizacion, empresa o persona");
         n.setBounds(23, 65, 93, 41);
         panel.add(n);
         
         d= new JLabel("descripcion :");
         d.setBounds(37, 117, 79, 20);
         panel.add(d);
         
         atras = new JButton("atras");
         atras.setBounds(281, 224, 89, 23);
         panel.add(atras);
	}
	public void visible()
	{
		setVisible(true);
	}

}
