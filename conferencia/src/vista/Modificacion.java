/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasdeinf2;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
public class Modificacion extends JFrame
{
    public JTextField nuevo_dia;
    public JLabel curso,estado,dia,horas;
    public JButton guardar,cancelar,verHorar;
    public JComboBox listaCursos,estad,nueva_hora;
    ImagenFondo fondo=new ImagenFondo("/Imagenes/fondo.jpg");
    Conexion conexion;
    Controlador control;
    
    public Modificacion(Controlador control,Conexion conexion)
    {
        super("Modificacion de Curso");
        this.control=control;
        this.conexion=conexion;
        curso= new JLabel("Curso:");
        estado=new JLabel("Estado:");
        dia = new JLabel("Ingrese nuevo Dia: (DD-MM-AA)");
        horas = new JLabel("Elija nueva Hora:");
        guardar=new JButton("Guardar");
        verHorar=new JButton("Ver Horarios");
        cancelar = new JButton("Cancelar");
        estad=new JComboBox();
        estad.setModel(new DefaultComboBoxModel(new String[] { "Activo", "Suspendido"}));
        listaCursos = new JComboBox();
        agregarCursos(listaCursos);
        nuevo_dia = new JTextField();
        nueva_hora = new JComboBox();
        nueva_hora.setModel(new DefaultComboBoxModel(new String[] { "periodo 1", "periodo 2","periodo 3","periodo 4"}));
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints contraints = new GridBagConstraints();
        this.setSize(700,400);
        Action ac = new Action();
        
        contraints.gridx=0;
        contraints.gridy=1;
        contraints.gridwidth=1;
        contraints.gridheight=1;
        contraints.fill=GridBagConstraints.LAST_LINE_START;
        contraints.weighty=1.0;
        contraints.weightx=0.0;
        this.getContentPane().add(curso,contraints);
        contraints.weighty=0.0;
        contraints.weightx=0.0;
        
        contraints.gridx=1;
        contraints.gridy=1;
        contraints.gridwidth=1;
        contraints.gridheight=1;
        contraints.fill=GridBagConstraints.SOUTH;
        contraints.weighty=1.0;
        contraints.weightx=0.0;
        this.getContentPane().add(estado,contraints);
        contraints.weighty=0.0;
        contraints.weightx=0.0;
        
        contraints.gridx=0;
        contraints.gridy=2;
        contraints.gridwidth=1;
        contraints.gridheight=1;
        contraints.fill=GridBagConstraints.NORTH;
        contraints.weighty=0.0;
        contraints.weightx=0.0;
        this.getContentPane().add(listaCursos,contraints);
        contraints.weighty=0.0;
        contraints.weightx=0.0;
        
        contraints.gridx=1;
        contraints.gridy=2;
        contraints.gridwidth=1;
        contraints.gridheight=1;
        contraints.fill=GridBagConstraints.NORTH;
        contraints.weighty=0.0;
        contraints.weightx=0.0;
        this.getContentPane().add(estad,contraints);
        contraints.weighty=0.0;
        contraints.weightx=0.0;
        
        contraints.gridx=0;
        contraints.gridy=3;
        contraints.gridwidth=1;
        contraints.gridheight=1;
        contraints.fill=GridBagConstraints.SOUTH;
        contraints.weighty=1.0;
        contraints.weightx=0.2;
        this.getContentPane().add(dia,contraints);
        contraints.weighty=0.0;
        contraints.weightx=0.0;
        
        contraints.gridx=1;
        contraints.gridy=3;
        contraints.gridwidth=1;
        contraints.gridheight=1;
        contraints.fill=GridBagConstraints.SOUTH;
        contraints.weighty=1.0;
        contraints.weightx=0.2;
        this.getContentPane().add(horas,contraints);
        contraints.weighty=0.0;
        contraints.weightx=0.0;
        
        contraints.gridx=0;
        contraints.gridy=4;
        contraints.gridwidth=1;
        contraints.gridheight=1;
        contraints.fill=GridBagConstraints.BOTH;
        contraints.weighty=0.0;
        contraints.weightx=0.0;
        this.getContentPane().add(nuevo_dia,contraints);
        contraints.weighty=0.0;
        contraints.weightx=0.0;
        
        contraints.gridx=1;
        contraints.gridy=4;
        contraints.gridwidth=1;
        contraints.gridheight=1;
        contraints.fill=GridBagConstraints.NORTH;
        contraints.weighty=0.0;
        contraints.weightx=0.0;
        this.getContentPane().add(nueva_hora,contraints);
        contraints.weighty=0.0;
        contraints.weightx=0.0;
        
        contraints.gridx=2;
        contraints.gridy=4;
        contraints.gridwidth=1;
        contraints.gridheight=1;
        contraints.fill=GridBagConstraints.CENTER;
        contraints.weighty=0.0;
        contraints.weightx=0.2;
        this.getContentPane().add(verHorar,contraints);
        contraints.weighty=0.0;
        contraints.weightx=0.0;
        
        contraints.gridx=0;
        contraints.gridy=5;
        contraints.gridwidth=1;
        contraints.gridheight=1;
        contraints.fill=GridBagConstraints.CENTER;
        contraints.weighty=2.0;
        contraints.weightx=0.2;
        this.getContentPane().add(guardar,contraints);
        guardar.addActionListener(ac);
        contraints.weighty=0.0;
        contraints.weightx=0.0;
        
        contraints.gridx=1;
        contraints.gridy=5;
        contraints.gridwidth=1;
        contraints.gridheight=1;
        contraints.fill=GridBagConstraints.CENTER;
        contraints.weighty=2.0;
        contraints.weightx=0.2;
        this.getContentPane().add(cancelar,contraints);
        cancelar.addActionListener(ac);
        contraints.weighty=0.0;
        contraints.weightx=0.0;
        
        contraints.gridx=0;
        contraints.gridy=0;
        contraints.gridwidth=3;
        contraints.gridheight =7;
        contraints.fill=GridBagConstraints.BOTH;
        this.getContentPane().add(fondo,contraints);

        this.setVisible(true);
    }
    public void agregarCursos(JComboBox lista)
    {
        lista.setModel(new DefaultComboBoxModel(new String[] { "Curso1","Curso2","Curso3"}));
    }
    
    
    
    public class Action implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==cancelar)
            {
                cerrarVentana();
            }
            if(e.getSource()==guardar)
            {
                enviarActualizacion(listaCursos.getSelectedItem(),nuevo_dia.getText(), nueva_hora.getSelectedItem());
            }
            if (e.getSource()==verHorar)
            {
                abrirVentanaHorarios();
            }
        }
        public void cerrarVentana()
        {
            System.exit(0);
        }
        public void enviarActualizacion(Object curso,Object dia,Object fecha)
        {
            try
            {
            String nombreCurso = curso.toString();
            String nuevoDia=dia.toString();
            String nuevaFecha=fecha.toString();
            
            //enviar actualizacion a la BD con estos valores
            }
            catch(Exception e)
            {
                System.out.println("Problema al realizar modificacion de curso");
            }
        }
        public void abrirVentanaHorarios()
        {
            //ventana de Harold
        }
        
    }
    public static void main(String[]args)
    {
        new Modificacion(new Controlador() ,new Conexion());
    }
}
