package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.Mensaje;
import Vista.EditorAnuncio;
import Vista.ImagenFondo;
import Vista.VentanaAnuncios;
public class ControladorPrincipal implements ActionListener
{
	private VentanaAnuncios v = null;
    private EditorAnuncio editor = null;
    private Mensaje m  = new Mensaje();    
	public ControladorPrincipal() 
	{		
	    editor = new EditorAnuncio();
		editor.visible();
		VentanaEditoAnuncioHabilitarBotones();		
	}
	private void VentanaEditoAnuncioHabilitarBotones()
	{
		this.editor.insertarAnuncio.addActionListener(this);
		this.editor.cancelar.addActionListener(this);	
		this.editor.ver.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object boton = e.getSource();		
		if(boton == this.editor.cancelar)
		{
            editor.cerrarVentana();
		}
        if(boton==this.editor.insertarAnuncio)
        {          	 
        	 String[] mensaje;
        	 mensaje = editor.EnviarRegistro();  
        	 m.setMensaje(mensaje);        	
        }
        if(boton == this.editor.ver)
        {
        	editor.cerrarVentana();
       	    v =  new VentanaAnuncios(m);       	 
       	    v.Visible();
        }
	}
}