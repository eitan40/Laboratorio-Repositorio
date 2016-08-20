package presentacion.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import presentacion.controlador.Controlador;

public class VentanaAgregar extends JDialog 
{
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	JButton btnAgregar;
	JButton btnCancelar;
	JButton btnGuardar;
	
	private String tipo = "";
	
	
	Controlador controlador;

	public VentanaAgregar(Controlador controlador) 
	{
		super();
		this.controlador = controlador;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);		
		setVisible(true);
		
		setBounds(100, 100, 302, 133);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 65, 21);
		contentPanel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(73, 11, 123, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAgregar = new JButton("Agregar");
				btnAgregar.addActionListener(this.controlador);
				btnAgregar.setActionCommand("OK");
				buttonPane.add(btnAgregar);
				//getRootPane().setDefaultButton(btnAgregar);
			}
			{
				btnGuardar = new JButton("Guardar");
				btnGuardar.addActionListener(this.controlador);
				btnGuardar.setActionCommand("OK");
				buttonPane.add(btnGuardar);

				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(this.controlador);
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	
	public JTextField getTxtNombre() {
		return txtNombre;
	}
	
	public void setTxtNombre(String txtNombre) {
		this.txtNombre.setText(txtNombre);
	}


	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	public JButton getBtnGuardar(){
		return btnGuardar;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
