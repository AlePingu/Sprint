import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Controlador
{
	public Controlador()
	{
		//constructor?
	}

	public void registrarAnuncio(String texto, Conexion conector)
	{
		conector.ejecutarQuery("SELECT insertaranuncio('" + texto + "')");
	}
/*
	public void activarDescripcion(Conexion conector)
	{
		Descripcion ventana = new Descripcion();
	}*/
	public void activarEditorAnuncio(Conexion conector)
	{
		EditorAnuncio ventana = new EditorAnuncio(this, conector);
	}
	public void activarVentanaAnuncios(Conexion conector)
	{
		//VentanaAnuncios ventana = new VentanaAnuncios(this, conector);
	}
	/*public void activarVentanaFormularioInscripcion(Conexion conector)
	{
		VentanaFormularioInscripcion ventana = new VentanaFormularioInscripcion();
	}
	public void activarVentanaLogeo(Conexion conector)
	{
		VentanaLogeo ventana = new VentanaLogeo();
	}
	public void activarOpcionesOrganizador(Conexion conector)
	{
		OpcionesOrganizador ventana = new OpcionesOrganizador();
	}
	public void activarRegistroPatrocinador(Conexion conector)
	{
		RegistroPatrocinador ventana = new RegistroPatrocinador();
	}*/
}