package Vista;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class VentanaAnuncios extends JFrame implements Runnable
{         
	
 	JPanel panelReferencia = new JPanel();
 	JPanel panelOfertas = new JPanel();
 	JPanel panelAnuncios = new JPanel();
	JLabel imagenFondo = new JLabel();
	JTextArea mensaje = new JTextArea();
	JLabel imagenCaratula = new JLabel();
	Image fondo;
	Image caratula;
	Thread hiloPrincipal,hiloAnuncios;
	public void run()
	{

		if(Thread.currentThread() == hiloPrincipal)//esto es una condicional q si 
		{
			int y=-300;
		   while(hiloPrincipal != null)
		   {			
			   if(y < 620)
			   {
				   imagenCaratula.setBounds(0,y,414,407); // 620 tope
				   y =y+1;
					esperarTiempo(120);   
			   }
			   else
			   {
				   y=-300;
			   }									
		   }
	    }
		else if(Thread.currentThread() == hiloAnuncios)
		{
			int y=0;
			while(hiloAnuncios != null)
			{
			   if(y > -170)
			   {
				    mensaje.setBounds(0,y,238,177);
					y = y - 1;
					esperarTiempo(120);
		  	   }
			   else			   
			   {
				   y = 627;
			   }
			}			
		}
     }	
	 private void esperarTiempo(int tiempo)
	 {
		try
		{
			Thread.sleep(tiempo);
		}
		catch(InterruptedException e)
		{
			System.out.println("ERROR "+e);
		}
	 }	   
	private void IniciarHilo()
	{
		if(hiloPrincipal == null)
		{
			hiloPrincipal = new Thread(this);
			hiloPrincipal.setPriority(1);
			hiloPrincipal.start(); 
		}
		if(hiloAnuncios == null)
		{
			hiloAnuncios = new Thread(this);
			hiloAnuncios.setPriority(1);
			hiloAnuncios.start();
		}
	}
	
	public VentanaAnuncios()
	{
		super("Anuncios");
		
		setBounds(150,5,812,665);
		getContentPane().setLayout(null);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		panelReferencia.setLayout(null);
		panelReferencia.setBounds(0,0, 132,627);
		panelReferencia.setBackground(Color.BLUE);
		panelReferencia.setLayout(null);

        imagenFondo.setBounds(0,0,132,625);
        fondo = new ImageIcon(getClass().getResource("/Imagenes/fondo.jpg")).getImage().getScaledInstance(132,625, Image.SCALE_DEFAULT);
        imagenFondo.setIcon(new ImageIcon(fondo));
         
        panelOfertas.setBounds(131,0,414,627);
        panelOfertas.setBackground(Color.ORANGE);
        panelOfertas.setLayout(null);
        
        
        imagenCaratula.setBounds(0,-392,414,407);
        caratula = new ImageIcon(getClass().getResource("/Imagenes/Bd.jpg")).getImage().getScaledInstance(414,407, Image.SCALE_DEFAULT);
        imagenCaratula.setIcon(new ImageIcon(caratula));

        panelAnuncios.setBounds(546,0,238,627);
        panelAnuncios.setBackground(Color.ORANGE);
        panelAnuncios.setLayout(null);
        

        mensaje.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 16));
		mensaje.setText("          ' Anuncio ' \n   Curso:    \n   Asunto: \n   Fecha:  ");		
		mensaje.setEnabled(false);
        mensaje.setBounds(0,0,238,177);
        
        panelAnuncios.add(mensaje);
        panelOfertas.add(imagenCaratula);
        panelReferencia.add(imagenFondo); 		
         
		getContentPane().add(panelReferencia);
		getContentPane().add(panelOfertas);
		getContentPane().add(panelAnuncios);

		
		
		
    }
	public void Visible()
	{
		setVisible(true);
		IniciarHilo();
	}
}
