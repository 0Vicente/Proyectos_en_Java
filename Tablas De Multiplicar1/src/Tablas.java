
public class Tablas {
public static void main (String [] args) {
	//Ejemplos con bucles
    
    int x=1,n=1;
    
    System.out.println("Tabla con For-For Ascendente");
    System.out.println();
    for (int b=1; b<=12; b++)
    {
        for (int c = 1; c<=12; c++)
        {
            System.out.println(b + " X " + c + " = " + (b * c));
        }
        System.out.println();
    }
    
    System.out.println("Tabla con While-While Ascendente");
    System.out.println();
    while (x<=12)
    {
        n=1;
        while(n<=12){
            System.out.println(x + " X " + n + " = " + (x * n));
            n++;
        }
    System.out.println();
    x++;    
    }
    
    
    
    System.out.println("Tabla con Do While-Do While Ascendente");
    System.out.println();
    x=1;
    do{
        n=1;
        do
        {
            System.out.println(x + " X " + n + " = " + (x * n));
            n++;
        }while (n<=12);
        
    System.out.println();
    x++;
        
    }while (x<=12);

   	System.out.println("Tabla con While-For Ascendente");
    System.out.println();
   	 
 int w=1;
    while(w<13){
   		 for (int t =1;t<=12;t++){
   			 System.out.println(w +" X "+ t +" = "+ w*t);	 
   		 }
   		 w++;
   		 System.out.println();
}
	System.out.println("Tabla con Do While-For Ascendente");
    System.out.println();
    int m=1;
    do {
    	for (int b=1; b<=12; b++) {
    	System.out.println(m + " X " + b + " = " + (b * m));
    	} System.out.println();
        m++;
    } while (m<13); 
   
    System.out.println("Tabla con For-For Descendente");
    System.out.println();
    for (int b=1; b<=12; b++)
    {
        for (int c = 12; c>=1; c--)
        {
            System.out.println(b + " X " + c + " = " + (b * c));
        }
        System.out.println();
    }
    
    System.out.println("Tabla con While-While Descendente");
    System.out.println();
    
  x=1;
    while (x<=12)
    {
        n=12;
        while(n>=1){
            System.out.println(x + " X " + n + " = " + (x * n));
            n--;
        }
    System.out.println();
    x++;    
    }
    
    System.out.println("Tabla con Do While-Do While Descendente");
    System.out.println();
    x=1;
    do{
        n=12;
        do
        {
            System.out.println(x + " X " + n + " = " + (x * n));
            n--;
        }while (n>=1);
        
    System.out.println();
    x++;
        
    }while (x<=12);

    System.out.println("Tabla con While-For Descendente");
    System.out.println();
    w=1;
    while(w<13){
   		 for (int t =12;t>=1;t--){
   			 System.out.println(w +" X "+ t +" = "+ w*t);	 
   		 }
   		 w++;
   		 System.out.println();
}
    System.out.println("Tabla con Do While-For Descendente");
    System.out.println(); 
    m=1;
    do {
    	for (int b=12; b>=1; b--) {
    	System.out.println(m + " X " + b + " = " + (b * m));
    	} System.out.println();
        m++;
    } while (m<13);
    
    System.out.println("Tabla con For-For sin 6 ");
    System.out.println(); 
 
    for (int b=1; b<=12; b++){
    	if(b!=6) {
        for (int c = 1; c<=12; c++){
        	if (c!=6) {
            System.out.println(b + " X " + c + " = " + (b * c));
        }}
        System.out.println();
    }}

    System.out.println("Tabla con For-For y Saltar el 6 ");
    System.out.println(); 
 
    for (int b=1; b<=12; b++){
        for (int c = 1; c<=12; c++){
        	if (c!=6) {
            System.out.println(b + " X " + c + " = " + (b * c));
        }}
        System.out.println();
    }
    
    System.out.println("Tabla con For-For pausar en todos los 6");
    System.out.println(); 
 int s=1;
    for (int b=1; b<=12; b++){
    	if(b==6){
    		break;
    		}else {
    	
        for (int c = 1; c<=12; c++){
        	if (c==6) {
        		break;
        		}else {
        			s=b*c;
        			if (s!=6) {
            System.out.println(b + " X " + c + " = " + s);
        }else{
        	break;
        			}} 
        }
        System.out.println();
    }}
    
    System.out.println("Tabla con For-For pausar en la tabla del 6 y el numero 6");
    System.out.println(); 
 s=1;
    for (int b=1; b<=12; b++){
    	if(b==6){
    		break;
    		}else {
    	
        for (int c = 1; c<=12; c++){
        	if (c==6) {
        		break;
        		}else {
        			s=b*c;
        			if (s!=6) {
            System.out.println(b + " X " + c + " = " + s);
        }}} 
        }
        System.out.println();
    }
   
    System.out.println("Tabla con For-For pausar en el numero 6");
    System.out.println(); 
 s=1;
    for (int b=1; b<=12; b++){
    	for (int c = 1; c<=12; c++){
        	if (c==6) {
        		break;
        		}else {
        			s=b*c;
        			if (s!=6) {
            System.out.println(b + " X " + c + " = " + s);
        }}} 
        System.out.println();
       }

    
    
}
}