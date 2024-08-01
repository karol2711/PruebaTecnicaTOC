package pruebaTecnicaToc;

import java.util.Scanner;

public class FibonacciPosicion {

	public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Ingrese la posición N: ");
	        int N = scanner.nextInt();
	        
	        if (N == 0) {
	            System.out.println("El número de Fibonacci en la posición 0 es: 0");
	        } else if (N == 1) {
	            System.out.println("El número de Fibonacci en la posición 1 es: 1");
	        } else {
	            int a = 0, b = 1;
	            for (int i = 2; i <= N; i++) {
	                int next = a + b;
	                a = b;
	                b = next;
	            }
	            System.out.println("El número de Fibonacci en la posición " + N + " es: " + b);
	        }
	    }
}