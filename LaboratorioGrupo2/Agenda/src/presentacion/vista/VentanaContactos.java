package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import javax.swing.JButton;

public class VentanaContactos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private  String[] nombreColumnas = {"Tipos de Contacto"};

	private Tabla tablaContactos;
	private DefaultTableModel modelContactos;
	

	
	public VentanaContactos() 
	{
		super();
		initialize();
	}
	
	public void initialize () 
	{
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 304, 329);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 288, 295);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane spContactos = new JScrollPane();
		spContactos.setBounds(10, 11, 164, 270);
		panel.add(spContactos);
	
		
		modelContactos = new DefaultTableModel(null,nombreColumnas);
		tablaContactos = new Tabla();
		tablaContactos.setModel(modelContactos);
		
		tablaContactos.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaContactos.getColumnModel().getColumn(0).setResizable(false);
				
		spContactos.setViewportView(tablaContactos);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(184, 14, 89, 23);
		panel.add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(184, 53, 89, 23);
		panel.add(btnEditar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(184, 87, 89, 23);
		panel.add(btnBorrar);
	}

	public void show()
	{
		this.frame.setVisible(true);
	}
	
	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}
	
	public JButton getBtnBorrar() {
		return btnBorrar;
	}

		
	public JTable getTablaContactos() {
		return tablaContactos;
	}

	public void setModelContactos(DefaultTableModel modelContactos) {
		this.modelContactos = modelContactos;
	}

	public DefaultTableModel getModelContactos() {
		return modelContactos;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}}
