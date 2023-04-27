package Week_2;

import java.util.Scanner;

public class SquareCheck {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        boolean result = checkSquare(num);
        System.out.println(result);
        scan.close();
    }
    public static boolean checkSquare(int num){
        boolean flag = false;
        int low = 0 , high = num;
        while(low<=high){
            int mid = (low + high)/2;
            int sq =mid*mid;
            if(sq==num){
                return true;
            }else if(sq<num){
                low=mid+1;
            }else if(sq>num){
                high=mid-1;
            }
        }
        return flag;
    }
}
