import java.util.Scanner;
public class Opciones {
	int opc,a,b,c;
	float resultado;
public int seleccionar() {
	do {
	System.out.println("\n-----Menu-----\n");
	System.out.println("1. Sacar el numero Mayor");
	System.out.println("2. Sacar el numero Menor");
	System.out.println("3. Suma");
	System.out.println("4. Resta");
	System.out.println("5. Multiplicacion");
	System.out.println("6. Divicion");
	System.out.println("7. Serie Fibonacci");
	System.out.println("8. Tabla de Multiplicar");
	System.out.println("9. Mes");
	System.out.println("\nELige una opcion: ");
	
	Scanner dt = new Scanner(System.in);
	opc=dt.nextInt();
	if ((opc!=1)&&(opc!=2)&&(opc!=3)&&(opc!=4)&&(opc!=5)&&(opc!=6)&&(opc!=7)&&(opc!=8)&&(opc!=9)&&(opc!=0)) {
		System.out.println("\nEsta no es una opcion valida\nPor Favor Intente de nuevo");
	}
	
	switch (opc) {
	
	case 1:
		
	
	}
	
	
	
	
}while(opc!=0);
	return c;	
}

}


