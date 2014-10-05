package Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.VentanaAnuncios;
import Vista.VentanaPublicar;

class Principal
{
	    
	public static void main(String[] args)
	{
		VentanaAnuncios v =  new VentanaAnuncios();
	    VentanaPublicar ve = new VentanaPublicar();
		ControladorPrincipal p = new ControladorPrincipal(v, ve);		
	}

}