package dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String apellido;
	private String telefono;
	private String calle;
	private String altura;
	private String piso;
	private String dpto;
	private Integer localidad;
	private String email;
	private Date fechaDeCumpleanios;
	private Integer tipoDeContacto;
	private String signo = "";

	public PersonaDTO(int idPersona, String n, String ap, String tel, String c, String alt, String p, 
					String d, Integer l, String em, Date f, Integer tC)
	{
		this.idPersona = idPersona;
		this.nombre = n;
		this.apellido = ap;
		this.telefono = tel;
		this.calle = c;
		this.altura = alt;
		this.piso = p;
		this.dpto = d;
		this.localidad = l;
		this.email = em;
		this.fechaDeCumpleanios = f;
		this.tipoDeContacto = tC;
	//	this.signo = obtnerSigno();
				
	}
	
	private String obtnerSigno() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getIdPersona() 
	{
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) 
	{
		this.idPersona = idPersona;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getTelefono() 
	{
		return this.telefono;
	}

	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getCalle() {
		return calle;
	}
	
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	public String getAltura() {
		return altura;
	}
	
	public void setAltura(String altura) {
		this.altura = altura;
	}
	
	public String getPiso() {
		return piso;
	}
	
	public void setPiso(String piso) {
		this.piso = piso;
	}
	
	public String getDpto() {
		return dpto;
	}
	
	public void setDpto(String dpto) {
		this.dpto = dpto;
	}

	public Integer getLocalidad() {
		return localidad;
	}
	
	public void setLocalidad(Integer localidad) {
		this.localidad = localidad;
	}
	
	public Date getFechaDeCumpleanios() {
		return fechaDeCumpleanios;
	}
	
	public void setFechaDeCumpleanios(Date fechaDeCumpleanios) {
		this.fechaDeCumpleanios = fechaDeCumpleanios;
	}
	
	public int getTipoDeContacto() {
		return tipoDeContacto;
	}
	
	public void setTipoDeContacto(Integer tipoDeContacto) {
		this.tipoDeContacto = tipoDeContacto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
//	public String obtenerSigno()
//	{
//		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
//		Date fecha = null;
//		try {
//
//		    fecha = formatoDelTexto);
//
//		} catch (ParseException ex) {
//
//		    ex.printStackTrace();
//		}
//		
//		
//		return "";
//	}
	
}
