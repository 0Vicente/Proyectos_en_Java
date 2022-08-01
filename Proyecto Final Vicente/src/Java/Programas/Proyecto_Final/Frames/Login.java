package Java.Programas.Proyecto_Final.Frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Java.Programas.Proyecto_Final.BD.Conexion;

public class Login extends JFrame {
	Conexion cn = new Conexion();
	int cont = 0;	
	private JPanel contentPane;
	private JTextField txtuser;
	private JPasswordField txtpass;
	interface ClickEnterListener extends ActionListener, KeyListener {
	     
	     default public void actionPerformed( ActionEvent e ) {
	         System.out.println("ap");
	     }
	     default public void keyPressed( KeyEvent ke ) {        
	         if (ke.getKeyCode() == KeyEvent.VK_ENTER) {            
	             realAction();
	         }
	      }
	     default public void keyReleased( KeyEvent ke ) {}
	     default public void keyTyped( KeyEvent ke ) {}

	     void realAction();
	}  
	public Login() {	
		Login.this.setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Login\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 332);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDebeContactarCon = new JLabel("Debe contactar uno de los administradores");
		lblDebeContactarCon.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDebeContactarCon.setVisible(false);
		lblDebeContactarCon.setBounds(10, 79, 304, 13);
		contentPane.add(lblDebeContactarCon);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(31, 151, 87, 13);
		contentPane.add(lblUsuario);
		
		txtuser = new JTextField();
		txtuser.setBounds(128, 148, 141, 19);
		contentPane.add(txtuser);
		txtuser.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasea.setBounds(31, 177, 87, 13);
		contentPane.add(lblContrasea);
		
		JLabel label = new JLabel("");
		Image imgs= new ImageIcon(this.getClass().getResource("/login-icon.png")).getImage();
		label.setBounds(102, 29, 126, 112);
		label.setIcon(new ImageIcon(imgs));
		contentPane.add(label);
		
		txtpass = new JPasswordField();
		txtpass.setEchoChar('*');
		txtpass.setBounds(128, 175, 141, 19);
		contentPane.add(txtpass);
		
		JRadioButton rdbtnMostrarContrasea = new JRadioButton("Mostrar Contrase\u00F1a");
		rdbtnMostrarContrasea.setBackground(SystemColor.textHighlight);
		rdbtnMostrarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnMostrarContrasea.isSelected()) {
					txtpass.setEchoChar((char)0);
				}else {
					txtpass.setEchoChar('*');
				}
			}
		});
		rdbtnMostrarContrasea.setBounds(128, 200, 141, 21);
		contentPane.add(rdbtnMostrarContrasea);
		
		
		JButton btnIniciarSe = new JButton("  Iniciar Sesion");
		btnIniciarSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = txtuser.getText();
				String pass = new String (txtpass.getPassword());
				if ((user.equals(""))||(pass.equals(""))) {
					JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
				}else if (cn.ingresar(user, pass)) {
				Login.this.dispose();
			} else if (cont<2) {
				cont= cont+1;
				JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrecto");
				txtuser.setText(null);
				txtpass.setText(null);
				}else {
					JOptionPane.showMessageDialog(null, "Ha excedido el numero de intentos, contacte con el administrador");
					btnIniciarSe.setEnabled(false);
					label.setVisible(false);
					lblDebeContactarCon.setVisible(true);
					txtuser.setText(null);
					txtpass.setText(null);
					rdbtnMostrarContrasea.setEnabled(false);
					txtuser.setEnabled(false);
					txtpass.setEnabled(false);
			}
				}
		});
		btnIniciarSe.setBackground(new Color(240, 255, 255));
		Image img= new ImageIcon(getClass().getResource("/descarga.jpg")).getImage();
		btnIniciarSe.setIcon(new ImageIcon(img));
		btnIniciarSe.setBounds(88, 234, 147, 33);
		contentPane.add(btnIniciarSe);
		}
  
}
