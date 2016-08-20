package modelo;

import java.util.List;

import persistencia.dao.TipoDeContactoDAO;
import dto.TipoDeContactoDTO;

public class Contacto 
{
	private TipoDeContactoDAO tipoDeContacto;	

	public Contacto()
	{
		tipoDeContacto = new TipoDeContactoDAO();
	}
	
	public void agregarTipoDeContacto(TipoDeContactoDTO nuevoTipoDeContacto)  
	{
		tipoDeContacto.insert(nuevoTipoDeContacto);
	}

	public void borrarTipoDeContacto(TipoDeContactoDTO tipoDeContactoEliminar) 
	{
		tipoDeContacto.delete(tipoDeContactoEliminar);
	}

	public void actualizarTipoDeContacto (TipoDeContactoDTO tC)
	{
		tipoDeContacto.update(tC);
	}
	
	public List<TipoDeContactoDTO> obtenerTipoDeContacto()
	{
		return tipoDeContacto.readAll();		
	}
}
