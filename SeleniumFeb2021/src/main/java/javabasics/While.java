package javabasics;

public class While {

	public static void main(String[] args) {
		
		
		int numero = 1;
		
		while(numero<=100) {
			System.out.println(numero);
			
			if(numero==34) {
				break;
			}
				numero++;
			
		}
		
		for(int num=50 ; num<=100; num++) {
			System.out.println(num);
		}

	}

}
