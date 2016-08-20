package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;

import javax.swing.JOptionPane;

import modelo.Agenda;
import modelo.Contacto;
import modelo.Localidad;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaAgregar;
import presentacion.vista.VentanaContactos;
import presentacion.vista.VentanaLocalidad;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.TipoDeContactoDTO;

public class Controlador implements ActionListener
{
		private Vista vista;
		
		private List<PersonaDTO> personasEnTabla;
		private List <LocalidadDTO> localidadesEnTabla;
		private List <TipoDeContactoDTO> tipoContactoEnTabla;
		
		private Agenda agenda;
		private Localidad localidad;		
		private Contacto contacto;
		
		private VentanaPersona ventanaPersona; 
		
		private VentanaLocalidad ventanaLocalidad;
		private VentanaContactos ventanaContactos;
		private VentanaAgregar ventanaAgregar;		
				
		PersonaDTO auxPersona;
		LocalidadDTO auxLocalidad;
		TipoDeContactoDTO auxTipoDeContacto;
		
		LocalidadDTO nuevaLocalidad;
		
		/**
		 * @wbp.parser.entryPoint
		 */
		public Controlador(Vista vista, Agenda agenda, Localidad localidad, Contacto cont, VentanaLocalidad vl, VentanaContactos vC)
		{ 
			this.vista = vista;
			this.vista.getBtnAgregar().addActionListener(this);
			this.vista.getBtnEditar().addActionListener(this);
			this.vista.getBtnBorrar().addActionListener(this);
			this.vista.getBtnReporte().addActionListener(this);
		
			this.ventanaLocalidad = vl;
			this.ventanaLocalidad.getBtnAgregar().addActionListener(this);
			this.ventanaLocalidad.getBtnBorrar().addActionListener(this);
			this.ventanaLocalidad.getBtnEditar().addActionListener(this);
			
			this.ventanaContactos = vC;
			this.ventanaContactos.getBtnAgregar().addActionListener(this);
			this.ventanaContactos.getBtnBorrar().addActionListener(this);
			this.ventanaContactos.getBtnEditar().addActionListener(this);
			
			this.agenda = agenda;
			this.localidad = localidad;
			this.contacto = cont;
			
			this.personasEnTabla = null;
			this.localidadesEnTabla = null;
			this.tipoContactoEnTabla = null;
			
		}
		
		public void inicializar()
		{
			this.llenarTabla();
		}
		
		private void llenarTabla()
		{
			this.vista.getModelPersonas().setRowCount(0); //Para vaciar la tabla
			this.vista.getModelPersonas().setColumnCount(0);
			this.vista.getModelPersonas().setColumnIdentifiers(this.vista.getNombreColumnas());
			
			this.llenarTablaLocalidades();
			this.llenarTablaTipoDeContacto();
			
			this.personasEnTabla = agenda.obtenerPersonas();
			
			for (int i = 0; i < this.personasEnTabla.size(); i ++)
			{
				String localidad = null;
				for (LocalidadDTO l : this.localidadesEnTabla)
				{
					if (l.getId() == this.personasEnTabla.get(i).getLocalidad())
						localidad = l.getNombre();
				}
				
				String tipoContacto = null;
				for (TipoDeContactoDTO tc : this.tipoContactoEnTabla)
				{
					if (tc.getId() == this.personasEnTabla.get(i).getTipoDeContacto())
						tipoContacto = tc.getNombre();
				}
				
				
				Object[] fila = {
								this.personasEnTabla.get(i).getNombre(), this.personasEnTabla.get(i).getApellido(),
								this.personasEnTabla.get(i).getTelefono(),this.personasEnTabla.get(i).getCalle(), 
								this.personasEnTabla.get(i).getAltura(), this.personasEnTabla.get(i).getPiso(), 
								this.personasEnTabla.get(i).getDpto(),
								localidad,
								this.personasEnTabla.get(i).getEmail(),
								this.personasEnTabla.get(i).getFechaDeCumpleanios(),
								tipoContacto
								};
				
				this.vista.getModelPersonas().addRow(fila);
			}
			this.vista.show();
		}

		private void llenarTablaLocalidades ()
		{
			this.ventanaLocalidad.getModelLocalidades().setRowCount(0); 
			this.ventanaLocalidad.getModelLocalidades().setColumnCount(0);
			this.ventanaLocalidad.getModelLocalidades().setColumnIdentifiers(this.ventanaLocalidad.getNombreColumnas());
			
			this.localidadesEnTabla = localidad.obtenerLocalidades();
			
			for (int i=0 ;i< this.localidadesEnTabla.size(); i++) 
			{
				
				Object [] fila = {this.localidadesEnTabla.get(i).getNombre()};
				this.ventanaLocalidad.getModelLocalidades().addRow(fila);
			}			
			

		}
		
		//ACTUALIZAR COMBO BOX EN VENTANA USUARIO
		private void actualizarListaLocalidades ()
		{
			this.ventanaPersona.getCmbxLocalidad().removeAllItems();
			
			for (LocalidadDTO l : this.localidadesEnTabla)
			{
				this.ventanaPersona.getCmbxLocalidad().addItem(l.getNombre());
			}	
		}	
		
		private void llenarTablaTipoDeContacto ()
		{
			this.ventanaContactos.getModelContactos().setRowCount(0); //
			this.ventanaContactos.getModelContactos().setColumnCount(0);
			this.ventanaContactos.getModelContactos().setColumnIdentifiers(this.ventanaContactos.getNombreColumnas());
			
			this.tipoContactoEnTabla = contacto.obtenerTipoDeContacto();
			for (int i=0 ;i< this.tipoContactoEnTabla.size(); i++) 
			{
				Object [] fila = {this.tipoContactoEnTabla.get(i).getNombre()};
			
				this.ventanaContactos.getModelContactos().addRow(fila);
			}
		}
		
		//ACTUALIZAR COMBO BOX EN VENTANA USUARIO
		private void actualizatListaTipoDeContacto ()
		{
			this.ventanaPersona.getCmbxTipoDeContacto().removeAllItems();
			for (TipoDeContactoDTO tC : this.tipoContactoEnTabla)
			{
				this.ventanaPersona.getCmbxTipoDeContacto().addItem(tC.getNombre());
			}	
		}	
		
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == this.vista.getBtnAgregar())
			{		
				this.ventanaPersona = new VentanaPersona(this);
				
				this.ventanaPersona.getBtnGuardar().setVisible(false);
				this.ventanaPersona.getLblAlerta1().setVisible(false);
				this.ventanaPersona.getLblAlerta2().setVisible(false);
				this.ventanaPersona.getLblAlerta3().setVisible(false);
				this.ventanaPersona.getLblAlerta4().setVisible(false);
					
				
				this.llenarTablaLocalidades();
				this.actualizarListaLocalidades();

				this.llenarTablaTipoDeContacto();
				this.actualizatListaTipoDeContacto();
			}
			//EDITAR PERSONA
			else if (e.getSource() == this.vista.getBtnEditar() )
			{
				
				try{
					Integer filaSeleccionada = this.vista.getTablaPersonas().getSelectedRow();
					
					if (filaSeleccionada < 0)
						JOptionPane.showMessageDialog(null, "Seleccionar un contacto", "Advertencia", JOptionPane.WARNING_MESSAGE);
		
					String nombre = this.vista.getTablaPersonas().getValueAt(filaSeleccionada, 0).toString();

					for (PersonaDTO p : this.personasEnTabla)
					{
						if (p.getNombre().equals(nombre))
							auxPersona = p;
					}
							
					for (LocalidadDTO l : this.localidadesEnTabla)
					{
						if (l.getId() == this.auxPersona.getLocalidad())
							auxLocalidad = l;
					}
					
					for (TipoDeContactoDTO tc : this.tipoContactoEnTabla)
					{
						if (tc.getId() == this.auxPersona.getTipoDeContacto())
							auxTipoDeContacto = tc;
					}
					
					
					this.ventanaPersona = new VentanaPersona(this);
					
					this.ventanaPersona.getBtnGuardar().setVisible(true);
					
					this.ventanaPersona.getLblAlerta1().setVisible(false);
					this.ventanaPersona.getLblAlerta2().setVisible(false);
					this.ventanaPersona.getLblAlerta3().setVisible(false);
					this.ventanaPersona.getLblAlerta4().setVisible(false);
					
					this.llenarTablaLocalidades();
					this.actualizarListaLocalidades();
					
					this.llenarTablaTipoDeContacto();
					this.actualizatListaTipoDeContacto();

					this.ventanaPersona.setTxtNombre(auxPersona.getNombre());
					this.ventanaPersona.setTxtApellido(auxPersona.getApellido());

					this.ventanaPersona.setTxtTelefono(auxPersona.getTelefono());
					this.ventanaPersona.setTxtCalle(auxPersona.getCalle());
					this.ventanaPersona.setTxtAltura(auxPersona.getAltura().toString());
					this.ventanaPersona.setTxtPiso(auxPersona.getPiso());
					this.ventanaPersona.setTxtDpto(auxPersona.getDpto());
					
					this.ventanaPersona.getCmbxLocalidad().setSelectedItem(auxLocalidad.getNombre());
					
					this.ventanaPersona.setTxtEmail(auxPersona.getEmail());
					this.ventanaPersona.setdCFechaDeCumple(auxPersona.getFechaDeCumpleanios());
					//
					this.ventanaPersona.getCmbxTipoDeContacto().setSelectedItem(auxTipoDeContacto.getNombre());
					
					this.ventanaPersona.getBtnAgregarPersona().setVisible(false);
					this.ventanaPersona.setVisible(true);

				}
				catch (ArrayIndexOutOfBoundsException ex)
				{
					ex.printStackTrace();
				}
												
			}
			else if(e.getSource() == this.vista.getBtnBorrar())
			{
				int[] filas_seleccionadas = this.vista.getTablaPersonas().getSelectedRows();
				for (int fila:filas_seleccionadas)
				{
					this.agenda.borrarPersona(this.personasEnTabla.get(fila));
				}				
				this.llenarTabla();			
			}
			else if(e.getSource() == this.vista.getBtnReporte())
			{		 		
				ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
				reporte.mostrar();				
			}
			//AGREGAR UNA NUEVA PERSONA
			else if(e.getSource() == this.ventanaPersona.getBtnAgregarPersona())
			{
				String nombre = this.ventanaPersona.getCmbxLocalidad().getSelectedItem().toString();
				
				for (LocalidadDTO l : this.localidadesEnTabla)
				{
					if (l.getNombre().equals(nombre))
						auxLocalidad = l;						
				}
				
				String nombre2 = this.ventanaPersona.getCmbxTipoDeContacto().getSelectedItem().toString();
				for (TipoDeContactoDTO tC : this.tipoContactoEnTabla)
				{
					if (tC.getNombre().equals(nombre2))
						auxTipoDeContacto = tC;
				}
				
				boolean acceso = true;
				Matcher nombreValido = ventanaPersona.nombreValido.matcher(ventanaPersona.getTxtNombre().getText()); //No vacío
				Matcher apellidoValido = ventanaPersona.apellidoValido.matcher (ventanaPersona.getTxtApellido().getText()); //No vacío
				Matcher numeroValido = ventanaPersona.nombreValido.matcher(ventanaPersona.getTxtTelefono().getText());
						
				if (!nombreValido.matches()) 
				{
					ventanaPersona.getLblAlerta1().setVisible(true);
					acceso = false;
				}
				else 
					acceso = true;	
				if (!apellidoValido.matches()) 
				{
					ventanaPersona.getLblAlerta2().setVisible(true);
					acceso = false;
				}
				else 
					acceso = true;

				if (!numeroValido.matches())
				{
					ventanaPersona.getLblAlerta3().setVisible(true);
					ventanaPersona.getLblAlerta4().setVisible(true);
					acceso = false;
				}
				else 
					acceso = true;
						
						
				if (acceso) 
				{
					//
					int dia = this.ventanaPersona.getdCFechaDeCumple().getCalendar().get(Calendar.DAY_OF_MONTH);
					int mes = this.ventanaPersona.getdCFechaDeCumple().getCalendar().get(Calendar.MONTH)+ 1;
					int anio = this.ventanaPersona.getdCFechaDeCumple().getCalendar().get(Calendar.YEAR);

					String fecha = anio + "-" + mes + "-" + dia;
					
					Date fechaCumpleaños = obtenerFecha(fecha);
					
					PersonaDTO nuevaPersona = new PersonaDTO(0,
							this.ventanaPersona.getTxtNombre().getText(),
							this.ventanaPersona.getTxtApellido().getText(),
							this.ventanaPersona.getTxtTelefono().getText(),
							this.ventanaPersona.getTxtCalle().getText(), 
							this.ventanaPersona.getTxtAltura().getText(),
							this.ventanaPersona.getTxtPiso().getText(), 
							this.ventanaPersona.getTxtDpto().getText(),
							auxLocalidad.getId(),
							this.ventanaPersona.getTxtEmail().getText(), 
							fechaCumpleaños,
							
//							fecha, 
							auxTipoDeContacto.getId());
							
						this.llenarTablaLocalidades();
						this.actualizarListaLocalidades();
								
						this.llenarTablaTipoDeContacto();
						this.actualizatListaTipoDeContacto();
							
						this.agenda.agregarPersona(nuevaPersona);
						this.llenarTabla();
						    
						this.ventanaPersona.dispose();
											
				}
				acceso = false;
							
			}
			//EDITAR UNA PERSONA Y GUARDARLA
			else if (e.getSource() == this.ventanaPersona.getBtnGuardar())
			{								
				String nombre = this.ventanaPersona.getCmbxLocalidad().getSelectedItem().toString();
				
				for (LocalidadDTO l : this.localidadesEnTabla)
				{
					if (l.getNombre().equals(nombre))
						auxLocalidad = l;						
				}
				
				String nombre2 = this.ventanaPersona.getCmbxTipoDeContacto().getSelectedItem().toString();
				for (TipoDeContactoDTO tC : this.tipoContactoEnTabla)
				{
					if (tC.getNombre().equals(nombre2))
						auxTipoDeContacto = tC;
				}
				
				boolean acceso = true;
				Matcher nombreValido = ventanaPersona.nombreValido.matcher(this.ventanaPersona.getTxtNombre().getText()); //No vacío
				Matcher apellidoValido = ventanaPersona.apellidoValido.matcher (this.ventanaPersona.getTxtApellido().getText()); //No vacío
				Matcher numeroValido = ventanaPersona.nombreValido.matcher(ventanaPersona.getTxtTelefono().getText());	
				
				if (!nombreValido.matches()) 
				{
					ventanaPersona.getLblAlerta1().setVisible(true);
					acceso = false;
				}		
				else
					acceso = true;
				
				if (!apellidoValido.matches()) 
				{
					ventanaPersona.getLblAlerta2().setVisible(true);
					acceso = false;
				}
				else
					acceso = true;
				
				if (!numeroValido.matches())
				{
					ventanaPersona.getLblAlerta4().setVisible(true);
					ventanaPersona.getLblAlerta3().setVisible(true);
					acceso = false;
				}
				else
					acceso = true;

				if (acceso) 
				{
					int dia = this.ventanaPersona.getdCFechaDeCumple().getCalendar().get(Calendar.DAY_OF_MONTH);
					int mes = this.ventanaPersona.getdCFechaDeCumple().getCalendar().get(Calendar.MONTH)+ 1;
					int anio = this.ventanaPersona.getdCFechaDeCumple().getCalendar().get(Calendar.YEAR);

					String fecha = anio + "-" + mes + "-" + dia;
					SimpleDateFormat lala = new SimpleDateFormat(fecha);
					Date f = null;
					try {
						f = lala.parse(fecha);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					PersonaDTO personaAux = new PersonaDTO(auxPersona.getIdPersona(),
							this.ventanaPersona.getTxtNombre().getText(),
							this.ventanaPersona.getTxtApellido().getText(),
							this.ventanaPersona.getTxtTelefono().getText(),
							this.ventanaPersona.getTxtCalle().getText(), 
							this.ventanaPersona.getTxtAltura().getText(),
							this.ventanaPersona.getTxtPiso().getText(), 
							this.ventanaPersona.getTxtDpto().getText(),
							auxLocalidad.getId(),
							//this.ventanaPersona.getCmbxLocalidad().getSelectedItem().toString(), 
							this.ventanaPersona.getTxtEmail().getText(), 
							f, 
							//this.ventanaPersona.getCmbxTipoDeContacto().getSelectedItem().toString()	
							auxTipoDeContacto.getId()
							);
						
					this.llenarTablaLocalidades();
					this.actualizarListaLocalidades();
						
					this.llenarTablaTipoDeContacto();
					this.actualizatListaTipoDeContacto();
						
					this.agenda.actualizarPersona(personaAux);					
					this.llenarTabla();			
						
					this.ventanaPersona.dispose();

				}
				acceso = false;
			}
			else if (e.getSource() == this.ventanaPersona.getBtnAbmLocalidad())
			{
				this.ventanaLocalidad.show();				
			}
			else if (e.getSource() == this.ventanaPersona.getBtnABMTipoDeContacto())
			{
				this.ventanaContactos.show();		
			}
			else if (e.getSource() == this.ventanaLocalidad.getBtnAgregar())
			{				
				this.ventanaAgregar = new VentanaAgregar(this);
				this.ventanaAgregar.getBtnGuardar().setVisible(false);
				
				this.ventanaAgregar.setTipo("Localidad");
				this.ventanaAgregar.setVisible(true);				
			}
			else if (e.getSource() == this.ventanaLocalidad.getBtnEditar())
			{
				try{
				Integer filaSeleccionada = this.ventanaLocalidad.getTablaLocalidades().getSelectedRow();
				
				if (filaSeleccionada < 0)
					JOptionPane.showMessageDialog(null, "Seleccionar una localidad", "Advertencia", JOptionPane.WARNING_MESSAGE);
			
				String nombre = this.ventanaLocalidad.getTablaLocalidades().getValueAt(filaSeleccionada, 0).toString();
				for (LocalidadDTO l : this.localidadesEnTabla)
				{
					if (l.getNombre().equals(nombre))
						auxLocalidad = l;
				}
				
				this.ventanaAgregar = new VentanaAgregar(this);
				this.ventanaAgregar.setTipo("Localidad");
				this.llenarTablaLocalidades();
				this.actualizarListaLocalidades();
				
				this.ventanaAgregar.setTxtNombre(auxLocalidad.getNombre());
				
				this.ventanaAgregar.getBtnAgregar().setVisible(false);
				this.ventanaAgregar.setVisible(true);
				}
				catch (ArrayIndexOutOfBoundsException ex)
				{
					ex.printStackTrace();
				}
			}
			else if (e.getSource() == this.ventanaLocalidad.getBtnBorrar())
			{
				int[] filas_seleccionadas = this.ventanaLocalidad.getTablaLocalidades().getSelectedRows();
				for (int fila:filas_seleccionadas)
				{
					this.localidad.borrarLocalidad(this.localidadesEnTabla.get(fila));
				}
				this.llenarTablaLocalidades();
				this.actualizarListaLocalidades();
			}
			
			else if (e.getSource() == this.ventanaContactos.getBtnAgregar())
			{
				this.ventanaAgregar = new VentanaAgregar(this);
				this.ventanaAgregar.getBtnGuardar().setVisible(false);
				this.ventanaAgregar.setTipo("TipoDeContacto");
				this.ventanaAgregar.setVisible(true);
				
			}
			else if (e.getSource() == this.ventanaContactos.getBtnEditar())
			{				
				try
				{
					Integer filaSeleccionada = this.ventanaContactos.getTablaContactos().getSelectedRow();
					
					if (filaSeleccionada < 0)
						JOptionPane.showMessageDialog(null, "Seleccione un tipo de contacto", "Advertencia", JOptionPane.WARNING_MESSAGE);
	
					
					String nombre = this.ventanaContactos.getTablaContactos().getValueAt(filaSeleccionada, 0).toString();
					for (TipoDeContactoDTO tC : this.tipoContactoEnTabla)
					{
						if (tC.getNombre().equals(nombre))
							auxTipoDeContacto = tC;
					}
					
					this.ventanaAgregar = new VentanaAgregar(this);
					this.ventanaAgregar.setTipo("TipoDeContacto");
					this.llenarTablaTipoDeContacto();
					this.actualizatListaTipoDeContacto();
					
					this.ventanaAgregar.setTxtNombre(auxTipoDeContacto.getNombre());
					
					this.ventanaAgregar.getBtnAgregar().setVisible(false);
					this.ventanaAgregar.setVisible(true);			
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}				
			}
			else if (e.getSource() == this.ventanaContactos.getBtnBorrar())
			{
				int[] filas_seleccionadas = this.ventanaContactos.getTablaContactos().getSelectedRows();
				for (int fila:filas_seleccionadas)
				{
					this.contacto.borrarTipoDeContacto(this.tipoContactoEnTabla.get(fila));
				}
				this.llenarTablaTipoDeContacto();
				this.actualizatListaTipoDeContacto();
			}
			//VENTANA AGREGAR
			else if (e.getSource() == this.ventanaAgregar.getBtnAgregar())
			{
				if (this.ventanaAgregar.getTipo().equals("Localidad"))
				{
					//Crear la nueva localidad
					nuevaLocalidad = new LocalidadDTO (0,this.ventanaAgregar.getTxtNombre().getText());
					
					this.localidad.agregarLocalidad(nuevaLocalidad);

					this.llenarTablaLocalidades();	
					this.actualizarListaLocalidades();		
					
					nuevaLocalidad = null;
				}
				else
				{
					//Crear un nuevo tipo de contacto
					TipoDeContactoDTO nuevoTipo = new TipoDeContactoDTO (0, this.ventanaAgregar.getTxtNombre().getText());
					this.contacto.agregarTipoDeContacto(nuevoTipo);
	
					this.llenarTablaTipoDeContacto();
					this.actualizatListaTipoDeContacto();
				}
				this.ventanaAgregar.dispose();
			}
			else if (e.getSource() == this.ventanaAgregar.getBtnGuardar())
			{	
				try{
					if (this.ventanaAgregar.getTipo().equals("Localidad"))
					{
						LocalidadDTO localidadAux = new LocalidadDTO(auxLocalidad.getId(), this.ventanaAgregar.getTxtNombre().getText());
								
						this.llenarTablaLocalidades();
						this.actualizarListaLocalidades();
						
						this.localidad.actualizarLocalidad(localidadAux);					
						this.llenarTablaLocalidades();
						this.actualizarListaLocalidades();
					}
					else
					{
						TipoDeContactoDTO tipoAux = new TipoDeContactoDTO (auxTipoDeContacto.getId(), 
													this.ventanaAgregar.getTxtNombre().getText());
						
						this.llenarTablaTipoDeContacto();
						this.actualizatListaTipoDeContacto();
						
						this.contacto.actualizarTipoDeContacto(tipoAux);
						this.llenarTablaTipoDeContacto();
						this.actualizatListaTipoDeContacto();
					}
					this.ventanaAgregar.dispose();

				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
			else if (e.getSource() == this.ventanaAgregar.getBtnCancelar())
			{			
				this.ventanaAgregar.dispose();
			}
		}
		//PARSEAR FECHA
		public Date obtenerFecha(String dCFechaDeCumple) {
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
			Date fecha = null;
			try {

			    fecha = formatoDelTexto.parse(dCFechaDeCumple);

			} catch (ParseException ex) {

			    ex.printStackTrace();
			}

		return fecha;
		}
}
