package Java.Programas.Ejemplos.Frame;

import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Temporizador extends JFrame {

	private JPanel contentPane;
	private Timer t;
	private int segundos= 60;
	private int minutos = 2;
	private int cont=0;
	public Temporizador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 227, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbltimer = new JLabel("00");
		lbltimer.setHorizontalAlignment(SwingConstants.CENTER);
		lbltimer.setBackground(SystemColor.textHighlight);
		lbltimer.setBounds(148, 30, 29, 40);
		contentPane.add(lbltimer);
		
		JLabel lblNewLabel = new JLabel("2:");
		lblNewLabel.setBounds(93, 44, 45, 13);
		contentPane.add(lblNewLabel);
		
		JButton btninicio = new JButton("Start");
		btninicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t = new Timer(1000,new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {

						lbltimer.setText(""+segundos);
						lblNewLabel.setText(minutos+":");
						if (segundos==0) {
							if (minutos==0) {
								cont++;
								System.out.println(cont);
								if (cont==1) {
									t.stop();
									cont=0;
									segundos=60;
									minutos=2;
									lbltimer.setText("00");
									lblNewLabel.setText(minutos+":");
								}
							}else {
								segundos=60;
								minutos--;	
							}
						}if (cont!=1) {segundos--;}
						}
				}
				);
						t.start();
						minutos--;
						segundos--;
			}
		});
		btninicio.setBounds(1, 80, 85, 21);
		contentPane.add(btninicio);
		
		JButton btnNewButton_1 = new JButton("Stop");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t.stop();
			}
		});
		btnNewButton_1.setBounds(96, 80, 85, 21);
		contentPane.add(btnNewButton_1);
		
		
	}
}
