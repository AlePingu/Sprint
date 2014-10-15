import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

public class VentanaOrganizador extends JDialog {
	private JLabel bienvenido,queHacer,fondo;
	public JButton verificarSolicitud,detalleCursos,agregarUsuario,cronogramaCursos,registrarPatrocinador,salir
				   ,nuevoCurso,retirarAnuncio,retirarCurso;
	public VentanaOrganizador(String nombre){ // al logear obtiene el nombre de usuario y lo manda como parametro
		
		setTitle("Opciones de Organizador");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(null);
		
		fondo = new JLabel();
        fondo.setBounds(0,0,800,600);
        ImageIcon fot = new ImageIcon("imagenes/2.jpg");
  	    Icon icono1 = new ImageIcon(fot.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
  	    fondo.setIcon(icono1);
		
			 bienvenido = new JLabel("Bienvenido "+nombre);
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
                  
            bienvenido.setFont(new Font("Arial Black", Font.BOLD, 15));
            queHacer.setFont(new Font("Arial Black", Font.BOLD, 25));
            
            bienvenido.setBounds(50,10,300,50);
              queHacer.setBounds(50,50,400,50);
                 salir.setBounds(550,30,150,25);
    verificarSolicitud.setBounds(50,150,225,30);
         detalleCursos.setBounds(50,200,225,30);
        agregarUsuario.setBounds(50,250,225,30);
      cronogramaCursos.setBounds(50,300,225,30);
 registrarPatrocinador.setBounds(50,350,225,30);
            nuevoCurso.setBounds(50,400,225,30);
        retirarAnuncio.setBounds(50,450,225,30);
          retirarCurso.setBounds(50,500,225,30);
                 
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
          add(fondo);
          setSize(800,600);
          setLocationRelativeTo(null);
          setVisible(true);
	}
	
	public static void main(String[] args) {
		new VentanaOrganizador("Denis123");
	}

}
