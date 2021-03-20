package javabasics;

import javax.swing.JOptionPane;

public class Arreglo {

	public static void main(String[] args) {


		int numeros[] = new int[20];
		
		rellenarListaDeNumeros(numeros);
		mostrarArreglo(numeros);
		//5, 6 , 7 , 8 ,9

	}//fin del main
	
	//indice 0 tiene el valor de 5
	
	
	
	public static void rellenarListaDeNumeros(int arreglo[]) {
		
		for(int i=0; i<arreglo.length;i++) {
			String texto = JOptionPane.showInputDialog("Ingresa un numero");
			arreglo[i] = Integer.parseInt(texto);
		}
	}//
	
	public static void mostrarArreglo(int arreglo[]) {
		for(int i=0 ; i<arreglo.length; i++) {
			System.out.println("El indice [ "+i+"] "+ " Esta el valor de [ "+arreglo[i]+" ]");
		}
	}

}
