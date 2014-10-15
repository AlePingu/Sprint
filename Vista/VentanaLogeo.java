package Vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaLogeo extends JDialog 
{
  public JButton aceptar,atras,recuperarCuenta;
  private JLabel n,c;
  private JTextField login,contraseña;
  JPanel panel;
  private JTextField textField;
  private JTextField textField_1;
	public VentanaLogeo() 
	{
		setSize(400,300);
		setLocation(100,150);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0,0,384,262);
		panel.setLayout(null);
		getContentPane().add(panel);
		
		aceptar = new JButton("aceptar");
		aceptar.setBounds(113, 164, 89, 23);
		panel.add(aceptar);
		
		atras = new JButton("atras");
		atras.setBounds(285, 228, 89, 23);
		panel.add(atras);
		
		recuperarCuenta = new JButton("recuperar cuenta");
		recuperarCuenta.setBounds(237, 186, 137, 23);
		panel.add(recuperarCuenta);
		
		textField = new JTextField();
		textField.setBounds(153, 93, 105, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 61, 106, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		n = new JLabel("Login");
		n.setBounds(39, 62, 86, 19);
		panel.add(n);
		
		c = new JLabel("Password");
		c.setBounds(39, 97, 86, 16);
		panel.add(c);
	}
	public void visible()
	{
		setVisible(true);
	}
}
