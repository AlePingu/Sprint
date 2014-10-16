import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class VentanaFormularioInscripcion extends JDialog 
{
   private JPanel panel; 
   private JTextField nombre,apellido,ci,dinero;
   public JButton inscribir,atras;
   private JLabel n,a,c,d;   
   private JComboBox comboBox;  
	public VentanaFormularioInscripcion() 
	{
		setSize(400,600);
		setLocation(160,40);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0,0,384,562);
		panel.setLayout(null);
		getContentPane().add(panel);
		
		nombre = new JTextField();		
		nombre.setBounds(207, 39, 86, 20);
		panel.add(nombre);		
		
		apellido = new JTextField();		
		apellido.setBounds(207, 99, 86, 20);
		panel.add(apellido);
				
		ci = new JTextField();		
		ci.setBounds(207, 159, 86, 20);
		panel.add(ci);		
		
		dinero = new JTextField();
		dinero.setBounds(218, 327, 86, 20);
		panel.add(dinero);
		dinero.setColumns(10);
		
		inscribir = new JButton("Inscribir");
		inscribir.setBounds(61, 507, 89, 23);
		panel.add(inscribir);
		
		atras = new JButton("Atras");
		atras.setBounds(272, 507, 89, 23);
		panel.add(atras);
		
		n = new JLabel("nombre(s) :");
		n.setBounds(104, 42, 93, 17);
		panel.add(n);
		
		a = new JLabel("apellidos :");
		a.setBounds(104, 102, 78, 17);
		panel.add(a);
		
		c = new JLabel("ci :");
		c.setBounds(104, 162, 78, 17);
		panel.add(c);
		
		d = new JLabel("Monto total cancelado :");
		d.setBounds(62, 329, 135, 17);
		panel.add(d);
		
		//String[] img= {"Ficha1","Ficha2","Ficha3","Ficha4"};
		comboBox = new JComboBox();
		comboBox.setBounds(207, 222, 86, 23);
		panel.add(comboBox);
		
		JLabel lblPromociones = new JLabel("Promociones");
		lblPromociones.setBounds(88, 225, 94, 20);
		panel.add(lblPromociones);
		
		
		
	}
	public void visible()
	{
		setVisible(true);
	}
}
