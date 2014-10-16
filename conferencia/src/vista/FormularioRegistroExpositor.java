package vista;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.text.MaskFormatter;


public class FormularioRegistroExpositor extends JDialog{
public JLabel titulo,nombreUsuario,pasword,repitePasword,email,nombre,direccion,pais,ciudad,telefono,fondo,tipoRegistro;
public  JTextField campoNombreUsuario,campoemail,camponombre,campodireccion,campopais,campociudad;
public JPasswordField campopasword,campoverificapasword;
public JButton verificaNombreUsuario,verificapasword,aceptar,cancelar;
public JFormattedTextField campoTelefono;
private MaskFormatter formatoTelefono;
public JComboBox tipo;
public FormularioRegistroExpositor(){
	setTitle("Formulario de Registro");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setLayout(null);
	
	fondo = new JLabel();
    fondo.setBounds(0,0,800,600);
    ImageIcon fot = new ImageIcon("imagenes/2.jpg");
	Icon icono1 = new ImageIcon(fot.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
	fondo.setIcon(icono1);
	
	       titulo = new JLabel("FORMULARIO DE REGISTRO");
	nombreUsuario = new JLabel("Nombre de Usuario : ");
	      pasword = new JLabel("Contaseña : ");
	repitePasword = new JLabel("Repite Contraseña :  ");
	        email = new JLabel("Correo Electronico : ");
	       nombre = new JLabel("Nombre : ");
	    direccion = new JLabel("Direccion : ");
	         pais = new JLabel("Pais : ");
	       ciudad = new JLabel("Ciudad : ");
	     telefono = new JLabel("Telefono : ");
	 tipoRegistro = new JLabel("Tipo de Registro : ");
	 String tiposdeRegistro [] = {"Expositor","Organizador","Personal"};
	         tipo = new JComboBox(tiposdeRegistro);
	      
	     try {
				formatoTelefono = new MaskFormatter("########");
				campoTelefono = new JFormattedTextField(formatoTelefono);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     titulo.setFont(new Font("Arial Black", Font.BOLD, 19));
  nombreUsuario.setFont(new Font("Arial Black", Font.BOLD, 17));
        pasword.setFont(new Font("Arial Black", Font.BOLD, 17));
  repitePasword.setFont(new Font("Arial Black", Font.BOLD, 17));
          email.setFont(new Font("Arial Black", Font.BOLD, 17));
         nombre.setFont(new Font("Arial Black", Font.BOLD, 17));
      direccion.setFont(new Font("Arial Black", Font.BOLD, 17));
           pais.setFont(new Font("Arial Black", Font.BOLD, 17));
         ciudad.setFont(new Font("Arial Black", Font.BOLD, 17));
       telefono.setFont(new Font("Arial Black", Font.BOLD, 17));
       tipoRegistro.setFont(new Font("Arial Black", Font.BOLD, 17));
       
       campoNombreUsuario = new JTextField(50);
               campoemail = new JTextField(50);
              camponombre = new JTextField(50);
           campodireccion = new JTextField(50);
                campopais = new JTextField(50);
              campociudad = new JTextField(50);
             campopasword = new JPasswordField();
     campoverificapasword = new JPasswordField();        
    verificaNombreUsuario = new JButton("Verificar Usuario");
          verificapasword = new JButton("Verificar Contraseña");
                  aceptar = new JButton("Aceptar");
                 cancelar = new JButton("Cancelar");
                 
                 titulo.setBounds(250,-5,550,50);
           tipoRegistro.setBounds(120,20,250,50);
                   tipo.setBounds(320,35,150,25);
          nombreUsuario.setBounds(100,60,250,50);
     campoNombreUsuario.setBounds(320,75,150,25);
  verificaNombreUsuario.setBounds(500,75,180,25);
                pasword.setBounds(186,120,150,50);
           campopasword.setBounds(320,135,150,25);
          repitePasword.setBounds(113,180,250,25);
   campoverificapasword.setBounds(320,180,150,25);
        verificapasword.setBounds(500,180,180,25);
                  email.setBounds(110,240,300,25);
             campoemail.setBounds(320,240,150,25);
                 nombre.setBounds(210,278,150,50);
            camponombre.setBounds(320,290,150,25);
              direccion.setBounds(197,340,150,50);
         campodireccion.setBounds(320,352,150,25);
                   pais.setBounds(248,390,150,50);
              campopais.setBounds(320,402,150,25);
                 ciudad.setBounds(224,440,150,50);
            campociudad.setBounds(320,452,150,25);
               telefono.setBounds(205,490,150,50);
          campoTelefono.setBounds(320,502,150,25);
                aceptar.setBounds(400,540,150,30);
               cancelar.setBounds(600,540,150,30);
	     
               add(titulo);
               add(tipoRegistro);
               add(tipo);
               add(nombreUsuario);
               add(campoNombreUsuario);
               add(verificaNombreUsuario);
               add(pasword);
               add(campopasword);
               add(repitePasword);
               add(campoverificapasword);
               add(verificapasword);
               add(email);
               add(campoemail);
               add(nombre);
               add(camponombre);
               add(direccion);
               add(campodireccion);
               add(pais);
               add(campopais);
               add(ciudad);
               add(campociudad);
               add(telefono);
               add(campoTelefono);
               add(aceptar);
               add(cancelar);
               add(fondo);
               setSize(800,600);
               setLocationRelativeTo(null);
}
public void esVisible()
{
	setVisible(true);
}
}
