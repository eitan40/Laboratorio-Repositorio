package dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainClass {

	public static void main(String[] args) 
	{		
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = null;
		try {

		    fecha = formatoDelTexto.parse("2016-09-01");

		} catch (ParseException ex) {

		    ex.printStackTrace();
		}
		
		
		PersonaDTO persona = new PersonaDTO (10, "Juana", "Perez", "0303456", "Calle falsa", "123", "3", "A",
								1, "lalala", fecha,1);
		
		
		System.out.println (persona.getNombre());
//		System.out.println (persona.getFechaDeCumpleanios());
//		
//		System.out.println ("");
//		
//		
		Date f = null;
		try {

		    f = formatoDelTexto.parse("1996-02-23");

		} catch (ParseException ex) {

		    ex.printStackTrace();
		}
//		System.out.println ("Signo: " + persona.getSigno());
//		persona.getSigno();

		System.out.println("----");
		persona.setFechaDeCumpleanios(f);
		System.out.println (persona.getFechaDeCumpleanios());
		
		
		System.out.println ("Signo: " + persona.getSigno());
		persona.getSigno();

	}

}
