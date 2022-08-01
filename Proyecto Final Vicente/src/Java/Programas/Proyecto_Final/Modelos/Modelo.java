package Java.Programas.Proyecto_Final.Modelos;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import Java.Programas.Proyecto_Final.BD.Conexion;
import Java.Programas.Proyecto_Final.Pojo.Persona;

public class Modelo extends AbstractTableModel{
	Conexion cn = new Conexion();
	String[] encabezado = {"id","Nombre","Apellido","Edad","Sexo"};
	ArrayList<Persona> lista = null;
	
	
	public Modelo() {
		lista = cn.mostrar("");
		fireTableDataChanged();
	}
	
	public void buscar(String campo, String dato ) {
		lista = cn.mostrar(campo, dato);
		fireTableDataChanged();
	}
		
	public void insertar(Persona p) {
		cn.agregar(p);
		lista = cn.mostrar("");
		fireTableDataChanged();
	}
	
	public void actualizar(Persona p) {
		cn.editar(p);
		lista = cn.mostrar("");
		fireTableDataChanged();
	}
	
	public void elimiar (int p) { 
		String btn[] = {"Si","No"};
		int eleccion =JOptionPane.showOptionDialog(null, "Esta a punto de eliminar estos datos, ¿Desea Continuar?", "Confirmar Eliminacion de Datos", 0, JOptionPane.WARNING_MESSAGE, null, btn, this);
		if (eleccion==JOptionPane.YES_OPTION) {
			cn.eliminar(lista.get(p).getId());
			lista.remove(p);
			fireTableRowsDeleted(p, p);
		}else if (eleccion==JOptionPane.NO_OPTION){
			JOptionPane.showMessageDialog(null, "Operacion Cancelada");
		}
	}
	
	
	@Override
	public String getColumnName(int x) {
		return encabezado[x];
	}
	
	@Override
	public int getColumnCount() {
		return encabezado.length;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int x, int y) {
		Object datos = null;
		Persona p = lista.get(x);
		switch (y) {
		
		case 0:
			datos = p.getId();
			break;
		case 1:
			datos = p.getNombre();
			break;
		case 2:
			datos = p.getApellido();
			break;
		case 3:
			datos = p.getEdad();
			break;
		case 4:
			datos = p.getSexo();
			break;

		}
		return datos;
		}

}
