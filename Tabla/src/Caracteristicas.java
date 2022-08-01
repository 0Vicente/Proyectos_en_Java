import java.util.Scanner; 
public class Caracteristicas {
String Animal, Peso, Altura, Raza, Color, Nombre, Edad;
public  String Atributos() {
	Scanner dt = new Scanner(System.in);
	inicio:
	System.out.println("\nQue animal es? ");
	Animal= dt.nextLine();
	System.out.println("Cual es su nombre?");
	Nombre= dt.nextLine();
	System.out.println("Cual es su edad? ");
	Edad= dt.nextLine();
	System.out.println("Cual es su altura(M)? ");
	Altura= dt.nextLine();
	System.out.println("Cual es su peso(KG)? ");
	Peso= dt.nextLine();
	System.out.println("Cual es su raza? ");
	Raza= dt.nextLine();
	System.out.println("Cual es su color? ");
	Color= dt.nextLine();
	
System.out.println("\nLos Datos de su "+Animal+" son: ");
System.out.println("Nombre: "+ Nombre+"\nEdad: "+ Edad+" años"+"\nAltura: "+ Altura+" metros"+ "\nPeso: "+Peso+" kilogramos"+"\nRaza: "+Raza+"\nColor: "+Color);
System.out.println();
	return Animal; } 

}
