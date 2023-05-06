package Week_3;

import java.util.*;
import java.math.*;

public class CalPowerOptimized {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENter the value of a and b ");
        BigInteger a = sc.nextBigInteger();
        int b= sc.nextInt();
        BigInteger result=powerFind(a,b);
        System.out.println("Power of an element is : "+result);
        sc.close();
    }
    public static BigInteger powerFind(BigInteger a,int b)
    {
        // base case condition
        if(b==1){
            return a;
        }
        else {
        BigInteger result= powerFind(a, b/2);
        BigInteger fR= result.multiply(result);
        if(b%2==0){
            return fR;
        }else {
            return fR.multiply(a);
        }
    }
    }
}
