/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;


import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class TransparentPanel extends JPanel 
{
    private Image miImagen;
 
 public TransparentPanel() 
 {
  super();
   //Hacemos que el panel sea transparente
  this.setOpaque(false);
 }
  // Lo utilizaremos para establecerle su imagen de fondo
 
 public void setBackgroundImage(Image miImagen) 
 {
  this.miImagen = miImagen;
 }
 //Para recuperar una imagen de un archivo y verificar su ruta
 public ImageIcon createImage(String path) 
 {
  URL imgURL = getClass().getResource(path);
     if (imgURL != null)
     {
         return new ImageIcon(imgURL);
     } 
     else 
     {
         System.err.println("No lo encuentro: " + path);
         return null;
     }
 }
 
    @Override
   public void paint(Graphics g) 
     {
    // Pintamos la imagen de fondo
    if(miImagen != null) 
    {
    Dimension tam=getSize();
    g.drawImage(miImagen, 0, 0,tam.width,tam.height,null);
     }
    // Y pintamos el resto de cosas que pueda tener el panel
    super.paint(g);
 
    }
}
