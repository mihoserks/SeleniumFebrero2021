package javabasics;

public class ArregloInvertirOrden {
	/**
	 * Dado un arreglo de 5 indicies con los valores 1,2,3,4,5
	 * guardar los valores en otro arreglo y mostrarlo invertido el orden
	 * **/
	public static void main(String[] args) {
		// Creamos arreglo con 5 indicies
		int[] arreglo1 = { 1, 2, 3, 4, 5 };//0 1 2 3 4
		int[] arreglo2 = new int[arreglo1.length]; // {5,4,3,2,1};
	
	//  for (int i= 0,j=0,K=0; i<numeros.length; i++) {
		for (int i = (arreglo1.length-1), j = 0; i >= 0; i--, j++) {
			arreglo2[j] = arreglo1[i];
			System.out.println(arreglo2[j]);
			
		} // arreglo dos indice 0 = 5
		 // arreglo dos indice 1 = 4
		

	}// main

}//class
