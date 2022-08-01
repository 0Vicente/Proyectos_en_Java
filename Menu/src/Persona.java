import java.util.Scanner;

public class Persona {
	private String apellido;
	private String sexo;
	private String nacionalidad;
	private String estado;
	private String fecha;
	private String cedula;
	private int edad;
	private String nombre;
	String a;
	int salir;
	 
Scanner dt = new Scanner(System.in);
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public String getSexo() {
	return sexo;
}
public void setSexo(String sexo) {
	this.sexo = sexo;
}
public String getNacionalidad() {
	return nacionalidad;
}
public void setNacionalidad(String nacionalidad) {
	this.nacionalidad = nacionalidad;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}
public String getCedula() {
	return cedula;
}
public void setCedula(String cedula) {
	this.cedula = cedula;
}
public int getEdad() {
	return edad;
}
public void setEdad(int edad) {
	this.edad = edad;
}
public String Plantilla() throws InterruptedException {
	Persona p =new Persona();
	String nom, ap, sex, nac, est, fec, ced;
	int edad;
	while(salir!=1){
		System.out.println("\nPlantilla de una persona");
		System.out.println();
		System.out.println("Ingrese el Nombre: ");
		nom=dt.nextLine();
		System.out.println("Ingrese el Apellido: ");
		ap=dt.nextLine();
		System.out.println("Ingrese su Cedula: ");
		ced=dt.nextLine();
		System.out.println("Ingrese el Estado Civil: ");
		est=dt.nextLine();
		System.out.println("Ingrese el Nacionalidad: ");
		nac=dt.nextLine();
		System.out.println("Ingrese el Fecha de Nacimiento: ");
		fec=dt.nextLine();
		System.out.println("Ingrese el Sex: ");
		sex=dt.nextLine();
		System.out.println("Ingrese el Edad: ");
		edad=dt.nextInt();
		p.setNombre(nom);
		p.setApellido(ap);
		p.setSexo(sex);
		p.setNacionalidad(nac);
		p.setEstado(est);
		p.setFecha(fec);
		p.setCedula(ced);
		p.setEdad(edad);
		System.out.println("\nLos Datos de "+nom+" son:\n");
		System.out.println("Nombre: "+p.getNombre()+"\nApellido: "+p.getApellido()+"\nCedula: "+ p.getCedula()+" \nFecha de Nac: "+p.getFecha()+"\nEdad: "+p.getEdad()+"\nSexo: "+p.getSexo()+"\nNacionalidad: "+p.getNacionalidad()+"\nEstado civil: "+p.getEstado());
		try {
			System.out.println("\nDesea Salir?(1=si/2=no)> ");
			salir = dt.nextInt();
		} catch (Exception e) {
			System.out.println("Debe introducir solo numeros");
			System.out.println("Fin");
			Thread.sleep(3000);
			salir=1;
		}
		if ((salir!=1)&&(salir!=2)) {
			System.out.println("Esta no es una opcion valida");	
		}
	}
	return a;
}
}
