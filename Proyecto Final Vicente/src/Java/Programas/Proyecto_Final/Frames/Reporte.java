package Java.Programas.Proyecto_Final.Frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.text.MessageFormat;

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
import javax.swing.JTextField;
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

public class Reporte extends JFrame {

	private JPanel panel;
	private JTable table;
	private JComboBox comboBox = new JComboBox();
	private JButton btnPdf = new JButton("Gererar");
	private JButton btnPersonalizado = new JButton("Personalizado");
	Modelo m = new Modelo();
	Conexion cn = new Conexion();
	Login lg = new Login() ;
	Pantalla1 p1 = new Pantalla1();
	JButton btnatras = new JButton("");
	JButton btnImprimir = new JButton("Imprimir");
	private JTextField txtbuscar;
	private boolean aa=false;
	public Reporte() {
		setTitle("Consulta");
		this.setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 452, 363);
		panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBox_1.getSelectedIndex()==0) {
					comboBox.setEnabled(false);
					btnPdf.setEnabled(false);
					btnPersonalizado.setEnabled(false);
				}else if (comboBox_1.getSelectedIndex()==1){
					comboBox.setEnabled(true);
					btnPdf.setEnabled(true);
					btnPersonalizado.setEnabled(false);
				}else if (comboBox_1.getSelectedIndex()==2){
					comboBox.setEnabled(false);
					btnPdf.setEnabled(false);
					btnPersonalizado.setEnabled(true);
				}
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"-Elige una Opcion-", "Plantilla", "Personalizado"}));
		comboBox_1.setBounds(21, 263, 125, 21);
		panel.add(comboBox_1);
		
		JLabel label = new JLabel("");
		label.setBounds(23, 290, 45, 13);
		panel.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 101, 386, 126);
		panel.add(scrollPane);
		
		table = new JTable();
		JTableHeader theheader = table.getTableHeader();
		theheader.setBackground(Color.white);
		table.setModel(m);
		scrollPane.setViewportView(table);
		
		JLabel lblTipoDeReporte = new JLabel("Tipo de Reporte: ");
		lblTipoDeReporte.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipoDeReporte.setBounds(23, 240, 135, 13);
		panel.add(lblTipoDeReporte);
		
		
		comboBox.setEnabled(false);
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--Elige una Opcion--", "Todos", "Masculinos", "Femeninos", "Mayores de Edad "}));
		comboBox.setBounds(156, 237, 145, 21);
		panel.add(comboBox);
		
		
		btnPdf.setEnabled(false);
		btnPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conexion cn = new Conexion();
				String a = null;
				int b = comboBox.getSelectedIndex();
				if (b!=0) {
				switch (b) {
				case 1:
					a="Reporte.jasper";
					break;
				case 2:
					a="Reporte Masculinos.jasper";
					break;
				case 3:
					a="Reporte Femeninos.jasper";
					break;
				case 4:
					a="Reporte Mayores de edad.jasper";
					break;
				}
				
				String path = "Report//"+a+"";
				JasperReport jr = null;
				try {
					jr = (JasperReport) JRLoader.loadObjectFromFile(path);
					JasperPrint jp = JasperFillManager.fillReport(jr,null,cn.getconexion());
					JasperViewer jv = new JasperViewer(jp,false);
					jv.setVisible(true);
					jv.setDefaultCloseOperation(0);
					jv.setTitle(path);
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}else {
					JOptionPane.showMessageDialog(null, "Debe Elegir algun Reporte");
				}
			}
		});
		btnPdf.setBounds(324, 237, 85, 21);
		panel.add(btnPdf);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(SystemColor.textHighlight);
		toolBar.setBounds(0, 0, 85, 33);
		panel.add(toolBar);
		
		JButton btnsalir = new JButton("");
		btnsalir.setToolTipText("Cerrar Sesion");
		btnsalir.setBorderPainted(false);
		btnsalir.setBorder(null);
		btnsalir.setBackground(SystemColor.textHighlight);
		Image img= new ImageIcon(getClass().getResource("/sesion1.png")).getImage();
		btnsalir.setIcon(new ImageIcon(img));
		btnsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String btn[] = {"Si","No"};
				int eleccion =JOptionPane.showOptionDialog(null, "Esta a Punto de cerrar sesion, ¿Desea Continuar?", "Confirmacion", 0, JOptionPane.WARNING_MESSAGE, null, btn, this);
				if  (eleccion==JOptionPane.YES_OPTION) {
					Reporte.this.dispose();
					lg.setLocationRelativeTo(null);
					lg.setVisible(true);
					}
								
			}
		});
		toolBar.add(btnsalir);
		
		
		btnatras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reporte.this.dispose();
				p1.setLocationRelativeTo(null);
				p1.setVisible(true);
			}
		});
		btnatras.setBackground(SystemColor.textHighlight);
		Image img1= new ImageIcon(getClass().getResource("/back.png")).getImage();
		btnatras.setIcon(new ImageIcon(img1));
		btnatras.setBorderPainted(false);
		btnatras.setToolTipText("Regresar");
		toolBar.add(btnatras);
		
		JLabel lblIntroduzca = new JLabel("Introduzca el   ");
		lblIntroduzca.setBounds(156, 48, 95, 13);
		panel.add(lblIntroduzca);
		
		JLabel lblcambio = new JLabel("Id");
		lblcambio.setBounds(240, 48, 74, 13);
		panel.add(lblcambio);
		
		JComboBox combobuscar = new JComboBox();
		combobuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a= combobuscar.getSelectedIndex();
				switch (a) {
				
				case 0:
					lblcambio.setText("Id");
					lblIntroduzca.setText("Introduzca el ");
					aa=false;
					break;
				case 1:
					lblcambio.setText("Nombre");
					lblIntroduzca.setText("Introduzca el ");
					aa=true;
					break;
				case 2:
					lblcambio.setText("Apellido");
					lblIntroduzca.setText("Introduzca el ");
					aa=true;
					break;
				case 3:
					lblcambio.setText("Edad");
					lblIntroduzca.setText("Introduzca la ");
					aa=true;
					break;
				case 4:
					lblcambio.setText("Sexo");
					lblIntroduzca.setText("Introduzca el ");
					aa=true;
					break;

				}
			}
		});
		combobuscar.setModel(new DefaultComboBoxModel(new String[] {"Id", "Nombre", "Apellido", "Edad", "Sexo"}));
		combobuscar.setBackground(Color.WHITE);
		combobuscar.setBounds(229, 21, 85, 21);
		panel.add(combobuscar);
		
		JLabel lblNewLabel = new JLabel("Buscar por: ");
		lblNewLabel.setBounds(156, 25, 95, 13);
		panel.add(lblNewLabel);
		
		txtbuscar = new JTextField();
		txtbuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				m.buscar(lblcambio.getText(), txtbuscar.getText());
				if (txtbuscar.getText().equals("")) {
					btnImprimir.setEnabled(false);
				}else {
					btnImprimir.setEnabled(true);
				}
			}
			@Override
			public void keyTyped(KeyEvent evt) {
				if (aa==true) {
					char c = evt.getKeyChar();
					if ((c<'a'||c>'z')&&(c<'A'||c>'Z')&&(c != KeyEvent.VK_SPACE)&&(c != KeyEvent.VK_BACK_SPACE)) {
						evt.consume();
					JOptionPane.showMessageDialog(null, "Este Campo Solo Acepta Letras");
					txtbuscar.setText(null);
					}
				}else {
					char c = evt.getKeyChar();
					if ((c<'0'||c>'9')&&(c != KeyEvent.VK_SPACE)&&(c != KeyEvent.VK_BACK_SPACE)) { 
						evt.consume();
						JOptionPane.showMessageDialog(null, "Este Campo Solo Acepta Numeros");
						txtbuscar.setText(null);
					}
					}
				
			}
		});
		txtbuscar.setBounds(156, 71, 158, 19);
		panel.add(txtbuscar);
		txtbuscar.setColumns(10);
		
		
		
		btnImprimir.setEnabled(false);
		btnImprimir.setToolTipText("Imprime tu consulta");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MessageFormat encabezado =  new MessageFormat("Consulta personas registradas");
				MessageFormat pp = new MessageFormat("Pagina No. {0,number,integer}");
				
				try {
					table.print(JTable.PrintMode.NORMAL, encabezado, pp);
				} catch (PrinterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnImprimir.setBounds(324, 70, 85, 21);
		panel.add(btnImprimir);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cn.salir();
			}
		});
		btnSalir.setBounds(324, 263, 85, 21);
		panel.add(btnSalir);
		
		btnPersonalizado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reporte_Personalizado frame = new Reporte_Personalizado();
				Reporte.this.dispose();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		btnPersonalizado.setEnabled(false);
		btnPersonalizado.setBounds(156, 263, 145, 21);
		panel.add(btnPersonalizado);
		
					
	}
	
	public void ocultarboton() {
		btnatras.setEnabled(false);
		btnatras.setVisible(false);
	}
}
