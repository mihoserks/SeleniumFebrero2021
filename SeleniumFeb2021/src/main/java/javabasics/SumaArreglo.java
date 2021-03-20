package javabasics;

public class SumaArreglo {

	public static void main(String[] args) {
		// Crear nuestro Arreglo de 100 indices
		int [] numeros = new int[100];
		int suma = 0;
		
		//Recorrer el arreglo asingar numero y sumar
		for(int i= 0; i<numeros.length; i++) {
			numeros[i]=i+1;
			suma+=numeros[i];
			//suma = suma + numeros[i];
		}
		
		//mostramos el resultado de la suma
		System.out.println(suma);
		

	}

}
