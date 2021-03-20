package javabasics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListasDeEnteros {

	public static void main(String[] args) {
		// Declarar nuestra lista de Enteros
		/**
		 * Como sacar el Numero mayor y el numero menos de la lista
		 * **/
		
		List<Integer> listaDeNumeros = new ArrayList<>();
		listaDeNumeros.add(2);
		listaDeNumeros.add(2);
		listaDeNumeros.add(20);
		listaDeNumeros.add(3);
		listaDeNumeros.add(20);
		listaDeNumeros.add(4);
		listaDeNumeros.add(5);
		listaDeNumeros.add(9);
		listaDeNumeros.add(20);
		listaDeNumeros.add(20);
		listaDeNumeros.add(20);
		listaDeNumeros.add(20);
		
		//Imprime todos los elementos de nuestra lista
		System.out.println(listaDeNumeros);
		//ordena la lista de menor a mayor
		Collections.sort(listaDeNumeros);
		System.out.println(listaDeNumeros);
		//Ordenamos y invertimos el orden de nuestra lista
		Collections.sort(listaDeNumeros, Collections.reverseOrder());
		//Imprime todos los elementos de nuestra lista
		System.out.println(listaDeNumeros);

		
		//quitar elementos repetidos en la lista
		Object last = null;

		int numCount = 0;
		Iterator<Integer> i = listaDeNumeros.iterator();

		while (i.hasNext()) {
			Object temp = i.next();
			if (temp.equals(last)) {
				i.remove();
				numCount++;
			} else {
				last = temp;
			} // fin else

		} // fin del while
			
		 System.out.println(listaDeNumeros);
		 System.out.println("El numero estaba repetido : " + numCount);
		 System.out.println("El numero mayor de la lista es: " + Collections.max(listaDeNumeros));
		 System.out.println("El numero menor de la lista es: " + Collections.min(listaDeNumeros));
		 Collections.reverse(listaDeNumeros);
		 System.out.println(listaDeNumeros);
		 
	}//main

}//class
