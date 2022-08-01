import java.util.Scanner;
public class Meses {

	public int Dias() {
		
		int salir,mes,dias=0,a;
		mes=0;
		a=0;
		salir=2;
	    Scanner dt= new Scanner(System.in);
	    while (salir!=1) {
	    System.out.println("\nPrograma para determinar los dias de un mes\n");
	    try {
			System.out.println("Ingrese el Mes: ");
			mes = dt.nextInt();
		} catch (Exception e) {
			System.out.println("Debe introducir solo numeros enteros");
		}
	    if((mes!=1)&&(mes!=2)&&(mes!=3)&&(mes!=4)&&(mes!=5)&&(mes!=6)&&(mes!=7)&&(mes!=8)&&(mes!=9)&&(mes!=10)&&(mes!=11)&&(mes!=12)) {
	    	System.out.println("Este no es un mes valido");
	    	continue;
	    }
		try {
			System.out.println("\nIngrese el Año: ");
			a = dt.nextInt();
		} catch (Exception e) {
			System.out.println("Debe introducir solo numeros enteros");
		}
		
	switch (mes)
	{
	case 1: case 3: case 5: case 7: case 8: case 10: case 12:
	dias = 31;
	break;
	case 4: case 6: case 9: case 11:
	dias = 30;
	break;
	case 2:
	if(a%4==0){
		dias = 29;
	 }   else
	dias=28;
	break;
	default:
		System.out.println("\nEl mes no es Valido");
	break;
	}
	System.out.println("\nEse mes tiene "+dias+" dias");
	
		try {
			System.out.println("Desea Salir?(1=si/2=no)> ");
			salir = dt.nextInt();
		} catch (Exception e) {
			System.out.println("Debe introducir solo numeros");
		}
		if ((salir!=1)&&(salir!=2)) {
			System.out.println("Esta no es una opcion valida");
		}}
	return a;
	}
}
