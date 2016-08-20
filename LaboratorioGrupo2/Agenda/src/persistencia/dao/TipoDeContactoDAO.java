package persistencia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.TipoDeContactoDTO;
import persistencia.conexion.Conexion;

public class TipoDeContactoDAO 
{
	private static final String insert = "INSERT INTO TipoContacto (idTipoContacto, tipoContacto) VALUES(?, ?)";
	private static final String delete = "DELETE FROM TipoContacto WHERE idTipoContacto = ?";
	private static final String readall = "SELECT * FROM TipoContacto";
	private static final Conexion conexion = Conexion.getConexion();
	private String update;

	
	
	public boolean insert(TipoDeContactoDTO contacto)
	{
		PreparedStatement statement;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, contacto.getId());	
			statement.setString(2, contacto.getNombre());
			
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

	public boolean update(TipoDeContactoDTO contacto)
	{
		PreparedStatement statement;
		update = "UPDATE TipoContacto " +
                "SET tipoContacto = ?" +
				"WHERE (idTipoContacto = "+contacto.getId()+ ")";
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			//statement.setInt(1, contacto.getId());	
			statement.setString(1, contacto.getNombre());
			
			
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

	
	public boolean delete(TipoDeContactoDTO contactoAEliminar)
	{
		PreparedStatement statement;
		int chequeoUpdate=0;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setInt(1, contactoAEliminar.getId());
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
	
	public List<TipoDeContactoDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<TipoDeContactoDTO> contactos = new ArrayList<TipoDeContactoDTO>();
		try 
		{ 
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				contactos.add(new TipoDeContactoDTO(resultSet.getInt("idTipoContacto"),
							resultSet.getString("tipoContacto")));
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
		return contactos;
	}

}
