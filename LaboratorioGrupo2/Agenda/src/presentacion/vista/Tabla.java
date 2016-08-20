package presentacion.vista;

import javax.swing.JTable;


public class Tabla extends JTable 
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Creates a new instance of MyTableModel */
    public Tabla() {
      
    }
    
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
}
