package Week_3;
import java.util.Scanner;

public class FibonaaciSeries {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of n  to print upto n : ");
        int n = sc.nextInt();
        System.out.println("Series is : ");
        fiboSeries(n, 0, 1, 0);
        sc.close();
        
        
    }
    public static void fiboSeries(int n, int f1, int f2, int counter){
        if(counter==n){
            return;
        }
        int f3= f1+f2;
        System.out.println(f1);
        fiboSeries(n, f2, f3, counter+=1);
    }
}
