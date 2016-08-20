package dto;

public class LocalidadDTO 
{
	private Integer id;
	private String nombre;
	
	public LocalidadDTO(Integer cod, String nombre) 
	{
		this.id = cod;
		this.nombre = nombre;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
