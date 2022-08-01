import java.io.IOException;
import java.util.Scanner;
public class Main {
	Scanner dt = new Scanner(System.in);
public static void main(String[] args) throws InterruptedException, IOException {	
	int opc,a,b,c;
	float resultado;
	String aa,bb,cc;
	do {
		System.out.println("\n-----Menu-----\n");
		System.out.println("0. Salir");
		System.out.println("1. Sacar el numero Mayor");
		System.out.println("2. Sacar el numero Menor");
		System.out.println("3. Suma");
		System.out.println("4. Resta");
		System.out.println("5. Multiplicacion");
		System.out.println("6. Divicion");
		System.out.println("7. Serie Fibonacci");
		System.out.println("8. Tabla de Multiplicar");
		System.out.println("9. Calculo dias de un mes");
		System.out.println("10. Datos de una persona");
		System.out.println("11. Agregar Persona a TXT");
		System.out.println("12. Ver Personas de TXT");
		System.out.println("\nELige una opcion: ");
		
		Scanner dt = new Scanner(System.in);
		opc=dt.nextInt();
		if ((opc!=1)&&(opc!=2)&&(opc!=3)&&(opc!=4)&&(opc!=5)&&(opc!=6)&&(opc!=7)&&(opc!=8)&&(opc!=9)&&(opc!=0)&&(opc!=10)&&(opc!=11)&&(opc!=12)) {
			System.out.println("\nEsta no es una opcion valida\nPor Favor Intente de nuevo");
			Thread.sleep(3000);
		}
		Archivo hola = new Archivo();
		Matematicas ms = new Matematicas();
		
		switch (opc) {
		
		case 1:
			ms.Mayor();
			break;
		case 2:
			ms.Menor();
			break;
			
		case 3:
			ms.sumar();
			break;
		case 4:
			ms.restar();
			break;
		case 5:
			ms.multiplicar();
			break;
		case 6:
			ms.dividir();
		case 7:
			ms.fibonacci();
			break;
		case 8:
			ms.tabla();
			break;
		case 9:
			Meses mes = new Meses();
			mes.Dias();
			break;
		case 10:
			Persona p = new Persona();
			p.Plantilla();
			break;
		case 11:
			hola.pedirDatos();
			break;
		case 12:
			hola.leerPersona();
			break;
			
		}
			
	}while(opc!=0);
	
	}

}
