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
			s.close();
			conector.close();
		}catch(Exception e)
		{
			System.out.println("Error al cerrar conexion");
		}
	}
}