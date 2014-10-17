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

import vista.DetalleCursoDisponible;
import vista.EditorAnuncio;
import vista.FormularioRegistroExpositor;
import vista.ListaDeCursoDescripcion;
import vista.VentanaAnuncios;
import vista.VentanaLogeo;
import vista.VentanaOrganizador;
import vista.VentanaPrincipal;
import vista.VentanaRegistroPatrocinador;
import vista.nuevoCurso;



public class ControladorPrincipal implements ActionListener
{
	private VentanaAnuncios v = null;
    private VentanaOrganizador org;
    private EditorAnuncio editor = new EditorAnuncio();
    private Mensaje m  = new Mensaje();
    private VentanaRegistroPatrocinador registro = new VentanaRegistroPatrocinador();
    private FormularioRegistroExpositor formularioRegistro;
    private VentanaLogeo login;
    private VentanaPrincipal principal;
    private ListaDeCursoDescripcion listaCursos;
    private DetalleCursoDisponible detalle;
	public ControladorPrincipal() 
	{			    	    		
		login = new VentanaLogeo();
		principal = new VentanaPrincipal();
		org = new VentanaOrganizador();
		formularioRegistro =new FormularioRegistroExpositor();
		listaCursos = new ListaDeCursoDescripcion();
		VentanaOrganizadorHabilitarBotones();
		VentanaPrincipalHabilitarBotones();
		VentanaListaDeCursosDescripcion();
	}
	private void VentanaPrincipalHabilitarBotones() {
		this.principal.logear.addActionListener(this);
		this.principal.listaCursos.addActionListener(this);
	}
	private void DetallecursosDisponibleBotones(){
		this.detalle.cerrarVentana.addActionListener(this);
	}
	private void VentanaListaDeCursosDescripcion(){
		for(int i=0;i<this.listaCursos.botones.length;i++) this.listaCursos.botones[i].addActionListener(this);
	}
	private void VentanaLogueoHabilitarBotones() {
		this.login.aceptar.addActionListener(this);
	}
	private void VentanaOrganizadorHabilitarBotones()
	{
		this.org.agregarUsuario.addActionListener(this);
		this.org.cronogramaCursos.addActionListener(this);
		this.org.detalleCursos.addActionListener(this);
		this.org.nuevoCurso.addActionListener(this);
		this.org.registrarPatrocinador.addActionListener(this);
		this.org.retirarAnuncio.addActionListener(this);
		this.org.retirarCurso.addActionListener(this);
		this.org.salir.addActionListener(this);
		this.org.verificarSolicitud.addActionListener(this);
	    this.org.nuevoAnuncio.addActionListener(this);	
	}
	private void VentanaEditoAnuncioHabilitarBotones()
	{
		this.editor.aceptar.addActionListener(this);
		this.editor.cancelar.addActionListener(this);
		this.editor.registro.addActionListener(this);		
		this.editor.ver.addActionListener(this);
	}
	private void VentanaRegistroHabilitarBotones(){
		this.formularioRegistro.aceptar.addActionListener(this);
		this.formularioRegistro.cancelar.addActionListener(this);
		this.formularioRegistro.tipo.addActionListener(this);
		this.formularioRegistro.verificapasword.addActionListener(this);
		this.formularioRegistro.verificaNombreUsuario.addActionListener(this);
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
		if (boton == this.principal.logear)
		{   		
			login.visible();

			VentanaLogueoHabilitarBotones();
			
		}
		if (boton == this.org.agregarUsuario)
		{   		
			formularioRegistro.esVisible();
			VentanaRegistroHabilitarBotones();
			
		}
		if (boton == this.org.cronogramaCursos)
		{   		
							
		}
		if(boton == this.org.detalleCursos)
		{
			// necesitamos obtener tres cosas y almacenarlas cada uno en un String [] para luego usarlo en la tabala
			// curso , inscritos, montotoals recaudadototal
		    //new detalleEconomicoCursos(curso,inscritos,monto );
		}
		if(boton == this.org.nuevoCurso)
		{
			new nuevoCurso();
		}
		if(boton == this.org.retirarCurso)
		{
			// necesitamos hacer una consulta a la base de datos para obtener cursos,expositore,ambiente,fecha
			// y guardarlos en un String [] estos mismos
			// new retirarCursos(curso, expositor, ambiente, fecha)
		}
        if(boton==this.org.registrarPatrocinador)
        {          	 
        	 registro.esVisible();
        	 VentanaRegistroPtracinadorHabilitarBotones();
        }
        if (boton==this.org.verificarSolicitud)
        {
        	// necesitamos hacer una consulta para obtener numero , expositor y curso y almacenar cada uno en un 
        	// arreglo de String cada uno 
        	// new VentanaConfirmacionCurso(numero, expositor, cursos)
        }
        if(boton==this.org.nuevoAnuncio)
        {          	 
        	editor = new EditorAnuncio();
			editor.visible();		
			VentanaEditoAnuncioHabilitarBotones();	        	
        }
        
        if(boton==this.formularioRegistro.tipo){
        	
	        this.formularioRegistro.email.setBounds(110,240,300,25);
	        this.formularioRegistro.pais.setBounds(248,390,150,50);
	        this.formularioRegistro.ciudad.setBounds(224,440,150,50);
	        
	        
			if(this.formularioRegistro.tipo.getSelectedItem().equals("Personal")){
				this.formularioRegistro.email.setText("Correo Electronico : ");
				this.formularioRegistro.pais.setText("Cargo : ");
				this.formularioRegistro.ciudad.setText("Sueldo : ");
				this.formularioRegistro.pais.setBounds(228,390,150,50);
			}
			if(this.formularioRegistro.tipo.getSelectedItem().equals("Expositor") || this.formularioRegistro.tipo.getSelectedItem().equals("Organizador") ){
				this.formularioRegistro.email.setText("Correo Electronico : ");
				this.formularioRegistro.pais.setText("Pais : ");
				this.formularioRegistro.ciudad.setText("Ciudad : ");	 
			}
			this.formularioRegistro.repaint();
			this.formularioRegistro.validate();
			
		}
		if (boton==this.formularioRegistro.verificapasword){
			if (this.formularioRegistro.campopasword.getText().equals(this.formularioRegistro.campoverificapasword.getText())){
				JOptionPane.showMessageDialog(this.formularioRegistro,"las contraseñas coinciden");
			}else{
				JOptionPane.showMessageDialog(this.formularioRegistro,"las contraseñas no coinciden");
				this.formularioRegistro.campopasword.setText("");
				this.formularioRegistro.campoverificapasword.setText("");
			}
				
		}
		if (boton == this.formularioRegistro.verificaNombreUsuario){
			String nombreUsuario=this.formularioRegistro.campoNombreUsuario.getText();
			/* metodo para que verificemos si existe el nombre de usuario en la base de datos
			   if(existe){
			   JOptionPane.showMessageDialog(this,"el nombre de usuario "+ e.campoNombreUsuario.getText()+" ya esta registrado");
			   campoNombreUsuario.setText("");
			   }no existe
			   JOptionPane.showMessageDialog(this,"el nombre de usuario "+ e.campoNombreUsuario.getText()+" esta libre para su uso");
			       
			 */
		}
		if(boton == this.formularioRegistro.aceptar){
			if (this.formularioRegistro.tipo.getSelectedItem().equals("Seleccione uno")){
				JOptionPane.showMessageDialog(this.formularioRegistro,"Seleccione un Tipo de Registro");
			}else{
			String usuario = this.formularioRegistro.campoNombreUsuario.getText();
			String password = this.formularioRegistro.campopasword.getText();
			String correo = this.formularioRegistro.campoemail.getText();  // es empresa
			String nombreUsiario = this.formularioRegistro.camponombre.getText();
			String paisUsuario = this.formularioRegistro.campopais.getText(); // es tipo de patrocinio;cargo
			String ciudadUsuario = this.formularioRegistro.campociudad.getText(); // es inversion ;sueldo
			String telefonoUsuario = this.formularioRegistro.campoTelefono.getText();
			String direccionUsuario = this.formularioRegistro.campodireccion.getText();
			/*
			if(tipo.getSelectedItem().equals("Organizador")){
			 metodo para guardar datos en la base de datos patrocinador
			
			}
			if(tipo.getSelectedItem().equals("Personal")){
			 metodo para guardar datos en la base de datos personal
			}
			if(tipo.getSelectedItem().equals("Expositor")){
			 metodo para guardar datos en la base de datos Expositor
			}
			 */
			this.formularioRegistro.campoNombreUsuario.setText("");
			this.formularioRegistro.campopasword.setText("");
			this.formularioRegistro.campoverificapasword.setText("");
			this.formularioRegistro.campoemail.setText("");
			this.formularioRegistro.camponombre.setText("");
			this.formularioRegistro.campopais.setText("");
			this.formularioRegistro.campociudad.setText("");
			this.formularioRegistro.campoTelefono.setText("");
			this.formularioRegistro.campodireccion.setText("");
			}
		
		}
		if(boton == this.formularioRegistro.cancelar){
			formularioRegistro.setVisible(false);
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
        if(boton == this.login.aceptar)
        {
        	String nombreUsuario = this.login.login.getText();
        	String password = this.login.contraseña.getText();
        	/// metodo que verifica que tipo de usuraio es 
        	//if(tipo == organizador) entonces org.esVisible(nombreUsuario);
        }
        if(boton == this.principal.listaCursos){
        	listaCursos.esVisible();
        }
        for(int i=0;i<this.listaCursos.botones.length;i++){
        	if(boton == this.listaCursos.botones[i]){
        		detalle = new DetalleCursoDisponible(this.listaCursos.botones[i].getText());
        		DetallecursosDisponibleBotones();
        		i = this.listaCursos.botones.length;
        	}
        }
        
    }
}