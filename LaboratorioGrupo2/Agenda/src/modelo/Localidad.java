package modelo;

import java.util.List;

import persistencia.dao.LocalidadDAO;
import dto.LocalidadDTO;

public class Localidad 
{
	private LocalidadDAO localidad;	

	public Localidad()
	{
		localidad = new LocalidadDAO();
	}
	
	public void agregarLocalidad(LocalidadDTO nuevaLocalidad)  
	{
		localidad.insert(nuevaLocalidad);
	}

	public void borrarLocalidad(LocalidadDTO localidadAEliminar) 
	{
		localidad.delete(localidadAEliminar);
	}
	
	public void actualizarLocalidad (LocalidadDTO l)
	{
		localidad.update(l);
	}
	
	public List<LocalidadDTO> obtenerLocalidades()
	{
		return localidad.readAll();		
	}

}
