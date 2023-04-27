package Week_2;

import java.util.*;

public class CheckOddEven {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number");
        int x = scan.nextInt();
        int binaryNum = 0;
        int pow = 1;
        while (x > 0) {
            int remainder = x % 2;
            binaryNum += remainder * pow;
            pow *= 10;
            x /= 2;
        }
        if((binaryNum & 1) == 0){
            System.out.println("Even number");
        }else{
            System.out.println("Odd number");
        }
        scan.close();
    }
}