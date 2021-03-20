package javabasics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ListaDeStrings {

	public static void main(String[] args) {
		// una lista de strings remover iguales e invertir orden
		List<String> listaDeNombres = new ArrayList<>();
		listaDeNombres.add("A 1");
		listaDeNombres.add("Z 2");
		listaDeNombres.add("J 3");
		listaDeNombres.add("Persona 4");
		listaDeNombres.add("Persona 5");
		listaDeNombres.add("Persona 5");
		listaDeNombres.add("Persona 5");
		listaDeNombres.add("Persona 5");
		
		//imprimir lista tal cual esta
		System.out.println(listaDeNombres);
		Collections.sort(listaDeNombres);
		System.out.println(listaDeNombres);
		Collections.sort(listaDeNombres, Collections.reverseOrder());
		System.out.println(listaDeNombres);
		
		//Eleminar los elementos repetidos de la lista de strings
		List<String> nombresSinRepetir = listaDeNombres
				.stream()
				.distinct().
				collect(Collectors.toList());
			System.out.println(nombresSinRepetir);
			Collections.reverse(nombresSinRepetir);
			System.out.println(nombresSinRepetir);
	}//main

}//class
