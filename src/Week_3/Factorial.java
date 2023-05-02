package Week_3;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int n = scan.nextInt();
        long result = fact(n);
        System.out.println("Factorial is : "+result);
        scan.close();
    }
    public static long fact(int n){
        if(n==1){
            return 1;
        }
        return n*fact(n-1);
    }
}
