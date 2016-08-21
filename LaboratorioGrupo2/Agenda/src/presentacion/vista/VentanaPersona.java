package presentacion.vista;


import java.awt.Color;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentacion.controlador.Controlador;

import com.toedter.calendar.JDateChooser;

import javax.swing.JComboBox;

public class VentanaPersona extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controlador controlador;

	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtCalle;
	private JTextField txtAltura;
	private JTextField txtPiso;
	private JTextField txtDpto;
	private JTextField txtEmail;

	JDateChooser dCFechaDeCumple;
	
	JComboBox <String> cmbxLocalidad;
	JComboBox <String> cmbxTipoDeContacto;

	private JButton btnAgregarPersona;
	JButton btnAbmLocalidad;
	JButton btnABMTipoDeContacto;
	
	
	JLabel lblAlerta1;
	JLabel lblAlerta2;
	JLabel lblAlerta3;
	private JLabel lblSoloNmeros;
	
	public Pattern nombreValido = Pattern.compile("[\\wñÑ]{1,20}");
	public Pattern apellidoValido = Pattern.compile("[\\wñÑ]{1,20}");
	public Pattern mailValido = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	public Pattern numeroValido = Pattern.compile ("[0-9]*");
	private JButton btnGuardar;


	
	public VentanaPersona(Controlador controlador) 
	{
		super();
		this.controlador = controlador;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 507, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 472, 413);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 113, 14);
		panel.add(lblNombre);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setBounds(10, 92, 113, 14);
		panel.add(lblTelefono);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 49, 113, 14);
		panel.add(lblApellido);

		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 137, 113, 14);
		panel.add(lblCalle);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(340, 137, 57, 14);
		panel.add(lblAltura);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(133, 178, 32, 14);
		panel.add(lblPiso);
		
		JLabel lblDpto = new JLabel("Dpto");
		lblDpto.setBounds(217, 178, 57, 14);
		panel.add(lblDpto);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 220, 113, 14);
		panel.add(lblLocalidad);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setBounds(10, 264, 113, 14);
		panel.add(lblEmail);
		
		JLabel lblFechaDeCumpleanios = new JLabel("Fecha de Cumplea\u00F1os");
		lblFechaDeCumpleanios.setBounds(10, 304, 113, 14);
		panel.add(lblFechaDeCumpleanios);
		
		JLabel lblTipoDeContacto = new JLabel("Tipo de Contacto");
		lblTipoDeContacto.setBounds(10, 346, 113, 14);
		panel.add(lblTipoDeContacto);
		
		
		lblAlerta1 = new JLabel("*");
		lblAlerta1.setForeground(Color.RED);
		lblAlerta1.setBounds(308, 11, 18, 14);
		panel.add(lblAlerta1);
	
		lblAlerta2 = new JLabel("*");
		lblAlerta2.setForeground(Color.RED);
		lblAlerta2.setBounds(308, 49, 18, 14);
		panel.add(lblAlerta2);
		
		lblAlerta3 = new JLabel("*");
		lblAlerta3.setForeground(Color.RED);
		lblAlerta3.setBounds(308, 92, 18, 14);
		panel.add(lblAlerta3);
		
		lblSoloNmeros = new JLabel("Solo n\u00FAmeros");
		lblSoloNmeros.setForeground(Color.RED);
		lblSoloNmeros.setBounds(141, 92, 133, 14);
		panel.add(lblSoloNmeros);

		
		txtNombre = new JTextField();
		txtNombre.setBounds(133, 8, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(133, 46, 164, 20);
		panel.add(txtApellido);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(133, 89, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		txtCalle.setBounds(133, 134, 164, 20);
		panel.add(txtCalle);
		
		txtAltura = new JTextField();
		txtAltura.setColumns(10);
		txtAltura.setBounds(396, 134, 63, 20);
		panel.add(txtAltura);
		
		txtPiso = new JTextField();
		txtPiso.setColumns(10);
		txtPiso.setBounds(175, 175, 32, 20);
		panel.add(txtPiso);
		
		txtDpto = new JTextField();
		txtDpto.setColumns(10);
		txtDpto.setBounds(266, 175, 32, 20);
		panel.add(txtDpto);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(133, 261, 164, 20);
		panel.add(txtEmail);
		
		dCFechaDeCumple = new JDateChooser();
		dCFechaDeCumple.setBounds(133, 298, 129, 20);
		panel.add(dCFechaDeCumple);
		
		cmbxLocalidad = new JComboBox<String>();
		cmbxLocalidad.setBounds(133, 217, 164, 20);
		panel.add(cmbxLocalidad);
		
		cmbxTipoDeContacto = new JComboBox<String>();
		cmbxTipoDeContacto.setBounds(133, 343, 164, 20);
		panel.add(cmbxTipoDeContacto);
		

		btnAbmLocalidad = new JButton("ABM");
		btnAbmLocalidad.addActionListener(this.controlador);
		btnAbmLocalidad.setBounds(307, 216, 39, 23);
		panel.add(btnAbmLocalidad);
		
		btnABMTipoDeContacto = new JButton("ABM");
		btnABMTipoDeContacto.addActionListener(this.controlador);
		btnABMTipoDeContacto.setBounds(307, 342, 39, 23);
		panel.add(btnABMTipoDeContacto);
				
		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.addActionListener(this.controlador);
		btnAgregarPersona.setBounds(370, 379, 89, 23);
		panel.add(btnAgregarPersona);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this.controlador);
		btnGuardar.setBounds(370, 379, 89, 23);
		panel.add(btnGuardar);

		this.setVisible(true);
	}
	
	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}

	public JTextField getTxtTelefono() 
	{
		return txtTelefono;
	}

	public JButton getBtnAgregarPersona() 
	{
		return btnAgregarPersona;
	}

	
	public JTextField getTxtApellido() {
		return txtApellido;
	}

	
	public JTextField getTxtCalle() {
		return txtCalle;
	}

	
	public JTextField getTxtAltura() {
		return txtAltura;
	}

	
	public JTextField getTxtPiso() {
		return txtPiso;
	}

	
	public JTextField getTxtDpto() {
		return txtDpto;
	}

	
	public JTextField getTxtEmail() {
		return txtEmail;
	}

	
	public JDateChooser getdCFechaDeCumple() {
		return dCFechaDeCumple;
	}

	
	public JComboBox<String> getCmbxLocalidad() {
		return cmbxLocalidad;
	}

	
	public JComboBox<String> getCmbxTipoDeContacto() {
		return cmbxTipoDeContacto;
	}

	
	public JButton getBtnAbmLocalidad() {
		return btnAbmLocalidad;
	}

	
	public JButton getBtnABMTipoDeContacto() {
		return btnABMTipoDeContacto;
	}
	
	public JLabel getLblAlerta1() {
		return lblAlerta1;
	}

	public JLabel getLblAlerta2() {
		return lblAlerta2;
	}

	public JLabel getLblAlerta3() {
		return lblAlerta3;
	}
	
	public JLabel getLblAlerta4() {
		return lblSoloNmeros;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setTxtNombre(String txtNombre) {
		this.txtNombre.setText(txtNombre);
	}

	public void setTxtApellido(String txtApellido) {
		this.txtApellido.setText(txtApellido);
	}

	public void setTxtTelefono(String txtTelefono) {
		this.txtTelefono.setText(txtTelefono);
	}

	public void setTxtCalle(String txtCalle) {
		this.txtCalle.setText(txtCalle);
	}

	public void setTxtAltura(String txtAltura) {
		this.txtAltura.setText(txtAltura);
	}

	public void setTxtPiso(String txtPiso) {
		this.txtPiso.setText(txtPiso);
	}

	public void setTxtDpto(String txtDpto) {
		this.txtDpto.setText(txtDpto);
	}

	public void setTxtEmail(String txtEmail) {
		this.txtEmail.setText(txtEmail);
	}

	public void setdCFechaDeCumple(Date fechaDeCumpleanios) {
		
//		int dia = fechaDeCumpleanios.getCalendar().get(Calendar.DAY_OF_MONTH);
//		int mes = fechaDeCumpleanios.getCalendar().get(Calendar.MONTH)+ 1;
//		int anio = fechaDeCumpleanios.getCalendar().get(Calendar.YEAR);
//
//		String fechaS = anio + "-" + mes + "-" + dia;
//		
//		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
//		Date fecha = null;
//		try {
//
//		    fecha = formatoDelTexto.parse(fechaS);
//
//		} catch (ParseException ex) {
//
//		    ex.printStackTrace();
//		}
		this.dCFechaDeCumple.setDate(fechaDeCumpleanios);

	
	}


//	public void setdCFechaDeCumple(Date date) {
//		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
//		Date fecha = null;
//		try {
//
//		    fecha = formatoDelTexto.parse(date);
//
//		} catch (ParseException ex) {
//
//		    ex.printStackTrace();
//		}
//		this.dCFechaDeCumple.setDate(fecha);
//	}

	
}


