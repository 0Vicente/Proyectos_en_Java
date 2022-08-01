package Java.Programas.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Java.Programas.Pollo.Persona;

public class Conexion {
	Connection conn;
	Statement query;
	public  Connection conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bdjava?user=root&password=root");
			query=conn.createStatement();
//			JOptionPane.showMessageDialog(null, "Se ha conectado la Base de Datos Correctamente");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	return conn;}
	
	Statement createStatement () {
		throw new UnsupportedOperationException("No soportado");
	}
	
	 public void Guardar_SQL (Persona p) {
		 try {
			query.execute("INSERT INTO Persona (Nombre, Apellido, Edad) values ('"+p.getNombre()+"','"+p.getApellido()+"','"+p.getEdad()+"')");
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
//		  String query1 = "INSERT INTO Persona (Nombre, Apellido, Edad) values ('"+p.getNombre()+"''"+p.getApellido()+"''"+p.getEdad()+"')";
//		  try {
//			  conn.createStatement().execute(query1);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		  
//	  }
	 
	 public  ArrayList<Persona> ver(){
		ArrayList<Persona> lista = new ArrayList<Persona>();
		 ResultSet rs;
		 try {
			rs = query.executeQuery("select nombre, apellido,edad from persona");
			while(rs.next()) {
				lista.add(new Persona(rs.getString("nombre"),rs.getString("apellido"), rs.getInt("edad")));
				System.out.print(rs.getString("nombre"));
				System.out.print(" ");
				System.out.print(rs.getString("apellido"));
				System.out.print(" ");
				System.out.print(rs.getInt("edad"));
				System.out.print(" ");
				System.out.println("");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return lista;
	 }
	 
}
