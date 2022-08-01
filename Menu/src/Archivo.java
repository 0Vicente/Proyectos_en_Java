import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Archivo {
	int salir;
	FileWriter fr;
	Scanner dt = new Scanner (System.in);
	BufferedWriter bw;
	File arc = new File("C:\\Users\\Vicente Luna\\Desktop\\txt\\Vicente.txt");
	public void escribir() throws IOException {
		String cp="", cp1;
		FileWriter wr = new FileWriter(arc);
		PrintWriter see = new PrintWriter(wr);
		System.out.println("Introduzca el texto: ");
		cp=dt.nextLine();
		see.write(cp);
		see.close();
	}
	
	public void leer() throws IOException {
		String lectura;
		FileReader fr = new FileReader(arc);
		BufferedReader br = new BufferedReader(fr);
		while ((lectura=br.readLine()) != null) {
			System.out.println(lectura);
		}
		}
	
	public void escribirPersona(Person nueva) throws IOException {
		File person = new File("C:\\Users\\Vicente Luna\\Desktop\\txt\\Personas.txt");
		if (person.exists()) {
		fr = new FileWriter(person,true);
		bw = new BufferedWriter(fr);
		bw.newLine();
		bw.write("Persona "+nueva.nombre1+"\r\n\r\n"+"Nombre: "+nueva.nombre1+"\r\nApellido: "+nueva.apellido1+"\r\nCedula: "+nueva.cedula1+"\r\n ");
		}else {
			fr = new FileWriter(person);
			bw = new BufferedWriter(fr);
			bw.write("*Nombre: "+nueva.nombre1+" "+" *Apellido: "+nueva.apellido1+" "+" *Cedula: "+nueva.cedula1);
		}
		bw.flush();
		bw.close();
		fr.close();
	}
	
	public void leerPersona() throws IOException, InterruptedException {
		String linea;
		while(salir!=1) {
			System.out.println("\nPrograma Leer Persona\n");
		File person = new File("C:\\Users\\Vicente Luna\\Desktop\\txt\\Personas.txt");
		FileReader fr = new FileReader(person);
		BufferedReader br = new BufferedReader(fr);
		while ((linea=br.readLine()) != null) {
			System.out.println(linea);
		}try {
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
		}}
		}
	 public void pedirDatos() throws IOException, InterruptedException {
		String aa,bb,cc;
		while(salir!=1){
		System.out.println("\nPrograma para introducir persona\n\n");
			System.out.println("Introduce el nombre: ");
			aa=dt.nextLine();
			System.out.println("Introduce el apellido: ");
			bb=dt.nextLine();
			System.out.println("Introduce la cedula: ");
			cc=dt.nextLine();
			Archivo hola = new Archivo();
		    hola.escribirPersona(new Person(aa, bb,cc));
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
		}}
	
	}
}