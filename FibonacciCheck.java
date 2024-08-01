package pruebaTecnicaToc;


import java.util.Scanner;

public class FibonacciCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número: ");
        int num = scanner.nextInt();
        
        if (isFibonacci(num)) {
            System.out.println(num + " es un número de Fibonacci.");
        } else {
            System.out.println(num + " no es un número de Fibonacci.");
        }
    }
    
    public static boolean isFibonacci(int num) {
        int a = 0, b = 1;
        while (b < num) {
            int next = a + b;
            a = b;
            b = next;
        }
        return b == num || num == 0;
    }
}