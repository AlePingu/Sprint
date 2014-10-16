import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

//import Modelo.Mensaje;

import java.awt.Graphics;
public class EditorAnuncio extends JFrame
{
    private Controlador control;
    private Conexion conector;
    private JButton aceptar;
    private JButton cancelar;
    private JButton ver;
    private JTextArea campoTexto;
    private JButton registro;
    String[] base;

    public EditorAnuncio(Controlador c1, Conexion c2)
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
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        class OyenteRegistrar implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                control.registrarAnuncio(campoTexto.getText(), conector);
            }
        }

        class OyenteVer implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                control.activarVentanaAnuncios(conector);
                CerrarVentana();
            }
        }

        registro.addActionListener(new OyenteRegistrar());
        ver.addActionListener(new OyenteVer());

    }
    public void visible()
    {
        this.setVisible(true);
    }       
    public void CerrarVentana()
    {        
        this.setVisible(false);      
    }
    public String[] EnviarRegistro()
    {             
    	String texto = campoTexto.getText();
        base = texto.split("\n");               
        campoTexto.setText("");
        JOptionPane.showMessageDialog(rootPane,"Tu mensaje se publico exitosamente!");
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

    public static void main(String[] args) {
        EditorAnuncio e = new EditorAnuncio(new Controlador(), new Conexion());
    }
}
