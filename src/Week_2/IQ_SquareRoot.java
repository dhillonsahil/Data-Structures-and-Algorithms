package Week_2;
import java.util.*;

// Approach Modified Binary Search Time: O(logn) , space : O(1)
public class IQ_SquareRoot {
    public static void main(String []args){
        Scanner sc= new Scanner(System.in);
        
        System.out.println("Enter a number to check SquareRoot : ");
        int x = sc.nextInt();
        int result = squareRoot(x);
        System.out.println(" square root is : "+result);
        sc.close();
    }
    public static int squareRoot(int num){
        int low=0, high=num,result=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            long sq=mid*mid;
            if(sq==num){
                return mid;
            }
            else if(sq<num){
                // store the floor value in case perfect root don't exist
                result=mid;
                low=mid+1;
            }else if(sq>num){
                high=mid-1;
            }
        }
        return result;
    }
}
