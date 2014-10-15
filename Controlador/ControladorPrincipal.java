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
import Vista.VentanaOpcionesOrganizador;
import Vista.VentanaRegistroPatrocinador;

public class ControladorPrincipal implements ActionListener
{
	private VentanaAnuncios v = null;
    private VentanaOpcionesOrganizador org = new VentanaOpcionesOrganizador();
    private EditorAnuncio editor = new EditorAnuncio();
    private Mensaje m  = new Mensaje();
    private VentanaRegistroPatrocinador registro = new VentanaRegistroPatrocinador();
	public ControladorPrincipal() 
	{			    	    		
		org.visible();
		VentanaOrganizadorHabilitarBotones();		
	}
	private void VentanaOrganizadorHabilitarBotones()
	{
		this.org.anuncio.addActionListener(this);
		this.org.curso.addActionListener(this);
		this.org.retirarA.addActionListener(this);
		this.org.retirarC.addActionListener(this);	
		this.org.patrocinador.addActionListener(this);
	}
	private void VentanaEditoAnuncioHabilitarBotones()
	{
		this.editor.aceptar.addActionListener(this);
		this.editor.cancelar.addActionListener(this);
		this.editor.registro.addActionListener(this);		
		this.editor.ver.addActionListener(this);
	}
	private void VentanaRegistroPtracinadorHabilitarBotones()
	{
		this.registro.registrar.addActionListener(this);
		this.registro.atras.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object boton = e.getSource();
		
		if (boton == this.org.anuncio)
		{   		
			org.setVisible(false);
			editor = new EditorAnuncio();
			editor.visible();		
			VentanaEditoAnuncioHabilitarBotones();				
		}
		if (boton == this.org.patrocinador)
		{   		
			org.setVisible(false);
			registro.visible();		
			VentanaRegistroPtracinadorHabilitarBotones();				
		}
		if(boton == this.registro.atras)
		{
			registro.setVisible(false);
			org.visible();
		}
		if(boton == this.editor.cancelar)
		{
            editor.CerrarVentana();
            org.setVisible(true);
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
