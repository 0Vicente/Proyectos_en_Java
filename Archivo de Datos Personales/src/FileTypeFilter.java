import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FileTypeFilter extends FileFilter{
	
	private final String extension;
	private final String descripcion;
	
	public FileTypeFilter (String extension, String descripcion) {
		this.extension= extension;
		this.descripcion=descripcion;
	}
	
	public boolean accept (File file) {
		if (file.isDirectory()) {
			return true;
		}
		return file.getName().endsWith(extension);		
	}
	
	public String getDescription() {
		return descripcion + String.format("(*%s)", extension);
	}

}
