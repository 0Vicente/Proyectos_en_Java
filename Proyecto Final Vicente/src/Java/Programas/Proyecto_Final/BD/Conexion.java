package Java.Programas.Proyecto_Final.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Java.Programas.Proyecto_Final.Frames.Pantalla1;
import Java.Programas.Proyecto_Final.Frames.Reporte;
import Java.Programas.Proyecto_Final.Pojo.Persona;

public class Conexion {
	public static Connection con;
	Statement query;
	public Conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/bdjava?user=root&password=root");
			query = con.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getconexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/bdjava?user=root&password=root");
			query = con.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public void agregar(Persona p) {
		String btn[] = {"Si","No"};
		int eleccion =JOptionPane.showOptionDialog(null, "Esta a punto de agregar un nuevo dato, ¿Desea Continuar?", "Confirmar Nuevo Dato", 0, JOptionPane.INFORMATION_MESSAGE, null, btn, this);
		if (eleccion==JOptionPane.YES_OPTION) {
			try {
				query.execute("INSERT INTO Persona (Nombre, Apellido, Edad, Sexo) values ('"+p.getNombre()+"','"+p.getApellido()+"','"+p.getEdad()+"','"+p.getSexo()+"')");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			JOptionPane.showMessageDialog(null, "Datos Agregados");
			}else{
				JOptionPane.showMessageDialog(null, "Operacion Cancelada");
			}
	}
	public void editar(Persona p) {
		String btn[] = {"Si","No"};
		int eleccion =JOptionPane.showOptionDialog(null, "Esta a punto de modificar estos datos, ¿Desea Continuar?", "Confirmar Edicion de Datos", 0, JOptionPane.INFORMATION_MESSAGE, null, btn, this);
		if (eleccion==JOptionPane.YES_OPTION) {
			try {
				query.execute("Update persona Set nombre='"+p.getNombre()+"', apellido='"+p.getApellido()+"', edad='"+p.getEdad()+"', sexo='"+p.getSexo()+"' Where id='"+p.getId()+"'");	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			JOptionPane.showMessageDialog(null, "Datos Actualizados");
			}else{
				JOptionPane.showMessageDialog(null, "Operacion Cancelada");
			}
	}
	
	public void eliminar(int codigo) {
				try {
			query.execute("Delete From Persona where id="+codigo);
			JOptionPane.showMessageDialog(null, "Datos Eliminados");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}
	
	public void salir() {
		String btn[] = {"Si","No"};
		int eleccion =JOptionPane.showOptionDialog(null, "Esta a Punto de salir, ¿Desea Continuar?", "Confirmacion", 0, JOptionPane.WARNING_MESSAGE, null, btn, this);
		if  (eleccion==JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		}
	
	
	public  ArrayList<Persona> mostrar(String nom){
		ArrayList<Persona> lista = new ArrayList<Persona>();
		ResultSet rs=null;
		try {
			rs = query.executeQuery("Select * from persona where concat (nombre, ' ',apellido) like '%"+nom+"%'");
			while(rs.next()) {
				lista.add(new Persona(rs.getInt("id"),rs.getString("nombre"),rs.getString("apellido"), rs.getInt("edad"),rs.getString("sexo")));
		}} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public  ArrayList<Persona> mostrar(String campo, String dato){
		ArrayList<Persona> lista = new ArrayList<Persona>();
		ResultSet rs=null;
		try {
			rs = query.executeQuery("Select * from persona where "+campo+" like '%"+dato+"%'");
			while(rs.next()) {
				lista.add(new Persona(rs.getInt("id"),rs.getString("nombre"),rs.getString("apellido"), rs.getInt("edad"),rs.getString("sexo")));
		}} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public  boolean  ingresar(String user, String pass){
		Pantalla1 p = new Pantalla1();
		Reporte rp = new Reporte();
		String nivel="";
		String usu="";
		String password="";
		ResultSet rs=null;
		try {
			rs = query.executeQuery("Select * from login where usuario='"+user+"'&&contrasena='"+pass+"'");
			while(rs.next()) {
				usu = user;
				password = pass;
				nivel= rs.getString("nivel");
				if ((nivel.equals("Admin"))&&(usu.equals(rs.getString("usuario")))&&(password.equals(rs.getString("contrasena")))) {
					p.setLocationRelativeTo(null);
					p.setVisible(true);
					return true;
				}else if((nivel.equals("User"))&&(usu.equals(rs.getString("usuario")))&&(password.equals(rs.getString("contrasena")))) {
					rp.setLocationRelativeTo(null);
					rp.setVisible(true);
					rp.ocultarboton();
					return true;
				}
				
		}} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
}
