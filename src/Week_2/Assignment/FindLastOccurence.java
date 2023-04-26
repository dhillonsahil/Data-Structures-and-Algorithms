package Week_2.Assignment;

import java.util.*;
public class FindLastOccurence {
    public static void main(String[] args) {
        int arr[ ] = {1,1,1,2,3,4,4,5,6,6,6,6};
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number to find last occurence : ");
        int target = scan.nextInt();
        int result=lastOccurence(arr , target);
        System.out.println(result);
        scan.close();

    }
    public static int lastOccurence(int arr[] , int target){
        int low= 0,high=arr.length-1;int result=-1;
        while(low<=high){
            int mid_idx = low + (high-low)/2;
            if(arr[mid_idx]==target){
                result=mid_idx;
                low=mid_idx+1;
            }else if(arr[mid_idx]<target){
                low = mid_idx+1;
            }else if(arr[mid_idx]>target){
                high=mid_idx-1;
            }
        }
        return result;
    }
}
