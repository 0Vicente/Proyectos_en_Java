package Java.Programas.Proyecto_Final.Frames;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import Java.Programas.Proyecto_Final.BD.Conexion;
import Java.Programas.Proyecto_Final.Modelos.Modelo;
import Java.Programas.Proyecto_Final.Pojo.Persona;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Image;

import javax.swing.JToolBar;

public class Pantalla1 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtnombre;
	private JTextField txtapellido;
	Modelo m = new Modelo();
	Conexion cn = new Conexion();
	private boolean aa=false;
	
	private JTextField txtid;
	private JTextField txtbuscar;
	
	public Pantalla1() {
		this.setLocationRelativeTo(null);
		setResizable(false);
		setForeground(Color.WHITE);
		setTitle("Gestion de Personas");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 690, 476);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 126, 610, 193);
		contentPane.add(scrollPane);
		
		txtnombre = new JTextField();
		txtnombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (((c<'a'||c>'z')&&(c<'A'||c>'Z'))&&(c!=KeyEvent.VK_BACK_SPACE)&&(c!=KeyEvent.VK_SPACE)) { evt.consume();
				JOptionPane.showMessageDialog(null, "Este Campo Solo Acepta Letras");
				txtnombre.setText(null);}
			}
		});
		txtnombre.setBounds(59, 38, 96, 19);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);
		txtnombre.requestFocus();
		
		txtapellido = new JTextField();
		txtapellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (((c<'a'||c>'z')&&(c<'A'||c>'Z'))&&(c!=KeyEvent.VK_BACK_SPACE)&&(c!=KeyEvent.VK_SPACE)) { evt.consume();
				JOptionPane.showMessageDialog(null, "Este Campo Solo Acepta Letras");
				txtapellido.setText(null);}
			}
		});
		txtapellido.setBounds(59, 84, 96, 19);
		contentPane.add(txtapellido);
		txtapellido.setColumns(10);
		
		txtid = new JTextField();
		txtid.setBounds(69, 58, 3, 19);
		contentPane.add(txtid);
		txtid.setColumns(10);
		txtid.setVisible(false);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 41, 71, 13);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 87, 71, 13);
		contentPane.add(lblApellido);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(177, 42, 45, 13);
		contentPane.add(lblEdad);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(177, 88, 45, 13);
		contentPane.add(lblSexo);
		
		JLabel lblhagaClicSobre = new JLabel("*Haga clic sobre una persona para editarla o eliminarla");
		lblhagaClicSobre.setBounds(24, 320, 437, 13);
		contentPane.add(lblhagaClicSobre);
		
		JLabel lblBuscarPor = new JLabel("Buscar Por:");
		lblBuscarPor.setBounds(376, 41, 71, 13);
		contentPane.add(lblBuscarPor);
		
		JLabel lblNewLabel = new JLabel("Introduzca el   ");
		lblNewLabel.setBounds(376, 64, 123, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblcambio = new JLabel("Id");
		lblcambio.setBounds(456, 64, 85, 13);
		contentPane.add(lblcambio);
		
		JComboBox combosexo = new JComboBox();
		combosexo.setModel(new DefaultComboBoxModel(new String[] {"-Elige Tu Sexo-", "Masculino", "Femenino"}));
		combosexo.setSelectedIndex(0);
		combosexo.setBackground(Color.WHITE);
		combosexo.setBounds(212, 84, 118, 21);
		contentPane.add(combosexo);
		
		JComboBox comboedad = new JComboBox();
		comboedad.setMaximumRowCount(100);
		comboedad.setToolTipText("");
		comboedad.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "+70"}));
		comboedad.setSelectedIndex(0);
		comboedad.setBackground(Color.WHITE);
		comboedad.setBounds(212, 38, 118, 21);
		contentPane.add(comboedad);
		
		JButton btnConsulta = new JButton("Imprimir");
		btnConsulta.setEnabled(false);
		btnConsulta.setToolTipText("Imprime tu consulta");
		btnConsulta.addActionListener(new ActionListener() {
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
		btnConsulta.setBounds(549, 83, 85, 21);
		contentPane.add(btnConsulta);
		
		JComboBox combobuscar = new JComboBox();
		combobuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			int a= combobuscar.getSelectedIndex();
			switch (a) {
			
			case 0:
				lblcambio.setText("Id");
				lblNewLabel.setText("Introduzca el ");
				aa=false;
				break;
			case 1:
				lblcambio.setText("Nombre");
				lblNewLabel.setText("Introduzca el ");
				aa=true;
				break;
			case 2:
				lblcambio.setText("Apellido");
				lblNewLabel.setText("Introduzca el ");
				aa=true;
				break;
			case 3:
				lblcambio.setText("Edad");
				lblNewLabel.setText("Introduzca la ");
				aa=true;
				break;
			case 4:
				lblcambio.setText("Sexo");
				lblNewLabel.setText("Introduzca el ");
				aa=true;
				break;

			}
			
			}
		});
		combobuscar.setModel(new DefaultComboBoxModel(new String[] {"Id", "Nombre", "Apellido", "Edad", "Sexo"}));
		combobuscar.setBounds(446, 37, 188, 21);
		combobuscar.setBackground(Color.WHITE);
		contentPane.add(combobuscar);

		
		txtbuscar = new JTextField();
		txtbuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				m.buscar(lblcambio.getText(), txtbuscar.getText());
				if (txtbuscar.getText().equals("")) {
					btnConsulta.setEnabled(false);
				}else {
					btnConsulta.setEnabled(true);
				}
					
			}
			@Override
			public void keyTyped(KeyEvent evt) {
				if (aa==true) {
					char c = evt.getKeyChar();
					if ((c<'a'||c>'z')&&(c<'A'||c>'Z')&&(c != KeyEvent.VK_SPACE)&&(c != KeyEvent.VK_BACK_SPACE)){
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
		txtbuscar.setBounds(402, 85, 137, 19);
		contentPane.add(txtbuscar);
		txtbuscar.setColumns(10);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (((txtnombre.getText().equals("")))&&((txtapellido.getText().equals("")))&&(comboedad.getSelectedItem().toString().equals("0"))&&(combosexo.getSelectedIndex()==0)) {
					txtid.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
					txtnombre.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
					txtapellido.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
					comboedad.setSelectedItem(table.getValueAt(table.getSelectedRow(), 3).toString());
					combosexo.setSelectedItem(table.getValueAt(table.getSelectedRow(), 4).toString());
					txtid.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				}else {
					String btn[] = {"Si","No"};
					int eleccion =JOptionPane.showOptionDialog(null, "Esta a punto de sustituir los datos que hay en los campos por lo seleccionado, ¿Desea Continuar?", "Confirmar Seleccion", 0, JOptionPane.INFORMATION_MESSAGE, null, btn, this);
					if (eleccion==JOptionPane.YES_OPTION) {
					txtid.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
					txtnombre.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
					txtapellido.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
					comboedad.setSelectedItem(table.getValueAt(table.getSelectedRow(), 3).toString());
					combosexo.setSelectedItem(table.getValueAt(table.getSelectedRow(), 4).toString());
					txtid.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
					}
				}
			}
		});
		scrollPane.setViewportView(table);
		JTableHeader theheader = table.getTableHeader();
		theheader.setBackground(Color.white);
		table.setModel(m);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			int edad =  Integer.parseInt(comboedad.getSelectedItem().toString());
			String sexo = combosexo.getSelectedItem().toString();
			if (((txtnombre.getText().equals("")))||((txtapellido.getText().equals("")))||(comboedad.getSelectedItem().toString().equals("0"))||(combosexo.getSelectedIndex()==0)) {
				JOptionPane.showMessageDialog(null, "Todos los Campos Deben estar Completos");
			}else {
				m.insertar(new Persona(0,txtnombre.getText(),txtapellido.getText(), edad,sexo));
				txtnombre.setText(null);
				txtapellido.setText(null);
				txtid.setText(null);
				comboedad.setSelectedIndex(0);
				combosexo.setSelectedIndex(0);
				txtnombre.requestFocus();
			}}
		});
		btnAgregar.setBounds(24, 368, 85, 21);
		contentPane.add(btnAgregar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int edad2 =  Integer.parseInt(comboedad.getSelectedItem().toString());
				String sexo2 = combosexo.getSelectedItem().toString();	
				if ((txtnombre.getText().equals(""))||((txtapellido.getText().equals("")))||(comboedad.getSelectedIndex()==0)||(combosexo.getSelectedIndex()==0)) {
				JOptionPane.showMessageDialog(null, "No hay nada selecionado");
				txtnombre.setText(null);
				txtapellido.setText(null);
				txtid.setText(null);
				comboedad.setSelectedIndex(0);
				combosexo.setSelectedIndex(0);
				txtnombre.requestFocus();
				}else {
					int id = Integer.parseInt(txtid.getText());
					if ((txtnombre.getText().equals(table.getValueAt(table.getSelectedRow(), 1)))&&(txtapellido.getText().equals(table.getValueAt(table.getSelectedRow(), 2)))&&(combosexo.getSelectedItem().toString().equals(table.getValueAt(table.getSelectedRow(), 4)))&&(comboedad.getSelectedItem().equals(table.getValueAt(table.getSelectedRow(), 3).toString()))){
						JOptionPane.showMessageDialog(null, "No se observan cambios");
				}else {					
					m.actualizar(new Persona(id,txtnombre.getText(),txtapellido.getText(), edad2,sexo2));
					txtnombre.setText(null);
					txtapellido.setText(null);
					txtid.setText(null);
					comboedad.setSelectedIndex(0);
					combosexo.setSelectedIndex(0);					
					txtnombre.requestFocus();
				}}
				
			}
		});
		btnEditar.setBounds(137, 368, 85, 21);
		contentPane.add(btnEditar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((txtnombre.getText().equals(""))||((txtapellido.getText().equals("")))||(comboedad.getSelectedIndex()==0)||(combosexo.getSelectedIndex()==0)) {
					JOptionPane.showMessageDialog(null, "No hay nada selecionado");
					txtnombre.setText(null);
					txtapellido.setText(null);
					txtid.setText(null);
					comboedad.setSelectedIndex(0);
					combosexo.setSelectedIndex(0);
					txtnombre.requestFocus();
					}else {
						m.elimiar(table.getSelectedRow());
						txtnombre.setText(null);
						txtapellido.setText(null);
						txtid.setText(null);
						comboedad.setSelectedIndex(0);
						combosexo.setSelectedIndex(0);					
						txtnombre.requestFocus();
					}
				
			}
		});
		btnBorrar.setBounds(251, 368, 85, 21);
		contentPane.add(btnBorrar);
		
		JButton btnGenerarPdf = new JButton("Generar Reporte");
		btnGenerarPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reporte rp = new Reporte();
				Pantalla1.this.dispose();
				rp.setLocationRelativeTo(null);
				rp.setVisible(true);
			}
		});
		btnGenerarPdf.setBounds(493, 368, 141, 21);
		contentPane.add(btnGenerarPdf);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(SystemColor.textHighlight);
		toolBar.setBounds(0, 0, 83, 28);
		contentPane.add(toolBar);
		
		JButton btncerrar = new JButton("");
		btncerrar.setToolTipText("Cerrar Sesion");
		btncerrar.setBorderPainted(false);
		btncerrar.setBackground(SystemColor.textHighlight);
		Image img= new ImageIcon(getClass().getResource("/sesion.png")).getImage();
		btncerrar.setIcon(new ImageIcon(img));
		btncerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login lg = new Login();
				String btn[] = {"Si","No"};
				int eleccion =JOptionPane.showOptionDialog(null, "Esta a Punto de cerrar sesion, ¿Desea Continuar?", "Confirmacion", 0, JOptionPane.WARNING_MESSAGE, null, btn, this);
				if  (eleccion==JOptionPane.YES_OPTION) {
					Pantalla1.this.dispose();
					lg.setLocationRelativeTo(null);
					lg.setVisible(true);
					}
			}
		});
		toolBar.add(btncerrar);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cn.salir();
			}
		});
		btnNewButton.setBounds(362, 368, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("");
		Image imgs= new ImageIcon(this.getClass().getResource("/buscar.png")).getImage();
		label.setBounds(376, 75, 24, 28);
		label.setIcon(new ImageIcon(imgs));
		contentPane.add(label);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, scrollPane, table, txtnombre, txtapellido, comboedad, combosexo, combobuscar, txtbuscar, lblNombre, lblApellido, lblEdad, lblSexo, lblhagaClicSobre, lblBuscarPor, lblNewLabel, lblcambio, btnAgregar, btnEditar, btnBorrar, txtid}));
		}
}
