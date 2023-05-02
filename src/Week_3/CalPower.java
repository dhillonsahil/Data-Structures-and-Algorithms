package Week_3;
import java.util.Scanner;

public class CalPower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        float num = sc.nextFloat();
        System.out.print("Enter power : ");
        int pow = sc.nextInt();
        double result= myPow(num,pow);
        System.out.println("The result is : "+ result);
        sc.close();
    }
    public static double myPow(Float x, int n){
        if(n==1){
            return x;
        }else if(n ==0 ){
            return 1;
        }else if(n <0){
            return 1 / myPow(x,-n);
        }
        double result = myPow(x,n/2);
        if(n%2==0){
            return (result*result);
        }else {
            return result*result*x;
        }
    }
}


// if(n==1){
//     return x;
// }else if(n ==0 ){
//     return 1;
// }else if(n <0){
//     double result = 1 / myPow(x , -n/2);
//     if(-n%2==0){
//         return result*result;
//     }else{
//         return result*result*(1/x);
//     }
    
// }
// double result = myPow(x,n/2);
// if(n%2==0){
//     return result*result;
// }else {
//     return result*result*x;
// }