/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasdeinf2;

import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
public class ImagenFondo extends JPanel
{
    String dir;
    public ImagenFondo(String direccion)
    {
        dir = direccion;
    }
     @Override
     public void paintComponent(Graphics g)
     {
         Dimension tam=getSize();
         ImageIcon fondo=new ImageIcon(new ImageIcon(getClass().getResource(dir)).getImage());
         g.drawImage(fondo.getImage(),0,0,tam.width,tam.height,null);
     }
}