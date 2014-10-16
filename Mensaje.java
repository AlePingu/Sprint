package Modelo;

import java.util.ArrayList;

public class Mensaje 
{
 private ArrayList<String[]> mensajes = new ArrayList<String[]>();
	public Mensaje() 
	{	
	}
	public void setMensaje(String[] m)
	{
		mensajes.add(m);
	}
	public ArrayList<String[]> getMensajes()
	{
	   return mensajes;	
	}
}
