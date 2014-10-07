/**
 * Ventana para insertar anuncios-solamente interfaz por el momento
 * 
 * @author Willy Sanchez Rojas 
 * @version 1.1
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.awt.Graphics;
public class EditorAnuncio extends JFrame
{
    JButton aceptar;
    JButton cancelar;
    JTextArea campoTexto;
    JButton registro;
    String[] base;
    public EditorAnuncio()
    {
        base=new String[10];
        Action evento= new Action();
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
        aceptar.addActionListener(evento);
        
        
        cancelar=new JButton("Cancelar");
        contraints.gridx=2;
        contraints.gridy=1;
        contraints.gridwidth=1;
        contraints.gridheight=1;
        contraints.fill=GridBagConstraints.NORTHWEST;
        contraints.weighty=1.0;
        this.getContentPane().add(cancelar,contraints);
        contraints.weighty=0.0;
        cancelar.addActionListener(evento);
        
        registro=new JButton("Ver Registro");
        contraints.gridx=1;
        contraints.gridy=2;
        contraints.gridwidth=1;
        contraints.gridheight=1;
        contraints.fill=GridBagConstraints.NORTH;
        contraints.weightx=0.5;
        this.getContentPane().add(registro,contraints);
        contraints.weightx=0.0;
        registro.addActionListener(evento);
        
        contraints.gridx=0;
        contraints.gridy=0;
        contraints.gridwidth=3;
        contraints.gridheight =3;
        contraints.fill=GridBagConstraints.BOTH;
        this.getContentPane().add(fondo,contraints);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[]args)
    {
        new EditorAnuncio();
    }
    public class Action implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==aceptar)
            insertarTexto();
            if(e.getSource()==cancelar)
            cerrarVentana();
            if(e.getSource()==registro)
            mostrarRegistro();
        }
    }
    public void insertarTexto()
    {
        for(int i=0;i<10;i++)
        {
            if(base[i]==null){
               base[i]=campoTexto.getText();
               campoTexto.setText("");
               JOptionPane.showMessageDialog(rootPane,"Tu mensaje se publicó exitosamente!");
               break;
            }
        }
    }
    public void cerrarVentana()
    {        
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void mostrarRegistro()
    {
        for(int i=0;i<10;i++)
        {
            if(base[i]!=null)
            System.out.println(base[i]);
        }
    }
    public class ImagenFondo extends JPanel
    {
        @Override
        public void paintComponent(Graphics g)
        {
            Dimension tam=getSize();
            ImageIcon fondo=new ImageIcon(new ImageIcon(getClass().getResource("/fondo.jpg")).getImage());
            g.drawImage(fondo.getImage(),0,0,tam.width,tam.height,null);
        }
    }
}
