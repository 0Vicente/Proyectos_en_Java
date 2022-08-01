
import java.util.Scanner;

public class Calculo_Indice_Corporal {
public static void main (String [] args) {
Float Altura,Peso, a;		
Scanner Dt = new Scanner(System.in);
   System.out.println("Ingresa tu Altura (Metros):");
  Altura = Dt.nextFloat();
  System.out.println("Ingresa tu Peso (Kilogramos):");
  Peso = Dt.nextFloat();
 
  a= Peso/(Altura*Altura);
  if (a<18.5) {
 System.out.println("Su Indice De Masa Corporal es: " + a);
 System.out.println("Usted Deberia Pensar en Comer un Poco Mas");
  }
  if ((a>=18.5)&&(a<=24.9)){
	  System.out.println("Su Indice De Masa Corporal es: " + a);
	  System.out.println("Usted Esta En Excelente Forma");
	   }
  if ((a>=25)&&(a<=29.9)){
	  System.out.println("Su Indice De Masa Corporal es: " + a);
	  System.out.println("Usted Debe Darle Menos a Barriga y Mas a Pecho y Espalda");
	   }
  if (a>=25){
	  System.out.println("Su Indice De Masa Corporal es: " + a);
	  System.out.println("Usted Debe Parar Con la Cuchara Ahora que hay Tiempo, Usted es una Persona Obesa");
	   }  
}
}
