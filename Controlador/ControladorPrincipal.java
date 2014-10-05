package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.VentanaAnuncios;
import Vista.VentanaPublicar;

public class ControladorPrincipal implements ActionListener
{
	private VentanaAnuncios v = null;
    private VentanaPublicar ve = null;
	public ControladorPrincipal(VentanaAnuncios v,VentanaPublicar ve) 
	{
		this.v=v;
		this.ve=ve;
		ve.Visible();
		HabilitarBotones();
		
	}
	private void HabilitarBotones()
	{
		this.ve.agregarCurso.addActionListener(this);
		this.ve.agregarAnuncio.addActionListener(this);
		this.ve.retirarAnuncio.addActionListener(this);
		this.ve.retirarCurso.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object boton = e.getSource();
		if (boton == this.ve.agregarAnuncio)
		{   		
			ve.setVisible(false);		    		   
		}
	}
}
