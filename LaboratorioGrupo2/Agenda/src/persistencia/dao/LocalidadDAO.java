package persistencia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import persistencia.conexion.Conexion;
import dto.LocalidadDTO;

public class LocalidadDAO 
{
	private static final String insert = "INSERT INTO Localidad (idLocalidad, nombreLocalidad) VALUES(?, ?)";
	private static final String delete = "DELETE FROM Localidad WHERE idLocalidad = ?";
	private static final String readall = "SELECT * FROM Localidad";
	private static final Conexion conexion = Conexion.getConexion();
	
	private String update;

	
	public boolean insert(LocalidadDTO localidad)
	{
		PreparedStatement statement;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, localidad.getId());	
			statement.setString(2, localidad.getNombre());
			
			if(statement.executeUpdate() > 0) //Si se ejecut� devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return false;
	}

	
	public boolean update(LocalidadDTO localidad)
	{
		PreparedStatement statement;
		update = "UPDATE Localidad " +
                "SET nombreLocalidad = ?" +
				"WHERE (idLocalidad = "+localidad.getId()+ ")";

		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			//statement.setInt(1, localidad.getId());	
			statement.setString(1, localidad.getNombre());
			
			if(statement.executeUpdate() > 0) //Si se ejecut� devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return false;
	}

	public boolean delete(LocalidadDTO localidadAEliminar)
	{
		PreparedStatement statement;
		int chequeoUpdate=0;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setInt(1,localidadAEliminar.getId());
			chequeoUpdate = statement.executeUpdate();
			if(chequeoUpdate > 0) //Si se ejecut� devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return false;
	}
	
	public List<LocalidadDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<LocalidadDTO> localidades = new ArrayList<LocalidadDTO>();
		try 
		{ 
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				localidades.add(new LocalidadDTO(resultSet.getInt("idLocalidad"),
							resultSet.getString("nombreLocalidad")));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return localidades;
	}

}
