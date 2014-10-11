package Vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaOpcionesOrganizador extends JDialog 
{
	public JButton anuncio,retirarA,retirarC,curso,patrocinador;
    private JLabel mensaje1,mensaje2,mensaje3;
    private JPanel principal;
    private JButton btnNewButton;
  
	public VentanaOpcionesOrganizador() 
	{		
		setSize(550,500);
		setLocation(100,150);
		getContentPane().setLayout(null);
		
		principal = new JPanel();
		principal.setBounds(0,0,534,462);
		principal.setLayout(null);		
		getContentPane().add(principal);
		
		anuncio = new JButton("insertar nuevo anuncio");
		anuncio.setBounds(48, 173, 160, 23);
		principal.add(anuncio);
		
		curso = new JButton("nuevo curso");
		curso.setBounds(48, 239, 160, 23);
		principal.add(curso);
		
		retirarA = new JButton("retirar anuncio");
		retirarA.setBounds(48, 299, 160, 23);
		principal.add(retirarA);
		
		retirarC= new JButton("retirar curso");
		retirarC.setBounds(48, 365, 160, 23);
		principal.add(retirarC);
		
		patrocinador = new JButton("nuevo patrocinador");
		patrocinador.setBounds(48, 113, 160, 23);
		principal.add(patrocinador);
		
	}
	public void visible()
	{
		setVisible(true);
	}
}
