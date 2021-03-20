package javaEjercicios;

public class ArregloDeStrings {

	public static void main(String[] args) {
		// Crear nuestro Arreglo de 100 indices
				String [] numeros  = new String[5];
				
				
				//Recorrer el arreglo asingar texto y mostrar
				for(int i= 0; i<=numeros.length; i++) {
					numeros[i]="Texto " + i;
					System.out.println(numeros[i]);
				}
				
				

	}

}
