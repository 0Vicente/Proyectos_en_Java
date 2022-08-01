import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import org.jvnet.substance.SubstanceDefaultLookAndFeel;

public class Pantalla1 extends JFrame {

	FileWriter fr;
	BufferedWriter bw;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	 private JTextArea JTextArea1 = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla1 frame = new Pantalla1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pantalla1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(220, 10, 182, 153);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnBorrar = new JButton("Guardar");
		btnBorrar.setBounds(21, 173, 85, 21);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre, apellido;
				int edad;
				nombre= textField.getText();
				apellido= textField_1.getText();
				edad= Integer.parseInt(textField_2.getText());
				File person = new File("D:\\Users\\thebo\\Documents\\Programas\\Programas en Java\\Archivo de Datos Personales\\Personas_Pantalla.txt");
				if (person.exists()) {
				try {
					fr = new FileWriter(person,true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				bw = new BufferedWriter(fr);
				try {
					bw.newLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					bw.write("Persona "+nombre+"\r\n\r\n"+"Nombre: "+nombre+"\r\nApellido: "+apellido+"\r\nEdad: "+edad+"\r\n ");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}else {
					try {
						fr = new FileWriter(person);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					bw = new BufferedWriter(fr);
					try {
						bw.write("Persona "+nombre+"\r\n\r\n"+"Nombre: "+nombre+"\r\nApellido: "+apellido+"\r\nEdad: "+edad+"\r\n ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					bw.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Los Datos de "+nombre+" han sido guardados");
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnBorrar);
		
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(125, 218, 85, 21);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(NORMAL);
			}
		});
		contentPane.add(btnSalir);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(21, 218, 85, 21);
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textArea.setText(null);
			}
		});
		contentPane.add(btnLimpiar);
		
		textField = new JTextField();
		textField.setBounds(114, 18, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(114, 57, 96, 19);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(114, 96, 96, 19);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(31, 24, 75, 13);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(31, 63, 75, 13);
		contentPane.add(lblApellido);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(31, 102, 73, 13);
		contentPane.add(lblEdad);
		
		
		
		JButton btnGuardarComo = new JButton("Guardar como");
		btnGuardarComo.setBounds(270, 173, 132, 21);
		btnGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fs = new JFileChooser(new File("C:\\Documents"));
				fs.setDialogTitle("Guardar Archivo");
				fs.setFileFilter(new FileTypeFilter(".txt", "Archivos de texto plano"));
				fs.setFileFilter(new FileTypeFilter(".doc", "Documentos Word"));
				fs.setFileFilter(new FileTypeFilter(".docx", "Documentos Word"));
				fs.setFileFilter(new FileTypeFilter(".pdf", "PDF"));
				int result = fs.showSaveDialog(null);
				if (result==JFileChooser.APPROVE_OPTION) {
					String nombre = textField.getText();
					String apellido = textField_1.getText();
					int edad = edad= Integer.parseInt(textField_2.getText());
					File person = fs.getSelectedFile();
					if (person.exists()) {
					try {
						fr = new FileWriter(person.getPath());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					bw = new BufferedWriter(fr);
					try {
						bw.newLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						bw.write("Persona "+nombre+"\r\n\r\n"+"Nombre: "+nombre+"\r\nApellido: "+apellido+"\r\nEdad: "+edad+"\r\n ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}else {
						try {
							fr = new FileWriter(person);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						bw = new BufferedWriter(fr);
						try {
							bw.write("Persona "+nombre+"\r\n\r\n"+"Nombre: "+nombre+"\r\nApellido: "+apellido+"\r\nEdad: "+edad+"\r\n ");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					try {
						bw.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						bw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						fr.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Los Datos de "+nombre+" han sido guardados");
				} else if (result==JFileChooser.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null,"Proceso no terminado");
				}
			}
		});
		contentPane.add(btnGuardarComo);
		JButton btnLeer = new JButton("Leer");
		btnLeer.setBounds(125, 173, 85, 21);
		btnLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String linea;
				File person = new File("D:\\Users\\thebo\\Documents\\Programas\\Programas en Java\\Archivo de Datos Personales\\Personas_Pantalla.txt");
				FileReader fr = null;
				try {
					fr = new FileReader(person);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BufferedReader br = new BufferedReader(fr);
				try {
					while ((linea=br.readLine()) != null) {
						System.out.println(linea);
						textArea.append(linea+"\n");
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
			}
		});
		contentPane.add(btnLeer);
		
		JButton btnLeer_1 = new JButton("Leer Archivo");
		btnLeer_1.setBounds(270, 218, 132, 21);
		btnLeer_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String ruta="";
			String linea;
			textArea.setText(null);	
			JFileChooser FC = new JFileChooser();
			FC.setFileFilter(new FileTypeFilter(".txt", "Archivos de texto plano"));
			FC.setFileFilter(new FileTypeFilter(".doc", "Documentos Word"));
			FC.setFileFilter(new FileTypeFilter(".docx", "Documentos Word"));
			int chooser = FC.showOpenDialog(FC);
			if (chooser==JFileChooser.APPROVE_OPTION) {
				ruta = FC.getSelectedFile().getPath();
				File person = new File(ruta);
				FileReader fr = null;
				try {
					fr = new FileReader(person);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BufferedReader br = new BufferedReader(fr);
				try {
					while ((linea=br.readLine()) != null) {
						System.out.println(linea);
						textArea.append(linea+"\n");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
			}else if(chooser==JFileChooser.CANCEL_OPTION) {
				JOptionPane.showMessageDialog(null,"No se ha especificado ningun archivo para leer");
			}
			
			}
		});
		contentPane.add(btnLeer_1);
	}
}
