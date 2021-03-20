package javabasics;

import java.util.Scanner;

public class CompararCadenas {

	public static void main(String[] args) {
	
		//Creamos Scaner para leer plabras
		Scanner leer = new Scanner(System.in);
		
		System.out.println("Escribe la primera Palabra");
		String palabra1 = leer.next();
		
		
		System.out.println("Escribe la segunda Palabra");
		String palabra2 = leer.next();
		leer.close();
		
		if (palabra1.equals(palabra2)) {
			System.out.println("Son iguales");
		}else {
			System.out.println("No son iguales");
		}
		
		
		String texto="Un 45 texto 6546456";
		System.out.println("Texto oringinal: " +texto);
		String textoSinespacios = texto.replace(" ", "");
		
		System.out.println("El texto sin espacios: "+ textoSinespacios);
		
		System.out.println("El texto tiene una longitud de [ "+texto.length()+" ] caracteres");
	
		
		String textoSinNumeros = texto.replaceAll("\\d", "");
		System.out.println("El texto sin numeros: " + textoSinNumeros);
		
		
		
		
		

	}//fin de main

}//fin de la clase
