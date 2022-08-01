package Java.Programas.Ejemplos.Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


	import java.awt.Container;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.FlowLayout;
	import java.util.Calendar;
	import java.util.Date;
	import java.util.TimeZone;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import java.awt.Font;

	public class basic_clock extends JFrame
	{
	    JLabel date, time;
	    private JPanel contentPane;
	    public basic_clock()
	    {
	        super("clock");

	        ActionListener listener = new ActionListener()
	        {
	            public void actionPerformed(ActionEvent event)
	            {
	                Calendar current = Calendar.getInstance();
	                current.setTime(new Date());
	                date.setText((current.get(Calendar.MONTH) + 1) +"/" +current.get(Calendar.DATE) +"/" +current.get(Calendar.YEAR));
	                String timeStr = String.format("%d:%02d:%02d", current.get(Calendar.HOUR), current.get(Calendar.MINUTE), current.get(Calendar.SECOND));
	                time.setText(timeStr);                
	            }
	        };

	        date = new JLabel();
	        time = new JLabel();

	        setLayout(new FlowLayout());
	        setSize(310,190);
	        setResizable(false);
	        setVisible(true);

	        add(date);
	        add(time);

	        date.setFont(new Font("Arial", Font.BOLD, 64));
	        time.setFont(new Font("Arial", Font.BOLD, 64));

	        javax.swing.Timer timer = new javax.swing.Timer(500, listener);
	        timer.setInitialDelay(0);
	        timer.start();
	    }

	    public static void main(String args[])
	    {

	        basic_clock c = new basic_clock();
	        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
	}