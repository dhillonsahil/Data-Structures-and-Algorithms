package Week_3;
import java.util.Scanner;

public class FibonacciNumber {
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       System.out.println("Enter a number : ");
       int n = scan.nextInt();
       int result = fib(n);
       System.out.println("Fibonacci number at "+n+" index is "+result);
       scan.close();
    }
    public static int fib(int n){
        if(n==0 || n==1){
            return n;
        }else {
            return fib(n-1)+fib(n-2);
        }
    }
}
