package Java.Programas.Proyecto_Final.Pojo;

public class Datos {

	private String user;
	private String pass;
	private String nivel;
	
	public Datos(String user, String pass, String nivel) {
		this.user = user;
		this.pass = pass;
		this.nivel = nivel;
	}
	
	
	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getNivel() {
		return nivel;
	}


	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

}
