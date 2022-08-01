import java.util.Scanner;
public class Matematicas {
int a,b,c,t,xn, salir=2;
String x,z;	
public int Mayor() throws InterruptedException{
Scanner dt= new Scanner(System.in);
while(salir!=1){
System.out.println("\nPrograma para determinar el mayor de tres numeros\n");
try {
	System.out.println("Ingrese el numero 1: ");
	a = dt.nextInt();
	System.out.println("Ingrese el numero 2: ");
	b = dt.nextInt();
	System.out.println("Ingrese el numero 3: ");
	c = dt.nextInt();
} catch (Exception e) {
	System.out.println("\nDebe introducir solo numeros enteros");
	System.out.println("Fin");
	Thread.sleep(3000);
	salir=1;
	continue;
}
if((a==b)&&(a==c)) {
	System.out.println("Los numeros son iguales, y su valor es "+a);
}else if((a==b)&&(a>c)){
	System.out.println("El mayor es "+a);
}else if ((a==c)&&(a>b)){
	System.out.println("El Mayor es "+a);
}else if((b==c)&&(b>a)){
	System.out.println("El mayor es "+b);
}
if ((a>b)&&(a>c)) {
	System.out.println("El Mayor es "+a);	
}else if((b>a)&&(b>c)) {
	System.out.println("El Mayor es "+b);
}else if((c>a)&&(c>b)) {
	System.out.println("El Mayor es "+c);}
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
return t;
}


public int Menor() throws InterruptedException {
	Scanner dt = new Scanner(System.in);
	while(salir!=1) {
	System.out.println("\nPrograma para determinar el menor de dos numeros\n");
	try {
		System.out.println("Ingrese el numero 1: ");
		a = dt.nextInt();
		System.out.println("Ingrese el numero 2: ");
		b = dt.nextInt();
	} catch (Exception e) {
		System.out.println("\nDebe introducir solo numeros enteros");
		System.out.println("Fin");
		Thread.sleep(3000);
		salir=1;
		continue;
	}
	if (a<b) {
		System.out.println("El menor es "+a);
	}else {
		System.out.println("El menor es "+b);
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
		Thread.sleep(3000);
	}}
	return t;
}

public int sumar() throws InterruptedException {
	Scanner dt = new Scanner(System.in);
	while(salir!=1) {
	System.out.println("\nPrograma para determinar el resultado de la suma entre dos numeros\n");
	try {
		System.out.println("Ingrese el numero 1: ");
		a = dt.nextInt();
		System.out.println("Ingrese el numero 2: ");
		b = dt.nextInt();
	} catch (Exception e) {
		System.out.println("\nDebe introducir solo numeros enteros");
		System.out.println("Fin");
		Thread.sleep(3000);
		salir=1;
		continue;
	}
	c=a+b;
	System.out.println("La suma entre "+a+" y "+b+" es igual a "+ c);
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
	return t;
}
public int restar() throws InterruptedException {
	Scanner dt = new Scanner(System.in);
	System.out.println("\nPrograma para determinar el resultado de la resta entre dos numeros\n");
	while(salir!=1) {
	try {
		System.out.println("Ingrese el numero 1: ");
		a = dt.nextInt();
		System.out.println("Ingrese el numero 2: ");
		b = dt.nextInt();
	} catch (Exception e) {
		System.out.println("\nDebe introducir solo numeros enteros");
		System.out.println("Fin");
		Thread.sleep(3000);
		salir=1;continue;
	}
	c=a-b;
	System.out.println("La resta entre "+a+" y "+b+" es igual a "+ c);
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
	}return t;
}
	
public int multiplicar() throws InterruptedException {
	Scanner dt = new Scanner(System.in);
	while(salir!=1){
	System.out.println("\nPrograma para determinar el resultado de la multiplicacion entre dos numeros \n");
	try {
		System.out.println("Ingrese el numero 1: ");
		a = dt.nextInt();
		System.out.println("Ingrese el numero 2: ");
		b = dt.nextInt();
	} catch (Exception e) {
		System.out.println("\nDebe introducir solo numeros enteros");
		System.out.println("Fin");
		Thread.sleep(3000);
		salir=1;continue;
	}
	c=a*b;
	System.out.println("La multiplicacion entre "+a+" y "+b+" es igual a "+ c);
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
	}return t;
}
public int dividir() throws InterruptedException {
	Scanner dt = new Scanner(System.in);
	System.out.println("\nPrograma para determinar el resultado de la divicion entre dos numeros\n");
	while(salir!=1) {
	try {
		System.out.println("Ingrese el numero 1: ");
		a = dt.nextInt();
		System.out.println("Ingrese el numero 2: ");
		b = dt.nextInt();
	} catch (Exception e) {
		System.out.println("\nDebe introducir solo numeros enteros");
		System.out.println("Fin");
		Thread.sleep(3000);
		salir=1;continue;
	}
	c=a/b;
	System.out.println("La divicion de "+a+" entre "+b+" es igual a "+ c);
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
	return t;
}

public int fibonacci() throws InterruptedException {
	Scanner dt = new Scanner(System.in);
	while(salir!=1) {
	System.out.println("\nPrograma para determinar la Serie Fibonacci\n");
	xn=1; c=1; b=0;
	try {
		System.out.println("Ingrese el numero de elementos: ");
		a = dt.nextInt();
	} catch (Exception e) {
		System.out.println("\nDebe introducir solo numeros enteros");
		System.out.println("Fin");
		Thread.sleep(3000);
		salir=1;continue;
	}
	for (int i = 0; i<=a; i++) {
		xn=c+b;
		System.out.print(xn+" ");
		c=b;
		b=xn;
	}
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
	return t;
}
public int tabla() throws InterruptedException {
	Scanner dt = new Scanner(System.in);
	while(salir!=1) {
	System.out.println("\nPrograma para hacer una tabla Ascendente\n");
    try {
		System.out.println("Ingrese el numero de la tabla: ");
		a = dt.nextInt();
	} catch (Exception e) {
		System.out.println("\nDebe introducir solo numeros enteros");
		System.out.println("Fin");
		Thread.sleep(3000);
		salir=1;continue;
	}
	for (int i = 1; i<=12; i++) {
			System.out.println(a+"X"+i+"="+(a*i));
		}
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
return a;
}
}	