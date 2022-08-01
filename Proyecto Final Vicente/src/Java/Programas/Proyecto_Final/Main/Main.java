package Java.Programas.Proyecto_Final.Main;
import javax.swing.JFrame;

import org.jvnet.substance.SubstanceDefaultLookAndFeel;

import Java.Programas.Proyecto_Final.Frames.Login;
import Java.Programas.Proyecto_Final.Frames.Reporte_Personalizado;

public class Main {
		
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		SubstanceDefaultLookAndFeel.setSkin("org.jvnet.substance.skin.OfficeBlue2007Skin");
		SubstanceDefaultLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceAquaTheme");
		SubstanceDefaultLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceNullWatermark");
		Login frame = new Login();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
			}

}	