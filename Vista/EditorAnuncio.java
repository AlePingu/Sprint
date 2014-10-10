package Vista;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

import Modelo.Mensaje;

import java.awt.Graphics;
public class EditorAnuncio extends JFrame
{
   public  JButton aceptar;
   public JButton cancelar;
   public JButton ver;
   public  JTextArea campoTexto;
   public  JButton registro;
   String[] base;

    public EditorAnuncio()
    {
        base=new String[10];        
        ImagenFondo fondo = new ImagenFondo();
        campoTexto=new JTextArea();
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints contraints = new GridBagConstraints();
        this.setSize(700,400);
                        
        contraints.gridx = 0;
        contraints.gridy=0;
        contraints.gridwidth =2;
        contraints.gridheight =2;
        contraints.fill=GridBagConstraints.BOTH;
        contraints.weighty=1.0;
        contraints.weightx=0.5;
        this.getContentPane().add(campoTexto,contraints);
        contraints.weighty=0.0;
        contraints.weightx=0.0;
        
        
        aceptar=new JButton("Aceptar");
        contraints.gridx=2;
        contraints.gridy=0;
        contraints.gridwidth=1;
        contraints.gridheight=1;
        contraints.fill=GridBagConstraints.NORTHWEST;
        contraints.weighty=1.0;
        this.getContentPane().add(aceptar,contraints);
        contraints.weighty=0.0;
        
        ver = new JButton("Ver anuncios");
        contraints.gridx=2;
        contraints.gridy=3;
        contraints.gridwidth=1;
        contraints.gridheight=1;
        contraints.fill=GridBagConstraints.NORTHWEST;
        contraints.weighty=1.0;
        this.getContentPane().add(ver,contraints);
        contraints.weighty=0.0;
        
        
        cancelar=new JButton("Cancelar");
        contraints.gridx=2;
        contraints.gridy=1;
        contraints.gridwidth=1;
        contraints.gridheight=1;
        contraints.fill=GridBagConstraints.NORTHWEST;
        contraints.weighty=1.0;
        this.getContentPane().add(cancelar,contraints);
        contraints.weighty=0.0;

        
        registro=new JButton("insertar Anuncios");
        contraints.gridx=1;
        contraints.gridy=2;
        contraints.gridwidth=1;
        contraints.gridheight=1;
        contraints.fill=GridBagConstraints.NORTH;
        contraints.weightx=0.5;
        this.getContentPane().add(registro,contraints);
        contraints.weightx=0.0;
        
        contraints.gridx=0;
        contraints.gridy=0;
        contraints.gridwidth=3;
        contraints.gridheight =3;
        contraints.fill=GridBagConstraints.BOTH;
        this.getContentPane().add(fondo,contraints);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void visible()
    {
        this.setVisible(true);
    }       
    public void CerrarVentana()
    {        
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public String[] EnviarRegistro()
    {             
    	String texto = campoTexto.getText();
        base = texto.split("\n");               
        campoTexto.setText("");
        JOptionPane.showMessageDialog(rootPane,"Tu mensaje se publicó exitosamente!");
        return base;
    }
    public class ImagenFondo extends JPanel
    {
        @Override
        public void paintComponent(Graphics g)
        {
            Dimension tam=getSize();
            ImageIcon fondo=new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/fondo.jpg")).getImage());
            g.drawImage(fondo.getImage(),0,0,tam.width,tam.height,null);
        }
    }
}
