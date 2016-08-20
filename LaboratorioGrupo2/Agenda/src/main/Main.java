package main;

import modelo.Agenda;
import modelo.Contacto;
import modelo.Localidad;
import presentacion.controlador.Controlador;
import presentacion.vista.VentanaContactos;
import presentacion.vista.VentanaLocalidad;
import presentacion.vista.Vista;


public class Main 
{

	public static void main(String[] args) 
	{
		Vista vista = new Vista();
		Agenda modelo = new Agenda();
		Localidad l = new Localidad ();
		Contacto c = new Contacto ();
		VentanaLocalidad vl = new VentanaLocalidad ();
		VentanaContactos vc = new VentanaContactos (); 
		
		Controlador controlador = new Controlador(vista, modelo, l, c, vl, vc);
		controlador.inicializar();
	}
}
