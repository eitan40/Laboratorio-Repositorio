package dto;

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
	private String signo;

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
	
	public String getSigno() {
		signo = this.obtenerSigno(fechaDeCumpleanios);
		return signo;
	}

	public void setSigno(String signo) {
		this.signo = signo;
	}

	@SuppressWarnings("deprecation")
	public String obtenerSigno(Date fecha)
	{
		switch (fecha.getMonth()+1)
		{
			case 1:
				if (fecha.getDate() >= 21)
					return "Acuario";
				else
					return "Capricornio";
			case 2:
				if (fecha.getDate() >= 19)
					return "Picis";
				else
					return "Acuario";
			case 3:
				if (fecha.getDate() >= 21)
					return "Aries";
				else
					return "Picis";
			case 4:
				if (fecha.getDate() >= 21)
					return "Tauro";
				else
					return "Aries";
			case 5:
				if (fecha.getDate() >= 22)
					return "Geminis";
				else
					return "Tauro";
			case 6:
				if (fecha.getDate() >= 22)
					return "Cancer";
				else
					return "Geminis";
			case 7:
				if (fecha.getDate() >= 23)
					return "Leo";
				else
					return "Cancer";
			case 8:
				if (fecha.getDate() >= 24)
					return "Virgo";
				else
					return "Leo";
			case 9:
				if (fecha.getDate() >= 24)
					return "Libra";
				else
					return "Virgo";
			case 10:
				if (fecha.getDate() >= 24)
					return "Escorpio";
				else
					return "Libra";
			case 11:
				if (fecha.getDate() >= 23)
					return "Sagitario";
				else
					return "Escorpio";
			case 12:
				if (fecha.getDate() >= 22)
					return "Capricornio";
				else
					return "Sagitario";
		}
		return "";
		
	}
	
}
