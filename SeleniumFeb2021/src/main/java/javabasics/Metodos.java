package javabasics;

public class Metodos {
	int numero1, numero2;
	
	
	public Metodos() {
		
	}
	public Metodos(String n) {
		
	}
	
	public Metodos(int numero1, int numero2) {
		this.numero1=numero1;
		this.numero2=numero2;
	}
	
	
	
	public void mensajeBienvenida (String mensaje) {
		System.out.println(mensaje);
	}
	
	public int sumatoria() {
		return numero1+numero2;
	}
	
	public String mostrarNombre(String nombre) {
		System.out.println(nombre);
		return nombre;
	}
	
	public String concatenarNombres(String nombre, String apellido) {
		System.out.println(nombre);
		return nombre +" "+ apellido;
	}
	
	
	
}
