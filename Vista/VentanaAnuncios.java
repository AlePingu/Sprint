package Vista;

import javax.lang.model.element.Element;
import javax.swing.*;

import Modelo.Mensaje;

import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaAnuncios extends JFrame implements Runnable
{
 	JPanel panelOfertas = new JPanel();
 	JPanel panelAnuncios = new JPanel();
 	JTextArea m1,m2,m3,m4;
	JLabel imagenCaratula = new JLabel();
	Image fondo;
	Image caratula;
	Thread hiloPrincipal,hiloAnuncios;
	Mensaje m;
	private int cola=0;
	private int siguiente = 0;
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
			int y1=-17,y2=144,y3=305,y4=466;
			while(hiloAnuncios != null)
			{
				m1.setBounds(10,y1, 349, 150);
				m2.setBounds(10,y2, 349, 150);
				m3.setBounds(10,y3, 349, 150);
				m4.setBounds(10,y4, 349, 150);
				y1 = y1 + 1;
				y2 = y2 + 1;
				y3 = y3 + 1;
				y4 = y4 + 1;
				   if(y1 > 620)
				   {
					   y1 = -40;
					   					   
			  	   }
				   if(y2 > 620)
				   {
					   y2 = -40;
					   
			  	   }
				   if(y3 > 620)
				   {
					   y3 = -40;
					   
			  	   }
				   if(y4 > 620)
				   {
					   y4 = -40;
					   
			  	   }
				esperarTiempo(120);
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
	
	public VentanaAnuncios(Mensaje m)
	{
		super("Anuncios");
		this.m = m;
		setBounds(150,5,812,665);
		getContentPane().setLayout(null);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
        fondo = new ImageIcon(getClass().getResource("/Imagenes/fondo.jpg")).getImage().getScaledInstance(132,625, Image.SCALE_DEFAULT);
         
        panelOfertas.setBounds(0,0,416,627);
        panelOfertas.setBackground(new Color(102, 255, 204));
        panelOfertas.setLayout(null);
        
        
        imagenCaratula.setBounds(0,-288,451,424);
        caratula = new ImageIcon(getClass().getResource("/Imagenes/Bd.jpg")).getImage().getScaledInstance(414,407, Image.SCALE_DEFAULT);
        imagenCaratula.setIcon(new ImageIcon(caratula));

		
        
        panelAnuncios.setBounds(415,0,369,627);
        panelAnuncios.setBackground(Color.ORANGE);
        panelAnuncios.setLayout(null);
                              
        panelOfertas.add(imagenCaratula);
		getContentPane().add(panelOfertas);
		getContentPane().add(panelAnuncios);
		
		m1= new JTextArea();		
		m1.setBounds(10, -17, 349, 150);
		m1.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 16));
		m1.setEnabled(false);
		m1.setVisible(false);
		panelAnuncios.add(m1);
		
		m2 = new JTextArea();
		m2.setBounds(10, 144, 349, 150);
		m2.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 16));
		m2.setEnabled(false);
		m2.setVisible(false);
		panelAnuncios.add(m2);
		
		m3 = new JTextArea();
		m3.setBounds(10, 305, 349, 150);
		m3.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 16));
		m3.setEnabled(false);
		m3.setVisible(false);
		panelAnuncios.add(m3);
		
		m4 = new JTextArea();
		m4.setBounds(10, 466, 349, 150);
		m4.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 16));
		m4.setEnabled(false);
		m4.setVisible(false);
		panelAnuncios.add(m4);
	    
		cargarAnuncios();	
    }
    private void cargarAnuncios()
    {
    	ArrayList<String[]> p = m.getMensajes();
    	int tamaño = p.size();
    	System.out.println("tamaño lista "+tamaño);   	    	
    	String f="";
    	int con=1;    	
    	if(tamaño <=4)
    	{
    		 for(String[] string : p)
        	 {
    			 for(int y =0 ;y<string.length;y++)
            	 {
    				 f = f + string[y]+'\n';
    				 System.out.println(f);
            	 }
        	    CargarTextos(f,con);
        	    con ++;
        	 } 	
    	}
    	else
    	{
    		cola = tamaño;
    	}
    	  
    }
    private void CargarTextos(String q,int co)
    {
    	int j=0;
    	
    	if(co == 1)
    	{    		
    		
    		m1.setText(q);
    		m1.setVisible(true);
    	}    		
    	if(co == 2)
    	{
    		m2.setText(q); 	        
 		    m2.setVisible(true);
    	}
    	if(co == 3)
    	{
          m3.setText(q);
  		  m3.setVisible(true);
    	}	    	    		
    	if(co == 4)
    	{
 	        m4.setText(q);
 		    m4.setVisible(true);
    	}    	    		    			
    }
	public void Visible()
	{
		setVisible(true);
		IniciarHilo();
	}
}
