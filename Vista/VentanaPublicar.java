package Vista;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class VentanaPublicar extends JDialog
{
	JPanel panelPrincipal;
	public JButton agregarCurso,agregarAnuncio,retirarAnuncio,retirarCurso;
	
	public VentanaPublicar() 
	{
	   setBounds(100,150,600,500);
	   setLayout(null);

	   
	   panelPrincipal= new JPanel();
	   panelPrincipal.setBounds(0, 0, 584, 462);
	   panelPrincipal.setLayout(null);
	   	   
	   add(panelPrincipal);
	   
	   agregarCurso = new JButton(" Agregar curso");
	   agregarCurso.setBounds(36, 124, 150, 23);
	   panelPrincipal.add(agregarCurso);
	   
	   agregarAnuncio = new JButton("Agregar Anuncio");
	   agregarAnuncio.setBounds(36, 196, 150, 23);
	   panelPrincipal.add(agregarAnuncio);
	   
	   retirarCurso = new JButton("Retirar curso");
	   retirarCurso.setBounds(36, 257, 150, 23);
	   panelPrincipal.add(retirarCurso);	   
	   
	   retirarAnuncio = new JButton("New button");
	   retirarAnuncio.setBounds(36, 325, 150, 23);
	   panelPrincipal.add(retirarAnuncio);
	   
	}

	public void Visible()
	{
		setVisible(true);
	}
}
