import java.util.Scanner;
public class Promedio {
public static void main (String [] args) {

	float n1,n2,n3,n4, nt;
	Scanner P = new Scanner(System.in);
	System.out.println("Ingrese La Nota del Primer Mes");
	n1= P.nextFloat();
	System.out.println("Ingrese La Nota del Segundo Mes");
	n2= P.nextFloat();
	System.out.println("Ingrese La Nota del Tercer Mes");
	n3= P.nextFloat();
	System.out.println("Ingrese La Nota del Cuarto Mes");
	n4= P.nextFloat();
	nt=(n1+n2+n3+n4)/4;
	System.out.println();
	System.out.println("Su Nota Promedio es: " + nt);
	}}
