package persistencia.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;
import dto.PersonaDTO;

public class PersonaDAO 
{
	private static final String insert = "INSERT INTO Personas(idPersona, nombre, apellido, telefono, mail, cumpleanios, calle, altura, piso, depto, localidad, tipoContacto) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM Personas WHERE idPersona = ?";
	private static final String readall = "SELECT * FROM Personas";
	private static final Conexion conexion = Conexion.getConexion();
	private String update;
		
	public boolean insert(PersonaDTO persona)
	{
		PreparedStatement statement;
		try 
		{
			@SuppressWarnings("deprecation")
			java.sql.Date sql = new java.sql.Date(persona.getFechaDeCumpleanios().getTime());
			
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, persona.getIdPersona());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getApellido());
			statement.setString(4, persona.getTelefono());
			statement.setString(5, persona.getEmail());
			statement.setDate(6, sql );			
			statement.setString(7, persona.getCalle());
			statement.setString(8, persona.getAltura());
			statement.setString(9, persona.getPiso());
			statement.setString(10, persona.getDpto());
			statement.setInt(11, persona.getLocalidad());
			statement.setInt(12, persona.getTipoDeContacto());
			
			
			if(statement.executeUpdate() > 0)//Si se ejecut� devuelvo true
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

	public boolean update(PersonaDTO persona)
	{

		PreparedStatement statement;
		update = "UPDATE Personas " +
                "SET nombre = ?," +
                "apellido = ?,"+
				"telefono = ?,"+
				"mail = ?,"+
				"cumpleanios = ?,"+
				"calle = ?,"+
                "altura = ?,"+
                "piso = ?,"+
                "depto = ?,"+
                "localidad = ?,"+
                "tipoContacto = ?" +
                
               " WHERE (idPersona = "+persona.getIdPersona() + ")";
       
		
		try 
		{
			@SuppressWarnings("deprecation")
			java.sql.Date sql = new java.sql.Date(persona.getFechaDeCumpleanios().getTime());
			statement = conexion.getSQLConexion().prepareStatement(update);
			
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getApellido());
			statement.setString(3, persona.getTelefono());
			statement.setString(4, persona.getEmail());
			statement.setDate(5, sql);
			
			statement.setString(6, persona.getCalle());
			statement.setString(7, persona.getAltura());
			statement.setString(8, persona.getPiso());
			statement.setString(9, persona.getDpto());
			statement.setInt(10, persona.getLocalidad());
			
			statement.setInt(11, persona.getTipoDeContacto());
			
			
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

	
	public boolean delete(PersonaDTO persona_a_eliminar)
	{
		PreparedStatement statement;
		int chequeoUpdate=0;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(persona_a_eliminar.getIdPersona()));
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
	
	public List<PersonaDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		try 
		{ 
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				personas.add(new PersonaDTO(resultSet.getInt("idPersona"), resultSet.getString("nombre"), resultSet.getString("apellido"), resultSet.getString("telefono"), 
											resultSet.getString("calle"), resultSet.getString("altura"),
											resultSet.getString("piso"), resultSet.getString("depto"),
											resultSet.getInt("localidad"), resultSet.getString("mail"), 
											resultSet.getDate("cumpleanios"), resultSet.getInt("tipoContacto")
											));
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
		return personas;
	}
}
