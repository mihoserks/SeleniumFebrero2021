package javabasics;

import javax.swing.JOptionPane;

public class Operaciones {
 /**
  * 1) Declarar dos variables numericas ingresando el valor por 
  * el teclado, muestra por consola la suma, resta multiplicacion
  * division.
  * 
  * **/
	
	
	public static void main(String[] args) {
		double numero1 = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el numero 1"));
		double numero2 = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el numero 2"));
		
		//Suma
		System.out.println("La suma es: "+ (numero1+numero2));
		JOptionPane.showMessageDialog(null, "La suma es: "+ (numero1+numero2));
		//resta
		System.out.println("La resta es: "+ (numero1-numero2));
		JOptionPane.showMessageDialog(null, "La resta es: "+ (numero1-numero2));
		//multiplicacion
		System.out.println("La multiplicacion es: "+ (numero1*numero2));
		JOptionPane.showMessageDialog(null, "La multiplicacion es: "+ (numero1*numero2));
		//divicion
		System.out.println("La division es: "+ (numero1/numero2));
		JOptionPane.showMessageDialog(null, "La division es: "+ (numero1/numero2));
		
	}
	
	
	
}//cierra clase
