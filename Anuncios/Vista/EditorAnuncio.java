package Vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.IOException;
public class EditorAnuncio extends JFrame
{
    public JButton insertarAnuncio;
    public JButton cancelar;
    public JTextArea campoTexto;
    public JButton ver;
    //public JButton registro;
    public String[] base;
    //public JButton cargarImagen;
    //public Image anuncioImagen;
    public EditorAnuncio()
    {
        base=new String[10];
       // Action evento= new Action();
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
        
        
        insertarAnuncio=new JButton("Insertar Anuncio");
        contraints.gridx=2;
        contraints.gridy=0;
        contraints.gridwidth=1;
        contraints.gridheight=1;
        contraints.fill=GridBagConstraints.SOUTH;
        contraints.weighty=1.0;
        this.getContentPane().add(insertarAnuncio,contraints);
        contraints.weighty=0.0;
        //insertarAnuncio.addActionListener(evento);
        
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
        contraints.fill=GridBagConstraints.NORTH;
        contraints.weighty=1.0;
        this.getContentPane().add(cancelar,contraints);
        contraints.weighty=0.0;
        //cancelar.addActionListener(evento);
        
        /**registro=new JButton("Ver Registro");
        contraints.gridx=2;
        contraints.gridy=2;
        contraints.gridwidth=1;
        contraints.gridheight=1;
        contraints.fill=GridBagConstraints.NORTHWEST;
        this.getContentPane().add(registro,contraints);
        contraints.weightx=0.0;
        registro.addActionListener(evento);
        
        cargarImagen=new JButton("Cargar Imagen");
        contraints.gridx=1;
        contraints.gridy=2;
        contraints.gridwidth=1;
        contraints.gridheight=1;
        contraints.fill=GridBagConstraints.NORTH;
        contraints.weighty=0.5;
        this.getContentPane().add(cargarImagen,contraints);
        contraints.weightx=0.0;
        cargarImagen.addActionListener(evento);*/
        
        contraints.gridx=0;
        contraints.gridy=0;
        contraints.gridwidth=3;
        contraints.gridheight =4;
        contraints.fill=GridBagConstraints.BOTH;
        this.getContentPane().add(fondo,contraints);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    /**public class Action implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==insertarAnuncio)
            insertarTexto();
            if(e.getSource()==cancelar)
            cerrarVentana();
            //if(e.getSource()==registro)
            //mostrarRegistro();
            //if(e.getSource()==cargarImagen)
            //subirImagen();
        }
    }*/
    public void insertarTexto()
    {
            for(int i=0;i<10;i++)
            {
                if(base[i]==null){
                 base[i]=campoTexto.getText();
                 JOptionPane.showMessageDialog(rootPane,"Tu mensaje se publicó exitosamente!");
                 campoTexto.setText("");
                 break;
                }
            }
    }
    public void visible()
    {
        this.setVisible(true);
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
    /**public void subirImagen()
    {
        JFileChooser j=new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado=j.showOpenDialog(null);
        if(estado== JFileChooser.APPROVE_OPTION){
                try {
                    anuncioImagen=ImageIO.read(j.getSelectedFile());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "imagen: "+ex);
                }
        }
    }
    public Image getAnuncioImagen()
    {
        return anuncioImagen;
    }*/
    public String[] EnviarRegistro()
    {             
    	String texto = campoTexto.getText();
        base = texto.split("\n");               
        campoTexto.setText("");
        JOptionPane.showMessageDialog(rootPane,"Tu mensaje se publicó exitosamente!");
        return base;
    }
}
    /**public String[] EnviarRegistro()
    {             
    	String texto = campoTexto.getText();
        base = texto.split("\n");               
        campoTexto.setText("");
        JOptionPane.showMessageDialog(rootPane,"Tu mensaje se publicó exitosamente!");
        return base;
    }*/