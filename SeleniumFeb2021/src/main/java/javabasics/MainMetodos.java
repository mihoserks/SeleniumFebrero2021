package javabasics;

public class MainMetodos {

	public static void main(String[] args) {
		//
		Metodos objecto = new Metodos(10,20);
		
		
		objecto.sumatoria();
		objecto.mensajeBienvenida("Hola Mundo");
		
		Metodos constructorAutomatico = new Metodos();
		
		constructorAutomatico.mensajeBienvenida("Hola Mundo");
		
		
//		System.out.println(constructorAutomatico.sumatoria());
//		constructorAutomatico.mensajeBienvenida("Test");
//		objecto.mensajeBienvenida("Test");
//		String name = objecto.concatenarNombres("Sergio","Ramones");
//		System.out.println(name);
		
	}

}
