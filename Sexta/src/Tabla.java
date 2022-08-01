import javax.swing.JOptionPane;
import javax.swing.JTextPane;


public class Tabla {

	public void tabla(int z){
		for (int i = 1; i <= 12; i++) {
			JOptionPane.showMessageDialog(null,z+ " X "+ i + " = "+ z*i, "Tabla", JOptionPane.OK_OPTION);
			System.out.println(z+ " X "+ i + " = "+ z*i);
		}
		
	}
}
