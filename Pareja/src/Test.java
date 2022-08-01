import java.util.Scanner;

public class Test {
	String b,c,e;
	int a,d;
	Scanner dt = new Scanner(System.in);
	
	
	public void preguntar() {
	System.out.println("Utiliza 1 para si y 2 para no\n");
	System.out.println("Me quieres?");
	a=dt.nextInt();
	if (a==1) {
		System.out.println("\nDel 1 al 100, cuanto me quieres?");
		b= dt.next();
		System.out.println("\nPues yo te quiero "+b+"+3MSC");
	}else {
		System.out.println("\nTarada");
	}}
	
	
	public void casar() {
		System.out.println("\nUtiliza 1 para si y 2 para no\n");
		System.out.println("Te Quieres Casar Conmigo?");
		a=dt.nextInt();
		if (a==1) {
			System.out.println("\nCual es tu nombre? ");
			b= dt.next();
			System.out.println("\nCual es tu apellido? ");
			c= dt.next();
			System.out.println("\nDesde ahora seras "+b+" "+c+" De Luna");
			System.out.println("\nCuantos hijos quiere tener se�ora De Luna? ");
			d=dt.nextInt();
			if (d==2) {
				System.out.println("\nPerfecto");
			} else if(d<2) {
				System.out.println("Podemos Tener 2 :(");
			}else if(d<1) {
				System.out.println("Quiero tener 2 :(");
			}else if (d<5) {
				System.out.println("Solo si la economia esta muy buena");
			}else if (d<12) {
				System.out.println("Te estas Pasando");
			}else if (d==12) {
				System.out.println("Minimo un equipo de futball");
			}else if (d>12) {
				System.out.println("ESTAS LOCA");
			}
		}else {
			System.out.println("\nTarada");
		}	
		
	}
	
}