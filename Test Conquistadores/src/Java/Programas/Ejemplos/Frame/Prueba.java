package Java.Programas.Ejemplos.Frame;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Prueba extends JFrame {
	static int segundos;
	static int minutos;
	static int horas;
	static boolean state=true;
	private JPanel contentPane;
	JLabel lblminutos = new JLabel("0:");
	JLabel lblsegundos = new JLabel("0");
	JLabel lblhoras = new JLabel("0:");
	private ButtonGroup pregunta1 = new ButtonGroup();
	private JRadioButton rb1rg1 = new JRadioButton("New radio button");
	private JRadioButton rb2rg1 = new JRadioButton("New radio button");
	private JRadioButton rb3rg1 = new JRadioButton("New radio button");
	public Prueba() {
		timer();
		pregunta1.add(rb1rg1);
		pregunta1.add(rb2rg1);
		pregunta1.add(rb3rg1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Prueba Historia de Amigo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 24, 471, 37);
		contentPane.add(lblNewLabel);
		
		
		rb1rg1.setBounds(54, 141, 103, 21);
		contentPane.add(rb1rg1);
		
		
		rb2rg1.setBounds(54, 164, 103, 21);
		contentPane.add(rb2rg1);
		
		
		rb3rg1.setBounds(54, 187, 103, 21);
		contentPane.add(rb3rg1);
		
		JLabel lblPregunta = new JLabel("Pregunta 1");
		lblPregunta.setBounds(56, 122, 145, 13);
		contentPane.add(lblPregunta);
		
		JLabel label = new JLabel("Pregunta 1");
		label.setBounds(56, 210, 145, 13);
		contentPane.add(label);
		
		JRadioButton radioButton = new JRadioButton("New radio button");
		radioButton.setBounds(54, 229, 103, 21);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("New radio button");
		radioButton_1.setBounds(54, 252, 103, 21);
		contentPane.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("New radio button");
		radioButton_2.setBounds(54, 275, 103, 21);
		contentPane.add(radioButton_2);
		
		
		lblminutos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblminutos.setBounds(418, 71, 26, 37);
		contentPane.add(lblminutos);
		
		JLabel lblsegundos = new JLabel("0");
		lblsegundos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblsegundos.setBounds(465, 71, 26, 37);
		contentPane.add(lblsegundos);
		
		
		lblhoras.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblhoras.setBounds(382, 71, 26, 37);
		contentPane.add(lblhoras);
	}
	
	public void timer() {
		state = true;
		Thread t = new Thread()
		{
			public void run(){
				
			for(;;) {
				if (state==true) {
					try {
						sleep(1000);
						if (segundos==0) {
							segundos=60;
							minutos--;
						}
						if (minutos==0) {
							segundos=60;
							minutos=60;
							horas--;
						}
//						if (horas==0) {
//							JOptionPane.showMessageDialog(null, "Tiempo Agotado");
//						}
						segundos--;
						lblsegundos.setText(" : "+ segundos);
						lblminutos.setText(" : "+ minutos);
						lblhoras.setText(""+ horas);
						
					} catch (Exception e) {
						// TODO: handle exception
					}
				}else {
					break;
				}
			}
		}
		};
		t.start();
	}
}
