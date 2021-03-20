package poo;

import java.util.Scanner;

public class TestCuenta {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		String nombre;
		String numero;
		double tipo;
		double importe;
		// vamos a crear un objecto de nuestra clase Cuenta usando el constructor sin parametros.
		Cuenta cuenta1 = new Cuenta();
		//asignar valor a las variables por telcado
		System.out.println("Ingresa Nombre: ");
		nombre = teclado.next();
		System.out.println("Ingresa numero de cuenta: ");
		numero = teclado.next();
		System.out.println("Tipo de interes: ");
		tipo = teclado.nextDouble();
		System.out.println("Saldo");
		importe = teclado.nextDouble();
		teclado.close();
		
		
		//asignar valores con nuestros metodos set
		cuenta1.setNombre(nombre);
		cuenta1.setNumeroCuenta(numero);
		cuenta1.setTipoInteres(tipo);
		cuenta1.setSaldo(importe);
		System.out.println(cuenta1.getNombre());
		
		//es utilizar nuestro constructor con parametros y asignarlos
		Cuenta cuenta2 = new Cuenta("Sergio Ramones","12346567",12.3,5000);
		System.out.println(cuenta2.getNombre());
		
		//utilizar el constructor que recibe un objeto
		Cuenta cuenta3 = new Cuenta(cuenta1);
		System.out.println("Cuenta 1 saldo: " + cuenta1.getSaldo());
		System.out.println("Cuenta 3 saldo: " + cuenta3.getSaldo());
		//ingreso en la cuenta 1
		cuenta1.ingreso(4000);
		System.out.println("///////////////////");
		System.out.println("Cuenta 1 saldo despues del ingreso: " + cuenta1.getSaldo());
		System.out.println("Cuenta 3 saldo: " + cuenta3.getSaldo());
		
		//mostrar datos de la cuenta2
		System.out.println("//////////////// Datos de la cuenta 2/////////////////////");
		System.out.println("Nombre del titular: " + cuenta2.getNombre());
		System.out.println("El número de cuenta: " + cuenta2.getNumeroCuenta());
		System.out.println("Tipo de interés: " + cuenta2.getTipoInteres());
		System.out.println("Saldo: " + cuenta2.getSaldo());
		
		// mostrar datos de la cuenta3
		System.out.println("//////////////// Datos de la cuenta 3/////////////////////");
		System.out.println("Nombre del titular: " + cuenta3.getNombre());
		System.out.println("El número de cuenta: " + cuenta3.getNumeroCuenta());
		System.out.println("Tipo de interés: " + cuenta3.getTipoInteres());
		System.out.println("Saldo: " + cuenta3.getSaldo());
		
		//Realizar una trasferencia de 2000 de la cuenta3 a la cuenta2
		System.out.println("Hacer trasferencia entre cuentas");
		cuenta3.trasferencia(cuenta2, 2000);
		
		//mostrar datos de la cuenta2
		System.out.println("//////////////// Datos de la cuenta 2/////////////////////");
		System.out.println("Nombre del titular: " + cuenta2.getNombre());
		System.out.println("El número de cuenta: " + cuenta2.getNumeroCuenta());
		System.out.println("Tipo de interés: " + cuenta2.getTipoInteres());
		System.out.println("Saldo: " + cuenta2.getSaldo());
		
		// mostrar datos de la cuenta3
		System.out.println("//////////////// Datos de la cuenta 3/////////////////////");
		System.out.println("Nombre del titular: " + cuenta3.getNombre());
		System.out.println("El número de cuenta: " + cuenta3.getNumeroCuenta());
		System.out.println("Tipo de interés: " + cuenta3.getTipoInteres());
		System.out.println("Saldo: " + cuenta3.getSaldo());
	
	
	}//main

}//class
