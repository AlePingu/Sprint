package vista;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

public class VentanaOrganizador extends JDialog {
	private JLabel bienvenido,queHacer,fondo;
	public JButton verificarSolicitud,detalleCursos,agregarUsuario,cronogramaCursos,registrarPatrocinador,salir
				   ,nuevoCurso,retirarAnuncio,retirarCurso,nuevoAnuncio;
	public String nombre;
	public VentanaOrganizador(){ // al logear obtiene el nombre de usuario y lo manda como parametro
		
		setTitle("Opciones de Organizador");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(null);
		
		fondo = new JLabel();
        fondo.setBounds(0,0,800,600);
        ImageIcon fot = new ImageIcon("imagenes/2.jpg");
  	    Icon icono1 = new ImageIcon(fot.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
  	    fondo.setIcon(icono1);
		
			 bienvenido = new JLabel("Bienvenido ");
	     	   queHacer = new JLabel("Que desea Hacer");
		  
     verificarSolicitud = new JButton("Verificar Solicitud");
          detalleCursos = new JButton("Detalle de Cursos");
         agregarUsuario = new JButton("Registrar Usuario");
       cronogramaCursos = new JButton("Cronograma de Cursos");
  registrarPatrocinador = new JButton("Registrar Patrocinador");
             nuevoCurso = new JButton("Nuevo Curso");
         retirarAnuncio = new JButton("Retirar Anuncio");
           retirarCurso = new JButton("Retirar Curso");
                  salir = new JButton("Salir");
           nuevoAnuncio = new JButton("Nuevo Anuncio");      
                  
            bienvenido.setFont(new Font("Arial Black", Font.BOLD, 15));
            queHacer.setFont(new Font("Arial Black", Font.BOLD, 25));
            
            bienvenido.setBounds(50,10,300,50);
              queHacer.setBounds(50,50,400,50);
                 salir.setBounds(550,30,150,25);
    verificarSolicitud.setBounds(50,120,225,30);
         detalleCursos.setBounds(50,170,225,30);
        agregarUsuario.setBounds(50,220,225,30);
      cronogramaCursos.setBounds(50,270,225,30);
 registrarPatrocinador.setBounds(50,320,225,30);
            nuevoCurso.setBounds(50,370,225,30);
          nuevoAnuncio.setBounds(50,420,225,30);
        retirarAnuncio.setBounds(50,470,225,30);
          retirarCurso.setBounds(50,520,225,30);
                 
          add(bienvenido);
          add(queHacer);
          add(salir);
          add(verificarSolicitud);
          add(detalleCursos);
          add(agregarUsuario);
          add(cronogramaCursos);
          add(registrarPatrocinador);
          add(nuevoCurso);
          add(retirarAnuncio);
          add(retirarCurso);
          add(nuevoAnuncio);
          add(fondo);
          setSize(800,600);
          setLocationRelativeTo(null);
	}
	
	public void esVisible(String nombre){
		bienvenido.setText("Bienvenido "+nombre);
		setVisible(true);
	}

}
