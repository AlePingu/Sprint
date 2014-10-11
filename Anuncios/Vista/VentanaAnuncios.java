package Vista;

import javax.lang.model.element.Element;
import javax.swing.*;
import Modelo.Mensaje;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
public class VentanaAnuncios extends JFrame implements Runnable
{
 	JPanel panelAnuncios = new JPanel();
 	JTextArea m1,m2,m3,m4,m5,m6,m7,m8;
	Thread hiloAnuncios;
	Mensaje m;
	private int cola=0;
	private int siguiente = 0;
	public void run()
	{
        if(Thread.currentThread() == hiloAnuncios)
		{
			int y1=-17,y2=144,y3=305,y4=466,y5=627,y6=788,y7=949 ,y8=1110;
			while(hiloAnuncios != null)
			{
				m1.setBounds(10,y1, 349, 150);
				m2.setBounds(10,y2, 349, 150);
				m3.setBounds(10,y3, 349, 150);
				m4.setBounds(10,y4, 349, 150);
				m5.setBounds(10,y5, 349, 150);
				m6.setBounds(10,y6, 349, 150);
				m7.setBounds(10,y7, 349, 150);
				m8.setBounds(10,y8, 349, 150);
				y1 = y1 + 1;
				y2 = y2 + 1;
				y3 = y3 + 1;
				y4 = y4 + 1;
				y5 = y5 + 1;
				y6 = y6 + 1;
				y7 = y7 + 1;
				y8 = y8 + 1;
				   if(y1 > 1240)
				   {
					   y1 = -40;
					   					   
			  	   }
				   if(y2 > 1240)
				   {
					   y2 = -40;
					   
			  	   }
				   if(y3 > 1240)
				   {
					   y3 = -40;
					   
			  	   }
				   if(y4 > 1240)
				   {
					   y4 = -40;
					   
			  	   }
			  	   if(y5 > 1240)
				   {
					   y5 = -40;
					   
			  	   }
			  	   if(y6 > 1240)
				   {
					   y6 = -40;
					   
			  	   }
			  	   if(y7 > 1240)
				   {
					   y7 = -40;
					   
			  	   }
			  	   if(y8 > 1240)
				   {
					   y8 = -40;
					   
			  	   }
				esperarTiempo(60);
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
		setBounds(150,5,374,657);
		getContentPane().setLayout(null);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);         
        
        panelAnuncios.setBounds(0,0,369,627);
        panelAnuncios.setBackground(Color.ORANGE);
        panelAnuncios.setLayout(null);
                              
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
		
		m5= new JTextArea();		
		m5.setBounds(10, -17, 349, 150);
		m5.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 16));
		m5.setEnabled(false);
		m5.setVisible(false);
		panelAnuncios.add(m5);
		
		m6= new JTextArea();		
		m6.setBounds(10, -17, 349, 150);
		m6.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 16));
		m6.setEnabled(false);
		m6.setVisible(false);
		panelAnuncios.add(m6);
		
		m7= new JTextArea();		
		m7.setBounds(10, -17, 349, 150);
		m7.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 16));
		m7.setEnabled(false);
		m7.setVisible(false);
		panelAnuncios.add(m7);
		
		m8= new JTextArea();		
		m8.setBounds(10, -17, 349, 150);
		m8.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 16));
		m8.setEnabled(false);
		m8.setVisible(false);
		panelAnuncios.add(m8);
	    
		cargarAnuncios();	
    }
    private void cargarAnuncios()
    {
    	ArrayList<String[]> p = m.getMensajes();
    	int tamaño = p.size();
    	System.out.println("tamaño lista "+tamaño);   	    	
    	String f="";
    	int con=1;    	
    	if(tamaño <=8)
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
        	    f="";
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
    	if(co == 5)
    	{
 	        m5.setText(q);
 		    m5.setVisible(true);
    	}
    	if(co == 6)
    	{
 	        m6.setText(q);
 		    m6.setVisible(true);
    	}
    	if(co == 7)
    	{
 	        m7.setText(q);
 		    m7.setVisible(true);
    	}
    	if(co == 8)
    	{
 	        m8.setText(q);
 		    m8.setVisible(true);
    	}
    }
	public void Visible()
	{
		setVisible(true);
		IniciarHilo();
	}
}