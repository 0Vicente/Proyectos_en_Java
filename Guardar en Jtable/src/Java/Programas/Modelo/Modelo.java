package Java.Programas.Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import Java.Programas.Conexion.Conexion;
import Java.Programas.Pollo.Persona;

public class Modelo extends AbstractTableModel {
	Conexion con = new Conexion();
	String[] arriba = {"Nombre","Apellido","Edad"};
	ArrayList<Persona> lista = null;
	
	public  Modelo() {
		lista = con.ver();
	}
	
	public void agregar (Persona p) {
		lista.add(p);
		fireTableDataChanged();
	}
	
	public void elimiar (int p) {
		if (p>=0) {
		if (JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar la persona?", "Confirmacion",JOptionPane.WARNING_MESSAGE , JOptionPane.YES_NO_OPTION, null)==JOptionPane.YES_OPTION) {
		lista.remove(p);
		fireTableRowsDeleted(p, p);
		JOptionPane.showMessageDialog(null, "Persona Eliminada");
		}else{
			JOptionPane.showMessageDialog(null, "Operacion Cancelada");
		}}else {
			JOptionPane.showMessageDialog(null, "No Hay Nada Seleccionado");
		}
		
//		int opcion = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar la fila?", "Confirmacion",  JOptionPane.YES_NO_OPTION);
//		if (opcion==0) {
//		lista.remove(p);
//		fireTableRowsDeleted(p, p);
//	}else if (opcion==1){
//		JOptionPane.showMessageDialog(null, "Operacion Cancelada");
//	} 
		
	}
	
	public void reemplazar (int a, Persona p) {
		if (JOptionPane.showConfirmDialog(null, "Seguro que desea actualizar la persona?", "Confirmacion",JOptionPane.WARNING_MESSAGE , JOptionPane.YES_NO_OPTION, null)==JOptionPane.YES_OPTION) {
			lista.set(a, p);
			fireTableDataChanged();
			JOptionPane.showMessageDialog(null, "Persona Actualizada Satisfactoriamente");
			}else{
				JOptionPane.showMessageDialog(null, "Operacion Cancelada");
			}
	}
	
 
public void guardar_arraylist() {
        
        	File f = new File("C:\\Users\\Vicente Luna\\Desktop\\txt\\Personas_Array.txt");
        	if (lista.size()> 0) {
        	if (JOptionPane.showConfirmDialog(null, "Seguro que desea agregar la persona?", "Confirmacion",JOptionPane.WARNING_MESSAGE , JOptionPane.YES_NO_OPTION, null)==JOptionPane.YES_OPTION) {	
        	if (f.exists()) {
        	try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
            bw.newLine();
            for (Persona e : lista) {
//                String fecha1 = new SimpleDateFormat("dd/MM/yyyy").format(e.getFecha_nacimiento());
            	bw.write("Persona "+e.getNombre()+"\r\n\r\n"+"Nombre: "+e.getNombre()+"\r\nApellido: "+e.getApellido()+"\r\nEdad: "+e.getEdad()+"\r\n\r\n ");
            }
            bw.flush();
            bw.close();
            JOptionPane.showMessageDialog(null,"Los Datos han sido guardados");	
        } catch (Exception ex) { 
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }}else {
        	try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            for (Persona e : lista) {
//                String fecha1 = new SimpleDateFormat("dd/MM/yyyy").format(e.getFecha_nacimiento());
            	bw.write("Persona "+e.getNombre()+"\r\n\r\n"+"Nombre: "+e.getNombre()+"\r\nApellido: "+e.getApellido()+"\r\nEdad: "+e.getEdad()+"\r\n\r\n ");
            	}
            bw.flush();
            bw.close();
            JOptionPane.showMessageDialog(null,"Los Datos han sido guardados");
        } catch (Exception ex) { 
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }}}else{
        	JOptionPane.showMessageDialog(null, "Operacion Cancelada");
        }
        	}else {JOptionPane.showMessageDialog(null, "La lista esta vacia");}
}
 
	
	 	
	@Override
	public String getColumnName(int x) {
		return arriba[x];
	}

	@Override
	public int getColumnCount() {
		
		return arriba.length;
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
			datos = p.getNombre();
			break;
		case 1:
			datos = p.getApellido();
			break;
		case 2:
			datos = p.getEdad();
			break;
		}		 
		return datos;
	}
	

}
