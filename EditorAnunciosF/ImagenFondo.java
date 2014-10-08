
/**
 * Write a description of class ImagenFondo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
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