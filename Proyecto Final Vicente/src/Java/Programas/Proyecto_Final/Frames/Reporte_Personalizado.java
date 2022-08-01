package Java.Programas.Proyecto_Final.Frames;

import java.awt.Color;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import Java.Programas.Proyecto_Final.BD.Conexion;
import Java.Programas.Proyecto_Final.Modelos.Modelo;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Reporte_Personalizado extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox combosexo = new JComboBox();
	private JComboBox comboedad1 = new JComboBox();
	private JComboBox comboedad2 = new JComboBox();
	private JComboBox comboid1 = new JComboBox();
	private JComboBox comboid2 = new JComboBox();
	private JComboBox comboapellido = new JComboBox();
	private JComboBox combonombre = new JComboBox();
	int id1=comboid1.getSelectedIndex();
	int id2=comboid2.getSelectedIndex();
	int edad1=comboedad1.getSelectedIndex();
	int edad2=comboedad2.getSelectedIndex();
	String sexo1;
	String sexo2;
	Modelo m = new Modelo();
	Reporte rp = new Reporte();
	Login lg = new Login();
	Conexion cn = new Conexion();
	Connection con = cn.getconexion();

	public Reporte_Personalizado() {
		llenarcomboid();
		llenarcomboedad();
		llenarcomboapellido();
		llenarcombonombre();
		setResizable(false);
		setTitle("Personalizar Reporte");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 628, 310);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblId = new JLabel("Id inicio");
		lblId.setBounds(11, 135, 45, 13);
		contentPane.add(lblId);
		
		JLabel lblNombre = new JLabel("Id final");
		lblNombre.setBounds(11, 158, 45, 13);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Edad inicio");
		lblApellido.setBounds(11, 183, 79, 13);
		contentPane.add(lblApellido);
		
		JLabel lblEdad = new JLabel("Edad final");
		lblEdad.setBounds(11, 206, 72, 13);
		contentPane.add(lblEdad);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(11, 229, 45, 13);
		contentPane.add(lblSexo);
		
		JButton btnnombre = new JButton("Generar Reporte");
		btnnombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					if (combonombre.getSelectedIndex()!=0) {
					String path = "Report//Reporte Nombre.jasper";
					JasperReport jr = null;
					Map parametros;
					parametros = new HashMap();
					parametros.put("Nombre",combonombre.getSelectedItem());
						try {
						jr = (JasperReport) JRLoader.loadObjectFromFile(path);
						JasperPrint jp = JasperFillManager.fillReport(jr, parametros, cn.getconexion());
						JasperViewer jv = new JasperViewer(jp,false);
						jv.setVisible(true);
						jv.setDefaultCloseOperation(0);
						jv.setTitle(path);
					} catch (JRException e) {
						e.printStackTrace();
					}catch(NullPointerException ex) {
						JOptionPane.showMessageDialog(null,"Los datos que suministro generan un reporte vacio");
						ex.printStackTrace();
					}
					
				}else {
					JOptionPane.showMessageDialog(null,"Debe darle un valor al campo nombre");
				}
			}
			});
		btnnombre.setEnabled(false);
		btnnombre.setBounds(275, 225, 147, 21);
		contentPane.add(btnnombre);
		
		JButton btnapellido = new JButton("Generar Reporte");
		btnapellido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboapellido.getSelectedIndex()!=0) {
					String path = "Report//Reporte Apellido.jasper";
					JasperReport jr = null;
					Map parametros;
					parametros = new HashMap();
					parametros.put("Apellido",comboapellido.getSelectedItem());
						try {
						jr = (JasperReport) JRLoader.loadObjectFromFile(path);
						JasperPrint jp = JasperFillManager.fillReport(jr, parametros, cn.getconexion());
						JasperViewer jv = new JasperViewer(jp,false);
						jv.setVisible(true);
						jv.setDefaultCloseOperation(0);
						jv.setTitle(path);
					} catch (JRException e) {
						e.printStackTrace();
					}catch(NullPointerException ex) {
						JOptionPane.showMessageDialog(null,"Los datos que suministro generan un reporte vacio");
						ex.printStackTrace();
					}
					
				}else {
					JOptionPane.showMessageDialog(null,"Debe darle un valor al campo apellido");
				}
			}
		});
		btnapellido.setEnabled(false);
		btnapellido.setBounds(275, 225, 147, 21);
		contentPane.add(btnapellido);
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cn.salir();
			}
		});
		btnSalir.setBounds(517, 225, 85, 21);
		contentPane.add(btnSalir);
		combosexo.setEnabled(false);
		
		combosexo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int b = combosexo.getSelectedIndex();
				switch(b) {
				case 1:
				sexo1="Masculino";
				sexo2="Masculino";
				break;
				case 2:
				sexo1="Femenino";
				sexo2="Femenino";
				break;
				case 3:
				sexo1="Masculino";
				sexo2="Femenino";
				break;
				}
				
			}
		});
		combosexo.setModel(new DefaultComboBoxModel(new String[] {"-Elige una opcion-", "Masculino", "Femenino", "Ambos"}));
		combosexo.setSelectedIndex(0);
		combosexo.setBounds(121, 225, 126, 21);
		combosexo.setBackground(Color.WHITE);
		contentPane.add(combosexo);
		
		JButton btnGenerarReporte = new JButton("Generar Reporte");
		btnGenerarReporte.setEnabled(false);
		btnGenerarReporte.addActionListener(new ActionListener() {
			private Map parametros;

			public void actionPerformed(ActionEvent arg0) {
				
				if (combosexo.getSelectedIndex()!=0) {
				String path = "Report//Reporte Personalizado.jasper";
				JasperReport jr = null;
				parametros = new HashMap();
				parametros.put("id", comboid1.getSelectedItem());
				parametros.put("id1", comboid2.getSelectedItem());
				parametros.put("edad", comboedad1.getSelectedItem());
				parametros.put("edad1", comboedad2.getSelectedItem());
				parametros.put("sexo", sexo1);
				parametros.put("sexo1", sexo2);
				try {
					jr = (JasperReport) JRLoader.loadObjectFromFile(path);
					JasperPrint jp = JasperFillManager.fillReport(jr, parametros, cn.getconexion());
					JasperViewer jv = new JasperViewer(jp,false);
					jv.setVisible(true);
					jv.setDefaultCloseOperation(0);
					jv.setTitle(path);
				} catch (JRException e) {
					e.printStackTrace();
				}catch(NullPointerException ex) {
					JOptionPane.showMessageDialog(null,"Los datos que suministro generan un reporte vacio");
					ex.printStackTrace();
				}
				
			}else {
				JOptionPane.showMessageDialog(null,"Debe darle un valor al campo sexo");
			}}
		});
		btnGenerarReporte.setBounds(275, 225, 147, 21);
		contentPane.add(btnGenerarReporte);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(SystemColor.textHighlight);
		toolBar.setBounds(1, 0, 72, 27);
		contentPane.add(toolBar);
		
		JButton btnCerrarSesion = new JButton("");
		btnCerrarSesion.setBorderPainted(false);
		btnCerrarSesion.setBorder(null);
		btnCerrarSesion.setToolTipText("Cerrar Sesion");
		Image img= new ImageIcon(getClass().getResource("/sesion1.png")).getImage();
		btnCerrarSesion.setIcon(new ImageIcon(img));
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String btn[] = {"Si","No"};
				int eleccion =JOptionPane.showOptionDialog(null, "Esta a Punto de cerrar sesion, ¿Desea Continuar?", "Confirmacion", 0, JOptionPane.WARNING_MESSAGE, null, btn, this);
				if  (eleccion==JOptionPane.YES_OPTION) {
					Reporte_Personalizado.this.dispose();
					lg.setLocationRelativeTo(null);
					lg.setVisible(true);
					}
				
			}
		});
		btnCerrarSesion.setBackground(SystemColor.textHighlight);
		toolBar.add(btnCerrarSesion);
		
		JButton btnAtras = new JButton("");
		btnAtras.setBorderPainted(false);
		btnAtras.setBorder(null);
		btnAtras.setToolTipText("Regresar");
		btnAtras.setBackground(SystemColor.textHighlight);
		Image img1= new ImageIcon(getClass().getResource("/back.png")).getImage();
		btnAtras.setIcon(new ImageIcon(img1));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reporte_Personalizado.this.dispose();
				rp.setLocationRelativeTo(null);
				rp.setVisible(true);
			}
		});
		toolBar.add(btnAtras);
		comboedad2.setEnabled(false);
		comboedad2.setSelectedIndex(0);
		
		
		comboedad2.setBounds(121, 202, 126, 21);
		comboedad2.setBackground(Color.WHITE);
		contentPane.add(comboedad2);
		comboedad1.setEnabled(false);
		comboedad1.setSelectedIndex(0);
		
		
		comboedad1.setBounds(121, 179, 126, 21);
		comboedad1.setBackground(Color.WHITE);
		contentPane.add(comboedad1);
		comboid2.setEnabled(false);
		comboid2.setSelectedIndex(-1);
		comboapellido.setEnabled(false);
			comboapellido.setBounds(121, 97, 126, 21);
		comboapellido.setBackground(Color.WHITE);
		contentPane.add(comboapellido);
		
		
		comboid2.setBounds(121, 154, 126, 21);
		comboid2.setBackground(Color.WHITE);
		contentPane.add(comboid2);
		comboid1.setEnabled(false);
		comboid1.setSelectedIndex(0);
		
		
		comboid1.setBounds(121, 131, 126, 21);
		comboid1.setToolTipText("Nota: Para elegir una sola persona solo debe repetir el valor de Id y darle el mayor rango a los demas campos");
		comboid1.setBackground(Color.WHITE);
		contentPane.add(comboid1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(275, 43, 327, 176);
		contentPane.add(scrollPane);
		 
		
		table = new JTable();
		table.setBackground(SystemColor.text);
		JTableHeader theheader = table.getTableHeader();
		theheader.setBackground(Color.white);
		table.setModel(m);
		scrollPane.setViewportView(table);
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(11, 78, 45, 13);
		contentPane.add(lblNombre_1);
		
		JLabel lblApellido_1 = new JLabel("Apellido");
		lblApellido_1.setBounds(11, 101, 45, 13);
		contentPane.add(lblApellido_1);
		combonombre.setEnabled(false);
		
		
		combonombre.setBounds(122, 74, 125, 21);
		combonombre.setBackground(Color.white);
		contentPane.add(combonombre);
		
		JLabel lblPersonalizaPor = new JLabel("Personaliza Por: ");
		lblPersonalizaPor.setBounds(11, 46, 99, 13);
		contentPane.add(lblPersonalizaPor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int b=comboBox.getSelectedIndex();
				switch(b) {
				case 0:
					combonombre.setEnabled(false);
					btnnombre.setEnabled(false);
					btnnombre.setVisible(false);
					comboapellido.setEnabled(false);
					comboid1.setEnabled(false);
					comboid2.setEnabled(false);
					comboedad1.setEnabled(false);
					comboedad2.setEnabled(false);
					combosexo.setEnabled(false);
					btnapellido.setEnabled(false);
					btnapellido.setVisible(false);
					btnGenerarReporte.setEnabled(false);
					btnGenerarReporte.setVisible(false);
				break;
				case 1:
					combonombre.setEnabled(true);
					btnnombre.setEnabled(true);
					btnnombre.setVisible(true);
					comboapellido.setEnabled(false);
					comboid1.setEnabled(false);
					comboid2.setEnabled(false);
					comboedad1.setEnabled(false);
					comboedad2.setEnabled(false);
					combosexo.setEnabled(false);
					btnapellido.setEnabled(false);
					btnapellido.setVisible(false);
					btnGenerarReporte.setEnabled(false);
					btnGenerarReporte.setVisible(false);
				break;
				case 2:
					combonombre.setEnabled(false);
					btnnombre.setEnabled(false);
					btnnombre.setVisible(false);
					comboapellido.setEnabled(true);
					comboid1.setEnabled(false);
					comboid2.setEnabled(false);
					comboedad1.setEnabled(false);
					comboedad2.setEnabled(false);
					combosexo.setEnabled(false);
					btnapellido.setEnabled(true);
					btnapellido.setVisible(true);
					btnGenerarReporte.setEnabled(false);
					btnGenerarReporte.setVisible(false);
				break;
				case 3:
					combonombre.setEnabled(false);
					btnnombre.setEnabled(false);
					btnnombre.setVisible(false);
					comboapellido.setEnabled(false);
					comboid1.setEnabled(true);
					comboid2.setEnabled(true);
					comboedad1.setEnabled(true);
					comboedad2.setEnabled(true);
					combosexo.setEnabled(true);
					btnapellido.setEnabled(false);
					btnapellido.setVisible(false);
					btnGenerarReporte.setEnabled(true);
					btnGenerarReporte.setVisible(true);
				break;
				
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-Elige una opcion-", "Por nombre", "Por apellido", "Libre"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(121, 43, 126, 21);
		contentPane.add(comboBox);
		
		
	}
	
	public void llenarcomboid() {
		ResultSet rs= null;
		try {
			Statement query = con.createStatement();
			rs = query.executeQuery("select id from persona");
			while(rs.next()) {
				comboid1.addItem(rs.getObject(1));
				comboid2.addItem(rs.getObject(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void llenarcombonombre() {
		ResultSet rs= null;
		try {
			Statement query = con.createStatement();
			rs = query.executeQuery("select distinct nombre from persona order by edad asc");
			while(rs.next()) {
				combonombre.addItem(rs.getObject(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void llenarcomboapellido() {
		ResultSet rs= null;
		try {
			Statement query = con.createStatement();
			rs = query.executeQuery("select distinct apellido from persona order by edad asc");
			while(rs.next()) {
				comboapellido.addItem(rs.getObject(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void llenarcomboedad() {
		ResultSet rs= null;
		try {
			Statement query = con.createStatement();
			rs = query.executeQuery("select distinct edad from persona order by edad asc");
			while(rs.next()) {
				comboedad1.addItem(rs.getObject(1));
				comboedad2.addItem(rs.getObject(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setear() {
		sexo1="Masculino";
		sexo2="Femenino";
	}
}
