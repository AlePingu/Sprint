package Controlador;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Mensaje;
import Vista.EditorAnuncio;
import Vista.VentanaAnuncios;
import Vista.VentanaPublicar;

public class ControladorPrincipal implements ActionListener
{
	private VentanaAnuncios v = null;
    private VentanaPublicar ve = null;
    private EditorAnuncio editor = null;
    private Mensaje m  = new Mensaje();
    
	public ControladorPrincipal() 
	{		
	    ve = new VentanaPublicar();
	    editor = new EditorAnuncio();
		editor.visible();
		VentanaEditoAnuncioHabilitarBotones();
		//VentanaPublicarHabilitarBotones();
		
	}
	private void VentanaPublicarHabilitarBotones()
	{
		this.ve.agregarCurso.addActionListener(this);
		this.ve.agregarAnuncio.addActionListener(this);
		this.ve.retirarAnuncio.addActionListener(this);
		this.ve.retirarCurso.addActionListener(this);
	}
	private void VentanaEditoAnuncioHabilitarBotones()
	{
		this.editor.aceptar.addActionListener(this);
		this.editor.cancelar.addActionListener(this);
		this.editor.registro.addActionListener(this);		
		this.editor.ver.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object boton = e.getSource();
		
		if (boton == this.ve.agregarAnuncio)
		{   		
			ve.setVisible(false);		    		   
		}
		if(boton == this.editor.cancelar)
		{
            editor.CerrarVentana();
		}
        if(boton==this.editor.registro)
        {          	 
        	 String[] mensaje;
        	 mensaje = editor.EnviarRegistro();  
        	 m.setMensaje(mensaje);        	
        }
        if(boton == this.editor.ver)
        {
        	editor.CerrarVentana();
       	    v =  new VentanaAnuncios(m);       	 
       	    v.Visible();
        }
	}
}
