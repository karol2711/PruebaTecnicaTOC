package pruebaTecnicaToc;

import java.util.Scanner;

public class FibonacciSeries {
	
	
	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número M: ");
        int M = scanner.nextInt();
        
        int a = 0, b = 1;
        System.out.print("Los primeros " + M + " números de Fibonacci son: ");
        for (int i = 1; i <= M; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
    }
}