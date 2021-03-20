package javabasics;

import javax.swing.JOptionPane;

public class AreaCirculo {
	/**
	 * Calcular el area de un circulo (pi*R2) ingresa el radio del circulo por telcado
	 * **/
	public static void main(String[] args) {
		double radio = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el Radio"));
		
		double area = Math.PI*Math.pow(radio, 2);
		
		System.out.println("El area del circulo  es: " + area);

	}

}
