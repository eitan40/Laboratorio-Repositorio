package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import javax.swing.JButton;

public class VentanaLocalidad extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private  String[] nombreColumnas = {"Localidad"};

	private Tabla tablaLocalidades;
	private DefaultTableModel modelLocalidades;
	

	
	public VentanaLocalidad() 
	{
		super();
//		this.controlador = c;
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
		
		JScrollPane spLocalidades = new JScrollPane();
		spLocalidades.setBounds(10, 11, 164, 270);
		panel.add(spLocalidades);
	
		
		modelLocalidades = new DefaultTableModel(null,nombreColumnas);
		tablaLocalidades = new Tabla();
		tablaLocalidades.setModel(modelLocalidades);
		
		tablaLocalidades.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaLocalidades.getColumnModel().getColumn(0).setResizable(false);
				
		spLocalidades.setViewportView(tablaLocalidades);
		
		btnAgregar = new JButton("Agregar");
	//	btnAgregar.addActionListener(this.controlador);
		btnAgregar.setBounds(184, 14, 89, 23);
		panel.add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		//btnEditar.addActionListener(this.controlador);
		btnEditar.setBounds(184, 53, 89, 23);
		panel.add(btnEditar);
		
		btnBorrar = new JButton("Borrar");
		//btnBorrar.addActionListener(this.controlador);
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

		
	public JTable getTablaLocalidades() {
		return tablaLocalidades;
	}

	public void setModelLocalidades(DefaultTableModel modelLocalidades) {
		this.modelLocalidades = modelLocalidades;
	}

	public DefaultTableModel getModelLocalidades() {
		return modelLocalidades;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}
}
