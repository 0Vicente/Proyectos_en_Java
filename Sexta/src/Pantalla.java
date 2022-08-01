import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


public class Pantalla extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnRestar;
	private JButton btnNewButton;
	private JButton btnDividir;
	private JButton btnLimpiar;
	private JButton btnRealizarTabla;
	private JTextField textField_3;
	private JLabel lblNewLabel;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla frame = new Pantalla();
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
	public Pantalla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNombre = new JLabel("Variable 1");
		lblNombre.setBounds(25, 30, 56, 14);
		contentPane.add(lblNombre);
		
		JButton btnMostrar = new JButton("Sumar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a,b,c;
				a=  Integer.parseInt(textField.getText());
				b=  Integer.parseInt(textField_1.getText());
				c=a+b;
				textField_2.setText(String.valueOf(c));
			}
		});
		btnMostrar.setBounds(10, 137, 89, 23);
		contentPane.add(btnMostrar);
		
		JLabel lblVariable = new JLabel("Variable 2");
		lblVariable.setBounds(25, 61, 56, 14);
		contentPane.add(lblVariable);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(25, 92, 56, 14);
		contentPane.add(lblResultado);
		
		textField = new JTextField();
		textField.setBounds(118, 27, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(118, 58, 86, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(118, 89, 86, 20);
		contentPane.add(textField_2);
		
		btnRestar = new JButton("Restar");
		btnRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a,b,c;
				a=  Integer.parseInt(textField.getText());
				b=  Integer.parseInt(textField_1.getText());
				c=a-b;
				textField_2.setText(String.valueOf(c));
			}
		});
		btnRestar.setBounds(109, 137, 89, 23);
		contentPane.add(btnRestar);
		
		btnNewButton = new JButton("Multiplicar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a,b,c;
				a=  Integer.parseInt(textField.getText());
				b=  Integer.parseInt(textField_1.getText());
				c=a*b;
				textField_2.setText(String.valueOf(c));
			}
		});
		btnNewButton.setBounds(208, 137, 89, 23);
		contentPane.add(btnNewButton);
		
		btnDividir = new JButton("Dividir");
		btnDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a,b,c;
				a=  Integer.parseInt(textField.getText());
				b=  Integer.parseInt(textField_1.getText());
				c=a/b;
				textField_2.setText(String.valueOf(c));
			}
		});
		btnDividir.setBounds(318, 137, 89, 23);
		contentPane.add(btnDividir);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
			}
		});
		btnLimpiar.setBounds(109, 185, 89, 23);
		contentPane.add(btnLimpiar);
		
		btnRealizarTabla = new JButton("Realizar Tabla");
		btnRealizarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int z;
				Tabla table = new Tabla();
				z = Integer.parseInt(textField_3.getText());
				table.tabla(z);
			}
		});
		btnRealizarTabla.setBounds(252, 57, 133, 23);
		contentPane.add(btnRealizarTabla);
		
		textField_3 = new JTextField();
		textField_3.setBounds(315, 27, 109, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		lblNewLabel = new JLabel("Numero para la tabla");
		lblNewLabel.setBounds(214, 30, 126, 14);
		contentPane.add(lblNewLabel);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(NORMAL);
			}
		});
		btnSalir.setBounds(208, 185, 89, 23);
		contentPane.add(btnSalir);
	}
}

