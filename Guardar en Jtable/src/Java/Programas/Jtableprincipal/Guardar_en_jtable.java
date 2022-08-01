package Java.Programas.Jtableprincipal;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;

import Java.Programas.Conexion.Conexion;
import Java.Programas.Modelo.Modelo;
import Java.Programas.Pollo.Persona;

public class Guardar_en_jtable extends JFrame {

	private JPanel contentPane;
	private JTextField textField_nombre;
	private JTextField textField_apellido;
	private JTextField textField_edad;
	private JTable table;
	Modelo modelo = new Modelo();
	private JButton btnEliminar;
	private JButton btnEditar;
	ArrayList<Persona> lista = new ArrayList<Persona>();
	Conexion con = new Conexion();
	Connection cn= con.conexion() ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Guardar_en_jtable frame = new Guardar_en_jtable();
					frame.setVisible(true);
//					Conexion c = new Conexion();
//					c.Guardar_SQL(new Persona("Adonis","Luna",14));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Guardar_en_jtable() {
		setBackground(new Color(0, 191, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 483);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_nombre = new JTextField();
		textField_nombre.setBounds(66, 24, 96, 19);
		contentPane.add(textField_nombre);
		textField_nombre.setColumns(10);
		
		textField_apellido = new JTextField();
		textField_apellido.setBounds(243, 24, 96, 19);
		contentPane.add(textField_apellido);
		textField_apellido.setColumns(10);
		
		textField_edad = new JTextField();
		textField_edad.setBounds(409, 24, 96, 19);
		contentPane.add(textField_edad);
		textField_edad.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 27, 45, 13);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(190, 27, 60, 13);
		contentPane.add(lblApellido);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(375, 27, 35, 13);
		contentPane.add(lblEdad);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(10, 68, 540, 219);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		JTableHeader theheader = table.getTableHeader();
		theheader.setBackground(Color.white);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setForeground(new Color(0, 0, 0));
		table.setModel(modelo);
		
		
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (table.getSelectedRow()>=0) {
				textField_nombre.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				textField_apellido.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				textField_edad.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				}
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				if ((textField_nombre.getText().equals(""))||(textField_apellido.getText().equals(""))||(textField_edad.getText().equals(""))) {
					JOptionPane.showMessageDialog(null, "Todos los Campos Deben estar Completos");
				
				}else {
					Persona p = new Persona(textField_nombre.getText(), textField_apellido.getText(),
					Integer.parseInt(textField_edad.getText()));
					modelo.agregar(p);
					
				}
					
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "ERROR!, La edad debe ser numerica");
				textField_edad.requestFocus();
			}
			} 
		});
		btnAgregar.setBounds(10, 335, 85, 21);
		contentPane.add(btnAgregar);
		
		
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow()>=0) {
					modelo.elimiar(table.getSelectedRow());
				}else {
					JOptionPane.showMessageDialog(null, "No Hay Nada Seleccionado");
				}
				}
			
		});
		btnEliminar.setBounds(140, 391, 85, 21);
		contentPane.add(btnEliminar);
		
		btnEditar = new JButton("Editar ");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow()>=0) {
					Persona p = new Persona (textField_nombre.getText(), textField_apellido.getText(), Integer.parseInt(textField_edad.getText()));
					modelo.reemplazar(table.getSelectedRow(), p);
				}else {JOptionPane.showMessageDialog(null, "No Hay Nada Seleccionado");}
				
			}
		});
		btnEditar.setBounds(140, 335, 85, 21);
		contentPane.add(btnEditar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((textField_nombre.getText().equals(""))&&(textField_apellido.getText().equals(""))&&(textField_edad.getText().equals(""))) {
					JOptionPane.showMessageDialog(null, "Todos los Campos Estan Vacios");
				}else {
				textField_nombre.setText(null);
				textField_apellido.setText(null);
				textField_edad.setText(null);
				textField_nombre.requestFocus();
			}}
		});
		btnLimpiar.setBounds(10, 391, 85, 21);
		contentPane.add(btnLimpiar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(NORMAL);
			}
		});
		btnSalir.setBounds(254, 391, 128, 21);
		contentPane.add(btnSalir);
		
		JButton btnGuardar = new JButton("Guardar TXT");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelo.guardar_arraylist();
					}
		});
		btnGuardar.setBounds(438, 297, 112, 21);
		contentPane.add(btnGuardar);
		
		JLabel lblNewLabel = new JLabel("Nota: Haga click sobre la fila que desea eliminar o editar");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(10, 297, 428, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnGuardarSql = new JButton("Guardar SQL");
		btnGuardarSql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				
//					String nombre =textField_nombre.getText();
//					String apellido = textField_apellido.getText();
					String edad = textField_edad.getText();
//					Persona persona = new Persona(nombre,apellido, Integer.parseInt(edad));
//					Conexion cone = new Conexion();
//					cone.Guardar_SQL(persona);
//					new Conexion();
					if ((textField_nombre.getText().equals(""))||(textField_apellido.getText().equals(""))||(textField_edad.getText().equals(""))) {
						JOptionPane.showMessageDialog(null, "Todos los Campos Deben estar Completos");
					}else if (JOptionPane.showConfirmDialog(null, "Seguro que desea guardar en la base de datos?", "Confirmacion",JOptionPane.WARNING_MESSAGE , JOptionPane.YES_NO_OPTION, null)==JOptionPane.YES_OPTION) {
					try {
						PreparedStatement pps= cn.prepareStatement("INSERT INTO Persona (Nombre, Apellido, Edad) values(?,?,?)");
						pps.setString(1, textField_nombre.getText());
						pps.setString(2, textField_apellido.getText());
						pps.setString(3, edad);
						pps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Persona Registrada");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}catch (NullPointerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}else{
						JOptionPane.showMessageDialog(null, "Operacion Cancelada");
					}
					
				
			}
		});
		btnGuardarSql.setBounds(326, 297, 112, 21);
		contentPane.add(btnGuardarSql);
		
		JButton btnProbarConexion = new JButton("Probar conexion");
		btnProbarConexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				con.conexion();
				JOptionPane.showMessageDialog(null, "Se ha conectado la Base de Datos Correctamente");
			}
		});
		btnProbarConexion.setBounds(254, 335, 128, 21);
		contentPane.add(btnProbarConexion);
		
		JButton btnVerDatos = new JButton("Ver Datos");
		btnVerDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				con.ver();
			}
		});
		btnVerDatos.setBounds(409, 391, 85, 21);
		contentPane.add(btnVerDatos);
	
}
}