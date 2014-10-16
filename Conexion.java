import java.sql.*;
public class Conexion
{
	private Connection conector;
	private Statement s;
	
	public Conexion()
	{
		try
		{
			Class.forName("org.postgresql.Driver");
			conector = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cursos", "postgres", "publica");
			s = conector.createStatement();
			ResultSet r = s.executeQuery("SELECT * FROM patrocinador");
			r.next();
			String asd = r.getString(2);
			System.out.println(asd);
		}catch(Exception e)
		{
			System.out.println("Error de coneccion");
		}
	}
	
	public ResultSet ejecutarQuery(String query)
	{
		ResultSet resultado = null;
		try
		{
			resultado = s.executeQuery(query);
		}catch(Exception e)
		{
			System.out.println("Error de consulta");
		}
		return resultado;
	}
	
	public void cerrarConexion()
	{
		try
		{
			s.executeQuery("SELECT cerrarSesion()");
			s.close();
			conector.close();
		}catch(Exception e)
		{
			System.out.println("Error al cerrar conexion");
		}
	}
}