package Week_2;
import java.util.*;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Binary Number");
        int x= sc.nextInt();
        int pow = 1;
        int decimalNumber=0;
        while(x>0){
            int remainder= x%2;
            decimalNumber +=remainder*pow;
            pow*=2;
            x/=10;
        }
        System.out.println(decimalNumber);
        sc.close();
    }
}
