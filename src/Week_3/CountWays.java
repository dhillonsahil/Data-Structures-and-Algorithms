package Week_3;
import java.util.Scanner;

public class CountWays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of stairs : ");
        int n = scan.nextInt();
        int result=count(n);
        System.out.println("No of ways to walk on Stairs are : "+result);
        scan.close();
    }
    public static int count(int n){
        return countWays(n+1);
    }
    public static int countWays(int n){
        if(n<=1){
            return n;
        }else {
            return countWays(n-1)+countWays(n-2);
        }
    }
}
