package javaEjercicios;

import java.util.Scanner;


public class Promedio {

	public static void main(String[] args) {
		int cantidadDeNotas;
		int suma = 0;
		int calificacion;
		double promedio;
		
		Scanner teclado = new Scanner(System.in);
		// 5 Calificaciones
		System.out.println("Cantidad de calificaciones a registrar:");
		cantidadDeNotas = teclado.nextInt();

		for (int i = 1; i <= cantidadDeNotas; i++) {

			System.out.println("Elemento [" + i + "]=");
			calificacion = teclado.nextInt();
				
			while (calificacion < 0 || calificacion > 100) {
				
				System.out.println("La calificacion debe ser entre un rango de 0 a 100");
				System.out.println("La calificacion que ingresaste es: [ " + calificacion + " ]");
				calificacion = teclado.nextInt();
				
			}//end while
		   //suma = suma + calificacion;
			suma += calificacion;

		}//end for
		teclado.close();
		promedio = suma / cantidadDeNotas;

		if (promedio <= 69) {
			System.out.println("El Promedio es: " + promedio + " estas reprobado");
		}
		if (promedio > 69 && promedio < 90) {
			System.out.println("El Promedio es: " + promedio + " estas aprobado ");
		}
		if (promedio >= 90 && promedio <= 100) {
			System.out.println("El Promedio es: " + promedio + " estas aprobado excelencia");
		}
		
	
	}// main

}// class
